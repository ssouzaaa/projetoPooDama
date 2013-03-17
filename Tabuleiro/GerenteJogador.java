package Tabuleiro;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GerenteJogador implements Serializable{
	/**
	 * JOGADORATUAL endica qual é o jogador que esta fazendo os movimentos
	 * quando esta true é o jogador1, false é o jogador2.
	 */
	private static boolean JOGADORATUAL = true;
	private Jogador jogador1,jogador2;
	
	public GerenteJogador(){
		this.jogador1 = new Jogador();
		this.jogador2 = new Jogador();
	}
	public String ganhador(){
		if(this.jogador1.getPonto() == 0){
			return this.jogador2.getNome();
		}else if(this.jogador2.getPonto() == 0){
			return this.jogador1.getNome();
		}
		return null;
	}
	public static void SETJOGADORATUAL(boolean jogadorAtual){
		JOGADORATUAL = jogadorAtual;
	}
	public static boolean GETJOGADORATUAL(){
		return JOGADORATUAL;
	}
	public void setNomeJogador1(String nome){
		this.jogador1.setNome(nome);
	}
	public void setNomeJogador2(String nome){
		this.jogador2.setNome(nome);
	}
	public String getNomeJogado1(){
		return this.jogador1.getNome();
	}
	public String getNomeJogador2(){
		return this.jogador2.getNome();
	}
	public void setPontoJogador1(){
		this.jogador1.setPonto();
	}
	public void setPontoJogador2(){
		this.jogador2.setPonto();
	}
	public int getpontoJogador1(){
		return this.jogador1.getPonto();
	}
	public int getpontoJogador2(){
		return this.jogador2.getPonto();
	}
	public void novaPartida(){
		this.jogador1.novaPartida();
		this.jogador2.novaPartida();
		JOGADORATUAL = false;
	}
}
