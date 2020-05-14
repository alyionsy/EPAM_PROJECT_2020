package by.mygeekacademy.library.run;

import by.mygeekacademy.library.console.Menu;

import java.util.InputMismatchException;

public class Start {
    public static void main(String[] args) {
        try {
            Menu.showMainMenu();
        } catch (InputMismatchException e) {
            System.out.println("Input error.");
        }
    }
}
