package dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a day of the week and its associated meals.
 */
public class DiasDaSemana {
    private String diaSemana;
    private ArrayList<Refeicao> refeicoes;

    /**
     * Constructs a new instance of DiasDaSemana with the given day of the week.
     * @param diaSemana the day of the week
     */
    public DiasDaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
        this.refeicoes = new ArrayList<>();
    }

    /**
     * Constructs a new instance of DiasDaSemana with an empty day of the week.
     */
    public DiasDaSemana() {
        this.diaSemana = "";
        this.refeicoes = new ArrayList<>();
    }

    /**
     * Returns the day of the week.
     * @return the day of the week
     */
    public String getDiaSemana() {
        return diaSemana;
    }

    /**
     * Returns the list of meals associated with this day of the week.
     * @return the list of meals
     */
    public List<Refeicao> getRefeicao() {
        return refeicoes;
    }

    /**
     * Sets the day of the week.
     * @param diaSemana the day of the week
     */
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    /**
     * Sets the list of meals associated with this day of the week.
     * @param refeicoes the list of meals
     */
    public void setRefeicao(List<Refeicao> refeicoes) {
        this.refeicoes = (ArrayList<Refeicao>) refeicoes;
    }
}
