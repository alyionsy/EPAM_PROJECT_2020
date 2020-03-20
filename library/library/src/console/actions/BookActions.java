package console.actions;

import domain.Book;
import service.BookService;
import service.impl.BookServiceImpl;

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

        System.out.println("Enter book's new author:");
        Book book = new Book();
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
            book.setAuthor(scanner.next());
        }

        book = service.update(book);

        System.out.println(book);
    }

    public static void deleteBook() {}
}
