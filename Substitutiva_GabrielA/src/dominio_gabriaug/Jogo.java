package dominio_gabriaug;

import java.util.Scanner;


public class Jogo {
        Tabuleiro tabuleiro1;
        Tabuleiro tabuleiro2;
        Jogador jogador1;
        Jogador jogador2;
        Scanner scanner = new Scanner(System.in);

        //construtor

        public Jogo() {
            jogador1 = new Jogador("Jogador 1");
            jogador2 = new Jogador("Jogador 2");

            jogador1.gerarEspadas();
            jogador2.gerarEspadas();

            tabuleiro1 = new Tabuleiro(jogador1);
            tabuleiro2 = new Tabuleiro(jogador2);
        }

        //getters e setters

        public Tabuleiro getTabuleiro1() {
            return tabuleiro1;
        }

        public Tabuleiro getTabuleiro2() {
            return tabuleiro2;
        }

        public Jogador getJogador1() {
            return jogador1;
        }

        public Jogador getJogador2() {
            return jogador2;
        }

        public void setTabuleiro1(Tabuleiro tabuleiro1) {
            this.tabuleiro1 = tabuleiro1;
        }

        public void setTabuleiro2(Tabuleiro tabuleiro2) {
            this.tabuleiro2 = tabuleiro2;
        }

        public void setJogador1(Jogador jogador1) {
            this.jogador1 = jogador1;
        }

        public void setJogador2(Jogador jogador2) {
            this.jogador2 = jogador2;
        }

        //metodos

        public void adicionarPonto(Jogador jogador){
            jogador.setPontos(jogador.getPontos()+1);
        }

        public boolean verificaVitoria(){
            if(jogador1.getPontos()>=125){
                System.out.println("Jogador 1 venceu!");
                return false;
            }
            else if(jogador2.getPontos()>=125){
                System.out.println("Jogador 2 venceu!");
                return false;
            }
            else{
                return true;
            }
        }

        public void iniciarJogo(){
            System.out.println("Segue a baixo as descriçoes e simbolos das espadas:");
            jogador1.mostrarEspadas();
            //jogadores selecionam onde pocisionar as suas espadas
            //jogador 1
            
            System.out.println("Jogador 1, escolha onde posicionar as suas espadas:");
            System.out.println("Colunas e linhas vão de 0 a 12");
            for(int i=0; i<6; i++){
                System.out.println("Espada "+(i+1)+":");
                System.out.println("Linha:");
                int linha = scanner.nextInt();
                System.out.println("Coluna:");
                int coluna = scanner.nextInt();
                System.out.println("Simbolo:");
                char simbolo = scanner.next().charAt(0);
                Espada espadaEscolhida= tabuleiro1.selecionaEspada(simbolo);
                tabuleiro1.posicionarEspada(espadaEscolhida, linha, coluna);
            }
            //jogador 2
            System.out.println("Jogador 2, escolha onde posicionar as suas espadas:");
            System.out.println("Colunas e linhas vão de 0 a 12");
            for(int i=0; i<6; i++){
                System.out.println("Espada "+(i+1)+":");
                System.out.println("Linha:");
                int linha = scanner.nextInt();
                System.out.println("Coluna:");
                int coluna = scanner.nextInt();
                System.out.println("Simbolo:");
                char simbolo = scanner.next().charAt(0);
                Espada espadaEscolhida= tabuleiro2.selecionaEspada(simbolo);
                tabuleiro2.posicionarEspada(espadaEscolhida, linha, coluna);
            }
            System.out.println(jogador1.getPontos());
            System.out.println(jogador2.getPontos());
            //jogadores revesam jogadas até alguém vencer
            while(verificaVitoria())//enquanto ninguem vencer
            {
                //jogador 1
                System.out.println("Jogador 1, escolha onde atacar:");
                //imprime o tabuleiro do jogador 2
                tabuleiro2.imprimirTabuleiro();
                System.out.println("Colunas e linhas vão de 0 a 12");
                System.out.println("Linha:");
                int linha = scanner.nextInt();
                System.out.println("Coluna:");
                int coluna = scanner.nextInt();
                if(tabuleiro1.atacarEspada(linha, coluna)){
                    adicionarPonto(jogador1);
                }
                
                //jogador 2
                System.out.println("Jogador 2, escolha onde atacar:");

                //imprime o tabuleiro do jogador 1
                tabuleiro1.imprimirTabuleiro();

                System.out.println("Linha:");
                linha = scanner.nextInt();
                System.out.println("Coluna:");
                coluna = scanner.nextInt();
                if(tabuleiro2.atacarEspada(linha, coluna)){
                    adicionarPonto(jogador2);
                }
                tabuleiro1.imprimirTabuleiro();
            }

        }
}
