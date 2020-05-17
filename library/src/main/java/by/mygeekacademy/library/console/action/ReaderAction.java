package by.mygeekacademy.library.console.action;

import by.mygeekacademy.library.exception.ValidationException;
import by.mygeekacademy.library.service.ReaderService;
import by.mygeekacademy.library.service.impl.ReaderServiceImpl;
import by.mygeekacademy.library.domain.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLDataException;
import java.util.Scanner;

public class ReaderAction {
    private static final ReaderService service = new ReaderServiceImpl();
    private static final Logger logger = LogManager.getLogger(ReaderAction.class.getName());

    public static void addReader() {
        try {
            Scanner scanner = new Scanner(System.in);
            Reader reader = new Reader();

            System.out.println("Enter reader's name:");
            if (scanner.hasNext()) {
                reader.setName(scanner.nextLine());
            }

            System.out.println("Enter reader's 2nd name:");
            if (scanner.hasNext()) {
                reader.setSecondName(scanner.nextLine());
            }

            service.create(reader);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            logger.error(e.toString());
        }
    }

    public static void updateReader() {
        try {
            Scanner scanner = new Scanner(System.in);
            Reader reader = new Reader();

            System.out.println("Enter reader's ID:");
            if (scanner.hasNext()) {
                reader = service.read(scanner.nextInt());
                if (reader == null) {
                    throw new SQLDataException("Invalid ID.");
                }
            }
            System.out.println("Enter reader's new name:");
            if (scanner.hasNext()) {
                scanner.nextLine();
                reader.setName(scanner.nextLine());
            }
            System.out.println("Enter reader's new 2nd name:");
            if (scanner.hasNext()) {
                reader.setSecondName(scanner.nextLine());
            }

            service.update(reader);
        } catch (ValidationException | SQLDataException e) {
            System.out.println(e.getMessage());
            logger.error(e.toString());
        }
    }

    public static void deleteReader() {
        Scanner scanner = new Scanner(System.in);

        int id = 0;
        System.out.println("Enter reader's ID:");
        if (scanner.hasNext()) {
            id = scanner.nextInt();
        }

        Reader reader = service.read(id);
        if (reader != null) {
            service.delete(reader);
            System.out.println("Deleted successful.");
        }
        else {
            System.out.println("Failed to delete reader.");
        }
    }

    public static void listAllReaders() {
        service.listAllReaders();
    }

    public static void showReader(int id) {
        service.showReader(id);
    }
}
