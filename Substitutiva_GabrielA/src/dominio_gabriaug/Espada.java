package dominio_gabriaug;

abstract class Espada {
    protected String descricao;
    protected int valor;
    protected char simbolo;
    private static char[] simbolos = {'A', 'B', 'G', 'M', 'P', 'O', 'D'};

    //construtor

    protected Espada(String descricao, int valor, char simbolo) {
        this.descricao = descricao;
        this.valor = valor;
        this.simbolo = simbolo;
    }

    //getters e setters

    public String getDescricao() {
        return descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public static char[] getSimbolos() {
        return simbolos;
    }

    public static void setSimbolos(char[] simbolos) {
        Espada.simbolos = simbolos;
    }

    //metodos

}
