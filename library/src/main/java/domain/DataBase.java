package main.java.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        Logger logger = LogManager.getLogger();
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
            logger.error("File not found");
        } catch (IOException e) {
            logger.error("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.info("Books are read.");
    }

    private static void readReaderList() {
        Logger logger = LogManager.getLogger();
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
            logger.error("File not found");
        } catch (IOException e) {
            logger.error("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.info("Readers are read.");
    }

    private static void readOrderList() {
        Logger logger = LogManager.getLogger();
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
            logger.error("File not found");
        } catch (IOException e) {
            logger.error("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.info("Orders are read.");
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
        Logger logger = LogManager.getLogger();
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
        logger.info("Books are written.");
    }

    private static void writeReaderList() {
        Logger logger = LogManager.getLogger();
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
        logger.info("Readers are written.");
    }

    private static void writeOrderList() {
        Logger logger = LogManager.getLogger();
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
        logger.info("Orders are written.");
    }

    public static void writeAll() {
        Logger logger = LogManager.getLogger();
        writeBookList();
        writeReaderList();
        writeOrderList();
        logger.info("Everything is written.");
    }
}
