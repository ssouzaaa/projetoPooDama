package Tabuleiro;

import java.io.Serializable;

import Evento.EventoPe�a;

import static Tabuleiro.TiposDePe�as.*;

@SuppressWarnings("serial")
public class Tabuleiro implements Serializable{

	private static boolean FOICAPTURADA = false;
	private Pe�a[][] pe�a;
	private boolean foiSalvo;
	private MovimentoDasPe�as movimneto;
	
	public Tabuleiro(){
		this.pe�a = new Pe�a[8][8];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				this.pe�a[i][j] =  new Pe�a(i,j);
			}
		}
		this.novaPartida();
		this.foiSalvo = false;
		this.movimneto = new MovimentoDasPe�as(this.pe�a);
	}
	public static void SETFOICAPTURADA(){
		FOICAPTURADA = false;
	}
	public static boolean GETFOICAPTURADA(){
		return FOICAPTURADA;
	}
	/**
	 * metodo para inicia um novo jogo, restaurando
	 * assim o tabuleiro e as pe�as as suas formas
	 * inicias.
	 */
	public void novaPartida() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(i == 0 || i == 1 || i == 2){
					if(i % 2 == 0){
						if(j % 2 == 0){
							this.pe�a[i][j].novaPartida(EHPE�APRETA);
						}
						else{
							this.pe�a[i][j].novaPartida(EHPE�AAZUL);
						}
					}
					else{
						if(j % 2 == 0){
							this.pe�a[i][j].novaPartida(EHPE�AAZUL);	
						}else{
							this.pe�a[i][j].novaPartida(EHPE�APRETA);
						}
					}
				}
				else if(i == 5 || i == 6 || i == 7){
					if(i % 2 == 0){
						if(j % 2 == 0){
							this.pe�a[i][j].novaPartida(EHPE�APRETA);
						}
						else{
							this.pe�a[i][j].novaPartida(EHPE�AVERMELHA);
						}
					}
					else{
						if(j % 2 == 0){
							this.pe�a[i][j].novaPartida(EHPE�AVERMELHA);
						}
						else{
							this.pe�a[i][j].novaPartida(EHPE�APRETA);
						}
					}
				}else{
					if(i % 2 == 0){
						if(j % 2 == 0){
							this.pe�a[i][j].novaPartida(EHPE�APRETA);
						}
						else{
							this.pe�a[i][j].novaPartida(EHPE�ABRANCA);
						}
					}
					else{
						if(j % 2 == 0){
							this.pe�a[i][j].novaPartida(EHPE�ABRANCA);
						}
						else{
							this.pe�a[i][j].novaPartida(EHPE�APRETA);
						}
					}
				}
			}
		}
	}
	public void movimentosDaPe�a(int linha,int coluna){
		if(this.pe�a[linha][coluna].getEhDama()){
			if(EventoPe�a.LINHA() == -1){
				this.movimneto.movimentoDama(linha, coluna);
			}else{
				this.movimneto.movimentoDeCapturaDaDama(linha, coluna);
			}
		}else{
			this.movimneto.movimentoCapturaPeca(linha, coluna);
			if(EventoPe�a.LINHA() == -1){
				if(this.pe�a[linha][coluna].getTipoPe�a() == EHPE�AAZUL){
					this.movimneto.movimentoNormalAzul(linha, coluna);
				}else{
					this.movimneto.movimentoNormalVermelho(linha, coluna);
				}
			}
		}
	}
	public void setEhDama(int linha,int coluna,boolean ehDama){
		this.pe�a[linha][coluna].setEhDama(ehDama);
	}
	public boolean getEhDama(int linha,int coluna){
		return this.pe�a[linha][coluna].getEhDama();
	}
	public void setTipoDePe�a(int linha,int coluna,TiposDePe�as tipoPe�a){
		this.pe�a[linha][coluna].setTipoPe�a(tipoPe�a);
	}
	public TiposDePe�as getTipoDaPe�a(int linha,int coluna){
		return this.pe�a[linha][coluna].getTipoPe�a();
	}
	public void setPordiMover(int linha,int coluna,boolean pordi){
		this.pe�a[linha][coluna].setPordiMover(pordi);
	}
	public boolean getPordiMover(int linha,int coluna){
		return this.pe�a[linha][coluna].getPordiMover();
	}
	public void jogadaAzul() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.pe�a[i][j].getTipoPe�a() == EHPE�AAZUL){
					this.pe�a[i][j].setPordiMover(true);
				}
			}
		}
	}
	public void jogadaVermelha() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.pe�a[i][j].getTipoPe�a() == EHPE�AVERMELHA){
					this.pe�a[i][j].setPordiMover(true);
				}
			}
		}
	}
	public void tudoProibido() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				this.pe�a[i][j].setPordiMover(false);
			}
		}
	}
	public void setFoiSalvo(boolean foiSalvo){
		this.foiSalvo = foiSalvo;
	}
	public boolean getFoiSalvo(){
		return this.foiSalvo;
	}
}