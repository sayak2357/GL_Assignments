public class Room {
    private String id;
    private String[] facilities;
    private int occupancy;
    private int floor;

    Room(String id,String[] facilities, int occupancy, int floor){
        this.id = id;
        this.facilities = facilities;
        this.occupancy = occupancy;
        this.floor = floor;
    }

    public boolean hasAc(){
        boolean res = false;
        for(String s: facilities){
            if(s.equals("AC")){
                res = true;
            }
        }
        return res;
    }
    public String[] getFacilities() {
        return facilities;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public int getFloor() {
        return floor;
    }
    public String getId(){
        return id;
    }
}
