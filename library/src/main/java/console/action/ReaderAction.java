package console.action;

import domain.Reader;
import service.ReaderService;
import service.impl.ReaderServiceImpl;

import java.util.Scanner;

public class ReaderAction {
    private static final ReaderService service = new ReaderServiceImpl();

    public static void addReader() {
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
            System.out.println(reader);
        }
        else {
            System.out.println("Failed to create reader.");
        }
    }

    public static void updateReader() {
        Scanner scanner = new Scanner(System.in);
        Reader reader = new Reader();

        System.out.println("Enter reader's ID:");
        if (scanner.hasNext()) {
            reader = service.read(scanner.nextInt());
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
            System.out.println(reader);
        }
        else {
            System.out.println("Failed to update reader.");
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
