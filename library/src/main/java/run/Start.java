package run;

import console.Menu;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Menu menu = new Menu();
        menu.ShowMainMenu();
    }
}
