public class Payment {
    private Customer customer;
    private int amount;
    private String mode;

    public Payment(Customer customer, int amount, String mode) {
        this.customer = customer;
        this.amount = amount;
        this.mode = mode;
    }
    public Payment(){
        this.customer = null;
        this.amount = 0;
        this.mode = null;
    }

    public Customer getCustomer() {
        return customer;
    }

    public long getAmount() {
        return amount;
    }

    public String getMode() {
        return mode;
    }
}
