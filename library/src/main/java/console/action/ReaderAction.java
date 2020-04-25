package console.action;

import domain.Reader;
import exception.ValidationException;
import service.ReaderService;
import service.impl.ReaderServiceImpl;

import java.sql.SQLDataException;
import java.util.Scanner;

public class ReaderAction {
    private static final ReaderService service = new ReaderServiceImpl();

    public static void addReader() {
        try {
            Scanner scanner = new Scanner(System.in);
            Reader reader = new Reader();

            System.out.println("Enter reader's name:");
            if (scanner.hasNext()) {
                reader.setReaderName(scanner.nextLine());
            }

            System.out.println("Enter reader's 2nd name:");
            if (scanner.hasNext()) {
                reader.setReaderSecondName(scanner.nextLine());
            }

            if (service.create(reader)) {
                System.out.println("Completed.");
            } else {
                System.out.println("Failed to create reader.");
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
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
                reader.setReaderName(scanner.nextLine());
            }
            System.out.println("Enter reader's new 2nd name:");
            if (scanner.hasNext()) {
                reader.setReaderSecondName(scanner.nextLine());
            }

            if (service.update(reader)) {
                System.out.println("Completed.");
            } else {
                System.out.println("Failed to update reader.");
            }
        } catch (ValidationException | SQLDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteReader() {
        Scanner scanner = new Scanner(System.in);

        int id = 0;
        System.out.println("Enter reader's ID:");
        if (scanner.hasNext()) {
            id = scanner.nextInt();
        }

        if (service.delete(id)) {
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
