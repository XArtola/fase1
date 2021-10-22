package fase1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hiztegia {

	private static Hiztegia hiztegiaInstance;

	private HitzenLista hitzak;

	private Internet internet;

	// Eraikitzailea

	private Hiztegia() {

		hiztegiaInstance = new Hiztegia();

		this.hitzak = new HitzenLista();

		internet = Internet.getInternetInstance();

	}

	// Get/Seterrak

	public static Hiztegia getHiztegiaInstance() {

		if (hiztegiaInstance == null)

			return new Hiztegia();

		else

			return hiztegiaInstance;
	}

	public HitzenLista getHitzak() {
		return hitzak;
	}

	public void setHitzak(HitzenLista hitzak) {
		this.hitzak = hitzak;
	}

	/**
	 * Hiztegia kargatzen du emandako fitxategitik
	 * 
	 * @param fitxIzena: hiztegia daukan fitxategiaren izena
	 * @throws FileNotFoundException
	 */
	private void hitzakKargatu(String fitxIzena) throws FileNotFoundException {

		// Fitxategi izenak hutsunerik ez duela ziurtatzeko
		fitxIzena.trim();

		Scanner sc = new Scanner(new File(fitxIzena));
		String lerroa;
		String[] osagaiak;

		while (sc.hasNextLine()) {
			lerroa = sc.nextLine();
			lerroa.trim();
			osagaiak = lerroa.split("\\s+");
			Hitza h = new Hitza(osagaiak[0]);
			this.hitzak.hitzaGehitu(h);

		}

		sc.close();

	}

	/**
	 * Hiztegiko hitz bakoitzari erreferentziatzen dituen web-orriak esleitzen
	 * zaizkio Aurre: Internet eta hiztegia kargatuta daude jadanik
	 */
	private void hitzenWebakKonputatu() {

		WebenLista w = internet.getWebak();

		for (Web web : w.getWebenLista()) {

			String domeinua = web.getDomeinua();

			for (int i = 4; i <= 10; i++) {

				for (int j = 0; j < domeinua.length() - 1 - i; j++) {

					// Hitzen bilaketa bitarra compareTo erabiliz
					int ezker, eskuin, erdiko;
					String bilatzeko = domeinua.substring(j, i);
					ezker = 0;
					eskuin = hitzak.getLista().size() - 1;
					erdiko = (ezker + eskuin) / 2;

					while (ezker < eskuin && hitzak.getLista().get(erdiko).getDatua() != bilatzeko) {

						int konparaketa = hitzak.getLista().get(erdiko).getDatua().compareTo(bilatzeko);

						if (konparaketa == 0) {

							hitzak.getLista().get(erdiko).getWebOrrienLista().add(web);

							ezker = eskuin + 1;

						}

						else if (konparaketa < 0) {

							ezker = erdiko + 1;

						}

						else
							eskuin = erdiko - 1;
						erdiko = (ezker + eskuin) / 2;
					}

				}

			}

		}

	}

	/**
	 * Hiztegia kargatzen du emandako fitxategitik, eta hitz bakoitzaren webak
	 * konputatzen ditu (hitz bakoitzari erreferentziatzen dituen web-orriak
	 * esleitzen zaizkio)
	 * 
	 * @param fitxIzena: hiztegia daukan fitxategiaren izena AURRE: Internet eta
	 *        hiztegia kargatuta daude dagoeneko
	 * @throws FileNotFoundException
	 */
	public void hasieratu(String fitxIzena) throws FileNotFoundException {

		hitzakKargatu(fitxIzena);
		hitzenWebakKonputatu();

	}

	/**
	 * Emandako stringa bilatzen du hiztegian eta dagokion hitza itzultzen du
	 * 
	 * @param s: bilatu nahi den hitzaren testua (stringa)
	 * @return s stringari dagokion hitza (hiztegian badago), null bestela
	 */
	public Hitza hitzaBilatu(String s) {

		for (Hitza hitza : hitzak.getLista()) {

			if (hitza.getDatua() == s)

				return hitza;

		}

		return null;
	}

}
