package Grafico;

import java.io.IOException;

import Imagens.Imagens;
import Tabuleiro.*;

public class GerenteInterface {

	private JanelaTabuleiro janelaTabuleiro;
	private Fachada fachada;
	private JanelaMenu menu;
	private Pe�aInterface[][] pe�a;
	private TrocaDePe�as troca;
	private Som som;
	
	public GerenteInterface(){
		this.janelaTabuleiro = new JanelaTabuleiro();
		this.fachada = new Fachada();
		this.menu = new JanelaMenu(this);
		this.pe�a = new Pe�aInterface[8][8];
		this.som = new Som();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				this.pe�a[i][j] =  new Pe�aInterface(i,j,this);
			}
		}
		this.janelaTabuleiro.setJanelaTabuleiro(this.pe�a,this);
		this.novaPartida();
		this.troca = new TrocaDePe�as(this.pe�a,this.fachada);
	}
	public void iniciarPartida(String nome,String nome2){
		this.fachada.iniciarPartida(nome, nome2);
		this.setLabelJogadorAtual(nome);
		this.novaPartida();
	}
	public void retomaJogo() throws IOException{
		this.fachada.retomaJogo();
		if(GerenteJogador.GETJOGADORATUAL()){
			this.setLabelJogadorAtual(this.getNomeJogador1());
			GerenteJogador.SETJOGADORATUAL(false);
		}else{
			this.setLabelJogadorAtual(this.getNomeJogador2());
			GerenteJogador.SETJOGADORATUAL(true);
		}
		Imagens imagem = new Imagens();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.fachada.getTipoDaPe�a(i, j) == TiposDePe�as.EHPE�AAZUL){
					this.pe�a[i][j].setImagemBotao(imagem.getAzul());
				}else if(this.fachada.getTipoDaPe�a(i, j) == TiposDePe�as.EHPE�AVERMELHA){
					this.pe�a[i][j].setImagemBotao(imagem.getVermelho());
				}else if(this.fachada.getTipoDaPe�a(i, j) == TiposDePe�as.EHPE�ABRANCA){
					this.pe�a[i][j].setImagemBotao(imagem.getBranco());
				}else{
					this.pe�a[i][j].setImagemBotao(imagem.getPreto());
				}
			}
		}
	}
	public void trocaDePe�as(int linha,int coluna,int linha2,int coluna2){
		int[] posicao = {-1,-1};
		if(this.fachada.getTipoDaPe�a(linha, coluna) == TiposDePe�as.EHPE�AAZUL){
			if(this.fachada.getEhDama(linha, coluna)){
				posicao = this.troca.calculaPecaCapturadaPelaDama(linha, coluna, linha2, coluna2, TiposDePe�as.EHPE�AVERMELHA);
				if(posicao[0] != -1){
					this.troca.trocaParaCasabranca(posicao[0], posicao[1]);
					this.fachada.setPontoJogador2();
				}
				this.troca.trocaDeDamaAzul(linha, coluna, linha2, coluna2);
			}else{
				posicao = this.troca.calculaPe�aCapturada(linha, coluna, linha2, coluna2);
				if(posicao[0] != -1 & posicao[1] != 0){
					this.troca.trocaParaCasabranca(posicao[0], posicao[1]);
					this.fachada.setPontoJogador2();
				}
				this.troca.trocaDePe�aAzul(linha, coluna, linha2, coluna2);
			}
		}else{
			if(this.fachada.getEhDama(linha, coluna)){
				posicao = this.troca.calculaPecaCapturadaPelaDama(linha, coluna, linha2, coluna2, TiposDePe�as.EHPE�AAZUL);
				if(posicao[0] != -1){
					this.troca.trocaParaCasabranca(posicao[0], posicao[1]);
					this.fachada.setPontoJogador1();
				}
				this.troca.trocaDeDamaVermelha(linha, coluna, linha2, coluna2);
			}else{
				posicao = this.troca.calculaPe�aCapturada(linha, coluna, linha2, coluna2);
				if(posicao[0] != -1){
					this.troca.trocaParaCasabranca(posicao[0], posicao[1]);
					this.fachada.setPontoJogador1();
				}
				this.troca.trocaDePe�aVermelha(linha, coluna, linha2, coluna2);
			}
		}
	}
	public void novaPartida(){
		this.janelaTabuleiro.setLabelJogadorAtual(this.getNomeJogador1());
		this.fachada.novaPartida();
		Imagens imagem = new Imagens();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(this.fachada.getTipoDaPe�a(i, j) == TiposDePe�as.EHPE�AAZUL){
					this.pe�a[i][j].setImagemBotao(imagem.getAzul());
				}else if(this.fachada.getTipoDaPe�a(i, j) == TiposDePe�as.EHPE�AVERMELHA){
					this.pe�a[i][j].setImagemBotao(imagem.getVermelho());
				}else if(this.fachada.getTipoDaPe�a(i, j) == TiposDePe�as.EHPE�ABRANCA){
					this.pe�a[i][j].setImagemBotao(imagem.getBranco());
				}else{
					this.pe�a[i][j].setImagemBotao(imagem.getPreto());
				}
			}
		}
	}
	public void seTornouDama(int linha,int coluna){
		this.troca.seTonouDama(linha, coluna);
	}
	public void movimentosDaPe�a(int linha,int coluna){
		this.fachada.movimentosDaPe�a(linha, coluna);
	}
	public boolean getPordiMover(int linha,int coluna){
		return this.fachada.getPordiMover(linha, coluna);
	}
	public TiposDePe�as getTipoDaPe�a(int linha,int coluna){
		return this.fachada.getTipoDaPe�a(linha, coluna);
	}
	public void tudoProibido(){
		this.fachada.tudoProibido();
	}
	public void jogadaAzul(){
		this.fachada.jogadaAzul();
	}
	public void jogadaVermelha(){
		this.fachada.jogadaVermelha();
	}
	public void setFinalizar(){
		this.janelaTabuleiro.setFinalizar();
	}
	public boolean getFinalizar(){
		return this.janelaTabuleiro.getFinalizar();
	}
	public void tornaVisivelOTabuleiro(){
		this.menu.setVisible(false);
		this.janelaTabuleiro.setVisible(true);
	}
	public void tornaVisivelOMenu(){
		this.janelaTabuleiro.setVisible(false);
		this.menu.setVisible(true);
	}
	public void SomIniciarJogo(){
		this.som.IniciarJogo();
	}
	public void SomJogadarNaoPermitida(){
		this.som.JogadarNaoPermitida();
	}
	public void SomPe�a(){
		this.som.Pe�a();
	}
	public void somBotao(){
		this.som.Botao();
	}
	public void setFoiSalvo(boolean foiSalvo){
		this.fachada.setFoiSalvo(foiSalvo);
	}
	public boolean getFoiSalvo(){
		return this.fachada.getFoiSalvo();
	}
	public void salvaJogo() throws IOException{
		this.fachada.salvaJogo();
	}
	public String ganhador(){
		return this.fachada.ganhador();
	}
	public String getNomeJogador1(){
		return this.fachada.getNomeJogador1();
	}
	public String getNomeJogador2(){
		return this.fachada.getNomeJogador2();
	}
	public void setLabelJogadorAtual(String nome){
		this.janelaTabuleiro.setLabelJogadorAtual(nome);
	}
}