package atividade5;

public class Titulo extends Conta{

    public Titulo(int dia, int mes, double valor) {
        super(dia, mes, valor);
    }

    public double getValorAPagar(int diaPagto, int mes){
        if (diaPagto > dia){
            return valor * 1.1;
        } else {
            return valor;
        }
    }
    
}
