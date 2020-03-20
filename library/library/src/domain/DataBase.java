package domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public static final String FILE_NAME_BOOKS = "src/res/bookData.txt";
    public static final String FILE_NAME_BOOK_OWNERS = "src/res/bookOwnerData.txt";
    public static final String FILE_NAME_ORDERS = "src/res/orderData.txt";

    private static List<Book> allBooks = new ArrayList<>();
    private static List<BookOwner> allOwners = new ArrayList<>();
    private static List<Order> allOrders = new ArrayList<>();

    public DataBase() {
        readBookArray();
        readBookOwnerArray();
        readOrderArray();
    }

    private static void readBookArray() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(FILE_NAME_BOOKS);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            int bookCounter = objectInputStream.readInt();
            for (int i = 0; i < bookCounter; i++) {
                allBooks.add((Book)objectInputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readBookOwnerArray() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(FILE_NAME_BOOK_OWNERS);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            int bookCounter = objectInputStream.readInt();
            for (int i = 0; i < bookCounter; i++) {
                allOwners.add((BookOwner)objectInputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readOrderArray() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(FILE_NAME_ORDERS);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            int bookCounter = objectInputStream.readInt();
            for (int i = 0; i < bookCounter; i++) {
                allOrders.add((Order)objectInputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
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
}
