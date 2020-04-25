package console;

import console.action.OrderAction;

import java.util.Scanner;

public class OrderSubMenu {
    public static void showOrderSubMenu(Scanner ui) {
        int c;
        while (true) {
            System.out.println("\n---------Order menu---------");
            System.out.println("\n[1] Create new order\n" + "[2] Update order\n"
                    + "[3] Find orders\n" + "[4] Delete order\n" + "[5] List orders\n");
            System.out.println("\n[6] BACK");
            System.out.print("\nEnter your choice: ");
            c = ui.nextInt();

            switch (c) {
                case 1:
                    OrderAction.addOrder();
                    break;
                case 2:
                    OrderAction.updateOrder();
                    break;
                case 3:
                    OrderAction.findOrder();
                    break;
                case 4:
                    OrderAction.deleteOrder();
                    break;
                case 5:
                    OrderAction.listAllOrders();
                    break;
                case 6:
                    Menu.showMainMenu();
                    break;
                default:
                    System.out.println("Try again.");
            }
        }
    }
}
