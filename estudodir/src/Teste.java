import java.io.EOFException;

public class Teste {
    public static void f(int i) throws Exception{
        try{
            switch (i){
                case 1:
                    throw new Exception();
                case 2:
                    throw new NumberFormatException();
                case 3:
                    throw new EOFException();
                default:
            }
        
        } catch (NumberFormatException e){
            System.out.println("NumberFormatException");
        } catch (EOFException e){
            System.out.println("EOFException");
        } catch (Exception e){
            System.out.println("Exception");
            throw e;
        }
    }
}
