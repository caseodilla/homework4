package edu.elon.data;

import java.sql.*;

import edu.elon.model.User;

public class UserDB {

  //inserts a user into the database
  public static int insertUser(User user) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;

    String query
            = "INSERT INTO User (Email, FirstName, LastName) "
            + "VALUES (?, ?, ?)";
    try {
      ps = connection.prepareStatement(query);
      ps.setString(1, user.getEmail());
      ps.setString(2, user.getFirstName());
      ps.setString(3, user.getLastName());
      return ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
      return 0;
    } finally {
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }

  //inserts a book into the database
  public static int insertBook(User user) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;

    String query
            = "INSERT INTO Book (BookName, DueDate, Email) "
            + "VALUES (?, ?, ?)";
    try {
      ps = connection.prepareStatement(query);
      ps.setString(1, user.getBookName());
      ps.setDate(2, user.getDate());
      ps.setString(3, user.getEmail());
      return ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
      return 0;
    } finally {
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }

  //updates a user in the database
  public static int updateUser(User user) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;

    String query = "UPDATE User SET "
            + "FirstName = ?, "
            + "LastName = ? "
            + "WHERE Email = ?";
    try {
      ps = connection.prepareStatement(query);
      ps.setString(1, user.getFirstName());
      ps.setString(2, user.getLastName());
      ps.setString(3, user.getEmail());

      return ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
      return 0;
    } finally {
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }
  
  //Updates the due date of a book for a particular user
  public static int updateBook(User user) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;

    String query = "UPDATE Book SET "
            + "DueDate = ?, "
            + "WHERE BookName = ?" 
            + "AND Email = ?";
    try {
      ps = connection.prepareStatement(query);
      ps.setDate(1, user.getDate());
      ps.setString(2, user.getBookName());
      ps.setString(2, user.getEmail());

      return ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
      return 0;
    } finally {
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }

  //removes a user from the database
  public static int deleteUser(User user) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;

    String query = "DELETE FROM User "
            + "WHERE Email = ?";
    try {
      ps = connection.prepareStatement(query);
      ps.setString(1, user.getEmail());

      return ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
      return 0;
    } finally {
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }

  //removes a book for a specific user from the database
  public static int deleteBook(User user) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;

    String query = "DELETE FROM Book "
            + "WHERE Email = ?"
            + "AND BookName = ?";
    try {
      ps = connection.prepareStatement(query);
      ps.setString(1, user.getEmail());
      ps.setString(2, user.getBookName());

      return ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
      return 0;
    } finally {
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }

  //Checks if a certain email already exists in the database
  public static boolean emailExists(String email) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    String query = "SELECT Email FROM User "
            + "WHERE Email = ?";
    try {
      ps = connection.prepareStatement(query);
      ps.setString(1, email);
      rs = ps.executeQuery();
      return rs.next();
    } catch (SQLException e) {
      System.out.println(e);
      return false;
    } finally {
      DBUtil.closeResultSet(rs);
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }

  //Returns a user given the user's email
  public static User selectUser(String email) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    String query = "SELECT * FROM User "
            + "WHERE Email = ?";
    try {
      ps = connection.prepareStatement(query);
      ps.setString(1, email);
      rs = ps.executeQuery();
      User user = null;
      if (rs.next()) {
        user = new User();
        user.setFirstName(rs.getString("FirstName"));
        user.setLastName(rs.getString("LastName"));
        user.setEmail(rs.getString("Email"));
      }
      return user;
    } catch (SQLException e) {
      System.out.println(e);
      return null;
    } finally {
      DBUtil.closeResultSet(rs);
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }
}
