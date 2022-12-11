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

import YayinDbDa.GirisSQL;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdminGiris extends JFrame {

	private JPanel contentPane;
	private JTextField pTextField;
	public String kullanici;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGiris frame = new AdminGiris();
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
	public AdminGiris() {
		setTitle("Kullan\u0131c\u0131 Giri\u015Fi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1163, 692);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(8, 10, 163, 635);
		contentPane.add(panel_1);
		
		JButton btnNewButton_3_1_1 = new JButton("Geri", null);
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				AdminGiris.this.dispose();
				Ziyaretci ziyaretci=new Ziyaretci();
				ziyaretci.setVisible(true);
			}
		});
		btnNewButton_3_1_1.setForeground(Color.BLACK);
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3_1_1.setBorder(new LineBorder(new Color(0, 0, 128)));
		btnNewButton_3_1_1.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton_3_1_1.setBounds(12, 592, 143, 33);
		panel_1.add(btnNewButton_3_1_1);
		
		Icon icon=new ImageIcon("iconsimages/logingf.gif");
		
		
		
		JButton btnNewButton_2 = new JButton(icon);
		btnNewButton_2.setBounds(8, 10, 147, 229);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(463, 240, 357, 158);
		contentPane.add(panel);
		panel.setLayout(null);
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.info);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"admin", "personel"}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setBounds(154, 10, 190, 42);
		panel.add(comboBox);
		JButton btnNewButton = new JButton("Giri\u015F");
		btnNewButton.setBounds(8, 114, 336, 36);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				
				 
			
				
				if (comboBox.getSelectedItem().equals("admin") & pTextField.getText().equals("1")) 
					{
					 JOptionPane.showMessageDialog(null,"Öncelikle, Yayýn/Bölge Ekle Sekmesinden --> Gazete Seçilmedi ve Dergi Seçilmedi Seçeneðini Ekleyiniz --> Daha Sonra Yayýn Eklemesi Yapabilirsiniz...!!! NOT: Ekleme Yaptýysanýz Uyarýyý Dikkate Almayýnýz...");
					 AdminGiris.this.dispose();
						YoneticiPaneli yon=new YoneticiPaneli();
						yon.setVisible(true);
									
					}
				
				
				else if(comboBox.getSelectedItem().equals("personel") & pTextField.getText().equals("1")) {
					
					 AdminGiris.this.dispose();
						PersonelPaneli yon=new PersonelPaneli();
						yon.setVisible(true);
					
					
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
		pTextField.setBackground(SystemColor.info);
		pTextField.setBounds(154, 62, 190, 42);
		panel.add(pTextField);
		pTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		pTextField.setColumns(10);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setBounds(8, 62, 138, 42);
		panel.add(lblParola);
		lblParola.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131");
		lblKullancAd.setBounds(8, 10, 138, 42);
		panel.add(lblKullancAd);
		lblKullancAd.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel = new JLabel("NOT: Admin \u015Fifresi 1 Personel \u015Eifresi 1");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(236, 611, 227, 13);
		contentPane.add(lblNewLabel);
		
		
		
		
		
	}
}
