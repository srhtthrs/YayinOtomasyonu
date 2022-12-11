package YayinDomain;

public class BolgeDomain {
	
	
	
	private int id;
	private String bolge;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBolge() {
		return bolge;
	}
	public void setBolge(String bolge) {
		this.bolge = bolge;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return bolge +"("+"Kod: "+id+")";
		
	}

}
