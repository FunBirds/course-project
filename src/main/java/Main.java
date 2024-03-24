import App.Controllers.ProductController;
import App.Functions;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Functions.helloMsg();
        Functions.writeSteps("");
        // Listen CMD
        Scanner scan = new Scanner(System.in);
        while(true){
            String command = scan.nextLine();
            // need to read the steps.txt file to know the last step
            String lastStep = String.valueOf(Functions.readSteps());
            if (command.isEmpty()){
                System.out.println("Hmm... you are just clicking enter, see /help for available commands!");
                continue;
            }
            //check if user is not doing some steps like "search"
            if (lastStep.isEmpty()) {
                // catch commands
                switch (command) {
                    case "/exit":
                        Functions.bye();
                        System.exit(0);
                    case "/search":
                        System.out.println("What are you looking for?");
                        Functions.writeSteps("search");
                        break;
                    case "/showAll":
                        ProductController.readAll();
                        break;
                    default:
                        System.out.println("OOPS...Command not found, try again!");
                        break;
                }
            }

            // TODO: check if command has in available commands list && Search items and show it
            if (lastStep.equals("search") && scan.hasNext()) {
                String name = scan.nextLine();
                System.out.println(name);
                ProductController.search(name);
                Functions.writeSteps("");
            }
        }
    }
}
