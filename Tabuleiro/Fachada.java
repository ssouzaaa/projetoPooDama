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
	 * construto da classe, se tive com um jogo salvo ja � iniciador com os dados
	 * que estam salvos caso contrario � dado new no gerenteJogador e em tabuleiro.
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
	 * m�todo para iniciar o jogo de damas.
	 * @param nome que � o nome do primeiro jogador.
	 * @param nome2 que � o nome do segundo jogador.
	 */
	public void iniciarPartida(String nome,String nome2){
		this.gerenteJogador.setNomeJogador1(nome);
		this.gerenteJogador.setNomeJogador2(nome2);
		this.gerenteJogador.novaPartida();
		this.novaPartida();
	}
	/**
	 * m�todo para retoma o jogo que foi salvo.
	 * @throws IOException se n�o tive nenhum arquivo salvo.
	 */
	public void retomaJogo() throws IOException{
		this.gerenteJogador = this.gravador.lerJogado();
		this.tabuleiro = this.gravador.lerTabuleiro();
	}
	/**
	 * m�todo para salva o jogo.
	 * @throws IOException se n�o conseguir salva.
	 */
	public void salvaJogo() throws IOException{
		this.gravador.gravaTabuleiro(this.tabuleiro);
		this.gravador.gravaJogado(this.gerenteJogador);
	}
	/**
	 * m�todo que altera os valores e tipos das pe�as para as posi��es inicias do jogo.
	 */
	public void novaPartida(){
		this.gerenteJogador.novaPartida();
		this.tabuleiro.novaPartida();
		this.tabuleiro.tudoProibido();
		this.tabuleiro.jogadaAzul();
	}
	/**
	 * m�todo para fazer os movimentos das pe�as.A linha e coluna endica a posi��o da pe�a na matriz.
	 * @param linha posi��o da pe�a.
	 * @param coluna posi��o da pe�a.
	 */
	public void movimentosDaPe�a(int linha,int coluna){
		this.tabuleiro.movimentosDaPe�a(linha, coluna);
	}
	/**
	 * m�todo para subtrair um ponto do primeiro jogador.
	 */
	public void setPontoJogador1(){
		this.gerenteJogador.setPontoJogador1();
	}
	/**
	 * m�todo para subtrair um ponto do segundo jogador.
	 */
	public void setPontoJogador2(){
		this.gerenteJogador.setPontoJogador2();
	}
	/**
	 * m�todo que retorna o nome do primeiro jogador.
	 * @return um String.
	 */
	public String getNomeJogador1(){
		return this.gerenteJogador.getNomeJogado1();
	}
	/**
	 * m�todo que retorna o nome do segundo jogador.
	 * @return um String.
	 */
	public String getNomeJogador2(){
		return this.gerenteJogador.getNomeJogador2();
	}
	/**
	 * m�todo que retorna o nome do jogador que ganhou o jogo,
	 * caso nenhum tenha ganhador ainda retorna null.
	 * @return o nome do ganhador do jogo.
	 */
	public String ganhador(){
		return this.gerenteJogador.ganhador();
	}
	/**
	 * m�todo para altera uma pe�a normal para uma dama e vice-versa,
	 * que recebe como paramento a posi��o da pe�a.
	 * @param linha posi��o da pe�a.
	 * @param coluna posi��o da pe�a.
	 * @param ehDama um boolean que endica se � dama true ou se � uma pe�a normal false.
	 */
	public void setEhDama(int linha,int coluna,boolean ehDama){
		this.tabuleiro.setEhDama(linha, coluna, ehDama);
	}
	/**
	 * m�todo que retorna um boolean que endica se a pe�a � uma dama ou n�o, que recebe 
	 * como paramento a posi��o da pe�a na matriz.
	 * @param linha posi��o da pe�a.
	 * @param coluna posi��o da pe�a.
	 * @return um boolean que endica se � ou n�o uma dama.
	 */
	public boolean getEhDama(int linha,int coluna){
		return this.tabuleiro.getEhDama(linha, coluna);
	}
	/**
	 * m�todo que autera o tipo da pe�a se � uma pe�a azul, vermelha etc.
	 * que recebe como paramento a posi��o da pe�a e o tipo da pe�a.
	 * @param linha posi��o da pe�a.
	 * @param coluna posi��o da pe�a.
	 * @param tipoPe�a � Enum que endica o tipo da pe�a que pordi ser 
	 * EHPE�ABRANCA,EHPE�APRETA,EHPE�AVERMELHA,EHPE�AAZUL.
	 */
	public void setTipoDePe�a(int linha,int coluna,TiposDePe�as tipoPe�a){
		this.tabuleiro.setTipoDePe�a(linha, coluna, tipoPe�a);
	}
	/**
	 * m�todo que retorna um Enum que endica o tipo da pe�a, que
	 * foi passada como paramento.
	 * @param linha posi��o da pe�a.
	 * @param coluna posi��o da pe�a.
	 * @return um Enum que endica o tipo da pe�a.
	 */
	public TiposDePe�as getTipoDaPe�a(int linha,int coluna){
		return this.tabuleiro.getTipoDaPe�a(linha, coluna);
	}
	/**
	 * m�todo que autera um valor boolean na pe�a que endica se essa
	 * pe�a pordi ou n�o se clicada para fazer o movimento da pe�a.
	 * @param linha posi��o da pe�a.
	 * @param coluna posi��o da pe�a.
	 * @param pordi um boolean que endica se pordi ou n�o mover a pe�a.
	 */
	public void setPordiMover(int linha,int coluna,boolean pordi){
		this.tabuleiro.setPordiMover(linha, coluna, pordi);
	}
	/**
	 * m�todo que retorna um boolean que endica se pordi ou n�o
	 * mover a pe�a ou clica na pe�a.
	 * @param linha posi��o da pe�a.
	 * @param coluna posi��o da pe�a.
	 * @return um boolean que endica se pordi ou n�o mover a pe�a.
	 */
	public boolean getPordiMover(int linha,int coluna){
		return this.tabuleiro.getPordiMover(linha, coluna);
	}
	/**
	 * m�todo que torna todas as pe�a azuis possives de serem clicada
	 * ou movidas de lugar.
	 */
	public void jogadaAzul(){
		this.tabuleiro.jogadaAzul();
	}
	/**
	 * m�todo que torna todas as pe�a vermelhas possives de serem clicada
	 * ou movidas de lugar.
	 */
	public void jogadaVermelha(){
		this.tabuleiro.jogadaVermelha();
	}
	/**
	 * m�todo que torna todas as pe�as imposives de serem clicadas ou movidas.
	 */
	public void tudoProibido(){
		this.tabuleiro.tudoProibido();
	}
	/**
	 * m�todo que autera para true ou false uma variavel que endica se
	 * o jogo foi salvo ou n�o.
	 * @param foiSalvo um boolean se foi true o jogo foi salvo se foi false o jogo
	 * n�o foi salvo.
	 */
	public void setFoiSalvo(boolean foiSalvo){
		this.tabuleiro.setFoiSalvo(foiSalvo);
	}
	/**
	 * m�todo retorna um boolean que endica se foi salvo ou n�o o jogo.
	 * @return um boolean se for true foi salvo se foi false n�o foi salvo o jogo.
	 */
	public boolean getFoiSalvo(){
		return this.tabuleiro.getFoiSalvo();
	}
}