package haha.meme.haha;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.hibernate.jpa.internal.EntityManagerFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import haha.meme.haha.PoistovnaRepository;

//@Controller
public class PoistovnaController {

	@Autowired
	private PoistovnaRepository poistovnaRepository;

	// @PersistenceUnit(unitName = "hibernate.globally_quoted_identifiers")
	private EntityManagerFactory emf;
	// private EntityManager em;

	// @RequestMapping("/")
	// @ResponseBody
	// public String test() {
	// Poistovna poistovna = new Poistovna();
	// poistovna.setNazov("AXA");
	// poistovnaRepository.save(poistovna);
	// return "hello";
	// }

	@RequestMapping("/")
	@ResponseBody
	public String test() {
		// System.out.println(poistovnaRepository.findAll());

		// emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		// em = new
		// em = emf.createEntityManager();
		// TypedQuery<Poistovna> query =
		// em.createQuery("SELECT p FROM Poistovne p", Poistovna.class);
		//
		// List<Poistovna> results = query.getResultList();
		// System.out.println(results);
		// System.out.println(poistovnaRepository.findAll());
		// TypProduktu typProduktu = poistovnaRepository.findOne(1L);
		// System.out.println(typProduktu);

		SingleConnectionDataSource ds = new SingleConnectionDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://sql7.freesqldatabase.com/sql7141780");
		ds.setUsername("sql7141780");
		ds.setPassword("FlVTuBE81x");

		JdbcTemplate jt = new JdbcTemplate(ds);

		// SqlRowSet rowSet = jt.queryForRowSet("SELECT * from TypProduktu");

		// while(rowSet.next()){
		// String col1 = rowSet.getString("col1");
		// String col2 = rowSet.getString("col2");
		// }

		Object[] parameters = new Object[] { new Long(0) };
		SqlRowSet srs = jt.queryForRowSet("select id AS kuku, nazov AS huhu from TypProduktu where id > ?", parameters);
		TypProduktu typProduktu = jt.queryForObject(
				"SELECT * FROM TypProduktu tp LEFT OUTER JOIN Produkt p ON p.idTypProduktu = tp.id WHERE tp.id = ?",
				new Object[] { 2 }, new BeanPropertyRowMapper<TypProduktu>(TypProduktu.class));
		int rowCount = 0;
		while (srs.next()) {
			// System.out.println(srs.getLong("kuku") + " - " +
			// srs.getString("huhu"));
			rowCount++;
		}
		System.out.println(rowCount);

		return "hello";
	}
}