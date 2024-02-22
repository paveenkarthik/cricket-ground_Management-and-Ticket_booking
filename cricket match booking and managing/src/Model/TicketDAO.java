package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import Resourse.Ticket;
import Resourse.User;

public class TicketDAO   {
    PreparedStatement upticket, getticid, print, gelall ,deltic;

    public TicketDAO()  {
        try {
            upticket =getDBConnection.  con.prepareStatement(
                    "insert into ticket(user_id,ground_id,no_of_ticket,seat,amount,cur_date,match_id,TOTAL) values(?,?,?,?,?,?,?,?)");
            getticid =getDBConnection.  con.prepareStatement("select ticket_id from ticket where user_id=? and ground_id=? and match_id=?");
            print = getDBConnection. con.prepareStatement("select ground_id,no_of_ticket,seat,ticket_id from ticket where user_id=?");
            gelall = getDBConnection. con.prepareStatement("select seat,ground_id,no_of_ticket,amount from ticket where ticket_id =? ");
            deltic=getDBConnection. con.prepareStatement("delete from ticket where ticket_id=?");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int insertTicket(Ticket t, int cost, int total){
        int k=0;
        try {
            upticket.setInt(1, t.getUser_id());
            upticket.setInt(2, t.getGround_id());
            upticket.setInt(3, t.getNo_Of_Ticket());
            upticket.setString(4, t.getType_Of_Seat());
            upticket.setInt(5, cost);
            Date ddate = new Date();
            java.sql.Date da = new java.sql.Date(ddate.getTime());
            upticket.setDate(6, da);
            upticket.setInt(7, t.getMatch_id());
            upticket.setInt(8, total);
             k = upticket.executeUpdate();  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }

    public int getTicId(Ticket t)  {
        int key = 0;
        try {
            getticid.setInt(1, t.getUser_id());
            getticid.setInt(2, t.getGround_id());
            getticid.setInt(3, t.getMatch_id());
    
            ResultSet rs = getticid.executeQuery();
            if (rs.next()) {
                key = rs.getInt(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }

    public List<List<String>> canticUI(User u)  {
        List<List<String>> d = new ArrayList<>();
        try {
            print.setInt(1, u.getUser_id());
            ResultSet rs = print.executeQuery();
            while (rs.next()) {
                List<String> li = new ArrayList<>();
                li.add(String.valueOf(rs.getInt(1)));
                li.add(String.valueOf(rs.getInt(2)));
                li.add(rs.getString(3));
                li.add(String.valueOf(rs.getInt(4)));
                d.add(li);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;

    }

    public List<List<String>> canticTI(Ticket t) {
        List<List<String>> d = new ArrayList<>();
        try {
            gelall.setInt(1, t.getTicket_id());
            ResultSet rs=gelall.executeQuery();
            while (rs.next()) {
                List<String> li = new ArrayList<>();
                li.add(rs.getString(1));
                li.add(String.valueOf(rs.getInt(2)));
                li.add(String.valueOf(rs.getInt(3)));
                li.add(String.valueOf(rs.getInt(4)));
                d.add(li);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;

    }
    public int delteticket(int ticId) throws Exception{
        deltic.setInt(1, ticId);
        int rs=deltic.executeUpdate();
        return rs;



    }
}
