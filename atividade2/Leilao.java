package atividade2;

public class Leilao {

    private Lote[] lotes;

    public Leilao(int quantidade) {
        lotes = new Lote[quantidade];
    }

    public boolean inserirLote(Lote lote) {
        for (int i = 0; i < lotes.length; i++) {
            if (lotes[i] == null) {
                lotes[i] = lote;
                return true;
            }
        }
        return false;
    }

    public Lote[] getLotes() {
        return lotes;
    }

    public void setLotes(Lote[] lotes) {
        this.lotes = lotes;
    }

    public boolean equals(Leilao leilao) {
        for (int i = 0; i < lotes.length; i++) {
            if (!lotes[i].equals(leilao.getLotes()[i])) {
                return false;
            }
        }
        return true;
    }

    public void receberLance(Lance lance, int numeroLote, int numeroProduto) {
        if (lotes[numeroLote].getProdutos()[numeroProduto].isVendido()) {
            System.out.println("Produto já vendido!");
        } else {
            if (lance.maiorQue(lotes[numeroLote].getProdutos()[numeroProduto].getValorAtual())) {
                lotes[numeroLote].getProdutos()[numeroProduto].setValorAtual(lance.getValor());
                lotes[numeroLote].getProdutos()[numeroProduto].setComprador(lance.getPessoa());
            } else {
                System.out.println("Lance menor que o valor atual!");
            }
        }
    }

    public void encerrarLeilao() {
        System.out.println("Leilão encerrado. Produtos vendidos:");
    
        for (Lote lote : lotes) {
            if (lote != null) {
                Produto[] produtos = lote.getProdutos();
                for (Produto produto : produtos) {
                    if (produto != null && produto.getComprador() != null) {
                        System.out.println("Produto: " + produto.getDescricao());
                        System.out.println("Comprador: " + produto.getComprador().getNome());
                        System.out.println("Valor: " + produto.getValorAtual());
                        System.out.println("---------------------------------");
                    }
                }
            }
        }
    }
}    