import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class app extends Applet implements Runnable, KeyListener{
	
	Thread thread;
	boolean pracuje;
	Graphics Gr;
	Graphics Gw;
	int klawisz=0;
	int x=0;
	int y=0;
	int pozX;
	int pozY;
	plansza pl;
	
	
	public void init(){
		pracuje = false;
		addKeyListener(this);
		resize(Constants.szerokoscOkna, Constants.wysokoscOkna);
		Gr = getGraphics();
		Gw = getGraphics();
		pozX = 300;
		pozY = 300;
		pl = new plansza(Constants.szerokoscOkna, Constants.wysokoscOkna);
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
			x=0;
			y=0;
			if(klawisz==37)	x = -1;
			if(klawisz==38)	y = -1;
			if(klawisz==39) x = 1;
			if(klawisz==40) y = 1;
			pl.ustawPole(pozX+=x, pozY+=y, 1);
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
		
		Gr.drawString(Integer.toString(zajete[1]), 100, 100);
		Gr.drawString(Integer.toString(pl.podajPole(40,40)), 100, 140);
	}
	
	/*
	public void generujPlansze(int szerokosc, int dlugosc){
		for(int y=0; y<dlugosc; y++){
			for(int x=0; x<szerokosc; x++){
				pola.add(new pole(x, y, )
			}
	}
	*/
	
	
	public void keyPressed(KeyEvent evt){
		klawisz=evt.getKeyCode();
	}
	
	public void keyTyped(KeyEvent evt){
		//klawisz=evt.getKeyCode();
		//37 - lewo
		//38 - gora
		//39 - prawo
		//40 - dol
	}
	
	public void keyReleased(KeyEvent evt){
		
	}

}
