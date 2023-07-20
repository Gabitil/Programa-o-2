package Lol;

    public class App {
    public static void main(String[] args) {
        Stack list = new Stack();
        list.push("Joao"); list.push("Maria"); list.push("Jose");
       
        while(!list.empty()){
            System.out.println((String)list.pop());
        }
    }
    }
    