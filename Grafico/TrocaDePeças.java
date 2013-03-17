package Grafico;

import java.io.Serializable;

import Grafico.Pe�aInterface;
import Imagens.Imagens;
import Tabuleiro.Fachada;
import Tabuleiro.TiposDePe�as;

@SuppressWarnings("serial")
public class TrocaDePe�as implements Serializable{

	private Pe�aInterface[][] pe�a;
	private Fachada fachada;
	private Imagens imagem;
	
	public TrocaDePe�as(Pe�aInterface[][] pe�a,Fachada fachada){
		this.pe�a = pe�a;
		this.fachada = fachada;
		this.imagem = new Imagens();
	}
	public void trocaParaCasabranca(int linha,int coluna){
		Imagens imagem = new Imagens();
		this.pe�a[linha][coluna].setImagemBotao(imagem.getBranco());
		this.fachada.setTipoDePe�a(linha, coluna, TiposDePe�as.EHPE�ABRANCA);
	}
	public void trocaDePe�aAzul(int linha, int coluna, int linha2, int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.pe�a[linha2][coluna2].setImagemBotao(this.imagem.getAzul());
		this.fachada.setTipoDePe�a(linha2, coluna2, TiposDePe�as.EHPE�AAZUL);
	}
	public void trocaDeDamaAzul(int linha, int coluna, int linha2, int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.pe�a[linha2][coluna2].setImagemBotao(this.imagem.getAzulDama());
		this.fachada.setTipoDePe�a(linha2, coluna2, TiposDePe�as.EHPE�AAZUL);
		this.fachada.setEhDama(linha2, coluna2, true);
	}
	public void trocaDePe�aVermelha(int linha, int coluna, int linha2,int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.pe�a[linha2][coluna2].setImagemBotao(this.imagem.getVermelho());
		this.fachada.setTipoDePe�a(linha2, coluna2, TiposDePe�as.EHPE�AVERMELHA);
	}
	public void trocaDeDamaVermelha(int linha, int coluna, int linha2,int coluna2) {
		this.trocaParaCasabranca(linha, coluna);
		this.pe�a[linha2][coluna2].setImagemBotao(this.imagem.getVermelhoDama());
		this.fachada.setTipoDePe�a(linha2, coluna2, TiposDePe�as.EHPE�AVERMELHA);
		this.fachada.setEhDama(linha2, coluna2, true);
	}
	public void seTonouDama(int linha,int coluna){
		if(this.fachada.getTipoDaPe�a(linha, coluna) == TiposDePe�as.EHPE�AAZUL){
			if(linha == 7){
				this.pe�a[linha][coluna].setImagemBotao(this.imagem.getAzulDama());
				this.fachada.setEhDama(linha, coluna, true);
			}
		}else{
			if(linha == 0){
				this.pe�a[linha][coluna].setImagemBotao(this.imagem.getVermelhoDama());
				this.fachada.setEhDama(linha, coluna, true);
			}
		}
	}
	public int[] calculaPe�aCapturada(int linha,int coluna,int linha2,int coluna2){
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
	public int[] calculaPecaCapturadaPelaDama(int linha, int coluna, int linha2,int coluna2,TiposDePe�as qualPe�a) {
		int[] posicao = {-1,-1};
		int x = linha,y = coluna;
		if(linha > linha2 & coluna < coluna2 ){
			while(x > linha2){
				x--;
				y++;
				if(this.fachada.getTipoDaPe�a(x,y) == qualPe�a){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				 }
			}
		}else if(linha > linha2 & coluna > coluna2){
			while(x > linha2){
				x--;
				y--;
				if(this.fachada.getTipoDaPe�a(x,y) == qualPe�a){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				 }
			}
		}else if(linha < linha2 & coluna > coluna2){
			while(x < linha2){
				x++;
				y--;
				if(this.fachada.getTipoDaPe�a(x,y) == qualPe�a){
					 posicao[0] = x;
					 posicao[1] = y;
					 return posicao;
				 }
			}
		}else{
			while(x < linha2){
				x++;
				y++;
				if(this.fachada.getTipoDaPe�a(x,y) == qualPe�a){
					posicao[0] = x;
					posicao[1] = y;
					return posicao;
				}
			}
		}
		return posicao;
	}
}