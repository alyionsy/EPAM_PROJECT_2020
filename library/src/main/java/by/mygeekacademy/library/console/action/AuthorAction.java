package by.mygeekacademy.library.console.action;

import by.mygeekacademy.library.dao.impl.ReaderDAOImpl;
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

            if (service.create(author)) {
                System.out.println("Completed.");
            } else {
                System.out.println("Failed to create author.");
            }
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

            if (service.update(author)) {
                System.out.println("Completed.");
            } else {
                System.out.println("Failed to update reader.");
            }
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

        if (service.delete(id)) {
            System.out.println("Deleted successful.");
        }
        else {
            System.out.println("Failed to delete author.");
        }
    }

    public static void listAllAuthors() {
        service.listAllAuthors();
    }

    public static void showAuthor(int id) {
        service.showAuthor(id);
    }
}
