package Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Grafico.Som;

public class EventoSobre implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		Som som = new Som();
		som.Botao();
		JOptionPane.showMessageDialog(null,"Desenvolvedores: Gilson Trajano Soares Costa \n" +
										   "                                   Italo Dantas de Souza \n" +
				   						   "Curso: Linc. Ci�ncia Da Computa��o/UFPB � Campos IV \n" +
				                           "Vers�o Do Jogo: Beta \n" +
										   "Data De Produ��o: 10/03/2013");
	}

}