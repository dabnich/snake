import java.util.Random;

//import java.

public class gracz {
	int pozX;
	int pozY;
	int kX; //kierunek X
	int kY; //kierunek Y
	plansza pl;
	
	public gracz(plansza pl, int pozX, int pozY){
		this.pl = pl;
		this.pozX = pozX;
		this.pozY = pozY;
		
	}
	
	public boolean goraWolna(){
		if(pozY>0){
			if(pl.podajPole(pozX, pozY-1) == 0) return true;
			return false;
		}
		return false;
	}
	
	public boolean dolWolna(){
		if(pozY<pl.dlugosc-1){
			if(pl.podajPole(pozX, pozY+1) == 0) return true;
			return false;
		}
		return false;
	}
	
	public boolean lewaWolna(){
		if(pozX>0){
			if(pl.podajPole(pozX-1, pozY) == 0) return true;
			return false;
		}
		return false;
	}
	
	public boolean prawaWolna(){
		if(pozX<pl.szerokosc-1){
			if(pl.podajPole(pozX+1, pozY) == 0) return true;
			return false;
		}
		return false;
	}
	
	public void wGore(){
		kX = 0;
		kY = -1;
	}
	
	public void wDol(){
		kX=0;
		kY=1;
	}
	
	public void wLewo(){
		kY=0;
		kX=-1;
	}
	
	public void wPrawo(){
		kY=0;
		kX=1;
	}
	
	public void skrecLosowo(){
		Random rand;
		if(kX!=0){
			if(goraWolna() && dolWolna()){
				rand = new Random();
				if(rand.nextBoolean()) wGore();
				else wDol();
			}
			else{
				if(goraWolna()) wGore();
				else wDol();
			}
		}
		else{
			if(lewaWolna() && prawaWolna()){
				rand = new Random();
				if(rand.nextBoolean()) wLewo();
				else wPrawo();
			}
			else{
				if(lewaWolna()) wLewo();
				else wPrawo();
			}
		}
	}
	
	public void ruch(){
		pozX += kX;
		pozY += kY;
	}
	
	
	

	
	
}
