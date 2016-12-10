package sk.upjs.swi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduktyNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProduktyNotFoundException() {

		super("V DB sa nenachadzaju ziadne produkty!");

	}

	public ProduktyNotFoundException(Long id) {

		super("Produktu " + id + " sa v DB nenasiel!");

	}

}
