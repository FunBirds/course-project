package App;

public class Variables {
    private static String APP_ENV;

    public static String getenv() {
        return APP_ENV;
    }

    public static void setAppEnv(String appEnv) {
        APP_ENV = appEnv;
    }
}
