package domain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public static final String BOOK_DATA_TXT = "resources/bookData.txt";
    public static final String READER_DATA_TXT = "resources/readerData.txt";
    public static final String ORDER_DATA_TXT = "resources/orderData.txt";

    private static List<Book> allBooks = new ArrayList<>();
    private static List<Reader> allReaders = new ArrayList<>();
    private static List<Order> allOrders = new ArrayList<>();

    public DataBase() {
        readBookList();
        readReaderList();
        readOrderList();
    }

    private static void readBookList() {
        try {
            FileInputStream fi = new FileInputStream(new File(BOOK_DATA_TXT));
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

    private static void readReaderList() {
        try {
            FileInputStream fi = new FileInputStream(new File(READER_DATA_TXT));
            ObjectInputStream oi = new ObjectInputStream(fi);

            int bookCounter = oi.readInt();
            for (int i = 0; i < bookCounter; i++) {
                allReaders.add((Reader) oi.readObject());
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

    private static void readOrderList() {
        try {
            FileInputStream fi = new FileInputStream(new File(ORDER_DATA_TXT));
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
    public static List<Reader> getAllReaders() {
        return allReaders;
    }
    public static List<Order> getAllOrders() {
        return allOrders;
    }

    public static void addBook(Book book) {
        allBooks.add(book);
    }
    public static void addReader(Reader reader) {
        allReaders.add(reader);
    }
    public static void addOrder(Order order) {
        allOrders.add(order);
    }

    private static void writeBookList() {
        try {
            FileOutputStream f = new FileOutputStream(new File(BOOK_DATA_TXT));
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

    private static void writeReaderList() {
        try {
            FileOutputStream f = new FileOutputStream(new File(READER_DATA_TXT));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeInt(allReaders.size());
            for (Reader reader : allReaders) {
                o.writeObject(reader);
            }
            o.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeOrderList() {
        try {
            FileOutputStream f = new FileOutputStream(new File(ORDER_DATA_TXT));
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

    public static void writeAll() {
        writeBookList();
        writeReaderList();
        writeOrderList();
    }
}
