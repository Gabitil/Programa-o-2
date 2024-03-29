package atividade4;

public class Ponto2D {
    private double x;
    private double y;

    public void Ponto2D(){
        this.x = 0;
        this.y = 0;
    }

    public void Ponto2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void Ponto2D(Ponto2D ponto){
        this.x = ponto.x;
        this.y = ponto.y;
    }

    public double calculaDistancia(Ponto2D ponto){
        return Math.sqrt(Math.pow(ponto.x - this.x, 2) + Math.pow(ponto.y - this.y, 2));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
