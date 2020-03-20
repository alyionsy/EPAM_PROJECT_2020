package console;

import console.action.BookAction;
import console.action.BookOwnerAction;
import console.action.OrderAction;
import domain.DataBase;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    int c;
    public void ShowMainMenu() throws FileNotFoundException {
        Scanner ui = new Scanner(System.in);
        while (true) {
            System.out.println("------Main menu------");
//            System.out.println("1. Add new book");
//            System.out.println("2. Update book's name");
//            System.out.println("3. Update book's author");
//            System.out.println("4. Update book's description");
//            System.out.println("5. Delete book");
//            System.out.println("6. Add new owner");
//            System.out.println("7. Update owner's info");
//            System.out.println("8. Delete owner");
//            System.out.println("9. Create order");
//            System.out.println("10. Update order");
//            System.out.println("11. Delete order");
//            System.out.println("12. EXIT");
            System.out.println("Books: 1. Add new book;" + " 2. Update book's name; "
                    + "3. Update book's author; " + "4. Update book's description; "
                    + "5. Delete book;");
            System.out.println("\nBook Owners: 6. Add new owner; " + "7. Update owner's info; "
                    + "8. Delete owner;");
            System.out.println("\nOrders: 9. Create order; " + "10. Update order; "
                    + "11. Delete order");
            System.out.println("\n12. EXIT");
            System.out.print("\nEnter your choice: "); c = ui.nextInt();

            switch(c) {
                case 1 : BookAction.addBook(); break;
                case 2 : BookAction.updateBookName(); break;
                case 3 : BookAction.updateBookAuthor(); break;
                case 4 : BookAction.updateBookDescription(); break;
                case 5 : BookAction.deleteBook(); break;
                case 6: BookOwnerAction.addBookOwner(); break;
                case 7: BookOwnerAction.updateBookOwner(); break;
                case 8: BookOwnerAction.deleteBookOwner(); break;
                case 9: OrderAction.updateOrder(); break;
                case 10: OrderAction.updateOrder(); break;
                case 11: OrderAction.updateOrder(); break;
                case 12 : System.out.println("Leaving the program now..."); DataBase.writeAll(); System.exit(0); break;
                default : System.out.println("error.");
            }

        }

    }
}
