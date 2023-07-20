package dominio_gabrielaugus;



public class QuadradoMagico{
    private int[][] tabuleiro;
    private int valor;
    private int valorVitoria;

    public QuadradoMagico(int[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
        this.valor = 0;
        this.valorVitoria = 15;
    }

    public QuadradoMagico(){
        this.tabuleiro = new int[3][3];
        this.valor = 0;
        this.valorVitoria = 15;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void iniciaTabuleiro(){
        for (int i = 0; i < this.tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro[i].length; j++) {
                this.tabuleiro[i][j] = 0;
            }
        }
    }

    public void inserirValor(int linha, int coluna, int valor)  throws IllegalArgumentException{
        if (coluna == 11 && linha == 11 && valor == 11) {
            throw new IllegalArgumentException("Digite novamente para continuar ou 0 0 0 para sair");
        }
        if (valor < 1 || valor > 9) {
            throw new IllegalArgumentException("Valor invalido");
        }
        if (linha < 0 || linha > 2) {
            throw new IllegalArgumentException("Linha invalida");
        }
        if (coluna < 0 || coluna > 2) {
            throw new IllegalArgumentException("Coluna invalida");
        }
        for (int i = 0; i < this.tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro[i].length; j++) {
                if (this.tabuleiro[i][j] == valor) {
                    this.tabuleiro[i][j] = this.tabuleiro[linha][coluna];
                    this.tabuleiro[linha][coluna] = valor;
                    return;
                }
            }
        }
        this.tabuleiro[linha][coluna] = valor;
    }

    public void verificaVitoria() throws JogoInvalidoException{
        int[] somaLinha = new int[3];
        int[] somaColuna = new int[3];
        int somaDiagonalPrincipal = 0;
        int somaDiagonalSecundaria = 0;

        for (int i = 0; i < this.tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro[i].length; j++) {
                somaLinha[i] += this.tabuleiro[i][j];
                somaColuna[j] += this.tabuleiro[i][j];
                if (i == j) {
                    somaDiagonalPrincipal += this.tabuleiro[i][j];
                }
                if (i + j == 2) {
                    somaDiagonalSecundaria += this.tabuleiro[i][j];
                }
            }
        }

        if (somaDiagonalPrincipal != this.valorVitoria || somaDiagonalSecundaria != this.valorVitoria) {
            throw new JogoInvalidoException("Jogo nao acabou");
        }

        for (int i = 0; i < somaLinha.length; i++) {
            if (somaLinha[i] != this.valorVitoria || somaColuna[i] != this.valorVitoria) {
                throw new JogoInvalidoException("Jogo nao acabou");
            }
        }
    }    

    public void imprimeTabuleiro(){
        for (int i = 0; i < this.tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro[i].length; j++) {
                System.out.print(this.tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
}
