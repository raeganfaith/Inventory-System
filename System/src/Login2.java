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
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.JLayeredPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
//CASHIER
public class Login2 extends JFrame {
	
	File f = new File("C:\\\\Users\\\\mynam\\\\Desktop\\\\system");
    int ln;
    String Username, Password;

	  
	//To insert images
	private Image img_logo = new ImageIcon(Login2.class.getResource("ress/logoh.png")).getImage().getScaledInstance(140, 170, Image.SCALE_SMOOTH);
	private Image img_admin = new ImageIcon(Login2.class.getResource("ress/cashier.png")).getImage().getScaledInstance(130, 175, Image.SCALE_SMOOTH); 
	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;
	
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

	void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
	}
	void readFile(){
        try {
            FileReader fr = new FileReader(f+ "\\info.txt");
            System.out.println("file exists!");
        }
        catch (FileNotFoundException ex) {
        	try {
                FileWriter fw = new FileWriter(f+ "\\info.txt");
                System.out.println("File created");
            } 
        	catch (IOException e) {
                Logger.getLogger(Login2.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    void addData(String user,String password){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+ "\\info.txt", "rw");
            for(int i = 0; i < ln; i++) {
                raf.readLine();
            }
            //if condition added after video to have no lines on first entry
            if(ln > 0) {
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            }
            raf.writeBytes("Username: " + user + "\r\n");
            raf.writeBytes("Password: " + password);
        } 
        catch (FileNotFoundException e) {
            Logger.getLogger(Login2.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (IOException e) {
            Logger.getLogger(Login2.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    void checkData(String user, String password){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+ "\\info.txt", "rw");
            
            String line = raf.readLine();
            Username = line.substring(10);
            Password = raf.readLine().substring(10);
            
            if(user.equals(Username)& password.equals(Password)) {
                JOptionPane.showMessageDialog(null, "password matched");
            }
            else {
                JOptionPane.showMessageDialog(null, "wrong user/Password");
            }
        } 
        catch (FileNotFoundException e) {
            Logger.getLogger(Login2.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (IOException e) {
            Logger.getLogger(Login2.class.getName()).log(Level.SEVERE, null, e);
        }    
    }
    
    void logic(String user, String password){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+ "\\info.txt", "rw");
            for(int i = 0; i < ln; i+=3) {
            	System.out.println("count " + i);
            
                String forUser = raf.readLine().substring(10);
                String forPass = raf.readLine().substring(10);
                
                if(user.equals(forUser) & password.equals(forPass)) {
                    JOptionPane.showMessageDialog(null, "Login Successfully!");
                    DashboardView dv = new DashboardView();
                    dv.setVisible(true);
                    Login2.this.setVisible(false);
                    break;
                }else if(i == (ln-2)){
                    JOptionPane.showMessageDialog(null, "Incorrect username/password");
                    break;
                }
                for(int k = 1; k < 2; k++){
                    raf.readLine();
                }
            }
        } 
        catch (FileNotFoundException e) {
            Logger.getLogger(Login2.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (IOException e) {
            Logger.getLogger(Login2.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    void countLines(){
        try {
            ln = 0;
            RandomAccessFile raf = new RandomAccessFile(f+ "\\info.txt", "rw");
            for(int i = 0; raf.readLine()!= null; i++){
                ln++;
            }
            System.out.println("number of lines:" + ln);
        } 
        catch (FileNotFoundException e) {
            Logger.getLogger(Login2.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (IOException e) {
            Logger.getLogger(Login2.class.getName()).log(Level.SEVERE, null, e);
        }
    }
	public Login2() {
		setUndecorated(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setBounds(124, 2, 148, 186);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		
		JLabel lblStore = new JLabel("STORE");
		lblStore.setForeground(new Color(0, 51, 51));
		lblStore.setFont(new Font("Big John", Font.PLAIN, 57));
		lblStore.setBounds(379, 60, 209, 82);
		contentPane.add(lblStore);
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(SystemColor.controlHighlight);
		panelMain.setBounds(0, 191, 700, 259);
		contentPane.add(panelMain);
		panelMain.setLayout(null);
		
		
		JLabel lbladmn = new JLabel("CAHIER");
		lbladmn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null, "Do you want to switch to cashier?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
						Login first = new Login();
						first.setVisible(true);
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
		lbladmn.setBounds(144, 170, 107, 29);
		panelMain.add(lbladmn);
		
		JLabel lbladmin = new JLabel("");
		lbladmin.addMouseListener(new MouseAdapter() {
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
				lbladmn.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbladmn.setForeground(Color.BLACK);
			
			}});
		lbladmin.setBounds(131, 28, 140, 138);
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
		
		userField = new JTextField();
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(272, 119, 244, 47);
		panelMain.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(0, 102, 102));
		panel_2_1.setBounds(0, 0, 56, 47);
		panel_1.add(panel_2_1);
		
		//To change the default echochar in JPassword Field.
				passwordField = new JPasswordField();
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
		
		JLabel lblNewLabel_2 = new JLabel("SIGN IN:");
		lblNewLabel_2.setForeground(new Color(0, 51, 51));
		lblNewLabel_2.setFont(new Font("Big John", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(351, 28, 91, 24);
		panelMain.add(lblNewLabel_2);
		
		JLabel lblLogin2Message = new JLabel("");
		lblLogin2Message.setForeground(new Color(204, 0, 0));
		lblLogin2Message.setFont(new Font("Arial", Font.PLAIN, 10));
		lblLogin2Message.setBounds(272, 170, 250, 21);
		panelMain.add(lblLogin2Message);
		setLocationRelativeTo(null);
		
		JCheckBox ShowPass = new JCheckBox("Show Password");
		ShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ShowPass.isSelected()) {
					passwordField.setEchoChar((char)0);
				}else {
					passwordField.setEchoChar('*');//Can be changed to bullet •
				}
			}
		});
		ShowPass.setFont(new Font("Tahoma", Font.PLAIN, 8));
		ShowPass.setBackground(SystemColor.controlHighlight);
		ShowPass.setBounds(437, 170, 152, 13);
		panelMain.add(ShowPass);
		
		JButton btnLogin2 = new JButton("LOGIN");
		btnLogin2.setBackground(new Color(51, 153, 153));
		btnLogin2.setBounds(415, 189, 101, 43);
		panelMain.add(btnLogin2);
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					LoginView first = new LoginView();
					first.setVisible(true);
					Login2.this.dispose();
				}}
			}
	);
		btnNewButton.setBackground(new Color(51, 102, 102));
		btnNewButton.setBounds(272, 188, 101, 47);
		panelMain.add(btnNewButton);
		btnLogin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createFolder();
				readFile();
				countLines();
				logic(userField.getText(), passwordField.getText());
			}});
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
		
		JLabel CloseButton = new JLabel("CLOSE");
		CloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		CloseButton.setForeground(Color.BLACK);
		CloseButton.setFont(new Font("Arial Black", Font.BOLD, 13));
		CloseButton.setBounds(620, 2, 80, 41);
		contentPane.add(CloseButton);

	}}

