package domain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public static final String FILE_NAME_BOOKS = "resources/bookData.txt";
    public static final String FILE_NAME_BOOK_OWNERS = "resources/bookOwnerData.txt";
    public static final String FILE_NAME_ORDERS = "resources/orderData.txt";

    private static List<Book> allBooks = new ArrayList<>();
    private static List<BookOwner> allOwners = new ArrayList<>();
    private static List<Order> allOrders = new ArrayList<>();

    public DataBase() throws IOException {
        readBookArray();
        readBookOwnerArray();
        readOrderArray();
    }

    private static void readBookArray() {
        try {
            FileInputStream fi = new FileInputStream(new File(FILE_NAME_BOOKS));
            ObjectInputStream oi = new ObjectInputStream(fi);

            int bookCounter = oi.readInt();
            for (int i = 0; i < bookCounter; i++) {
                allBooks.add((Book) oi.readObject());
            }
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readBookOwnerArray() {
        try {
            FileInputStream fi = new FileInputStream(new File(FILE_NAME_BOOK_OWNERS));
            ObjectInputStream oi = new ObjectInputStream(fi);

            int bookCounter = oi.readInt();
            for (int i = 0; i < bookCounter; i++) {
                allOwners.add((BookOwner) oi.readObject());
            }
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readOrderArray() {
        try {
            FileInputStream fi = new FileInputStream(new File(FILE_NAME_ORDERS));
            ObjectInputStream oi = new ObjectInputStream(fi);

            int bookCounter = oi.readInt();
            for (int i = 0; i < bookCounter; i++) {
                allOrders.add((Order) oi.readObject());
            }
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> getAllBooks() {
        return allBooks;
    }

    public static List<BookOwner> getAllOwners() {
        return allOwners;
    }
    public static List<Order> getAllOrders() {
        return allOrders;
    }

    public static void addBook(Book book) {
        allBooks.add(book);
    }

    public static void addBookOwner(BookOwner owner) {
        allOwners.add(owner);
    }

    public static void addOrder(Order order) {
        allOrders.add(order);
    }

    private static void writeBookArray() throws IOException {
        try {
            FileOutputStream f = new FileOutputStream(new File(FILE_NAME_BOOKS));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeInt(allBooks.size());
            for (Book book : allBooks) {
                o.writeObject(book);
            }
            o.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeBookOwnerArray() throws FileNotFoundException {
        try {
            FileOutputStream f = new FileOutputStream(new File(FILE_NAME_BOOK_OWNERS));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeInt(allOwners.size());
            for (BookOwner owner : allOwners) {
                o.writeObject(owner);
            }
            o.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeOrderArray() throws FileNotFoundException {
        try {
            FileOutputStream f = new FileOutputStream(new File(FILE_NAME_ORDERS));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeInt(allOrders.size());
            for (Order order : allOrders) {
                o.writeObject(order);
            }
            o.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAll() throws IOException {
        writeBookArray();
        writeBookOwnerArray();
        writeOrderArray();
    }
}
