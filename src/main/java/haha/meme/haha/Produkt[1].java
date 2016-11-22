package haha.meme.haha;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Produkt")
public class Produkt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8426736342857815290L;

	@Id
	@GeneratedValue
	private int id;

	private int idTypProduktu;
	private int idPoistovna;
	private int rizikovaSkupina;
	private int dobaPoisteniaOd;
	private int dobaPoisteniaDo;
	private int minVek;
	private int maxVek;
	@OneToMany
	private List<Koeficienty> koeficientyList;
	@ManyToOne
	private Poistovna poistovna;
	
	@ManyToOne(targetEntity=TypProduktu.class)
	@JoinColumn(name="id", insertable=false, updatable=false)
	private TypProduktu typProduktu;

	public Produkt() {
		super();
	}

	public Produkt(int idTypProduktu, int idPoistovna, String nazov, int rizikovaSkupina, int dobaPoisteniaOd,
			int dobaPoisteniaDo, int minVek, int maxVek, List<Koeficienty> koeficientyList, TypProduktu typProduktu) {

		this.idTypProduktu = idTypProduktu;
		this.idPoistovna = idPoistovna;
		this.rizikovaSkupina = rizikovaSkupina;
		this.dobaPoisteniaOd = dobaPoisteniaOd;
		this.dobaPoisteniaDo = dobaPoisteniaDo;
		this.minVek = minVek;
		this.maxVek = maxVek;
		this.koeficientyList = koeficientyList;
		this.typProduktu = typProduktu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTypProduktu() {
		return idTypProduktu;
	}

	public void setIdTypProduktu(int idTypProduktu) {
		this.idTypProduktu = idTypProduktu;
	}

	public int getIdPoistovna() {
		return idPoistovna;
	}

	public void setIdPoistovna(int idPoistovna) {
		this.idPoistovna = idPoistovna;
	}

	public int getRizikovaSkupina() {
		return rizikovaSkupina;
	}

	public void setRizikovaSkupina(int rizikovaSkupina) {
		this.rizikovaSkupina = rizikovaSkupina;
	}

	public int getDobaPoisteniaOd() {
		return dobaPoisteniaOd;
	}

	public void setDobaPoisteniaOd(int dobaPoisteniaOd) {
		this.dobaPoisteniaOd = dobaPoisteniaOd;
	}

	public int getDobaPoisteniaDo() {
		return dobaPoisteniaDo;
	}

	public void setDobaPoisteniaDo(int dobaPoisteniaDo) {
		this.dobaPoisteniaDo = dobaPoisteniaDo;
	}

	public int getMinVek() {
		return minVek;
	}

	public void setMinVek(int minVek) {
		this.minVek = minVek;
	}

	public int getMaxVek() {
		return maxVek;
	}

	public void setMaxVek(int maxVek) {
		this.maxVek = maxVek;
	}

	public List<Koeficienty> getKoeficientyList() {
		return koeficientyList;
	}

	public void setKoeficientyList(List<Koeficienty> koeficientyList) {
		this.koeficientyList = koeficientyList;
	}

	public Poistovna getPoistovna() {
		return poistovna;
	}

	public void setPoistovna(Poistovna poistovna) {
		this.poistovna = poistovna;
	}

	public TypProduktu getTypProduktu() {
		return typProduktu;
	}

	public void setTypProduktu(TypProduktu typProduktu) {
		this.typProduktu = typProduktu;
	}

	@Override
	public String toString() {
		return String.format("(%d, %d, %d, %d, %d, %s)", this.rizikovaSkupina, this.dobaPoisteniaOd,
				this.dobaPoisteniaDo, this.minVek, this.maxVek, this.koeficientyList);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dobaPoisteniaDo;
		result = prime * result + dobaPoisteniaOd;
		result = prime * result + idPoistovna;
		result = prime * result + idTypProduktu;
		result = prime * result + ((koeficientyList == null) ? 0 : koeficientyList.hashCode());
		result = prime * result + maxVek;
		result = prime * result + minVek;
		result = prime * result + ((poistovna == null) ? 0 : poistovna.hashCode());
		result = prime * result + rizikovaSkupina;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produkt other = (Produkt) obj;
		if (dobaPoisteniaDo != other.dobaPoisteniaDo)
			return false;
		if (dobaPoisteniaOd != other.dobaPoisteniaOd)
			return false;
		if (idPoistovna != other.idPoistovna)
			return false;
		if (idTypProduktu != other.idTypProduktu)
			return false;
		if (koeficientyList == null) {
			if (other.koeficientyList != null)
				return false;
		} else if (!koeficientyList.equals(other.koeficientyList))
			return false;
		if (maxVek != other.maxVek)
			return false;
		if (minVek != other.minVek)
			return false;
		if (poistovna == null) {
			if (other.poistovna != null)
				return false;
		} else if (!poistovna.equals(other.poistovna))
			return false;
		if (rizikovaSkupina != other.rizikovaSkupina)
			return false;
		return true;
	}

}
