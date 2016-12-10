package sk.upjs.swi;

public class InputData {

	private int vek;
	private int rizikovaSkupina;
	private int dobaPoistenia;
	
	private InputRowData[] typyProduktov;

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

	public InputRowData[] getTypyProduktov() {
		return typyProduktov;
	}

	public void setTypyProduktov(InputRowData[] typyProduktov) {
		this.typyProduktov = typyProduktov;
	}
	
}
