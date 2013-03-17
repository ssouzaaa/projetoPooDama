package Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JOptionPane;

import Grafico.GerenteInterface;

@SuppressWarnings("serial")
public class EventoPe�a implements ActionListener,Serializable{
	
	private static int LINHA = -1,COLUNA = -1,CONT = 0;
	private int linha,coluna;
	private GerenteInterface gerente;
	
	public EventoPe�a(int linha, int coluna,GerenteInterface gerente) {
		this.linha = linha;
		this.coluna = coluna;
		this.gerente = gerente;
	}
	public void actionPerformed(ActionEvent e) {
		if(this.gerente.getPordiMover(this.linha, this.coluna)){
			this.gerente.SomPe�a();
			this.gerente.tudoProibido();
			this.gerente.setFinalizar();
			CONT++;
			this.gerente.movimentosDaPe�a(this.linha,this.coluna);
			if(LINHA != -1 & COLUNA != -1){
				this.gerente.trocaDePe�as(LINHA, COLUNA, this.linha, this.coluna);
				this.gerente.seTornouDama(this.linha, this.coluna);
				LINHA = this.linha;
				COLUNA = this.coluna;
				this.gerente.tudoProibido();
				this.gerente.movimentosDaPe�a(this.linha,this.coluna);
			}else{
				LINHA = this.linha;
				COLUNA = this.coluna;
			}
		}else{
			this.gerente.SomJogadarNaoPermitida();
			JOptionPane.showMessageDialog(null,"Jogadar n�o pemitida");
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