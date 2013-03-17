package Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Grafico.*;

public class EventoSalva implements ActionListener{

	private GerenteInterface gerente;
	
	public EventoSalva(GerenteInterface gerente){
		this.gerente = gerente;
	}
	public void actionPerformed(ActionEvent e) {
		if(this.gerente.getFinalizar()){
			this.gerente.setFoiSalvo(true);
			Som som = new Som();
			som.Botao();
			try {
				this.gerente.salvaJogo();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null,e1);
			}
			this.gerente.tornaVisivelOMenu();
		}else{
			JOptionPane.showMessageDialog(null,"Finalize sua jogadar clicando em Ok");
		}
	}
}