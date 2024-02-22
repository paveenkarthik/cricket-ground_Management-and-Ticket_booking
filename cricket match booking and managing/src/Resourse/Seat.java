package Resourse;

public class Seat {
   private int ground_id;
   private int vip;
   private int firstClass;
   private int secondClass;
   private int standard;
   private int matchId;

public Seat() {
   
}
public Seat(int ground_id, int vip, int firstClass, int secondClass, int standard, int matchId) {
    this.ground_id = ground_id;
    this.vip = vip;
    this.firstClass = firstClass;
    this.secondClass = secondClass;
    this.standard = standard;
    this.matchId = matchId;
}

public int getGround_id() {
    return ground_id;
}
public void setGround_id(int ground_id) {
    this.ground_id = ground_id;
}


public int getMatchId() {
    return matchId;
}

public void setMatchId(int matchId) {
    this.matchId = matchId;
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
