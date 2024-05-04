package projekt_knihovna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Knihovna {

	static Map<String,Kniha> soupisKnih=new HashMap<String, Kniha>();
	
	public static void pridatKnihu(Scanner sc){
		
		  boolean dostupna = true;
		  String zanr = null;
		  int vhodnost = 0;  
		
		  System.out.println("Zadejte n�zev:");
		  String jmeno = sc.next();
		  System.out.println("Zadejte autora:");
		  String autor = sc.next();
		  System.out.println("Zadejte rok vyd�n�:");
		  int rok = vstupCisla.pouzeCeleCislo(sc);

		  
		  System.out.println("Chcete p�idat rom�n nebo u�ebnici?");
		  System.out.println("1 - Rom�n");
		  System.out.println("2 - U�ebnice");
		
		  int vyber = vstupCisla.pouzeCeleCislo(sc);
		  if (vyber == 1)
		  {
			  System.out.println("Napi�te ��nr rom�nu:");
			  System.out.println("DOBRODRUZNY");
			  System.out.println("ISCI-FI");
			  System.out.println("HISTORCKY");
			  System.out.println("BIOGRAFICKY");
			  System.out.println("HUMORISTICKY");
			  
			  zanr = sc.next().toUpperCase();  
		  }

		  else if (vyber == 2) 
		  {
			  System.out.println("Pro jak� ro�n�k je u�ebnice vhodn�?");
			  System.out.println("Zadejte ro�n�k v rozsahu 1-9");
			  vhodnost = vstupCisla.pouzeCeleCislo(sc);
			 
		  }
		  else {
			  System.out.println("Zadali jste nespr�vnou hodnotu");
		  } 	
		  
		  Kniha knizka = new Kniha(jmeno, autor, rok, dostupna, zanr, vhodnost);
		  soupisKnih.put(jmeno, knizka);
		  System.out.println("Kniha byla p�id�na");
		  
	}
	
	
	public static void upravitKnihu(Scanner sc) {
		System.out.println("Zadejte n�zev knihy, kterou chcete upravit");
		String jmeno = sc.next();
		
		if(!soupisKnih.containsKey(jmeno)) {
			System.out.println("Kniha s t�mto n�zvem se v knihovn� nenach�z�");
		}
		
		else {
			Kniha knizka = soupisKnih.get(jmeno);
			System.out.println("Chci upravit: ");
			System.out.println("1 - Autora");
			System.out.println("2 - Rok vyd�n�");
			System.out.println("3 - Dostupnost");
			int vstup = vstupCisla.pouzeCeleCislo(sc);
			
			if (vstup == 1) {
				System.out.println("Zadejte nov�ho autora:");
				String autor = sc.next();
				knizka.setAutor(autor);
				System.out.println("Autor byl opraven");
			}
			else if (vstup == 2) {
				System.out.println("Zadejte nov� rok vyd�n�:");
				int rok = vstupCisla.pouzeCeleCislo(sc);
				knizka.setRok(rok);
				System.out.println("Rok vyd�n� byl opraven");
			}
			else if (vstup == 3) {
				System.out.println("Zadejte stav dostupnosti:");
				System.out.println("1 - Dostupn�");
				System.out.println("2 - Vyp�j�en�");
				
					int vstup2 = vstupCisla.pouzeCeleCislo(sc);
						switch (vstup2) {
						case 1: knizka.setDostupna(true);
								System.out.println("Kniha byla nastavena jako dostupn�");
								break;
						case 2: knizka.setDostupna(false);
								System.out.println("Kniha byla nastavena jako nedostupn� (vyp�j�en�)");
								break;
						}
			}
			else {
				System.out.println("Zadali jste neplatnou operaci");
				System.out.println("Opakujte akci znovu");
			}
		}
	}
	
	public static void smazatKnihu (Scanner sc) {
		System.out.println("Zadejte n�zev knihy, kterou chcete smazat");
		String jmeno = sc.next();
		
		if(!soupisKnih.containsKey(jmeno)) {
			System.out.println("Kniha s t�mto n�zvem se v knihovn� nenach�z�");
		}
		else {
			soupisKnih.remove(jmeno);
			System.out.println("Kniha byla smaz�na");	
		}
	}
	
	public static void oznacitKnihu (Scanner sc) {
		System.out.println("Zadejte n�zev knihy, kterou chcete vyp�j�it nebo vr�tit");
		String jmeno = sc.next();
		
		if(!soupisKnih.containsKey(jmeno)) {
			System.out.println("Kniha s t�mto n�zvem se v knihovn� nenach�z�");
		}
		else {
			Kniha knizka = soupisKnih.get(jmeno);
			System.out.println("P�ejete si knihu vyp�j�it nebo ji vrac�te?");
			System.out.println("1 - Vyp�j�it");
			System.out.println("2 - Vr�tit");
			
			int vstup3 = vstupCisla.pouzeCeleCislo(sc);
			if (vstup3 == 1) {
				knizka.setDostupna(false);
				System.out.println("Kniha byla ozna�ena jako nedostupn�");
			}
			else if (vstup3 == 2 ) {
				knizka.setDostupna(true);
				System.out.println("Kniha byla ozna�ena jako dostupn�");
			}
			else {
				System.out.println("Zadali jste neplatnou operaci");
				System.out.println("Opakujte akci znovu");
			}
		}
	}
	
	public static void vypisKnihAbeceda (Scanner sc) {
		if(soupisKnih.isEmpty()){
            System.out.println("V knihovn� nen� ��dn� kniha");
            return;
        }

        List<Kniha> seznamKnih = new ArrayList<>(soupisKnih.values());
        Collections.sort(seznamKnih, (kniha1, kniha2) -> kniha1.getJmeno().compareTo(kniha2.getJmeno()));

        for (Kniha kniha : seznamKnih) {
            System.out.print("N�zev knihy: " + kniha.getJmeno() + " | ");
            System.out.print("Autor: " + kniha.getAutor() + " | ");
            System.out.print("Rok vyd�n�: " + kniha.getRok() + " | ");
            System.out.print("Dostupnost: " + kniha.getDostupna() + " | ");
            if (kniha.getZanr() != null) {
                System.out.println("��nr: " + kniha.getZanr());
            } else {
                System.out.println("Ro�n�k: " + kniha.getVhodnost());
            }
        }
	}
	
	public static void najitKnihu(Scanner sc) {
		System.out.println("Zadejte n�zev knihy");
		String jmeno = sc.next();
		
		if(!soupisKnih.containsKey(jmeno)) {
			System.out.println("Kniha s t�mto n�zvem se v knihovn� nenach�z�");
		}
		else {
			Kniha knizka = soupisKnih.get(jmeno);
			System.out.println("N�zev knihy: " + knizka.getJmeno() + " | "+ "Autor: " + knizka.getAutor() + " | " + "Rok vyd�n�: " + knizka.getRok());
			System.out.println("Dostupn�? " + knizka.getDostupna());
			System.out.println(knizka.getZanr() != null ? "��nr: " + knizka.getZanr(): "Vhodn� pro: " + knizka.getVhodnost() + ". ro�n�k");
		}
	}
	
	public static void vypisKnihAutor(Scanner sc) {
		System.out.println("Zadejte autora");
		String autor = sc.next();
		
		List<Kniha> knihyAutora = new ArrayList<>();
		
		for (Kniha knizka : soupisKnih.values()) {
			if(knizka.getAutor().equals(autor)) {
				knihyAutora.add(knizka);
			}
		}
		
		if(knihyAutora.isEmpty()) {
			System.out.println("V knihovn� nejsou knihy od tohoto autora");
		}
		
		Collections.sort(knihyAutora, (knizka1, knizka2) -> Integer.compare(knizka1.getRok(), knizka2.getRok()));
				
		for (Kniha knizka : knihyAutora) {
			System.out.println("N�zev knihy: " + knizka.getJmeno() + " | " + "Rok vyd�n�: " + knizka.getRok());
		}
	}	
	
	
	public static void vypisKnihZanr(Scanner sc) {
		System.out.println("Zadejte ��nr knihy: DOBRODRUZNY | SCI-FI | HISTORICKY | BIOGRAFICKY | HUMORISTICKY");
        String zanr = sc.next().toUpperCase();


        List<Kniha> knihyPodleZanru = new ArrayList<>();

        for (Kniha kniha : soupisKnih.values()) {
            String knihaZanr = kniha.getZanr();

            if (knihaZanr != null && knihaZanr.equals(zanr)) {
                knihyPodleZanru.add(kniha);
            }
        }

        if (knihyPodleZanru.isEmpty()) {
            System.out.println("V knihovn� nejsou ��dn� knihy tohoto ��nru.");
        }

        for (Kniha kniha : knihyPodleZanru) {
            System.out.print("N�zev knihy: " + kniha.getJmeno() + " | ");
            System.out.print("Autor: " + kniha.getAutor() + " | ");
            System.out.print("Rok vyd�n�: " + kniha.getRok() + " | ");
            System.out.print("Dostupnost: " + kniha.getDostupna() + " | ");
            System.out.println("��nr: " + kniha.getZanr());
        }
	}
	
	public static void vypisVypujcene(Scanner sc) {
		System.out.println("Aktu�ln� vyp�j�en� knihy:");
		System.out.println();
		for (Kniha knizka : soupisKnih.values()) {
			if(knizka.getDostupna() == false) {

				System.out.println(knizka.getJmeno() + (knizka.getZanr() != null ?" | " + knizka.getZanr() + " rom�n": " | u�ebnice pro " + knizka.getVhodnost() + ". ro�n�k"));
			}
		}
	}

	public static void zapisDoSouboru (Scanner sc) {
		System.out.println("Zadejte n�zev knihy, kterou chcete zapsat do souboru:");
        String nazev = sc.next();

        if (!soupisKnih.containsKey(nazev)) {
            System.out.println("Kniha nebyla nalezena v seznamu.");
            return;
        }

        try {
            String nazevSouboru = nazev + ".txt"; 
            PrintWriter writer = new PrintWriter(new FileWriter(nazevSouboru, false));

            for (Kniha kniha : soupisKnih.values()) {
                if (kniha.getJmeno().equals(nazev)) {
                    writer.println(kniha.getJmeno());
                    writer.println(kniha.getAutor());
                    writer.println(kniha.getRok());
                    writer.println(kniha.getDostupna());
                    if (kniha.getZanr() != null) {
                        writer.println(kniha.getZanr());
                    } else {
                        writer.println(kniha.getVhodnost());
                    } 
                }
            }

            writer.close();

            System.out.println("Informace o knize byly �sp�n� zaps�ny do souboru " + nazevSouboru);
        } catch (IOException e) {
            System.out.println("Chyba p�i ukl�d�n� do souboru: " + e.getMessage());
        }
	}
	
	public static void cteniZeSouboru (Scanner sc) {

		System.out.println("Zadejte n�zev souboru, ze kter�ho chcete informace na��st");
		String nazevSouboru = sc.next();
		
		File soubor2 = new File(nazevSouboru + ".txt");
		
		if(soubor2.exists()) {
			try {
				
				FileReader fr=new FileReader(soubor2);
				BufferedReader br=new BufferedReader(fr);
				
				String jmeno = br.readLine();
				String autor = br.readLine();
				int rok = Integer.parseInt(br.readLine());
				boolean dostupna = Boolean.parseBoolean(br.readLine());

				String line = br.readLine();
				    if (line.matches("\\d+")) {
						int vhodnost = Integer.parseInt(line);
					    String zanr = null;
						Kniha knizka = new Kniha(jmeno, autor, rok, dostupna, zanr, vhodnost);
						soupisKnih.put(jmeno, knizka);
						System.out.println("P�idali jste u�ebnici");

				    } else {
						String zanr = line;
						int vhodnost = 0;
						Kniha knizka = new Kniha(jmeno, autor, rok, dostupna, zanr, vhodnost);

						soupisKnih.put(jmeno, knizka);
						System.out.println("P�idali jste rom�n");

				    }

                br.close();
            }
			catch (IOException e) {
				System.err.println("Chyba p�i �ten� souboru: " + e.getMessage());
			}		
		}
		else {
			System.out.println("Soubor s t�mto n�zvem neexistuje");
		}
	}
	
	
	
	
}