package console.action;

import domain.Book;
import domain.BookOwner;
import service.BookOwnerService;
import service.impl.BookOwnerServiceImpl;

import java.util.Scanner;

public class BookOwnerAction {

    private static BookOwnerService service = new BookOwnerServiceImpl();

    public static void addBookOwner() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book owner's name:");
        BookOwner owner = new BookOwner();
        if (scanner.hasNext()) {
            owner.setBookOwnerName(scanner.next());
        }

        System.out.println("Enter book owner's 2nd name:");
        if (scanner.hasNext()) {
            owner.setBookOwnerSecondName(scanner.next());
        }

        System.out.println("Enter book owner's reading number:");
        if (scanner.hasNext()) {
            owner.setBookOwnerNumber(scanner.next());
        }

        owner = service.create(owner);

        System.out.println(owner);
    }
    public static void updateBookOwner() {
        Scanner scanner = new Scanner(System.in);

        BookOwner owner = new BookOwner();
        System.out.println("Enter book owner's number:");
        if (scanner.hasNext()) {
            owner = service.findByNumber(scanner.next());
        }
        System.out.println("Enter book's new name:");
        if (scanner.hasNext()) {
            owner.setBookOwnerName(scanner.next());
        }
        System.out.println("Enter book's new 2nd name:");
        if (scanner.hasNext()) {
            owner.setBookOwnerSecondName(scanner.next());
        }

        owner = service.update(owner);

        System.out.println(owner);
    }
    public static void deleteBookOwner() {
        Scanner scanner = new Scanner(System.in);

        BookOwner owner = new BookOwner();
        System.out.println("Enter book owner's reading number:");
        if (scanner.hasNext()) {
            owner = service.findByNumber(scanner.next());
        }
        service.delete(owner);
    }
}
