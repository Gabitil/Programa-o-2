package dominio;


import java.util.ArrayList;

/**
 * This class represents a menu with meals for each day of the week.
 * It contains methods to add, consult, alter and delete meals from the menu.
 */
public class Cardapio {
    private ArrayList<DiasDaSemana> diasDaSemana;

    /**
     * Constructor for the Cardapio class.
     * Initializes the diasDaSemana ArrayList.
     */
    public Cardapio() {
        this.diasDaSemana = new ArrayList<>();
    }

    /**
     * Getter for the diasDaSemana ArrayList.
     * @return The ArrayList of DiasDaSemana objects.
     */
    public ArrayList<DiasDaSemana> getDiasDaSemana() {
        return diasDaSemana;
    }

    /**
     * Setter for the diasDaSemana ArrayList.
     * @param diasDaSemana The ArrayList of DiasDaSemana objects to be set.
     */
    public void setDiasDaSemana(ArrayList<DiasDaSemana> diasDaSemana) {
        this.diasDaSemana = diasDaSemana;
    }

    /**
     * Adds a new meal to the menu.
     * @param descricao The description of the meal.
     * @param vCalorico The caloric value of the meal.
     * @param dia The day of the week for the meal.
     * @param tRefeicao The type of meal (breakfast, lunch, dinner, etc.).
     * @throws DupilicadeException If there is already a meal with the same description in the menu.
     */
    public void incluir(String descricao, double vCalorico, String dia, String tRefeicao) throws DupilicadeException {
        for (DiasDaSemana diasdaSemana : diasDaSemana) {
            for (Refeicao refeicao : diasdaSemana.getRefeicao()) {
                if (refeicao.getDescricao().equals(descricao)) {
                    throw new DupilicadeException("Já existe uma refeição com essa descrição!");
                }
            }
        }
        
        Refeicao refeicao2 = new Refeicao(descricao, vCalorico, tRefeicao);
        
        for (DiasDaSemana diasdaSemana : diasDaSemana) {
            if (diasdaSemana.getDiaSemana().equals(dia)) {
                diasdaSemana.getRefeicao().add(refeicao2);
                return;
            }
        }
        
        // Se o dia não existir, crie um novo DiasDaSemana
        DiasDaSemana novoDia = new DiasDaSemana(dia);
        novoDia.getRefeicao().add(refeicao2);
        diasDaSemana.add(novoDia);
    }

    /**
     * Consults a meal in the menu.
     * @param descricao The description of the meal to be consulted.
     * @param dia The day of the week for the meal to be consulted.
     * @param tRefeicao The type of meal (breakfast, lunch, dinner, etc.) to be consulted.
     * @return The Refeicao object that matches the parameters, or null if it is not found.
     */
    public Refeicao consultar(String descricao, String dia, String tRefeicao){
        for (DiasDaSemana diasdaSemana : diasDaSemana) {
            if (diasdaSemana.getDiaSemana().equals(dia)) {
                for (Refeicao refeicao : diasdaSemana.getRefeicao()) {
                    if (refeicao.getDescricao().equals(descricao) && refeicao.gettRefeicao().equals(tRefeicao)) {
                        return refeicao;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Alters a meal in the menu.
     * @param refeicao The Refeicao object to be altered.
     * @param descricao The new description for the meal.
     * @param vCalorico The new caloric value for the meal.
     */
    public void alterar(Refeicao refeicao, String descricao, double vCalorico){
        refeicao.setDescricao(descricao);
        refeicao.setvCalorico(vCalorico);
    }

    /**
     * Deletes a meal from the menu.
     * @param refeicao The Refeicao object to be deleted.
     */
    public void excluir(Refeicao refeicao) {
        for (DiasDaSemana diasdaSemana : diasDaSemana) {
            if (diasdaSemana.getRefeicao().contains(refeicao)) {
                diasdaSemana.getRefeicao().remove(refeicao);
                break;
            }
        }
    }
}
  