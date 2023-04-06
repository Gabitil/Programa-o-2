package atividade3;

import java.util.Scanner;

public class CallCenter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String pergunta;

        Interpretadora interpretadora = new Interpretadora();
        SuporteTecnico suporte = new SuporteTecnico();

        System.out.println("Bem-vindo ao sistema de Suporte Técnico");

        do {
            // Recebe pelo teclado a pergunta do usuário
            System.out.println("Pressione <enter> para continuar ou digite 'sair' para sair do sistema.");

            // Se o usuário digitar sair, o programa é encerrado
            if (input.nextLine().equals("sair")) {
                System.out.println("Obrigada por utilizar nossos serviços!");
                break;
            }

            System.out.println("Descreva seu problema de maneira sucinta.");
            pergunta = input.nextLine();

            // Separa as palavras da pergunta
            interpretadora.separaPalavras(pergunta);

            // Verifica se a pergunta é uma das palavras-chave e, se não for, devolve a resposta padrão
            String resposta = suporte.getRespostaPorPalavrasChave(interpretadora.getPalavrasChave());
            System.out.println(resposta);

        } while (true);

        input.close();
    }
}
