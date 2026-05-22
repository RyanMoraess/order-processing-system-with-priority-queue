package service;

import model.Order;
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
        // Checks the order type to route it to the correct queue
        if (order.getType().equalsIgnoreCase("urgent")) {
            priorityQueue.offer(order);
            System.out.println("Urgent order queued: " + order);
        } else {
            normalQueue.offer(order);
            System.out.println("Normal order queued: " + order);
        }
    }

    public void processNext() {
        Order order = null;

        // First, tries to pull from the priority queue
        if (!priorityQueue.isEmpty()) {
            order = priorityQueue.poll();
        } 
        // If the priority queue is empty, pulls from the normal queue
        else if (!normalQueue.isEmpty()) {
            order = normalQueue.poll();
        }

        // If an order was found in either queue, processes it
        if (order != null) {
            order.setStatus("processed");
            processedList.add(order);
            System.out.println("Processed: " + order);
        } else {
            System.out.println("No orders to process.");
        }
    }

    public void processAll() {
        System.out.println("\n--- Processing all orders ---");
        // Loop continues as long as there is any order left in either queue
        while (!priorityQueue.isEmpty() || !normalQueue.isEmpty()) {
            processNext();
        }
    }

    public void searchByCustomer(String name) {
        System.out.println("\n--- Search results for: " + name + " ---");
        // Iterates through the processed history to find matching customer names
        for (Order order : processedList) {
            if (order.getCustomer().equalsIgnoreCase(name)) {
                System.out.println(order);
            }
        }
    }

    public void generateReport() {
        System.out.println("\n------- REPORT -------");
        System.out.println("Total processed: " + processedList.size());

        double total = 0;
        long urgentCount = 0;

        // Calculates total revenue and counts urgent orders
        for (Order order : processedList) {
            total += order.getAmount();
            if (order.getType().equalsIgnoreCase("urgent")) {
                urgentCount++;
            }
        }

        System.out.printf("Total amount: $%.2f\n", total);
        System.out.println("Urgent orders: " + urgentCount);
        System.out.println("Normal orders: " + (processedList.size() - urgentCount));
        System.out.println("----------------------");
    }
}