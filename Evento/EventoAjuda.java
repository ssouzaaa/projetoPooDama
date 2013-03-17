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
				"O jogador que estiver jogando com as peças Azuis começa \n" +
				"o jogo (que é o primeiro jogado). A seguir, os jogadores \n" +
				"alternam jogadas até o fim do jogo. As peças comuns só \n" +
				"podem se movimentar para a frente, para uma casa branca \n" +
				"livre na próxima linha,diagonal à sua casa atual. \n" +
				"As damas podem ser movimentar em diagonal para frente e \n" +
				"para trás para qualquer casa livre, desde que o caminho \n" +
				"esteja livre. O jogo termina quando todas as peças de \n" +
				"um jogador forem capturadas.\n" +
				" CAPTURA \n" +
				"As peças comuns só podem capturar para frente e para \n" +
				"trás peças adversárias adjacentes às suas. As damas podem \n" +
				"capturar peças distantes na sua diagonal, desde que o \n" +
				"caminho entre a dama e a peça capturada esteja livre, \n" +
				"e o caminho entre a peça capturada e a casa de destino \n" +
				"da dama esteja também livre. \n" +
				" REGRA \n" +
				"Ao termina sua jogada devesse clica em OK para passa a \n" +
				"vez para o próximo jogador.Para iniciar uma nova partida \n" +
				"é só clicar em Nova Partida.Para uma jogadar dupla é só \n " +
				"clica na porcima casa.\n");
	}
}