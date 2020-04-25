package console.action;

import domain.Author;
import domain.Reader;
import service.AuthorService;
import service.ReaderService;
import service.impl.AuthorServiceImpl;
import service.impl.ReaderServiceImpl;

import java.util.Scanner;

public class AuthorAction {
    private static final AuthorService service = new AuthorServiceImpl();

    public static void addAuthor() {
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
            System.out.println(author);
        }
        else {
            System.out.println("Failed to create author.");
        }
    }

    public static void updateReader() {
        Scanner scanner = new Scanner(System.in);
        Author author = new Author();

        System.out.println("Enter author's ID:");
        if (scanner.hasNext()) {
            author = service.read(scanner.nextInt());
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
            System.out.println(author);
        }
        else {
            System.out.println("Failed to update reader.");
        }
    }

    public static void deleteReader() {
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
