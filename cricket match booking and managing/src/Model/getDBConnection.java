package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Util.Env;

public class getDBConnection {
    protected static Connection con;
    public static Statement st;

    private getDBConnection() {
        try {
  
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Env.url, Env.user, Env.pass);
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        if (con == null) {
            new getDBConnection();
        }
        return con;
    }
}
