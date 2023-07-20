/**
 * @author Gabriel Augusto de Lima Maia
 */


package dominio_gabrielaug;

/**
 * Classe que representa o jogo Lotofacil
 */
public class Lotofacil extends Jogo{
    
    public Lotofacil() {
        minNumerosAposta = 15;
        maxNumerosAposta = 20;
        minDominioNumero = 1;
        maxDominioNumero = 25;
        qntNumApostados = minNumerosAposta;
    }
}
