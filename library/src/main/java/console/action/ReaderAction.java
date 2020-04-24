package console.action;

import domain.Reader;
import service.ReaderService;
import service.impl.ReaderServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class ReaderAction {

    private static ReaderService service = new ReaderServiceImpl();

    public static void addReader() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter reader's name:");
        Reader reader = new Reader();
        if (scanner.hasNext()) {
            reader.setReaderName(scanner.nextLine());
        }

        System.out.println("Enter book reader's 2nd name:");
        if (scanner.hasNext()) {
            reader.setReaderSecondName(scanner.nextLine());
        }

        reader = service.create(reader);

        System.out.println(reader);
    }

    public static void updateReader() throws IOException {
        Scanner scanner = new Scanner(System.in);

        Reader reader = new Reader();
        System.out.println("Enter book reader's ID:");
        if (scanner.hasNext()) {
            reader = service.read(scanner.nextLong());
        }
        System.out.println("Enter book's new name:");
        if (scanner.hasNext()) {
            scanner.nextLine();
            reader.setReaderName(scanner.nextLine());
        }
        System.out.println("Enter book's new 2nd name:");
        if (scanner.hasNext()) {
            reader.setReaderSecondName(scanner.nextLine());
        }

        reader = service.update(reader);

        System.out.println(reader);
    }

    public static void deleteReader() throws IOException {
        Scanner scanner = new Scanner(System.in);

        Reader reader = new Reader();
        System.out.println("Enter book owner's ID:");
        if (scanner.hasNext()) {
            reader = service.read(scanner.nextLong());
        }
        service.delete(reader);
    }

    public static void listAllReaders() throws IOException, ClassNotFoundException {
        service.listAllReaders();
    }
}
