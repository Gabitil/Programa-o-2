package atividade2;

public class Teste {
    
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", "123456789");
        Pessoa pessoa2 = new Pessoa("Maria", "987654321");
        Pessoa pessoa3 = new Pessoa("Pedro", "111222333");
        Lance lance = new Lance(pessoa, 100);
        Lance lance2 = new Lance(pessoa2, 200);
        Lance lance3 = new Lance(pessoa3, 150);
        Lance lance4 = new Lance(pessoa, 250);
        Produto produto = new Produto("TV", 100);
        Produto produto2 = new Produto("Notebook", 200);
        Produto produto3 = new Produto("TV", 100);
        Lote lote = new Lote(2);
        Lote lote2 = new Lote(2);
        Lote lote3 = new Lote(2);
        lote.inserirProduto(produto);
        lote.inserirProduto(produto2);
        lote2.inserirProduto(produto3);
        lote2.inserirProduto(produto2);
        lote3.inserirProduto(produto);
        lote3.inserirProduto(produto2);

        Leilao leilao = new Leilao(3);
        leilao.inserirLote(lote);
        leilao.inserirLote(lote2);
        leilao.inserirLote(lote3);

        leilao.receberLance(lance, 0, 0);
        leilao.receberLance(lance2, 0, 1);
        leilao.receberLance(lance3, 1, 0);
        leilao.receberLance(lance4, 1, 1);

        leilao.encerrarLeilao();
    }
}
