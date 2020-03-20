package console;

import console.actions.BookActions;
import console.actions.BookOwnerActions;
import console.actions.OrderActions;
import domain.DataBase;

import java.util.Scanner;

public class Menu {
    int c;
    public void ShowMainMenu() {
        BookActions bookActions = new BookActions();
        BookOwnerActions bookOwnerActions = new BookOwnerActions();
        OrderActions orderActions = new OrderActions();
        Scanner ui = new Scanner(System.in);
        while (true) {
            System.out.println("-----Main menu------");
            System.out.println("1. Add new book");
            System.out.println("2. Update book's name");
            System.out.println("3. Update book's author");
            System.out.println("4. Update book's description");
            System.out.println("5. Delete book");
            System.out.println("6. Add new owner");
            System.out.println("7. Update owner's info");
            System.out.println("8. Delete owner");
            System.out.println("9. Update order");
            System.out.println("10. EXIT");
            System.out.print("Enter choice"); c = ui.nextInt();

            switch(c) {
                case 1 : BookActions.addBook(); break;
                case 2 : BookActions.updateBookName(); break;
                case 3 : BookActions.updateBookAuthor(); break;
                case 4 : BookActions.updateBookDescription(); break;
                case 5 : BookActions.deleteBook(); break;
                case 6: BookOwnerActions.addBookOwner(); break;
                case 7: BookOwnerActions.updateBookOwner(); break;
                case 8: BookOwnerActions.deleteBookOwner(); break;
                case 9: OrderActions.updateOrder(); break;
                case 10 : System.out.println("Leaving the program now..."); System.exit(0); break;
                default : System.out.println("error.");
            }

        }

    }
}
