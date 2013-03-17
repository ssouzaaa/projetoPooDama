package Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Grafico.GerenteInterface;
import Grafico.Som;
import Tabuleiro.GerenteJogador;

public class EventoCancela implements ActionListener{

	private GerenteInterface gerente;
	
	public EventoCancela(GerenteInterface gerente){
		this.gerente = gerente;
	}
	public void actionPerformed(ActionEvent e) {
		Som som = new Som();
		som.Botao();
		if(EventoPeça.CONT() == 1){
			EventoPeça.ZERACONT();
			this.gerente.tudoProibido();
			EventoPeça.EMVALIDARPOSICAO();
			if(GerenteJogador.GETJOGADORATUAL()){
				this.gerente.jogadaAzul();
			}else{
				this.gerente.jogadaVermelha();
			}
		}else{
			JOptionPane.showMessageDialog(null," Não cancela movimnetos de peças apenas " +
											   "\n cancela a peça que foi clicada.");
		}
	}
}