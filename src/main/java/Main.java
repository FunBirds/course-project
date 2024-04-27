import EntityLayer.Cup;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Cup().setName("Cup").setPrice(10.0).setMaterial("Glass").setQuantity(10).setSize("M").setColor("Red").setVolume(0.3).toString());
    }
}
