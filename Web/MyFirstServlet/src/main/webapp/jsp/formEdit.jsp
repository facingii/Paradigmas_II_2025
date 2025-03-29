<%@ page import="mx.uv.fiee.iinf.paradigmas.web.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
  <head>
    <title>Title</title>
    <link rel="stylesheet" href="styles/form.css"
  </head>
  <body>
    <p>Register</p>

    <%
        User user = (User) request.getAttribute ("user");
    %>

    <div style="display:flex;justify-content:center">
    <form class=form action="formEditServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="idUser" id="idUser" value=<%=user.getId()%>>
            <label>Name</label>
            <input type="text" name="name" id="name" value=<%=user.getName()%> />
            <label>Lastname</label>
            <input type="text" name="lastname" id="lastname" value=<%=user.getLastName()%> />
            <label>Age</label>
            <input type="text" name="age" id="age" value=<%=user.getAge()%> />
            <label>Address</label>
            <input type="text" name="address" id="address" value=<%=user.getAddress()%> />
            <label>Avatar</label>
            <input type="file" name="avatar" id="avatar" />
            <input type="submit" name="submit" id="submit" />
    </form>
    </div>
  </body>
</html>
