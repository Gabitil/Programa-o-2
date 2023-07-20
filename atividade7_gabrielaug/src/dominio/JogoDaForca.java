package dominio;

import servicos.TextFileApps;
import java.util.ArrayList;
import java.util.Random;

public class JogoDaForca {
    private String palavra;
    private ArrayList<String> letrasPalavra;
    private String[] letras;
    private ArrayList<String> palavrasjogo;
    private int numTentativas;
    private boolean venceu;


    public JogoDaForca() {
        this.palavrasjogo = new ArrayList<String>();
        this.letras = new String[7];
        this.numTentativas = 15;
        this.venceu = false;
        this.letrasPalavra = new ArrayList<String>();
    }

    public void separaLetras(){
        for (int i = 0; i < this.palavra.length(); i++) {
            this.letrasPalavra.add(String.valueOf(this.palavra.charAt(i)));
        }
        System.out.println(letrasPalavra);
    }
    public ArrayList<Integer> verificaLetra(String letra) {
        // Verifica se a letra existe na palavra e retorna as posições em que ela ocorre
        System.out.println(letra);
        ArrayList<Integer> posicoes = new ArrayList<>();
        for (int i = 0; i < this.letrasPalavra.size(); i++) {
            if (this.letrasPalavra.get(i).equals(letra)) {
                this.letras[i] = letra;
                posicoes.add(i);
            }
        }
        return posicoes;
    }

    public boolean verificaFimDoJogo(){
        // Verifica se o jogo acabou
        if (this.numTentativas == 0) {
            this.venceu = false;
            return true;
        } else {
            for (int i = 0; i < this.letras.length; i++) {
                if (this.letras[i] == null) {
                    return false;
                }
            }
            this.venceu = true;
            return true;
        }
    }
    

    public void sorteiaPalavraJogo(String nomeArquivo){
        // recebe as palavras do arquivo
        this.palavrasjogo = TextFileApps.lerArquivo(nomeArquivo);

        // sorteia uma palavra
        Random random = new Random();
        int indice = random.nextInt(this.palavrasjogo.size());
        this.palavra = this.palavrasjogo.get(indice);
        this.palavra = this.palavra.toUpperCase();
        separaLetras();

        System.out.println(this.palavra);
    }

    public String getPalavra() {
        return this.palavra;
    }

    public int getTentativas() {
        return this.numTentativas;
    }

    public void diminuirTentativas() {
        this.numTentativas--;
    }

    public boolean getVenceu() {
        return this.venceu;
    }

    

}
