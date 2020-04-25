package console.action;

import domain.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

import java.util.Scanner;

public class OrderAction {
    private static final OrderService service = new OrderServiceImpl();

    public static void addOrder() {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        System.out.println("Enter reader's ID:");
        if (scanner.hasNext()) {
            order.setReaderID(scanner.nextInt());
        }

        System.out.println("Enter book's ID:");
        if (scanner.hasNext()) {
            order.setBookID(scanner.nextInt());
        }

        if (service.create(order)) {
            System.out.println(order);
        }
        else {
            System.out.println("Failed to create order.");
        }
    }

    public static void updateOrder() {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        System.out.println("Enter order's ID:");
        if (scanner.hasNext()) {
            order = service.read(scanner.nextInt());
        }
        System.out.println(order);

        int c;
        System.out.println("[1] Update reader's ID" + "\n[2] Update book's ID");
        c = scanner.nextInt();
        switch (c) {
            case 1:
                System.out.println("Enter new reader's ID:");
                order.setReaderID(scanner.nextInt());
                break;
            case 2:
                System.out.println("Enter new book's ID:");
                order.setBookID((scanner.nextInt()));
                break;
            default:
                System.out.println("Nothing is chosen.");
                break;
        }

        if (service.update(order)) {
            System.out.println(order);
        }
        else {
            System.out.println("Failed to update order.");
        }
    }

    public static void deleteOrder() {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        int id = 0;
        System.out.println("Enter order's ID:");
        if (scanner.hasNext()) {
            id = scanner.nextInt();
        }

        if (service.delete(id)) {
            System.out.println("Deleted successful.");
        }
        else {
            System.out.println("Failed to delete order.");
        }
    }

    public static void listAllOrders() {
        service.listAllOrders();
    }

    public static void showOrder(int id) {
        service.showOrder(id);
    }
}
