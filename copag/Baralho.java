package copag;

import java.security.SecureRandom;

public class Baralho {
    private Carta[] cartas;
    private static String[] naipes = {"Copas", "Ouros", "Paus", "Espadas"};
    private static SecureRandom gerador = new SecureRandom();

    //construtor
    public Baralho() {
        cartas = new Carta[52];
        int i = 0;
        for (String naipe : naipes) {//for each para percorrer o array de naipes
            for (int valor = 1; valor <= 13; valor++) {
                cartas[i] = new Carta(naipe, valor);
                i++;
            }
        }
    }

    //getters e setters

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



    //retirar carta do baralho
    public void retirarCartas(Carta[] cartasDistribuidas, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            for (int j = 0; j < cartas.length; j++) {
                if (cartas[j] == null || cartasDistribuidas[i] == null) {
                    continue;
                }
                if (cartasDistribuidas[i].getNaipe().equals(cartas[j].getNaipe()) && cartasDistribuidas[i].getValor() == cartas[j].getValor()) {
                    cartas[j] = null;
                }
            }
        }
    }

    //embaralhar cartas e se null, embaralhar novamente
    public Carta embaralharCartas(){
        int indice = gerador.nextInt(52);
        while (cartas[indice] == null) {
            indice = gerador.nextInt(52);
        }
        return cartas[indice];
    }
    

   //distribuir cartas e retirar do baralho
    public Carta[] distribuirCartas(int quantidade) {
        Carta[] cartasDistribuidas = new Carta[quantidade];
        for (int i = 0; i < quantidade; i++) {
            cartasDistribuidas[i] = embaralharCartas();
            retirarCartas(cartasDistribuidas, quantidade);
        }
        return cartasDistribuidas;
    }


}
