package console;

import console.action.BookAction;
import console.action.BookOwnerAction;
import console.action.OrderAction;
import domain.DataBase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    int c;
    public void ShowMainMenu() throws IOException, ClassNotFoundException {
        Scanner ui = new Scanner(System.in);
        while (true) {
            System.out.println("\n------Main menu------");
            System.out.println("Books:\n[1] Add new book\n" + "[2] Update book's name\n"
                    + "[3] Update book's author\n" + "[4] Update book's description\n"
                    + "[5] Delete book\n" + "[6] List all books");
            System.out.println("Book Owners:\n[7] Add new owner\n" + "[8] Update owner's info\n"
                    + "[9] Delete owner\n" + "[10] List all owners");
            System.out.println("Orders:\n[11] Create order\n" + "[12] Update order\n"
                    + "[13] Delete order\n" + "[14] List orders");
            System.out.println("\n[15] EXIT");
            System.out.print("\nEnter your choice: "); c = ui.nextInt();

            switch(c) {
                case 1: BookAction.addBook(); break;
                case 2: BookAction.updateBookName(); break;
                case 3: BookAction.updateBookAuthor(); break;
                case 4: BookAction.updateBookDescription(); break;
                case 5: BookAction.deleteBook(); break;
                case 6: BookAction.listAllBooks(); break;
                case 7: BookOwnerAction.addBookOwner(); break;
                case 8: BookOwnerAction.updateBookOwner(); break;
                case 9: BookOwnerAction.deleteBookOwner(); break;
                case 10: BookOwnerAction.listAllOwners(); break;
                case 11: OrderAction.addOrder(); break;
                case 12: OrderAction.updateOrder(); break;
                case 13: OrderAction.deleteOrder(); break;
                case 14: OrderAction.listAllOrders(); break;
                case 15: System.out.println("Leaving the program now..."); DataBase.writeAll(); System.exit(0); break;
                default: System.out.println("error.");
            }
        }

    }
}
