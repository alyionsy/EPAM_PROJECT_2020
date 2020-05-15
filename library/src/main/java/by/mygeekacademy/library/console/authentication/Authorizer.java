package by.mygeekacademy.library.console.authentication;

import by.mygeekacademy.library.service.LibrarianService;
import by.mygeekacademy.library.service.impl.LibrarianServiceImpl;
import java.util.Scanner;

public class Authorizer {
    private static final LibrarianService service = new LibrarianServiceImpl();

    public static void authentication() {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";
        boolean indicator = true;
        while (indicator) {
            System.out.println("Username: ");
            if (scanner.hasNextLine()) {
                username = scanner.nextLine();
            }
            System.out.println("Password: ");
            if (scanner.hasNextLine()) {
                password = scanner.nextLine();
            }

            if (service.findLibrarian(username, password)) {
                indicator = false;
            }
            else {
                System.out.println("Invalid password or username. Try again.");
            }
        }

    }
}
