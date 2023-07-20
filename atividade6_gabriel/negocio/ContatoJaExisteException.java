package atividade6_gabriel.negocio;

public class ContatoJaExisteException extends Exception{
        
        public ContatoJaExisteException(String mensagem){
            super(mensagem);
        }
}
