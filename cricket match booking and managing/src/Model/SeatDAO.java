package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.userControl;
import Resourse.Seat;
import Resourse.Seatpanel;
import Resourse.Ticketcostpermanent;

public class SeatDAO  {
    PreparedStatement addG, seatper, ticseat, vip, fc, sc, st;
    PreparedStatement cvip, csc, cst, cfc,ticcost;
    String stad;

    public SeatDAO()  {
        try {
            seatper = getDBConnection. con.prepareStatement("insert into seat values(?,?,?,?,?,?)");
            addG = getDBConnection. con.prepareStatement("select * from seat where ground_id=? and match_id=?");
            vip = getDBConnection. con.prepareStatement("update seat set vip=vip-? where ground_id=?  and match_id= ?");
            fc = getDBConnection. con.prepareStatement("update seat set firstclass=firstclass-? where ground_id=?  and match_id= ?");
            sc =getDBConnection.  con.prepareStatement("update seat set secondclass=secondclass-? where ground_id=?  and match_id= ?");
            st = getDBConnection. con.prepareStatement("update seat set standard=standard-? where ground_id=?  and match_id= ?");
            ticcost=getDBConnection. con.prepareStatement("select * from ticketcost where ground_id=? AND match_id=?");
    
            cvip =getDBConnection.  con.prepareStatement("update seat set vip=vip+? where ground_id=?");
            cfc = getDBConnection. con.prepareStatement("update seat set firstclass=firstclass+? where ground_id=?");
            csc =getDBConnection.  con.prepareStatement("update seat set secondclass=secondclass+? where ground_id=?");
            cst =getDBConnection.  con.prepareStatement("update seat set standard=standard+? where ground_id=?");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int setSeat(Seat chair)  {
        int rs=0;
        try {
            seatper.setInt(1, chair.getGround_id());
            seatper.setInt(2, chair.getVip());
            seatper.setInt(3, chair.getFirstClass());
            seatper.setInt(4, chair.getSecondClass());
            seatper.setInt(5, chair.getStandard());
            seatper.setInt(6, chair.getMatchId());
            rs = seatper.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;

    }

    public Seat availseat(int gi, int mi) 
     {
        try {
            addG.setInt(1, gi);
            addG.setInt(2, mi);
            ResultSet rs = addG.executeQuery();
            while (rs.next()) {
                return new Seat(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public  List<List<String>> availseat1(int gi, int mi) {
        List<List<String>> d = new ArrayList<>();
        try {
            
            addG.setInt(1, gi);
            addG.setInt(2, mi);
            ResultSet rs = addG.executeQuery();
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
    public Seat getAllSeat(int gi,int mi){
        try {
            
            ticcost.setInt(1, gi);
            ticcost.setInt(2, mi);
            ResultSet rs=ticcost.executeQuery();
            if(rs.next()){
                return new Seat(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public ArrayList<String> Seatss(int choice, int gi, int mi, int seat, int ui) throws Exception {

        ArrayList<String> h = new ArrayList<String>();
        if (choice == 1) {
            vip.setInt(1, seat);
            vip.setInt(2, gi);
            vip.setInt(3, mi);
            vip.executeUpdate();
            ticketcostpermanantDAO d = new ticketcostpermanantDAO();
            Ticketcostpermanent t = d.SetCost(gi);
            int percost = t.getC_vip();
            SeatPanelDAO sp = new SeatPanelDAO();
            Seatpanel panel = sp.getSeat(gi);
            int perseat = panel.getVip();
            Seat g = availseat(gi, mi);
            int temSeat = g.getVip();
            h.add(String.valueOf(ui));
            h.add(String.valueOf(gi));
            h.add(String.valueOf(seat));
            h.add("vip");
            h.add(String.valueOf(mi));
            h.add(String.valueOf(percost));
            h.add(String.valueOf(perseat));
            h.add(String.valueOf(temSeat));
            return h;

        } else if (choice == 2) {
            fc.setInt(1, seat);
            fc.setInt(2, gi);
            fc.setInt(3, mi);
            fc.executeUpdate();
            ticketcostpermanantDAO d = new ticketcostpermanantDAO();
            Ticketcostpermanent t = d.SetCost(gi);
            int percost = t.getC_fc();
            SeatPanelDAO sp = new SeatPanelDAO();
            Seatpanel panel = sp.getSeat(gi);
            int perseat = panel.getFirstClass();
            userControl control = new userControl();
            Seat g = control.seatAvail(gi, mi);
            int temSeat = g.getFirstClass();
            h.add(String.valueOf(ui));
            h.add(String.valueOf(gi));
            h.add(String.valueOf(seat));
            h.add("firstclass");
            h.add(String.valueOf(mi));
            h.add(String.valueOf(percost));
            h.add(String.valueOf(perseat));
            h.add(String.valueOf(temSeat));
            return h;
        } else if (choice == 3) {
            sc.setInt(1, seat);
            sc.setInt(2, gi);
            sc.setInt(3, mi);
            sc.executeUpdate();
            ticketcostpermanantDAO d = new ticketcostpermanantDAO();
            Ticketcostpermanent t = d.SetCost(gi);
            int percost = t.getC_sc();
            SeatPanelDAO sp = new SeatPanelDAO();
            Seatpanel panel = sp.getSeat(gi);
            int perseat = panel.getSecondClass();
            userControl control = new userControl();
            Seat g = control.seatAvail(gi, mi);
            int temSeat = g.getSecondClass();
            h.add(String.valueOf(ui));
            h.add(String.valueOf(gi));
            h.add(String.valueOf(seat));
            h.add("secondclass");
            h.add(String.valueOf(mi));
            h.add(String.valueOf(percost));
            h.add(String.valueOf(perseat));
            h.add(String.valueOf(temSeat));
            return h;
        } else if (choice == 4) {
            st.setInt(1, seat);
            st.setInt(2, gi);
            st.setInt(3, mi);
            st.executeUpdate();
            ticketcostpermanantDAO d = new ticketcostpermanantDAO();
            Ticketcostpermanent t = d.SetCost(gi);
            int percost = t.getC_st();
            SeatPanelDAO sp = new SeatPanelDAO();
            Seatpanel panel = sp.getSeat(gi);
            int perseat = panel.getStandard();
            userControl control = new userControl();
            Seat g = control.seatAvail(gi, mi);
            int temSeat = g.getStandard();
            h.add(String.valueOf(ui));
            h.add(String.valueOf(gi));
            h.add(String.valueOf(seat));
            h.add("standard");
            h.add(String.valueOf(mi));
            h.add(String.valueOf(percost));
            h.add(String.valueOf(perseat));
            h.add(String.valueOf(temSeat));
            return h;
        }
        return null;
    }

    public Seat Availseat(Seat a)  {
        try {
            
            addG.setInt(1, a.getGround_id());
            addG.setInt(2, a.getMatchId());
            ResultSet rs = addG.executeQuery();
            while (rs.next()) {
                return new Seat(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int oldformticket(String seat, int gid, int tick) throws Exception{

        int k=0;
        if (seat.equals("vip")) {
         cvip.setInt(1, tick);
         cvip.setInt(2, gid);
         int rs=cvip.executeUpdate();
         return rs;
        }
        
        else if (seat.equals("firstclass")) {
            cfc.setInt(1, tick);
            cfc.setInt(2, gid);
            int rs=cfc.executeUpdate();
            return rs;
        }
        
        else if (seat.equals("secondclass")) {
            csc.setInt(1, tick);
            csc.setInt(2, gid);
            int rs=csc.executeUpdate();
            return rs;
        }
        
        else if (seat.equals("standard")) {
            cst.setInt(1, tick);
            cst.setInt(2, gid);
            int rs=cst.executeUpdate();
            return rs;
        }
return k;
    }
}
