class Customer {
    String name;
    Customer next;

    public Customer(String name) {
        this.name = name;
        this.next = null;
    }
}

class Queue {
    private Customer front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    public void push(String name) {
        Customer newCustomer = new Customer(name);
        if (rear == null) {
            front = rear = newCustomer;
        } else {
            rear.next = newCustomer;
            rear = newCustomer;
        }
        System.out.println(name + " telah ditambahkan ke antrian.");
    }

    public void pop() {
        if (front == null) {
            System.out.println("Antrian kosong! Tidak ada pelanggan untuk dilayani.");
            return;
        }
        System.out.println(front.name + " telah dilayani dan keluar dari antrian.");
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    public void displayQueue() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.print("Antrian pelanggan: ");
        Customer temp = front;
        while (temp != null) {
            System.out.print(temp.name + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}

public class RestaurantQueue {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.push("Lanisa");
        queue.push("Aqsha");
        queue.push("Najmi");
        queue.push("Rizky");

        queue.displayQueue();

        queue.pop();
        queue.displayQueue();

        queue.pop();
        queue.displayQueue();

        queue.push("Mulyadi");
        queue.displayQueue();

        queue.pop();
        queue.pop();
        queue.displayQueue();
    }
}
