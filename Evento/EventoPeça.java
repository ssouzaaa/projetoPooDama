package Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JOptionPane;

import Grafico.GerenteInterface;

@SuppressWarnings("serial")
public class EventoPeça implements ActionListener,Serializable{
	
	private static int LINHA = -1,COLUNA = -1,CONT = 0;
	private int linha,coluna;
	private GerenteInterface gerente;
	
	public EventoPeça(int linha, int coluna,GerenteInterface gerente) {
		this.linha = linha;
		this.coluna = coluna;
		this.gerente = gerente;
	}
	public void actionPerformed(ActionEvent e) {
		if(this.gerente.getPordiMover(this.linha, this.coluna)){
			this.gerente.SomPeça();
			this.gerente.tudoProibido();
			this.gerente.setFinalizar();
			CONT++;
			this.gerente.movimentosDaPeça(this.linha,this.coluna);
			if(LINHA != -1 & COLUNA != -1){
				this.gerente.trocaDePeças(LINHA, COLUNA, this.linha, this.coluna);
				this.gerente.seTornouDama(this.linha, this.coluna);
				LINHA = this.linha;
				COLUNA = this.coluna;
				this.gerente.tudoProibido();
				this.gerente.movimentosDaPeça(this.linha,this.coluna);
			}else{
				LINHA = this.linha;
				COLUNA = this.coluna;
			}
		}else{
			this.gerente.SomJogadarNaoPermitida();
			JOptionPane.showMessageDialog(null,"Jogadar não pemitida");
		}
	}
	public static void ZERACONT(){
		CONT = 0;
	}
	public static int CONT(){
		return CONT;
	}
	public static void EMVALIDARPOSICAO(){
		LINHA = -1;
		COLUNA = -1;
	}
	public static int LINHA(){
		return LINHA;
	}
	public static int COLUNA(){
		return COLUNA;
	}
}