package Resourse;

public class Ticketcostpermanent {
    private int ground_id;
    private int c_vip;
    private int c_fc;
    private int c_sc;
    private int c_st;

    
    public Ticketcostpermanent() {
    }

    public Ticketcostpermanent(int ground_id, int c_vip, int c_fc, int c_sc, int c_st) {
        this.ground_id = ground_id;
        this.c_vip = c_vip;
        this.c_fc = c_fc;
        this.c_sc = c_sc;
        this.c_st = c_st;
    }


    public int getGround_id() {
        return ground_id;
    }


    public void setGround_id(int ground_id) {
        this.ground_id = ground_id;
    }


    public int getC_vip() {
        return c_vip;
    }


    public void setC_vip(int c_vip) {
        this.c_vip = c_vip;
    }


    public int getC_fc() {
        return c_fc;
    }


    public void setC_fc(int c_fc) {
        this.c_fc = c_fc;
    }


    public int getC_sc() {
        return c_sc;
    }


    public void setC_sc(int c_sc) {
        this.c_sc = c_sc;
    }


    public int getC_st() {
        return c_st;
    }


    public void setC_st(int c_st) {
        this.c_st = c_st;
    }

    @Override
    public String toString() {
        return "Ticketcostpermanent [ground_id=" + ground_id + ", c_vip=" + c_vip + ", c_fc=" + c_fc + ", c_sc=" + c_sc
                + ", c_st=" + c_st + "]";
    }


}
