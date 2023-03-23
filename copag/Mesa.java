package copag;



/*Faça um aplicativo Java denominado Mesa para simular o jogo entre dois jogadores A e B. Ao iniciar o jogo, os
jogadores deverão receber cinco cartas. Dentre estas cartas, cada jogador deverá selecionar a maior carta e exibi-la.
Vencerá o jogo o jogador que tiver exibido a carta de maior valor. Caso ocorra empate, vencerá o jogo o jogador
que tiver com a carta de Ouros.
 */

public class Mesa {
    public static void main(String[] args) {
        int quantidade;


        Baralho baralho = new Baralho();

        System.out.println("Mesa embaralhando.........…");
        System.out.println("Informe o número de cartas a distribuir para os jogadores:");
        //solicita a quantidade de cartas para o usuário:
        quantidade = Integer.parseInt(System.console().readLine());
        System.out.println("Mesa distribui as " + quantidade + " cartas para jogador A e para o jogador B.");

        //distribui as cartas para os jogadores e retira do baralho:
        Jogador jogadorA = new Jogador(baralho.distribuirCartas(quantidade), quantidade);
        Jogador jogadorB = new Jogador(baralho.distribuirCartas(quantidade), quantidade);
        
        //mostra as cartas dos jogadores.
        //System.out.println("O jogador A tem as seguintes cartas:");
        //jogadorA.mostrarCartas();
        //System.out.println("O jogador B tem as seguintes cartas:");
        //jogadorB.mostrarCartas();


        //jogadores jogam as suas maiores cartas:
        Carta maiorCartaJogadorA = jogadorA.maiorCarta();
        Carta maiorCartaJogadorB = jogadorB.maiorCarta();

        //exibe as cartas jogadas:
        System.out.println("O jogador A joga a carta de naipe " + maiorCartaJogadorA.getNaipe() + " e de valor " + maiorCartaJogadorA.getValor());
        System.out.println("O jogador B joga a carta de naipe " + maiorCartaJogadorB.getNaipe() + " e de valor " + maiorCartaJogadorB.getValor());

        //verifica quem venceu e se empatar refaz o jogo:

        if (maiorCartaJogadorA.getValor() > maiorCartaJogadorB.getValor()) {
            System.out.println("O jogador A venceu o jogo.");
        } else if (maiorCartaJogadorA.getValor() < maiorCartaJogadorB.getValor()){
            System.out.println("O jogador B venceu o jogo.");
        } else {
            if ("Ouros".equals(maiorCartaJogadorA.getNaipe())) {
                System.out.println("O jogador A venceu o jogo, por ter a carta de ouros.");
            } else if ("Ouros".equals(maiorCartaJogadorB.getNaipe())) {
                System.out.println("O jogador B venceu o jogo, por ter a carta de ouros.");
            } else {
                System.out.println("O jogo empatou.");
                System.out.println("Refazendo o jogo...");                                                          
                main(args);
            }
        }
        
    }
}
