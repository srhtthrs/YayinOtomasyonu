package YayinDomain;

public class GirisDomain {
	
	private int id;
	private String kullaniciAdi;
	private String parola;
	private String parolaTekrar;
	
	private String adi;
	private String soyAdi;
	
	private String adres;
	private String telefon;
	
	private String gazete;
	private String dergi;
	
	private String onayDurum;
	
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}



	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}


	public String getParola() {
		return parola;
	}




	public void setParola(String parola) {
		this.parola = parola;
	}


	public String getParolaTekrar() {
		return parolaTekrar;
	}


	public void setParolaTekrar(String parolaTekrar) {
		this.parolaTekrar = parolaTekrar;
	}


	public String getAdi() {
		return adi;
	}



	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSoyAdi() {
		return soyAdi;
	}


	public void setSoyAdi(String soyAdi) {
		this.soyAdi = soyAdi;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}


	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getGazete() {
		return gazete;
	}

	public void setGazete(String gazete) {
		this.gazete = gazete;
	}

	public String getDergi() {
		return dergi;
	}

	public void setDergi(String dergi) {
		this.dergi = dergi;
	}
	
	
	
	
	
	
	
	public String getOnayDurum() {
		return onayDurum;
	}

	public void setOnayDurum(String onayDurum) {
		this.onayDurum = onayDurum;
	}



	@Override
	public String toString() {
	
		
		return "Onay Durumu: "+onayDurum+ "     "+"Sicil: "+id+ "     "+"Adý: "+adi+ "     "+"Soyadý: "+soyAdi+ "     "+"Adresi: "+adres+ "     "+"Telefonu: "+telefon+"     "+"Gazete: "+gazete+ "     "+"Dergi: "+dergi;

	}
	

}

