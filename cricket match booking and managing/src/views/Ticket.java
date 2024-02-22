package views;

import java.util.ArrayList;

import Controller.userControl;
import Resourse.Seat;
import Util.Scan;

public class Ticket extends Scan {
    public void setVip(int v, int gi, int mi, int ui) {
        User1 view = new User1();
        System.out.print("NUMBER OF SEATS YOU NEEDED : ");
        int seat = s.nextInt();
        System.out.println();
        Seat y = new Seat();
        int k = 0;
        // if (v == 1) {
        //     k = y.getVip();
        //     System.out.println(k);
        // } else if (v == 2) {
        //     k = y.getFirstClass();
        // } else if (v == 3) {
        //     k = y.getSecondClass();
        // } else if (v == 4) {
        //     k = y.getStandard();
        // }
    
        //  if(k>seat)
        //  {
        //     System.out.println("ENTER VALID SEAT QUANTIY");
        //     System.out.println();
        //     setVip(v, gi, mi, ui);
        //     return;
        //  }

        System.out.println("-------------------------------------------------------------------------------");
        userControl user = new userControl();
        ArrayList<String> p = user.ticket(v, gi, mi, seat, ui);
        ArrayList<Integer> amount = user.amount(p);
        System.out.println("COST/TICKET: " + amount.get(0));
        System.out.println("TOTAL COST: " + amount.get(1));
        int cost = amount.get(0);
        int total = amount.get(1);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("1.PAY\n2.EXIT");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("ENTER 1/2 :");
        int what = s.nextInt();
        int m = 0;
        if (what == 1) {
            m = user.insertTicket(p, cost, total);
        }
        if (what == 2) {
            view.book();
        }
        if (m != 0) {
            System.out.println("");
            System.out.println("YOUR TICKET BOOKED SUCCESSFULLY.....!!");
            System.out.println("-------------------------------------------------------------------------------");
            view.book();
        }

    }
}
