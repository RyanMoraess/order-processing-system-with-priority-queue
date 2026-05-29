# Order processing System with Priority Queue

## About the Project
This repository contains a functional Java application developed as part of the **Algorithms and Data Structures** assignment at Unifil. The core objective is to solve a simulated real-word problem using efficient computational data management.

## The Real-World Problem 
In high-volume e-commerce or logistics hubs, order cannot always be processed on a strictly first-come, first-served basis. Urgent orders or express shipping requsts immediate fulfillment to meet strict business timelines.

This system simulates an automated dispatch system where incoming orders are dynamically routed and prioritized based on operational rules rather than arrival time alone.

## Data Structure $ Operations

To meet the academic requirements, this project implements a **Priority Queue mechanism** using multiple standard Queues. The implementation covers all fundamental data operations:
* **Equeue (Insertaion):** Orders are analyzed and placed into either the 'priorityQueue' or 'normalQueue' based on their type.
* **Dequeue (Removal):** The system processes and removes the highest-priority orders first. Normal orders are handled only when the prorioty queue is empty.
* **Collection Tracking:** A history list tracks processed orders for analytics, and generating dynamic metrics.

## How to Run
1. Clone the repository.
2. Nvigate to the `src/` directory.
3. Highlight or opne `Main.java` using your favorite IDE or terminal and run it.
