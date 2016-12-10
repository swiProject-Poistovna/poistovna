package sk.upjs.swi;

import java.io.Serializable;

/**
 * 
 * @author Jimmy
 * 
 *         trieda sluzi na ulozenie dat, ktore pridu z klienta
 * 
 */

public class PoistenecDataIn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9089795174166955301L;
	private int vek;
	private int rizikovaSkupina;
	// private String nazovTypuProduktu;
	private int dobaPoistenia;
	private int cielovaSumaPoistenia;
	private int jednotkovaSuma;
	
	private int idTypProduktu;
	
	private TypProduktu typProduktu;

	public PoistenecDataIn() {
		// TODO Auto-generated constructor stub
	}

	public int getVek() {
		return vek;
	}

	public void setVek(int vek) {
		this.vek = vek;
	}

	public int getRizikovaSkupina() {
		return rizikovaSkupina;
	}

	public void setRizikovaSkupina(int rizikovaSkupina) {
		this.rizikovaSkupina = rizikovaSkupina;
	}

	public int getDobaPoistenia() {
		return dobaPoistenia;
	}

	public void setDobaPoistenia(int dobaPoistenia) {
		this.dobaPoistenia = dobaPoistenia;
	}

	public int getCielovaSumaPoistenia() {
		return cielovaSumaPoistenia;
	}

	public void setCielovaSumaPoistenia(int cielovaSumaPoistenia) {
		this.cielovaSumaPoistenia = cielovaSumaPoistenia;
	}

	public int getJednotkovaSuma() {
		return jednotkovaSuma;
	}

	public void setJednotkovaSuma(int jednotkovaSuma) {
		this.jednotkovaSuma = jednotkovaSuma;
	}

	public TypProduktu getTypProduktu() {
		return typProduktu;
	}

	public void setTypProduktu(TypProduktu typProduktu) {
		this.typProduktu = typProduktu;
	}

	public int getIdTypProduktu() {
		return idTypProduktu;
	}

	public void setIdTypProduktu(int idTypProduktu) {
		this.idTypProduktu = idTypProduktu;
	}

}
