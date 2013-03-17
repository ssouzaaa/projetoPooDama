package Grafico;

import java.io.Serializable;

import Grafico.PeçaInterface;
import Imagens.Imagens;
import Tabuleiro.Fachada;
import Tabuleiro.TiposDePeças;

@SuppressWarnings("serial")
public class TrocaDePeças implements Serializable{

	private PeçaInterface[][] peça;
	private Fachada fachada;
	private Imagens imagem;
	
	public TrocaDePeças(PeçaInterface[][] peça,Fachada fachada){
		this.peça = peça;
		this.fachada = fachada;
		this.imagem = new Imagens();
	}
	public void trocaParaCasabranca(int linha,int coluna){
		Imagens imagem = new Imagens();
		this.peça[linha][coluna].setImagemBotao(imagem.getBranco());
		this.fachada.setTipoDePeça(linha, coluna, TiposDePeças.EHPEÇABRANCA);
	}
	public void trocaDePeçaAzul(int linha, int coluna, int linha2, int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.peça[linha2][coluna2].setImagemBotao(this.imagem.getAzul());
		this.fachada.setTipoDePeça(linha2, coluna2, TiposDePeças.EHPEÇAAZUL);
	}
	public void trocaDeDamaAzul(int linha, int coluna, int linha2, int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.peça[linha2][coluna2].setImagemBotao(this.imagem.getAzulDama());
		this.fachada.setTipoDePeça(linha2, coluna2, TiposDePeças.EHPEÇAAZUL);
		this.fachada.setEhDama(linha2, coluna2, true);
	}
	public void trocaDePeçaVermelha(int linha, int coluna, int linha2,int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.peça[linha2][coluna2].setImagemBotao(this.imagem.getVermelho());
		this.fachada.setTipoDePeça(linha2, coluna2, TiposDePeças.EHPEÇAVERMELHA);
	}
	public void trocaDeDamaVermelha(int linha, int coluna, int linha2,int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.peça[linha2][coluna2].setImagemBotao(this.imagem.getVermelhoDama());
		this.fachada.setTipoDePeça(linha2, coluna2, TiposDePeças.EHPEÇAVERMELHA);
		this.fachada.setEhDama(linha2, coluna2, true);
	}
	public void seTonouDama(int linha,int coluna){
		if(this.fachada.getTipoDaPeça(linha, coluna) == TiposDePeças.EHPEÇAAZUL){
			if(linha == 7){
				this.peça[linha][coluna].setImagemBotao(this.imagem.getAzulDama());
				this.fachada.setEhDama(linha, coluna, true);
			}
		}else{
			if(linha == 0){
				this.peça[linha][coluna].setImagemBotao(this.imagem.getVermelhoDama());
				this.fachada.setEhDama(linha, coluna, true);
			}
		}
	}
	public int[] calculaPeçaCapturada(int linha,int coluna,int linha2,int coluna2){
		int[] posicao = {-1,-1};
		if(linha - 2 == linha2){
			if(coluna - 2 == coluna2){
				posicao[0] = linha - 1;
				posicao[1] = coluna - 1;
			}else if(coluna + 2 == coluna2){
				posicao[0] = linha - 1;
				posicao[1] = coluna + 1;
			}
		}else{
			if(coluna - 2 == coluna2){
				posicao[0] = linha + 1;
				posicao[1] = coluna - 1;
			}else if(coluna + 2 == coluna2){
				posicao[0] = linha + 1;
				posicao[1] = coluna + 1;
			}
		}
		if((posicao[0] >= 0 & posicao[0] <= 7) & (posicao[1] >= 0 & posicao[1] <= 7)){
			return posicao;
		}
		posicao[0] = -1;
		posicao[1] = -1;
		return posicao;
	}
	public int[] calculaPecaCapturadaPelaDama(int linha, int coluna, int linha2,int coluna2,TiposDePeças qualPeça) {
		int[] posicao = {-1,-1};
		int x = linha,y = coluna;
		if(linha > linha2 & coluna < coluna2 ){
			while(x > linha2){
				x--;
				y++;
				if(this.fachada.getTipoDaPeça(x,y) == qualPeça){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				 }
			}
		}else if(linha > linha2 & coluna > coluna2){
			while(x > linha2){
				x--;
				y--;
				if(this.fachada.getTipoDaPeça(x,y) == qualPeça){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				 }
			}
		}else if(linha < linha2 & coluna > coluna2){
			while(x < linha2){
				x++;
				y--;
				if(this.fachada.getTipoDaPeça(x,y) == qualPeça){
					 posicao[0] = x;
					 posicao[1] = y;
					 return posicao;
				 }
			}
		}else{
			while(x < linha2){
				x++;
				y++;
				if(this.fachada.getTipoDaPeça(x,y) == qualPeça){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				}
			}
		}
		return posicao;
	}
}