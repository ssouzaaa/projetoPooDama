package Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Grafico.*;
import Tabuleiro.GerenteJogador;

public class EventoIniciar implements ActionListener{

	private GerenteInterface gerente;
	
	public EventoIniciar(GerenteInterface gerente){
		this.gerente = gerente;
	}
	public void actionPerformed(ActionEvent e) {
		this.gerente.somBotao();
		EventoPeça.EMVALIDARPOSICAO();
		String nome = JOptionPane.showInputDialog(" Informe o Nome \n Do Primeiro Jogado: ");
		String nome2 = JOptionPane.showInputDialog(" Informe o Nome \n Do Segundo Jogado: ");
		this.gerente.iniciarPartida(nome, nome2);
		GerenteJogador.SETJOGADORATUAL(false);
		this.gerente.tornaVisivelOTabuleiro();
		this.gerente.SomIniciarJogo();
	}
}