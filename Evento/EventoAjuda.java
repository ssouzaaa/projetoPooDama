package Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Grafico.Som;

public class EventoAjuda implements ActionListener{

	public void actionPerformed(ActionEvent e){
		Som som = new Som();
		som.Botao();
		JOptionPane.showMessageDialog(null," O JOGO \n" +
				"O jogador que estiver jogando com as pe�as Azuis come�a \n" +
				"o jogo (que � o primeiro jogado). A seguir, os jogadores \n" +
				"alternam jogadas at� o fim do jogo. As pe�as comuns s� \n" +
				"podem se movimentar para a frente, para uma casa branca \n" +
				"livre na pr�xima linha,diagonal � sua casa atual. \n" +
				"As damas podem ser movimentar em diagonal para frente e \n" +
				"para tr�s para qualquer casa livre, desde que o caminho \n" +
				"esteja livre. O jogo termina quando todas as pe�as de \n" +
				"um jogador forem capturadas.\n" +
				" CAPTURA \n" +
				"As pe�as comuns s� podem capturar para frente e para \n" +
				"tr�s pe�as advers�rias adjacentes �s suas. As damas podem \n" +
				"capturar pe�as distantes na sua diagonal, desde que o \n" +
				"caminho entre a dama e a pe�a capturada esteja livre, \n" +
				"e o caminho entre a pe�a capturada e a casa de destino \n" +
				"da dama esteja tamb�m livre. \n" +
				" REGRA \n" +
				"Ao termina sua jogada devesse clica em OK para passa a \n" +
				"vez para o pr�ximo jogador.Para iniciar uma nova partida \n" +
				"� s� clicar em Nova Partida.Para uma jogadar dupla � s� \n " +
				"clica na porcima casa.\n");
	}
}