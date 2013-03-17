package Tabuleiro;

import java.io.Serializable;
/**
 * classe com as funcionalidades de uma pe�a de dama.
 * @author gilson
 */
@SuppressWarnings("serial")
public class Pe�a implements Serializable{

	private boolean pordiMover,ehDama;
	private TiposDePe�as tipoPe�a;
	
	public Pe�a(int linha,int coluna){
		this.pordiMover = false;
		this.ehDama = false;
	}
	public void novaPartida(TiposDePe�as tipoPe�a){
		this.tipoPe�a = tipoPe�a;
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
	public void setTipoPe�a(TiposDePe�as tipoPe�a){
		this.tipoPe�a = tipoPe�a;
	}
	public TiposDePe�as getTipoPe�a(){
		return this.tipoPe�a;
	}
}