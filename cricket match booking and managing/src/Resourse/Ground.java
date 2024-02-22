package Resourse;

public class Ground {
    private int ground_id;
    private String ground_name;
    private String ground_place;
    private int totalSeat;
    public Ground() {
    }
    public Ground(int ground_id, String ground_name, String ground_place, int totalSeat) {
        this.ground_id = ground_id;
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
    @Override
    public String toString() {
        return "Ground [ground_id=" + ground_id + ", ground_name=" + ground_name + ", ground_place=" + ground_place
                + ", totalSeat=" + totalSeat + "]";
    }
    

}
