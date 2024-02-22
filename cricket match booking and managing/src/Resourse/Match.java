package Resourse;

import java.sql.Date;

public class Match {
    private int ground_id;
    private int match_id;
    private String match;
    private Date matchDate;

    
    public Match() {
    }
    

    public int getGround_id() {
        return ground_id;
    }
    public void setGround_id(int ground_id) {
        this.ground_id = ground_id;
    }
    public Match(int ground_id, int match_id, String match, Date matchDate) {
        this.ground_id = ground_id;
        this.match_id = match_id;
        this.match = match;
        this.matchDate = matchDate;
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



    public int getMatch_id() {
        return match_id;
    }



    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }



}
