package YayinDomain;

public class GazeteDomain {

	
	private int id;
	private String gazete;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGazete() {
		return gazete;
	}
	public void setGazete(String gazete) {
		this.gazete = gazete;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return gazete +"("+"Kod: "+id+")";
		
		
	}
	
}
