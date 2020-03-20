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

    public DataBase() throws FileNotFoundException {
        readBookArray();
        readBookOwnerArray();
        readOrderArray();
    }

    private static void readBookArray() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME_BOOKS);

        try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            int bookCounter = objectInputStream.readInt();
            for (int i = 0; i < bookCounter; i++) {
                allBooks.add((Book)objectInputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readBookOwnerArray() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME_BOOK_OWNERS);

        try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            int bookCounter = objectInputStream.readInt();
            for (int i = 0; i < bookCounter; i++) {
                allOwners.add((BookOwner)objectInputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void readOrderArray() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME_ORDERS);

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

    private static void writeBookArray() throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME_BOOKS);

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeInt(allBooks.size());
            for(Book book: allBooks) {
                objectOutputStream.writeObject(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeBookOwnerArray() throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME_BOOK_OWNERS);

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeInt(allOwners.size());
            for(BookOwner owner: allOwners) {
                objectOutputStream.writeObject(owner);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeOrderArray() throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME_ORDERS);

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeInt(allOrders.size());
            for(Order order: allOrders) {
                objectOutputStream.writeObject(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAll() throws FileNotFoundException {
        writeBookArray();
        writeBookOwnerArray();
        writeOrderArray();
    }
}
