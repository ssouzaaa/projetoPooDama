package Tabuleiro;

import java.io.Serializable;

import Evento.EventoPeça;

import static Tabuleiro.TiposDePeças.*;

@SuppressWarnings("serial")
public class Tabuleiro implements Serializable{

	private static boolean FOICAPTURADA = false;
	private Peça[][] peça;
	private boolean foiSalvo;
	private MovimentoDasPeças movimneto;
	
	public Tabuleiro(){
		this.peça = new Peça[8][8];
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				this.peça[i][j] =  new Peça(i,j);
			}
		}
		this.novaPartida();
		this.foiSalvo = false;
		this.movimneto = new MovimentoDasPeças(this.peça);
	}
	public static void SETFOICAPTURADA(){
		FOICAPTURADA = false;
	}
	public static boolean GETFOICAPTURADA(){
		return FOICAPTURADA;
	}
	/**
	 * metodo para inicia um novo jogo, restaurando
	 * assim o tabuleiro e as peças as suas formas
	 * inicias.
	 */
	public void novaPartida() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(i == 0 || i == 1 || i == 2){
					if(i % 2 == 0){
						if(j % 2 == 0){
							this.peça[i][j].novaPartida(EHPEÇAPRETA);
						}
						else{
							this.peça[i][j].novaPartida(EHPEÇAAZUL);
						}
					}
					else{
						if(j % 2 == 0){
							this.peça[i][j].novaPartida(EHPEÇAAZUL);	
						}else{
							this.peça[i][j].novaPartida(EHPEÇAPRETA);
						}
					}
				}
				else if(i == 5 || i == 6 || i == 7){
					if(i % 2 == 0){
						if(j % 2 == 0){
							this.peça[i][j].novaPartida(EHPEÇAPRETA);
						}
						else{
							this.peça[i][j].novaPartida(EHPEÇAVERMELHA);
						}
					}
					else{
						if(j % 2 == 0){
							this.peça[i][j].novaPartida(EHPEÇAVERMELHA);
						}
						else{
							this.peça[i][j].novaPartida(EHPEÇAPRETA);
						}
					}
				}else{
					if(i % 2 == 0){
						if(j % 2 == 0){
							this.peça[i][j].novaPartida(EHPEÇAPRETA);
						}
						else{
							this.peça[i][j].novaPartida(EHPEÇABRANCA);
						}
					}
					else{
						if(j % 2 == 0){
							this.peça[i][j].novaPartida(EHPEÇABRANCA);
						}
						else{
							this.peça[i][j].novaPartida(EHPEÇAPRETA);
						}
					}
				}
			}
		}
	}
	public void movimentosDaPeça(int linha,int coluna){
		if(this.peça[linha][coluna].getEhDama()){
			if(EventoPeça.LINHA() == -1){
				this.movimneto.movimentoDama(linha, coluna);
			}else{
				this.movimneto.movimentoDeCapturaDaDama(linha, coluna);
			}
		}else{
			this.movimneto.movimentoCapturaPeca(linha, coluna);
			if(EventoPeça.LINHA() == -1){
				if(this.peça[linha][coluna].getTipoPeça() == EHPEÇAAZUL){
					this.movimneto.movimentoNormalAzul(linha, coluna);
				}else{
					this.movimneto.movimentoNormalVermelho(linha, coluna);
				}
			}
		}
	}
	public void setEhDama(int linha,int coluna,boolean ehDama){
		this.peça[linha][coluna].setEhDama(ehDama);
	}
	public boolean getEhDama(int linha,int coluna){
		return this.peça[linha][coluna].getEhDama();
	}
	public void setTipoDePeça(int linha,int coluna,TiposDePeças tipoPeça){
		this.peça[linha][coluna].setTipoPeça(tipoPeça);
	}
	public TiposDePeças getTipoDaPeça(int linha,int coluna){
		return this.peça[linha][coluna].getTipoPeça();
	}
	public void setPordiMover(int linha,int coluna,boolean pordi){
		this.peça[linha][coluna].setPordiMover(pordi);
	}
	public boolean getPordiMover(int linha,int coluna){
		return this.peça[linha][coluna].getPordiMover();
	}
	public void jogadaAzul() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.peça[i][j].getTipoPeça() == EHPEÇAAZUL){
					this.peça[i][j].setPordiMover(true);
				}
			}
		}
	}
	public void jogadaVermelha() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.peça[i][j].getTipoPeça() == EHPEÇAVERMELHA){
					this.peça[i][j].setPordiMover(true);
				}
			}
		}
	}
	public void tudoProibido() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				this.peça[i][j].setPordiMover(false);
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