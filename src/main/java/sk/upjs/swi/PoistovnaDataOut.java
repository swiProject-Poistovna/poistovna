package sk.upjs.swi;

import java.io.Serializable;

/**
 * Trieda sluzi na odoslanie dat na klienta, ktore by sa potom mali zobrazit v
 * tabulke
 * 
 * @author Jimmy
 *
 */

public class PoistovnaDataOut implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6325784196916440235L;
	private String nazovPoistovne;
	private double vyslednaMesacnaPlatba;

	public PoistovnaDataOut(String nazovPoistovne, double vyslednaMesacnaPlatba) {
		this.nazovPoistovne = nazovPoistovne;
		this.vyslednaMesacnaPlatba = vyslednaMesacnaPlatba;
	}

	public String getNazovPoistovne() {
		return nazovPoistovne;
	}

	public void setNazovPoistovne(String nazovPoistovne) {
		this.nazovPoistovne = nazovPoistovne;
	}

	public double getVyslednaMesacnaPlatba() {
		return vyslednaMesacnaPlatba;
	}

	public void setVyslednaMesacnaPlatba(double vyslednaMesacnaPlatba) {
		this.vyslednaMesacnaPlatba = vyslednaMesacnaPlatba;
	}

}
