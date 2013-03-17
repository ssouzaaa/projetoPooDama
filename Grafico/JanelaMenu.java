package Grafico;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Evento.*;
import Imagens.Imagens;

@SuppressWarnings("serial")
public class JanelaMenu extends JFrame{

	private Imagens imagens;
	private JButton iniciar,retoma,ajuda,sobre,som,sair;
	private EventoIniciar eventoIniciar;
	private EventoRetoma eventoRetoma;
	private EventoAjuda eventoAjuda;
	private EventoSobre eventoSobre;
	private EventoSom eventoSom;
	private EventoSair eventoSair;
	
	public JanelaMenu(GerenteInterface gerente){
		super("Jogo De Dama");
		this.iniciar = new JButton("Iniciar Jogo");
		this.retoma = new JButton("Retoma Jogo");
		this.ajuda = new JButton("Ajuda");
		this.sobre = new JButton("Sobre");
		this.som = new JButton("Som: sim");
		this.sair = new JButton("Sair");
		this.eventoIniciar = new EventoIniciar(gerente);
		this.eventoRetoma = new EventoRetoma(gerente);
		this.eventoSobre = new EventoSobre();
		this.eventoAjuda = new EventoAjuda();
		this.eventoSom = new EventoSom(this.som,gerente);
		this.eventoSair = new EventoSair();
		Container c1 = new JPanel();
		this.imagens = new Imagens();
		JLabel imagens = new JLabel(this.imagens.getLabel());
		
		c1.setLayout(new GridLayout(6,1,0,4));
		Container container = getContentPane();
		BorderLayout border = new BorderLayout();
		container.setLayout(border);
		
		c1.add(this.iniciar);
		c1.add(this.retoma);
		c1.add(this.som);
		c1.add(this.ajuda);
		c1.add(this.sobre);
		c1.add(this.sair);
		
		container.add(imagens);
		container.add(BorderLayout.WEST,c1);
		this.iniciar.addActionListener(this.eventoIniciar);// ADICIONADO O EVENTO AO BOTÃO
		this.retoma.addActionListener(this.eventoRetoma);
		this.ajuda.addActionListener(this.eventoAjuda);
		this.sobre.addActionListener(this.eventoSobre);
		this.som.addActionListener(eventoSom);
		this.sair.addActionListener(this.eventoSair);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // COLOCA A JANELA NO MEIO DA TELA
		setSize(300,210);// TAMANHO DA TELA 300 190
		setVisible(true);// VISIBILEDADA DA TELA
		setResizable(false);
	}
}