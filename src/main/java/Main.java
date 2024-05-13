import ui.UI;

public class Main {
    public static void main(String[] args){
        try {
            UI ui = new UI();
            ui.start();
        }catch(RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
