package Tabuleiro;

import java.io.Serializable;
/**
 * classe com as funcionalidades de uma peça de dama.
 * @author gilson
 */
@SuppressWarnings("serial")
public class Peça implements Serializable{

	private boolean pordiMover,ehDama;
	private TiposDePeças tipoPeça;
	
	public Peça(int linha,int coluna){
		this.pordiMover = false;
		this.ehDama = false;
	}
	public void novaPartida(TiposDePeças tipoPeça){
		this.tipoPeça = tipoPeça;
		this.pordiMover = false;
		this.ehDama = false;
	}
	public boolean getPordiMover() {
		return this.pordiMover;
	}
	public void setPordiMover(boolean pordi) {
		this.pordiMover = pordi;
	}
	public void setEhDama(boolean ehDama){
		this.ehDama = ehDama;
	}
	public boolean getEhDama(){
		return this.ehDama;
	}
	public void setTipoPeça(TiposDePeças tipoPeça){
		this.tipoPeça = tipoPeça;
	}
	public TiposDePeças getTipoPeça(){
		return this.tipoPeça;
	}
}