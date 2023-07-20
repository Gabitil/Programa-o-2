package atividade5;

import java.util.ArrayList;
import java.util.List;


public class ControlePagamento {

    private List<Passivo> pagamentos = new ArrayList<Passivo>();

    public void addPagamento(Passivo pagamento){
        pagamentos.add(pagamento);
    }

    public double totalPagamentos(int diaPagto, int mes){
        double total = 0;
        for (Passivo pagamento : pagamentos) {
            total += pagamento.getValorAPagar(diaPagto, mes);
        }
        return total;
    }

    public void exibeValoresIndividuais(int diaPagto, int mes){
        for (Passivo pagamento : pagamentos) {
            System.out.println(pagamento.getValorAPagar(diaPagto, mes));
        }
    }
}
