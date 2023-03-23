package atividade2;

public class Lote {
    
    private Produto[] produtos;
    private int quantidade;

    public Lote(int quantidade, String[] descricao, double[] valorInicial) {
        this.quantidade = quantidade;
        produtos = new Produto[quantidade];

        for (int i = 0; i < quantidade; i++) {
            produtos[i] = new Produto(descricao[i], valorInicial[i]);
        }

    }


}
