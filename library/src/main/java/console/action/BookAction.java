package console.action;

import domain.Book;
import exception.ValidationException;
import service.BookService;
import service.impl.BookServiceImpl;

import java.sql.SQLDataException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookAction {
    private static final BookService service = new BookServiceImpl();

    public static void addBook() {
        try {
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
                System.out.println("Completed.");
            } else {
                System.out.println("Failed to create book.");
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateBookName() {
        try {
            Scanner scanner = new Scanner(System.in);
            Book book = new Book();

            System.out.println("Enter book's ID:");
            if (scanner.hasNext()) {
                book = service.read(scanner.nextInt());
                if (book == null) {
                    throw new SQLDataException("Invalid ID.");
                }
            }

            System.out.println("Enter book's new name:");
            if (scanner.hasNext()) {
                scanner.nextLine();
                book.setName(scanner.nextLine());
            }

            if (service.update(book)) {
                System.out.println("Completed.");
            } else {
                System.out.println("Failed to update book.");
            }
        } catch (ValidationException | SQLDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateBookAuthor() {
        try {
            Scanner scanner = new Scanner(System.in);
            Book book = new Book();

            System.out.println("Enter book's ID:");
            if (scanner.hasNext()) {
                book = service.read(scanner.nextInt());
                if (book == null) {
                    throw new SQLDataException("Invalid ID.");
                }
            }

            System.out.println("Enter book's new author's ID:");
            if (scanner.hasNext()) {
                scanner.nextLine();
                book.setAuthorID(scanner.nextInt());
            }

            if (service.update(book)) {
                System.out.println("Completed.");
            } else {
                System.out.println("Failed to update book.");
            }
        } catch(ValidationException | SQLDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateBookYear() {
        try {
            Scanner scanner = new Scanner(System.in);
            Book book = new Book();

            System.out.println("Enter book's ID:");
            if (scanner.hasNext()) {
                book = service.read(scanner.nextInt());
                if (book == null) {
                    throw new SQLDataException("Invalid ID.");
                }
            }

            System.out.println("Enter book's new year:");
            if (scanner.hasNext()) {
                scanner.nextLine();
                book.setYear(scanner.nextInt());
            }

            if (service.update(book)) {
                System.out.println("Completed.");
            } else {
                System.out.println("Failed to update book.");
            }
        } catch(ValidationException | SQLDataException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    public static void updateBookDescription() {
        try {
            Scanner scanner = new Scanner(System.in);
            Book book = new Book();

            System.out.println("Enter book's ID:");
            if (scanner.hasNext()) {
                book = service.read(scanner.nextInt());
                if (book == null) {
                    throw new SQLDataException("Invalid ID.");
                }
            }

            System.out.println("Enter book's new description:");
            if (scanner.hasNext()) {
                scanner.nextLine();
                book.setDescription(scanner.nextLine());
            }

            if (service.update(book)) {
                System.out.println("Completed.");
            } else {
                System.out.println("Failed to update book.");
            }
        } catch (ValidationException | SQLDataException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBook() {
        try {
            Scanner scanner = new Scanner(System.in);

            int id = 0;
            System.out.println("Enter book's ID:");
            if (scanner.hasNext()) {
                id = scanner.nextInt();
            }

            if (service.delete(id)) {
                System.out.println("Deleted successful.");
            } else {
                System.out.println("Failed to delete book.");
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    public static void listAllBooks() {
        service.listAllBooks();
    }

    public static void showBook(int id) {
        service.showBook(id);
    }

    public static void findBook() {
        Scanner scanner = new Scanner(System.in);

        int c;
        System.out.println("[1] by name\n[2] by author's ID\n[3] by year");
        c = scanner.nextInt();
        switch (c) {
            case 1: findByName(); break;
            case 2: findByAuthorID(); break;
            case 3: findByYear(); break;
            default: break;
        }
    }

    private static void findByName() {
        try {
            Scanner scanner = new Scanner(System.in);

            String name = null;
            System.out.println("Enter a name to find:");
            if (scanner.hasNext()) {
                name = scanner.nextLine();
            }
            System.out.println(service.findByName(name));

        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    private static void findByAuthorID() {
        try {
            Scanner scanner = new Scanner(System.in);

            int id = 0;
            System.out.println("Enter ID of the author:");
            if (scanner.hasNext()) {
                id = scanner.nextInt();
            }
            System.out.println(service.findByAuthorID(id));

        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    private static void findByYear() {
        try {
            Scanner scanner = new Scanner(System.in);

            int year = 0;
            System.out.println("Enter a year to find:");
            if (scanner.hasNext()) {
                year = scanner.nextInt();
            }
            System.out.println(service.findByYear(year));

        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }
}
