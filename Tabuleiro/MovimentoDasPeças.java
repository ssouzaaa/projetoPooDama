package Tabuleiro;

import java.io.Serializable;
import static Tabuleiro.TiposDePeças.*;

@SuppressWarnings("serial")
public class MovimentoDasPeças implements Serializable{

	private Peça[][] peças;
	private int[][] esquedaCima,direitaCima,esquedaBaixo,direitaBaixo;
	
	public MovimentoDasPeças(Peça[][] peças){
		this.peças = peças;
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
		TiposDePeças jogado;
		if(this.peças[x][y].getTipoPeça() == EHPEÇAAZUL){
			jogado = EHPEÇAVERMELHA;
		}else{
			jogado = EHPEÇAAZUL;
		}
		for(int i = 0; i < 4; i++){
			int linha = x + verto[i][0],coluna = y + verto[i][1];
			int linha2 = x + verto2[i][0],coluna2 = y + verto2[i][1];
			if((linha >= 0 & linha <= 7) & (coluna >= 0 & coluna <= 7)){
				if((linha2 >= 0 & linha2 <= 7) & (coluna2 >= 0 & coluna2 <= 7)){
					if(this.peças[linha2][coluna2].getTipoPeça() == jogado & this.peças[linha][coluna].getTipoPeça() == EHPEÇABRANCA){
						this.peças[linha][coluna].setPordiMover(true);
					}
				}
			}
		}
	}
	public void movimentoNormalAzul(int linha,int coluna){
		if(linha + 1 <= 7 & coluna - 1 >= 0){
			if(this.peças[linha + 1][coluna - 1].getTipoPeça() == EHPEÇABRANCA){
				this.peças[linha + 1][coluna - 1].setPordiMover(true);
			}
		}if(linha + 1 <= 7 & coluna + 1 <= 7){
			if(this.peças[linha + 1][coluna + 1].getTipoPeça() == EHPEÇABRANCA){
				this.peças[linha + 1][coluna + 1].setPordiMover(true);
			}
		}
	}
	public void movimentoNormalVermelho(int linha,int coluna) {
		if(linha - 1 >= 0 & coluna - 1 >= 0){
			if(this.peças[linha - 1][coluna - 1].getTipoPeça() == EHPEÇABRANCA){
				this.peças[linha - 1][coluna - 1].setPordiMover(true);
			}
		}
		if(linha - 1 >= 0 & coluna + 1 <= 7){
			if(this.peças[linha - 1][coluna + 1].getTipoPeça() == EHPEÇABRANCA){
				this.peças[linha - 1][coluna + 1].setPordiMover(true);
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
					if(this.peças[x][y].getTipoPeça() == EHPEÇAVERMELHA & this.peças[x + verto[i][0]][y + verto[i][1]].getTipoPeça() == EHPEÇAVERMELHA){
						break;
					}if(this.peças[x][y].getTipoPeça() == EHPEÇAAZUL & this.peças[x + verto[i][0]][y + verto[i][1]].getTipoPeça() == EHPEÇAAZUL){
						break;
					}
				}
				if(this.peças[linha][coluna].getTipoPeça() == EHPEÇAVERMELHA){
					if(this.peças[x][y].getTipoPeça() == EHPEÇAVERMELHA){
						break;
					}
					if(this.peças[x][y].getTipoPeça() == EHPEÇAAZUL){
						if(this.peças[x + verto[i][0]][y + verto[i][1]].getTipoPeça() == EHPEÇABRANCA){
							pordi = true;
						}
					}
				}else{
					if(this.peças[x][y].getTipoPeça() == EHPEÇAAZUL){
						break;
					}
					if(this.peças[x][y].getTipoPeça() == EHPEÇAVERMELHA){
						if((x + verto[i][0] >= 0 & x + verto[i][0] <= 7) & (y + verto[i][1] >= 0 & y + verto[i][1] <= 7)){
							if(this.peças[x + verto[i][0]][y + verto[i][1]].getTipoPeça() == EHPEÇABRANCA){
								pordi = true;
							}
						}
					}
				}
				if(pordi){
					if(this.peças[x][y].getTipoPeça() == EHPEÇABRANCA){
						this.peças[x][y].setPordiMover(true);
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
		int[] posiçao = this.damaPordiMover(linha, coluna, -1, -1);
		if(posiçao[0] != -1){
			while(linha != posiçao[0]){
				linha -= 1;
				coluna -= 1;
				this.peças[linha][coluna].setPordiMover(true);
			}
			this.peças[linha - 2][coluna - 2].setPordiMover(true);
		}
	}
	public void movEsquedaBaixoDama(int linha,int coluna){
		int[] posiçao = this.damaPordiMover(linha, coluna, 1, -1);
		if(posiçao[0] != -1){
			while(linha != posiçao[0]){
				linha += 1;
				coluna -= 1;
				this.peças[linha][coluna].setPordiMover(true);
			}
			this.peças[linha - 2][coluna - 2].setPordiMover(true);
		}
	}
	public void movDireitaCimaDama(int linha,int coluna){
		int[] posiçao = this.damaPordiMover(linha, coluna, -1, 1);
		if(posiçao[0] != -1){
			while(linha != posiçao[0]){
				linha -= 1;
				coluna += 1;
				this.peças[linha][coluna].setPordiMover(true);
			}
			this.peças[linha - 2][coluna - 2].setPordiMover(true);
		}
	}
	public void movDireitaBaixoDama(int linha,int coluna){
		int[] posiçao = this.damaPordiMover(linha, coluna, 1, 1);
		if(posiçao[0] != -1){
			while(linha != posiçao[0]){
				linha += 1;
				coluna += 1;
				this.peças[linha][coluna].setPordiMover(true);
			}
			this.peças[linha - 2][coluna - 2].setPordiMover(true);
		}
	}
	/**
	 * método para ver se a peça pordi ou não vazer seu movimento dada uma direção que é informada
	 * por x e y que pordi ser esqueda para cima, esqueda para baixo, direita para cima e 
	 * direita para baixo.
	 * @param linha posição da peça.
	 * @param coluna posicao da peça.
	 * @param x endica a direção do movimento  da peça na matriz.
	 * @param y endica a direção do movimneto da peça na matriz
	 * @return um verto de int que é posição da ultima peça que ele pordi mover a dama.
	 
	public int[] damaPordiMover(int linha,int coluna,int x,int y){
		int linha2 = linha,coluna2 = coluna;
		int[] posiçao = new int[2];
		while((x >= 0 & x <= 7) & (y >= 0 & y <= 7)){
			linha += x;
			coluna += y;
			if(((linha >= 0 & linha <= 7) & (coluna >= 0 & coluna <= 7)) & ((linha + x >= 0 & linha + x <= 7) & (coluna + y >= 0 & coluna + y <= 7))){
				if(this.peças[linha][coluna].getTipoPeça() == EHPEÇAVERMELHA & this.peças[linha + x][coluna + y].getTipoPeça() == EHPEÇAVERMELHA){
					break;
				}if(this.peças[linha][coluna].getTipoPeça() == EHPEÇAAZUL & this.peças[linha + x][coluna + y].getTipoPeça() == EHPEÇAAZUL){
					break;
				}
			}
			if((linha >= 0 & linha <= 7) & (coluna >= 0 & coluna <= 7)){
				if(this.peças[linha2][coluna2].getTipoPeça() == EHPEÇAVERMELHA){
					if(this.peças[linha][coluna].getTipoPeça() == EHPEÇAVERMELHA){
						break;
					}
				}else{
					if(this.peças[linha][coluna].getTipoPeça() == EHPEÇAAZUL){
						break;
					}
				}
				if(!(this.peças[linha][coluna].getTipoPeça() != EHPEÇABRANCA)){
					if(linha + x >= 0 & linha + x <= 7 & coluna + y >= 0 & coluna + y <= 7){
						if(this.peças[linha + x][coluna + y].getTipoPeça() == EHPEÇABRANCA){
							posiçao[0] = linha;
							posiçao[1] = coluna;
							return posiçao;
						}
					}
				}
			}
		}
		posiçao[0] = -1;
		return posiçao;
	}*/
	public void movimentoDama(int linha,int coluna){
		int[][] verto = {{-1,1},{1,1},{1,-1},{-1,-1}};
		for(int i = 0; i < 4; i++){
			int x = linha + verto[i][0],y = coluna + verto[i][1];
			while((x >= 0 & x <= 7) & (y >= 0 & y <= 7)){
				if(this.peças[x][y].getTipoPeça() == EHPEÇABRANCA){
					this.peças[x][y].setPordiMover(true);
				}
				if((x + verto[i][0] >= 0 & x + verto[i][0] <= 7) & (y + verto[i][1] >= 0 & y + verto[i][1] <= 7)){
					if(this.peças[x][y].getTipoPeça() == EHPEÇAVERMELHA & this.peças[x + verto[i][0]][y + verto[i][1]].getTipoPeça() == EHPEÇAVERMELHA){
						break;
					}if(this.peças[x][y].getTipoPeça() == EHPEÇAAZUL & this.peças[x + verto[i][0]][y + verto[i][1]].getTipoPeça() == EHPEÇAAZUL){
						break;
					}
				}
				if(this.peças[linha][coluna].getTipoPeça() == EHPEÇAVERMELHA){
					if(this.peças[x][y].getTipoPeça() == EHPEÇAVERMELHA){
						break;
					}
				}else{
					if(this.peças[x][y].getTipoPeça() == EHPEÇAAZUL){
						break;
					}
				}
				x += verto[i][0];
				y += verto[i][1];
			}
		}
	}
}