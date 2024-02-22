package Controller;

import java.util.List;

import Model.SeatPanelDAO;
import Model.groundDAO;
import Model.ticketcostpermanantDAO;
import Resourse.Ground;
import Resourse.Seatpanel;
import Resourse.Ticketcostpermanent;

public class groundControl {
    public int addStadium(String stdName, String stdPlace, int capacity){
        groundDAO grd = new groundDAO();
        Ground grdres = new Ground();
        grdres.setGround_name(stdName);
        grdres.setGround_place(stdPlace);
        grdres.setTotalSeat(capacity);
        int rs = grd.addground(grdres);
        return rs;
    }

    public int addCost(int cv, int cf, int cs, int cst, String g_name)  {
        groundDAO grd = new groundDAO();
        ticketcostpermanantDAO grd1=new ticketcostpermanantDAO();
        Ticketcostpermanent tc = new Ticketcostpermanent();
        int id = grd.getid(g_name);
        tc.setC_fc(cf);
        tc.setC_sc(cs);
        tc.setC_st(cst);
        tc.setC_vip(cv);
        tc.setGround_id(id);
        int rs = grd1.setCost(tc);
        return rs;
    }

    public int addSeat(int vip, int fc, int sc, int st, String g_name){
        groundDAO grd = new groundDAO();
        SeatPanelDAO grd1=new SeatPanelDAO();
        int id = grd.getid(g_name);
        Seatpanel seat=new Seatpanel();
        seat.setFirstClass(fc);
        seat.setSecondClass(sc);
        seat.setVip(vip);
        seat.setStandard(st);
        seat.setGround_id(id);
        int rs=grd1.setSeat(seat);
        return rs;
    }

    public List<List<String>> updatation() {
        groundDAO grd = new groundDAO();
       List<List<String>> output=grd.updateStadium();
        return output; 
    }

    public int alterName(String change, int id) {
        groundDAO grd = new groundDAO();
        Ground g=new Ground();
        g.setGround_name(change);
        int rs=grd.alterstadiumName(g,id);
        return rs;
    }
    public int altergrdPlace(String change, int id) throws Exception{
        groundDAO grd = new groundDAO();
        Ground g=new Ground();
        g.setGround_place(change);
        int rs=grd.alterplace(g,id);
        return rs;

    }
    public int altergrdcap(int id, int change, int vi, int fc, int sc, int sta) throws Exception
    { groundDAO grd = new groundDAO();
        Ground g=new Ground();
        SeatPanelDAO grd1=new SeatPanelDAO();
        Seatpanel seat=new Seatpanel();
        g.setTotalSeat(change);
        int rs=grd.altercap(g,id);
        seat.setFirstClass(fc);
        seat.setSecondClass(sc);
        seat.setVip(vi);
        seat.setStandard(sta);
        int rp=grd1.altercseat(seat,id);
        if(rs==rp)
        return rs;

        return 5;


    }
}
