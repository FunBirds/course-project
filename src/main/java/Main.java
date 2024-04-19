import App.Controllers.ProductController;
import App.Functions;
import EntityLayer.Cup;
import EntityLayer.Plate;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Functions.helloMsg();
        Functions.writeSteps("");
        // Listen CMD
        Scanner scan = new Scanner(System.in);
//        while(true){
//            String command = scan.nextLine();
//            // need to read the steps.txt file to know the last step
//            String lastStep = String.valueOf(Functions.readSteps());
//            if (command.isEmpty()){
//                System.out.println("Hmm... you are just clicking enter, see /help for available commands!");
//                continue;
//            }
//            //check if user is not doing some steps like "search"
//            if (lastStep.isEmpty()) {
//                // catch commands
//                if (command.equals("/exit")) {
//                    Functions.bye();
//                    System.exit(0);
//                } else if (command.equals("/search")) {
//                    System.out.println("What are you looking for?");
//                    Functions.writeSteps("search");
//                } else if (command.equals("/showAll")) {
//                    ProductController.readAll();
//                } else {
//                    System.out.println("OOPS...Command not found, try again!");
//                }
//            }
//
//            if (lastStep.equals("search")) {
//                ProductController.search(command);
//                Functions.writeSteps("");
//            }
//        }

        Plate plate = new Plate().setColor("Red").setMaterial("Ceramic").setName("Plate").setPrice(10.0).setQuantity(10).setShape("Round");
        System.out.println(plate);
    }
}
