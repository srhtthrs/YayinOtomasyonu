package YayinDbDa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import YayinDomain.GazeteDomain;

public class GazeteSQL {

	
public static void tabloOlustur() {		
		Connection baglanti= DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorguStatement=
					baglanti.prepareStatement("CREATE TABLE gazeteler (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1), gazete VARCHAR(50))");		
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
	
		
public static void gazeteSil(GazeteDomain silinecekKisiDomain) {
		Connection baglanti=DataBaseConn.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM gazeteler WHERE id=?");
			sorgu.setInt(1, silinecekKisiDomain.getId());
			sorgu.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



public static ArrayList<GazeteDomain> gazeteListele(){	
	ArrayList<GazeteDomain> gazeteler= new ArrayList<GazeteDomain>();
	Connection baglanti = DataBaseConn.baglantiAl();
	try {
		PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM gazeteler WHERE gazete IS NOT NULL");	
		ResultSet rs2=sorgu2.executeQuery();		
		while(rs2.next()) {			
			GazeteDomain siradakiDomain2=new GazeteDomain();					
			siradakiDomain2.setId(rs2.getInt("id"));
			siradakiDomain2.setGazete(rs2.getString("gazete"));											
			gazeteler.add(siradakiDomain2);			
		}				
	} catch (SQLException e) {	
		e.printStackTrace();
	}		
	return gazeteler;	
}










public static void gazeteEkle(GazeteDomain eklenecekKisiDomain1) {	
	Connection baglanti=DataBaseConn.baglantiAl();
	tabloOlustur();
	PreparedStatement sorguPreparedStatement;
	try {		
		sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO gazeteler (gazete) VALUES (?)");
		sorguPreparedStatement.setString(1, eklenecekKisiDomain1.getGazete());			
		sorguPreparedStatement.executeUpdate();				
	} catch (SQLException e) {	
		e.printStackTrace();
	}		
}


}