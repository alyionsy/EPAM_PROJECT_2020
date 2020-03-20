package console.actions;

import domain.Book;
import domain.DataBase;
import service.BookService;
import service.impl.BookServiceImpl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class BookActions {

    private static BookService service = new BookServiceImpl();

    public static void addBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book's name:");
        Book book = new Book();
        if (scanner.hasNext()) {
            book.setName(scanner.next());
        }

        System.out.println("Enter book's author:");
        if (scanner.hasNext()) {
            book.setAuthor(scanner.next());
        }

        book = service.create(book);

        System.out.println(book);
    }

    public static void updateBookName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book's new name:");
        Book book = new Book();
        if (scanner.hasNext()) {
            book.setName(scanner.next());
        }

        book = service.update(book);

        System.out.println(book);
    }

    public static void updateBookAuthor() {
        Scanner scanner = new Scanner(System.in);

        Book book = new Book();
        System.out.println("Enter book's name:");
        if (scanner.hasNext()) {
            book = service.findByName(scanner.next());
        }
        System.out.println("Enter book's new author:");
        if (scanner.hasNext()) {
            book.setAuthor(scanner.next());
        }

        book = service.update(book);

        System.out.println(book);
    }

    public static void updateBookDescription() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book's new description:");
        Book book = new Book();
        if (scanner.hasNext()) {
            book.setDescription(scanner.next());
        }

        book = service.update(book);

        System.out.println(book);
    }

    public static void deleteBook() {
        Scanner scanner = new Scanner(System.in);

        Book book = new Book();
        System.out.println("Enter book's name:");
        if (scanner.hasNext()) {
            book = service.findByName(scanner.next());
        }
        service.delete(book);
    }
}
