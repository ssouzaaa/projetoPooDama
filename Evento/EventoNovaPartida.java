package Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Grafico.GerenteInterface;

public class EventoNovaPartida implements ActionListener{

	private GerenteInterface gerente;
	
	public EventoNovaPartida(GerenteInterface gerente){
		this.gerente = gerente;
	}
	public void actionPerformed(ActionEvent e) {
		this.gerente.somBotao();
		this.gerente.novaPartida();
		EventoPeça.EMVALIDARPOSICAO();
	}
}