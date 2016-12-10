package sk.upjs.swi;

public class InputRowData {

	private int id;
	private String nazov;
	private int jednotkovaSuma;
	/**
	 * cielova suma zvolena zakaznikom
	 */
	private int cielovaSuma;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazov() {
		return nazov;
	}
	public void setNazov(String nazov) {
		this.nazov = nazov;
	}
	public int getJednotkovaSuma() {
		return jednotkovaSuma;
	}
	public void setJednotkovaSuma(int jednotkovaSuma) {
		this.jednotkovaSuma = jednotkovaSuma;
	}
	public int getCielovaSuma() {
		return cielovaSuma;
	}
	public void setCielovaSuma(int cielovaSuma) {
		this.cielovaSuma = cielovaSuma;
	}	
	
}
