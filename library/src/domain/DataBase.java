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

    public DataBase() throws IOException, ClassNotFoundException {
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

    private static void writeBookArray() throws IOException {
        try {
            FileOutputStream f = new FileOutputStream(new File(FILE_NAME_BOOKS));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeInt(allBooks.size());
            for (Book book : allBooks) {
//                o.writeLong(book.getId());
                o.writeObject(book);
            }
            o.close();
            f.close();
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

    public static void writeAll() throws IOException {
        writeBookArray();
        writeBookOwnerArray();
        writeOrderArray();
    }
}
