package pkg;

public class User {
	
	private String nev;
	private String email;
	private String passwd;
	
	public User(String nev, String email, String passwd) {
		super();
		this.nev = nev;
		this.email = email;
		this.passwd = passwd;
	}
	
	public String getHello() {
		return "Hello";
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		if(nev.equals("pista")) {
			this.nev = null;
		}else
		this.nev = nev;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	
	
	

}
