package YayinUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import YayinDbDa.BolgeSQL;
import YayinDbDa.DataBaseConn;
import YayinDbDa.DergiSQL;
import YayinDbDa.GazeteSQL;
import YayinDbDa.GirisSQL;
import YayinDomain.DergiDomain;
import YayinDomain.GazeteDomain;
import YayinDomain.GirisDomain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class UyeOl extends JFrame {

	private JPanel contentPane;
	private JTextField kadiTextField;
	private JTextField parolaTextField;
	private JTextField parolaTTextField;
	private JTextField adiTextField;
	private JTextField soyadiTextField;
	private JTextField adresTextField;
	private JTextField telefonTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UyeOl frame = new UyeOl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UyeOl() {
		setBackground(SystemColor.inactiveCaption);
		setTitle("\u00DCye Ol");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1163, 692);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		ImageIcon ikonCik = new ImageIcon("iconsimages/cikis.png"); 
		Image imageCik = ikonCik.getImage();
		Image newimgCik = imageCik.getScaledInstance(25, 25,  java.awt.Image.SCALE_AREA_AVERAGING); 
		ImageIcon newImageIconCik = new ImageIcon(newimgCik); 
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(8, 10, 187, 635);
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_3_1_1 = new JButton("Geri", null);
		btnNewButton_3_1_1.setBounds(8, 591, 171, 34);
		panel.add(btnNewButton_3_1_1);
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//UyeOl.this.setVisible(false);
				UyeOl.this.dispose();
				Ziyaretci ziyaretci=new Ziyaretci();
				ziyaretci.setVisible(true);
				
				
			}
		});
		btnNewButton_3_1_1.setForeground(Color.BLACK);
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3_1_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1.setBackground(UIManager.getColor("CheckBox.background"));
		
		
		Icon ikonUGf = new ImageIcon("iconsimages/uyegf.gif"); 
			JButton btnNewButton = new JButton(ikonUGf);
			btnNewButton.setBounds(8, 10, 171, 208);
			panel.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(203, 10, 428, 635);
		panel_1.setBackground(SystemColor.activeCaption);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(8, 64, 120, 29);
		panel_1.add(lblNewLabel);
		
		kadiTextField = new JTextField();
		kadiTextField.setBackground(SystemColor.info);
		kadiTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		kadiTextField.setBounds(154, 61, 266, 36);
		panel_1.add(kadiTextField);
		kadiTextField.setColumns(10);
		
		JLabel lblParola = new JLabel("Parola:");
		lblParola.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblParola.setBounds(8, 106, 120, 29);
		panel_1.add(lblParola);
		
		parolaTextField = new JTextField();
		parolaTextField.setBackground(SystemColor.info);
		parolaTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		parolaTextField.setColumns(10);
		parolaTextField.setBounds(154, 103, 266, 36);
		panel_1.add(parolaTextField);
		
		JLabel lblParolaTekrar = new JLabel("Parola Tekrar:");
		lblParolaTekrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblParolaTekrar.setBounds(8, 148, 120, 29);
		panel_1.add(lblParolaTekrar);
		
		parolaTTextField = new JTextField();
		parolaTTextField.setBackground(SystemColor.info);
		parolaTTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		parolaTTextField.setColumns(10);
		parolaTTextField.setBounds(154, 145, 266, 36);
		panel_1.add(parolaTTextField);
		
		JLabel lblAd = new JLabel("Ad\u0131:");
		lblAd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAd.setBounds(8, 190, 120, 29);
		panel_1.add(lblAd);
		
		adiTextField = new JTextField();
		adiTextField.setBackground(SystemColor.info);
		adiTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		adiTextField.setColumns(10);
		adiTextField.setBounds(154, 187, 266, 36);
		panel_1.add(adiTextField);
		
		JLabel lblSoyad = new JLabel("Soyad\u0131:");
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoyad.setBounds(8, 232, 120, 29);
		panel_1.add(lblSoyad);
		
		soyadiTextField = new JTextField();
		soyadiTextField.setBackground(SystemColor.info);
		soyadiTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		soyadiTextField.setColumns(10);
		soyadiTextField.setBounds(154, 229, 266, 36);
		panel_1.add(soyadiTextField);
		
		JLabel lblNewLabel_4_1 = new JLabel("Adres:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(8, 274, 120, 29);
		panel_1.add(lblNewLabel_4_1);
		
		adresTextField = new JTextField();
		adresTextField.setBackground(SystemColor.info);
		adresTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		adresTextField.setColumns(10);
		adresTextField.setBounds(154, 271, 266, 36);
		panel_1.add(adresTextField);
		
		JLabel lblNewLabel_4_2 = new JLabel("Telefon:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_2.setBounds(8, 316, 120, 29);
		panel_1.add(lblNewLabel_4_2);
		
		telefonTextField = new JTextField();
		telefonTextField.setBackground(SystemColor.info);
		telefonTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		telefonTextField.setColumns(10);
		telefonTextField.setBounds(154, 313, 266, 36);
		panel_1.add(telefonTextField);
		
		JList list = new JList();
		list.setBounds(164, 356, 75, -49);
		panel_1.add(list);
		
		JComboBox onayComboBox = new JComboBox();
		onayComboBox.setEnabled(false);
		onayComboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		onayComboBox.setModel(new DefaultComboBoxModel(new String[] {"Hen\u00FCz Onaylanmad\u0131", "Onayland\u0131"}));
		onayComboBox.setBounds(154, 451, 266, 37);
		panel_1.add(onayComboBox);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Abonelik Onay Durumu:");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4_2_1.setBounds(8, 457, 138, 29);
		panel_1.add(lblNewLabel_4_2_1);
		
		
		JComboBox gazcomboBox = new JComboBox(GazeteSQL.gazeteListele().toArray());
		gazcomboBox.setBackground(SystemColor.info);
		gazcomboBox.setBounds(154, 359, 266, 36);
		panel_1.add(gazcomboBox);
		
		JComboBox dercomboBox = new JComboBox(DergiSQL.dergiListele().toArray());
		dercomboBox.setBackground(SystemColor.info);
		dercomboBox.setBounds(154, 405, 266, 36);
		panel_1.add(dercomboBox);
		
		JButton btnNewButton_3_1_2 = new JButton("G\u00F6nder", null);
		btnNewButton_3_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			if(GirisSQL.kullaniciAdiKontrol(kadiTextField.getText())) {
			JOptionPane.showMessageDialog(null,"Kullanýcý Adý Daha Önce Alýnmýþ, Farklý Bir Kullanýcý Adý Deneyin");
				
			}
			else {
				
				if(kadiTextField.getText().equals("") | parolaTextField.getText().equals("")| parolaTTextField.getText().equals("")| adiTextField.getText().equals("")| soyadiTextField.getText().equals("")| adresTextField.getText().equals("")| telefonTextField.getText().equals(""))										
				{
					JOptionPane.showMessageDialog(null,"Lütfen Tüm Alanlarý Doldurunuz");
				}
			
				else if(parolaTextField.getText().equals(parolaTTextField.getText())){
				      try {
				    	  
				    	  GirisDomain addUser=new GirisDomain();
				    	  
				    	  addUser.setKullaniciAdi(kadiTextField.getText());
				    	  addUser.setParola(parolaTextField.getText());
				    	  addUser.setParolaTekrar(parolaTTextField.getText());
				    	  
				    	  addUser.setAdi(adiTextField.getText());
				    	  addUser.setSoyAdi(soyadiTextField.getText());
				    	  
				    	  addUser.setAdres(adresTextField.getText());
				    	  addUser.setTelefon(telefonTextField.getText());
				    	  
				    	 
				    	 
				    	  System.out.println(gazcomboBox.getSelectedItem());
				    	  
				    
				    	  
				    	  addUser.setGazete(gazcomboBox.getSelectedItem().toString());
				    	  
				    	  addUser.setDergi(dercomboBox.getSelectedItem().toString());
				    	 			    	  
				    	  
				    	 addUser.setOnayDurum("Henüz Onaylanmadý");
				    	  
				    	  GirisSQL.kisiEkle(addUser);							
							JOptionPane.showMessageDialog(null,"Kayýt Baþarýlý");
							
							kadiTextField.setText("");
					    	parolaTextField.setText("");
					    	parolaTTextField.setText("");					    	  
					    	adiTextField.setText("");
					    	soyadiTextField.setText("");
					    	adresTextField.setText("");
					    	telefonTextField.setText("");
							
							
				      }						
					 catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null,"Baglanti Hatasi");
						
					}
					
					
				}
				
				else JOptionPane.showMessageDialog(null,"Parolayý Kontrol Edin");
				
			}
		
		
			}

			
			});
		
		
		
		
		btnNewButton_3_1_2.setForeground(Color.BLACK);
		btnNewButton_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3_1_2.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_2.setBackground(UIManager.getColor("CheckBoxMenuItem.background"));
		btnNewButton_3_1_2.setBounds(8, 591, 412, 34);
		panel_1.add(btnNewButton_3_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("Yay\u0131n \u00DCyeli\u011Fi / Abonelik \u0130\u00E7in A\u015Fa\u011F\u0131daki Formu Doldurunuz.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblNewLabel_1.setBounds(8, 10, 412, 29);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("Gazete Se\u00E7");
		lblNewLabel_4_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_2_2.setBounds(8, 366, 98, 29);
		panel_1.add(lblNewLabel_4_2_2);
		
		JLabel lblNewLabel_4_2_3 = new JLabel("Dergi Se\u00E7");
		lblNewLabel_4_2_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_2_3.setBounds(8, 408, 98, 29);
		panel_1.add(lblNewLabel_4_2_3);
		
		setLocationRelativeTo(null);
		
		
		ImageIcon imgdgtm=new ImageIcon("iconsimages/bolges.jpg");
		JButton btnNewButton_1 = new JButton(imgdgtm);
		btnNewButton_1.setBounds(659, 320, 482, 325);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.info);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		scrollPane.setBounds(659, 60, 482, 250);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setGridColor(Color.BLUE);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setBackground(SystemColor.info);
		table.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		scrollPane.setViewportView(table);
		
		
		table.setModel(BolgeSQL.bolgeDefaultTableModel());
		
		Icon ýcnDuyuru=new ImageIcon("iconsimages/duyuruGf2.gif");
		
		JLabel lblNewLabel_1_1 = new JLabel("\u0130kamet Adresinize Da\u011F\u0131t\u0131m Yap\u0131l\u0131p Yap\u0131lmad\u0131\u011F\u0131n\u0131 Kontrol Ediniz.");
		lblNewLabel_1_1.setBounds(659, 21, 482, 29);
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
	}
}
