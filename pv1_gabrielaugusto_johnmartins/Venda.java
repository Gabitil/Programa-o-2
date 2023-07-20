package pv1_gabrielaugusto_johnmartins;

import java.util.ArrayList;

public class Venda {
    private ArrayList<Produto> produtos;
    private int qtdProdutos;

    public Venda() {
        this.produtos = new ArrayList<Produto>();
        this.qtdProdutos = 0;
    }

    //gets e setters

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }

    public double calculoValor(){
        double valorTotal = 0;
        for (Produto produto : produtos) {
            valorTotal += produto.getPreco();
        }
        return valorTotal;
    }

    public double verificaTroco(double valorPago){
        return valorPago - calculoValor(); 
    }
}
