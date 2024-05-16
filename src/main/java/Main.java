import ui.UI;

public class Main {
    public static void main(String[] args) {
        try {
            UI ui = new UI();
            ui.start();
        } catch(RuntimeException e){
            System.err.println("An error occurred: " + e.getMessage());
            System.out.println("Something went wrong... Please restart the program.");
        }
    }
}
