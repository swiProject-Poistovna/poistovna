package sk.upjs.swi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//Kontrolér je trieda, ktorej metódy budú obsluhovať URL adresy pre RESTovské požiadavky.

@RestController
public class PoistovnaResourceController {

	/*
	 * anotácia @Autowired naznačí Springu, že do nej má vložiť inštanciu beanu
	 * pre databázu, ktorá sa nachádza v aplikačnom kontexte. (Taká inštancia
	 * existuje, keďže trieda Database bola anotovaná ako komponent).
	 */
	@Autowired
	// @Qualifier("PoistovneDBService")
	private PoistovneDBService poistovneDBService;

	@Autowired
	// @Qualifier("ProduktRepository")
	private ProduktRepository produktRepository;

	@Autowired
	private PoistovnaRepository poistovnaRepository;

	@Autowired
	private UsersRepository usersRepository;

	// netreba zabudat na konkurentne programovanie, lebo klasicky ArrayList by
	// nam to rozbil
	private List<Poistovna> poistovneList = new CopyOnWriteArrayList<Poistovna>();
	private List<PoistovnaDataOut> poistovnaDataOutList = new CopyOnWriteArrayList<PoistovnaDataOut>();
	private List<TypProduktu> typyProduktovList = new CopyOnWriteArrayList<TypProduktu>();
	private List<Produkt> zoznamProduktovList = new CopyOnWriteArrayList<Produkt>();

	public PoistovnaResourceController() {

		// produktRepository.s

		// poistovneList.add(new Poistovna(1, "AXA", new ArrayList<>()));
		// poistovneList.add(new Poistovna(2, "Wustenrot", new ArrayList<>()));

		// poistovneList.add(new Poistovna(1, "AXA"));
		// poistovneList.add(new Poistovna(2, "Wustenrot"));
		//
		//
		// // Koeficienty - naplnim aspon 2 riadky tabulky hospitalizacie pre
		// AXU
		// List<Koeficienty> zoznamKoeficientovAXA = new ArrayList<>();
		// zoznamKoeficientovAXA.add(new Koeficienty(new Long(1), 15,
		// 1.70, 1.70, 1.70, 1.70, 1.72, 1.75, 1.79, 1.82, 1.85, 1.89,
		// 1.42, 1.44, 1.47, 1.49, 1.52, 1.54, 1.58, 1.61, 1.65, 1.69,
		// 1.28, 1.31, 1.36, 1.41, 1.46, 1.53, 1.60, 1.67, 1.75, 1.84,
		// 1.11, 1.17, 1.23, 1.30, 1.38, 1.46, 1.54, 1.63, 1.73, 1.83,
		// 1.20, 1.27, 1.34, 1.41, 1.49, 1.56, 1.65, 1.73, 1.82, 1.91,
		// 2.76, 2.76, 2.76, 2.76, 2.76, 2.76, 2.76, 2.76, 2.76, 2.76,
		// -1, -1, -1, -1, -1, -1, -1, -1, -1, -1));
		//
		// zoznamKoeficientovAXA.add(new Koeficienty(new Long(1), 16,
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
		//
		// zoznamProduktovList = new ArrayList<>();
		// zoznamProduktovList.add(new Produkt(1, 1, "Hospitalizacia_AXA", 1, 1,
		// 30, 20, 60, zoznamKoeficientovAXA));
		// zoznamProduktovList.add(new Produkt(1, 2, "Hospitalizacia_Wustenrot",
		// 1, 1, 60, 0, 64, zoznamKoeficientovWustenrot));

		// //odtial zacneme - z TypProduktu
		// TypProduktu typProduktu1 = new TypProduktu(1, "Hospitalizacia",
		// zoznamProduktovList, poistovneList);
		// TypProduktu typProduktu2 = new TypProduktu(2, "Smrt", new
		// ArrayList<>(), new ArrayList<>());
		//
		// this.typyProduktovList.add(typProduktu1);
		// this.typyProduktovList.add(typProduktu2);

		// poistovneDBService.setZoznamProduktovList(zoznamProduktovList);

	}

	@RequestMapping("/HAHA")
	@ResponseBody
	public String test() {
		Poistovna poistovna = new Poistovna();
		// poistovna.setId(10);
		poistovna.setNazov("PeknaPoistovna");
		poistovnaRepository.save(poistovna);
		return "hello";
	}

	@RequestMapping("/poistovne")
	public List<Poistovna> dajVsetkyPoistovne() {
		this.poistovneList = poistovneDBService.dajVsetkyPoistovne();

		if (this.poistovneList == null || this.poistovneList.size() == 0) {
			throw new PoistovneNotFoundException();
		}

		return this.poistovneList;
	}

	@RequestMapping("/poistovneHAHA")
	public List<Poistovna> dajVsetkyPoistovneHAHA() {

		Iterable<Poistovna> poistovnaList = poistovnaRepository.findAll();
		for (Poistovna poistovna : poistovnaList) {
			this.poistovneList.add(poistovna);
		}

		if (this.poistovneList == null || this.poistovneList.size() == 0) {
			throw new PoistovneNotFoundException();
		}

		return this.poistovneList;
	}

	@RequestMapping("/koeficienty")
	public List<Koeficienty> dajVsetkyKoeficienty() {
		return poistovneDBService.dajVsetkyKoeficienty();
	}
	
	@RequestMapping("/typyProduktov")
	public List<TypProduktu> dajVsetkyTypyProduktov() {
		this.typyProduktovList = poistovneDBService.dajVsetkyTypyProduktov();
		if (this.typyProduktovList == null || this.typyProduktovList.size() == 0) {
			throw new TypyProduktovNotFoundException();
		}

		return this.typyProduktovList;
	}

	@RequestMapping("/produkty")
	public List<Produkt> dajVsetkyProdukty() {
		// this.poistovneList = poistovneDBService.dajVsetkyRecepty();

		Iterable<Produkt> produktyList = produktRepository.findAll();
		for (Produkt produkt : produktyList) {
			this.zoznamProduktovList.add(produkt);
		}

		if (this.zoznamProduktovList == null || this.zoznamProduktovList.size() == 0) {
			throw new ProduktyNotFoundException();
		}

		return this.zoznamProduktovList;
	}

	@RequestMapping("/produktyHAHA")
	public List<Produkt> dajVsetkyProduktyHAHA() {
		this.zoznamProduktovList = poistovneDBService.dajVsetkyProduktyHAHA();
		if (this.zoznamProduktovList == null || this.zoznamProduktovList.size() == 0) {
			throw new ProduktyNotFoundException();
		}

		return this.zoznamProduktovList;
	}

	@RequestMapping(value = "/pridajProdukt", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void pridajProdukt(@RequestBody Produkt produkt) {
		
		System.out.println(produkt);
		
		Produkt produktUlozeny = null;
		try {
			produktUlozeny = produktRepository.save(produkt);
		} catch (Exception e) {
			if (produktUlozeny == null) {
				throw new DuplicitaProduktuException();
			}
		}
		
	}
	
	@RequestMapping(value = "/vyhovujucePoistovne", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public List<PoistovnaDataOut> dajVyhovujucePoistovne(@RequestBody InputData inputData) {
		
		List<PoistenecDataIn> poistenecDataList = new ArrayList<PoistenecDataIn>();
		
		for (InputRowData ird: inputData.getTypyProduktov()) {
			
			if (ird.getCielovaSuma() <= 0) {
				continue;
			}
			
			PoistenecDataIn poistenecDataIn = new PoistenecDataIn();
			poistenecDataIn.setVek(inputData.getVek());
			poistenecDataIn.setRizikovaSkupina(inputData.getRizikovaSkupina());
			poistenecDataIn.setDobaPoistenia(inputData.getDobaPoistenia());
			poistenecDataIn.setCielovaSumaPoistenia(ird.getCielovaSuma());
			poistenecDataIn.setJednotkovaSuma(ird.getJednotkovaSuma());
			poistenecDataIn.setIdTypProduktu(ird.getId());
			
			// ???
			poistenecDataIn.setTypProduktu(null);
			
			poistenecDataList.add(poistenecDataIn);
		}
		
		
		// this.poistovnaDataOutList =
		// poistovneDBService.dajVyhovujucePoistovneMimoDB(poistenecData);
		List<PoistovnaDataOut> vyslednyListPoistovni = new ArrayList<PoistovnaDataOut>();
		vyslednyListPoistovni = poistovneDBService.dajVyhovujucePoistovne(poistenecDataList);
		if (vyslednyListPoistovni == null || vyslednyListPoistovni.size() == 0) {
			throw new PoistovneNotFoundException();
		}

		Comparator<PoistovnaDataOut> dataOutComparator = new Comparator<PoistovnaDataOut>() {

			@Override
			public int compare(PoistovnaDataOut p1, PoistovnaDataOut p2) {
				return Double.compare(p1.getVyslednaMesacnaPlatba(), p2.getVyslednaMesacnaPlatba());
			}
		};

		Collections.sort(vyslednyListPoistovni, dataOutComparator);
		
		this.poistovnaDataOutList = Collections.unmodifiableList(vyslednyListPoistovni);
		
		return this.poistovnaDataOutList;
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void overLoginAHeslo(@RequestBody Users inputData) {
		
		boolean loginAHesloOK = poistovneDBService.overLoginAHeslo(inputData);
		if (!loginAHesloOK) {
			throw new LoginFailedException();
		}
		
	}

	@RequestMapping(value = "/pridajUsera", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void pridajProdukt(@RequestBody Users user) {
		
		System.out.println(user);
		
		Users userUlozeny = null;
		try {
			userUlozeny = usersRepository.save(user);
		} catch (Exception e) {
			if (userUlozeny == null) {
				throw new DuplicitaUserovException();
			}
		}
		
	}

	
	@RequestMapping("/usersHAHA")
	public List<Users> dajVsetkychUsersHAHA() {

		List<Users> usersList = new ArrayList<>();
		
		Iterable<Users> usersIterable = usersRepository.findAll();
		for (Users user : usersIterable) {
			usersList.add(user);
		}
		
		return usersList;
	}
	
	
}
