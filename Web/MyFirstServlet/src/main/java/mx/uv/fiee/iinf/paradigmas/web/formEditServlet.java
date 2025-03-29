package mx.uv.fiee.iinf.paradigmas.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.uv.fiee.iinf.paradigmas.web.dal.UsersProvider;
import mx.uv.fiee.iinf.paradigmas.web.models.User;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/formEditServlet")
@MultipartConfig
public class formEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt (req.getParameter("id"));
        var username = getServletContext().getInitParameter("username");
        var password = getServletContext().getInitParameter("password");
        var url = getServletContext().getInitParameter("connectionString");

        try {
            var user = UsersProvider.getUser (username, password, url, id);
            var dispatcher = req.getRequestDispatcher ("jsp/formEdit.jsp");
            if (dispatcher != null) {
                req.setAttribute ("user", user);
                dispatcher.forward (req, resp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Updated!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var username = getServletContext().getInitParameter("username");
        var password = getServletContext().getInitParameter("password");
        var url = getServletContext().getInitParameter("connectionString");

        int id = Integer.parseInt (req.getParameter("idUser"));
        var name = req.getParameter ("name");
        var lastname = req.getParameter ("lastname");
        var age = Integer.parseInt (req.getParameter ("age"));
        var address = req.getParameter ("address");

        var user = new User();
        user.setName (name);
        user.setLastName (lastname);
        user.setAge (age);
        user.setAddress (address);

        try {
            UsersProvider.editUser(username, password, url, id, user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        resp.getWriter().write("User updated!");
    }
}
