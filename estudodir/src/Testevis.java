public class Testevis {
    public static void main(String[] args) {

        try {
            Teste.f(1);
        } catch (Exception e) {
            System.out.println("Exception");
        }
        try {
            Teste.f(2);
        } catch (Exception e) {
            System.out.println("Exception");
        }
        try {
            Teste.f(3);
        } catch (Exception e) {
            System.out.println("Exception");
        }

    }
}
