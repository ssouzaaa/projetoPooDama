package Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import Grafico.GerenteInterface;

public class EventoVolta implements ActionListener{

	private GerenteInterface gerente;
	
	public EventoVolta(GerenteInterface gerente){
		this.gerente = gerente;
	}
	public void actionPerformed(ActionEvent e) {
		this.gerente.somBotao();
		File file = new File("dama.txt"),file2 = new File("jogado.txt");;
		if(file.exists()){
			file.delete();
		}
		if(file2.exists()){
			file2.delete();
		}
		this.gerente.tornaVisivelOMenu();
	}
}