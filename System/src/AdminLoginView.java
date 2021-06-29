
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

	public class AdminLoginView extends JFrame {
		
		
		private Image img_logo = new ImageIcon(AdminLoginView.class.getResource("ress/logoh.png")).getImage().getScaledInstance(140, 170, Image.SCALE_SMOOTH);
		private Image img_admin = new ImageIcon(AdminLoginView.class.getResource("ress/admin.png")).getImage().getScaledInstance(135, 160, Image.SCALE_SMOOTH);
		
		private JLabel lblIconLogo = new JLabel("");
		private JLabel lblStore = new JLabel("STORE");
		private JPanel panelMain = new JPanel();
		private JLabel lbladmn = new JLabel("ADMIN");
		private JLabel lbladmin = new JLabel("");
		private JPanel panel = new JPanel();
		private JPanel panel_2 = new JPanel();
		public JTextField userField = new JTextField();
		private JPanel panel_1 = new JPanel();
		private JPanel panel_2_1 = new JPanel();
		
		private JLabel lblNewLabel_2 = new JLabel("SIGN IN:");
		private JCheckBox ShowPass = new JCheckBox("Show Password");
		public JButton btnLogin = new JButton("LOGIN");
		public JButton btnCancelButton = new JButton("CANCEL");
		private JLabel lblNewLabel_1 = new JLabel("Inventory system");
		public JPanel prodpanel = new JPanel();
		public JPasswordField passwordField = new JPasswordField();
		public JLabel CloseButton = new JLabel("CLOSE");
		
		public static void Screen() {
			AdminLoginView frame = new AdminLoginView();
			AdminLoginModel model = new AdminLoginModel();
			AdminLoginController control = new AdminLoginController(frame, model);
			frame.setVisible(true);	
		}
		
		
	AdminLoginView(){
		setUndecorated(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450); //Frame size
		prodpanel = new JPanel();
		prodpanel.setBackground(new Color(51, 153, 153));
		prodpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(prodpanel);
		setLocationRelativeTo(null);
		prodpanel.setLayout(null);
		
		prodpanel.add(lblIconLogo,lblStore);
		prodpanel.add(panelMain,lbladmn);
		prodpanel.add(lbladmin,panel);
		prodpanel.add(panel_2,userField);
		prodpanel.add(panel_2,userField);
		prodpanel.add(panel_2,userField);
		
		
		lblIconLogo.setBounds(124, 2, 148, 186);
		prodpanel.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		
		lblStore.setForeground(new Color(0, 51, 51));
		lblStore.setFont(new Font("Big John", Font.PLAIN, 57));
		lblStore.setBounds(379, 60, 209, 82);
		prodpanel.add(lblStore);
		
		panelMain.setBackground(SystemColor.controlHighlight);
		panelMain.setBounds(0, 191, 700, 259);
		prodpanel.add(panelMain);
		panelMain.setLayout(null);
		
		lbladmn.setForeground(new Color(0, 51, 51));
		lbladmn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to switch to cashier?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					DashboardView first = new DashboardView();
					first.setVisible(true);
					AdminLoginView.this.dispose();
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
		
		lbladmn.setFont(new Font("Big John", Font.PLAIN, 23));
		lbladmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to switch to cashier?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					DashboardView first = new DashboardView();
					first.setVisible(true);
					AdminLoginView.this.dispose();
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
		
		lbladmn.setBounds(148, 170, 91, 29);
		panelMain.add(lbladmn);
		
		lbladmin.setBounds(122, 42, 140, 123);
		panelMain.add(lbladmin);
		lbladmin.setIcon(new ImageIcon(img_admin));
		
		panel.setBounds(272, 62, 244, 47);
		panelMain.add(panel);
		panel.setLayout(null);
		
		panel_2.setBackground(new Color(51, 153, 153));
		panel_2.setBounds(0, 0, 56, 47);
		panel.add(panel_2);
		
		userField.setBackground(SystemColor.menu);
		userField.addFocusListener(new FocusAdapter() {
			//Place holder for showing the username and password inside the JtextField
			@Override
			public void focusGained(FocusEvent e) {
				if(userField.getText().equals("Username")) {
					userField.setText("");
				} else {
					userField.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(userField.getText().equals(""))
					userField.setText("Username");
			}
		});
		userField.setBorder(null);
		userField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		userField.setText("Username");
		userField.setBounds(64, 0, 170, 47);
		panel.add(userField);
		userField.setColumns(10);
		
		panel_1.setBounds(272, 119, 244, 47);
		panelMain.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2_1.setBackground(new Color(0, 102, 102));
		panel_2_1.setBounds(0, 0, 56, 47);
		panel_1.add(panel_2_1);
		
		
		passwordField.setBackground(SystemColor.menu);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(passwordField.getText().equals("Password")) { 
					passwordField.setEchoChar('*');//can also be changed to bullet
					passwordField.setText("");
				} else {
					passwordField.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(passwordField.getText().equals("")) {
					passwordField.setText("Password");
					passwordField.setEchoChar((char)0);//So that the password will default to text
				}
			}
		});
		passwordField.setBorder(null);
		passwordField.setEchoChar((char)0);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setText("Password");
		passwordField.setBounds(64, 0, 170, 47);
		panel_1.add(passwordField);
		
		lblNewLabel_2.setForeground(new Color(0, 51, 51));
		lblNewLabel_2.setFont(new Font("Big John", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(351, 28, 91, 24);
		panelMain.add(lblNewLabel_2);
		
		
		ShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ShowPass.isSelected()) {
					passwordField.setEchoChar((char)0);
				}else {
					passwordField.setEchoChar('*');
				}
			}
		});	
		ShowPass.setFont(new Font("Tahoma", Font.PLAIN, 8));
		ShowPass.setBackground(SystemColor.controlHighlight);
		ShowPass.setBounds(437, 170, 152, 13);
		panelMain.add(ShowPass);
		
		btnLogin.setBackground(new Color(51, 153, 153));
		btnLogin.setBounds(415, 189, 101, 43);
		panelMain.add(btnLogin);
		
		btnCancelButton.setBackground(new Color(51, 102, 102));
		btnCancelButton.setBounds(272, 188, 101, 47);
		panelMain.add(btnCancelButton);
		JLabel lblUni = new JLabel("UNI");
		lblUni.setForeground(new Color(245, 245, 245));
		lblUni.setFont(new Font("Big John", Font.PLAIN, 57));
		lblUni.setBounds(272, 65, 124, 72);
		prodpanel.add(lblUni);
		
		lblNewLabel_1.setForeground(new Color(153, 204, 204));
		lblNewLabel_1.setFont(new Font("Big John", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(282, 112, 242, 48);
		prodpanel.add(lblNewLabel_1);
		
		CloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		CloseButton.setForeground(Color.BLACK);
		CloseButton.setFont(new Font("Arial Black", Font.BOLD, 16));
		CloseButton.setBounds(620, 2, 80, 41);
		prodpanel.add(CloseButton);		

	}
	private void setRelativeLocation(Object object) {
		
	}
	void createFolder() {
		
	}
	
	public String getUserName() {
		return userField.getText();
	}	
	public String getUserPass() {
		return passwordField.getText();
	}
	
	void addLoginListener(ActionListener listenForLogin) {
		btnLogin.addActionListener(listenForLogin);
	}
	void addCancelListener(ActionListener listenForCancel) {
		btnCancelButton.addActionListener(listenForCancel);
	}
	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	public void setUserField(JTextField userField) {
		this.userField = userField;
	}
	void addCloseListener(MouseListener listenDorClose) {
		CloseButton.addMouseListener(listenDorClose);
	}
	int displayValidation(String Message1, String Message2) {
		return JOptionPane.showConfirmDialog(null, Message1, Message2, JOptionPane.YES_NO_OPTION);	
	}
	void displayMessage(String Message) {
		JOptionPane.showMessageDialog(null, Message);
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	