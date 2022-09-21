public class Room {
    private String[] facilities;
    private int occupancy;
    private int floor;
    Room(String[] facilities, int occupancy, int floor){
        this.facilities = facilities;
        this.occupancy = occupancy;
        this.floor = floor;
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
}
