package fase1;

import java.io.IOException;
import java.util.Scanner;

public class WebAplikazioa {


	public static void main(String[] args) throws IOException {
		//  SORTU ETA HASIERATU HIZTEGIA (Singleton)
		//  SORTU ETA HASIERATU INTERNET (Singleton)

		Internet i = Internet.getInternetInstance();		
		Hiztegia h = Hiztegia.getHiztegiaInstance();
		
		i.hasieratu("fitxategiak/smallindex", "fitxategiak/smallpld-arc");	
		h.hasieratu("fitxategiak/smallwords.txt");
		
		System.out.println(h.getHitzak().getLista().get(4096).getDatua());
		
		int aukera = 1;
		Scanner sc = new Scanner(System.in);
		String hitza;
		while(aukera!=0) {
			System.out.println("Zer egin nahi duzu?");
			System.out.println("1. Web-orriak bilatu gako-hitzen bidez");
			System.out.println("0. Irten");
			aukera = Integer.parseInt(sc.nextLine());
			switch(aukera) {
			case 1: System.out.println("Sartu gako-hitz bat:");			        
			        hitza=sc.nextLine();
			        hitza.trim();
			        
			        i.webBilatzailea(hitza);
				
				    break;
			default: break;
			}
		}
		sc.close();

	}

}