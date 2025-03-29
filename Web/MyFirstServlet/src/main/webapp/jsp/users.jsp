<%@ page import="mx.uv.fiee.iinf.paradigmas.web.models.User" %>
<%@ page import="java.util.LinkedList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
    <link rel="stylesheet" href="styles/users.css" />
  </head>
  <body>
    <%
        LinkedList<User> userList = (LinkedList<User>) request.getAttribute("userList");
    %>

    <h2>Users list</h2>
    <div>
        <table class="styled-table">
            <theader>
                <tr>
                    <th>Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Address</th>
                    <th colspan="2">Actions</th>
                </tr>
            </theader>
            <tbody>
                <%
                    for (User u: userList) {
                        out.println("<tr class=\"active-row\">");
                        out.println("<td>" + u.getName() + "</td>");
                        out.println("<td>" + u.getLastName() + "</td>");
                        out.println("<td>" + u.getAge() + "</td>");
                        out.println("<td>" + u.getAddress() + "</td>");
                        out.println("<td><a href=\"formEditServlet?id=" + u.getId() + "\">Edit</a></td>");
                        out.println("<td>Delete</td>");
                        out.println("<tr>");
                    }
                %>
            </tbody>
        <table>
    </div>

  </body>
</html>
