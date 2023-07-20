package pv1_gabrielaugusto_johnmartins;

import java.util.Scanner;

public class Caixa {
    
    public static void main(String[] args) {

        Estoque estoque = new Estoque();
        Venda venda = new Venda();
        Produto produto = new Produto();
        int codigo;
        int qtdProdutos;
        int valorPago;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Bem vindo ao sistema de vendas da loja XYZ");
        
        estoque.adicionaProduto(new Produto(111111, "Detergente ABC", 1));
        estoque.adicionaProduto(new Produto(222222, "Sabão em pó OMO", 6.5));
        estoque.adicionaProduto(new Produto(333333, "Shampoo Beleza Fácil", 12));
        estoque.adicionaProduto(new Produto(444444, "Creme dental Colgate", 3.5));
        estoque.adicionaProduto(new Produto(555555, "Sabonete Nívea", 1.8));
        estoque.adicionaProduto(new Produto(666666, "Biscoito Maizena", 2));
        estoque.adicionaProduto(new Produto(777777, "Leite desnatado Parmalat", 3));

        System.out.println("Produtos cadastrados no estoque: " + estoque.qtdProdutos());

        //Enquanto o cliente não digitar 0 continue adicionando produtos

        System.out.println("Digite o código do produto ou 0 para finalizar a compra: ");

        codigo = leitor.nextInt();

        while (codigo != 0) {
            System.out.println("Digite a quantidade do produto: ");
            qtdProdutos = leitor.nextInt();
            for (int i = 0; i < qtdProdutos; i++) {
                venda.getProdutos().add(estoque.buscaProduto(codigo));
            }
            System.out.println("Digite o código do produto ou 0 para finalizar a compra: ");
            codigo = leitor.nextInt();
        }
            
        System.out.println("Valor total da compra: " + venda.calculoValor());
        System.out.println("Digite o valor pago: ");
        valorPago = leitor.nextInt();

        if (venda.verificaTroco(valorPago) < 0) {
            System.out.println("Valor insuficiente para a compra");
        } else {
            System.out.println("Troco: " + venda.verificaTroco(valorPago));
        }

    }
}
