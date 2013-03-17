package Tabuleiro;

import java.io.Serializable;
import static Tabuleiro.TiposDePe�as.*;

@SuppressWarnings("serial")
public class MovimentoDasPe�as implements Serializable{

	private Pe�a[][] pe�as;
	private int[][] esquedaCima,direitaCima,esquedaBaixo,direitaBaixo;
	
	public MovimentoDasPe�as(Pe�a[][] pe�as){
		this.pe�as = pe�as;
		this.esquedaCima = new int[8][2];
		this.esquedaBaixo = new int[8][2];
		this.direitaCima = new int[8][2];
		this.direitaBaixo = new int[8][2];
		this.envalidar();
	}
	private void envalidar(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 2; j++){
				this.esquedaCima[i][j] = -1;
				this.esquedaBaixo[i][j] = -1;
				this.direitaCima [i][j] = -1;
				this.direitaBaixo[i][j] = -1;
			}
		}
	}
	public void movimentoCapturaPeca(int x,int y){
		int[][] verto = {{-2,2},{2,2},{2,-2},{-2,-2}};
		int[][] verto2 = {{-1,1},{1,1},{1,-1},{-1,-1}};
		TiposDePe�as jogado;
		if(this.pe�as[x][y].getTipoPe�a() == EHPE�AAZUL){
			jogado = EHPE�AVERMELHA;
		}else{
			jogado = EHPE�AAZUL;
		}
		for(int i = 0; i < 4; i++){
			int linha = x + verto[i][0],coluna = y + verto[i][1];
			int linha2 = x + verto2[i][0],coluna2 = y + verto2[i][1];
			if((linha >= 0 & linha <= 7) & (coluna >= 0 & coluna <= 7)){
				if((linha2 >= 0 & linha2 <= 7) & (coluna2 >= 0 & coluna2 <= 7)){
					if(this.pe�as[linha2][coluna2].getTipoPe�a() == jogado & this.pe�as[linha][coluna].getTipoPe�a() == EHPE�ABRANCA){
						this.pe�as[linha][coluna].setPordiMover(true);
					}
				}
			}
		}
	}
	public void movimentoNormalAzul(int linha,int coluna){
		if(linha + 1 <= 7 & coluna - 1 >= 0){
			if(this.pe�as[linha + 1][coluna - 1].getTipoPe�a() == EHPE�ABRANCA){
				this.pe�as[linha + 1][coluna - 1].setPordiMover(true);
			}
		}if(linha + 1 <= 7 & coluna + 1 <= 7){
			if(this.pe�as[linha + 1][coluna + 1].getTipoPe�a() == EHPE�ABRANCA){
				this.pe�as[linha + 1][coluna + 1].setPordiMover(true);
			}
		}
	}
	public void movimentoNormalVermelho(int linha,int coluna) {
		if(linha - 1 >= 0 & coluna - 1 >= 0){
			if(this.pe�as[linha - 1][coluna - 1].getTipoPe�a() == EHPE�ABRANCA){
				this.pe�as[linha - 1][coluna - 1].setPordiMover(true);
			}
		}
		if(linha - 1 >= 0 & coluna + 1 <= 7){
			if(this.pe�as[linha - 1][coluna + 1].getTipoPe�a() == EHPE�ABRANCA){
				this.pe�as[linha - 1][coluna + 1].setPordiMover(true);
			}
		}
	}
	public void movimentoDeCapturaDaDama(int linha,int coluna){
		int[][] verto = {{-1,1},{1,1},{1,-1},{-1,-1}};
		boolean pordi = false;
		for(int i = 0; i < 4; i++){
			int x = linha + verto[i][0],y = coluna + verto[i][1];
			while((x >= 0 & x <= 7) & (y >= 0 & y <= 7)){
				
				if((x + verto[i][0] >= 0 & x + verto[i][0] <= 7) & (y + verto[i][1] >= 0 & y + verto[i][1] <= 7)){
					if(this.pe�as[x][y].getTipoPe�a() == EHPE�AVERMELHA & this.pe�as[x + verto[i][0]][y + verto[i][1]].getTipoPe�a() == EHPE�AVERMELHA){
						break;
					}if(this.pe�as[x][y].getTipoPe�a() == EHPE�AAZUL & this.pe�as[x + verto[i][0]][y + verto[i][1]].getTipoPe�a() == EHPE�AAZUL){
						break;
					}
				}
				if(this.pe�as[linha][coluna].getTipoPe�a() == EHPE�AVERMELHA){
					if(this.pe�as[x][y].getTipoPe�a() == EHPE�AVERMELHA){
						break;
					}
					if(this.pe�as[x][y].getTipoPe�a() == EHPE�AAZUL){
						if(this.pe�as[x + verto[i][0]][y + verto[i][1]].getTipoPe�a() == EHPE�ABRANCA){
							pordi = true;
						}
					}
				}else{
					if(this.pe�as[x][y].getTipoPe�a() == EHPE�AAZUL){
						break;
					}
					if(this.pe�as[x][y].getTipoPe�a() == EHPE�AVERMELHA){
						if((x + verto[i][0] >= 0 & x + verto[i][0] <= 7) & (y + verto[i][1] >= 0 & y + verto[i][1] <= 7)){
							if(this.pe�as[x + verto[i][0]][y + verto[i][1]].getTipoPe�a() == EHPE�ABRANCA){
								pordi = true;
							}
						}
					}
				}
				if(pordi){
					if(this.pe�as[x][y].getTipoPe�a() == EHPE�ABRANCA){
						this.pe�as[x][y].setPordiMover(true);
					}
				}
				x += verto[i][0];
				y += verto[i][1];
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void segundoMovimentoDama(int linha,int coluna){
		this.movEsquedaCimaDama(linha, coluna);
		this.movEsquedaBaixoDama(linha, coluna);
		this.movDireitaCimaDama(linha, coluna);
		this.movDireitaBaixoDama(linha, coluna);
	}
	public void movEsquedaCimaDama(int linha,int coluna){
		int[] posi�ao = this.damaPordiMover(linha, coluna, -1, -1);
		if(posi�ao[0] != -1){
			while(linha != posi�ao[0]){
				linha -= 1;
				coluna -= 1;
				this.pe�as[linha][coluna].setPordiMover(true);
			}
			this.pe�as[linha - 2][coluna - 2].setPordiMover(true);
		}
	}
	public void movEsquedaBaixoDama(int linha,int coluna){
		int[] posi�ao = this.damaPordiMover(linha, coluna, 1, -1);
		if(posi�ao[0] != -1){
			while(linha != posi�ao[0]){
				linha += 1;
				coluna -= 1;
				this.pe�as[linha][coluna].setPordiMover(true);
			}
			this.pe�as[linha - 2][coluna - 2].setPordiMover(true);
		}
	}
	public void movDireitaCimaDama(int linha,int coluna){
		int[] posi�ao = this.damaPordiMover(linha, coluna, -1, 1);
		if(posi�ao[0] != -1){
			while(linha != posi�ao[0]){
				linha -= 1;
				coluna += 1;
				this.pe�as[linha][coluna].setPordiMover(true);
			}
			this.pe�as[linha - 2][coluna - 2].setPordiMover(true);
		}
	}
	public void movDireitaBaixoDama(int linha,int coluna){
		int[] posi�ao = this.damaPordiMover(linha, coluna, 1, 1);
		if(posi�ao[0] != -1){
			while(linha != posi�ao[0]){
				linha += 1;
				coluna += 1;
				this.pe�as[linha][coluna].setPordiMover(true);
			}
			this.pe�as[linha - 2][coluna - 2].setPordiMover(true);
		}
	}
	/**
	 * m�todo para ver se a pe�a pordi ou n�o vazer seu movimento dada uma dire��o que � informada
	 * por x e y que pordi ser esqueda para cima, esqueda para baixo, direita para cima e 
	 * direita para baixo.
	 * @param linha posi��o da pe�a.
	 * @param coluna posicao da pe�a.
	 * @param x endica a dire��o do movimento  da pe�a na matriz.
	 * @param y endica a dire��o do movimneto da pe�a na matriz
	 * @return um verto de int que � posi��o da ultima pe�a que ele pordi mover a dama.
	 
	public int[] damaPordiMover(int linha,int coluna,int x,int y){
		int linha2 = linha,coluna2 = coluna;
		int[] posi�ao = new int[2];
		while((x >= 0 & x <= 7) & (y >= 0 & y <= 7)){
			linha += x;
			coluna += y;
			if(((linha >= 0 & linha <= 7) & (coluna >= 0 & coluna <= 7)) & ((linha + x >= 0 & linha + x <= 7) & (coluna + y >= 0 & coluna + y <= 7))){
				if(this.pe�as[linha][coluna].getTipoPe�a() == EHPE�AVERMELHA & this.pe�as[linha + x][coluna + y].getTipoPe�a() == EHPE�AVERMELHA){
					break;
				}if(this.pe�as[linha][coluna].getTipoPe�a() == EHPE�AAZUL & this.pe�as[linha + x][coluna + y].getTipoPe�a() == EHPE�AAZUL){
					break;
				}
			}
			if((linha >= 0 & linha <= 7) & (coluna >= 0 & coluna <= 7)){
				if(this.pe�as[linha2][coluna2].getTipoPe�a() == EHPE�AVERMELHA){
					if(this.pe�as[linha][coluna].getTipoPe�a() == EHPE�AVERMELHA){
						break;
					}
				}else{
					if(this.pe�as[linha][coluna].getTipoPe�a() == EHPE�AAZUL){
						break;
					}
				}
				if(!(this.pe�as[linha][coluna].getTipoPe�a() != EHPE�ABRANCA)){
					if(linha + x >= 0 & linha + x <= 7 & coluna + y >= 0 & coluna + y <= 7){
						if(this.pe�as[linha + x][coluna + y].getTipoPe�a() == EHPE�ABRANCA){
							posi�ao[0] = linha;
							posi�ao[1] = coluna;
							return posi�ao;
						}
					}
				}
			}
		}
		posi�ao[0] = -1;
		return posi�ao;
	}*/
	public void movimentoDama(int linha,int coluna){
		int[][] verto = {{-1,1},{1,1},{1,-1},{-1,-1}};
		for(int i = 0; i < 4; i++){
			int x = linha + verto[i][0],y = coluna + verto[i][1];
			while((x >= 0 & x <= 7) & (y >= 0 & y <= 7)){
				if(this.pe�as[x][y].getTipoPe�a() == EHPE�ABRANCA){
					this.pe�as[x][y].setPordiMover(true);
				}
				if((x + verto[i][0] >= 0 & x + verto[i][0] <= 7) & (y + verto[i][1] >= 0 & y + verto[i][1] <= 7)){
					if(this.pe�as[x][y].getTipoPe�a() == EHPE�AVERMELHA & this.pe�as[x + verto[i][0]][y + verto[i][1]].getTipoPe�a() == EHPE�AVERMELHA){
						break;
					}if(this.pe�as[x][y].getTipoPe�a() == EHPE�AAZUL & this.pe�as[x + verto[i][0]][y + verto[i][1]].getTipoPe�a() == EHPE�AAZUL){
						break;
					}
				}
				if(this.pe�as[linha][coluna].getTipoPe�a() == EHPE�AVERMELHA){
					if(this.pe�as[x][y].getTipoPe�a() == EHPE�AVERMELHA){
						break;
					}
				}else{
					if(this.pe�as[x][y].getTipoPe�a() == EHPE�AAZUL){
						break;
					}
				}
				x += verto[i][0];
				y += verto[i][1];
			}
		}
	}
}