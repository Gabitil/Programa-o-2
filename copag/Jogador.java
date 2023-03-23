package copag;

public class Jogador {
    private Carta[] cartas;
    private int quantidade;

    //construtor
    public Jogador() {
        cartas = new Carta[quantidade];
    }

    public Jogador(Carta[] cartas, int quantidade) {
        this.cartas = cartas;
        this.quantidade = quantidade;
    }

    //getters e setters

    public Carta[] getCartas() {
        return cartas;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    //retorna a maior carta do jogador
    public Carta maiorCarta() {
        Carta maiorCarta = cartas[0];
        for (int i = 1; i < quantidade; i++) {
            if (cartas[i].getValor() > maiorCarta.getValor()) {//
                maiorCarta = cartas[i];
            }
        }
        return maiorCarta;
    }

    //mostra as cartas do jogador
    public void mostrarCartas() {
        for (int i = 0; i < quantidade; i++) {
            System.out.println(cartas[i].getValor() + " de " + cartas[i].getNaipe());
        }
    }



    
}
