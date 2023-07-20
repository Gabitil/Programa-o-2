package visao_gabrielaug;

import dominio_gabrielaugus.JogoInvalidoException;
import dominio_gabrielaugus.QuadradoMagico;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        QuadradoMagico jogo = new QuadradoMagico();
        jogo.iniciaTabuleiro();
        System.out.println("Seja bem vindo ao jogo do Quadrado Magico!");
        System.out.println("Veja o tabuleiro inicial:");
        jogo.imprimeTabuleiro();
        System.out.println("Vamos comecar o jogo!");
        System.out.println("Insira os valores de 1 a 9 no tabuleiro");
        System.out.println("Digite a linha, coluna e valor separados por espaco");
        System.out.println("Não é permitido inserir valores repetidos");
        System.out.println("Lembre que as colunas e linhas vao de 0 a 200");
        System.out.println("Digite 11 11 11 para verificar se ganhou");
        System.out.println("Digite 0 0 0 para sair");
        System.out.println("Digite 10 10 10 para reiniciar o jogo");
        System.out.println("Boa sorte!");

        int linha, coluna, valor;

        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.print("Digite a linha, coluna e valor: ");
            linha = entrada.nextInt();
            coluna = entrada.nextInt();
            valor = entrada.nextInt();

            if (linha == 11 && coluna == 11 && valor == 11) {
                try {
                    jogo.verificaVitoria();
                    System.out.println("Parabens, voce ganhou!");
                    System.out.println("Digite 10 10 10 para reiniciar o jogo");
                    System.out.println("Ou Digite 0 0 0 para sair");
                    continue;
                } catch (JogoInvalidoException e) {
                    System.out.println(e.getMessage());
                }
            } else if (linha == 0 && coluna == 0 && valor == 0) {
                break;
            } else if (linha == 10 && coluna == 10 && valor == 10) {
                jogo.iniciaTabuleiro();
                System.out.println("Tabuleiro reiniciado!");
                jogo.imprimeTabuleiro();
                continue;
            }

            try {
                jogo.inserirValor(linha, coluna, valor);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            jogo.imprimeTabuleiro();

        }
    }
}
