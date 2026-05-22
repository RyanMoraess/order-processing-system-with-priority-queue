import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class OrderProcessingSystem {
    private Queue<Order> normalQueue;
    private Queue<Order> priorityQueue;
    private List<Order> processedList;

    public OrderProcessingSystem() {
        this.normalQueue = new LinkedList<>();
        this.priorityQueue = new LinkedList<>();
        this.processedList = new ArrayList<>();
    }

    public void addOrder(Order order) {
        if (order.getType().equals("urgent")) {
            priorityQueue.offer(order);
            System.out.println("Urgent order queued: " + order);
        } else {
            normalQueue.offer(order);
            System.out.println("Normal order queued: " + order);
        }
    }

    public void processNext() {
        Order order = null;

        if (!priorityQueue.isEmpty()) {
            order = priorityQueue.poll();
        } else if (!normalQueue.isEmpty()) {
            order = normalQueue.poll();
        } else {
            System.out.println("No orders to process.");
            return;
        }

        order.setStatus("processed");
        processedList.add(order);
        System.out.println("Processed: " + order);
    }

    public void processAll() {
        System.out.println("/n--- Processing all orders ---");
        while (!priorityQueue.isEmpty() || !normalQueue.isEmpty()) {
            processNext();
        }
    }

    public void searchByCustomer(String name) {
        System.out.println("/n--- Search results for: " + name " ---");
        for (Order order : processedList) {
            if (order.getCustomer().equalIgnoreCase(name)) {
                System.out.println(order);
            }
        }
    }

    public void generateReport() {
        System.out.println("/n======= REPORT =======");
        System.out.println("Total processed: " + processedList.size());

        double total = 0;
        for (Order order : processedList) {
            total += order.getAmount();
        }
        System.out.printf("Total amount: $%.2f%n", total);

        long urgentCount = 0;
        for (Order order : processedList) {
            if (order.getType().equals("urgent")) {
                urgentCount++;
            }
        }

        System.out.println("Urgent orders: " + urgentCount);
        System.out.println("Normal orders: " + (processedList.size() - urgentCount));
        System.out.println("======================");

    }

}