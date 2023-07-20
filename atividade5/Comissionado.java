package atividade5;

public class Comissionado extends Empregado{
    private double valorVendas;

    public Comissionado(double valorVendas, String nome, String sobrenome, int numIdent) {
        super(nome, sobrenome, numIdent);
        this.valorVendas = valorVendas;
    }

    public double getValorAPagar(int diaPagto, int mes){
        return valorVendas * 0.6;
    }
}
