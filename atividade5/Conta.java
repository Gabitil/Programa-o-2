package atividade5;

public abstract class Conta implements Passivo {
    protected int dia;
    protected int mes;
    protected double valor;

    protected Conta(int dia, int mes, double valor) {
        this.dia = dia;
        this.mes = mes;
        this.valor = valor;
    }
}
