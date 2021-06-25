import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserView extends JFrame {	
	private Image img_logo = new ImageIcon(UserView.class.getResource("ress/logoh.png")).getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField userid;
	private JTextField role;
	private JTextField user;
	private JTextField password;
	private JTextField phone;
	DefaultTableModel model;

	private JTable table;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView frame = new UserView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public UserView() {
		
		setUndecorated(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblUni = new JLabel("UNI");
		lblUni.setForeground(new Color(245, 245, 245));
		lblUni.setFont(new Font("Big John", Font.PLAIN, 50));
		lblUni.setBounds(257, 32, 124, 69);
		contentPane.add(lblUni);
		
		JLabel lblStore = new JLabel("STORE");
		lblStore.setForeground(new Color(0, 51, 51));
		lblStore.setFont(new Font("Big John", Font.PLAIN, 50));
		lblStore.setBounds(350, 25, 209, 82);
		contentPane.add(lblStore);
		
		JLabel lblNewLabel_1 = new JLabel("Inventory system");
		lblNewLabel_1.setForeground(new Color(153, 204, 204));
		lblNewLabel_1.setFont(new Font("Big John", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(258, 74, 242, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(184, 0, 77, 130);
		lblNewLabel.setIcon(new ImageIcon(img_logo));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 132, 700, 10);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("MANAGE USERS:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(SystemColor.menu);
		lblNewLabel_2.setFont(new Font("Big John", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(242, 152, 251, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("User ID:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(30, 193, 87, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Role:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(30, 227, 100, 24);
		contentPane.add(lblNewLabel_3_1);
		
		userid = new JTextField();
		userid.setBounds(122, 198, 139, 19);
		contentPane.add(userid);
		userid.setColumns(10);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Username:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(30, 260, 87, 24);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Password:");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2.setBounds(30, 294, 87, 24);
		contentPane.add(lblNewLabel_3_1_2);
		
		role = new JTextField();
		role.setColumns(10);
		role.setBounds(122, 232, 139, 19);
		contentPane.add(role);
		
		user = new JTextField();
		user.setColumns(10);
		user.setBounds(122, 265, 139, 19);
		contentPane.add(user);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(122, 299, 139, 19);
		contentPane.add(password);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table .getSelectedRow();
				model.setValueAt(userid.getText(), i, 0);
				model.setValueAt(role.getText(), i, 1);
				model.setValueAt(user.getText(), i, 2);
				model.setValueAt(password.getText(), i, 3);
				model.setValueAt(phone.getText(), i, 4);
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBounds(30, 416, 231, 30);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(30, 496, 231, 30);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(295, 186, 377, 300);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				userid.setText(model.getValueAt(i, 0).toString());
				role.setText(model.getValueAt(i, 0).toString());
				user.setText(model.getValueAt(i, 0).toString());
				password.setText(model.getValueAt(i, 0).toString());
				phone.setText(model.getValueAt(i, 0).toString());
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"User ID","Role","UserName","Password","Phone"};
		final Object[] row = new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		//to automatically displayed the data saved in the notepad to the JTable.
			String filePath = "C:\\Users\\mynam\\Desktop\\PRODUCT\\USER.txt";
			File file = new File(filePath);
				
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
					
				DefaultTableModel mode = (DefaultTableModel)table.getModel();
				Object[] lines = br.lines().toArray();
					
				for(int i = 0; i < lines.length; i++) {
					String[] rows = lines[i].toString().split(" ");
					model.addRow(rows);
				}	
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = userid.getText();
				row[1] = role.getText();
				row[2] = user.getText();
				row[3] = password.getText();
				row[4] = phone.getText();
				model.addRow(row);

				userid.setText("");
				role.setText("");
				user.setText("");
				password.setText("");
				phone.setText("");
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(30, 376, 231, 30);
		contentPane.add(btnAdd);
		
		JLabel btnback = new JLabel("  BACK");
		btnback.setForeground(Color.BLACK);
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashboardView first = new DashboardView();
				first.setVisible(true);
				UserView.this.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnback.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnback.setForeground(Color.BLACK);
			}
		});
		btnback.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnback.setBounds(0, 0, 71, 41);
		contentPane.add(btnback);
		
		JLabel phonenum = new JLabel("Phone:");
		phonenum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phonenum.setBounds(30, 328, 87, 24);
		contentPane.add(phonenum);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(122, 333, 139, 19);
		contentPane.add(phone);
		
		JLabel CloseButton = new JLabel("CLOSE");
		CloseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					UserView.this.dispose();
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
		CloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		CloseButton.setForeground(Color.BLACK);
		CloseButton.setFont(new Font("Arial Black", Font.BOLD, 16));
		CloseButton.setBounds(620, 0, 80, 41);
		contentPane.add(CloseButton);
		
		JButton btnsClear = new JButton("CLEAR");
		btnsClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userid.setText("");
				role.setText("");
				user.setText("");
				password.setText("");
				phone.setText("");
			}
		});
		btnsClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnsClear.setBounds(30, 456, 231, 30);
		contentPane.add(btnsClear);
		
		JButton btnExport = new JButton("SAVE");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Successfully Exported!");
				String filePath = "C:\\Users\\mynam\\Desktop\\PRODUCT\\USER.txt";
				File file = new File(filePath);
				try {
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					
					for(int i = 0; i < model.getRowCount(); i++) {
						for(int j = 0; j < model.getColumnCount(); j++) { //row
							bw.write(model.getValueAt(i, j).toString()+" "); //column
						}
						bw.newLine();
					}
					
					bw.close();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExport.setBounds(295, 496, 377, 30);
		contentPane.add(btnExport);
	}
}
