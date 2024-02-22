package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Resourse.Ticketcostpermanent;

public class ticketcostpermanantDAO  {

    PreparedStatement addC, adds;
    String stad;

    public ticketcostpermanantDAO()  {
        try {
            
            addC =getDBConnection.  con.prepareStatement("insert into ticketcost1 values(?,?,?,?,?)");
            adds =getDBConnection.  con.prepareStatement("Select * from ticketcost1 where ground_id=?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int setCost(Ticketcostpermanent cost)  {
        int rs=0;
        try {
            addC.setInt(1, cost.getGround_id());
            addC.setInt(2, cost.getC_vip());
            addC.setInt(3, cost.getC_fc());
            addC.setInt(4, cost.getC_sc());
            addC.setInt(5, cost.getC_st());
            rs = addC.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public Ticketcostpermanent SetCost(int g_id)  {
        try {
            adds.setInt(1, g_id);
            ResultSet rs = adds.executeQuery();
            if (rs.next()) {
                return new Ticketcostpermanent(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}