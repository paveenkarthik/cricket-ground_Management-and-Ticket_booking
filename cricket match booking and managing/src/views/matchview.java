package views;

import java.util.List;

import Controller.groundControl;
import Controller.matchcontrol;
import Model.matchDAO;
import Util.Scan;

public class matchview extends Scan {

    public void matches()  {
        System.out.println("STADIUM DETAILS");
        System.out.println("***************");
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
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("1.ADD MATCHES\n2.UPDATE MATCHES\n3.CANCEL MATCHES\n4.EXIT");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.print("ENTER YOUR CHOICE: ");
        try {
            
            int d = s.nextInt();
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            if (d == 1) {
                addMatches();
            } else if (d == 2) {
                updateMatch();
            } else if (d == 3) {
                cancelmatch();
            } else if (d == 4) {
                Admin n = new Admin();
                n.stadiumDetail();
            } else {
                System.out.println("ENTER CORRECT CHOICE");
                System.out.println();
                matches();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMatches()  {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                                ADD MATCHES TO THE GROUND                     |");
        System.out.println("|                                *************************                     |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.print("GROUND ID: ");
        int d = s.nextInt();
        System.out.print("MATCH NAME : ");
        String matchname = s.next();
        System.out.print("MATCH DATE(yyyy-mm-dd) : ");
        String input = s.next();
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        matchcontrol control = new matchcontrol();
        int rs = control.addcricket(d, matchname, input);
        int k = 0, m = 0;
        int ps = control.getid(matchname, input);
        k = control.setseatcost(ps, d);
        m = control.ticketcost(ps, d);

        if (rs == 1 && k == 1 && m == 1) {
            System.out.println("SUCCESSFULLY MATCH ADDED");
        }
    }

    public void updateMatch() 
     {
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
        System.out.println("1.CHANGES IN MATCH\n2.CHANGES IN DATE\n3.CHANGE MATCH PLACE \n4.EXIT");
        try {
            System.out.print("ENTER YOUR CHOICE : ");
            int a = s.nextInt();
            System.out.println();
            System.out.print("ENTER THE MATCH ID : ");
            int id = s.nextInt();
            if (a == 1) {
                updateMatchName(id);
            } else if (a == 2) {
                updateMatchDate(id);
            } else if (a == 3) {
                updateplace(id);
            } else if (a == 4) {
                matches();
            } else {
                System.out.println("ENTER THE CORRENSPONDING VALUE ");
                matches();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMatchName(int id)  {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                         CHANGES IN THE MATCH                                 |");
        System.out.println("|                         ********************                                 |");
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("ENTER CHANGED MATCH NAME like(csk-vs-mi)");
        String changedmatch = s.next();
        System.out.println();
        matchcontrol control = new matchcontrol();
        int rs = control.changedmatchName(changedmatch, id);
        if (rs == 1) {
            System.out.println("MATCH WAS CHANGED SUCCESSFULLY");
        }
    }

    public void updateMatchDate(int id) 
     {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                         CHANGE MATCH DATE                                    |");
        System.out.println("|                         *****************                                    |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.print("ENTER THE CHANGED DATE (yyyy-mm-dd) : ");
        String date = s.next();
        matchcontrol control = new matchcontrol();
        int rs = control.changeDate(date, id);
        if (rs == 1) {
            System.out.println("MATCHDATE WAS CHANGED SUCCESSFULLY");
        }

    }

    public void updateplace(int id) 
     {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                         CHANGE MATCH PLACE                                   |");
        System.out.println("|                         ******************                                   |");
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
        System.out.println();
        System.out.print("ENTER THE CHANGED STADIUM ID : ");
        int m = s.nextInt();
        matchcontrol control = new matchcontrol();
        int rs = control.changeplace(m, id);
        if (rs == 1) {
            System.out.println("MATCHPLACE WAS CHANGED SUCCESSFULLY");
        }
    }

    public void cancelmatch() 
     {
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
        System.out.print("ENTER THE MATCH ID ");
        int id = s.nextInt();
        System.out.println();
        int rs = all.cancelmatch(id);
        if (rs == 1) {
            System.out.println("MATCH WAS DELETED");
        }
    }
}
