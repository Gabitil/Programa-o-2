package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dominio.JogoDaForca;
import servicos.TextFileApps;
import java.util.ArrayList;
import java.util.Random;



public class JanelaPrincipal extends JFrame implements ActionListener{
	private String[] auxiliar = {"Q","W","E","R","T","Y","U","I","O","P",
								 "A","S","D","F","G","H","J","K","L","Ç",
								 "Z","X","C","V","B","N","M"};
	
	private JButton botaoNovo;
	private JButton botaoConferir;
	private JButton botaoSair;
	
	private JButton[] botoesLetras;
	
	private JTextField[] letrasPalavra;
	
	
	private JLabel textoAcima;
	
	private JLabel textoAbaixo;
	
	private JPanel botoesSouth;
	private JPanel barraSouth;
	private JPanel center;
	private JPanel teclado;
	private JPanel linha1Letras;
	private JPanel linha2Letras;
	private JPanel linha3Letras;
	
	private JPanel linhaPalavra;

	private JogoDaForca jogo = new JogoDaForca();

	private ArrayList<Integer> posicoes;
	
	public JanelaPrincipal() {
		super("Jogo da Forca");
		setLayout(new BorderLayout());
		instanciarComponentes();
		adicionarComponentes();
		registrarHandlerDeEventos();
		jogo.sorteiaPalavraJogo("palavras7letras");
		posicoes = new ArrayList<Integer>();
	}
	
	
	
	private void instanciarComponentes() {
		botaoNovo = new JButton(" Novo Jogo ");
		botaoConferir = new JButton(" Conferir ");
		botaoSair = new JButton(" Sair ");
		
		botoesLetras = new JButton[27];
		for(int i=0; i<botoesLetras.length; i++) {
			botoesLetras[i] = new JButton(auxiliar[i]);
		}
		
		letrasPalavra = new JTextField[7];
		for(int i = 0; i<letrasPalavra.length;i++) {
			letrasPalavra[i]= new JTextField(" ");
		}
		
		textoAcima = new JLabel(" Adivinhe a palavra");
		
		textoAbaixo = new JLabel( " Você tem 15 tentativas ");
		
		botoesSouth = new JPanel();
		barraSouth = new JPanel();
		center = new JPanel();
		teclado = new JPanel();
		linhaPalavra = new JPanel();
		linha1Letras = new JPanel();
		linha2Letras = new JPanel();
		linha3Letras = new JPanel();

		
	}
	
	private void adicionarComponentes() {
		add(barraSouth, BorderLayout.SOUTH);
		barraSouth.setLayout(new GridLayout(2,1));
		
		barraSouth.add(botoesSouth);
		barraSouth.add(textoAbaixo);
		botoesSouth.setLayout(new GridLayout(1,3));
		botoesSouth.add(botaoNovo);
		botoesSouth.add(botaoConferir);
		botoesSouth.add(botaoSair);
		
		add(textoAcima, BorderLayout.NORTH);
		
		center.setLayout(new GridLayout(2,1));
		add(center, BorderLayout.CENTER);
		
		center.add(linhaPalavra);
		center.add(teclado);
		
		linhaPalavra.setLayout(new GridLayout(1,7));
		for(JTextField campo:letrasPalavra )
			linhaPalavra.add(campo);
		teclado.setLayout(new GridLayout(3,1));
		teclado.add(linha1Letras);
		teclado.add(linha2Letras);
		teclado.add(linha3Letras);
		
		linha1Letras.setLayout(new GridLayout(1,10));
		linha2Letras.setLayout(new GridLayout(1,10));
		linha3Letras.setLayout(new GridLayout(1,7));
		
		for(int i = 0; i< 10; i++) {
			linha1Letras.add(botoesLetras[i]);
		}
		for(int i = 10; i< 20; i++) {
			linha2Letras.add(botoesLetras[i]);
		}
		for(int i = 20; i< 27; i++) {
			linha3Letras.add(botoesLetras[i]);
		}
	}
	
	private void registrarHandlerDeEventos() {
		botaoNovo.addActionListener(this);
		botaoConferir.addActionListener(this);
		botaoSair.addActionListener(this);
		for(JButton botao:botoesLetras)
			botao.addActionListener(this);

		
	}

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == botaoNovo) {
			System.out.println("Novo Jogo");
		} else if (evento.getSource() == botaoConferir) {
			System.out.println("Conferir");
		} else if (evento.getSource() == botaoSair) {
			System.out.println("Sair");
		} else {
			boolean letraEncontrada = false;
			for (int i = 0; i < botoesLetras.length; i++) {
				if (evento.getSource() == botoesLetras[i]) {
					String letra = auxiliar[i];
					ArrayList<Integer> posicoes = jogo.verificaLetra(letra);
					if (posicoes != null) {
						letraEncontrada = true;
						for (int posicao : posicoes) {
							letrasPalavra[posicao].setText(letra);
						}
					}
					break; // Sai do loop após encontrar a letra correspondente
				}
			}
	
			if (!letraEncontrada) {
				jogo.diminuirTentativas(); // Diminui a quantidade de tentativas
			}
	
			if (jogo.verificaFimDoJogo()) {
				if (jogo.getVenceu()) {
					textoAbaixo.setText("Você ganhou");
				} else {
					textoAbaixo.setText("Você perdeu");
				}
			} else {
				textoAbaixo.setText("Número de tentativas: " + jogo.getTentativas());
			}
		}
	}
	
	public static void main(String[] args) {
		JanelaPrincipal janela = new JanelaPrincipal();
		janela.setSize(500,300);
		janela.setVisible(true);
		
	}
}
