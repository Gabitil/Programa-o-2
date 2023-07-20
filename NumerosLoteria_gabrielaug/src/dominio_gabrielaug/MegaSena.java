/**
 * @author Gabriel Augusto de Lima Maia
 */


package dominio_gabrielaug;

/**
 * Classe que representa o jogo MegaSena
 */
public class MegaSena extends Jogo{

        public MegaSena() {
        minNumerosAposta = 6;
        maxNumerosAposta = 20;
        minDominioNumero= 1;
        maxDominioNumero = 60;
        qntNumApostados = minNumerosAposta;
    }
}
