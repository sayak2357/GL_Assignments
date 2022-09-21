public class Hotel {
    private String name;
    private String address;
    private Room[] rooms;

    public Hotel(String name, String address, Room[] rooms) {
        this.name = name;
        this.address = address;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Room[] getRooms() {
        return rooms;
    }
}
