package Grafico;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

import Evento.EventoSom;

public class Som extends Thread{

	public void run(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void IniciarJogo(){
		if(EventoSom.TEMSOM()){
			try {
				@SuppressWarnings("deprecation")
            	AudioClip clip = Applet.newAudioClip(new File("C:\\som\\iniciarJogo.wav").toURL()); 
				clip.play();
			} catch (MalformedURLException ex){  
            	ex.printStackTrace();
			}
		}
	}
	public void JogadarNaoPermitida(){
		if(EventoSom.TEMSOM()){
			try {
				@SuppressWarnings("deprecation")
            	AudioClip clip = Applet.newAudioClip(new File("C:\\som\\Error.wav").toURL());
            	clip.play();
        	} catch (MalformedURLException ex){  
            	ex.printStackTrace();  
        	}
		}
	}
	public void Peça(){
		if(EventoSom.TEMSOM()){
			try {
				@SuppressWarnings("deprecation")
				AudioClip clip = Applet.newAudioClip(new File("C:\\som\\Peça.wav").toURL());  
				clip.play();
			} catch (MalformedURLException ex){  
				ex.printStackTrace();  
			}
		}
	}
	public void Botao(){
		if(EventoSom.TEMSOM()){
			try {
				@SuppressWarnings("deprecation")
				AudioClip clip = Applet.newAudioClip(new File("C:\\som\\botao.wav").toURL());  
				clip.play();
				this.run();
			} catch (MalformedURLException ex){  
				ex.printStackTrace();  
			}
		}
	}
}
