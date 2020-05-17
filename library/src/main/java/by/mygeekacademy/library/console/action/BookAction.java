package by.mygeekacademy.library.console.action;

import by.mygeekacademy.library.exception.ValidationException;
import by.mygeekacademy.library.service.BookService;
import by.mygeekacademy.library.service.impl.BookServiceImpl;
import by.mygeekacademy.library.domain.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLDataException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookAction {
    private static final BookService service = new BookServiceImpl();
    private static final Logger logger = LogManager.getLogger(BookAction.class.getName());
    private static final int PAGE_LENGTH = 5;

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

            service.create(book);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            logger.error(e.toString());
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

            service.update(book);
        } catch (ValidationException | SQLDataException e) {
            System.out.println(e.getMessage());
            logger.error(e.toString());
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

            service.update(book);
        } catch(ValidationException | SQLDataException e) {
            System.out.println(e.getMessage());
            logger.error(e.toString());
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

            service.update(book);
        } catch(ValidationException | SQLDataException e) {
            System.out.println(e.getMessage());
            logger.error(e.toString());
        } catch (InputMismatchException e) {
            e.printStackTrace();
            logger.error(e.toString());
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

            service.update(book);
        } catch (ValidationException | SQLDataException e) {
            System.out.println(e.getMessage());
            logger.error(e.toString());
        } catch (InputMismatchException e) {
            e.printStackTrace();
            logger.error(e.toString());
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

            Book book = service.read(id);
            if (book != null) {
                service.delete(book);
                System.out.println("Deleted successful.");
            }
            else {
                System.out.println("Failed to delete book.");
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
    }

    public static void listBooks() {
        Scanner scanner = new Scanner(System.in);
        int count = service.countAll();
        int pages;
        if (count % PAGE_LENGTH == 0) {
            pages = service.countAll() / PAGE_LENGTH;
        }
        else {
            pages = service.countAll() / PAGE_LENGTH + 1;
        }

        for (int i = 1; i <= pages; i++) {
            page(i, pages);
            System.out.println("[N] - NEXT PAGE, [Q] - EXIT");
            boolean indicator = true;
            while (indicator) {
                if (scanner.hasNext()) {
                    String result = scanner.nextLine();
                    switch (result) {
                        case "N":
                        case "n":
                            indicator = false;
                            break;
                        case "Q":
                        case "q":
                            indicator = false;
                            i = pages;
                            break;
                        default:
                            System.out.println("Try again.");
                            break;
                    }
                }
            }
        }
    }

    private static void page(int number, int pages) {
        System.out.println("\n[ PAGE " + number + " OF " + pages + " ]");
        service.listPage(number);
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
            logger.error(e.toString());
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
            logger.error(e.toString());
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
            logger.error(e.toString());
        }
    }
}
