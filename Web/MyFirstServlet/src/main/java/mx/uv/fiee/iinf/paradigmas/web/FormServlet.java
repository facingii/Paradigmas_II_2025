package mx.uv.fiee.iinf.paradigmas.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.uv.fiee.iinf.paradigmas.web.dal.UsersContext;
import mx.uv.fiee.iinf.paradigmas.web.dal.UsersProvider;
import mx.uv.fiee.iinf.paradigmas.web.models.Avatar;
import mx.uv.fiee.iinf.paradigmas.web.models.User;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.UUID;

@WebServlet ("/formServlet")
@MultipartConfig
public class FormServlet extends HttpServlet {
    private static final String AVATARS_FOLDER = "avatars";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var name = req.getParameter ("name");
        var lastname = req.getParameter ("lastname");
        var age = Integer.parseInt (req.getParameter ("age"));
        var address = req.getParameter ("address");

        BufferedImage image = null;
        InputStream in = req.getPart("avatar").getInputStream();
        if (in != null) {
            image = ImageIO.read(in);
        }
        Avatar avatar = null;
        String webPath = getServletContext ().getRealPath("/WEB-INF");

        if (webPath != null && image != null) {
            String uuid = UUID.randomUUID ().toString ();

            String folderPath = String.format(webPath + File.separator + AVATARS_FOLDER);
            File folder = new File (folderPath);
            if (!folder.exists ()) {
                boolean result = folder.mkdir();
                if (!result) {
                    resp.sendError(500);
                }
            }

            String filename = String.format ("%s.jpg", uuid);
            String filepath = folderPath + File.separator + filename;
            FileOutputStream fos = new FileOutputStream (filepath);
            ImageIO.write (image, "jpg", fos);

            avatar = new Avatar ();
            avatar.setAvatarName (uuid);
            avatar.setAvatarPath (filepath);
        }

        var user = new User();
        user.setName (name);
        user.setLastName (lastname);
        user.setAge (age);
        user.setAddress (address);

        try {
            var username = getServletContext().getInitParameter ("username");
            var password = getServletContext().getInitParameter ("password");
            var url = getServletContext().getInitParameter ("connectionString");

            int avatar_id = UsersProvider.insertNewAvatar (username, password, url, avatar);
            user.setAvatarId (avatar_id);

            boolean result = UsersProvider.insertNewUser (username, password, url, user);
            if (result) {
                resp.getWriter().write ("User Added!");
                return;
            }
        } catch (SQLException e) {
            throw new RuntimeException (e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        resp.sendError(400);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var username = getServletContext().getInitParameter("username");
        var password = getServletContext().getInitParameter("password");
        var url = getServletContext().getInitParameter("connectionString");

        LinkedList<User> userList = null;
        try {
            userList = UsersProvider.getAllUsers (username, password, url);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/users.jsp");
        if (dispatcher != null) {
            req.setAttribute ("userList", userList);
            dispatcher.forward(req, resp);
        }

        resp.sendError(404);
    }

}
