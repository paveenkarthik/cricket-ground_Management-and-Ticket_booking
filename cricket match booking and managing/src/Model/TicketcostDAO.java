package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Resourse.Ticketcost;

public class TicketcostDAO {
    PreparedStatement ticper,ticamount;
    String stad;

    public TicketcostDAO()  {
        try {
            ticper =getDBConnection.  con.prepareStatement("insert into ticketcost values(?,?,?,?,?,?)");
            ticamount=getDBConnection. con.prepareStatement("select * from ticketcost where ground_id=? AND match_id=?");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getthecost(Ticketcost tc)  {
        int rs=0;
        try {
            ticper.setInt(1, tc.getGround_id());
            ticper.setInt(2, tc.getC_vip());
            ticper.setInt(3, tc.getC_fc());
            ticper.setInt(4, tc.getC_sc());
            ticper.setInt(5, tc.getC_st());
            ticper.setInt(6, tc.getMatch_id());
           rs = ticper.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public List<List<String>> gettcost(Ticketcost t) {
        List<List<String>> d = new ArrayList<>();
        try {
            ticamount.setInt(1, t.getGround_id());
            ticamount.setInt(2, t.getMatch_id());
            ResultSet rs=ticamount.executeQuery();
               while (rs.next()) {
                   List<String> li = new ArrayList<>();
                   li.add(String.valueOf(rs.getInt(1)));
                   li.add(String.valueOf(rs.getInt(2)));
                   li.add(String.valueOf(rs.getInt(3)));
                   li.add(String.valueOf(rs.getInt(4)));
                   li.add(String.valueOf(rs.getInt(5)));
                   li.add(String.valueOf(rs.getInt(6)));
                   d.add(li);
               }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }
}
