/**
 * @author Gabriel Augusto de Lima Maia
 */


package dominio_gabrielaug;

/**
 * Classe que representa o jogo Quina
 */
public class Quina extends Jogo{

    /**
     * Construtor
     */
     public Quina() {
        minNumerosAposta = 5;
        maxNumerosAposta = 15;
        minDominioNumero = 1;
        maxDominioNumero = 80;
        qntNumApostados = minNumerosAposta;
    }
}
