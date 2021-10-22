package fase1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Internet {
	
	private static Internet internetInstance;
	
	private Hiztegia nireHiztegia;
	
	private WebenLista webak;
	
	// Eraikitzailea
	
	public WebenLista getWebak() {
		return webak;
	}

	public void setWebak(WebenLista webak) {
		this.webak = webak;
	}

	private Internet() {
		
		this.setNireHiztegia(new Hiztegia());
	}
	
	// Get/Seterrak
	
	public Internet getInternetInstance() {
		
		if(internetInstance == null)
			
			return new Internet();
		
		else 
			return internetInstance;
	}


	public Hiztegia getNireHiztegia() {
		return nireHiztegia;
	}


	public void setNireHiztegia(Hiztegia nireHiztegia) {
		this.nireHiztegia = nireHiztegia;
	}

	
	
	/**
	* Pasatako fitxategian dauden webak kargatzen ditu
	* @param fitxIzena: webak dauzkan fitxategiaren izena
	 * @throws FileNotFoundException 
	*/
	private void webakKargatu(String fitxIzena) throws FileNotFoundException {
		
		// Fitxategi izenak hutsunerik ez duela ziurtatzeko
		fitxIzena.trim();
		
		Scanner sc = new Scanner(new File(fitxIzena));
		String lerroa;
		String[] osagaiak;
		
		while (sc.hasNextLine()) {
			lerroa = sc.nextLine();
			lerroa.trim();
			osagaiak = lerroa.split("\\s+");
			Web w = new Web(Integer.parseInt(osagaiak[1]), osagaiak[0]);
			
			this.webak.webaErantsi(w);
			
		}

		
		sc.close();	
		
	}
	
	/**
	* Pasatako fitxategian dauden estekak kargatzen ditu
	* @param fitxIzena: estekak dauzkan fitxategiaren izena
	 * @throws FileNotFoundException 
	*/
	private void estekakKargatu(String fitxIzena) throws FileNotFoundException{
		
		// Fitxategi izenak hutsunerik ez duela ziurtatzeko
		fitxIzena.trim();
		
		Scanner sc = new Scanner(new File(fitxIzena));
		String lerroa;
		String[] osagaiak;
		
		while (sc.hasNextLine()) {
			lerroa = sc.nextLine();
			lerroa.trim();
			osagaiak = lerroa.split("\\s+");
			this.webak.estekaErantsi(Integer.parseInt(osagaiak[0]), Integer.parseInt(osagaiak[1]));
			
		}

		
		sc.close();	
		
		
		
	}
	
	/**
	* Klasea hasieratzen du: horretarako web-orriak eta estekak kargatzen ditu
	* @param webenFitxIzena: webak dauzkan fitxategiaren izena
	* @param estekenFitxIzena: estekak dauzkan fitxategiaren izena
	 * @throws FileNotFoundException 
	*/
	public void hasieratu(String webenFitxIzena, String estekenFitxIzena) throws FileNotFoundException{
		
		webakKargatu(webenFitxIzena);
		estekakKargatu(estekenFitxIzena);
		
	}
	/**
	* Hitz bati dagokion stringa emanda, pantailan inprimatzen ditu
	* gako-hitz hori duten webak
	* @param s: hitzari dagokion stringa
	*/
	public void webBilatzailea(String s){
		
		
		
	}



}
