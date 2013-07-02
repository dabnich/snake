import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Random;



public class TestyGracz {

	@Test public void wolneStrony(){
		plansza plansza = new plansza(Constants.szerokoscOkna, Constants.wysokoscOkna);
		gracz gracz = new gracz(plansza, 300, 300);
		Random random;
		int x, y;
		for(int i=0; i<200; i++){
			
			random = new Random();
			x = random.nextInt(Constants.szerokoscOkna-2);

			
			random = new Random();
			y = random.nextInt(Constants.wysokoscOkna-2);
			
			x+=1;
			y+=1;


			gracz.pozX=x;
			gracz.pozY=y;
			assertEquals("wolna gora", gracz.goraWolna(), true);
			assertEquals("wolna dol", gracz.dolWolna(), true);
			assertEquals("wolna lewa", gracz.lewaWolna(), true);
			assertEquals("wolna prawa", gracz.prawaWolna(), true);
		}
	}
	
	@Test public void rozneStrony(){
		
		Random random;
		int x, y;
		plansza plansza = new plansza(Constants.szerokoscOkna, Constants.wysokoscOkna);
		gracz gracz = new gracz(plansza, 300, 300);
		
		
		for(int i=0; i<200; i++){
			
			random = new Random();
			x = random.nextInt(Constants.szerokoscOkna-4);
	
			
			random = new Random();
			y = random.nextInt(Constants.wysokoscOkna-4);
			
			x+=2;
			y+=2;
			
			gracz.pozX = x;
			gracz.pozY = y;
			
			plansza.ustawPole(x+1, y, 1);
			assertEquals("prawa zajeta", gracz.prawaWolna(), false);
			plansza.ustawPole(x+1, y, 0);
			
			plansza.ustawPole(x-1, y, 1);
			assertEquals("lewa zajeta", gracz.lewaWolna(), false);
			plansza.ustawPole(x-1, y, 0);
			
			plansza.ustawPole(x, y+1, 1);
			assertEquals("dol zajeta", gracz.dolWolna(), false);
			plansza.ustawPole(x, y+1, 0);
			
			plansza.ustawPole(x, y-1, 1);
			assertEquals("gora zajeta", gracz.goraWolna(), false);
			plansza.ustawPole(x, y-1, 0);
		}
	}
	
	@Test public void zajeteRuch (){
		plansza plansza = new plansza(Constants.szerokoscOkna, Constants.wysokoscOkna);
		gracz gracz = new gracz(plansza, 300, 300);
		plansza.ustawPole(300, 300, 1);
		while(gracz.pozY>100){
			gracz.wGore();
			gracz.ruch();
			assertEquals("za sob¹", gracz.dolWolna(), false);
			plansza.ustawPole(gracz.pozX, gracz.pozY, 1);
		}
		//gracz.wPrawo();
		//gracz.ruch();
		gracz.pozX+=1;
		assertEquals("za sob¹", gracz.lewaWolna(), false);
		plansza.ustawPole(gracz.pozX, gracz.pozY, 1);
		while(gracz.pozY<300){
			gracz.wDol();
			gracz.ruch();
			assertEquals("za sob¹", gracz.goraWolna(), false);
			assertEquals("po lewej", gracz.lewaWolna(), false);
			plansza.ustawPole(gracz.pozX, gracz.pozY, 1);
		}
	}
	
}
