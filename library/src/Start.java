import console.Menu;
import domain.DataBase;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataBase db = new DataBase();
        Menu menu = new Menu();
        menu.ShowMainMenu();
//        DataBase db = new DataBase();
//        System.out.println(db.getAllBooks().toString());
    }
}
