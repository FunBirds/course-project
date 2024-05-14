package ui.impl;

import io.github.cdimascio.dotenv.Dotenv;
import ui.AppViewInterface;

public class AppViewImpl implements AppViewInterface {
    Dotenv env = Dotenv.configure().load();

    public void startMessage(String message) {
        System.out.println(message);
    }
    public void endMessage(String message) {
        System.out.println(message);
    }
    public void developerInformation(String name, String email) {
        System.out.println("Developer: " + name + " (" + email + ")");
    }
    public void launchMessage(String appName, String version, String description) {
        System.out.println("App: " + appName);
        System.out.println("Version: " + version);
        System.out.println("Description: " + description);
    }

    public void displayMenu() {
        System.out.println("/***************************************/");
        System.out.println("/************ List of Menus ************/");
        System.out.println("/***************************************/");
        System.out.println("/all - Display all products");
        System.out.println("/all -t=[TABLEWARE NAME]- Display all products by tableware name");
        System.out.println("/plist - List of Parameters");
        System.out.println("/plist -t=[TABLEWARE NAME] - List of specific tableware parameters");
        System.out.println("/tlist - List of Tablewares");
        System.out.println("/search -t=[TABLEWARE NAME] -p=[PARAMETER] -a=[PARAMETER ARGUMENT] - Search by a parameter");
        System.out.println("/search -t=[TABLEWARE NAME] -n=[NAME] - Search by a name");
        System.out.println("/purchasable -t=[TABLEWARE NAME] -a=[COST] - Display all purchasable products");
        System.out.println("/help - Display the list of commands");
        System.out.println("/exit - Exit the application and quit");
    }

    public void launchAnimation() {
        for (int i = 0; i <= 100; i++) {
            System.out.print("Launching App — " + i + "%" + "\r");
            if (i == 100) {
                System.out.flush();
                startMessage("Welcome !!!");
                System.out.print("\n");
                launchMessage(env.get("APPLICATION_NAME"), env.get("APPLICATION_VERSION"), env.get("APPLICATION_DESCRIPTION"));
                System.out.print("\n");
                developerInformation(env.get("DEVELOPER_NAME"), env.get("DEVELOPER_EMAIL"));
                System.out.print("\n");
                displayMenu();
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
