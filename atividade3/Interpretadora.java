package atividade3;

import java.util.HashSet;



public class Interpretadora {
    private HashSet<String> palavrasChave;

    public Interpretadora() {
        this.palavrasChave = new HashSet<>();
    }

    public void separaPalavras (String frase){
        String[] palavras = frase.split(" ");
        for (String palavra : palavras) {
            this.palavrasChave.add(palavra);
        }
    }

    public HashSet<String> getPalavrasChave(){
        return this.palavrasChave;
    }
}
