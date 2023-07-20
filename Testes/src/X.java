public class X {
 public static void main(String[] args) {
 try {
 falha();
 System.out.print("A1");
 } catch (RuntimeException ex) {
 System.out.print("A2");
 } catch (Exception ex1) {
 System.out.print("A3");
 } finally {
 System.out.print("A4");
 }
 System.out.print("A5");
 }
 public static void falha() {
 throw new RuntimeException();
 }
}