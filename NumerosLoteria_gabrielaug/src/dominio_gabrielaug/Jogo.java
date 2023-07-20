/**
 * @author Gabriel Augusto de Lima Maia
 */


package dominio_gabrielaug;

import java.util.HashSet;
import java.util.Set;
import java.util.random.RandomGenerator;

/**
 * Classe abstrata que representa um jogo
 */
public abstract class Jogo {
    /**
     * Atributos
     * 
     */
    protected int minNumerosAposta;
    protected int maxNumerosAposta;
    protected int minDominioNumero;
    protected int maxDominioNumero;
    protected int qntNumApostados;
    private String tipoJogo;
    protected RandomGenerator gerador;


    /**
     * Construtor
     */
    protected Jogo() {
        gerador = RandomGenerator.getDefault();
    }


    
    /**
     * Getters e Setters
     * 
     */

    /** 
     * recebe a quantidade de numeros apostados
     * @return o valor da quantidade de numeros apostados
     */
    public int getQntNumApostados() {
        return qntNumApostados;
    }

    
    /** 
     * salva a quantidade de numeros apostados
     * @param qntNumApostados
     */
    public void setQntNumApostados(int qntNumApostados) {
        this.qntNumApostados = qntNumApostados;
    }

    
    /** 
     * recebe o tipo de jogo
     * @return String com o tipo de jogo
     */
    public String getTipoJogo() {
        return tipoJogo;
    }

    
    /** 
     * salva o tipo de jogo
     * @param tipoJogo
     */
    public void setTipoJogo(String tipoJogo) {
        this.tipoJogo = tipoJogo;
    }

    
    /** 
     * Recebe o gerador de numeros aleatorios
     * @return RandomGenerator
     */
    public RandomGenerator getGerador() {
        return gerador;
    }

    //Métodos

    /**
     * Aumenta a quantidade de numeros apostados
     * @param qntNumApostados
     * @param maxNumerosAposta
     */
    public void aumentarAposta() {
        if (qntNumApostados < maxNumerosAposta) {
            qntNumApostados++;
        }
    }

    /**
     * Diminui a quantidade de numeros apostados
     * @param qntNumApostados
     * @param minNumerosAposta
     */
    public void diminuirAposta() {
        if (qntNumApostados > minNumerosAposta) {
            qntNumApostados--;
        }
    }

    /**
     * Gera uma aposta aleatória
     * @param qntNumApostados
     * @param minDominioNumero
     * @param maxDominioNumero
     * @param gerador
     * @return Set<Integer> com os numeros gerados
     */
    public Set<Integer> gerarAposta(){

        Set<Integer> numerosSelecionados = new HashSet<>();

        while (numerosSelecionados.size() < qntNumApostados) {
            int numero;
            do {
                numero = gerador.nextInt(minDominioNumero, maxDominioNumero);
            } while (numerosSelecionados.contains(numero));
            
            numerosSelecionados.add(numero);
        }

        return numerosSelecionados;
    }

    /***
     * Salva os numeros gerados em uma string
     * @param numerosSelecionados
     * @return String com os numeros gerados
    */
    public String salvarNumerosGerados(Set<Integer> numerosSelecionados) {
        StringBuilder sb = new StringBuilder();
        for (Integer numero : numerosSelecionados) {
            sb.append(numero).append(" ");
        }
        return sb.toString();
    }

    /**
     * Salva o maior e o menor numero de dominio em uma string
     * @param maxDominioNumero
     * @param minDominioNumero 
     * @return String com o maior e o menor numero de dominio
     */
    public String salvarNumerosPossiveisDominio() {
        return  minDominioNumero + " a " + maxDominioNumero;
        
    }

    /**
     * Salva o maior e o menor numero de aposta em uma string
     * @param minNumerosAposta 
     * @param maxNumerosAposta
     * @return String com o maior e o menor numero de aposta
     */
    public String salvarNumerosPossiveisAposta() {
        return minNumerosAposta + " a " + maxNumerosAposta;
    }

    /**
     * Salva a quantidade de numeros apostados em uma string
     * @param qntNumApostados 
     * @return String com a quantidade de numeros apostados
     */
    public String salvarNumerosApostados() {
        return qntNumApostados + "";
    }
}
