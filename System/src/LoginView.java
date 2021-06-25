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
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView extends JFrame {
	
	private Image img_logo2 = new ImageIcon(LoginView.class.getResource("ress/logoh.png")).getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
	private Image img_cashier2 = new ImageIcon(LoginView.class.getResource("ress/cashier.png")).getImage().getScaledInstance(130, 175, Image.SCALE_SMOOTH);
	private Image img_admin2 = new ImageIcon(LoginView.class.getResource("ress/admin.png")).getImage().getScaledInstance(140, 165, Image.SCALE_SMOOTH);
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginView() {
		setUndecorated(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUni = new JLabel("UNI");
		lblUni.setForeground(new Color(245, 245, 245));
		lblUni.setFont(new Font("Big John", Font.PLAIN, 50));
		lblUni.setBounds(280, 50, 124, 69);
		contentPane.add(lblUni);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(176, 10, 109, 144);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(img_logo2));
		
		JLabel lblStore = new JLabel("STORE");
		lblStore.setForeground(new Color(0, 51, 51));
		lblStore.setFont(new Font("Big John", Font.PLAIN, 50));
		lblStore.setBounds(373, 43, 209, 82);
		contentPane.add(lblStore);
		
		JLabel lblNewLabel_1 = new JLabel("Inventory system");
		lblNewLabel_1.setForeground(new Color(153, 204, 204));
		lblNewLabel_1.setFont(new Font("Big John", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(281, 92, 242, 48);
		contentPane.add(lblNewLabel_1);
		
		JPanel panelMainLog = new JPanel();
		
		panelMainLog.setBackground(SystemColor.controlHighlight);
		panelMainLog.setBounds(0, 161, 700, 289);
		contentPane.add(panelMainLog);
		panelMainLog.setLayout(null);
		
		JLabel lbladmn = new JLabel("ADMIN");
		lbladmn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to Login as Admin?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Login first = new Login();
					first.setVisible(true);
					LoginView.this.dispose();
				}}
				@Override
				public void mouseEntered(MouseEvent e) {
					lbladmn.setForeground(Color.GRAY);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lbladmn.setForeground(Color.BLACK);
				}
		});
		lbladmn.setForeground(new Color(0, 51, 51));
		lbladmn.setFont(new Font("Big John", Font.PLAIN, 23));
		lbladmn.setBounds(442, 191, 91, 29);
		panelMainLog.add(lbladmn);
		
		JLabel lbladmin = new JLabel("");
		lbladmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to Login as Admin?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Login first = new Login();
					first.setVisible(true);
					LoginView.this.dispose();
				}}
				@Override
				public void mouseEntered(MouseEvent e) {
					lbladmn.setForeground(Color.GRAY);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lbladmn.setForeground(Color.BLACK);
				}
		});
		lbladmin.setBounds(411, 66, 140, 122);
		lbladmin.setIcon(new ImageIcon(img_admin2));
		panelMainLog.add(lbladmin);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN AS:");
		lblNewLabel_2.setBounds(293, 23, 113, 24);
		lblNewLabel_2.setForeground(new Color(0, 51, 51));
		lblNewLabel_2.setFont(new Font("Big John", Font.PLAIN, 20));
		panelMainLog.add(lblNewLabel_2);
		
		
		JLabel lblCash = new JLabel("CASHIER");
		lblCash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to Login as Cashier?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Login first = new Login();
					first.setVisible(true);
					LoginView.this.dispose();
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

		JLabel lblCashier = new JLabel("");
		lblCashier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to Login as Cashier?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Login2 first = new Login2();
					//panelADMIN pan = new panelADMIN();
					//pan.setVisible(true);
					first.setVisible(true);
					LoginView.this.dispose();
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

		lblCashier.setBounds(149, 51, 130, 137);
		lblCashier.setIcon(new ImageIcon(img_cashier2));
		panelMainLog.add(lblCashier);
		
		lblCash.setForeground(new Color(0, 51, 51));
		lblCash.setFont(new Font("Big John", Font.PLAIN, 23));
		lblCash.setBounds(159, 191, 108, 29);
		panelMainLog.add(lblCash);
		
		JPanel panelCashier = new JPanel();
		panelCashier.setBorder(null);
		panelCashier.setBackground(SystemColor.controlHighlight);
		panelCashier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to Login as Cashier?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Login first = new Login();
					first.setVisible(true);
					LoginView.this.dispose();
				}
			}
		});
		panelCashier.setBounds(145, 66, 140, 156);
		panelMainLog.add(panelCashier);
		
		JPanel panelAdmin = new JPanel();
		panelAdmin.setBorder(null);
		panelAdmin.setBackground(SystemColor.controlHighlight);
		panelAdmin.setBounds(421, 57, 130, 171);
		panelMainLog.add(panelAdmin);
		
		JLabel CloseButton = new JLabel("CLOSE");
		CloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		CloseButton.setForeground(Color.BLACK);
		CloseButton.setFont(new Font("Arial Black", Font.BOLD, 16));
		CloseButton.setBounds(620, 0, 80, 41);
		contentPane.add(CloseButton);
		setLocationRelativeTo(null);
	
	}	
}
