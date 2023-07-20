package atividade4;

import java.util.ArrayList;

public abstract class Forma {
    private ArrayList<Ponto2D> pontos;

    public abstract double calculaArea();
    public abstract double calculaPerimetro();

    public Forma(Ponto2D[] pontos) {
        this.pontos = new ArrayList<Ponto2D>();
        for (int i = 0; i < pontos.length; i++) {
            this.pontos.add(pontos[i]);
        }
    }

    public Ponto2D[] getPontos() {
        return pontos;
    }

    public static Forma geraForma(Ponto2D[] pontos){
        if(pontos.length == 3){
            return new Triangulo(pontos);
        } else if(pontos.length == 4){
            return new Quadrado(pontos);
        } else if(pontos.length == 2){
            return new Circulo(pontos);
        } else {
            return null;
        }
    }

    public boolean verificaTriangulo(){
        if(pontos.length == 3){
            return true;
        } else {
            return false;
        }
    }
    public boolean verificaQuadrado(){
        if(pontos.length == 4){
            return true;
        } else {
            return false;
        }
    }
    public boolean verificaCirculo(){
        if(pontos.length == 2){
            return true;
        } else {
            return false;
        }
    }
    
}
