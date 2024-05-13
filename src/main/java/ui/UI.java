package ui;

import controllers.CommandController;
import ui.impl.AppViewImpl;

import java.util.Map;
import java.util.Scanner;

public class UI {
    public void start() {
        AppViewImpl appView = new AppViewImpl();
        appView.launchAnimation();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + "Start your journey!: ");
        CommandController commandController = new CommandController();
        while (true){
            String command = scanner.nextLine();
            if (command.equals("/exit")){
                break;
            }
            if(command.contains("/search")){
                Map<String, String> output = commandController.searchCommand(command);
                System.out.println(output);
            }
        }
    }
}
