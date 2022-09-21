import java.util.ArrayList;
import java.util.Scanner;

public class MyHotelBookingApp {
    private static ArrayList<Booking> allBookings = new ArrayList<Booking>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hi");
        Hotel myHotel = initializeHotel();
        while(true){
            System.out.print("1) Book Hotel\n2) Exit\nEnter your option: ");
            int choice = sc.nextInt();
            if(choice == 1){
                Customer C = getCustomerInfo();
                Booking B = getBooking(C,myHotel);
                if(!B.status){
                    System.out.println("Sorry! no rooms available");
                }
                else{
                    allBookings.add(B);
                }
            }
            if(choice == 2){
                return;
            }
        }
    }
    private static Booking getBooking(Customer C,Hotel H){
        int startDate,endDate, occupancy,acNonAc,floor;
        String paymentMethod;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hi "+C.getName());
        System.out.println("Enter dates between 1 and 30");
        System.out.print("Enter start date: ");
        startDate = sc.nextInt();
        while(true) {
            System.out.print("Enter exit date: ");
            endDate = sc.nextInt();
            if(endDate>startDate)
                break;
        }
        int duration = endDate - startDate+1;
        while(true) {
            System.out.print("Enter occupancy (1/2/3): ");
            occupancy = sc.nextInt();
            if(occupancy == 1 || occupancy == 2 || occupancy == 3)
                break;
        }
        while(true) {
            System.out.print("Ac or non-AC (1 - AC, 0 - non-AC): ");
            acNonAc = sc.nextInt();
            if(acNonAc ==1 || acNonAc == 0)
                break;
        }
        while(true) {
            System.out.print("Floor preference (0 - no preference, 1 - First Floor, 2 - Second Floor): ");
            floor = sc.nextInt();
            if(floor ==1 || floor == 0 || floor == 2)
                break;
        }
        Room room = getSuitableRoom(startDate,endDate,occupancy,acNonAc,floor,H);
        if(room!=null){
            while(true){
                System.out.println("total fair: "+getFair(room)*duration);
                System.out.println("enter payment method (cash/card): ");
                paymentMethod = sc.next();
                if(paymentMethod.equals("cash") || paymentMethod.equals("card"))
                    break;
            }
            Payment p = new Payment(C,getFair(room), paymentMethod);
            System.out.println("You have successfully booked the room: "+room.getId());
            if(occupancy == 1)
                System.out.print("Single occupancy ");
            else if(occupancy == 2)
                System.out.print("Double occupancy ");
            else
                System.out.print("Triple occupancy ");
            if(acNonAc>0)
                System.out.print("AC ");
            System.out.println(room.getFloor()+"th floor");
            return new Booking(C,startDate,endDate, room.getId(), p, true);
        }
        else{
            return new Booking(C,startDate,endDate,"",new Payment(),false);
        }
    }
    private static Room getSuitableRoom(int startDate, int endDate, int occupancy, int acNonAc,int floor, Hotel H){
        Room[] allRooms = H.getRooms();
        Scanner sc = new Scanner(System.in);
        for(Room r: allRooms){
            if(floor>0 && acNonAc>0) {
                if (r.getOccupancy() == occupancy && r.getFloor() == floor && r.hasAc()){
                    String id = r.getId();
                    if(isBookingAvailable(startDate,endDate,id)){
                        System.out.println("You need to pay: " + getFair(r));
                        return r;
                    }
                }
            }
            else if(floor>0 && acNonAc==0) {
                if (r.getOccupancy() == occupancy && r.getFloor() == floor){
                    String id = r.getId();
                    if(isBookingAvailable(startDate,endDate,id)){
                        System.out.println("You need to pay: " + getFair(r));
                        return r;
                    }
                }
            }
            else if(floor==0 && acNonAc>0) {
                if (r.getOccupancy() == occupancy && r.hasAc()){
                    String id = r.getId();
                    if(isBookingAvailable(startDate,endDate,id)){
                        return r;
                    }
                }
            }
            else if(floor==0 && acNonAc==0) {
                if (r.getOccupancy() == occupancy){
                    String id = r.getId();
                    if(isBookingAvailable(startDate,endDate,id)){
                        System.out.println("You need to pay: " + getFair(r));
                        return r;
                    }
                }
            }
        }
        return null;
    }
    private static boolean isBookingAvailable(int startDate,int endDate,String id){
        for(Booking B:allBookings){
            if(B.getRoomId() == id && isConflict(B,startDate,endDate))
                return false;
        }
        return true;
    }
    private static  boolean isConflict(Booking B, int startDate, int endDate){
        int bookingStartDate = B.getStartDate();
        int bookingEndDate = B.getEndDate();
        if(endDate<bookingStartDate || startDate>bookingEndDate)
            return false;
        return true;
    }
    private static Customer getCustomerInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("your name: ");
        String name = sc.nextLine();
        System.out.print("your adhaar number: ");
        long adhaarNumber = sc.nextLong();
        Customer C = new Customer(name,adhaarNumber);
        return C;
    }
    private static Hotel initializeHotel(){
        Room[] rooms = new Room[7];
        rooms[0] = new Room("101", new String[] {"AC"},1,1);
        rooms[1] = new Room("102", new String[] {"AC"},2,1);
        rooms[2] = new Room("103", new String[] {},2,1);
        rooms[3] = new Room("201", new String[] {"AC"},1,2);
        rooms[4] = new Room("202", new String[] {},1,2);
        rooms[5] = new Room("203", new String[] {"AC"},2,2);
        rooms[6] = new Room("204", new String[] {"AC"},3,2);
        return new Hotel("SayakIn","Kolkata 84",rooms);
    }
    private static int getFair(Room r){
        int totalFair = 0;
        if(r.getOccupancy() == 1)
            totalFair += 2000;
        else if(r.getOccupancy() == 2)
            totalFair += 3000;
        else if(r.getOccupancy() ==3)
            totalFair += 4000;
        String[] facilities = r.getFacilities();
        for(String f:facilities){
            if(f.equals("AC"))
                totalFair += 1000;
        }
        return totalFair;
    }
}
