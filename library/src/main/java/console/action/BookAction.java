package console.action;

import domain.Book;
import service.BookService;
import service.impl.BookServiceImpl;
import java.util.Scanner;

public class BookAction {
    private static final BookService service = new BookServiceImpl();

    public static void addBook() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();

        System.out.println("Enter book's name:");
        if (scanner.hasNext()) {
            book.setName(scanner.nextLine());
        }

        System.out.println("Enter book's author ID:");
        if (scanner.hasNext()) {
            book.setAuthorID(scanner.nextInt());
        }

        System.out.println("Enter book's year:");
        if (scanner.hasNext()) {
            book.setYear(scanner.nextInt());
        }

        System.out.println("Enter book's description:");
        if (scanner.hasNext()) {
            scanner.nextLine();
            book.setDescription(scanner.nextLine());
        }

        if (service.create(book)) {
            System.out.println(book);
        }
        else {
            System.out.println("Failed to create book.");
        }
    }

    public static void updateBookName() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();

        System.out.println("Enter book's ID:");
        if (scanner.hasNext()) {
            book = service.read(scanner.nextInt());
        }

        System.out.println("Enter book's new name:");
        if (scanner.hasNext()) {
            scanner.nextLine();
            book.setName(scanner.nextLine());
        }

        if (service.update(book)) {
            System.out.println(book);
        }
        else {
            System.out.println("Failed to update book.");
        }
    }

    public static void updateBookAuthor() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();

        System.out.println("Enter book's ID:");
        if (scanner.hasNext()) {
            book = service.read(scanner.nextInt());
        }

        System.out.println("Enter book's new author:");
        if (scanner.hasNext()) {
            scanner.nextLine();
            book.setAuthorID(scanner.nextInt());
        }

        if (service.update(book)) {
            System.out.println(book);
        }
        else {
            System.out.println("Failed to update book.");
        }
    }

    public static void updateBookDescription() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();

        System.out.println("Enter book's ID:");
        if (scanner.hasNext()) {
            book = service.read(scanner.nextInt());
        }

        System.out.println("Enter book's new description:");
        if (scanner.hasNext()) {
            scanner.nextLine();
            book.setDescription(scanner.nextLine());
        }

        if (service.update(book)) {
            System.out.println(book);
        }
        else {
            System.out.println("Failed to update book.");
        }
    }

    public static void deleteBook() {
        Scanner scanner = new Scanner(System.in);

        int id = 0;
        System.out.println("Enter book's ID:");
        if (scanner.hasNext()) {
            id = scanner.nextInt();
        }

        if (service.delete(id)) {
            System.out.println("Deleted successful.");
        }
        else {
            System.out.println("Failed to delete book.");
        }
    }

    public static void listAllBooks() {
        service.listAllBooks();
    }

    public static void showBook(int id) {
        service.showBook(id);
    }
}
