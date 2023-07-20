package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tabuleiro {
    // Atributos

    private int linhas;
    private int colunas;
    private int tamanho;
    private Peca[][] pecas;
    private int paresAcertados;
    private int paresTotal;
    private int jogadas;
    private int pontos;
    private boolean fim;
    private Random random;

    // Construtor

    public Tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.tamanho = linhas * colunas;
        this.pecas = new Peca[linhas][colunas];
        this.paresAcertados = 0;
        this.paresTotal = tamanho / 2;
        this.jogadas = 0;
        this.pontos = 0;
        this.random = new Random();
        gerarPecas();
    }

    // Getters e Setters

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Peca[][] getPecas() {
        return pecas;
    }

    public int getParesAcertados() {
        return paresAcertados;
    }

    public int getParesTotal() {
        return paresTotal;
    }

    public int getJogadas() {
        return jogadas;
    }

    public int getPontos() {
        return pontos;
    }

    public boolean isFim() {
        return fim;
    }

    // Metodos

    private void gerarPecas() {
        List<String> valores = new ArrayList<>();
        char linhaInicial = 'A';
        char colunaInicial = 'A';
    
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                valores.add(String.valueOf(linhaInicial) + String.valueOf(colunaInicial));
                colunaInicial++;
            }
            linhaInicial++;
        }
    
        int paresCriados = 0;
    
        while (paresCriados < paresTotal) {
            int index = random.nextInt(valores.size());
            String valor = valores.get(index);
            valores.remove(index);
    
            int linha1 = random.nextInt(linhas);
            int coluna1 = random.nextInt(colunas);
    
            if (pecas[linha1][coluna1] == null) {
                pecas[linha1][coluna1] = new Peca(valor);
                paresCriados++;
    
                int linha2;
                int coluna2;
    
                do {
                    linha2 = random.nextInt(linhas);
                    coluna2 = random.nextInt(colunas);
                } while (pecas[linha2][coluna2] != null);
    
                pecas[linha2][coluna2] = new Peca(valor);
                paresCriados++;
            }
        }
    }
    

    public void virarPeca(int linha1, int coluna1, int linha2, int coluna2) {
        if (pecas[linha1][coluna1].getVirada() == 0 && pecas[linha2][coluna2].getVirada() == 0) {
            pecas[linha1][coluna1].virar();
            pecas[linha2][coluna2].virar();
            jogadas++;
        }
    }

    public boolean verificarPares(int linha1, int coluna1, int linha2, int coluna2) {
        if (pecas[linha1][coluna1].equals(pecas[linha2][coluna2])) {
            paresAcertados++;
            pontos += 10;
            return true;
        } else {
            pontos -= 2;
            pecas[linha1][coluna1].virar();
            pecas[linha2][coluna2].virar();
            return false;
        }
    }

    public boolean verificarFim() {
        return paresAcertados == paresTotal;
    }

    @Override
    public String toString() {
        String tabuleiro = "";
    
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                tabuleiro += pecas[linha][coluna].getValorVisual() + " ";
            }
            tabuleiro += "\n";
        }
    
        return tabuleiro;
    }


}    