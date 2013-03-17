package Imagens;

import java.io.Serializable;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Imagens implements Serializable{

	private ImageIcon branco,preto,Circulo_azul,Circulo_azulDama,Circulo_vermelho,Circulo_vermelhoDama,label;
	
	public Imagens(){
		this.label = new ImageIcon(getClass().getResource("fotos/damaGif.gif"));
		this.branco = new ImageIcon(getClass().getResource("fotos/branco.jpg"));
		this.preto = new ImageIcon(getClass().getResource("fotos/02.jpg"));
		this.Circulo_azul = new ImageIcon(getClass().getResource("fotos/circulo_azul.png"));
		this.Circulo_azulDama = new ImageIcon(getClass().getResource("fotos/circulo_azulDama.png"));
		this.Circulo_vermelho = new ImageIcon(getClass().getResource("fotos/circulo_vermelho.png"));
		this.Circulo_vermelhoDama = new ImageIcon(getClass().getResource("fotos/circulo_vermelhoDama.png"));
	}
	public ImageIcon getLabel(){
		return this.label;
	}
	public ImageIcon getBranco(){
		return this.branco;
	}
	public ImageIcon getPreto(){
		return this.preto;
	}
	public ImageIcon getAzul(){
		return this.Circulo_azul;
	}
	public ImageIcon getAzulDama(){
		return this.Circulo_azulDama;
	}
	public ImageIcon getVermelho(){
		return this.Circulo_vermelho;
	}
	public ImageIcon getVermelhoDama(){
		return this.Circulo_vermelhoDama;
	}
}