package atividade5;

public interface Passivo {
    public static final double SALARIO = 1320.0;
    public static final double HORA = 65.0;

    public abstract double getValorAPagar(int diaPagto, int mes);    
}
