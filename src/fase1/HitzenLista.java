package fase1;

import java.util.ArrayList;

public class HitzenLista {
	
	private ArrayList<Hitza> lista;
	
	// Eraikitzailea
	
	public HitzenLista() {
		
		this.setLista(new ArrayList<Hitza>());
	}
	
	
	// Get/Seterrak
	
	public ArrayList<Hitza> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Hitza> lista) {
		this.lista = lista;
	}
	
	/**
	* Hitz bat gehitzen dio listari
	* @param hitza: gehitzen den hitza
	*/
	public void hitzaGehitu(Hitza hitza) {
		
		
		if(!this.lista.contains(hitza))
			
			this.lista.add(hitza);
		
	}
	/**
	* Emandako stringa bilatzen du hitzen listan eta dagokion hitza itzultzen du
	* @param s: bilatu nahi den hitzaren testua (stringa)
	* @return s stringari dagokion hitza (listan badago), null bestela
	*/
	public Hitza hitzaBilatu(String s) {
		
		int i = this.lista.indexOf(new Hitza(s));
		
		if(i >= 0) {
			
			return this.lista.get(i);
		}
		
		return null;
		
	}



}
