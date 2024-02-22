package views;

import java.util.List;

import Controller.groundControl;
import Controller.userControl;
import Model.TicketDAO;
import Model.matchDAO;
import Util.Scan;

public class User1 extends Scan {
  public void toSignUpLogin()  {

    System.out.println("WELCOME TO CRICKET TICKET BOOKING");
    System.out.println("*********************************");
    System.out.print("1.Login\n2.Signup\n3.Exit\n");
    System.out.println("-------------------------------------------------------------------------------");
    System.out.print("ENTER YOUR CHOICE: ");
    int does = s.nextInt();
    System.out.println("-------------------------------------------------------------------------------");
    if (does == 1) {
      getlogin();
    } else if (does == 2) {
      toSignUp();
    } else {
      return;
    }
  }

  public void getlogin() 
   {

    System.out.println("                                 LOGIN");
    System.out.println("                                 *****");
    System.out.print("ENTER YOUR EMAIL ID OR MOBILE NUMBER: ");
    String num = s.next().toLowerCase();
    System.out.println();
    System.out.print("ENTER YOUR PASSWORD: ");
    String pass = s.next();
    System.out.println("-------------------------------------------------------------------------------");
    int check=0;
    Admin admin = new Admin();
    try {
      userControl us = new userControl();
       check = us.login(num, pass);
      
    } catch (Exception e) {
     e.printStackTrace();
    }
    if (check == 1) {
      System.out.println("LOGGINED SUCCESSFULLY");
      System.out.println("-------------------------------------------------------------------------------");
      System.out.println("WELCOME ADMIN");
      System.out.println("-------------------------------------------------------------------------------");
      admin.stadiumDetail();
    } else if(check==3) {
      System.out.println("LOGGINED SUCCESSFULLY");
      System.out.println("-------------------------------------------------------------------------------");
      System.err.println("WELCOME USER");
      System.out.println("-------------------------------------------------------------------------------");
      book();
    }
  }

  public void toSignUp() 
   {
    System.out.println("                              SIGNUP");
    System.out.println("                              ******");
    System.out.println("-------------------------------------------------------------------------------");

    System.out.println();
    System.out.print("ENTER YOUR NAME =>");
    String name = s.next().toLowerCase();
    System.out.println();
    System.out.print("ENTER YOUR PHONE NUMBER =>");
    String num = s.next();
    System.out.println();
    System.out.print("ENTER YOUR EMAIL ID =>");
    String email = s.next().toLowerCase();
    System.out.println();
    System.out.print("ENTER YOUR PASSWORD =>");
    String pass = s.next();
    System.out.println();
    userControl signcontrol = new userControl();
    int set = signcontrol.signUp(email, name, num, pass);
    if (set == 1) {
      System.out.println("YOUR ACCOUNT WAS REGISTERED");
      getlogin();
    } else if (set == 6) {
      System.out.println("ENTER CORRECT EMAIL-ID");
      toSignUp();
    } else if (set == 7) {
      System.out.println("ENTER PASSWORD WITH MORE THEN 8 CHARACTER");
      toSignUp();

    } else if (set == 8) {
      System.out.println("ENTER VALID MOBILE NUMBER");
      toSignUp();

    } else if (set == 9) {
      System.out.println("EMAIL ID ALREADY EXIST.... ENTER ANOTHER EMAIL-ID");
      toSignUp();

    } else {
      System.out.println("SOMETHING WRONG ON YOUR SIGNUP");
      toSignUp();
    }
  }

  public void book()
   {
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println("1.BOOKING\n2.CANCELLATION\n3.EXIT");
    System.out.println();
    System.out.println("-------------------------------------------------------------------------------");
    System.out.print("ENTER YOUR CHOICE : ");
    int choice = s.nextInt();
    System.out.println();
    System.out.println("-------------------------------------------------------------------------------");
    if (choice == 1) {
      setbooking();
    } else if (choice == 2) {
      cancelTicket();
    } else if (choice == 3) {
      System.out.println("THANK YOU  (:)..!!");
    } else {
      System.out.println("ENTER THE CORRESPONDING DETAILS");
      System.out.println("-------------------------------------------------------------------------------");
      book();
    }
  }
  public void tobook1()
   {
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println("1.BOOKING\n2.CANCELLATION\n3.EXIT");
    System.out.println();
    System.out.println("-------------------------------------------------------------------------------");
    System.out.print("ENTER YOUR CHOICE : ");
    int choice = s.nextInt();
    System.out.println();
    System.out.println("-------------------------------------------------------------------------------");
    if (choice == 1) {
      setbooking();
    } else if (choice == 2) {
      cancelTicket();
    } else if (choice == 3) {
      System.out.println("THANK YOU  (:)..!!");
      Admin view=new Admin();
      view.stadiumDetail();
    } else {
      System.out.println("ENTER THE CORRESPONDING DETAILS");
      System.out.println("-------------------------------------------------------------------------------");
      book();
    }
  }

  public void setbooking() 
   {
    System.out.println("                        TICKET BOOKING");
    System.out.println("                        **************");
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println("                            MATCHES");
    System.out.println("                            *******");
    System.out.println("-------------------------------------------------------------------------------");
    matchDAO all = new matchDAO();
    List<List<String>> mat = all.GetAllMatch();
    System.out.printf("%-20s%-20s%-20s%-20s\n", "MATCH ID", "STADIUM ID", "MATCHES",
        "DATE OF THE MATCH");
    for (int i = 0; i < mat.size(); i++) {
      System.out.printf("%-20s", mat.get(i).get(0));
      System.out.printf("%-20s", mat.get(i).get(1));
      System.out.printf("%-20s", mat.get(i).get(2));
      System.out.printf("%-20s\n", mat.get(i).get(3));
    }

    System.out.println();
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println("                            STADIUM");
    System.out.println("                            *******");
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println();

    groundControl grd = new groundControl();
    List<List<String>> update = grd.updatation();
    System.out.printf("%-20s%-20s%-20s%-20s\n", "STADIUM ID", "STADIUM NAME", "STADIUM LOCATION",
        " SEAT ALLOCATION ");
    for (int i = 0; i < update.size(); i++) {
      System.out.printf("%-20s", update.get(i).get(0));
      System.out.printf("%-20s", update.get(i).get(1));
      System.out.printf("%-20s", update.get(i).get(2));
      System.out.printf("%-20s\n", update.get(i).get(3));
    }
    System.out.println();
    System.out.println("1.CONFIRM BOOKING\n2.EXIT");
    int book = s.nextInt();
    System.out.println();
    System.out.println("-------------------------------------------------------------------------------");
    if (book == 2) {
      book();
    } else if (book == 1) {
      ticketBooking();
    }
  }

  public void ticketBooking() 
   {
    System.out.print("ENTER YOUR EMAIL ID : ");
    String ep = s.next().toLowerCase();
    System.out.println();
    System.out.println("-------------------------------------------------------------------------------");
    int id=0;
    try {
      userControl p = new userControl();
     id = p.getUserId(ep);
      
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("-------------------------------------------------------------------------------");
    System.out.println();
    System.out.print("ENTER THE STADIUM ID : ");
    int gi = s.nextInt();
    System.out.println();
    System.out.print("ENTER THE MATCH ID : ");
    int mi = s.nextInt();
    System.out.println();
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println("                            SEAT'S AVAILABLE ");
    System.out.println("                           ******************");
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println();
    System.out.println(
        "----------------------------------------------------------------------------------------------------------------------------------");
    userControl control = new userControl();
    List<List<String>> k = control.seatAvail1(gi, mi);
    System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "GROUND ID", "VIP SEAT", "FIRST CLASS SEAT",
        "SECOND CLASS SEAT", "STANDARD SEAT");
        for (int i = 0; i < k.size(); i++) {
          System.out.printf("%-20s", k.get(i).get(0));
          System.out.printf("%-20s", k.get(i).get(1));
          System.out.printf("%-20s", k.get(i).get(2));
          System.out.printf("%-20s", k.get(i).get(3));
          System.out.printf("%-20s\n", k.get(i).get(4));
        }
      if(k.isEmpty())
      {
        System.out.println("THERE IS NO MATCH FOUND");
        setbooking();
        return;
      }
    System.out.println(
        "----------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println();
    System.out.println("                           COST OF THE SEATS");
    System.out.println("                           *****************");
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println(
        "-----------------------------------------------------------------------------------------------------------");
    System.out.println();

    System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "GROUND ID", "VIP SEAT", "FIRST CLASS SEAT",
        "SECOND CLASS SEAT", "STANDARD SEAT");
    List<List<String>>  k1 = control.cost(gi, mi);
    for (int i = 0; i < k1.size(); i++) {
      System.out.printf("%-20s", k1.get(i).get(0));
      System.out.printf("%-20s", k1.get(i).get(1));
      System.out.printf("%-20s", k1.get(i).get(2));
      System.out.printf("%-20s", k1.get(i).get(3));
      System.out.printf("%-20s\n", k1.get(i).get(4));
    }

    System.out.println(
        "-----------------------------------------------------------------------------------------------------------");
    // System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    System.out.println();
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println("1.VIP SEAT\n2.FIRST CLASS SEAT\n3.SECOND CLASS SEAT\n4.STANDARD SEAT\n5.EXIT");
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println();
    System.out.print("ENTER YOUR CHOICE : ");
    int choice = s.nextInt();
    System.out.println();
    System.out.println("-------------------------------------------------------------------------------");

    Ticket view = new Ticket();
    System.out.println();
    if (choice == 1) {
      view.setVip(choice, gi, mi, id);
    } else if (choice == 2) {
      view.setVip(choice, gi, mi, id);
    } else if (choice == 3) {
      view.setVip(choice, gi, mi, id);

    } else if (choice == 4) {
      view.setVip(choice, gi, mi, id);

    } else if (choice == 5) {

      book();
    }
  }

  public void cancelTicket() 
   {
    int k=0;
    System.out.println("TICKET CANCELLING");
    System.out.println("*****************");
    System.out.print("ENTER YOUR EMAIL ID : ");
    String email = s.next();
    userControl use=new userControl();
    User1 view =new User1();
    int tid=0;
    try {
      tid=use.getUserId(email);
      
    } catch (Exception e) {
     e.printStackTrace();
    }
if(tid==0)
{
  System.out.println("ENTER VALID EMAIL-ID :");
  System.out.println();
  cancelTicket();
  return;
}
if(!email.contains("@gmail.com")){
  System.out.println("ENTER VALID EMAIL-ID :");
  System.out.println();
  cancelTicket();
  return;
}
    System.out.println();
    System.out.println("-------------------------------------------------------------------------------");
    userControl user = new userControl();
    try {
      k = user.getUserId(email);
      
    } catch (Exception e) {
     e.printStackTrace();
    }
    List<List<String>> li = user.cancelTicket(k);
    System.out.printf("%-20s%-20s%-20s%-20s\n", "GROUND ID", "NO OF TICKETS", "TYPE OF SEAT", "TICKET_ID");
    for (int i = 0; i < li.size(); i++) {
      System.out.printf("%-20s", li.get(i).get(0));
      System.out.printf("%-20s", li.get(i).get(1));
      System.out.printf("%-20s", li.get(i).get(2));
      System.out.printf("%-20s\n", li.get(i).get(3));
    }
    if (li.isEmpty()) {
      System.out.println("THERE IS NO BOOKING");
      book();
    }
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println();
    System.out.print("ENTER THE TICKET ID : ");
    int ticId = s.nextInt();
    List<List<String>> d = user.cancel(ticId);
    String seat = "";
    int gid = 0;
    int tick = 0;
    int amount = 0;
    seat = d.get(0).get(0);
    gid = Integer.parseInt(d.get(0).get(1));
    tick = Integer.parseInt(d.get(0).get(2));
    amount = Integer.parseInt(d.get(0).get(3));
    System.out.println(seat);
    System.out.println(gid);
    System.out.println(tick);
    System.out.println(amount);
     user.deleteTic(seat, gid, tick);
    System.out.println("YOUR AMOUNT (" + amount + ") WILL BE CREDITED IN 10 MINITES");
    System.out.println();
    System.out.println("IF YOU RECEIVED THE AMOUNT ENTER .1");
    int a = s.nextInt();
    if (a == 1) {
      TicketDAO tic = new TicketDAO();
      try {
        
        tic.delteticket(ticId);
        view.book();
        
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
