package sk.upjs.swi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicitaUserovException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicitaUserovException() {

		super("V DB sa uz tento pouzivatel nachadza!");

	}

//	public ProduktyNotFoundException(Long id) {
//
//		super("Produktu " + id + " sa v DB nenasiel!");
//
//	}

}
