package atividade2;

public class Produto {

    private String descricao;
    private double valorInicial;
    private double valorAtual;
    private boolean vendido;
    private Pessoa comprador;

    public Produto() {
        this.descricao = "";
        this.valorInicial = 0;
        this.valorAtual = 0;
        this.vendido = false;
    }

    public Produto(String descricao, double valorInicial) {
        this.descricao = descricao;
        this.valorInicial = valorInicial;
        this.valorAtual = valorInicial;
        this.vendido = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public Pessoa getComprador() {
        return comprador;
    }
    
    public void setComprador(Pessoa comprador) {
        this.comprador = comprador;
    }

    public boolean equals(Produto produto) {
        return this.descricao.equals(produto.getDescricao()) &&
               this.valorInicial == produto.getValorInicial() &&
               this.valorAtual == produto.getValorAtual() &&
               this.vendido == produto.isVendido();
    }
}
