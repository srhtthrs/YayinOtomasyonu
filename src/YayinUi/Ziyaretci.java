package YayinUi;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.AWTException;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.border.LineBorder;

import YayinDbDa.BolgeSQL;
import YayinDbDa.DergiSQL;
import YayinDbDa.GazeteSQL;
import YayinDbDa.GirisSQL;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.border.SoftBevelBorder;

public class Ziyaretci extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ziyaretci frame = new Ziyaretci();
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
	public Ziyaretci() {
		
		
		BufferedImage image = null;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		} catch (HeadlessException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (AWTException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			ImageIO.write(image, "png", new File("/screenshot.png"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		setTitle("Gazete Dergi Otomasyonu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1163, 692);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(8, 10, 185, 635);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnyeOl = new JButton("\u00DCye Ol");
		btnyeOl.setForeground(Color.BLACK);
		btnyeOl.setBackground(UIManager.getColor("CheckBox.background"));
		btnyeOl.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnyeOl.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnyeOl.setBounds(8, 549, 169, 33);
		panel.add(btnyeOl);
		
		
		
		JButton btnNewButton = new JButton("\u00DCye Giri\u015Fi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ziyaretci.this.setVisible(false);
				GirisPaneli yonUyeGiris=new GirisPaneli();
				yonUyeGiris.setVisible(true);
				
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(8, 506, 169, 33);
		panel.add(btnNewButton);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(494, 339, 331, 173);
		contentPane.add(scrollPane_2);
		
		JList listgaz = new JList();
		listgaz.setForeground(new Color(75, 0, 130));
		listgaz.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		scrollPane_2.setViewportView(listgaz);
		listgaz.setBackground(SystemColor.activeCaption);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(833, 339, 297, 173);
		contentPane.add(scrollPane_3);
		
		
		JList listDer = new JList();
		listDer.setForeground(new Color(75, 0, 130));
		listDer.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		scrollPane_3.setViewportView(listDer);
		listDer.setBackground(SystemColor.activeCaption);
		
		ImageIcon ikonGz = new ImageIcon("iconsimages/ne.png"); 
		Image imageGz = ikonGz.getImage();
		Image newimgGz = imageGz.getScaledInstance(25, 25,  java.awt.Image.SCALE_AREA_AVERAGING); 
		ImageIcon newImageIconGz = new ImageIcon(newimgGz);
		
		
		ImageIcon ikonCik = new ImageIcon("iconsimages/cikis.png"); 
		Image imageCik = ikonCik.getImage();
		Image newimgCik = imageCik.getScaledInstance(25, 25,  java.awt.Image.SCALE_AREA_AVERAGING); 
		ImageIcon newImageIconCik = new ImageIcon(newimgCik);
		
		Icon ikonGf2 = new ImageIcon("iconsimages/991p.gif"); 	
		JButton btnNewButton_3 = new JButton(ikonGf2);
		btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_3.setBounds(8, 10, 169, 285);
		panel.add(btnNewButton_3);
		
		JButton btnAdmin_1 = new JButton("Admin");
		btnAdmin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ziyaretci.this.setVisible(false);
				AdminGiris yonUyeGiris=new AdminGiris();
				yonUyeGiris.setVisible(true);
				
			}
		});
		btnAdmin_1.setForeground(Color.BLACK);
		btnAdmin_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdmin_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAdmin_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnAdmin_1.setBounds(8, 592, 169, 33);
		panel.add(btnAdmin_1);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		

		
		
		
			
	
		
		
		ImageIcon ikonGaz = new ImageIcon("iconsimages/newspaper.jpg"); 
		Image imageGaz = ikonGaz.getImage();
		Image newimgGaz = imageGaz.getScaledInstance(350, 300,  java.awt.Image.SCALE_AREA_AVERAGING); 
		ImageIcon newImageIconGaz = new ImageIcon(newimgGaz); 					
		JButton btnNewButton_1 = new JButton(newImageIconGaz);
		btnNewButton_1.setBounds(494, 10, 331, 264);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_1);
		
		ImageIcon ikonDer = new ImageIcon("iconsimages/dergi.jpg"); 
		Image imageDer = ikonDer.getImage();
		Image newimgDer = imageDer.getScaledInstance(400, 300,  java.awt.Image.SCALE_AREA_AVERAGING); 
		ImageIcon newImageIconDer = new ImageIcon(newimgDer);
		 	
		JButton btnNewButton_1_1 = new JButton(newImageIconDer);
		btnNewButton_1_1.setBounds(833, 10, 308, 264);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnNewButton_1_1);
		
		
		
	
		
		
		ImageIcon ikonBol = new ImageIcon("iconsimages/bolges.jpg"); 
		Image image2 = ikonBol.getImage();
		Image newimg = image.getScaledInstance(280, 300,  java.awt.Image.SCALE_AREA_AVERAGING); 
		ImageIcon newImageIcon = new ImageIcon(newimg); 	
		JButton btnNewButton_1_2 = new JButton(newImageIcon);
		btnNewButton_1_2.setBounds(201, 10, 285, 264);
		btnNewButton_1_2.setToolTipText("Detay \u0130\u00E7in T\u0131klay\u0131n\u0131z");
		
		btnNewButton_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler iconsimages\\istDetay.pdf");
				} catch (IOException e1) {
					
					JOptionPane.showMessageDialog(null,"Check File Please");
				}
				
			}
		});
		contentPane.add(btnNewButton_1_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(199, 520, 931, 125);
		panel_1_3.setBackground(SystemColor.activeCaption);
		contentPane.add(panel_1_3);
		panel_1_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sisteme \u00FCye olarak, yay\u0131n aboneli\u011Finizi ba\u015Flatabilirsiniz.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel.setBounds(8, 10, 487, 31);
		panel_1_3.add(lblNewLabel);
		
		JLabel lblNewLabel2 = new JLabel("Y\u00F6netici onay\u0131ndan sonra abonelik i\u015Fleminiz tamamlanacakt\u0131r. ");
		lblNewLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel2.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel2.setBounds(8, 51, 514, 31);
		panel_1_3.add(lblNewLabel2);
		
		JLabel lblNewLabel3 = new JLabel("Abone olmadan \u00F6nce ikamet adresinizin yay\u0131n da\u011F\u0131t\u0131m\u0131 yap\u0131lan b\u00F6lgeler i\u00E7erisinde olup olmad\u0131\u011Fn\u0131 kontrol ediniz.");
		lblNewLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel3.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel3.setBounds(8, 94, 774, 31);
		panel_1_3.add(lblNewLabel3);
		
		Icon duyuru2Gf=new ImageIcon("iconsimages/duyuru1Gf.gif");
		
		Icon duyurGf=new ImageIcon("iconsimages/duyuruGf.gif");
		
		JLabel lblNewLabel_1 = new JLabel("Da\u011F\u0131t\u0131m B\u00F6lgeleri");
		lblNewLabel_1.setBackground(SystemColor.activeCaption);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblNewLabel_1.setBounds(211, 284, 275, 45);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gazeteler");
		lblNewLabel_1_1.setBackground(SystemColor.activeCaption);
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(504, 284, 295, 45);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Dergiler");
		lblNewLabel_1_2.setBackground(SystemColor.activeCaption);
		lblNewLabel_1_2.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblNewLabel_1_2.setBounds(834, 284, 296, 45);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(201, 339, 285, 173);
		contentPane.add(scrollPane_1);
		
		JList listBol = new JList();
		listBol.setForeground(new Color(75, 0, 130));
		listBol.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		scrollPane_1.setViewportView(listBol);
		listBol.setBackground(SystemColor.activeCaption);
		
		
		
		
		
		Icon ikonGf = new ImageIcon("iconsimages/nwsppr.gif");
		btnyeOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ziyaretci.this.setVisible(false);
				UyeOl ziyaretci=new UyeOl();
				ziyaretci.setVisible(true);
			}
		});
		setLocationRelativeTo(null);// prog.ortada baþlar...
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(448, 332, -292, 178);
		contentPane.add(scrollPane);
		
		listgaz.setListData(GazeteSQL.gazeteListele().toArray());
		listDer.setListData(DergiSQL.dergiListele().toArray());
		listBol.setListData(BolgeSQL.bolgeListele().toArray());
		
		
		
		
		
	}
	
	
	}

