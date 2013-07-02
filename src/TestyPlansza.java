import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

 public class TestyPlansza{
	 
	 
	 @Test public void generowaniePlanszy(){
		 plansza pl = new plansza(Constants.szerokoscOkna, Constants.wysokoscOkna);
		 assertEquals("ilosc pol", (int)(Constants.szerokoscOkna*Constants.wysokoscOkna), pl.pola[0].length*pl.pola.length);
		 boolean wyzerowana=true;
		 for(int x=0; x<Constants.szerokoscOkna; x++){
			for(int y=0; y<Constants.wysokoscOkna; y++){
					if(pl.pola[x][y]!=0){ 
						wyzerowana=false;
						break;
					}
			}
		 }
		 assertEquals("pola wyzerowane", wyzerowana, true);
	}
	 
	 public void iloscZajetych(){
		 plansza pl = new plansza(Constants.szerokoscOkna, Constants.wysokoscOkna);
		 Random rand;
		 int x, y;
		 
		rand = new Random();
		 x = rand.nextInt(Constants.szerokoscOkna);
		 rand = new Random();
		 y = rand.nextInt(Constants.wysokoscOkna);
		
		 pl.ustawPole(x, y, 1);
		 assertEquals("ilosc zajêtych", pl.zajete.size(), 1);
		 
		 pl.ustawPole(x, y, 1);
		 assertEquals("ilosc zajetych ponownie", pl.zajete.size(), 1);
	}
	 
	 @Test public void poprawnoscWspolrzednych(){
		plansza pl = new plansza(Constants.szerokoscOkna, Constants.wysokoscOkna);
		int i=0;
		int[] wsp;
		wsp = new int[2];
		for(int x=0; x<Constants.szerokoscOkna; x++){
			for(int y=0; y<Constants.wysokoscOkna; y++){
				pl.ustawPole(x, y, 1);
				i++;
				
				assertEquals("ilosc zajetych", pl.zajete.size(), i);
				
				wsp = pl.podajWsp(pl.zajete.get(i-1));
				assertEquals("wspolrzedneX zajetego", wsp[0], x);
				assertEquals("wspolrzedneY zajetego", wsp[1], y);
			}
		}
	 }
		
	@Test public void szybkoscUstawienia(){
		plansza pl = new plansza(Constants.szerokoscOkna, Constants.wysokoscOkna);
		for(int x=0; x<Constants.szerokoscOkna; x++){
			for(int y=0; y<Constants.wysokoscOkna; y++){
				pl.ustawPole(x, y, 1);
			}
		}
	}
	
	
	

}
	 
	 
	 
	 
   
	
	 
	 

 