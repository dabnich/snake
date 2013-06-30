import java.util.ArrayList;


public class plansza {
	//pole pole;
	//ArrayList<pole> pola = new ArrayList<pole>();
	private int wielkosc;
	public int szerokosc;
	public int dlugosc;
	ArrayList<Integer> zajete = new ArrayList<Integer>();
	ArrayList<Integer> pola = new ArrayList<Integer>();
	
	public plansza(int szerokosc, int dlugosc){
		this.szerokosc = szerokosc;
		this.dlugosc = dlugosc;
		this.wielkosc = szerokosc*dlugosc;
		
		for(int y=0; y<this.dlugosc; y++){
			for(int x=0; x<this.szerokosc; x++){
				pola.add(0);
			}
		}
	}
	
	public void ustawPole(int x, int y, int stan){
		int n = x+(y*szerokosc);
		pola.add(n, stan);
		if(stan!=0) zajete.add(n);
	}
	
	public int podajPole(int x, int y){
		return pola.get(x+(y*szerokosc));
	}
	
	public int[] podajWsp(int n){
		
		int y = (int)(n/szerokosc);
		int x = n-(y*szerokosc);
		int [] wynik = {x, y};
		return wynik;
	}
	
	
	
	
	
}
