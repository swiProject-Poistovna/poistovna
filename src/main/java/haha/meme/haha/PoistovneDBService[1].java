package haha.meme.haha;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.*;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.mysql.cj.jdbc.MysqlDataSource;

/*
 * anotácia @Component zaručí automatickú registráciu triedy "ReceptyDBService" 
 * v aplikačnom kontexte Springu. 
 * Triedy, ktoré budú potrebovať prístup k databáze, sa na ňu 
 * budú môcť odkazovať pomocou špeciálnej anotácie (@Autowired)
 */
@Component
public class PoistovneDBService {

	private List<Poistovna> zoznamPoistovniList;
	private List<PoistovnaDataOut> zoznamDatPreOdoslanieKlientoviList;
	private List<Produkt> zoznamProduktovList;
	private List<TypProduktu> zoznamTypovProduktov;
	// private EntityManagerFactory emf;
	// private EntityManager em;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ProduktRepository produktRepository;

	private final static int referencnaCielovaSumaPoistenia = 10000;
	private final static int POCET_DNI_V_MESIACI = 12;


	public PoistovneDBService() throws NamingException, SQLException {

		super();

		// if (zoznamPoistovniList == null) {
		// zoznamPoistovniList = new ArrayList<>();
		// }
		// zoznamPoistovniList.add(new Poistovna(1, "AXA"));
		// zoznamPoistovniList.add(new Poistovna(2, "Wustenrot"));
		////
		//// // Koeficienty - naplnim aspon 2 riadky tabulky hospitalizacie pre
		// AXU
		// List<Koeficienty> zoznamKoeficientov = new ArrayList<>();
		// zoznamKoeficientov.add(new Koeficienty(new Long(1), 15,
		// 1.70, 1.70, 1.70, 1.70, 1.72, 1.75, 1.79, 1.82, 1.85, 1.89,
		// 1.42, 1.44, 1.47, 1.49, 1.52, 1.54, 1.58, 1.61, 1.65, 1.69,
		// 1.28, 1.31, 1.36, 1.41, 1.46, 1.53, 1.60, 1.67, 1.75, 1.84,
		// 1.11, 1.17, 1.23, 1.30, 1.38, 1.46, 1.54, 1.63, 1.73, 1.83,
		// 1.20, 1.27, 1.34, 1.41, 1.49, 1.56, 1.65, 1.73, 1.82, 1.91,
		// 2.76, 2.76, 2.76, 2.76, 2.76, 2.76, 2.76, 2.76, 2.76, 2.76,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1));
		//
		// zoznamKoeficientov.add(new Koeficienty(new Long(1), 16,
		// 1.70, 1.70, 1.70, 1.72, 1.75, 1.80, 1.84, 1.87, 1.90, 1.94,
		// 1.46, 1.48, 1.50, 1.54, 1.57, 1.60, 1.64, 1.68, 1.72, 1.77,
		// 1.34, 1.38, 1.44, 1.50, 1.56, 1.63, 1.70, 1.79, 1.88, 1.98,
		// 1.19, 1.26, 1.34, 1.41, 1.49, 1.59, 1.68, 1.77, 1.88, 1.98,
		// 1.30, 1.37, 1.45, 1.53, 1.61, 1.69, 1.78, 1.87, 1.96, 2.06,
		// 2.76, 2.76, 2.76, 2.76, 2.76, 2.76, 2.76, 2.76, 2.76, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1));
		//
		// List<Koeficienty> zoznamKoeficientovWustenrot = new ArrayList<>();
		// zoznamKoeficientovWustenrot.add(new Koeficienty(new Long(2), 15,
		// 2.45, 2.49, 2.53, 2.58, 2.63, 2.68, 2.73, 2.79, 2.85, 2.92,
		// 2.99, 3.06, 3.14, 3.21, 3.29, 3.36, 3.43, 3.50, 3.57, 3.63,
		// 3.70, 3.77, 3.84, 3.91, 3.98, 4.06, 4.14, 4.23, 4.33, 4.43,
		// 4.54, 4.66, 4.79, 4.92, 5.07, 5.22, 5.38, 5.54, 5.72, 5.90,
		// 6.09, 6.28, 6.49, 6.70, 6.93, 7.16, 7.39, 7.64, 7.90, 8.16,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1));
		//
		//
		// this.zoznamProduktovList = new ArrayList<>();
		// this.zoznamProduktovList.add(new Produkt(1, 1, "Hospitalizacia_AXA",
		// 1, 1, 30, 15, 60, zoznamKoeficientov));
		// this.zoznamProduktovList.add(new Produkt(1, 2,
		// "Hospitalizacia_Wustenrot", 1, 1, 60, 0, 64,
		// zoznamKoeficientovWustenrot));
		//
		// for (Poistovna poistovna : zoznamPoistovniList) {
		// poistovna.getZoznamTypovProduktov().add(new TypProduktu(1,
		// "Hospitalizacia", zoznamProduktovList, zoznamPoistovniList));
		// }
		//
		// //odtial zacneme - z TypProduktu
		// List<Poistovna> poistovnaList = new ArrayList<>();
		// zoznamPoistovniList.add(new Poistovna(1, "AXA"));
		// zoznamPoistovniList.add(new Poistovna(2, "Wustenrot"));
		//
		// TypProduktu typProduktu1 = new TypProduktu(1, "Hospitalizacia",
		// zoznamProduktovList, zoznamPoistovniList);
		// TypProduktu typProduktu2 = new TypProduktu(2, "Smrt", new
		// ArrayList<>(), new ArrayList<>());

		// Context context = new InitialContext();
		// DataSource dataSource = (DataSource)
		// context.lookup("java:comp/env/jdbc/myDB");

		/*
		 * MysqlDataSource dataSource = new MysqlDataSource();
		 * dataSource.setUser("scott"); dataSource.setPassword("tiger");
		 * dataSource.setServerName("myDBHost.example.org");
		 * 
		 * Connection conn = dataSource.getConnection(); Statement stmt =
		 * conn.createStatement(); ResultSet rs =
		 * stmt.executeQuery("SELECT ID FROM USERS");
		 * 
		 * 
		 * rs.close(); stmt.close(); conn.close();
		 * 
		 */
		// Open a database connection
		// (create a new database if it doesn't exist yet):
		// emf =
		// Persistence.createEntityManagerFactory("$objectdb/db/points.odb");

		// TODO: tieto 2 riadky potom odkomentovat
		/*
		 * emf = Persistence.createEntityManagerFactory(
		 * "$objectdb/db/poistovnaREST.odb"); em = emf.createEntityManager();
		 * 
		 */
		// Find the number of Point objects in the database:
		// Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
		// System.out.println("Total Points: " + q1.getSingleResult());

		// Find the average X value:
		// Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
		// System.out.println("Average X: " + q2.getSingleResult());

		// Close the database connection:
		// em.close();
		// emf.close();

		// SingleConnectionDataSource dataSource = new
		// SingleConnectionDataSource();
		// dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		// dataSource.setUrl("jdbc:mysql://sql7.freesqldatabase.com/sql7141780");
		// dataSource.setUsername("sql7141780");
		// dataSource.setPassword("FlVTuBE81x");
		//
		// jdbcTemplate = new JdbcTemplate(dataSource);
		// jdbcTemplate = new JdbcTemplate(new d);

		// SqlRowSet rowSet = jt.queryForRowSet("SELECT * from TypProduktu");

		// while(rowSet.next()){
		// String col1 = rowSet.getString("col1");
		// String col2 = rowSet.getString("col2");
		// }

	}

	/**
	 * Nájde v databáze recept s daným identifikátorom. Ak sa taký recept
	 * nenájde, vráti <code>null</code>.
	 */
	// TODO: prerobit na DB
	public Poistovna findFromDBById(Long id) {

		// Find the number of Point objects in the database:
		// Query query = em.createQuery("SELECT p FROM projekt.Poistovna p WHERE
		// p.id = :idPoistovna ");
		// query.setParameter("idPoistovna", id);
		//// int rowCount = query.executeUpdate();
		// System.out.println("Najdeny zaznam: " + query.getSingleResult() );
		//// System.out.println("Najdeny zaznam: " + String.format("(%s)",
		// query.getSingleResult()) );
		//
		//
		// if (query.getSingleResult() != null) {
		// return (Poistovna) query.getSingleResult();
		// }
		//
		//// for (Recept recept : this.receptyList) {
		//// if(recept.getId().equals(id)) {
		//// return recept;
		//// }
		//// }
		return null;
	}

	/**
	 * Vráti zoznam všetkých poistovní v databáze. Zoznam je nemeniteľný.
	 */
	public List<Poistovna> dajVsetkyPoistovne() {
		// Retrieve all the Poistovna objects from the database:

		// Object[] parameters = new Object[] { new Long(0) };
		// SqlRowSet srs = jdbcTemplate.queryForRowSet("select id AS kuku, nazov
		// AS huhu from TypProduktu where id > ?", parameters);

		String sql = "SELECT * FROM Poistovna";
		List<Poistovna> poistovneList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Poistovna>(Poistovna.class));

		this.zoznamPoistovniList = poistovneList;

		return Collections.unmodifiableList(this.zoznamPoistovniList);
	}

	public TypProduktu dajTypProduktu(int idTypuProduktu) {
		
		String sql = "SELECT * FROM TypProduktu WHERE id = ?";
		TypProduktu typProduktu = jdbcTemplate.queryForObject(sql,
				new Object[]{new Integer(idTypuProduktu)},
				new BeanPropertyRowMapper<TypProduktu>(TypProduktu.class));
		
		return typProduktu;
	}
	
	public List<TypProduktu> dajVsetkyTypyProduktov() {

		String sql = "SELECT * FROM TypProduktu";
		List<TypProduktu> typyProduktovList = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<TypProduktu>(TypProduktu.class));

		this.zoznamTypovProduktov = typyProduktovList;

		return Collections.unmodifiableList(this.zoznamTypovProduktov);
	}

	public List<Produkt> dajVsetkyProduktyHAHA() {
		// Retrieve all the Poistovna objects from the database:

		// Object[] parameters = new Object[] { new Long(0) };
		// SqlRowSet srs = jdbcTemplate.queryForRowSet("select id AS kuku, nazov
		// AS huhu from TypProduktu where id > ?", parameters);

		Iterable<Produkt> produktyList = produktRepository.findAll();
		for (Produkt produkt : produktyList) {
			this.zoznamProduktovList.add(produkt);
		}
		// this.zoznamPoistovniList = poistovneList;

		return Collections.unmodifiableList(this.zoznamProduktovList);
	}

	/**
	 * Uloží alebo aktualizuje objekt receptu. Ak má recept identifikátor rovný
	 * <code>null</code>, znamená to inštanciu, ktorá v databáze ešte nie je. V
	 * opačnom prípade sa existujúca inštancia s takým ID nahradí novou
	 * inštanciou s aktualizovanými dátami.
	 * 
	 * @param recept
	 */
	public void save(Poistovna poistovna) {
		// ulozi objekt poistovna do databazy:
		// em.getTransaction().begin();
		// em.persist(poistovna);
		// em.getTransaction().commit();

		// em.close();
		// emf.close();

		// if(recept.getId() == null) {
		// recept.setId(new Date().getTime());
		// receptyList.add(recept);
		// return;
		// }
		// Recept dbRecept = findById(recept.getId());
		// receptyList.remove(dbRecept);
		// receptyList.add(recept);
	}

	// TODO: dorobit aktualizaciu(UPDATE)
	public void update(Long id, Poistovna poistovna) {
		Poistovna p = findFromDBById(id);
		// em.getTransaction().begin();
		// p.setNazov(poistovna.getNazov());
		//// p.setZoznamTypovProduktov(poistovna.getZoznamTypovProduktov());
		// em.getTransaction().commit();

		// em.close();
		// emf.close();

	}

	/**
	 * Odstráni z databázy recept s daným identifikátorom. Inštancia v parametri
	 * nemusí mať vyplnené všetky údaje, stačí, keď má vyplnený identifikátor.
	 */
	// TODO: prerobit na DB
	public void removeRecept(Long id) {
		// najprv musime objekt v DB vyhladat()
		// TODO: pouzit vyhladavaciu metodu
		Poistovna poistovna = findFromDBById(id);
		// em.getTransaction().begin();
		// em.remove(poistovna);
		// em.getTransaction().commit();

		// em.close();
		// emf.close();

		// Recept dbRecept = findFromDBById(recept.getId());
		// if(dbRecept != null) {
		// receptyList.remove(dbRecept);
		// }
	}

	/**
	 * Vráti zoznam receptov v databáze podľa vyhľadávaného reťazca. Zoznam je
	 * nemeniteľný.
	 */
	// public List<Poistovna> dajReceptyPodlaRetazca(String vyhladavanyRetazec)
	// {
	// // Retrieve all the Point objects from the database:
	//
	// List<Poistovna> celkovaMnozinaReceptov = new CopyOnWriteArrayList<>();
	// List<Poistovna> resultsList = new CopyOnWriteArrayList<>();
	//
	// String retazec = vyhladavanyRetazec;
	// if (StringUtils.hasText(retazec)) {
	// String[] klucoveSlovaPole = retazec.split(";");
	// if (klucoveSlovaPole != null) {
	// for (String klucoveSlovo : klucoveSlovaPole) {
	//
	// String select =
	// "SELECT DISTINCT r FROM Recept r LEFT OUTER JOIN r.zoznamIngrediencii i "
	// + "WHERE (r.nazov).toUpperCase() LIKE (:retazec) "
	// + "OR (r.autor).toUpperCase() LIKE (:retazec)"
	// + "OR (r.postupPripravy).toUpperCase() LIKE (:retazec)"
	// + "OR (i.nazov).toUpperCase() LIKE (:retazec)";
	//
	// TypedQuery<Recept> query =
	// em.createQuery(select, Recept.class);
	//
	// query.setParameter("retazec", "%" + klucoveSlovo.toUpperCase() + "%");
	//
	// resultsList.addAll(query.getResultList());
	//
	// }
	// }
	//
	// // odstranime duplicity a zaroven zachovame poradie, preto LinkedHashSet
	// celkovaMnozinaReceptov = new CopyOnWriteArrayList<>(new
	// LinkedHashSet<Recept>(resultsList));
	//
	// }
	//
	//
	//
	// this.receptyList = celkovaMnozinaReceptov;
	//// for (Recept r : results) {
	//// System.out.println(r);
	//// }
	//
	// // Close the database connection:
	//// em.close();
	//// emf.close();
	//
	//
	// return Collections.unmodifiableList(this.receptyList);
	// }

	/**
	 * Vráti zoznam receptov v databáze podľa vyhľadávaného reťazca. Zoznam je
	 * nemeniteľný.
	 */
	// public List<Recept> dajReceptyPodlaIngrediencii(String
	// vyhladavanyRetazecIngrediencii) {
	// // Retrieve all the Point objects from the database:
	//
	// List<Recept> celkovaMnozinaReceptov = new CopyOnWriteArrayList<>();
	// List<Recept> resultsList = new CopyOnWriteArrayList<>();
	//
	// String retazec = vyhladavanyRetazecIngrediencii;
	// if (StringUtils.hasText(retazec)) {
	// String[] klucoveSlovaPole = retazec.split(";");
	// if (klucoveSlovaPole != null) {
	// for (String klucoveSlovo : klucoveSlovaPole) {
	//
	// String select =
	// "SELECT DISTINCT r FROM Recept r LEFT OUTER JOIN r.zoznamIngrediencii i "
	// + "WHERE (i.nazov).toUpperCase() LIKE (:retazec)";
	//
	// TypedQuery<Recept> query =
	// em.createQuery(select, Recept.class);
	//
	// query.setParameter("retazec", "%" + klucoveSlovo.toUpperCase() + "%");
	//
	//
	// resultsList.addAll(query.getResultList());
	//
	// }
	// }
	//
	//
	//
	//
	//
	// // odstranime duplicity a zaroven zachovame poradie, preto LinkedHashSet
	// celkovaMnozinaReceptov = new CopyOnWriteArrayList<>(new
	// LinkedHashSet<Recept>(resultsList));
	//
	// // algoritmus na vyhladavanie receptov so zadanymi ingredienciami
	// String[] zoznamIngredienciiPole = retazec.split(";");
	// List<Recept> vyhovujuceRecepty =
	// vratReceptyObsahujuceVsetkyZadaneIngrediecie(celkovaMnozinaReceptov,
	// zoznamIngredienciiPole);
	//
	// this.receptyList = vyhovujuceRecepty;
	// }
	//
	//
	//
	//// for (Recept r : results) {
	//// System.out.println(r);
	//// }
	//
	// // Close the database connection:
	//// em.close();
	//// emf.close();
	//
	//
	// return Collections.unmodifiableList(this.receptyList);
	// }

	/**
	 * 
	 * @param receptyList
	 * @param zoznamZadanychIngredienciiPole
	 * @return vrati zoznam receptov(<code>List</code>), ak pole ma aspon 1
	 *         prvok, inak <code>null</code>
	 */
	// private List<Recept>
	// vratReceptyObsahujuceVsetkyZadaneIngrediecie(List<Recept> receptyList,
	// String[] zoznamZadanychIngredienciiPole) {
	//
	// List<Recept> vyhovujuceReceptyList = new CopyOnWriteArrayList<Recept>();
	//
	// if (receptyList != null && receptyList.size() > 0 &&
	// zoznamZadanychIngredienciiPole != null &&
	// zoznamZadanychIngredienciiPole.length > 0) {
	//
	// for (Recept recept : receptyList) {
	//
	// List<Ingrediencia> zoznamIngredienciiReceptuList =
	// recept.getZoznamIngrediencii();
	//
	// int pocetZhodnychIngrediencii = 0;
	// for (Ingrediencia ingredienciaZReceptu : zoznamIngredienciiReceptuList) {
	//
	// for (String ingredienciaZoZadanehoPola : zoznamZadanychIngredienciiPole)
	// {
	//
	// if ( ingredienciaZoZadanehoPola.equals(ingredienciaZReceptu.getNazov()) )
	// {
	// //nasiel som ingredienciu z receptu v zadanom zozname, mozem ist na
	// dalsiu ingredienciu z receptu
	// pocetZhodnychIngrediencii++;
	// break;
	// }
	//
	// }
	//
	// }
	//
	// /*
	// * ak sa pocet najdenych zhodnych ingrediencii rovna s poctom ingrediencii
	// v recepte,
	// * viem, ze mam postacujuce ingrediencie na uvarenie receptu
	// */
	// if (pocetZhodnychIngrediencii == zoznamIngredienciiReceptuList.size()) {
	// vyhovujuceReceptyList.add(recept);
	// }
	//
	//
	// }
	//
	//
	// }
	//
	// return vyhovujuceReceptyList.size() > 0 ? vyhovujuceReceptyList : null;
	// }

	/**
	 * Vrati zoznam poistovni v databaze podla podmienok zadanych uzivatelom.
	 * Zoznam je nemeniteľný(konkurentne programovanie).
	 */
	public List<PoistovnaDataOut> dajVyhovujucePoistovne(PoistenecDataIn dataPoistenca) {

		String sql = "SELECT * FROM Produkt p WHERE p.rizikovaSkupina = ? AND p.idTypProduktu = ? "
				+ "AND p.dobaPoisteniaOd <= ? AND p.dobaPoisteniaDo >= ? " + "AND p.minVek <= ? AND p.maxVek >= ?";

		Object[] parametrePole = new Object[] { new Integer(dataPoistenca.getRizikovaSkupina()),
				new Integer(dataPoistenca.getTypProduktu().getId()), new Integer(dataPoistenca.getDobaPoistenia()),
				new Integer(dataPoistenca.getDobaPoistenia()), new Integer(dataPoistenca.getVek()),
				new Integer(dataPoistenca.getVek()) };

		List<Produkt> produktyList = jdbcTemplate.query(sql, parametrePole,
				new BeanPropertyRowMapper<Produkt>(Produkt.class));

		if (produktyList == null || produktyList.size() == 0) {
			return null;
		}

		double hladanyKoeficient = -1;
		Map<Produkt, Double> produktyAKoeficientyMap = new HashMap<Produkt, Double>();

		for (Produkt produkt : produktyList) {

			String sqlKoeficienty = "SELECT * FROM Koeficienty WHERE idProdukt = ? AND vek = ?";
			List<Koeficienty> koeficientyList = jdbcTemplate.query(sqlKoeficienty,
					new Object[] { new Long(produkt.getId()), new Integer(dataPoistenca.getVek()) },
					new BeanPropertyRowMapper<Koeficienty>(Koeficienty.class));

			if (koeficientyList == null || koeficientyList.size() == 0) {
				return null;
			}

			for (Koeficienty koeficienty : koeficientyList) {
				hladanyKoeficient = koeficienty.dajSpravnyKoeficient(dataPoistenca.getDobaPoistenia());
				// hladanyKoeficient = koeficienty.dajSpravnyKoeficient(30);
				break;
			}

			if (hladanyKoeficient != -1) {
				// potrebujem si niekde odkladat produkty a koeficienty
				produktyAKoeficientyMap.put(produkt, hladanyKoeficient);
			}

		}

		// ak je mapa null alebo prazdna, znamena to, ze sme nenasli ziadny
		// produkt s vyhovujucim koeficientom
		if (produktyAKoeficientyMap == null || produktyAKoeficientyMap.size() == 0) {
			return null;
		}

		// este vyratame jednotlive koeficienty
		this.zoznamDatPreOdoslanieKlientoviList = vypocitajAVratVyslednuMnozinu(produktyAKoeficientyMap, dataPoistenca);

		return Collections.unmodifiableList(this.zoznamDatPreOdoslanieKlientoviList);

	}

	private List<PoistovnaDataOut> vypocitajAVratVyslednuMnozinu(
			Map<Produkt, Double> mapaVyhovujucichProduktovAKoeficientov, PoistenecDataIn dataPoistenca) {

		Comparator<PoistovnaDataOut> dataOutComparator = new Comparator<PoistovnaDataOut>() {

			@Override
			public int compare(PoistovnaDataOut p1, PoistovnaDataOut p2) {
				return Double.compare(p1.getVyslednaMesacnaPlatba(), p2.getVyslednaMesacnaPlatba());
			}
		};

		List<PoistovnaDataOut> vyslednyZoznamList = new ArrayList<PoistovnaDataOut>();
		TypProduktu typProduktu = null;
		int jednotkovaSuma = 1000;
		for (Produkt produkt : mapaVyhovujucichProduktovAKoeficientov.keySet()) {

			// staci nam typ produktu nacitat iba raz
			if (typProduktu == null) {
				typProduktu = this.dajTypProduktu(produkt.getIdTypProduktu());
				if (typProduktu != null) {
					jednotkovaSuma = typProduktu.getJednotkovaSuma();
				}
			}
			
			int zelanaCielovaSumaPoistenia = dataPoistenca.getCielovaSumaPoistenia();
			// pomer, ktorym vynasobime koeficient, aby sme dostali vysku
			// mesacnej platby - ta bude rozhodujuca pri volbe poistovne
//			double pomer = zelanaCielovaSumaPoistenia / referencnaCielovaSumaPoistenia;
			double pomer = zelanaCielovaSumaPoistenia / jednotkovaSuma;

			double koeficient = mapaVyhovujucichProduktovAKoeficientov.get(produkt);
//			DecimalFormat df = new DecimalFormat("#.00");
			double vyslednaRocnaPlatba = koeficient * pomer;
			double vyslednaMesacnaPlatba = round(vyslednaRocnaPlatba / POCET_DNI_V_MESIACI, 2);

			PoistovnaDataOut dataOut = null;

			if (this.zoznamPoistovniList == null || this.zoznamPoistovniList.size() == 0) {
				this.zoznamPoistovniList = this.dajVsetkyPoistovne();
			}

			if (this.zoznamPoistovniList != null) {
				for (Poistovna poistovna : this.zoznamPoistovniList) {
					if (poistovna.getId() == produkt.getIdPoistovna()) {
						dataOut = new PoistovnaDataOut(poistovna.getNazov(), vyslednaMesacnaPlatba);
						break;
					}
				}
			}

			vyslednyZoznamList.add(dataOut);
		}

		Collections.sort(vyslednyZoznamList, dataOutComparator);

		return vyslednyZoznamList;

	}

	private int dajJednotkovuSumu() {
		
		
		
		return 0;
	}

	public List<Produkt> getZoznamProduktovList() {
		return zoznamProduktovList;
	}

	public void setZoznamProduktovList(List<Produkt> zoznamProduktovList) {
		this.zoznamProduktovList = zoznamProduktovList;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

}