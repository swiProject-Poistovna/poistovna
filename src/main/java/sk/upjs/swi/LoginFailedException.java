package sk.upjs.swi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoginFailedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 13856944630676170L;

	public LoginFailedException() {
		super("V DB sa nenachádza používateľ s daným loginom a heslom!");
	}
}
