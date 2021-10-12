public class DemoTest {

    public static void main(String[] args) {
        String a= new String("hello");
        String aa= new String("hello");
        char c[] = {'h','e','l','l','o'};
        System.out.println(aa==a);
        System.out.println(a.equals(c));
    }
}
