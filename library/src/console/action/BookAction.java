package console.action;

import domain.Book;
import service.BookService;
import service.impl.BookServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class BookAction {

    private static BookService service = new BookServiceImpl();

    public static void addBook() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book's name:");
        Book book = new Book();
        if (scanner.hasNext()) {
            book.setName(scanner.nextLine());
        }

        System.out.println("Enter book's author:");
        if (scanner.hasNext()) {
            book.setAuthor(scanner.nextLine());
        }

        System.out.println("Enter book's description:");
        if (scanner.hasNext()) {
            book.setDescription(scanner.nextLine());
        }

        book = service.create(book);

        System.out.println(book);
    }

    public static void updateBookName() throws IOException {
        Scanner scanner = new Scanner(System.in);

        Book book = new Book();
        System.out.println("Enter book's ID:");
        if (scanner.hasNext()) {
            book = service.read(scanner.nextLong());
        }
        System.out.println("Enter book's new name:");
        if (scanner.hasNext()) {
            scanner.nextLine();
            book.setName(scanner.nextLine());
        }

        book = service.update(book);

        System.out.println(book);
    }

    public static void updateBookAuthor() throws IOException {
        Scanner scanner = new Scanner(System.in);

        Book book = new Book();
        System.out.println("Enter book's ID:");
        if (scanner.hasNext()) {
            book = service.read(scanner.nextLong());
        }
        System.out.println("Enter book's new author:");
        if (scanner.hasNext()) {
            scanner.nextLine();
            book.setAuthor(scanner.nextLine());
        }

        book = service.update(book);

        System.out.println(book);
    }

    public static void updateBookDescription() throws IOException {
        Scanner scanner = new Scanner(System.in);

        Book book = new Book();
        System.out.println("Enter book's ID:");
        if (scanner.hasNext()) {
            book = service.read(scanner.nextLong());
        }
        System.out.println("Enter book's new description:");
        if (scanner.hasNext()) {
            scanner.nextLine();
            book.setDescription(scanner.nextLine());
        }

        book = service.update(book);

        System.out.println(book);
    }

    public static void deleteBook() throws IOException {
        Scanner scanner = new Scanner(System.in);

        Book book = new Book();
        System.out.println("Enter book's ID:");
        if (scanner.hasNext()) {
            book = service.read(scanner.nextLong());
        }
        service.delete(book);
    }

    public static void listAllBooks() throws IOException, ClassNotFoundException {
        service.listAllBooks();
    }
}
