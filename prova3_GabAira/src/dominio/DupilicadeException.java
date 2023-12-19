package dominio;

/**
 * This exception is thrown when a duplicate meal description is detected.
 */
public class DupilicadeException extends Exception{
    public DupilicadeException(String mensagem){
        super("Já existe uma refeição com essa descrição!");
    }
}
