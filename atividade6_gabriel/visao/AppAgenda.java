package atividade6_gabriel.visao;

import atividade6_gabriel.negocio.Agenda;
import atividade6_gabriel.negocio.Contato;
import atividade6_gabriel.negocio.ContatoInexistenteException;
import atividade6_gabriel.servicos.ManipulaArquivoTexto;

public class AppAgenda {
    
        public static void main(String[] args) {
            Agenda agenda = new Agenda();
            Contato contato = new Contato("Gabriel", "Rua 1", "1234-5678", "gabriel@gmail.com");
            try{agenda.incluirContato(contato);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Contato contato2 = new Contato("João", "Rua 2", "1234-5678", "joao@gmail.com");
            try{agenda.incluirContato(contato2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Contato contato3 = new Contato("Maria", "Rua 3", "1234-5678", "maria@gmail.com");
            try{agenda.incluirContato(contato3);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                agenda.existeContato("Gabriel");
            } catch (ContatoInexistenteException e) {
                System.out.println(e.getMessage());
            }

            try {
                agenda.existeContato("João");
            } catch (ContatoInexistenteException e) {
                System.out.println(e.getMessage());
            }

            try {
                agenda.existeContato("Maria");
            } catch (ContatoInexistenteException e) {
                System.out.println(e.getMessage());
            }

            try {
                agenda.existeContato("José");
            } catch (ContatoInexistenteException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(agenda.consultarContato("Gabriel"));
            System.out.println(agenda.consultarContato("João"));
            System.out.println(agenda.consultarContato("Maria"));

            try {agenda.removerContato("Gabriel");
            } catch (ContatoInexistenteException e) {
                System.out.println(e.getMessage());
            }
            try {agenda.removerContato("José");
            } catch (ContatoInexistenteException e) {
                System.out.println(e.getMessage());
            }

            try {
                agenda.existeContato("Gabriel");
            } catch (ContatoInexistenteException e) {
                System.out.println(e.getMessage());
            }


            try{agenda.persistirAgenda("contatos.txt");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {agenda.lerAgenda("contatos.txt");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
}
