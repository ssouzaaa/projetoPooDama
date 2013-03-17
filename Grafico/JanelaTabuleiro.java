package Grafico;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

import Evento.*;

public class JanelaTabuleiro extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private EventoOk eventoOk;
	private EventoCancela eventoCancela;
	private EventoNovaPartida eventoNova;
	private EventoVolta eventoVolta;
	private EventoSalva eventoSalva;
	private PeçaInterface[][] peça;
	private JButton ok,Cancela,novaJogo,salva,sair;
	private JLabel label;
	
	public JanelaTabuleiro(){
		super("DAMA");
	}
	public void setJanelaTabuleiro(PeçaInterface[][] peça,GerenteInterface gerente){
		this.peça = peça;
		this.ok = new JButton("OK");
		this.Cancela = new JButton("Cancela");
		this.novaJogo = new JButton("Novo Jogo");
		this.salva = new JButton("Salva");
		this.sair = new JButton("Volta");
		this.eventoOk = new EventoOk(gerente);
		this.eventoCancela = new EventoCancela(gerente);
		this.eventoNova = new EventoNovaPartida(gerente);
		this.eventoSalva = new EventoSalva(gerente);
		this.eventoVolta = new EventoVolta(gerente);
		Container c = getContentPane();
		Container c1 = new JPanel();
		this.label = new JLabel("Jogador atual: ");
		this.label.setForeground(Color.blue);
		Container c2 = new JPanel();
		c1.setLayout(new GridLayout(8,8,4,4));
		BorderLayout border = new BorderLayout();
		c.setLayout(border);
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				c1.add(this.peça[i][j].getBotao());
			}
		}
		c.add(BorderLayout.CENTER,c1);
		c2.setLayout(new GridLayout(1,6,4,4));
		c2.add(this.ok);
		c2.add(this.Cancela);
		c2.add(this.novaJogo);
		c2.add(this.salva);
		c2.add(this.sair);
		c.add(BorderLayout.SOUTH,c2);
		c.add(BorderLayout.NORTH,this.label);
		this.ok.addActionListener(this.eventoOk);
		this.Cancela.addActionListener(this.eventoCancela);
		this.novaJogo.addActionListener(this.eventoNova);
		this.salva.addActionListener(this.eventoSalva);
		this.sair.addActionListener(this.eventoVolta);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,620);
		setVisible(false);
		setResizable(false);
	}
	public void setLabelJogadorAtual(String nome){
		this.label.setText(" Jogador Atual: " + nome);
	}
	public void setFinalizar(){
		this.eventoOk.setFinalizar();
	}
	public boolean getFinalizar(){
		return this.eventoOk.getFinalizar();
	}
}