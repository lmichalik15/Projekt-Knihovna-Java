package projekt_knihovna;

import java.util.Scanner;

public class vstupCisla{

	  public static int pouzeCeleCislo(Scanner sc) {
		    int cislo = 0;
		    try {
		      cislo = sc.nextInt();
		    }
		    catch (Exception e) {
		      System.out.println("Nastala zde v�jimka typu " + e.toString());
		      System.out.println("Zadejte pros�m cel� ��slo");
		      sc.nextLine();
		      cislo = pouzeCeleCislo(sc);
		    }
		    return cislo;
		  }
	 

}
