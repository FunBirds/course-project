import App.DB;

public class Main {
    public static void main(String[] args) {
       String result = DB.search("Gadgedsadsdast");
       if (result != null) {
           System.out.println(result);
       } else {
           System.out.println("Product not found");
       }
    }

}
