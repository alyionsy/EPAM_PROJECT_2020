package by.mygeekacademy.library.console.submenu;

import by.mygeekacademy.library.console.Menu;
import by.mygeekacademy.library.console.action.BookAction;

import java.util.Scanner;

public class BookSubMenu {
    public static void showBookSubMenu(Scanner ui) {
        int c;
        while (true) {
            System.out.println("\n---------Book menu---------");
            System.out.println("[1] Create new book\n" + "[2] Update book's name\n" +
                    "[3] Update book's author\n" + "[4] Update book's year\n" + "[5] Update book's description\n" +
                    "[6] Find books\n" + "[7] Delete book\n" + "[8] List all books");
            System.out.println("\n[9] BACK");
            System.out.print("\nEnter your choice: ");
            c = ui.nextInt();

            switch (c) {
                case 1:
                    BookAction.addBook();
                    break;
                case 2:
                    BookAction.updateBookName();
                    break;
                case 3:
                    BookAction.updateBookAuthor();
                    break;
                case 4:
                    BookAction.updateBookYear();
                    break;
                case 5:
                    BookAction.updateBookDescription();
                    break;
                case 6:
                    BookAction.findBook();
                    break;
                case 7:
                    BookAction.deleteBook();
                    break;
                case 8:
                    BookAction.listBooks();
                    break;
                case 9:
                    Menu.showMainMenu();
                    break;
                default:
                    System.out.println("Try again.");
            }
        }
    }
}
