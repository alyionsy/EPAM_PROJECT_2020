package main.java.run;

import main.java.console.Menu;
import main.java.domain.DataBase;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataBase db = new DataBase();
        Menu menu = new Menu();
        menu.ShowMainMenu();
    }
}
