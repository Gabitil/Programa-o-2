package atividade2;

public class Lote {
    
    private Produto[] produtos;


    public Lote(int quantidade) {
        produtos = new Produto[quantidade];
    }

    public boolean inserirProduto(Produto produto) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] == null) {
                produtos[i] = produto;
                return true;
            }
        }
        return false;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    public boolean equals(Lote lote) {
        for (int i = 0; i < produtos.length; i++) {
            if (!produtos[i].equals(lote.getProdutos()[i])) {
                return false;
            }
        }
        return true;
    }

}
