package copag;

public class Teste {
    public static void main(String[] args) {
        Carta carta1 = new Carta("Paus", 2);

        System.out.print("Olá! A carta de naipe ");
        System.out.print(carta1.getNaipe());
        System.out.println(" foi criada");
        System.out.println("o valor da carta é: " + carta1.getValor());

        Carta carta2 = new Carta("Copas", 3);

        System.out.print("Olá! A carta de naipe ");
        System.out.print(carta2.getNaipe());
        System.out.println(" foi criada");
        System.out.println("o valor da carta é: " + carta2.getValor());

        System.out.println("A carta 1 é maior que a carta 2? " + (carta1.comparaValor(carta2) == 1));
        System.out.println("A carta 1 é menor que a carta 2? " + (carta1.comparaValor(carta2) == -1));
        System.out.println("A carta 1 é igual a carta 2? " + (carta1.comparaValor(carta2) == 0));

        System.out.println("A carta 1 é do mesmo naipe que a carta 2? " + carta1.compararNaipe(carta2));
        
    }
}
