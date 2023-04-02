package atividade2;

public class Lance {
    private Pessoa pessoa;
    private double valor;

    public Lance() {
        this.pessoa = new Pessoa();
        this.valor = 0;
    }

    public Lance(Pessoa pessoa, double valor) {
        this.pessoa = pessoa;
        this.valor = valor;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean equals(Lance lance) {
        return this.pessoa.equals(lance.getPessoa()) && this.valor == lance.getValor();
    }

    public boolean maiorQue(double valor) {
        return this.valor > valor;
    }
}
