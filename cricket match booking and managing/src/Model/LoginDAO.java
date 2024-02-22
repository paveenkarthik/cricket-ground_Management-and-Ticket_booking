package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Resourse.User;

public class LoginDAO {
  PreparedStatement getLogin, setSigh, getUser, delUser, getid;
  String query;

  public LoginDAO() throws SQLException {
    getLogin = getDBConnection. con.prepareStatement("select * from user where (user_email=? or phone_number=?)");
    setSigh =getDBConnection.  con
        .prepareStatement("insert into user(user_name,user_email,phone_number,whom,Password) values(?,?,?,?,?)");
    getUser = getDBConnection. con.prepareStatement("select * from user where user_id=?");
    delUser = getDBConnection. con.prepareStatement("delete from user where user_id=? and whom='user'");
    query = "select * from user where whom ='user'";
    getid =getDBConnection.  con.prepareStatement("select user_id from user where user_email=? or phone_number=?");

  }

  public User getLoginData(String email)  {
    try {
      getLogin.setString(1, email);
      getLogin.setString(2, email);
      ResultSet rs = getLogin.executeQuery();
      if (rs.next()) {
        return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
            rs.getString(6));
      }
      
    } catch (Exception e) {
     
      e.printStackTrace();
    }
    return null;
  }

  public int setSignInData(User use)  {
    int rs=0;
    try {
      setSigh.setString(1, use.getUser_name());
      setSigh.setString(2, use.getUser_email());
      setSigh.setString(3, use.getPhone_number());
      setSigh.setString(4, "user");
      setSigh.setString(5, use.getPassword());
      rs = setSigh.executeUpdate();
      
    } catch (Exception e) {
      
      e.printStackTrace();
    }
    return rs;
  }

  public int setSignInAdmin(User use) {
    int rs=0;
    try {
      setSigh.setString(1, use.getUser_name());
      setSigh.setString(2, use.getUser_email());
      setSigh.setString(3, use.getPhone_number());
      setSigh.setString(4, "admin");
      setSigh.setString(5, use.getPassword());
       rs = setSigh.executeUpdate();
      
    } catch (Exception e) {
      
      e.printStackTrace();
    }
    return rs;
  }

  public List<List<String>> gellAllUsers()  {
    List<List<String>> d = new ArrayList<>();
    try {
      ResultSet rs = getDBConnection. st.executeQuery(query);
      while (rs.next()) {
        List<String> li = new ArrayList<>();
        li.add(String.valueOf(rs.getInt(1)));
        li.add(rs.getString(2));
        li.add(rs.getString(3));
        li.add(rs.getString(4));
        li.add(rs.getString(5));
        d.add(li);
      }
      
    } catch (Exception e) {
     
      e.printStackTrace();
    }
    return d;
  }

  public User getUserById(int b) {
    try {
      getUser.setInt(1, b);
      ResultSet rs = getUser.executeQuery();
      if (rs.next()) {
        return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
            rs.getString(6));
      }
      
    } catch (Exception e) {
     
      e.printStackTrace();
    }
    return null;
  }

  public int deleteUser(int id)  {
int rs=0;
    try {
      delUser.setInt(1, id);
    rs = delUser.executeUpdate();
      
    } catch (Exception e) {
      
      e.printStackTrace();
    }
    return rs;
  }

  public int getuserId(User u)  {
    int k = 0;
try {
  getid.setString(1, u.getUser_email());
  getid.setString(2, u.getPhone_number());
  ResultSet rs = getid.executeQuery();
  if (rs.next()) {
    k = rs.getInt(1);

  }
  
} catch (Exception e) {
  
  e.printStackTrace();
}
    return k;

  }
}
