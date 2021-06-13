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

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.JLayeredPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login2 extends JFrame {
	
	//To insert images
	private Image img_logo = new ImageIcon(Login2.class.getResource("ress/logoh.png")).getImage().getScaledInstance(140, 170, Image.SCALE_SMOOTH);
	//private Image img_cashier = new ImageIcon(Login2.class.getResource("ress/cashier.png")).getImage().getScaledInstance(120, 170, Image.SCALE_SMOOTH);
	private Image img_cashier = new ImageIcon(Login2.class.getResource("ress/cashier.png")).getImage().getScaledInstance(120, 170, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login2 frame = new Login2();
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
		contentPane.setBackground(new Color(51, 153, 153));
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
		
		
		JLabel lblcashier = new JLabel("CASHIER");
		lblcashier.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null, "Do you want to switch to admin?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
						Login first = new Login();
						first.setVisible(true);
						Login2.this.dispose();
					}
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lblcashier.setForeground(Color.GRAY);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblcashier.setForeground(Color.BLACK);
			}});
		lblcashier.setForeground(new Color(0, 51, 51));
		lblcashier.setFont(new Font("Big John", Font.PLAIN, 23));
		lblcashier.setBounds(136, 164, 115, 29);
		panelMain.add(lblcashier);
		
		JLabel lblcash = new JLabel("");
		lblcash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to switch to admin?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Login first = new Login();
					first.setVisible(true);
					Login2.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblcashier.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblcashier.setForeground(Color.BLACK);
			
			}});
		lblcash.setBounds(126, 28, 140, 132);
		panelMain.add(lblcash);
		lblcash.setIcon(new ImageIcon(img_cashier));
		
		JPanel panel = new JPanel();
		panel.setBounds(272, 62, 244, 47);
		panelMain.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 0, 56, 47);
		panel.add(panel_2);
		
		txtUsername = new JTextField();
		txtUsername.setBackground(SystemColor.menu);
		txtUsername.addFocusListener(new FocusAdapter() {
			//Place holder for showing the username and password inside the JtextField
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				} else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals(""))
					txtUsername.setText("Username");
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUsername.setText("Username");
		txtUsername.setBounds(64, 0, 170, 47);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(272, 119, 244, 47);
		panelMain.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(0, 102, 102));
		panel_2_1.setBounds(0, 0, 56, 47);
		panel_1.add(panel_2_1);
		
		//To change the default echochar in JPassword Field.
				txtPassword = new JPasswordField();
				txtPassword.setBackground(SystemColor.menu);
				txtPassword.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						if(txtPassword.getText().equals("Password")) { 
							txtPassword.setEchoChar('*');//can also be changed to bullet
							txtPassword.setText("");
						} else {
							txtPassword.selectAll();
						}
					}
					@Override
					public void focusLost(FocusEvent e) {
						if(txtPassword.getText().equals("")) {
							txtPassword.setText("Password");
							txtPassword.setEchoChar((char)0);//So that the password will default to text
						}
					}
				});
				txtPassword.setBorder(null);
				txtPassword.setEchoChar((char)0);
				txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtPassword.setText("Password");
				txtPassword.setBounds(64, 0, 170, 47);
				panel_1.add(txtPassword);
		
		JLabel lblNewLabel_2 = new JLabel("SIGN IN:");
		lblNewLabel_2.setForeground(new Color(0, 51, 51));
		lblNewLabel_2.setFont(new Font("Big John", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(351, 28, 91, 24);
		panelMain.add(lblNewLabel_2);
		
		JLabel lblLoginMessage = new JLabel("");
		lblLoginMessage.setForeground(new Color(204, 0, 0));
		lblLoginMessage.setFont(new Font("Arial", Font.PLAIN, 10));
		lblLoginMessage.setBounds(272, 164, 250, 21);
		panelMain.add(lblLoginMessage);
		setLocationRelativeTo(null);
		
		JPanel panelLoginBtn = new JPanel();
		panelLoginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				String user = txtUsername.getText();
				String pass = txtPassword.getText();
				
				if(user.equals("asd") && pass.equals("asdf")) {
					JOptionPane.showMessageDialog(null, "Login Successful!");
					DashboardView dv = new DashboardView();
					dv.setVisible(true);
					Login2.this.dispose();
				}
				else if(user.equals("Cashier1") && pass.equals("cash123") || user.equals("Cashier2") && pass.equals("cash456")) {
					JOptionPane.showMessageDialog(null, "Please input all requirements!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Username and Password didn't match!");
				}
			}
					//Hovering buttons
					@Override
					public void mouseEntered(MouseEvent e) {
						panelLoginBtn.setBackground(new Color(20, 130, 130));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						panelLoginBtn.setBackground(new Color(51, 153, 153));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						panelLoginBtn.setBackground(new Color(80, 183, 183));
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						panelLoginBtn.setBackground(new Color(20, 130, 130));
					}});
		panelLoginBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLoginBtn.setBackground(new Color(51, 153, 153));
		panelLoginBtn.setBounds(417, 188, 101, 47);
		panelMain.add(panelLoginBtn);
		panelLoginBtn.setLayout(null);
		
		JLabel lblLogin2 = new JLabel("LOG IN");
		lblLogin2.setBounds(0, 10, 101, 27);
		panelLoginBtn.add(lblLogin2);
		lblLogin2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panelBack = new JPanel();
		panelBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					LoginView first = new LoginView();
					first.setVisible(true);
					Login2.this.dispose();
				}}
				//Hovering buttons
				@Override
				public void mouseEntered(MouseEvent e) {
					panelBack.setBackground(new Color(0, 70, 70));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					panelBack.setBackground(new Color(0, 102, 102));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					panelBack.setBackground(new Color(30, 133, 133));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					panelBack.setBackground(new Color(0, 70, 70));
				}});
		panelBack.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBack.setBackground(new Color(0, 102, 102));
		panelBack.setBounds(272, 188, 101, 47);
		panelMain.add(panelBack);
		panelBack.setLayout(null);
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setBounds(0, 10, 101, 27);
		panelBack.add(lblBack);
		lblBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JCheckBox ShowPass = new JCheckBox("Show Password");
		ShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ShowPass.isSelected()) {
					txtPassword.setEchoChar((char)0);
				}else {
					txtPassword.setEchoChar('*');//Can be changed to bullet •
				}}
		});
		ShowPass.setFont(new Font("Tahoma", Font.PLAIN, 8));
		ShowPass.setBackground(SystemColor.controlHighlight);
		ShowPass.setBounds(439, 168, 152, 13);
		panelMain.add(ShowPass);
		
		
	
		
	}
}
