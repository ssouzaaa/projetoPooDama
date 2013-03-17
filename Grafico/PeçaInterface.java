package Grafico;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Evento.EventoPe�a;

public class Pe�aInterface{

	private JButton pe�aBotao;
	private EventoPe�a evento;
	
	public Pe�aInterface(int linha, int coluna, GerenteInterface gerente) {
		this.pe�aBotao = new JButton();
		this.evento = new EventoPe�a(linha,coluna,gerente);
		this.pe�aBotao.addActionListener(this.evento);
	}
	public JButton getBotao() {
		return this.pe�aBotao;
	}
	public void setImagemBotao(ImageIcon i) {
		this.pe�aBotao.setIcon(i);
	}
}