package dominio;

public class Refeicao {
    private String descricao;
    private double vCalorico;
    private String tRefeicao;

    //construtor
    public Refeicao(String descricao, double vCalorico, String tRefeicao) {
        this.descricao = descricao;
        this.vCalorico = vCalorico;
        this.tRefeicao = tRefeicao;
    }

    public Refeicao() {
        this.descricao = "";
        this.vCalorico = 0;
    }

    //getters e setters

    public String getDescricao() {
        return descricao;
    }

    public double getvCalorico() {
        return vCalorico;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setvCalorico(double vCalorico) {
        this.vCalorico = vCalorico;
    }

    public String gettRefeicao() {
        return tRefeicao;
    }

    public void settRefeicao(String tRefeicao) {
        this.tRefeicao = tRefeicao;
    }


}
