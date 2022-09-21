public class Booking {
    private Customer customer;
    private int startDate;
    private int endDate;
    private String roomId;
    private Payment payment;
    boolean status;

    public Booking(Customer customer, int startDate, int endDate, String roomId, Payment payment, boolean status) {
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomId = roomId;
        this.payment = payment;
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getStartDate() {
        return startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public String getRoomId() {
        return roomId;
    }

    public Payment getPayment() {
        return payment;
    }
    public boolean getStatus(){
        return status;
    }
}
