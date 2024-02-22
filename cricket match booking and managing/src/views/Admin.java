package views;


import java.util.List;

import Controller.groundControl;
import Controller.userControl;
import Model.LoginDAO;
import Resourse.User;
import Util.Scan;

public class Admin extends Scan {
    public void stadiumDetail()  {
        System.out.println(
                "1.TICKET BOOKING\n2.ADDING STADIUM\n3.UPDATES ON STADIUM\n4.CANCELLING TICKETS\n5.ADMIN OWNS\n6.ADD/UPDATE MATCHES\n7.EXIT");
        System.out.println();
        User1 v = new User1();
        System.out.print("WHAT YOU WANT TO DO? ENTER YOUR CHOICE:= ");
        try {
            int choice = s.nextInt();
            matchview match = new matchview();
            if (choice == 2) {
                addStadium();
            } else if (choice == 1) {
                v.tobook1();
            } else if (choice == 3) {
                updateStadium();
            } else if (choice == 4) {
              v.cancelTicket();
            } else if (choice == 5) {
                adminOwns();
            } else if (choice == 6) {
                match.matches();
            } else if (choice == 7) {
                v.toSignUpLogin();
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public void addStadium()  {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                           ADDING A NEW STADIUM DETAILS                       |");
        System.out.println("|                           ****************************                       |");
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println();
        System.out.print("STADIUM NAME  : ");
        String g_name = s.next().toLowerCase();
        System.out.println();
        System.out.print("STADIUM PLACE : ");
        String g_place = s.next().toLowerCase();
        System.out.println();
        System.out.print("STADIUM TOTAL SEATING CAPACITY : ");
        int cap = s.nextInt();
        System.out.println();

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                           SPECIAL SEATS CAPACITES                            |");
        System.out.println("|                           ***********************                            |");
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println();
        System.out.print("NO OF VIP SEATS : ");
        int vip = s.nextInt();
        System.out.println();
        System.out.print("NO OF FIRST CLASS SEATS : ");
        int fc = s.nextInt();
        System.out.println();
        System.out.print("NO OF SECONG CLASS SEATS : ");
        int sc = s.nextInt();
        System.out.println();
        System.out.print("NO OF STANDARED SEATS : ");
        int st = s.nextInt();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                             COST OF THE TICKET                               |");
        System.out.println("|                             ******************                               |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.print("COST OF THE VIP TICKET : ");
        int cv = s.nextInt();
        System.out.println();
        System.out.print("COST OF THE FIRSTCLASS TICKET : ");
        int cf = s.nextInt();
        System.out.println();
        System.out.print("COST OF THE SECONDCLASS TICKET : ");
        int cs = s.nextInt();
        System.out.println();
        System.out.print("COST OF THE STANDARD TICKET : ");
        int cst = s.nextInt();
        System.out.println();
        groundControl grd = new groundControl();
        int addG = grd.addStadium(g_name, g_place, cap);
        int addC = grd.addCost(cv, cf, cs, cst, g_name);
        int addS = grd.addSeat(vip, fc, sc, st, g_name);
        if (addC == addG && addG == addS) {
            System.out.println("STADIUM IS ADDED");
            System.out.println("-------------------------------------------------------------------------------");

            stadiumDetail();
        }
    }

    public void updateStadium()  {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                             UPDATING THE STADIUM                            |");
        System.out.println("|                             ********************                            |");
        System.out.println("-------------------------------------------------------------------------------");
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
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("ENTER STADIUM ID : ");
        int id = s.nextInt();
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println();

        System.out.println("1.ALTER STADIUM NAME\n2.ALTER STADIUM PLACE\n3.ALTER SEAT CAPACITY\n4.EXIT");
        System.out.println();
        System.out.print("ENTER THE CHOICE : ");
        try {
            int what = s.nextInt();
            
            if (what == 1) {
                alterName(id);
            } else if (what == 2) {
                alterStadiumPlace(id);
            } else if (what == 3) {
                alterSeatCap(id);
            } else if (what == 4)
                stadiumDetail();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterName(int id) {
        groundControl grd = new groundControl();

        System.out.println();
        System.out.print("ENTER THE CHANGED NAME : ");
        String change = s.next().toLowerCase();
        System.out.println();
        int changed = grd.alterName(change, id);
        if (changed == 1)
            System.out.println("CHANGES DONE");
        else
            System.out.println("SOMETHING WENT WRONG");

    }

    public void alterStadiumPlace(int id)  {
        groundControl grd = new groundControl();
        System.out.println();
        System.out.print("ENTER THE CHANGED PLACE : ");
        String change = s.next().toLowerCase();
        System.out.println();
        int changed=0;
        try {
            
            changed = grd.altergrdPlace(change, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (changed == 1)
            System.out.println("CHANGES DONE");

        else
            System.out.println("SOMETHING WENT WRONG");

    }

    public void alterSeatCap(int id)  {
        groundControl grd = new groundControl();
        System.out.println();
        System.out.print("ENTER THE CHANGED CAPASITY : ");
        int change = s.nextInt();
        System.out.println();
        System.out.print("ENTER THE CHANGED VIP SEAT : ");
        int vi = s.nextInt();
        System.out.println();
        System.out.print("ENTER THE CHANGED FIRST CLASS SEAT : ");
        int fc = s.nextInt();
        System.out.println();
        System.out.print("ENTER THE CHANGED SECOND CLASS SEAT : ");
        int sc = s.nextInt();
        System.out.println();
        System.out.print("ENTER THE CHANGED STANDARD SEAT : ");
        int sta = s.nextInt();
        System.out.println();
        int changed=0;
        try {
            
             changed = grd.altergrdcap(id, change, vi, fc, sc, sta);
        } catch (Exception e) {
             e.printStackTrace();
        }
        if (changed == 1)
            System.out.println("CHANGES DONE");
        else
            System.out.println("SOMETHING WENT WRONG");
    }

    public void adminOwns() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(
                "1.ADD ADMIN\n2.PRINT ENTIRE USER DETAILS\n3.PRINT THE DETAILS BASED ON ID\n4.REMOVE THE USER BY ID\n5.EXIT");
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println();
        System.out.print("ENTER YOUR CHOICE : ");
        try {
            
            int a = s.nextInt();
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            if (a == 1) {
                AddAdmin();
            } else if (a == 2) {
                entireUser();
            } else if (a == 3) {
                printbyId();
            } else if (a == 4) {
                deleteUserById();
            } else if (a == 5) {
                stadiumDetail();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddAdmin() {
        System.out.println("                              ADMIN SIGNUP");
        System.out.println("                              ************");
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
        int set = signcontrol.signUpadmin(email, name, num, pass);
        if (set == 1) {
            System.out.println("YOUR ACCOUNT WAS REGISTERED");
            adminOwns();
        } else if (set == 6) {
            System.out.println("ENTER CORRECT EMAIL-ID");
            AddAdmin();
        } else if (set == 7) {
            System.out.println("ENTER PASSWORD WITH MORE THEN 8 CHARACTER");
            AddAdmin();

        } else if (set == 8) {
            System.out.println("ENTER VALID MOBILE NUMBER");
            AddAdmin();

        } else if (set == 9) {
            System.out.println("EMAIL ID ALREADY EXIST.... ENTER ANOTHER EMAIL-ID");
            AddAdmin();

        } else {
            System.out.println("SOMETHING WRONG ON YOUR SIGNUP");
            AddAdmin();
        }
    }

    public void entireUser()  {
        try {
            
            LoginDAO log = new LoginDAO();
            List<List<String>> rs = log.gellAllUsers();
            System.out.printf("%-20s%-20s%-20s%-20s\n", "USER ID", "USER EMAIL", "USER NAME",
                    "PHONE NUMBER");
                    for (int i = 0; i < rs.size(); i++) {
                        System.out.printf("%-20s", rs.get(i).get(0));
                        System.out.printf("%-20s", rs.get(i).get(1));
                        System.out.printf("%-20s", rs.get(i).get(2));
                        System.out.printf("%-20s\n", rs.get(i).get(3));
                      }
        } catch (Exception e) {
           e.printStackTrace();
        }

    }

    public void printbyId()  {
        try {
            LoginDAO log = new LoginDAO();
            System.out.print("ENTER ID FOR SEARCHING: ");
            int b = s.nextInt();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            User rs = log.getUserById(b);
            System.out.printf("%-20s%-20s%-20s%-20s\n", "USER ID", "USER EMAIL", "USER NAME",
                    "PHONE NUMBER");
            System.out.printf("%-20d", rs.getUser_id());
            System.out.printf("%-20s", rs.getUser_email());
            System.out.printf("%-20s", rs.getUser_name());
            System.out.printf("%-20S\n", rs.getPhone_number());
            System.out.println("-------------------------------------------------------------------------------");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUserById() throws Exception {
        entireUser();
        System.out.println();
        System.out.print("ENTER ID FOR DELETING: ");
        int b = s.nextInt();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
       int rs=0;
       try {
           LoginDAO log = new LoginDAO();
          rs = log.deleteUser(b);
        
       } catch (Exception e) {
        e.printStackTrace();
       }
        if (rs == 1)
            System.out.println("DELETED SUCCESSFULLY");
    }
}
