package Tabuleiro;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Jogador implements Serializable{

	private int ponto;
	private String nome;
	
	public Jogador(){
		this("");
	}
	public Jogador(String nome){
		this.ponto = 12;
		this.nome = nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	public void setPonto(){
		this.ponto--;
	}
	public void novaPartida(){
		this.ponto = 12;
	}
	public int getPonto(){
		return this.ponto;
	}
}