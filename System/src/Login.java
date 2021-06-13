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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.JLayeredPane;

public class Login extends JFrame {
	  
	//To insert images
	private Image img_logo = new ImageIcon(Login.class.getResource("ress/logoh.png")).getImage().getScaledInstance(140, 170, Image.SCALE_SMOOTH);
	private Image img_admin = new ImageIcon(Login.class.getResource("ress/admin.png")).getImage().getScaledInstance(130, 160, Image.SCALE_SMOOTH); 
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblLoginMessage = new JLabel(""); 
	
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
	public Login() {
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
					Login.this.dispose();
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
		
		
		JLabel lbladmn = new JLabel("ADMIN");
		lbladmn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null, "Do you want to switch to cashier?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
						Login2 first = new Login2();
						first.setVisible(true);
						Login.this.dispose();
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
		lbladmn.setBounds(148, 170, 91, 29);
		panelMain.add(lbladmn);
		
		JLabel lbladmin = new JLabel("");
		lbladmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to switch to cashier?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Login2 first = new Login2();
					first.setVisible(true);
					Login.this.dispose();
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
		lbladmin.setBounds(122, 42, 140, 123);
		panelMain.add(lbladmin);
		lbladmin.setIcon(new ImageIcon(img_admin));
		
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
		lblLoginMessage.setBounds(272, 170, 250, 21);
		panelMain.add(lblLoginMessage);
		setLocationRelativeTo(null);
		
		JPanel panelLoginBtn = new JPanel();
		panelLoginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user;
				String pass;
				
				user = txtUsername.getText();
				pass = txtPassword.getText();
				if(user.equals("rae")&&user.equals("123") || user.equals("niel")&&user.equals("456")) {
					JOptionPane.showMessageDialog(null,"Login Successful!");
					DashboardView first = new DashboardView();
					first.setVisible(true);
					Login.this.dispose();
					//To inform the user the missing requirement
					}else if(txtUsername.equals("")&&txtPassword.equals("")) {
						lblLoginMessage.setText("Please input all requirements!");
						//If the registered user and password is different from the information being put for log in
							}else {
							lblLoginMessage.setText("Username and Password didn't match!");
							}}
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
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setBounds(0, 10, 101, 27);
		panelLoginBtn.add(lblLogIn);
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panelBackbtn = new JPanel();
		panelBackbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					
					LoginView first = new LoginView();
					first.setVisible(true);
					Login.this.dispose();
				}}
					//Hovering buttons
					@Override
					public void mouseEntered(MouseEvent e) {
						panelBackbtn.setBackground(new Color(0, 70, 70));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						panelBackbtn.setBackground(new Color(0, 102, 102));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						panelBackbtn.setBackground(new Color(30, 133, 133));
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						panelBackbtn.setBackground(new Color(0, 70, 70));
					}});
		panelBackbtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBackbtn.setBackground(new Color(0, 102, 102));
		panelBackbtn.setBounds(272, 188, 101, 47);
		panelMain.add(panelBackbtn);
		panelBackbtn.setLayout(null);
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setBounds(0, 10, 101, 27);
		panelBackbtn.add(lblBack);
		lblBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
	
		
	}
}
