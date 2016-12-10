package sk.upjs.swi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TypyProduktovNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TypyProduktovNotFoundException() {

		super("V DB sa nenachadzaju ziadne typy produktov!");

	}

	public TypyProduktovNotFoundException(Long id) {

		super("Typ produktu " + id + " sa v DB nenasiel!");

	}

}
