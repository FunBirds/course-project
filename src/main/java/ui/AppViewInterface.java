package ui;

public interface AppViewInterface {
    void startMessage(String message);
    void endMessage(String message);
    void developerInformation(String name, String email);
    void launchMessage(String appName, String version, String description);
    void launchAnimation();
    void displayMenu();
}
