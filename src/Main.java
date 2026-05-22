import model.Order;
import service.OrderProcessingSystem;

public class Main {
    public static void main(String[] args) {
        OrderProcessingSystem system = new OrderProcessingSystem();

        system.addOrder(new Order(1, "Alice", 150.00, "normal"));
        system.addOrder(new Order(2, "Bob", 320.00, "urgent"));
        system.addOrder(new Order(3, "Alice", 89.90, "urgent"));
        system.addOrder(new Order(4, "Carol", 500.00, "urgent"));
        system.addOrder(new Order(5, "David", 210.00, "normal"));

        system.processAll();

        system.searchByCustomer("Alice");

        system.generateReport();

    }
}