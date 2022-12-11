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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PersonelPaneli extends JFrame {

	private JPanel contentPane;
	private JTextField bultextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonelPaneli frame = new PersonelPaneli();
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
	public PersonelPaneli() {
		setResizable(false);
		setTitle("Y\u00F6netici Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1235, 692);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(8, 10, 176, 635);
		contentPane.add(panel);
		
		JButton btnNewButton_3_1_1 = new JButton("Geri", null);
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//YoneticiPaneli.this.setVisible(false);
				
				PersonelPaneli.this.dispose();
				Ziyaretci ziyaretci=new Ziyaretci();
				ziyaretci.setVisible(true);
			}
		});
		btnNewButton_3_1_1.setForeground(Color.BLACK);
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3_1_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1.setBounds(8, 591, 160, 34);
		panel.add(btnNewButton_3_1_1);
		Icon gphy=new ImageIcon("iconsimages/giphy.gif");
		JButton btnNewButton_4 = new JButton(gphy);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(8, 10, 160, 204);
		panel.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(192, 10, 1021, 635);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 59, 1005, 566);
		panel_2.add(scrollPane_1);
		
		JList listele = new JList();
		scrollPane_1.setViewportView(listele);
		listele.setBackground(SystemColor.info);
		
		bultextField = new JTextField();
		bultextField.setBackground(SystemColor.info);
		bultextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				listele.setListData(GirisSQL.bul(bultextField.getText()).toArray());
				
			}
		});
		bultextField.setForeground(new Color(165, 42, 42));
		bultextField.setFont(new Font("Tahoma", Font.BOLD, 31));
		bultextField.setBounds(8, 10, 795, 39);
		panel_2.add(bultextField);
		bultextField.setColumns(10);
		
		JButton btnNewButton_3_1_1_1_1_5 = new JButton("Ara", null);
		btnNewButton_3_1_1_1_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listele.setListData(GirisSQL.bul(bultextField.getText()).toArray());
			}
		});
		btnNewButton_3_1_1_1_1_5.setForeground(Color.BLACK);
		btnNewButton_3_1_1_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3_1_1_1_1_5.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_1_5.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_1_5.setBounds(811, 10, 202, 39);
		panel_2.add(btnNewButton_3_1_1_1_1_5);
		
		JButton btnNewButton_3_1_1_1_1 = new JButton("\u00DCye Listele", null);
		btnNewButton_3_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listele.setListData(GirisSQL.uyeleriListele().toArray());
			}
		});
		btnNewButton_3_1_1_1_1.setForeground(Color.BLACK);
		btnNewButton_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_1.setBounds(8, 224, 160, 34);
		panel.add(btnNewButton_3_1_1_1_1);
		
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
		btnNewButton_3_1_1_1_1_1.setBounds(8, 268, 160, 34);
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
		btnNewButton_3_1_1_1_1_2.setBounds(8, 312, 160, 34);
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
		btnNewButton_3_1_1_1_1_3.setBounds(8, 356, 160, 34);
		panel.add(btnNewButton_3_1_1_1_1_3);
		
		JButton btnNewButton_3_1_1_1_2_1 = new JButton("Onays\u0131z Talep G\u00F6r", null);
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
		btnNewButton_3_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3_1_1_1_2_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_2_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_2_1.setBounds(8, 468, 160, 31);
		panel.add(btnNewButton_3_1_1_1_2_1);
		
		JButton btnNewButton_3_1_1_1_2_2 = new JButton("Talep Onayla", null);
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
					
				}}
			
				
				
				
			
			
			
			
		});
		btnNewButton_3_1_1_1_2_2.setForeground(new Color(0, 128, 0));
		btnNewButton_3_1_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3_1_1_1_2_2.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1_1_2_2.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1_1_2_2.setBounds(8, 506, 160, 31);
		panel.add(btnNewButton_3_1_1_1_2_2);
		
		JLabel lblNewLabel_1 = new JLabel("Abonelik \u0130\u015Flemleri");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(8, 434, 160, 13);
		panel.add(lblNewLabel_1);
		
		Icon cnws=new ImageIcon("iconsimages/newspaper.jpg");
		
		
		Icon npaper=new ImageIcon("iconsimages/newspaper.jpg");
		
	
		
		
		
		
		Icon ikonGff = new ImageIcon("iconsimages/nwsppr.gif"); 
		setLocationRelativeTo(null);
	}
}
