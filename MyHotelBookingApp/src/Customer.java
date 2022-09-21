public class Customer {
    private String name;
    private long adhaarNumber;

    public Customer(String name, long adhaarNumber) {
        this.name = name;
        this.adhaarNumber = adhaarNumber;
    }

    public String getName() {
        return name;
    }

    public long getAdhaarNumber() {
        return adhaarNumber;
    }
}
