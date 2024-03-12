import App.Functions;

public class Main {
    public static void main(String[] args) {
        Functions.getEnv("DB_URL");
        System.out.println(App.Variables.getenv());
    }
}
