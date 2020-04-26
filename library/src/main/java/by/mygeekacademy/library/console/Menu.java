package by.mygeekacademy.library.console;

import by.mygeekacademy.library.console.submenu.AuthorSubMenu;
import by.mygeekacademy.library.console.submenu.BookSubMenu;
import by.mygeekacademy.library.console.submenu.OrderSubMenu;
import by.mygeekacademy.library.console.submenu.ReaderSubMenu;

import java.util.Scanner;

public class Menu {
    public static void showMainMenu() {
        int c;
        Scanner ui = new Scanner(System.in);
        while (true) {
            System.out.println("\n---------Main menu---------");
            System.out.println("[1] Authors\n" + "[2] Books\n"
                    + "[3] Readers\n" + "[4] Orders");
            System.out.println("\n[5] EXIT");
            System.out.print("\nEnter your choice: "); c = ui.nextInt();

            switch(c) {
                case 1: AuthorSubMenu.showAuthorSubMenu(ui); break;
                case 2: BookSubMenu.showBookSubMenu(ui); break;
                case 3: ReaderSubMenu.showReaderSubMenu(ui); break;
                case 4: OrderSubMenu.showOrderSubMenu(ui); break;
                case 5: System.out.println("Leaving the program now..."); System.exit(0); break;
                default: System.out.println("error.");
            }
        }

    }
}
