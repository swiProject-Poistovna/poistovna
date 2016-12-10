package sk.upjs.swi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PoistovneNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PoistovneNotFoundException() {

		super("V DB sa nenachadza ziadna vyhovujuca poistovna!");

	}

	public PoistovneNotFoundException(Long id) {

		super("Poistovna " + id + " sa v DB nenasla!");

	}

}
