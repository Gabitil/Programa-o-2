package atividade5;

public class SistemaPagamentoTeste {
    public static void main(String[] args) {
        ControlePagamento controle = new ControlePagamento();
        Terceirizado terceirizado = new Terceirizado(10, "Maria", "Silva", 456);
        Comissionado comissionado = new Comissionado(1000, "José", "Silva", 789);
        AssalariadoComissionado assalariadoComissionado = new AssalariadoComissionado(0.1, 1000, "João", "Silva", 123);
        Titulo titulo = new Titulo(10, 10, 1000);
        Concessionaria concessionaria = new Concessionaria(10, 10, 1000);
        controle.addPagamento(terceirizado);
        controle.addPagamento(comissionado);
        controle.addPagamento(assalariadoComissionado);
        controle.addPagamento(titulo);
        controle.addPagamento(concessionaria);
        System.out.println("Total de pagamentos: " + controle.totalPagamentos(11, 10));
        System.out.println("Valores individuais: ");
        controle.exibeValoresIndividuais(11, 10);

    }
}
