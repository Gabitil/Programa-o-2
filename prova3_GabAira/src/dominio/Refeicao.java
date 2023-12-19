package dominio;

/**
 * This class represents a meal, with a description, caloric value and type of meal.
 */
public class Refeicao {
    private String descricao;
    private double vCalorico;
    private String tRefeicao;

    /**
     * Constructor for the Refeicao class.
     * @param descricao The description of the meal.
     * @param vCalorico The caloric value of the meal.
     * @param tRefeicao The type of meal.
     */
    public Refeicao(String descricao, double vCalorico, String tRefeicao) {
        this.descricao = descricao;
        this.vCalorico = vCalorico;
        this.tRefeicao = tRefeicao;
    }

    /**
     * Default constructor for the Refeicao class.
     */
    public Refeicao() {
        this.descricao = "";
        this.vCalorico = 0;
    }

    //getters e setters

    /**
     * Getter for the description of the meal.
     * @return The description of the meal.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Getter for the caloric value of the meal.
     * @return The caloric value of the meal.
     */
    public double getvCalorico() {
        return vCalorico;
    }

    /**
     * Setter for the description of the meal.
     * @param descricao The new description of the meal.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Setter for the caloric value of the meal.
     * @param vCalorico The new caloric value of the meal.
     */
    public void setvCalorico(double vCalorico) {
        this.vCalorico = vCalorico;
    }

    /**
     * Getter for the type of meal.
     * @return The type of meal.
     */
    public String gettRefeicao() {
        return tRefeicao;
    }

    /**
     * Setter for the type of meal.
     * @param tRefeicao The new type of meal.
     */
    public void settRefeicao(String tRefeicao) {
        this.tRefeicao = tRefeicao;
    }
}
