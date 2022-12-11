package YayinDbDa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import YayinDomain.DergiDomain;

public class DergiSQL {
	
public static void tabloOlustur() {		
		Connection baglanti= DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorguStatement=
					baglanti.prepareStatement("CREATE TABLE dergiler (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1), dergi VARCHAR(50))");		
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
	
		
public static void dergisil(DergiDomain silinecekKisiDomain) {
		Connection baglanti=DataBaseConn.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM dergiler WHERE id=?");
			sorgu.setInt(1, silinecekKisiDomain.getId());
			sorgu.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



public static ArrayList<DergiDomain> dergiListele(){	
	ArrayList<DergiDomain> dergiler= new ArrayList<DergiDomain>();
	Connection baglanti = DataBaseConn.baglantiAl();
	try {
		PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM dergiler WHERE dergi IS NOT NULL");	
		ResultSet rs2=sorgu2.executeQuery();		
		while(rs2.next()) {			
			DergiDomain siradakiDomain2=new DergiDomain();					
			siradakiDomain2.setId(rs2.getInt("id"));
			siradakiDomain2.setDergi(rs2.getString("dergi"));											
			dergiler.add(siradakiDomain2);			
		}				
	} catch (SQLException e) {	
		e.printStackTrace();
	}		
	return dergiler;	
}



public static void dergiEkle(DergiDomain eklenecekKisiDomain1) {	
	Connection baglanti=DataBaseConn.baglantiAl();
	tabloOlustur();
	PreparedStatement sorguPreparedStatement;
	try {		
		sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO dergiler (dergi) VALUES (?)");
		sorguPreparedStatement.setString(1, eklenecekKisiDomain1.getDergi());			
		sorguPreparedStatement.executeUpdate();				
	} catch (SQLException e) {	
		e.printStackTrace();
	}		
}

}
