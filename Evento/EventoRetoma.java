package Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Grafico.GerenteInterface;
import Tabuleiro.GerenteJogador;

public class EventoRetoma implements ActionListener{

	private GerenteInterface gerente;
	
	public EventoRetoma(GerenteInterface gerente){
		this.gerente = gerente;
	}
	public void actionPerformed(ActionEvent e) {
		this.gerente.somBotao();
		try {
			this.gerente.retomaJogo();
			this.gerente.tornaVisivelOTabuleiro();
			this.gerente.SomIniciarJogo();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null,e1);
		}
		if(GerenteJogador.GETJOGADORATUAL()){
			this.gerente.setLabelJogadorAtual(this.gerente.getNomeJogador1());
			GerenteJogador.SETJOGADORATUAL(false);
		}else{
			this.gerente.setLabelJogadorAtual(this.gerente.getNomeJogador2());
			GerenteJogador.SETJOGADORATUAL(true);
		}
	}
}