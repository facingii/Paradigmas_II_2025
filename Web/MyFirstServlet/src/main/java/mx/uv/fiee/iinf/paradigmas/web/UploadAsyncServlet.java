package mx.uv.fiee.iinf.paradigmas.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.CharBuffer;
import java.util.Collection;
import java.util.Enumeration;

@WebServlet(name = "UploadAsyncServlet", urlPatterns = "/uploadAsync")
@MultipartConfig
public class UploadAsyncServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /***
         * Composite form handler
         */
        request.setCharacterEncoding ("UTF-8");

        Enumeration<String> params = request.getParameterNames ();
        while (params.hasMoreElements ()) {
            String param = params.nextElement ();
            String value = request.getParameter (param);

            System.out.printf ("%s = %s %n", param, value);
        }

        System.out.println ("Now parts!");

        Collection<Part> parts = request.getParts ();
        for (Part part: parts) {
            System.out.println ("Part name: " + part.getName () + ", " + " Part size: " + part.getSize ());
        }

        /*InputStream in = request.getInputStream ();

        BufferedImage bi = ImageIO.read (in);
        BufferedImage thumb = new BufferedImage (100, 100, bi.getType ());

        Graphics2D g = thumb.createGraphics ();
        g.setComposite (AlphaComposite.Src);
        g.setRenderingHint (RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint (RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage (bi, 0, 0, 100, 100, null);

        response.setContentType ("image/jpg");
        ImageIO.write (thumb, "jpg", response.getOutputStream ());*/
    }

}