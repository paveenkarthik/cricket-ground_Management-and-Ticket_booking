package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Resourse.Ground;

public class groundDAO {
    PreparedStatement addG, addS, addC, getGId, altname, altplace, altcap, altseat;
    String stad;

    public groundDAO() {
        try {
            addG = getDBConnection.con
                    .prepareStatement(" insert into ground(ground_name,ground_place,total_seat_cap) values(?,?,?)");
            getGId = getDBConnection.con.prepareStatement("select ground_id from ground where ground_name=?");
            altname = getDBConnection.con.prepareStatement("update ground set ground_name =? where ground_id=?");
            altplace = getDBConnection.con.prepareStatement("update ground set ground_place =? where ground_id=? ");
            altcap = getDBConnection.con.prepareStatement("update ground set total_seat_cap =? where ground_id=?");

        } catch (Exception e) {
            e.printStackTrace();
        }
        stad = "select * from ground";
    }

    public int addground(Ground grdres) {
        int rs = 0;
        try {
            addG.setString(1, grdres.getGround_name());
            addG.setString(2, grdres.getGround_place());
            addG.setInt(3, grdres.getTotalSeat());
            rs = addG.executeUpdate();
        } catch (Exception e) {
           
            e.printStackTrace();
        }
        return rs;
    }

    public int getid(String g_name) {

        int id = 0;
        try {
            getGId.setString(1, g_name);
            ResultSet rs = getGId.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);

            }
        } catch (Exception e) {
        }
        return id;
    }

    public List<List<String>> updateStadium() {
        List<List<String>> d = new ArrayList<>();
        try {
            ResultSet rs = getDBConnection.st.executeQuery(stad);
            while (rs.next()) {
                List<String> li = new ArrayList<>();
                li.add(String.valueOf(rs.getInt(1)));
                li.add(rs.getString(2));
                li.add(rs.getString(3));
                li.add(String.valueOf(rs.getString(4)));
                d.add(li);
            }

        } catch (Exception e) {
           
            e.printStackTrace();
        }

        return d;
    }

    public int alterstadiumName(Ground g, int id) {
        int rs = 0;
        try {
            altname.setString(1, g.getGround_name());
            altname.setInt(2, id);
            rs = altname.executeUpdate();

        } catch (Exception e) {
           
            e.printStackTrace();
        }
        return rs;
    }

    public int alterplace(Ground g, int id) {
        int rs = 0;
        try {
            altplace.setString(1, g.getGround_place());
            altplace.setInt(2, id);
            rs = altplace.executeUpdate();

        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return rs;
    }

    public int altercap(Ground g, int id) {
        int rs = 0;
        try {
            altcap.setInt(1, g.getTotalSeat());
            altcap.setInt(2, id);
            rs = altcap.executeUpdate();

        } catch (Exception e) {
           
            e.printStackTrace();
        }
        return rs;

    }

}
