package sk.upjs.swi;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "Poistovna")
public class Poistovna implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8304749490020459662L;

	@Id
	@GeneratedValue
	// @ColumnDefault(value = "20")
	private int id;

	@Column(nullable = false, unique = true)
	private String nazov;

	// @ManyToMany
	// @JoinTable(name="TypProduktu")
	@ManyToMany(mappedBy = "zoznamPoistovni")
	private List<TypProduktu> zoznamTypovProduktov;

	// @OneToMany
	// private List<Produkt> zoznamProduktov;

	public Poistovna() {
		// TODO Auto-generated constructor stub
	}

	public Poistovna(int id, String nazov) {
		this.id = id;
		this.nazov = nazov;
	}

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

	// public List<Produkt> getZoznamProduktov() {
	// return zoznamProduktov;
	// }
	//
	// public void setZoznamProduktov(List<Produkt> zoznamProduktov) {
	// this.zoznamProduktov = zoznamProduktov;
	// }

	@Override
	public String toString() {
		StringBuilder vysledok = new StringBuilder();

		vysledok.append("Poistovna [id=" + id + ", nazov=" + nazov + "]");

		for (TypProduktu typProduktu : zoznamTypovProduktov) {
			vysledok.append(" " + typProduktu + "; ");
		}
		return vysledok.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nazov == null) ? 0 : nazov.hashCode());
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
		Poistovna other = (Poistovna) obj;
		if (nazov == null) {
			if (other.nazov != null)
				return false;
		} else if (!nazov.equals(other.nazov))
			return false;
		return true;
	}

	// setters and getters
}