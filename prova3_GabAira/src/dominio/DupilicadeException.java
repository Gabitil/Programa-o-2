package dominio;

public class DupilicadeException extends Exception{
    public DupilicadeException(String mensagem){
        super("Já existe uma refeição com essa descrição!");
    }
}
