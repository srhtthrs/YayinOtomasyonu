package YayinUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import YayinDbDa.DergiSQL;
import YayinDbDa.GazeteSQL;
import YayinDbDa.GirisSQL;
import YayinDomain.GirisDomain;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class GirisPaneli extends JFrame {

	private JPanel contentPane;
	private JTextField kTextField;
	private JTextField pTextField;
	public String kullanici;
	private JTextField adiTextField;
	private JTextField soyAdiTextField;
	private JTextField adresTextField;
	private JTextField telefonTextField;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisPaneli frame = new GirisPaneli();
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
	public GirisPaneli() {
		setTitle("Kullan\u0131c\u0131 Giri\u015Fi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1163, 692);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBackground(SystemColor.activeCaption);
		
		panel_2.setBounds(210, 10, 931, 635);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel uyeLabel = new JLabel(".....");
		uyeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		uyeLabel.setForeground(Color.RED);
		uyeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 42));
		uyeLabel.setBounds(348, 20, 575, 91);
		panel_2.add(uyeLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(8, 10, 194, 635);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 121, 915, 69);
		panel_2.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setBackground(SystemColor.info);
		
		
		JButton btnNewButton_3_1_1 = new JButton("Geri");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				GirisPaneli.this.dispose();
				Ziyaretci ziyaretci=new Ziyaretci();
				ziyaretci.setVisible(true);
			}
		});
		btnNewButton_3_1_1.setForeground(Color.BLACK);
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3_1_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1.setBounds(8, 592, 178, 33);
		panel_1.add(btnNewButton_3_1_1);
		
		Icon icon=new ImageIcon("iconsimages/logingf.gif");
		
		
		JButton btnNewButton_2 = new JButton(icon);
		btnNewButton_2.setBounds(8, 10, 178, 229);
		panel_1.add(btnNewButton_2);
		
		Icon iconw=new ImageIcon("iconsimages/nwsppr2gf.gif");
		JButton btnNewButton_1 = new JButton(iconw);
		btnNewButton_1.setBounds(8, 249, 178, 222);
		panel_1.add(btnNewButton_1);
		JButton abonelikOnayBtn = new JButton("Abonelik Onay\u0131 Sorgula");
		abonelikOnayBtn.setVisible(false);
		abonelikOnayBtn.setBounds(8, 549, 178, 33);
		panel_1.add(abonelikOnayBtn);
		abonelikOnayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				list.setListData(GirisSQL.uyeAdiIlebul(uyeLabel.getText()).toArray());
			}
		});
		abonelikOnayBtn.setForeground(Color.BLACK);
		abonelikOnayBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		abonelikOnayBtn.setBorder(new LineBorder(new Color(0, 0, 128)));
		abonelikOnayBtn.setBackground(UIManager.getColor("CheckBox.background"));
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(463, 240, 357, 158);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		
		
		JLabel lblHogeldin = new JLabel("Ho\u015Fgeldin");
		lblHogeldin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHogeldin.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		lblHogeldin.setBounds(8, 20, 302, 91);
		panel_2.add(lblHogeldin);
		
		JPanel bilgiPanel = new JPanel();
		bilgiPanel.setVisible(false);
		bilgiPanel.setLayout(null);
		bilgiPanel.setBackground(SystemColor.activeCaption);
		bilgiPanel.setBounds(187, 268, 443, 330);
		panel_2.add(bilgiPanel);
		
		JLabel lblAd = new JLabel("Ad\u0131:");
		lblAd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAd.setBounds(8, 13, 120, 29);
		bilgiPanel.add(lblAd);
		
		adiTextField = new JTextField();
		adiTextField.setBackground(SystemColor.info);
		adiTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		adiTextField.setColumns(10);
		adiTextField.setBounds(154, 10, 266, 36);
		bilgiPanel.add(adiTextField);
		
		JLabel lblSoyad = new JLabel("Soyad\u0131:");
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoyad.setBounds(8, 55, 120, 29);
		bilgiPanel.add(lblSoyad);
		
		soyAdiTextField = new JTextField();
		soyAdiTextField.setBackground(SystemColor.info);
		soyAdiTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		soyAdiTextField.setColumns(10);
		soyAdiTextField.setBounds(154, 52, 266, 36);
		bilgiPanel.add(soyAdiTextField);
		
		JLabel lblNewLabel_4_1 = new JLabel("Adres:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(8, 97, 120, 29);
		bilgiPanel.add(lblNewLabel_4_1);
		
		adresTextField = new JTextField();
		adresTextField.setBackground(SystemColor.info);
		adresTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		adresTextField.setColumns(10);
		adresTextField.setBounds(154, 94, 266, 36);
		bilgiPanel.add(adresTextField);
		
		JLabel lblNewLabel_4_2 = new JLabel("Telefon:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_2.setBounds(8, 139, 120, 29);
		bilgiPanel.add(lblNewLabel_4_2);
		
		telefonTextField = new JTextField();
		telefonTextField.setBackground(SystemColor.info);
		telefonTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		telefonTextField.setColumns(10);
		telefonTextField.setBounds(154, 136, 266, 36);
		bilgiPanel.add(telefonTextField);
		
		JList list_1 = new JList();
		list_1.setBounds(164, 356, 75, -49);
		bilgiPanel.add(list_1);
		
		JComboBox gazcomboBox = new JComboBox(GazeteSQL.gazeteListele().toArray());
		gazcomboBox.setBackground(SystemColor.info);
		gazcomboBox.setBounds(154, 182, 266, 36);
		bilgiPanel.add(gazcomboBox);
		
		JComboBox dercomboBox = new JComboBox(DergiSQL.dergiListele().toArray());
		dercomboBox.setBackground(SystemColor.info);
		dercomboBox.setBounds(154, 228, 266, 36);
		bilgiPanel.add(dercomboBox);
		
		JButton btnNewButton_3_1_2 = new JButton("G\u00F6nder", null);
		btnNewButton_3_1_2.setForeground(Color.BLACK);
		btnNewButton_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3_1_2.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_2.setBackground(SystemColor.menu);
		btnNewButton_3_1_2.setBounds(8, 461, 412, 34);
		bilgiPanel.add(btnNewButton_3_1_2);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("Gazete Se\u00E7");
		lblNewLabel_4_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_2_2.setBounds(8, 189, 98, 29);
		bilgiPanel.add(lblNewLabel_4_2_2);
		
		JLabel lblNewLabel_4_2_3 = new JLabel("Dergi Se\u00E7");
		lblNewLabel_4_2_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_2_3.setBounds(8, 231, 98, 29);
		bilgiPanel.add(lblNewLabel_4_2_3);
		
		JButton guncelleBtn = new JButton("G\u00FCncelle");
		guncelleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(adiTextField.getText().equals("")| soyAdiTextField.getText().equals("")| adresTextField.getText().equals("")| telefonTextField.getText().equals(""))										
				{
					JOptionPane.showMessageDialog(null,"Lütfen Tüm Alanlarý Doldurunuz");
				}		
				else {
				   			    	  
				    	  GirisDomain addUser=(GirisDomain) list.getSelectedValue();
				    	  
				    	  if(addUser!=null) {
				    	  addUser.setAdi(adiTextField.getText());
				    	  addUser.setSoyAdi(soyAdiTextField.getText());				    	  
				    	  addUser.setAdres(adresTextField.getText());
				    	  addUser.setTelefon(telefonTextField.getText());				    	 
				    	  			    	  				    				    	  
				    	  addUser.setGazete(gazcomboBox.getSelectedItem().toString());				    	  
				    	  addUser.setDergi(dercomboBox.getSelectedItem().toString());
				    	  
				    	 addUser.setOnayDurum("Henüz Onaylanmadý");	
				    	 
				    	  GirisSQL.abonelikGuncelle(addUser);	
				    	  
							JOptionPane.showMessageDialog(null,"Güncelleme Baþarýlý");	
							
							
							list.setListData(GirisSQL.uyeAdiIlebul(uyeLabel.getText()).toArray());
					    	adiTextField.setText("");
					    	soyAdiTextField.setText("");
					    	adresTextField.setText("");
					    	telefonTextField.setText("");	}
				    	  else {
				    		  JOptionPane.showMessageDialog(null," Yukarýdaki Listeden Bilgilerinizin Bulunduðu Satýrý Seçiniz...");
				    		  
				    	  }
							
				      					
					
									
				}
								
			}
		});
		guncelleBtn.setForeground(Color.BLACK);
		guncelleBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		guncelleBtn.setBorder(new LineBorder(new Color(0, 0, 128)));
		guncelleBtn.setBackground(UIManager.getColor("CheckBox.background"));
		guncelleBtn.setBounds(8, 278, 412, 29);
		bilgiPanel.add(guncelleBtn);
		
		JButton bilgiGuncelBtn = new JButton("Bilgilerimi G\u00FCncelle");
		bilgiGuncelBtn.setVisible(false);
		bilgiGuncelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bilgiPanel.setVisible(true);
				list.setListData(GirisSQL.uyeAdiIlebul(uyeLabel.getText()).toArray());
			}
		});
		bilgiGuncelBtn.setForeground(Color.BLACK);
		bilgiGuncelBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		bilgiGuncelBtn.setBorder(new LineBorder(new Color(0, 0, 128)));
		bilgiGuncelBtn.setBackground(UIManager.getColor("CheckBox.background"));
		bilgiGuncelBtn.setBounds(8, 506, 178, 33);
		panel_1.add(bilgiGuncelBtn);
		
		
		
		JButton btnNewButton = new JButton("Giri\u015F");
		btnNewButton.setBounds(8, 114, 336, 36);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
							
				 if (GirisSQL.kontrol(kTextField.getText(), pTextField.getText()) )
					
					{	
										
						panel.setVisible(false);
						panel_2.setVisible(true);
						
						btnNewButton_1.setVisible(true);
						
						uyeLabel.setText(kTextField.getText());
						abonelikOnayBtn.setVisible(true);
						bilgiGuncelBtn.setVisible(true);
						
						
					}
				 else
					{
					JOptionPane.showMessageDialog(null,"kullanýcý adý ya da þifre hatalýdýr.");			
					}
			
				
				 
				 
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		pTextField = new JTextField();
		pTextField.setBounds(154, 62, 190, 42);
		panel.add(pTextField);
		pTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		pTextField.setColumns(10);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setBounds(8, 62, 138, 42);
		panel.add(lblParola);
		lblParola.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKullancAd.setBounds(8, 10, 138, 42);
		panel.add(lblKullancAd);
		lblKullancAd.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		kTextField = new JTextField();
		kTextField.setBounds(154, 10, 190, 42);
		panel.add(kTextField);
		kTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		kTextField.setColumns(10);
		
		
		
		
	}
}
