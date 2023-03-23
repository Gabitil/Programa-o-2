package atividade2;

public class Produto {
    
    private String descricao;
    private double valorInicial;
    private double valorAtual;
    private boolean vendido;

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
}
