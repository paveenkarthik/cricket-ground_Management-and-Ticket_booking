package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Resourse.Seatpanel;

public class SeatPanelDAO  {

    PreparedStatement addG, addS, altseat, addc,ticseat;
    String stad;

    public SeatPanelDAO()  {
        try {
            addS = getDBConnection. con.prepareStatement("insert into seatpanel values(?,?,?,?,?)");
            altseat =getDBConnection. con.prepareStatement(
                    "update seatpanel set vip= ?,firstclass=?,secondclass=?,standard=? where ground_id=?");
            addc = getDBConnection. con.prepareStatement("Select * from seatpanel where ground_id=?");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int setSeat(Seatpanel seat) {
        int rs=0;
        try {
            addS.setInt(1, seat.getGround_id());
            addS.setInt(2, seat.getVip());
            addS.setInt(3, seat.getFirstClass());
            addS.setInt(4, seat.getSecondClass());
            addS.setInt(5, seat.getStandard());
            rs = addS.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;

    }

    public int altercseat(Seatpanel seat, int id) {
        int rs=0;
        try {
            altseat.setInt(1, seat.getVip());
            altseat.setInt(2, seat.getFirstClass());
            altseat.setInt(3, seat.getSecondClass());
            altseat.setInt(4, seat.getStandard());
            altseat.setInt(5, id);
            rs = altseat.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public Seatpanel getSeat(int g_id)  {
        try {
            
            addc.setInt(1, g_id);
            ResultSet rs = addc.executeQuery();
            if (rs.next()) {
                return new Seatpanel(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
