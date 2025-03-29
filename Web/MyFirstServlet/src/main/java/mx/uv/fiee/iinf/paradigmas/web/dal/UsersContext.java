package mx.uv.fiee.iinf.paradigmas.web.dal;

import mx.uv.fiee.iinf.paradigmas.web.models.Avatar;
import mx.uv.fiee.iinf.paradigmas.web.models.User;

import java.sql.*;

public class UsersContext {
    private final Connection connection;

    public UsersContext (String user, String password, String url) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection (url, user, password);
    }

    public boolean addUser (User user) {
        var sql = getInsertUserStatement (user);
        PreparedStatement prepared;

        try {
            prepared = connection.prepareStatement (sql);
            prepared.execute ();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean editUser (int id, User user) {
        var sql = getUpdateUserProfile (id, user);
        PreparedStatement prepared;

        try {
            prepared = connection.prepareStatement (sql);
            prepared.executeUpdate ();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }


    public int addAvatar (Avatar avatar) throws SQLException {
        var sql = getInsertAvatarStatement (avatar);
        var prepared = connection.prepareStatement (sql);
        prepared.execute();

        sql = getIdentityStatement ();
        prepared  = connection.prepareStatement (sql);
        var rs = prepared.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return -1;
    }

    public ResultSet getUsers () {
        var sql = getAllUserStatement ();

        try {
            var prepared = connection.prepareStatement (sql);
            var result = prepared.executeQuery ();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getUser (int id) {
        var sql = getUserById (id);
        try {
            var prepared = connection.prepareStatement (sql);
            return prepared.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close () throws SQLException {
        connection.close ();
    }

    private String getInsertUserStatement (User user) {
        String template =  "INSERT INTO user_profile (name, last_name, age, address, avatar_id) VALUES ('%s', '%s', %d, '%s', %d)";
        String sql = String.format (template, user.getName(), user.getLastName(), user.getAge(), user.getAddress(), user.getAvatarId());
        return sql;
    }

    private String getAllUserStatement () {
        String sql = "SELECT id, name, last_name, age, address, avatar_id FROM user_profile";
        return sql;
    }

    private String getInsertAvatarStatement (Avatar avatar) {
        String template = "INSERT INTO user_avatar (avatar_name, avatar_path) VALUES ('%s', '%s');";
        String sql = String.format (template, avatar.getAvatarName(), avatar.getAvatarPath());
        return sql;
    }

    private String getIdentityStatement () {
        return "SELECT LAST_INSERT_ID();";
    }

    private String getUserById (int id) {
        String sql = "SELECT id, name, last_name, age, address, avatar_id FROM user_profile WHERE id = " + id;
        return sql;
    }

    private String getUpdateUserProfile (int id, User user) {
        String template = "UPDATE user_profile SET name='%s', last_name='%s', age=%d, address='%s' WHERE id = %d";
        String sql = String.format (template, user.getName(), user.getLastName(), user.getAge(), user.getAddress(), id);
        return sql;
    }
}
