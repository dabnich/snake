
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
	
	private boolean goraWolna(){
		if(pozY>0){
			if(pl.podajPole(pozX, pozY-1) == 0) return true;
			return false;
		}
		return false;
	}
	
	private boolean dolWolna(){
		if(pozY<pl.dlugosc-1){
			if(pl.podajPole(pozX, pozY+1) == 0) return true;
			return false;
		}
		return false;
	}
	
	private boolean lewaWolna(){
		if(pozX>0){
			if(pl.podajPole(pozX-1, pozY) == 0) return true;
			return false;
		}
		return false;
	}
	
	private boolean prawaWolna(){
		if(pozX<pl.szerokosc-1){
			if(pl.podajPole(pozX+1, pozY) == 0) return true;
			return false;
		}
		return false;
	}
	

	
	
}
