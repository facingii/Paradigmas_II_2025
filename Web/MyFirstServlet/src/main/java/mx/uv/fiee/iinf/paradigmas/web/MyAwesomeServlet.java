package mx.uv.fiee.iinf.paradigmas.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet (name = "MyAwesomeServlet", urlPatterns = "/awesome")
public class MyAwesomeServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().write("Dummy response");

        var headerDict = new HashMap<String, String>();
        var headerNames = req.getHeaderNames ();

        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement ();
            String value = req.getHeader (header);

            headerDict.put (header, value);
        }

        req.setAttribute ("headers", headerDict);
        RequestDispatcher rd = req.getRequestDispatcher ("jsp/headers.jsp");

        if (rd != null) {
            rd.forward (req, resp);
        } else {
            resp.sendError (500);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Dummy post");
    }
}
