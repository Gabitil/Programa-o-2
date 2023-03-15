package floricultura;

public class Produto {
    
    private String descricao;
    private double preco;
    private int codigo;

    public Produto() {
        descricao = "";
        preco = 0.0;
        codigo = 0;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}