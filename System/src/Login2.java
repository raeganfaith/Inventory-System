import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class Login2 extends JFrame {
	
	//To insert images
	private Image img_logo = new ImageIcon(Login2.class.getResource("ress/logoh.png")).getImage().getScaledInstance(140, 170, Image.SCALE_SMOOTH);
	private Image img_cashier = new ImageIcon(Login2.class.getResource("ress/cashier.png")).getImage().getScaledInstance(120, 170, Image.SCALE_SMOOTH);
	private Image img_admin = new ImageIcon(Login2.class.getResource("ress/admin.png")).getImage().getScaledInstance(130, 160, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private PanelCashier PanelCashier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login2() {
		setUndecorated(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel CloseButton = new JLabel("X");
		CloseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Login2.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				CloseButton.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				CloseButton.setForeground(Color.BLACK);
			
			}
		});
		CloseButton.setForeground(new Color(0, 0, 0));
		CloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		CloseButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		CloseButton.setBounds(680, 0, 20, 20);
		contentPane.add(CloseButton);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setBounds(124, 2, 148, 186);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel lblStore = new JLabel("STORE");
		lblStore.setForeground(new Color(0, 51, 51));
		lblStore.setFont(new Font("Big John", Font.PLAIN, 57));
		lblStore.setBounds(379, 60, 209, 82);
		contentPane.add(lblStore);
		
		JLabel lblUni = new JLabel("UNI");
		lblUni.setForeground(new Color(245, 245, 245));
		lblUni.setFont(new Font("Big John", Font.PLAIN, 57));
		lblUni.setBounds(272, 65, 124, 72);
		contentPane.add(lblUni);
		
		JLabel lblNewLabel_1 = new JLabel("Inventory system");
		lblNewLabel_1.setForeground(new Color(153, 204, 204));
		lblNewLabel_1.setFont(new Font("Big John", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(282, 112, 242, 48);
		contentPane.add(lblNewLabel_1);
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(SystemColor.controlHighlight);
		panelMain.setBounds(0, 191, 700, 259);
		contentPane.add(panelMain);
		panelMain.setLayout(null);
		
		
		
		
		JLabel lblCash = new JLabel("CASHIER");
		lblCash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Login2.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCash.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCash.setForeground(Color.BLACK);
			}
		});
		lblCash.setForeground(new Color(0, 51, 51));
		lblCash.setFont(new Font("Big John", Font.PLAIN, 23));
		lblCash.setBounds(156, 179, 108, 29);
		panelMain.add(lblCash);
		
		JLabel lbladmn = new JLabel("ADMIN");
		lbladmn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
						Login2.this.dispose();
					}
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lbladmn.setForeground(Color.GRAY);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lbladmn.setForeground(Color.BLACK);
			}});
		lbladmn.setForeground(new Color(0, 51, 51));
		lbladmn.setFont(new Font("Big John", Font.PLAIN, 23));
		lbladmn.setBounds(462, 179, 91, 29);
		panelMain.add(lbladmn);
		
		JLabel lbladmin = new JLabel("");
		lbladmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Login2.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbladmn.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbladmn.setForeground(Color.BLACK);
			
			}});
		lbladmin.setBounds(432, 50, 140, 123);
		panelMain.add(lbladmin);
		lbladmin.setIcon(new ImageIcon(img_admin));//setIcon
		
		
		
		JLabel lblNewLabel = new JLabel("LOGIN AS:");
		lblNewLabel.setForeground(new Color(0, 51, 51));
		lblNewLabel.setFont(new Font("Big John", Font.PLAIN, 25));
		lblNewLabel.setBounds(286, 10, 140, 40);
		panelMain.add(lblNewLabel);
		setLocationRelativeTo(null);
	
		
	}
}
