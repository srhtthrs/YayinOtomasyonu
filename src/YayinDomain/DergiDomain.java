package YayinDomain;

public class DergiDomain {
	
	private int id;
	private String dergi;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDergi() {
		return dergi;
	}
	public void setDergi(String dergi) {
		this.dergi = dergi;
	}
	
	
	@Override
	public String toString() {

		return dergi +"("+"Kod: "+id+")";
	}

}
