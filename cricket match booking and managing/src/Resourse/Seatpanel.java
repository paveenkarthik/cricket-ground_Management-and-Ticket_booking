package Resourse;

public class Seatpanel {
    private int ground_id;
    private int vip;
    private int firstClass;
    private int secondClass;
    private int standard;
  
    
    public Seatpanel() {
    }
    public Seatpanel(int ground_id, int vip, int firstClass, int secondClass, int standard) {
        this.ground_id = ground_id;
        this.vip = vip;
        this.firstClass = firstClass;
        this.secondClass = secondClass;
        this.standard = standard;
    }
    
    public int getGround_id() {
        return ground_id;
    }
    public void setGround_id(int ground_id) {
        this.ground_id = ground_id;
    }
    public int getVip() {
        return vip;
    }
    public void setVip(int vip) {
        this.vip = vip;
    }
    public int getFirstClass() {
        return firstClass;
    }
    public void setFirstClass(int firstClass) {
        this.firstClass = firstClass;
    }
    public int getSecondClass() {
        return secondClass;
    }
    public void setSecondClass(int secondClass) {
        this.secondClass = secondClass;
    }
    public int getStandard() {
        return standard;
    }
    public void setStandard(int standard) {
        this.standard = standard;
    }
    

}
