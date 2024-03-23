import App.DB;

import static java.lang.Thread.sleep;
import java.util.*;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello! Welcome to the Warhouse App");
        System.out.println("We are making a connection to the database... please be patient");
        Thread.sleep(2000);
        System.out.println("Done! Connection established");
        System.out.println("This app made by Abdullajonov Boburjon! Type \"/help\" to see all aviable comand");
//      # Listen the console xD
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("/help")) {
                System.out.println("Wassup bro! Here is the list of all aviable commands");
            }
        }
    }
}
