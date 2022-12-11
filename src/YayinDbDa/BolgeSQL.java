package YayinDbDa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import YayinDomain.BolgeDomain;



public class BolgeSQL {

	static DefaultTableModel model;
	
	
public static void tabloOlustur() {		
		Connection baglanti= DataBaseConn.baglantiAl();
		try {
			PreparedStatement sorguStatement=
					baglanti.prepareStatement("CREATE TABLE bolgeler (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1), bolge VARCHAR(50))");		
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
	

public static void bolgesil(BolgeDomain silinecekKisiDomain) {
		Connection baglanti=DataBaseConn.baglantiAl();	
		try {
			PreparedStatement sorgu= baglanti.prepareStatement("DELETE FROM bolgeler WHERE id=?");
			
			sorgu.setInt(1, silinecekKisiDomain.getId());
			
			sorgu.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


public static void ekle_bolge(BolgeDomain eklenecekKisiDomain1) {	
	Connection baglanti=DataBaseConn.baglantiAl();
	tabloOlustur();
	PreparedStatement sorguPreparedStatement;
	try {		
		sorguPreparedStatement = baglanti.prepareStatement("INSERT INTO bolgeler (bolge) VALUES (?)");
		sorguPreparedStatement.setString(1, eklenecekKisiDomain1.getBolge());			
		sorguPreparedStatement.executeUpdate();				
	} catch (SQLException e) {	
		e.printStackTrace();
	}		
}


public static ArrayList<BolgeDomain> bolgeListele(){	
	ArrayList<BolgeDomain> bolgeler= new ArrayList<BolgeDomain>();
	Connection baglanti = DataBaseConn.baglantiAl();
	try {
		PreparedStatement sorgu2 =baglanti.prepareStatement("SELECT * FROM bolgeler WHERE bolge IS NOT NULL");	
		ResultSet rs2=sorgu2.executeQuery();		
		while(rs2.next()) {			
			BolgeDomain siradakiDomain2=new BolgeDomain();					
			siradakiDomain2.setId(rs2.getInt("id"));
			siradakiDomain2.setBolge(rs2.getString("bolge"));											
			bolgeler.add(siradakiDomain2);			
		}				
	} catch (SQLException e) {	
		e.printStackTrace();
	}		
	return bolgeler;	
}


public static DefaultTableModel bolgeDefaultTableModel() {
	 model=new DefaultTableModel();
	 Object[] kolonlar= {"DAÐITIM BÖLGELERÝMÝZ"};  //Dizimizi Object sýnýfýnda oluþturmamýz durumunda içerisinde farklý tipte verileri (int,String) barýndýrabiliriz.
	 Object[] satirlar=new Object[200];//dizi uzunluðunu farklý bir fonksiyonla aldýk.
	 Connection baglanti =DataBaseConn.baglantiAl();			 		 
	 model.setColumnIdentifiers(kolonlar);					 		
	try {
		Statement st= baglanti.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM bolgeler ORDER BY bolge ASC");
		while(rs.next()) {					
			//satirlar[0]=rs.getInt("id");
			satirlar[0]=rs.getString("bolge");
			
			model.addRow(satirlar);				
		}			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return model;				
}







		
}
