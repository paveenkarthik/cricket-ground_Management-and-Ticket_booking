package Resourse;

import java.sql.Date;

public class groundandmatch {
    private int ground_id;
    private int match_id;
    private String match;
    private Date matchDate;
    private String ground_name;
    private String ground_place;
    private int totalSeat;

    

    public groundandmatch() {
    }

    
    public groundandmatch(int ground_id, int match_id, String match, Date matchDate, String ground_name,
            String ground_place, int totalSeat) {
        this.ground_id = ground_id;
        this.match_id = match_id;
        this.match = match;
        this.matchDate = matchDate;
        this.ground_name = ground_name;
        this.ground_place = ground_place;
        this.totalSeat = totalSeat;
    }


    public int getGround_id() {
        return ground_id;
    }
    public void setGround_id(int ground_id) {
        this.ground_id = ground_id;
    }
    public int getMatch_id() {
        return match_id;
    }
    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }
    public String getMatch() {
        return match;
    }
    public void setMatch(String match) {
        this.match = match;
    }
    public Date getMatchDate() {
        return matchDate;
    }
    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }
    public String getGround_name() {
        return ground_name;
    }
    public void setGround_name(String ground_name) {
        this.ground_name = ground_name;
    }
    public String getGround_place() {
        return ground_place;
    }
    public void setGround_place(String ground_place) {
        this.ground_place = ground_place;
    }
    public int getTotalSeat() {
        return totalSeat;
    }
    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }



}
