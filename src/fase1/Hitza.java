package fase1;

import java.util.ArrayList;

public class Hitza {
	
	private String datua;
	
	private ArrayList<Web> webOrrienLista;
	
	// Eraikitzailea
	
	public Hitza(String datua) {
		
		this.setDatua(datua);
		
		this.setWebOrrienLista(new ArrayList<Web>());
		
		
	}
	
	// Get/Seterrak

	public String getDatua() {
		return datua;
	}

	public void setDatua(String datua) {
		this.datua = datua;
	}

	public ArrayList<Web> getWebOrrienLista() {
		return webOrrienLista;
	}

	public void setWebOrrienLista(ArrayList<Web> webOrrienLista) {
		this.webOrrienLista = webOrrienLista;
	}
	
	@Override
    public boolean equals(Object obj) {
        Hitza h= (Hitza)obj;
        if (this.datua.equals(h.datua)) return true;
        return false;
    }

}
