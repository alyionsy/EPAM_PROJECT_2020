package console.action;

import domain.Book;
import domain.BookOwner;
import service.BookOwnerService;
import service.impl.BookOwnerServiceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BookOwnerAction {

    private static BookOwnerService service = new BookOwnerServiceImpl();

    public static void addBookOwner() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book owner's name:");
        BookOwner owner = new BookOwner();
        if (scanner.hasNext()) {
            owner.setBookOwnerName(scanner.nextLine());
        }

        System.out.println("Enter book owner's 2nd name:");
        if (scanner.hasNext()) {
            owner.setBookOwnerSecondName(scanner.nextLine());
        }

        owner = service.create(owner);

        System.out.println(owner);
    }

    public static void updateBookOwner() {
        Scanner scanner = new Scanner(System.in);

        BookOwner owner = new BookOwner();
        System.out.println("Enter book owner's ID:");
        if (scanner.hasNext()) {
            owner = service.read(scanner.nextLong());
        }
        System.out.println("Enter book's new name:");
        if (scanner.hasNext()) {
            scanner.nextLine();
            owner.setBookOwnerName(scanner.nextLine());
        }
        System.out.println("Enter book's new 2nd name:");
        if (scanner.hasNext()) {
            owner.setBookOwnerSecondName(scanner.nextLine());
        }

        owner = service.update(owner);

        System.out.println(owner);
    }

    public static void deleteBookOwner() throws IOException {
        Scanner scanner = new Scanner(System.in);

        BookOwner owner = new BookOwner();
        System.out.println("Enter book owner's ID:");
        if (scanner.hasNext()) {
            owner = service.read(scanner.nextLong());
        }
        service.delete(owner);
    }

    public static void listAllOwners() throws IOException, ClassNotFoundException {
        service.listAllOwners();
    }
}
