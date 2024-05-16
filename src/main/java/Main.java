import ui.UI;

/**
 * The Main class is the entry point of the application.
 * It creates an instance of the UI class and starts it.
 * If any runtime exception occurs during the execution, it is caught and an error message is printed.
 */
public class Main {
    /**
     * The main method is the entry point of the Java application.
     * @param args An array of command-line arguments for the application
     */
    public static void main(String[] args) {
        try {
            // Create a new UI instance
            UI ui = new UI();
            // Start the UI
            ui.start();
        } catch(RuntimeException e){
            // Print the error message if a runtime exception occurs
            System.err.println("An error occurred: " + e.getMessage());
            // Inform the user that something went wrong and the program needs to be restarted
            System.out.println("Something went wrong... Please restart the program.");
        }
    }
}