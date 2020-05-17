package by.mygeekacademy.library.console.action;

import by.mygeekacademy.library.exception.ValidationException;
import by.mygeekacademy.library.service.OrderService;
import by.mygeekacademy.library.service.impl.OrderServiceImpl;
import by.mygeekacademy.library.domain.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLDataException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderAction {
    private static final OrderService service = new OrderServiceImpl();
    private static final Logger logger = LogManager.getLogger(OrderAction.class.getName());

    public static void addOrder() {
        try {
            Scanner scanner = new Scanner(System.in);
            Order order = new Order();

            System.out.println("Enter reader's ID:");
            if (scanner.hasNext()) {
                order.setReadID(scanner.nextInt());
            }

            System.out.println("Enter book's ID:");
            if (scanner.hasNext()) {
                order.setBookID(scanner.nextInt());
            }

            service.create(order);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            logger.error(e.toString());
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
                    order.setReadID(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Enter new book's ID:");
                    order.setBookID((scanner.nextInt()));
                    break;
                default:
                    System.out.println("Nothing is chosen.");
                    break;
            }

            service.update(order);
        } catch (ValidationException | SQLDataException e) {
            System.out.println(e.getMessage());
            logger.error(e.toString());
        }
    }

    public static void deleteOrder() {
        Scanner scanner = new Scanner(System.in);

        int id = 0;
        System.out.println("Enter order's ID:");
        if (scanner.hasNext()) {
            id = scanner.nextInt();
        }

        Order order = service.read(id);
        if (order != null) {
            service.delete(order);
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
            logger.error(e.toString());
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
            logger.error(e.toString());
        }
    }

    public static void showOrder(int id) {
        service.showOrder(id);
    }
}
