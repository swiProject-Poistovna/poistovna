package sk.upjs.swi;

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
	private int id;

	private String nazov;
	@Column
	private int jednotkovaSuma;
	
//	@OneToMany
//	@OneToMany(targetEntity=Produkt.class, cascade = CascadeType.ALL, mappedBy="typProduktu", fetch=FetchType.EAGER)
	@OneToMany(targetEntity=Produkt.class, mappedBy="typProduktu", fetch=FetchType.EAGER)
	private List<Produkt> zoznamProduktovList;
	// @ManyToMany(mappedBy="zoznamTypovProduktov")
	@ManyToMany
	@JoinTable(name = "TYPPROD_POIST")
	private List<Poistovna> zoznamPoistovni;

	
	private static final int JEDNOTKOVA_SUMA_HOSPITALIZACIA = 1;
	private static final int JEDNOTKOVA_SUMA_SMRT_TRVALE_NASLEDKY = 1000; 
	private static final int JEDNOTKOVA_SUMA_KRITICKE_CHOROBY = 100;
	
	

	public TypProduktu() {
	}

	public TypProduktu(int id, String nazov, List<Produkt> zoznamProduktovList, List<Poistovna> zoznamPoistovni) {
		this.id = id;
		this.nazov = nazov;
		this.zoznamProduktovList = zoznamProduktovList;
		this.zoznamPoistovni = zoznamPoistovni;
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

	public int getJednotkovaSuma() {
		return jednotkovaSuma;
	}

	public void setJednotkovaSuma(int jednotkovaSuma) {
		this.jednotkovaSuma = jednotkovaSuma;
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