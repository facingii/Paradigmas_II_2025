package mx.uv.fiee.iinf.paradigmas.web.dal;

import mx.uv.fiee.iinf.paradigmas.web.models.Avatar;
import mx.uv.fiee.iinf.paradigmas.web.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class UsersProvider {

    public static LinkedList<User> getAllUsers (String username, String password, String url) throws SQLException, ClassNotFoundException {
        LinkedList<User> userList = new LinkedList<>();
        UsersContext context = new UsersContext (username, password, url);
        ResultSet resultSet = context.getUsers ();

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId (resultSet.getInt("id"));
                    user.setName (resultSet.getString("name"));
                    user.setLastName (resultSet.getString("last_name"));
                    user.setAge (resultSet.getInt("age"));
                    user.setAddress (resultSet.getString("address"));

                    userList.add(user);
                }
            } catch (Exception ex) {
                ex.printStackTrace ();
            }
        }

        context.close ();
        return userList;
    }

    public static int insertNewAvatar (String username, String password, String url, Avatar avatar) throws SQLException, ClassNotFoundException {
        UsersContext context = new UsersContext(username, password, url);
        int id = context.addAvatar (avatar);
        context.close ();
        return id;
    }

    public static boolean insertNewUser (String username, String password, String url, User user) throws SQLException, ClassNotFoundException {
        var context = new UsersContext (username, password, url);
        boolean result = context.addUser (user);
        context.close ();
        return result;
    }

    public static User getUser (String username, String password, String url, int id) throws SQLException, ClassNotFoundException {
        var context = new UsersContext (username, password, url);
        ResultSet resultSet = context.getUser (id);

        User user = null;
        if (resultSet.next ()) {
            user = new User ();
            user.setId (resultSet.getInt("id"));
            user.setName (resultSet.getString("name"));
            user.setLastName (resultSet.getString("last_name"));
            user.setAge (resultSet.getInt("age"));
            user.setAddress (resultSet.getString("address"));
            user.setAvatarId (resultSet.getInt("avatar_id"));
        }

        context.close ();
        return user;
    }

    public static boolean editUser (String username, String password, String url, int id, User user) throws SQLException, ClassNotFoundException {
        var context = new UsersContext (username, password, url);
        boolean result = context.editUser (id, user);
        context.close ();
        return result;
    }

}
