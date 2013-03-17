package Arquivo;

import java.io.*;

import Tabuleiro.*;

@SuppressWarnings("serial")
public class Gravador implements Serializable{
	
	public Tabuleiro lerTabuleiro() throws IOException{
		ObjectInputStream object = null;
		try {
			object = new ObjectInputStream(new FileInputStream("dama.txt"));
			return (Tabuleiro) object.readObject();
		} catch (FileNotFoundException e) {
			throw new IOException("Arquivos não encontado");
		}catch (ClassNotFoundException e) {
			throw new IOException("Classe dos objetos não foram encontados",e);
		}finally{
			if(object != null){
				object.close();
			}
		}
	}
	public void gravaTabuleiro(Tabuleiro tabuleiro) throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("dama.txt"));
			out.writeObject(tabuleiro);
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo não encontado");
		}catch(IOException e){
			throw e;
		}finally{
			if(out != null){
				out.close();
			}
		}
	}
	public GerenteJogador lerJogado() throws IOException{
		ObjectInputStream object = null;
		try {
			object = new ObjectInputStream(new FileInputStream("jogado.txt"));
			return (GerenteJogador) object.readObject();
		} catch (FileNotFoundException e) {
			throw new IOException("Arquivos não encontado");
		}catch (ClassNotFoundException e) {
			throw new IOException("Classe dos objetos não foram encontados",e);
		}finally{
			if(object != null){
				object.close();
			}
		}
	}
	public void gravaJogado(GerenteJogador gerente) throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("jogado.txt"));
			out.writeObject(gerente);
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo não encontado");
		}catch(IOException e){
			throw e;
		}finally{
			if(out != null){
				out.close();
			}
		}
	}
}