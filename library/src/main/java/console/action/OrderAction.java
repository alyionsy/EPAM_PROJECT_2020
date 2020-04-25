package console.action;

import domain.Order;
import exception.ValidationException;
import service.OrderService;
import service.impl.OrderServiceImpl;

import java.sql.SQLDataException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderAction {
    private static final OrderService service = new OrderServiceImpl();

    public static void addOrder() {
        try {
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
                System.out.println("Completed.");
            } else {
                System.out.println("Failed to create order.");
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateOrder() {
        try {
            Scanner scanner = new Scanner(System.in);
            Order order = new Order();

            System.out.println("Enter order's ID:");
            if (scanner.hasNext()) {
                order = service.read(scanner.nextInt());
                if (order == null) {
                    throw new SQLDataException("Invalid ID.");
                }
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
                System.out.println("Completed.");
            } else {
                System.out.println("Failed to update order.");
            }
        } catch (ValidationException | SQLDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteOrder() {
        Scanner scanner = new Scanner(System.in);

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

    public static void findOrder() {
        Scanner scanner = new Scanner(System.in);

        int c;
        System.out.println("[1] by reader\n[2] by book");
        c = scanner.nextInt();
        switch (c) {
            case 1:
                findByReaderID();
                break;
            case 2:
                findByBookID();
                break;
            default:
                break;
        }

    }

    private static void findByReaderID() {
        try {
            Scanner scanner = new Scanner(System.in);

            int id = 0;
            System.out.println("Enter ID of the reader:");
            if (scanner.hasNext()) {
                id = scanner.nextInt();
            }
            System.out.println(service.findByReaderID(id));

        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    private static void findByBookID() {
        try {
            Scanner scanner = new Scanner(System.in);

            int id = 0;
            System.out.println("Enter ID of the book:");
            if (scanner.hasNext()) {
                id = scanner.nextInt();
            }
            System.out.println(service.findByBookID(id));

        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    public static void showOrder(int id) {
        service.showOrder(id);
    }
}
