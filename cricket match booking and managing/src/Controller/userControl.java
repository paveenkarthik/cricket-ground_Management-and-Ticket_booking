package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.LoginDAO;
import Model.SeatDAO;
import Model.TicketDAO;
import Model.TicketcostDAO;
import Resourse.Seat;
import Resourse.Ticket;
import Resourse.Ticketcost;
import Resourse.User;

public class userControl {
    public int login(String email, String Pass) throws Exception {
        LoginDAO login = new LoginDAO();
        User whom = login.getLoginData(email);
        if (whom == null)
            throw new Exception("INVALID USER");
        if (!whom.getPassword().equals(Pass))
            throw new Exception("INVALID PASSWORD");
        if (whom.getWhom().equals("admin")) {
            return 1;
        }
        if (!whom.getWhom().equals("admin")) {
            return 3;
        }
        
        return 2;
    }

    public int signUp(String email, String name, String phonenum, String pass)  {
        int isSignUp = 0;
        try {
            
            LoginDAO sign = new LoginDAO();
        
        int k = 0;
        if (!email.contains("@gmail.com")) {
            return 6;
        } else
            k = k + 1;
        if (pass.length() < 8) {
            return 7;
        } else
            k = k + 1;
        if (phonenum.length() != 10) {
            return 8;
        } else
            k = k + 1;
        User whom = sign.getLoginData(email);
        if (whom != null) {
            return 9;
        } else
            k = k + 1;
        User res = new User();
        if (k == 4) {
            res.setUser_name(name);
            res.setUser_email(email);
            res.setPassword(pass);
            res.setPhone_number(phonenum);
            isSignUp = sign.setSignInData(res);
        }
    } catch (Exception e) {
       e.printStackTrace();
    }
        return isSignUp;
    }

public int signUpadmin(String email, String name, String phonenum, String pass) {
    int isSignUp = 0;
    try {
        LoginDAO sign = new LoginDAO();
        int k = 0;
        if (!email.contains("@gmail.com")) {
            return 6;
        } else
            k = k + 1;
        if (pass.length() < 8) {
            return 7;
        } else
            k = k + 1;
        if (phonenum.length() != 10) {
            return 8;
        } else
            k = k + 1;
        User whom = sign.getLoginData(email);
        if (whom != null) {
            return 9;
        } else
            k = k + 1;
        User res = new User();
        if (k == 4) {
            res.setUser_name(name);
            res.setUser_email(email);
            res.setPassword(pass);
            res.setPhone_number(phonenum);
            isSignUp = sign.setSignInAdmin(res);
        }
    } catch (Exception e) {
       e.printStackTrace();
    }
        return isSignUp;
    }

    public int getUserId(String ep) throws Exception {
        LoginDAO d = new LoginDAO();
        User u = new User();
        u.setUser_email(ep);
        u.setPhone_number(ep);
        int id = d.getuserId(u);
        return id;
    }

    public int getTicketId(int ui, int gi, int mi)  {
        TicketDAO m = new TicketDAO();
        Ticket T = new Ticket();
        T.setUser_id(ui);
        T.setGround_id(gi);
        T.setMatch_id(mi);            
        int k = m.getTicId(T);
        return k;
    }
   public List<List<String>> cancelTicket(int k) {
    List<List<String>> d=new ArrayList<>();
    TicketDAO m = new TicketDAO();
    User u=new User();
    u.setUser_id(k);
    d=m.canticUI(u);
    return d;
   }
   public List<List<String>> cancel(int ticId ){
    List<List<String>> d=new ArrayList<>();
    TicketDAO m = new TicketDAO();
    Ticket T=new Ticket();
    T.setTicket_id(ticId);
    d=m.canticTI(T);
    return d;
   }
   
   public int deleteTic(String seat, int gid, int tick){
    SeatDAO m = new SeatDAO();
    int k=0;
    try {
       k=m.oldformticket(seat,gid,tick);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    return k;
   }
   public int insertTicket(ArrayList<String> p, int cost, int total) {
        int a=Integer.parseInt(p.get(0)); 
        int b=Integer.parseInt(p.get(1)); 
        int c=Integer.parseInt(p.get(2)); 
        String d=p.get(3); 
        int e=Integer.parseInt(p.get(4)); 
        Ticket T = new Ticket();
        T.setUser_id(a);
        T.setGround_id(b);
        T.setNo_Of_Ticket(c);
        T.setType_Of_Seat(d);
        T.setMatch_id(e);
        TicketDAO m = new TicketDAO();
        int k=m.insertTicket(T,cost,total);
        return k;
    }
    
    public Seat seatAvail(int gi, int mi)  {
        SeatDAO m = new SeatDAO();
        Seat a = new Seat();
        a.setGround_id(gi);
        a.setMatchId(mi);
        Seat k = m.Availseat(a);
        System.out.println(k.getGround_id());
        return k;
    }
    public List<List<String>> seatAvail1(int gi, int mi)  {
        SeatDAO m = new SeatDAO();
        Seat a = new Seat();
        a.setGround_id(gi);
        a.setMatchId(mi);
       List<List<String>> k = m.availseat1(gi,mi);
        return k;
    }

    public List<List<String>> cost(int gi, int mi)  {
        TicketcostDAO tDao = new TicketcostDAO();
        Ticketcost t = new Ticketcost();
        t.setGround_id(gi);
        t.setMatch_id(mi);
        List<List<String>> f = tDao.gettcost(t);
        return f;
    }

    public ArrayList<String> ticket(int choice, int gi, int mi, int seat, int ui)  {
        SeatDAO se = new SeatDAO();
        ArrayList<String> p=new ArrayList<>();
        try {
             p = se.Seatss(choice, gi, mi, seat, ui);
             
            } catch (Exception e) {
                e.printStackTrace();
            }
            return p;
       
    }
   
    public ArrayList<Integer> amount(ArrayList<String> p)  {
        ArrayList<Integer> a = new ArrayList<>();
        int length = p.size(), total = 0;
        int ts = Integer.parseInt(p.get(length - 1));
        int ps = Integer.parseInt(p.get(length - 2));
        int cost = Integer.parseInt(p.get(length - 3));
        int seat = Integer.parseInt(p.get(2));
        if (ts >= seat) {

            if ((ps / 1.3) > ts) {
                cost *= 1.5;
                total = cost * seat;
                a.add(cost);
                a.add(total);
                return a;

            } else if ((ps / 2) > ts) {
                cost *= 2;
                total = cost * seat;
                a.add(cost);
                a.add(total);
                return a;

            } else if ((ps / 4) > ts) {
                cost *= 2.5;
                total = cost * seat;
                a.add(cost);
                a.add(total);
                return a;

            } else if ((ps / 8) > ts) {
                cost *= 3;
                total = cost * seat;
                a.add(cost);
                a.add(total);
                return a;

            } else {
                total = cost * seat;
                a.add(cost);
                a.add(total);
                return a;

            }
        } else {
            return null;
        }

    }
}
