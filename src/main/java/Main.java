import App.DB;
import App.Functions;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Functions.helloMsg();

        // Listen CMD
        while(true){
            Scanner scan = new Scanner(System.in);
            String command = scan.nextLine();
            // need to read the steps.txt file to know the last step
            String lastStep = String.valueOf(Functions.readSteps());

            if (command.equals("/exit")) {
                Functions.bye();
                System.exit(0);
            } else if (command.equals("/search")) {
                System.out.println("What are you looking for?");
                Functions.writeSteps("search");
            } else {
                Functions.showError("OOPS...Command not found, try again!");
            }
            if (scan.hasNext() && lastStep.equals("search")) {
                System.out.println("It's working!");
            }
        }
    }
}
