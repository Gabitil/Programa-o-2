package floricultura;


public class Teste {
    public static void main(String[] args) {
        Produto flor;
        flor = new Produto();

        flor.setDescricao("violeta");
        flor.setPreco(2.0);
        flor.setCodigo(1);

        System.out.println(flor.getDescricao());
        System.out.println(flor.getPreco());
        System.out.println(flor.getCodigo());

    }
}
