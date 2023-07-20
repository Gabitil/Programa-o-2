package dominio_gabriaug;

import java.util.ArrayList;

public class Jogador {
    private ArrayList<Espada> espadas;
    private int pontos = 0;
    private String nome;

    //constructor
    public Jogador(String nome) {
        this.espadas = new ArrayList<>();
        this.nome = nome;
    }

    //getters and setters

    public ArrayList<Espada> getEspadas() {
        return espadas;
    }

    public int getPontos() {
        return pontos;
    }

    public String getNome() {
        return nome;
    }

    public void setEspadas(ArrayList<Espada> espadas) {
        this.espadas = espadas;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //metodos

    public void addEspada(Espada espada){
        this.espadas.add(espada);
    }

    public void gerarEspadas(){
        //gera 1 de cada tipo de espada
        this.espadas.add(new EspadadeAluminio());
        this.espadas.add(new EspadadeBronze());
        this.espadas.add(new EspadadeGelo());
        this.espadas.add(new EspadadeOuro());
        this.espadas.add(new EspadadePlatina());
        this.espadas.add(new EspadadeMadeira());
    }

    public void removeEspada(Espada espada){
        this.espadas.remove(espada);
    }

    public void addPontos(int pontos){
        this.pontos += pontos;
    }

    public void removePontos(int pontos){
        this.pontos -= pontos;
    }

    public void mostrarEspadas(){
        //Mostra os simbolos, descrições e valor de cada espada
        for (Espada espada : this.espadas) {
            System.out.println("Simbolo: " + espada.getSimbolo() + " Descrição: " + espada.getDescricao() + " Valor: " + espada.getValor());
        }
    }

}
