package Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Grafico.GerenteInterface;
import Tabuleiro.GerenteJogador;

public class EventoOk implements ActionListener{

	private GerenteInterface gerente;
	private boolean finalizar;
	
	public EventoOk(GerenteInterface gerente){
		this.gerente = gerente;
		this.finalizar = false;
	}
	public void actionPerformed(ActionEvent e) {
		this.finalizar = true;
		this.gerente.somBotao();
		this.gerente.tudoProibido();
		EventoPeça.EMVALIDARPOSICAO();
		EventoPeça.ZERACONT();
		if(GerenteJogador.GETJOGADORATUAL()){
			this.gerente.setLabelJogadorAtual(this.gerente.getNomeJogador1());
			GerenteJogador.SETJOGADORATUAL(false);
			this.gerente.jogadaAzul();
		}else{
			this.gerente.setLabelJogadorAtual(this.gerente.getNomeJogador2());
			GerenteJogador.SETJOGADORATUAL(true);
			this.gerente.jogadaVermelha();
		}
		String ganhador = this.gerente.ganhador();
		if(ganhador != null){
			JOptionPane.showMessageDialog(null, "Ganhador: " + ganhador);
		}
	}
	public void setFinalizar(){
		this.finalizar = false;
	}
	public boolean getFinalizar(){
		return this.finalizar;
	}
}