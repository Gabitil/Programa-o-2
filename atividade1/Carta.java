package atividade1;

public class Carta {
    private String naipe;
    private int valor;

    

    public Carta() {
        naipe = "";
        valor = 0;
    }

    public Carta ( String naipe, int valor ) {
        this.naipe = naipe;
        this.valor = valor;
    }


    public String getNaipe(){
        return naipe;
    }

    public void setNaipe(String naipe){
       this.naipe= naipe;
    }

    public int getValor(){
        return valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public int comparaValor(Carta carta){
        if (carta.getValor() > this.valor) {
            return 1;
        } else if (carta.getValor() < this.valor) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean compararNaipe(Carta carta){
        if (carta.getNaipe().equals(this.naipe)) {
            return true;
        } else {
            return false;
        }
    }
}
