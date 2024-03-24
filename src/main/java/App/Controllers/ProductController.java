package App.Controllers;

import App.DB;

public class ProductController {
    // search for products
    public static void search(String name){
        String data =  DB.search(name);
        if (data != null) {
            System.out.println(data);
        } else {
            System.out.println("Product not found!");
        }
    }
    public static void readAll(){
        DB.readAll();
    }
}
