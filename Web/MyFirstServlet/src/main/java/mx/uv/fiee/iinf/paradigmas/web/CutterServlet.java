package mx.uv.fiee.iinf.paradigmas.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "CutterServlet", urlPatterns = "/Cutter")
public class CutterServlet extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int x1 = Integer.parseInt (request.getParameter ("x1"));
        int y1 = Integer.parseInt (request.getParameter ("y1"));
        int x2 = Integer.parseInt (request.getParameter ("x2"));
        int y2 = Integer.parseInt (request.getParameter ("y2"));

        if (x1 > x2) {
            int foo = x1;
            x1 = x2;
            x2 = foo;
        }

        if (y1 > y2) {
            int bar = y1;
            y1 = y2;
            y2 = bar;
        }

        String webPath = getServletContext ().getRealPath (File.separator);
        File file = new File (webPath + File.separator + "images" + File.separator + "launch.jpg");

        BufferedImage bi = ImageIO.read (file);
        BufferedImage bi2 = bi.getSubimage (x1, y1, (x2 - x1), (y2 - y1));

        ByteArrayOutputStream bos = new ByteArrayOutputStream ();
        ImageIO.write (bi2, "jpg", bos);
        bos.flush ();

        bos.writeTo (response.getOutputStream ());
        bos.close ();
    }

}