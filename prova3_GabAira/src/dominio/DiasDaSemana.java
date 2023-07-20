package dominio;

import java.util.ArrayList;
import java.util.List;

public class DiasDaSemana {
    private String diaSemana;
    private ArrayList<Refeicao> refeicoes;

    //construtor

    public DiasDaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
        this.refeicoes = new ArrayList<>();
    }

    public DiasDaSemana() {
        this.diaSemana = "";
        this.refeicoes = new ArrayList<>();
    }

    //getters e setters

    public String getDiaSemana() {
        return diaSemana;
    }

    public List<Refeicao> getRefeicao() {
        return refeicoes;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public void setRefeicao(List<Refeicao> refeicoes) {
        this.refeicoes = (ArrayList<Refeicao>) refeicoes;
    }

   

}
