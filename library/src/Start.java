import console.Menu;
import domain.DataBase;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DataBase db = new DataBase();
        Menu menu = new Menu();
        menu.ShowMainMenu();
    }
}
