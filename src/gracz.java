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
	
	public boolean wlasneWolne(){
		if(pl.podajPole(pozX, pozY)!=0)return false;
		else return true;
	}
	
	public boolean pozaObszarem(){
		if(pozX>=pl.szerokosc || pozX<0 || pozY>=pl.dlugosc || pozY<0) return true;
		else return false;
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
	
	public boolean przedWolne(){
		if(kX>0){
			if(prawaWolna())	return true;
			return false;
		}
		if(kX<0){
			if(lewaWolna())	return true;
			return false;
		}
		if(kY>0){
			if(dolWolna())	return true;
			return false;
		}
		if(kY<0){
			if(goraWolna())	return true;
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
	
	public void stop(){
		kX=0;
		kY=0;
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
	
	public void jedzLosowo(){
		Random rand = new Random();
		if(rand.nextInt(20)==0 || !przedWolne())	skrecLosowo();
	}
	
	public void ruch(){
		pozX += kX;
		pozY += kY;
		if(pozaObszarem()){
			pozX-=kX;
			pozY-=kY;
			stop();
		}
		else if(!wlasneWolne()){
			pozX-=kX;
			pozY-=kY;
			stop();
		}
	}
	
}
