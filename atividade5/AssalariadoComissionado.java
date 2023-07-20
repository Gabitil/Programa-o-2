package atividade5;

public class AssalariadoComissionado extends Comissionado{
    private double percentualBonus;

    public AssalariadoComissionado(double percentualBonus, double valorVendas, String nome, String sobrenome, int numIdent) {
        super(valorVendas, nome, sobrenome, numIdent);
        this.percentualBonus = percentualBonus;
    }

    @Override
    public double getValorAPagar(int diaPagto, int mes){
        return super.getValorAPagar(diaPagto, mes) * (1 + percentualBonus);
    }
    
}
