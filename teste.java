//programa que lê um numero inteiro e diz se ele e par ou impar
import java.util.Scanner; //importa a classe Scanner do pacote java.util para o programa poder ler dados do teclado 
public class teste { //classe principal do programa 
    public static void main(String[] args) { //metodo principal do programa 
        Scanner input = new Scanner(System.in); //cria um objeto da classe Scanner para ler dados do teclado 
        int num; //declara uma variavel do tipo inteiro
        System.out.println("Digite um numero inteiro: "); //imprime na tela a mensagem entre aspas
        num = input.nextInt(); //le um numero inteiro do teclado e armazena na variavel num 
        if (num % 2 == 0) {
            System.out.println("O numero " + num + " e par"); //imprime na tela a mensagem entre aspas
        } else {
            System.out.println("O numero " + num + " e impar");
        }
    }
}

