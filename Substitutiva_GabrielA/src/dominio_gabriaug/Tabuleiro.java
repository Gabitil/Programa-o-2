package dominio_gabriaug;

public class Tabuleiro {
    //tabuleiro 13 por 13 em que jogadores posicionam as espadas e depois escolhem a posição para atacar na matriz
    private Espada[][] tabuleiroj;
    private int tamanho = 13;
    private Jogador jogador;
    private int posicaoX;
    private int posicaoY;

    //construtor

    public Tabuleiro( Jogador jogador) {
        this.jogador = jogador;
        this.tabuleiroj = new Espada[tamanho][tamanho];
    }

    //getters e setters

    public Espada[][] getTabuleiroj() {
        return tabuleiroj;
    }

    public int getTamanho() {
        return tamanho;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setTabuleiroj(Espada[][] tabuleiro) {
        this.tabuleiroj = tabuleiro;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    //metodos

    public void posicionarEspada(Espada espada, int x, int y){
        //posiciona a espada no tabuleiro
        this.tabuleiroj[x][y] = espada;
    }

    public Espada selecionaEspada(char simbolo){
        //seleciona a espada que o jogador quer usar
        for (Espada espada : this.jogador.getEspadas()) {
            if (espada.getSimbolo() == simbolo) {
                return espada;
            }
        }
        return null;
    }

    public boolean atacarEspada(int x, int y){
        //ataca a espada na posição x,y
        if(this.tabuleiroj[x][y] != null){
            this.tabuleiroj[x][y] = new EspadaDestruida();

            return true;
        } else if (this.tabuleiroj[x][y] != null && this.tabuleiroj[x][y].getSimbolo() == 'D'){ //se a espada ja foi destruida
            System.out.println("Espada ja foi destruida");
            return false;
        }
        else if (this.tabuleiroj[x][y] == null){ //se não tem espada na posição
            System.out.println("Não tem espada na posição");
            return false;
        }
        return false;
    }

    public void imprimirTabuleiro(){
        //imprime o tabuleiro os simbolos das espadas ou o simbulos de espada destruida
        for(int i=0; i<this.tamanho; i++){
            for(int j=0; j<this.tamanho; j++){
                if(this.tabuleiroj[i][j] != null && this.tabuleiroj[i][j].getSimbolo() == 'D'){ //se a espada foi destruida
                    System.out.print(this.tabuleiroj[i][j].getSimbolo()+" ");
                }
                else if (this.tabuleiroj[i][j] == null || this.tabuleiroj[i][j] != null){ 
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
