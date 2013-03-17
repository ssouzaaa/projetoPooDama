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
				   						   "Curso: Linc. Ciência Da Computação/UFPB – Campos IV \n" +
				                           "Versão Do Jogo: Beta \n" +
										   "Data De Produção: 10/03/2013");
	}

}