<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap" %>
<html>
  <head>
    <title>Vista para el servlet MyAwesome servlet</title>
  </head>
  <body>
    <%
        String title = "Headers received in request";
        HashMap<String, String> headers = (HashMap<String, String>) request.getAttribute("headers");
    %>

    <h1 style="font-family:helvetica, verdana, sans-serif;font-size:16pt;"><%=title %></h1>
    <ul class="style:font-family:inherit; font-size:14pt;">
        <%
            for (var entry: headers.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                out.println("<li style=\"font-family:monospace;font-size:14pt\">" + value + "</li>");
            }
        %>
    </ul>
  </body>
</html>
