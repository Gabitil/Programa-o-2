package copag;

import java.util.Random;

public class Baralho {
    private Carta[] cartas;
    private static String naipes[] = {"Copas", "Ouros", "Paus", "Espadas"};
    private static Random gerador = new Random();

    public Baralho() {
        cartas = new Carta[52];
        int i = 0;
        for (String naipe : naipes) {
            for (int valor = 1; valor <= 13; valor++) {
                cartas[i] = new Carta(naipe, valor);
                i++;
            }
        }
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    public static String[] getNaipes() {
        return naipes;
    }

    public static void setNaipes(String[] naipes) {
        Baralho.naipes = naipes;
    }
    public Carta retirarumaCarta(){
        Carta carta;
        int posicao = gerador.nextInt(51);
        while (cartas[posicao] == null) {
            posicao = gerador.nextInt(51);
        }
        carta = cartas[posicao];
        cartas[posicao] = null;
        return carta;
    }
}
