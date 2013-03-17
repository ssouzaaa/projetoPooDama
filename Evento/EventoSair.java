package Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Grafico.Som;

public class EventoSair implements ActionListener{

	private static final int DISPOSE_ON_CLOSE = 0;

	public void actionPerformed(ActionEvent e) {
		Som som = new Som();
		som.Botao();
		System.exit(DISPOSE_ON_CLOSE);
	}
}