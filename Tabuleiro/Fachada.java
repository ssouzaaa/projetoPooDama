package Tabuleiro;

import java.io.IOException;

import Arquivo.Gravador;

/**
 * classe para distibui as funcionalidades das para as classes experts.
 * @author gilson
 *
 */
public class Fachada{

	private GerenteJogador gerenteJogador;
	private Tabuleiro tabuleiro;
	private Gravador gravador;
	/**
	 * construto da classe, se tive com um jogo salvo ja é iniciador com os dados
	 * que estam salvos caso contrario é dado new no gerenteJogador e em tabuleiro.
	 */
	public Fachada(){
		this.gravador = new Gravador();
		this.gerenteJogador = new GerenteJogador();
		this.tabuleiro = new Tabuleiro();
		/*try {
			this.gerenteJogador = this.gravador.lerJogado();
		} catch (IOException e) {
			this.gerenteJogador = new GerenteJogador();
		}
		try {
			this.tabuleiro = this.gravador.lerTabuleiro();
		} catch (IOException e) {
			this.tabuleiro = new Tabuleiro();
		}*/
	}
	/**
	 * método para iniciar o jogo de damas.
	 * @param nome que é o nome do primeiro jogador.
	 * @param nome2 que é o nome do segundo jogador.
	 */
	public void iniciarPartida(String nome,String nome2){
		this.gerenteJogador.setNomeJogador1(nome);
		this.gerenteJogador.setNomeJogador2(nome2);
		this.gerenteJogador.novaPartida();
		this.novaPartida();
	}
	/**
	 * método para retoma o jogo que foi salvo.
	 * @throws IOException se não tive nenhum arquivo salvo.
	 */
	public void retomaJogo() throws IOException{
		this.gerenteJogador = this.gravador.lerJogado();
		this.tabuleiro = this.gravador.lerTabuleiro();
	}
	/**
	 * método para salva o jogo.
	 * @throws IOException se não conseguir salva.
	 */
	public void salvaJogo() throws IOException{
		this.gravador.gravaTabuleiro(this.tabuleiro);
		this.gravador.gravaJogado(this.gerenteJogador);
	}
	/**
	 * método que altera os valores e tipos das peças para as posições inicias do jogo.
	 */
	public void novaPartida(){
		this.gerenteJogador.novaPartida();
		this.tabuleiro.novaPartida();
		this.tabuleiro.tudoProibido();
		this.tabuleiro.jogadaAzul();
	}
	/**
	 * método para fazer os movimentos das peças.A linha e coluna endica a posição da peça na matriz.
	 * @param linha posição da peça.
	 * @param coluna posição da peça.
	 */
	public void movimentosDaPeça(int linha,int coluna){
		this.tabuleiro.movimentosDaPeça(linha, coluna);
	}
	/**
	 * método para subtrair um ponto do primeiro jogador.
	 */
	public void setPontoJogador1(){
		this.gerenteJogador.setPontoJogador1();
	}
	/**
	 * método para subtrair um ponto do segundo jogador.
	 */
	public void setPontoJogador2(){
		this.gerenteJogador.setPontoJogador2();
	}
	/**
	 * método que retorna o nome do primeiro jogador.
	 * @return um String.
	 */
	public String getNomeJogador1(){
		return this.gerenteJogador.getNomeJogado1();
	}
	/**
	 * método que retorna o nome do segundo jogador.
	 * @return um String.
	 */
	public String getNomeJogador2(){
		return this.gerenteJogador.getNomeJogador2();
	}
	/**
	 * método que retorna o nome do jogador que ganhou o jogo,
	 * caso nenhum tenha ganhador ainda retorna null.
	 * @return o nome do ganhador do jogo.
	 */
	public String ganhador(){
		return this.gerenteJogador.ganhador();
	}
	/**
	 * método para altera uma peça normal para uma dama e vice-versa,
	 * que recebe como paramento a posição da peça.
	 * @param linha posição da peça.
	 * @param coluna posição da peça.
	 * @param ehDama um boolean que endica se é dama true ou se é uma peça normal false.
	 */
	public void setEhDama(int linha,int coluna,boolean ehDama){
		this.tabuleiro.setEhDama(linha, coluna, ehDama);
	}
	/**
	 * método que retorna um boolean que endica se a peça é uma dama ou não, que recebe 
	 * como paramento a posição da peça na matriz.
	 * @param linha posição da peça.
	 * @param coluna posição da peça.
	 * @return um boolean que endica se é ou não uma dama.
	 */
	public boolean getEhDama(int linha,int coluna){
		return this.tabuleiro.getEhDama(linha, coluna);
	}
	/**
	 * método que autera o tipo da peça se é uma peça azul, vermelha etc.
	 * que recebe como paramento a posição da peça e o tipo da peça.
	 * @param linha posição da peça.
	 * @param coluna posição da peça.
	 * @param tipoPeça é Enum que endica o tipo da peça que pordi ser 
	 * EHPEÇABRANCA,EHPEÇAPRETA,EHPEÇAVERMELHA,EHPEÇAAZUL.
	 */
	public void setTipoDePeça(int linha,int coluna,TiposDePeças tipoPeça){
		this.tabuleiro.setTipoDePeça(linha, coluna, tipoPeça);
	}
	/**
	 * método que retorna um Enum que endica o tipo da peça, que
	 * foi passada como paramento.
	 * @param linha posição da peça.
	 * @param coluna posição da peça.
	 * @return um Enum que endica o tipo da peça.
	 */
	public TiposDePeças getTipoDaPeça(int linha,int coluna){
		return this.tabuleiro.getTipoDaPeça(linha, coluna);
	}
	/**
	 * método que autera um valor boolean na peça que endica se essa
	 * peça pordi ou não se clicada para fazer o movimento da peça.
	 * @param linha posição da peça.
	 * @param coluna posição da peça.
	 * @param pordi um boolean que endica se pordi ou não mover a peça.
	 */
	public void setPordiMover(int linha,int coluna,boolean pordi){
		this.tabuleiro.setPordiMover(linha, coluna, pordi);
	}
	/**
	 * método que retorna um boolean que endica se pordi ou não
	 * mover a peça ou clica na peça.
	 * @param linha posição da peça.
	 * @param coluna posição da peça.
	 * @return um boolean que endica se pordi ou não mover a peça.
	 */
	public boolean getPordiMover(int linha,int coluna){
		return this.tabuleiro.getPordiMover(linha, coluna);
	}
	/**
	 * método que torna todas as peça azuis possives de serem clicada
	 * ou movidas de lugar.
	 */
	public void jogadaAzul(){
		this.tabuleiro.jogadaAzul();
	}
	/**
	 * método que torna todas as peça vermelhas possives de serem clicada
	 * ou movidas de lugar.
	 */
	public void jogadaVermelha(){
		this.tabuleiro.jogadaVermelha();
	}
	/**
	 * método que torna todas as peças imposives de serem clicadas ou movidas.
	 */
	public void tudoProibido(){
		this.tabuleiro.tudoProibido();
	}
	/**
	 * método que autera para true ou false uma variavel que endica se
	 * o jogo foi salvo ou não.
	 * @param foiSalvo um boolean se foi true o jogo foi salvo se foi false o jogo
	 * não foi salvo.
	 */
	public void setFoiSalvo(boolean foiSalvo){
		this.tabuleiro.setFoiSalvo(foiSalvo);
	}
	/**
	 * método retorna um boolean que endica se foi salvo ou não o jogo.
	 * @return um boolean se for true foi salvo se foi false não foi salvo o jogo.
	 */
	public boolean getFoiSalvo(){
		return this.tabuleiro.getFoiSalvo();
	}
}