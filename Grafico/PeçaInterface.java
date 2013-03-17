package Grafico;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Evento.EventoPeça;

public class PeçaInterface{

	private JButton peçaBotao;
	private EventoPeça evento;
	
	public PeçaInterface(int linha, int coluna, GerenteInterface gerente) {
		this.peçaBotao = new JButton();
		this.evento = new EventoPeça(linha,coluna,gerente);
		this.peçaBotao.addActionListener(this.evento);
	}
	public JButton getBotao() {
		return this.peçaBotao;
	}
	public void setImagemBotao(ImageIcon i) {
		this.peçaBotao.setIcon(i);
	}
}