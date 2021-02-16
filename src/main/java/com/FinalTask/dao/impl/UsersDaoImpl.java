package com.FinalTask.dao.impl;

import com.FinalTask.dao.UsersDao;
import com.FinalTask.entity.Role;
import com.FinalTask.entity.Users;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UsersDaoImpl implements UsersDao {

    private static final String SQL_FIND_USER_BY_NAME_AND_PASS = "SELECT * FROM users WHERE (user_name = ? AND user_password = ?)";
//    private static Map<String, Users> mapUsers;
//
//    static {
//        initUsers();
//    }
//
//    private static void initUsers() {
//        mapUsers = new HashMap<>();
//        Connection connection = ConnectionPool.getInstance().getConnection();
//        try {
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USERS");
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Users user = new Users();
//                user.setId(resultSet.getInt("id"));
//                user.setUserName(resultSet.getString("user_name"));
//                user.setUserPassword(resultSet.getString("user_password"));
//                user.setUserEmail(resultSet.getString("user_email"));
//                user.setUserAddress(resultSet.getString("user_address"));
//                user.setUserPhoneNumber(resultSet.getString("user_phone_number"));
//                user.setRoleId(resultSet.getInt("role_id"));
//                mapUsers.put(user.getUserName(), user);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//    }

//    public static Users findUser(String userName, String password) {
////        Users user = mapUsers.get(userName);
////        if (user != null && user.getUserPassword().equals(password)) {
////            return user;
////        }
////        return null;
//        Users user = null;
//        Connection connection = ConnectionPool.getInstance().getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users WHERE (user_name = ? AND user_password = ?)");
//            preparedStatement.setString(1, userName);
//            preparedStatement.setString(2, password);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            user = new Users();
//            while (resultSet.next()) {
//                user.setId(resultSet.getInt(1));
//                user.setUserName(resultSet.getString(2));
//                user.setUserPassword(resultSet.getString(3));
//                user.setUserEmail(resultSet.getString(4));
//                user.setUserAddress(resultSet.getString(5));
//                user.setUserPhoneNumber(resultSet.getString(6));
//                user.setRoleId(resultSet.getInt(7));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        if(user != null && user.getUserPassword() != null)
//            return user;
//        return null;
//    }

    @Override
    public int createUser(Users user) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO " +
                    "USERS(user_name, user_password, user_email, " +
                    "user_address, user_phone_number, role_id) VALUES(?,?,?,?,?,?)");
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserPassword());
            statement.setString(3, user.getUserEmail());
            statement.setString(4, user.getUserAddress());
            statement.setString(5, user.getUserPhoneNumber());
            statement.setInt(6, user.getRoleId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public Users findUserByNameAndPass(String userName, String userPassword) {
        Users user = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = ConnectionPool.getInstance().getConnection();
            pstmt = con.prepareStatement(SQL_FIND_USER_BY_NAME_AND_PASS);
            pstmt.setString(1, userName);
            pstmt.setString(2, userPassword);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = extractUser(rs);
            }
        } catch (SQLException ex) {
           // throw new DBException(Messages.ERR_CANNOT_OBTAIN_USER_BY_LOGIN, ex);
        } finally {
            close(con, pstmt, rs);
        }
        return user;
    }


    private void close(Connection con, Statement stmt, ResultSet rs) {
        close(rs);
        close(stmt);
        close(con);
    }
    private void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
              //  LOG.error(Messages.ERR_CANNOT_CLOSE_CONNECTION, ex);
            }
        }
    }

    /**
     * Closes a statement object.
     */
    private void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
               // LOG.error(Messages.ERR_CANNOT_CLOSE_STATEMENT, ex);
            }
        }
    }

    /**
     * Closes a result set object.
     */
    private void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                //LOG.error(Messages.ERR_CANNOT_CLOSE_RESULTSET, ex);
            }
        }
    }

    private Users extractUser(ResultSet rs) throws SQLException {
        Users user = new Users();
        user.setId(rs.getInt(1));
        user.setUserName(rs.getString(2));
        user.setUserPassword(rs.getString(3));
        user.setUserEmail(rs.getString(4));
        user.setUserAddress(rs.getString(5));
        user.setUserPhoneNumber(rs.getString(5));
        user.setRoleId(rs.getInt(7));
        return user;
    }

}
