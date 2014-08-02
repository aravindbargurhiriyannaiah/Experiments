public class SingletonTest {
    private static final String STR = new String("aravind");

    private SingletonTest() {
    }

    public static String getInstance() {
        return STR;
    }
}
