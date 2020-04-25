package console;

import console.action.ReaderAction;

import java.util.Scanner;

public class ReaderSubMenu {
    public static void showReaderSubMenu(Scanner ui) {
        int c;
        while (true) {
            System.out.println("\n---------Reader menu---------");
            System.out.println("\n[1] Create new reader\n" + "[2] Update reader's info\n" +
                    "[3] Delete reader\n" + "[4] List all readers\n");
            System.out.println("\n[6] BACK");
            System.out.print("\nEnter your choice: ");
            c = ui.nextInt();

            switch (c) {
                case 1:
                    ReaderAction.addReader();
                    break;
                case 2:
                    ReaderAction.updateReader();
                    break;
                case 3:
                    ReaderAction.deleteReader();
                    break;
                case 4:
                    ReaderAction.listAllReaders();
                    break;
                case 5:
                    Menu.showMainMenu();
                    break;
                default:
                    System.out.println("Try again.");
            }
        }
    }
}
