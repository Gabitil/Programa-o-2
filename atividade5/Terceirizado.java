package atividade5;

public class Terceirizado extends Empregado{
    private double horasTrabalhadas;

    public Terceirizado(double horasTrabalhadas, String nome, String sobrenome, int numIdent) {
        super(nome, sobrenome, numIdent);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorAPagar(int diaPagto, int mes){
        return horasTrabalhadas * Passivo.HORA;
    }

    
}
