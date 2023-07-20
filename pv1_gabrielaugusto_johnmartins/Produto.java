package pv1_gabrielaugusto_johnmartins;

public class Produto {
    private int codigo;
    private String descricao;
    private double preco;

    //construtores

    public Produto(){
        this.codigo= 0;
        this.descricao= "";
        this.preco = 0;
    }

    public Produto (int codigo, String descricao, double preco){
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    //gets e setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


}
