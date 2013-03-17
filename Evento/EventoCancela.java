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
		if(EventoPe�a.CONT() == 1){
			EventoPe�a.ZERACONT();
			this.gerente.tudoProibido();
			EventoPe�a.EMVALIDARPOSICAO();
			if(GerenteJogador.GETJOGADORATUAL()){
				this.gerente.jogadaAzul();
			}else{
				this.gerente.jogadaVermelha();
			}
		}else{
			JOptionPane.showMessageDialog(null," N�o cancela movimnetos de pe�as apenas " +
											   "\n cancela a pe�a que foi clicada.");
		}
	}
}