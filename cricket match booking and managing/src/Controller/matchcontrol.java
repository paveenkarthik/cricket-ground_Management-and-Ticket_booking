package Controller;

import java.text.SimpleDateFormat;

import Model.SeatDAO;
import Model.SeatPanelDAO;
import Model.TicketcostDAO;
import Model.matchDAO;
import Model.ticketcostpermanantDAO;
import Resourse.Match;
import Resourse.Seat;
import Resourse.Seatpanel;
import Resourse.Ticketcost;
import Resourse.Ticketcostpermanent;


public class matchcontrol {
    public int addcricket(int d, String matchname, String input)  {
        matchDAO match = new matchDAO();
        Match m = new Match();
        m.setGround_id(d);
        m.setMatch(matchname);
        int rs = match.addcricMatch(m, input);
        return rs;
    }

    public int getid(String matchname, String input) {
        matchDAO match = new matchDAO();
        Match m = new Match();
        m.setMatch(matchname);
        int key = match.getmatchId(m, input);
        return key;
    }

    public int setseatcost(int m_id, int g_id)  {
        SeatPanelDAO md = new SeatPanelDAO();
        SeatDAO seat = new SeatDAO();
        Seatpanel sp = md.getSeat(g_id);
        Seat chair = new Seat();
        chair.setFirstClass(sp.getFirstClass());
        chair.setGround_id(g_id);
        chair.setMatchId(m_id);
        chair.setSecondClass(sp.getSecondClass());
        chair.setVip(sp.getVip());
        chair.setStandard(sp.getStandard());
        int rs = seat.setSeat(chair);
        return rs;
    }

    public int ticketcost(int m_id, int g_id) {
        TicketcostDAO tcd = new TicketcostDAO();
        ticketcostpermanantDAO tp = new ticketcostpermanantDAO();
        Ticketcostpermanent tcp = tp.SetCost(g_id);
        Ticketcost tc = new Ticketcost();
        tc.setC_fc(tcp.getC_fc());
        tc.setC_sc(tcp.getC_sc());
        tc.setC_st(tcp.getC_st());
        tc.setC_vip(tcp.getC_vip());
        tc.setGround_id(g_id);
        tc.setMatch_id(m_id);
        int rs = tcd.getthecost(tc);
        return rs;

    }

    public int changedmatchName(String changedmatch, int id)  {
        matchDAO md = new matchDAO();
        Match m = new Match();
        m.setMatch(changedmatch);
        int rs = md.updatematchname(m, id);
        return rs;
    }

    public int changeDate(String date, int id)  {
        matchDAO md = new matchDAO();
        Match m = new Match();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date pa = simpleDateFormat.parse(date);
            java.sql.Date da = new java.sql.Date(pa.getTime());
            m.setMatchDate(da);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int rs = md.updateDateMatch(m, id);
        return rs;
    }

    public int changeplace(int grd_id, int id) {
        matchDAO md = new matchDAO();
        Match m = new Match();
        m.setGround_id(grd_id);
        int rs = md.updateplaceMatch(m, id);
        return rs;

    }

}
