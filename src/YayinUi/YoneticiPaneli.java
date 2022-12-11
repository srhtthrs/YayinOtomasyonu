package YayinUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;


import YayinDbDa.BolgeSQL;
import YayinDbDa.DataBaseConn;
import YayinDbDa.DergiSQL;
import YayinDbDa.GazeteSQL;
import YayinDbDa.GirisSQL;
import YayinDomain.BolgeDomain;
import YayinDomain.DergiDomain;
import YayinDomain.GazeteDomain;

import YayinDomain.GirisDomain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;

public class YoneticiPaneli extends JFrame {

	private JPanel contentPane;
	private JTextField gazeteField;
	private JTextField dergiField;
	private JTextField bolgeField;
	private JTextField bultextField;
	private JTextField toplamTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YoneticiPaneli frame = new YoneticiPaneli();
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
	public YoneticiPaneli() {
		setResizable(false);
		setTitle("Y\u00F6netici Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1235, 736);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(8, 10, 188, 679);
		contentPane.add(panel);
		
		JButton btnNewButton_3_1_1 = new JButton("Geri", null);
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//YoneticiPaneli.this.setVisible(false);
				
				YoneticiPaneli.this.dispose();
				Ziyaretci ziyaretci=new Ziyaretci();
				ziyaretci.setVisible(true);
			}
		});
		btnNewButton_3_1_1.setForeground(Color.BLACK);
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3_1_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1.setBounds(8, 635, 172, 34);
		panel.add(btnNewButton_3_1_1);
		Icon gphy=new ImageIcon("iconsimages/giphy.gif");
		JButton btnNewButton_4 = new JButton(gphy);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(8, 10, 172, 204);
		panel.add(btnNewButton_4);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(204, 181, 1009, 508);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 107, 993, 375);
		panel_2.add(scrollPane_1);
		
		JList listele = new JList();
		scrollPane_1.setViewportView(listele);
		listele.setBackground(SystemColor.info);
		
		bultextField = new JTextField();
		bultextField.setBackground(SystemColor.info);
		bultextField.setForeground(new Color(165, 42, 42));
		bultextField.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		bultextField.setBounds(322, 12, 289, 39);
		panel_2.add(bultextField);
		bultextField.setColumns(10);
		
		JButton btnNewButton_3_1_1_1_1_5 = new JButton("\u0130sme G\u00F6re Abone Ara", null);
		btnNewButton_3_1_1_1_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(bultextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Arama Kriterini Yandaki Kutuya Yazýnýz");
				}
				else {
				listele.setListData(GirisSQL.bul(bultextField.getText()).toArray());
				
				int uyeAboneSayisi= GirisSQL.uyeAdiBulsay(bultextField.getText());
				toplamTextField.setText(Integer.toString(uyeAboneSayisi));
				}
			}
		});
		btnNewButton_3_1_1_1_1_5.setForeground(Color.BLACK);
		btnNewButton_3_1_1_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3_1_1_1_1_5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_3_1_1_1_1_5.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_1_5.setBounds(619, 15, 181, 39);
		panel_2.add(btnNewButton_3_1_1_1_1_5);
		
		JButton btnNewButton_3_1_1_1_1_5_1 = new JButton("Gazete Ad\u0131na G\u00F6re Aboneler", null);
		btnNewButton_3_1_1_1_1_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(bultextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Arama Kriterini Yandaki Kutuya Yazýnýz");
				}
				else {
				
				listele.setListData(GirisSQL.gazeteBul(bultextField.getText()).toArray());
				int gazeteAboneSayisi= GirisSQL.gazeteBulsay(bultextField.getText());
				toplamTextField.setText(Integer.toString(gazeteAboneSayisi));
				}
			}
		});
		btnNewButton_3_1_1_1_1_5_1.setForeground(Color.BLACK);
		btnNewButton_3_1_1_1_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3_1_1_1_1_5_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_3_1_1_1_1_5_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_1_5_1.setBounds(808, 58, 193, 39);
		panel_2.add(btnNewButton_3_1_1_1_1_5_1);
		
		JButton btnNewButton_3_1_1_1_1_5_2 = new JButton("B\u00F6lgelere G\u00F6re Aboneler", null);
		btnNewButton_3_1_1_1_1_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(bultextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Arama Kriterini Yandaki Kutuya Yazýnýz");
				}
				else {
				listele.setListData(GirisSQL.bolgeBul(bultextField.getText()).toArray());
				
				
				
				int bolgeAboneSayisi= GirisSQL.bolgeBulsay(bultextField.getText());
				toplamTextField.setText(Integer.toString(bolgeAboneSayisi));
				}
			}
			
			
			
		});
		btnNewButton_3_1_1_1_1_5_2.setForeground(Color.BLACK);
		btnNewButton_3_1_1_1_1_5_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3_1_1_1_1_5_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_3_1_1_1_1_5_2.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_1_5_2.setBounds(808, 15, 193, 39);
		panel_2.add(btnNewButton_3_1_1_1_1_5_2);
		
		JButton btnNewButton_3_1_1_1_1_5_3 = new JButton("Dergi Ad\u0131na G\u00F6re Aboneler", null);
		btnNewButton_3_1_1_1_1_5_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(bultextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Arama Kriterini Yandaki Kutuya Yazýnýz");
				}
				else {
				listele.setListData(GirisSQL.dergiBul(bultextField.getText()).toArray());
				
				
				
				int dergiAboneSayisi= GirisSQL.dergiBulsay(bultextField.getText());
				toplamTextField.setText(Integer.toString(dergiAboneSayisi));
				}
			}
		});
		btnNewButton_3_1_1_1_1_5_3.setForeground(Color.BLACK);
		btnNewButton_3_1_1_1_1_5_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3_1_1_1_1_5_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_3_1_1_1_1_5_3.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_1_5_3.setBounds(619, 58, 181, 39);
		panel_2.add(btnNewButton_3_1_1_1_1_5_3);
		
		toplamTextField = new JTextField();
		toplamTextField.setText("0");
		toplamTextField.setBackground(SystemColor.inactiveCaption);
		toplamTextField.setEditable(false);
		toplamTextField.setForeground(new Color(165, 42, 42));
		toplamTextField.setFont(new Font("Tahoma", Font.BOLD, 32));
		toplamTextField.setBounds(89, 61, 53, 36);
		panel_2.add(toplamTextField);
		toplamTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Toplam");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(18, 61, 63, 36);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Kay\u0131t Bulundu.");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(150, 61, 121, 36);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Aranacak \u00DCye, B\u00F6lge, Dergi veya Gazeteyi Giriniz:");
		lblNewLabel_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(8, 15, 297, 36);
		panel_2.add(lblNewLabel_2_1_1);
		
		
		
		JButton btnNewButton_3_1_1_1_1_1 = new JButton("Bolge Listele", null);
		btnNewButton_3_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listele.setListData(BolgeSQL.bolgeListele().toArray());
			}
		});
		btnNewButton_3_1_1_1_1_1.setForeground(Color.BLACK);
		btnNewButton_3_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3_1_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_1_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_1_1.setBounds(8, 260, 94, 28);
		panel.add(btnNewButton_3_1_1_1_1_1);
		
		JButton btnNewButton_3_1_1_1_1_2 = new JButton("Gazete Listele", null);
		btnNewButton_3_1_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listele.setListData(GazeteSQL.gazeteListele().toArray());
			}
		});
		btnNewButton_3_1_1_1_1_2.setForeground(Color.BLACK);
		btnNewButton_3_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3_1_1_1_1_2.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_1_2.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_1_2.setBounds(8, 298, 94, 31);
		panel.add(btnNewButton_3_1_1_1_1_2);
		
		JButton btnNewButton_3_1_1_1_1_3 = new JButton("Dergi Listele", null);
		btnNewButton_3_1_1_1_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listele.setListData(DergiSQL.dergiListele().toArray());
			}
		});
		btnNewButton_3_1_1_1_1_3.setForeground(Color.BLACK);
		btnNewButton_3_1_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3_1_1_1_1_3.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_1_3.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_1_3.setBounds(8, 339, 94, 28);
		panel.add(btnNewButton_3_1_1_1_1_3);
		
		JButton btnNewButton_3_1_1_1_1_4 = new JButton("\u00DCye Sil", null);
		btnNewButton_3_1_1_1_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			GirisDomain silinecekKisiDomain =(GirisDomain)listele.getSelectedValue();
				if(silinecekKisiDomain!=null) {
					int n=JOptionPane.showConfirmDialog(null, "Üyeyi Silmek Ýstediðine Emin Misin?","UYARI !!", JOptionPane.YES_NO_OPTION);
					if(n==0) {
						GirisSQL.kisiSil(silinecekKisiDomain);
						listele.setListData(GirisSQL.uyeleriListele().toArray());					
					}
					else {						
						}					
				}	
				else {JOptionPane.showMessageDialog(null," Silinecek Üye seçilmedi");}
				
			}
		});
		btnNewButton_3_1_1_1_1_4.setForeground(new Color(165, 42, 42));
		btnNewButton_3_1_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3_1_1_1_1_4.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_1_4.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_1_4.setBounds(110, 547, 70, 34);
		panel.add(btnNewButton_3_1_1_1_1_4);
		
		JButton btnNewButton_3_1_1_1_1_4_1 = new JButton("Sil", null);
		
		
		btnNewButton_3_1_1_1_1_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				BolgeDomain silinecekKisiDomain =(BolgeDomain)listele.getSelectedValue();
				if(silinecekKisiDomain!=null) {
					int n=JOptionPane.showConfirmDialog(null, "Bolgeyi Silmek Ýstediðine Emin Misin?","UYARI !!", JOptionPane.YES_NO_OPTION);
					if(n==0) {
						BolgeSQL.bolgesil(silinecekKisiDomain);
						listele.setListData(BolgeSQL.bolgeListele().toArray());					
					}
					else {						
						}					
				}	
				else {JOptionPane.showMessageDialog(null," Silinecek Bölge seçilmedi");}
			}
		});
		
		
		btnNewButton_3_1_1_1_1_4_1.setForeground(new Color(165, 42, 42));
		btnNewButton_3_1_1_1_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3_1_1_1_1_4_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_1_4_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_1_4_1.setBounds(110, 260, 70, 28);
		panel.add(btnNewButton_3_1_1_1_1_4_1);
		
		JButton btnNewButton_3_1_1_1_1_4_2 = new JButton("Sil", null);
		btnNewButton_3_1_1_1_1_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			GazeteDomain silinecekKisiDomain =(GazeteDomain)listele.getSelectedValue();
			if(silinecekKisiDomain!=null) {
				int n=JOptionPane.showConfirmDialog(null, "Gazeteyi Silmek Ýstediðine Emin Misin?","UYARI !!", JOptionPane.YES_NO_OPTION);
				if(n==0) {
					GazeteSQL.gazeteSil(silinecekKisiDomain);
					listele.setListData(GazeteSQL.gazeteListele().toArray());					
				}
				else {						
					}					
			}	
			else {JOptionPane.showMessageDialog(null," Silinecek Gazete seçilmedi");}}
		});
		
		
		btnNewButton_3_1_1_1_1_4_2.setForeground(new Color(165, 42, 42));
		btnNewButton_3_1_1_1_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3_1_1_1_1_4_2.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_1_4_2.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_1_4_2.setBounds(110, 299, 70, 28);
		panel.add(btnNewButton_3_1_1_1_1_4_2);
		
		JButton btnNewButton_3_1_1_1_1_4_3 = new JButton("Sil", null);
		btnNewButton_3_1_1_1_1_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DergiDomain silinecekKisiDomain =(DergiDomain)listele.getSelectedValue();
				if(silinecekKisiDomain!=null) {
					int n=JOptionPane.showConfirmDialog(null, "Dergiyi Silmek Ýstediðine Emin Misin?","UYARI !!", JOptionPane.YES_NO_OPTION);
					if(n==0) {
						DergiSQL.dergisil(silinecekKisiDomain);
						listele.setListData(DergiSQL.dergiListele().toArray());					
					}
					else {						
						}					
				}	
				else {JOptionPane.showMessageDialog(null," Silinecek Dergi seçilmedi");}
				
				
			}
		});
		btnNewButton_3_1_1_1_1_4_3.setForeground(new Color(165, 42, 42));
		btnNewButton_3_1_1_1_1_4_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3_1_1_1_1_4_3.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_1_4_3.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_1_4_3.setBounds(110, 339, 70, 28);
		panel.add(btnNewButton_3_1_1_1_1_4_3);
		
		JButton btnNewButton_3_1_1_1_2_1 = new JButton("Abonelik Talep G\u00F6r", null);
		btnNewButton_3_1_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(GirisSQL.onaysizTalepGor("Henüz").toString().equals("[]"))
				{
					JOptionPane.showMessageDialog(null,"Onaylanmamýþ Abonelik Talebi Bulunmamaktadýr.");
				}
				
				else {
				listele.setListData(GirisSQL.onaysizTalepGor("Henüz").toArray());}
				
				//listele.setListData(GirisSQL.bul(bultextField.getText()).toArray());
			}
		});
		btnNewButton_3_1_1_1_2_1.setForeground(Color.BLUE);
		btnNewButton_3_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3_1_1_1_2_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_2_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_2_1.setBounds(8, 459, 172, 34);
		panel.add(btnNewButton_3_1_1_1_2_1);
		
		JButton btnNewButton_3_1_1_1_2_2 = new JButton("Abonelik Talep Onayla", null);
		btnNewButton_3_1_1_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					GirisDomain duzenlecekKisiDomain =(GirisDomain) listele.getSelectedValue();
					if(duzenlecekKisiDomain!=null) {
						duzenlecekKisiDomain.setOnayDurum("onaylandý");
						
						
						GirisSQL.abonelikOnayla(duzenlecekKisiDomain);
						
						listele.setListData(GirisSQL.uyeleriListele().toArray());
						
						
					}else
					{JOptionPane.showMessageDialog(null," Onaylanacak Abonelik seçilmedi");
					
					
					}
					
				}
				}
			
				
				
				
			
			
			
			
		});
		btnNewButton_3_1_1_1_2_2.setForeground(new Color(0, 128, 0));
		btnNewButton_3_1_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3_1_1_1_2_2.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_2_2.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_2_2.setBounds(8, 503, 172, 34);
		panel.add(btnNewButton_3_1_1_1_2_2);
		
		JLabel lblNewLabel_1 = new JLabel("Abonelik \u0130\u015Flemleri");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(8, 436, 172, 13);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_3_1_1_1_2_2_1 = new JButton("Talep Onay Kald\u0131r", null);
		btnNewButton_3_1_1_1_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					GirisDomain duzenlecekKisiDomain =(GirisDomain) listele.getSelectedValue();
					if(duzenlecekKisiDomain!=null) {
						duzenlecekKisiDomain.setOnayDurum("Henüz Onaylanmadý");
						
						
						GirisSQL.abonelikOnayla(duzenlecekKisiDomain);
						
						listele.setListData(GirisSQL.uyeleriListele().toArray());
						
						
					}else
					{JOptionPane.showMessageDialog(null," Onaylanacak Abonelik seçilmedi");
					
					
					}
					
				}
			}
		});
		btnNewButton_3_1_1_1_2_2_1.setForeground(new Color(165, 42, 42));
		btnNewButton_3_1_1_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3_1_1_1_2_2_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_2_2_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_2_2_1.setBounds(8, 591, 172, 34);
		panel.add(btnNewButton_3_1_1_1_2_2_1);
		
		JButton btnNewButton_3_1_1_1_2_1_1 = new JButton("\u00DCye Listele", null);
		btnNewButton_3_1_1_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listele.setListData(GirisSQL.uyeleriListele().toArray());
			}
		});
		btnNewButton_3_1_1_1_2_1_1.setForeground(Color.BLUE);
		btnNewButton_3_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3_1_1_1_2_1_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_2_1_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_2_1_1.setBounds(8, 547, 94, 34);
		panel.add(btnNewButton_3_1_1_1_2_1_1);
		
		Icon cnws=new ImageIcon("iconsimages/newspaper.jpg");
		
		
		Icon npaper=new ImageIcon("iconsimages/newspaper.jpg");
		
	
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(242, 38, 939, 133);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.inactiveCaption);
		
		
		
		Icon ikonGff = new ImageIcon("iconsimages/nwsppr.gif"); 
		setLocationRelativeTo(null);
		
		
		
		
		JButton btnNewButton_2 = new JButton("Ekle");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bolgeField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Eklenecek Bölgeyi Yazýnýz");
				}
				else {
				
				try {				    	  
			    	BolgeDomain eklenecekdergi=new BolgeDomain();
			    	 eklenecekdergi.setBolge(bolgeField.getText());			    	 							
						BolgeSQL.ekle_bolge(eklenecekdergi);
						
						JOptionPane.showMessageDialog(null,"Kayýt Baþarýlý");
						bolgeField.setText("");
						
			      }
				 catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null,"Baglanti Hatasi");						
				}
				
				
				
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(639, 96, 282, 25);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Ekle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dergiField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Eklenecek Dergiyi Yazýnýz");
				}
				else {
				
				try {				    	  
			    	 DergiDomain eklenecekdergi=new DergiDomain();
			    	 eklenecekdergi.setDergi(dergiField.getText());			    	 							
						DergiSQL.dergiEkle(eklenecekdergi);
						
						JOptionPane.showMessageDialog(null,"Kayýt Baþarýlý");
						dergiField.setText("");
						
			      }
				 catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null,"Baglanti Hatasi");						
				}
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(311, 96, 298, 25);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gazeteField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Eklenecek Gazeteyi Yazýnýz");
				}
				else {
				
				try {				    	  
			    	  GazeteDomain eklenecekgazete=new GazeteDomain();
			    	  eklenecekgazete.setGazete(gazeteField.getText());			    	 							
						GazeteSQL.gazeteEkle(eklenecekgazete);
						
						JOptionPane.showMessageDialog(null,"Kayýt Baþarýlý");
						gazeteField.setText("");
						
			      }
				 catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null,"Baglanti Hatasi");						
				}
				
				
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(22, 96, 258, 25);
		panel_1.add(btnNewButton);
		
		gazeteField = new JTextField();
		gazeteField.setBackground(SystemColor.info);
		gazeteField.setFont(new Font("Tahoma", Font.BOLD, 18));
		gazeteField.setColumns(10);
		gazeteField.setBounds(22, 53, 258, 33);
		panel_1.add(gazeteField);
		
		JLabel lblNewLabel = new JLabel("Gazete Ekle");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(68, 10, 191, 33);
		panel_1.add(lblNewLabel);
		
		JLabel lblBlgeEkle = new JLabel("Dergi Ekle");
		lblBlgeEkle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlgeEkle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBlgeEkle.setBounds(349, 10, 191, 33);
		panel_1.add(lblBlgeEkle);
		
		dergiField = new JTextField();
		dergiField.setBackground(SystemColor.info);
		dergiField.setFont(new Font("Tahoma", Font.BOLD, 18));
		dergiField.setColumns(10);
		dergiField.setBounds(311, 53, 298, 33);
		panel_1.add(dergiField);
		
		bolgeField = new JTextField();
		bolgeField.setBackground(SystemColor.info);
		bolgeField.setFont(new Font("Tahoma", Font.BOLD, 18));
		bolgeField.setColumns(10);
		bolgeField.setBounds(639, 53, 282, 33);
		panel_1.add(bolgeField);
		
		JLabel lblBlgeEkle_1 = new JLabel("B\u00F6lge Ekle");
		lblBlgeEkle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlgeEkle_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBlgeEkle_1.setBounds(692, 10, 191, 33);
		panel_1.add(lblBlgeEkle_1);
	}
}
