package sk.upjs.swi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique=true, nullable=false)	
	private String login;
	private String heslo;
	
	public Users() {
		super();
	}

	public Users(long id) {
		super();
		this.id = id;
	}

	public Users(String login, String heslo) {
		super();
		this.login = login;
		this.heslo = heslo;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getHeslo() {
		return heslo;
	}
	
	public void setHeslo(String heslo) {
		this.heslo = heslo;
	}
	
	

}
