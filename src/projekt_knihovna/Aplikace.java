package projekt_knihovna;

import java.util.Scanner;

public class Aplikace {

	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);

	  
      int choice = 0; 
      boolean run = true;
      
      while(run)
	  {
      System.out.println(System.lineSeparator());
      System.out.println("Vítejte v knihovnì");
      System.out.println();
      System.out.println("Vyberte èinnost:");
      System.out.println("1 ... Pøidání nové knihy");
      System.out.println("2 ... Úprava knihy");
      System.out.println("3 ... Smazání knihy");
      System.out.println("4 ... Oznaèení vypùjèené/vrácené knihy");
      System.out.println("5 ... Výpis knih podle abecedy");
      System.out.println("6 ... Najít knihu podle názvu");
      System.out.println("7 ... Výpis knih daného autora");
      System.out.println("8 ... Výpis knih daného žánru");
      System.out.println("9 ... Výpis vypùjèených knih");
      System.out.println("10 ... Zápis knihy do souboru");
      System.out.println("11 ... Naètení knihy ze souboru");
      System.out.println("12 ... Vypnout aplikaci");
	
      choice = vstupCisla.pouzeCeleCislo(sc);
      
	  switch(choice) {
	  
	  case 1:
		  Knihovna.pridatKnihu(sc);
		  break;
	  case 2:
		  Knihovna.upravitKnihu(sc);
		  break;
	  case 3:
		  Knihovna.smazatKnihu(sc);
		  break;
	  case 4:
		  Knihovna.oznacitKnihu(sc);
		  break;
	  case 5:
		  Knihovna.vypisKnihAbeceda(sc);
		  break;
	  case 6:
		  Knihovna.najitKnihu(sc);
		  break;
	  case 7:
		  Knihovna.vypisKnihAutor(sc);
		  break;
	  case 8:
	      Knihovna.vypisKnihZanr(sc);
		  break;	
	  case 9:
		  Knihovna.vypisVypujcene(sc);
		  break;
	  case 10:
		  Knihovna.zapisDoSouboru(sc);
		  break;
	  case 11:
		  Knihovna.cteniZeSouboru(sc);
		  break;
	  case 12:
		  run=false;
		  break;
	  }
	}
	}
}
