package atividade5;

public class Assalariado extends Empregado{
    private double horasExtras;

    public Assalariado(double horasExtras, String nome, String sobrenome, int numIdent) {
        super(nome, sobrenome, numIdent);
        this.horasExtras = horasExtras;
    }

    public double getValorAPagar(int diaPagto, int mes){
        return Passivo.SALARIO + horasExtras * Passivo.HORA;
    }
    
}
