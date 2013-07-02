import java.util.ArrayList;
import java.math.*;


public class plansza {
	//pole pole;
	//ArrayList<pole> pola = new ArrayList<pole>();
	private int wielkosc;
	public int szerokosc;
	public int dlugosc;
	ArrayList<Integer> zajete = new ArrayList<Integer>();
	//ArrayList<Integer> pola = new ArrayList<Integer>();
	int[][] pola;
	
	public plansza(int szerokosc, int dlugosc){
		this.szerokosc = szerokosc;
		this.dlugosc = dlugosc;
		this.wielkosc = szerokosc*dlugosc;
		
		this.pola = new int[szerokosc][dlugosc];
		
		for(int x=0; x<this.szerokosc; x++){
			for(int y=0; y<this.dlugosc; y++){
				this.pola[x][y] = 0;
			}
		}
	}
	
	public void ustawPole(int x, int y, int stan){
		if(pola[x][y]==0){
			pola[x][y] = stan;
			
			zajete.add(x+(y*szerokosc));
		}
		
		/*
		if(pola.get(n)==0){
			pola.add(n, stan);
			if(stan!=0) zajete.add(n);
		}
		*/
	}
	
	public int podajPole(int x, int y){
		return pola[x][y];
	}
	
	public int[] podajWsp(int n){
		
		int y = n/szerokosc;
		int x = n-(y*szerokosc);
		int [] wynik = {x, y};
		return wynik;
	}
	
	public int podajKlucz(int pozX, int pozY){
		return pozX+(pozY*szerokosc);
	}
	
}
