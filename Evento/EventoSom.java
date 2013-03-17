package Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Grafico.GerenteInterface;

public class EventoSom implements ActionListener{

	private static boolean TEMSOM = true;
	private GerenteInterface gerente;
	private JButton som;
	
	public EventoSom(JButton som,GerenteInterface gerente){
		this.gerente = gerente;
		this.som = som;
	}
	public void actionPerformed(ActionEvent e) {
		this.gerente.somBotao();
		if(TEMSOM){
			this.som.setText("Som: não");
			TEMSOM = false;
		}else{
			this.som.setText("Som: sim");
			TEMSOM = true;
		}
	}
	public static boolean TEMSOM(){
		return TEMSOM;
	}
}
