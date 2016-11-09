package haha.meme.haha;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * @author Jimmy
 *
 */
@Entity
@Table(name = "TypProduktu")
public class TypProduktu implements Serializable {
	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue
	private Long id;

	private String nazov;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Produkt> zoznamProduktovList;
	// @ManyToMany(mappedBy="zoznamTypovProduktov")
	@ManyToMany
	@JoinTable(name = "TYPPROD_POIST")
	private List<Poistovna> zoznamPoistovni;

	public TypProduktu() {
	}

	public TypProduktu(long id, String nazov, List<Produkt> zoznamProduktovList, List<Poistovna> zoznamPoistovni) {
		this.id = id;
		this.nazov = nazov;
		this.zoznamProduktovList = zoznamProduktovList;
		this.zoznamPoistovni = zoznamPoistovni;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazov() {
		return nazov;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}

	// @ManyToMany(targetEntity=Poistovna.class)
	// @JoinTable(name="ZOZN_POIST")
	public List<Poistovna> getZoznamPoistovni() {
		return zoznamPoistovni;
	}

	public void setZoznamPoistovni(List<Poistovna> zoznamPoistovni) {
		this.zoznamPoistovni = zoznamPoistovni;
	}

	public List<Produkt> getZoznamProduktov() {
		return zoznamProduktovList;
	}

	public void setZoznamProduktov(List<Produkt> zoznamProduktov) {
		this.zoznamProduktovList = zoznamProduktov;
	}

	@Override
	public String toString() {
		return String.format("(%s, %s, %s)", this.nazov, this.zoznamProduktovList + "KUKU",
				this.zoznamPoistovni + "HUHU");
	}
}