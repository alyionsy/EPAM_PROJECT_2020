package by.mygeekacademy.library.console.action;

import by.mygeekacademy.library.domain.Author;
import by.mygeekacademy.library.exception.ValidationException;
import by.mygeekacademy.library.service.AuthorService;
import by.mygeekacademy.library.service.impl.AuthorServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLDataException;
import java.util.Scanner;

public class AuthorAction {
    private static final AuthorService service = new AuthorServiceImpl();
    private static final Logger logger = LogManager.getLogger(AuthorAction.class.getName());
    private static final int PAGE_LENGTH = 7;

    public static void addAuthor() {
        try {
            Scanner scanner = new Scanner(System.in);
            Author author = new Author();

            System.out.println("Enter author's name:");
            if (scanner.hasNext()) {
                author.setName(scanner.nextLine());
            }

            System.out.println("Enter author's 2nd name:");
            if (scanner.hasNext()) {
                author.setSecondName(scanner.nextLine());
            }

            service.create(author);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            logger.error(e.toString());
        }
    }

    public static void updateAuthor() {
        try {
            Scanner scanner = new Scanner(System.in);
            Author author = new Author();

            System.out.println("Enter author's ID:");
            if (scanner.hasNext()) {
                author = service.read(scanner.nextInt());
                if (author == null) {
                    throw new SQLDataException("Invalid ID.");
                }
            }
            System.out.println("Enter author's new name:");
            if (scanner.hasNext()) {
                scanner.nextLine();
                author.setName(scanner.nextLine());
            }
            System.out.println("Enter author's new 2nd name:");
            if (scanner.hasNext()) {
                author.setSecondName(scanner.nextLine());
            }

            service.update(author);
        } catch (ValidationException | SQLDataException e) {
            System.out.println(e.getMessage());
            logger.error(e.toString());
        }
    }

    public static void deleteAuthor() {
        Scanner scanner = new Scanner(System.in);

        int id = 0;
        System.out.println("Enter author's ID:");
        if (scanner.hasNext()) {
            id = scanner.nextInt();
        }

        Author author = service.read(id);
        if (author != null) {
            service.delete(author);
            System.out.println("Deleted successful.");
        }
        else {
            System.out.println("Failed to delete author.");
        }
    }

    public static void listAuthors() {
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

    public static void showAuthor(int id) {
        service.showAuthor(id);
    }

    public static void showAllAuthors() {
        service.listAllAuthors();
    }

}
