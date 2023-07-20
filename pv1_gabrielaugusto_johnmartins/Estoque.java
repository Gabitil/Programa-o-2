package pv1_gabrielaugusto_johnmartins;

import java.util.ArrayList;

public class Estoque {

    private ArrayList<Produto> produtos;


    //construtores

    public Estoque() {
        this.produtos = new ArrayList<Produto>();
    }


    //gets e setters

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public void adicionaProduto(Produto produto){
        this.produtos.add(produto);
    }

    public Produto buscaProduto(int codigo){
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public int qtdProdutos(){
        return this.produtos.size();
    }

 
}
