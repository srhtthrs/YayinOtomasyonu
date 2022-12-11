package YayinDbDa;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.JOptionPane;


import YayinDomain.GirisDomain;




public class GirisSQL {
	
	
public static void tabloOlustur() {		
		Connection baglanti7= DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorguStatement=
					baglanti7.prepareStatement("CREATE TABLE uyeler (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),"
							+ "kullaniciadi VARCHAR(50),"
							+ "parola VARCHAR (50),"
							+ "parolatekrar VARCHAR(50),"
							+"adi VARCHAR(50),"
							+ "soyadi VARCHAR(50),"
							+ "adres VARCHAR(50),"
							+ "telefon VARCHAR(50),"
							+ "gazete VARCHAR(50),"
							+ "dergi VARCHAR(50),"
							+ "onaydurum VARCHAR(50))");	
							
					
	sorguStatement.executeUpdate();		
		} catch (SQLException e) {			
			if(e.getSQLState().equals("X0Y32")) {				
				System.out.println("tablo mevcut");
			}else 
			{			
			e.printStackTrace();		
			}
}
}
	
		
public static void kisiSil(GirisDomain silinecekKisiDomain) {
		Connection baglanti=DataBaseConn.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM uyeler WHERE id=?");
			sorgu.setInt(1, silinecekKisiDomain.getId());
			sorgu.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


public static ArrayList<GirisDomain> uyeleriListele(){	
	ArrayList<GirisDomain> uyeler= new ArrayList<GirisDomain>();
	Connection baglanti = DataBaseConn.baglantiAl();
	try {
		PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM uyeler ORDER BY onaydurum ASC");	
		ResultSet rs2=sorgu2.executeQuery();		
		while(rs2.next()) {			
			GirisDomain siradakiDomain2=new GirisDomain();	
			
			siradakiDomain2.setId(rs2.getInt("id"));
			siradakiDomain2.setKullaniciAdi(rs2.getString("kullaniciadi"));
			siradakiDomain2.setParola(rs2.getString("parola"));
			siradakiDomain2.setParolaTekrar(rs2.getString("parolatekrar"));
			siradakiDomain2.setAdi(rs2.getString("adi"));
			siradakiDomain2.setSoyAdi(rs2.getString("soyadi"));
			siradakiDomain2.setAdres(rs2.getString("adres"));
			siradakiDomain2.setTelefon(rs2.getString("telefon"));
			siradakiDomain2.setGazete(rs2.getString("gazete"));
			siradakiDomain2.setDergi(rs2.getString("dergi"));
			siradakiDomain2.setOnayDurum(rs2.getString("onaydurum"));
					
			
			uyeler.add(siradakiDomain2);			
		}				
	} catch (SQLException e) {	
		e.printStackTrace();
	}		
	return uyeler;	
}


public static void kisiEkle(GirisDomain eklenecekKisiDomain1) {	
	Connection baglanti=DataBaseConn.baglantiAl();
	tabloOlustur();
	PreparedStatement sorguPreparedStatement;
	try {		
		sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO uyeler (kullaniciadi, parola, parolatekrar, adi, soyadi, adres, telefon, gazete,dergi, onaydurum) VALUES (?,?,?,?,?,?,?,?,?,?)");
		
		sorguPreparedStatement.setString(1, eklenecekKisiDomain1.getKullaniciAdi());			
		sorguPreparedStatement.setString(2, eklenecekKisiDomain1.getParola());
		sorguPreparedStatement.setString(3, eklenecekKisiDomain1.getParolaTekrar());
		sorguPreparedStatement.setString(4, eklenecekKisiDomain1.getAdi());
		sorguPreparedStatement.setString(5, eklenecekKisiDomain1.getSoyAdi());
		sorguPreparedStatement.setString(6, eklenecekKisiDomain1.getAdres());
		sorguPreparedStatement.setString(7, eklenecekKisiDomain1.getTelefon());
		sorguPreparedStatement.setString(8, eklenecekKisiDomain1.getGazete());
		sorguPreparedStatement.setString(9, eklenecekKisiDomain1.getDergi());
		sorguPreparedStatement.setString(10, eklenecekKisiDomain1.getOnayDurum());
		
		
		sorguPreparedStatement.executeUpdate();				
	} catch (SQLException e) {	
		e.printStackTrace();
	}		
}


public static boolean kontrol(String kullaniciAdi, String parola) {
	
	boolean sonuc=false;
	
	Connection baglanti= DataBaseConn.baglantiAl();
	 try {
		 
		 PreparedStatement sorgu= baglanti.prepareStatement("SELECT * FROM uyeler WHERE kullaniciadi=? AND parola=?");
		 sorgu.setString(1,kullaniciAdi);
		 sorgu.setString(2,parola);
		 ResultSet rs=sorgu.executeQuery();
		 
		 while(rs.next()) {
			 sonuc=true;
			 }
		
	} catch (Exception e) {
	
		JOptionPane.showMessageDialog(null, "Hata Var");
		
	}
	return sonuc;
	
}


public static boolean kullaniciAdiKontrol(String kullaniciAdi) {
	boolean sonuc=false;	
	Connection baglanti= DataBaseConn.baglantiAl();
	 try {		 
		 PreparedStatement sorgu= baglanti.prepareStatement("SELECT * FROM uyeler WHERE kullaniciadi=?");
		 sorgu.setString(1,kullaniciAdi);		 
		 ResultSet rs=sorgu.executeQuery();		 
		 while(rs.next()) {
			 sonuc=true;
			 }		
	 } 
	 catch (Exception e) 
	 {	
		JOptionPane.showMessageDialog(null, "Hata Var");		
	 }
	return sonuc;	
}


public static void abonelikOnayla(GirisDomain duzenlenecekKisiDomain) {
	
	Connection baglanti=DataBaseConn.baglantiAl();
	try {
		PreparedStatement sorgu =baglanti.prepareStatement("UPDATE uyeler SET onaydurum=? WHERE id=?");
	sorgu.setString(1, duzenlenecekKisiDomain.getOnayDurum());	
	sorgu.setInt(2, duzenlenecekKisiDomain.getId());
	
	
	sorgu.executeUpdate();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}


public static ArrayList<GirisDomain> bul(String adiString){		
	ArrayList<GirisDomain> bulunanKisiListesi= new ArrayList<GirisDomain>();
	Connection baglanti = DataBaseConn.baglantiAl();
	try {
		PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM uyeler WHERE adi LIKE ? ORDER BY adi ASC");	
		sorgu.setString(1, "%"+adiString+"%");
		ResultSet rs=sorgu.executeQuery();			
		while(rs.next()) {				
			GirisDomain siradakiDomain=new GirisDomain();
			
			
			siradakiDomain.setId(rs.getInt("id"));
			siradakiDomain.setAdi(rs.getString("adi"));
			siradakiDomain.setSoyAdi(rs.getString("soyadi"));
			siradakiDomain.setAdres(rs.getString("adres"));
			siradakiDomain.setTelefon(rs.getString("telefon"));
			siradakiDomain.setGazete(rs.getString("gazete"));
			siradakiDomain.setDergi(rs.getString("dergi"));
			siradakiDomain.setOnayDurum(rs.getString("onaydurum"));			
			bulunanKisiListesi.add(siradakiDomain);				
		}			
	} catch (SQLException e) {		
		e.printStackTrace();
	}			
	return bulunanKisiListesi;	
}

public static ArrayList<GirisDomain> bolgeBul(String bolgeString){		
	ArrayList<GirisDomain> bulunanKisiListesi= new ArrayList<GirisDomain>();
	Connection baglanti = DataBaseConn.baglantiAl();
	try {
		PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM uyeler WHERE adres LIKE ?");	
		sorgu.setString(1, bolgeString+"%");
		ResultSet rs=sorgu.executeQuery();			
		while(rs.next()) {				
			GirisDomain siradakiDomain=new GirisDomain();
			
			
			siradakiDomain.setId(rs.getInt("id"));
			siradakiDomain.setAdi(rs.getString("adi"));
			siradakiDomain.setSoyAdi(rs.getString("soyadi"));
			siradakiDomain.setAdres(rs.getString("adres"));
			siradakiDomain.setTelefon(rs.getString("telefon"));
			siradakiDomain.setGazete(rs.getString("gazete"));
			siradakiDomain.setDergi(rs.getString("dergi"));
			siradakiDomain.setOnayDurum(rs.getString("onaydurum"));			
			bulunanKisiListesi.add(siradakiDomain);				
		}			
	} catch (SQLException e) {		
		e.printStackTrace();
	}			
	return bulunanKisiListesi;	
}

public static int bolgeBulsay(String bolgeString){		
	ArrayList<GirisDomain> bulunanKisiListesi= new ArrayList<GirisDomain>();
	Connection baglanti = DataBaseConn.baglantiAl();
	int say=0;
	try {
		PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM uyeler WHERE adres LIKE ?");	
		sorgu.setString(1, bolgeString+"%");
		ResultSet rs=sorgu.executeQuery();	
		
		while(rs.next()) {	
			say++;
			GirisDomain siradakiDomain=new GirisDomain();
			
			
			siradakiDomain.setId(rs.getInt("id"));
			siradakiDomain.setAdi(rs.getString("adi"));
			siradakiDomain.setSoyAdi(rs.getString("soyadi"));
			siradakiDomain.setAdres(rs.getString("adres"));
			siradakiDomain.setTelefon(rs.getString("telefon"));
			siradakiDomain.setGazete(rs.getString("gazete"));
			siradakiDomain.setDergi(rs.getString("dergi"));
			siradakiDomain.setOnayDurum(rs.getString("onaydurum"));			
			bulunanKisiListesi.add(siradakiDomain);				
		}			
	} catch (SQLException e) {		
		e.printStackTrace();
	}			
	return say;	
}

public static ArrayList<GirisDomain> dergiBul(String dergiString){		
	ArrayList<GirisDomain> bulunanKisiListesi= new ArrayList<GirisDomain>();
	Connection baglanti = DataBaseConn.baglantiAl();
	try {
		PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM uyeler WHERE dergi LIKE ?");	
		sorgu.setString(1, dergiString+"%");
		ResultSet rs=sorgu.executeQuery();			
		while(rs.next()) {				
			GirisDomain siradakiDomain=new GirisDomain();
			
			
			siradakiDomain.setId(rs.getInt("id"));
			siradakiDomain.setAdi(rs.getString("adi"));
			siradakiDomain.setSoyAdi(rs.getString("soyadi"));
			siradakiDomain.setAdres(rs.getString("adres"));
			siradakiDomain.setTelefon(rs.getString("telefon"));
			siradakiDomain.setGazete(rs.getString("gazete"));
			siradakiDomain.setDergi(rs.getString("dergi"));
			siradakiDomain.setOnayDurum(rs.getString("onaydurum"));			
			bulunanKisiListesi.add(siradakiDomain);				
		}			
	} catch (SQLException e) {		
		e.printStackTrace();
	}			
	return bulunanKisiListesi;	
}


public static int dergiBulsay(String dergiString){		
	ArrayList<GirisDomain> bulunanKisiListesi= new ArrayList<GirisDomain>();
	Connection baglanti = DataBaseConn.baglantiAl();
	int say=0;
	try {
		PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM uyeler WHERE dergi LIKE ?");	
		sorgu.setString(1, dergiString+"%");
		ResultSet rs=sorgu.executeQuery();	
		
		while(rs.next()) {	
			say++;
			GirisDomain siradakiDomain=new GirisDomain();
			
			
			siradakiDomain.setId(rs.getInt("id"));
			siradakiDomain.setAdi(rs.getString("adi"));
			siradakiDomain.setSoyAdi(rs.getString("soyadi"));
			siradakiDomain.setAdres(rs.getString("adres"));
			siradakiDomain.setTelefon(rs.getString("telefon"));
			siradakiDomain.setGazete(rs.getString("gazete"));
			siradakiDomain.setDergi(rs.getString("dergi"));
			siradakiDomain.setOnayDurum(rs.getString("onaydurum"));			
			bulunanKisiListesi.add(siradakiDomain);				
		}			
	} catch (SQLException e) {		
		e.printStackTrace();
	}			
	return say;	
}


public static ArrayList<GirisDomain> gazeteBul(String gazeteString){		
	ArrayList<GirisDomain> bulunanKisiListesi= new ArrayList<GirisDomain>();
	Connection baglanti = DataBaseConn.baglantiAl();
	
	try {
		PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM uyeler WHERE gazete LIKE ?");	
		sorgu.setString(1, gazeteString+"%");
		ResultSet rs=sorgu.executeQuery();			
		while(rs.next()) {				
			GirisDomain siradakiDomain=new GirisDomain();
			
			
			siradakiDomain.setId(rs.getInt("id"));
			siradakiDomain.setAdi(rs.getString("adi"));
			siradakiDomain.setSoyAdi(rs.getString("soyadi"));
			siradakiDomain.setAdres(rs.getString("adres"));
			siradakiDomain.setTelefon(rs.getString("telefon"));
			siradakiDomain.setGazete(rs.getString("gazete"));
			siradakiDomain.setDergi(rs.getString("dergi"));
			siradakiDomain.setOnayDurum(rs.getString("onaydurum"));			
			bulunanKisiListesi.add(siradakiDomain);				
		}			
	} catch (SQLException e) {		
		e.printStackTrace();
	}			
	return bulunanKisiListesi;	
}


public static int gazeteBulsay(String gazeteString){		
	ArrayList<GirisDomain> bulunanKisiListesi= new ArrayList<GirisDomain>();
	Connection baglanti = DataBaseConn.baglantiAl();
	int say=0;
	try {
		PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM uyeler WHERE gazete LIKE ?");	
		sorgu.setString(1, gazeteString+"%");
		ResultSet rs=sorgu.executeQuery();	
		
		while(rs.next()) {	
			say++;
			GirisDomain siradakiDomain=new GirisDomain();
			
			
			siradakiDomain.setId(rs.getInt("id"));
			siradakiDomain.setAdi(rs.getString("adi"));
			siradakiDomain.setSoyAdi(rs.getString("soyadi"));
			siradakiDomain.setAdres(rs.getString("adres"));
			siradakiDomain.setTelefon(rs.getString("telefon"));
			siradakiDomain.setGazete(rs.getString("gazete"));
			siradakiDomain.setDergi(rs.getString("dergi"));
			siradakiDomain.setOnayDurum(rs.getString("onaydurum"));			
			bulunanKisiListesi.add(siradakiDomain);				
		}			
	} catch (SQLException e) {		
		e.printStackTrace();
	}			
	return say;	
}


public static ArrayList<GirisDomain> uyeAdiIlebul(String adiString){		
	ArrayList<GirisDomain> bulunanKisiListesi= new ArrayList<GirisDomain>();
	Connection baglanti = DataBaseConn.baglantiAl();
	try {
		PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM uyeler WHERE kullaniciAdi LIKE ? ORDER BY adi ASC");	
		sorgu.setString(1,adiString);
		ResultSet rs=sorgu.executeQuery();			
		while(rs.next()) {				
			GirisDomain siradakiDomain=new GirisDomain();
			
			
			siradakiDomain.setId(rs.getInt("id"));
			siradakiDomain.setAdi(rs.getString("adi"));
			siradakiDomain.setSoyAdi(rs.getString("soyadi"));
			siradakiDomain.setAdres(rs.getString("adres"));
			siradakiDomain.setTelefon(rs.getString("telefon"));
			siradakiDomain.setGazete(rs.getString("gazete"));
			siradakiDomain.setDergi(rs.getString("dergi"));
			siradakiDomain.setOnayDurum(rs.getString("onaydurum"));			
			bulunanKisiListesi.add(siradakiDomain);				
		}			
	} catch (SQLException e) {		
		e.printStackTrace();
	}			
	return bulunanKisiListesi;	
}


public static int uyeAdiBulsay(String ueAdiBulSayString){		
	ArrayList<GirisDomain> bulunanKisiListesi= new ArrayList<GirisDomain>();
	Connection baglanti = DataBaseConn.baglantiAl();
	int say=0;
	try {
		PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM uyeler WHERE adi LIKE ?");	
		sorgu.setString(1, ueAdiBulSayString+"%");
		ResultSet rs=sorgu.executeQuery();	
		
		while(rs.next()) {	
			say++;
			GirisDomain siradakiDomain=new GirisDomain();
			
			
			siradakiDomain.setId(rs.getInt("id"));
			siradakiDomain.setAdi(rs.getString("adi"));
			siradakiDomain.setSoyAdi(rs.getString("soyadi"));
			siradakiDomain.setAdres(rs.getString("adres"));
			siradakiDomain.setTelefon(rs.getString("telefon"));
			siradakiDomain.setGazete(rs.getString("gazete"));
			siradakiDomain.setDergi(rs.getString("dergi"));
			siradakiDomain.setOnayDurum(rs.getString("onaydurum"));			
			bulunanKisiListesi.add(siradakiDomain);				
		}			
	} catch (SQLException e) {		
		e.printStackTrace();
	}			
	return say;	
}


public static ArrayList<GirisDomain> onaysizTalepGor(String talep){		
	ArrayList<GirisDomain> bulunanKisiListesi= new ArrayList<GirisDomain>();
	Connection baglanti = DataBaseConn.baglantiAl();
	try {
		PreparedStatement sorgu =baglanti.prepareStatement("SELECT * FROM uyeler WHERE onaydurum LIKE ? ORDER BY adi ASC");	
		sorgu.setString(1, "%"+talep+"%");
		ResultSet rs=sorgu.executeQuery();			
		while(rs.next()) {				
			GirisDomain siradakiDomain=new GirisDomain();
			
			
			siradakiDomain.setId(rs.getInt("id"));
			siradakiDomain.setAdi(rs.getString("adi"));
			siradakiDomain.setSoyAdi(rs.getString("soyadi"));
			siradakiDomain.setAdres(rs.getString("adres"));
			siradakiDomain.setTelefon(rs.getString("telefon"));
			siradakiDomain.setGazete(rs.getString("gazete"));
			siradakiDomain.setDergi(rs.getString("dergi"));
			siradakiDomain.setOnayDurum(rs.getString("onaydurum"));
			
			
			
			
			
			bulunanKisiListesi.add(siradakiDomain);				
		}			
	} catch (SQLException e) {		
		e.printStackTrace();
	}			
	return bulunanKisiListesi;	
}


public static void abonelikGuncelle(GirisDomain guncellenecekKisiDomain) {
	
	Connection baglanti=DataBaseConn.baglantiAl();
	try {                                                        
		PreparedStatement sorgu =baglanti.prepareStatement("UPDATE uyeler SET adi=? , soyadi=? , adres=? , telefon=? , gazete=? , dergi=? , onaydurum=? WHERE id=?");
	sorgu.setString(1, guncellenecekKisiDomain.getAdi());	
	sorgu.setString(2, guncellenecekKisiDomain.getSoyAdi());	
	sorgu.setString(3, guncellenecekKisiDomain.getAdres());	
	sorgu.setString(4, guncellenecekKisiDomain.getTelefon());	
	sorgu.setString(5, guncellenecekKisiDomain.getGazete());
	sorgu.setString(6, guncellenecekKisiDomain.getDergi());	
	sorgu.setString(7, guncellenecekKisiDomain.getOnayDurum());	
	sorgu.setInt(8, guncellenecekKisiDomain.getId());
	
	
	sorgu.executeUpdate();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		
}














}
