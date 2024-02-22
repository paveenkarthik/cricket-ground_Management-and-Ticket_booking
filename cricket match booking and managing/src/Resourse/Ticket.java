package Resourse;

public class Ticket {
    private int ticket_id;
    private int user_id;
    private int ground_id;
    private int match_id;
    private int No_Of_Ticket;
    private String Type_Of_Seat;
    private String cur_date ;
    public Ticket() {
    }
    
    public Ticket(int ticket_id, int user_id, int ground_id,int match_id, int no_Of_Ticket, String type_Of_Seat, String cur_date) {
        this.ticket_id = ticket_id;
        this.user_id = user_id;
        this.match_id = match_id;
        No_Of_Ticket = no_Of_Ticket;
        Type_Of_Seat = type_Of_Seat;
        this.cur_date = cur_date;
        this.ground_id=ground_id;
    }

    public int getTicket_id() {
        return ticket_id;
    }
    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getMatch_id() {
        return match_id;
    }
    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }
    public int getNo_Of_Ticket() {
        return No_Of_Ticket;
    }
    public void setNo_Of_Ticket(int no_Of_Ticket) {
        No_Of_Ticket = no_Of_Ticket;
    }
    public String getType_Of_Seat() {
        return Type_Of_Seat;
    }
    public void setType_Of_Seat(String type_Of_Seat) {
        Type_Of_Seat = type_Of_Seat;
    }
    public String getCur_date() {
        return cur_date;
    }
    public void setCur_date(String cur_date) {
        this.cur_date = cur_date;
    }
    @Override
    public String toString() {
        return "Ticket [ticket_id=" + ticket_id + ", user_id=" + user_id + ", match_id=" + match_id + ", No_Of_Ticket="
                + No_Of_Ticket + ", Type_Of_Seat=" + Type_Of_Seat + ", cur_date=" + cur_date + "]";
    }

    public int getGround_id() {
        return ground_id;
    }

    public void setGround_id(int ground_id) {
        this.ground_id = ground_id;
    }
   
}
