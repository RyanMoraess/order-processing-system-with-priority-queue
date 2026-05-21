public class Order {
    private int id;
    private String customer;
    private double amount;
    private String status; // state: "pending" or "processed"
    private String type; // "normal" or "urgent"

    public Order(int id, String customer, double amount, String type) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
        this.type = type;
        this.status = "pending";
    }

    public int getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("[#%d] Customer: %s | Amount: $%.2f | Type: %s | Status: %s"
            id, customer, amount, type, status);
    }

}
