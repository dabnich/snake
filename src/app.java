import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class app extends Applet implements Runnable, KeyListener{
	
	Thread thread;
	boolean pracuje;
	Graphics Gr;
	Graphics Gw;
	int klawiszP=0;
	int klawiszT=0;
	//char klawiszC;
	String slowo;
	int x=0;
	int y=0;
	int pozX;
	int pozY;
	plansza pl;
	gracz gracz;
	
	
	public void init(){
		pracuje = false;
		addKeyListener(this);
		resize(Constants.szerokoscOkna, Constants.wysokoscOkna);
		Gr = getGraphics();
		Gw = getGraphics();
		pozX = 300;
		pozY = 300;
		pl = new plansza(Constants.szerokoscOkna, Constants.wysokoscOkna);
		gracz = new gracz(pl, pozX, pozY);
	}
	
	public void start(){
		thread = new Thread(this);
		thread.start();
		pracuje = true;
	}
	
	public void stop(){
		pracuje = false;
	}
	
	public void run(){
		while(pracuje){
			pl.ustawPole(gracz.pozX, gracz.pozY, 1);
			if(klawiszP==37)	gracz.wLewo();
			if(klawiszP==38)	gracz.wGore();
			if(klawiszP==39) 	gracz.wPrawo();
			if(klawiszP==40) 	gracz.wDol();
			if(klawiszP==10) {
				gracz.jedzLosowo();
				//klawiszT=0;
			}
			
			gracz.ruch();
			
			draw();

			try{
				Thread.sleep(1000/Constants.FPS);
			}
			catch(InterruptedException ex){}
		}
	}
	
	
	
	public void draw(){
		Gr.clearRect(0, 0, getWidth(), getHeight());
		int zajete[] = new int[2];
		
		for(int i=0; i<pl.zajete.size(); i++){
			zajete = pl.podajWsp(pl.zajete.get(i));
			Gr.fillRect(zajete[0], zajete[1], 1, 1);
		}
		
		/*
		for(int i=0; i<pl.pola.size(); i++){
			if(pl.pola.get(i)==1){
				zajete = pl.podajWsp(pl.pola.get(i));
				Gr.fillRect(zajete[0], zajete[1], 1, 1);
			}
		}
		*/
		Gr.drawString(Integer.toString(pl.zajete.size()), 100, 40);
		Gr.drawString(Integer.toString(zajete[1]), 100, 100);
		Gr.drawString(Integer.toString(gracz.pozX)+" , "+Integer.toString(gracz.pozY), 100, 140);
		Gr.drawString(Integer.toString(pl.podajKlucz(gracz.pozX, gracz.pozY)), 100, 180);
		

	}

	
	
	public void keyPressed(KeyEvent evt){
		klawiszP = evt.getKeyCode();
		
	}
	
	public void keyTyped(KeyEvent evt){
		//klawisz=evt.getKeyCode();
		//37 - lewo
		//38 - gora
		//39 - prawo
		//40 - dol
		
		
	}
	
	public void keyReleased(KeyEvent evt){
		klawiszT = evt.getKeyCode();
	}

}
