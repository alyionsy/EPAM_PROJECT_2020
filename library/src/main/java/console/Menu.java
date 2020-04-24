package main.java.console;

import main.java.console.action.BookAction;
import main.java.console.action.ReaderAction;
import main.java.console.action.OrderAction;

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
            System.out.println("Readers:\n[7] Add new reader\n" + "[8] Update reader's info\n"
                    + "[9] Delete reader\n" + "[10] List all readers");
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
                case 7: ReaderAction.addReader(); break;
                case 8: ReaderAction.updateReader(); break;
                case 9: ReaderAction.deleteReader(); break;
                case 10: ReaderAction.listAllReaders(); break;
                case 11: OrderAction.addOrder(); break;
                case 12: OrderAction.updateOrder(); break;
                case 13: OrderAction.deleteOrder(); break;
                case 14: OrderAction.listAllOrders(); break;
                case 15: System.out.println("Leaving the program now..."); System.exit(0); break;
                default: System.out.println("error.");
            }
        }

    }
}
