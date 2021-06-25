import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
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

public class ProductView extends JFrame {
	
	private Image img_logo = new ImageIcon(ProductView.class.getResource("ress/logoh.png")).getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField ID;
	private JTextField name;
	private JTextField category;
	private JTextField quantity;
	private JTextField price;
	private JTextField description;
	DefaultTableModel model;

	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductView frame = new ProductView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public ProductView() {
		
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
		
		JLabel lblNewLabel_2 = new JLabel("PRODUCT INVENTORY");
		lblNewLabel_2.setForeground(SystemColor.menu);
		lblNewLabel_2.setFont(new Font("Big John", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(242, 152, 251, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Product ID:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(31, 186, 87, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Name:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(31, 220, 100, 24);
		contentPane.add(lblNewLabel_3_1);
		
		ID = new JTextField();
		ID.setBounds(123, 191, 139, 19);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Category:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(31, 253, 87, 24);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Quantity:");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2.setBounds(31, 287, 87, 24);
		contentPane.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("Price:");
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_3.setBounds(31, 321, 87, 24);
		contentPane.add(lblNewLabel_3_1_3);
		
		JLabel lblNewLabel_3_1_4 = new JLabel("Description:");
		lblNewLabel_3_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_4.setBounds(31, 355, 87, 24);
		contentPane.add(lblNewLabel_3_1_4);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(123, 225, 139, 19);
		contentPane.add(name);
		
		category = new JTextField();
		category.setColumns(10);
		category.setBounds(123, 258, 139, 19);
		contentPane.add(category);
		
		quantity = new JTextField();
		quantity.setColumns(10);
		quantity.setBounds(123, 292, 139, 19);
		contentPane.add(quantity);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(123, 326, 139, 19);
		contentPane.add(price);
		
		description = new JTextField();
		description.setColumns(10);
		description.setBounds(123, 360, 139, 38);
		contentPane.add(description);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(295, 186, 377, 292);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Product ID","Name","Category","Quantity","Price","Description"};
		final Object[] row = new Object[6];
		//Object[] row = new Object [0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		String filePath = "C:\\Users\\mynam\\Desktop\\PRODUCT\\PRODUCTS.txt";
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
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = ID.getText();
				row[1] = name.getText();
				row[2] = category.getText();
				row[3] = quantity.getText();
				row[4] = price.getText();
				row[5] = description.getText();
				model.addRow(row);

				ID.setText("");
				name.setText("");
				category.setText("");
				quantity.setText("");
				price.setText("");
				description.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(31, 408, 231, 30);
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table .getSelectedRow();
				model.setValueAt(ID.getText(), i, 0);
				model.setValueAt(name.getText(), i, 1);
				model.setValueAt(category.getText(), i, 2);
				model.setValueAt(quantity.getText(), i, 3);
				model.setValueAt(price.getText(), i, 4);
				model.setValueAt(description.getText(), i, 5);
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBounds(31, 448, 231, 30);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(31, 488, 100, 30);
		contentPane.add(btnDelete);
		
		//----------CLOSE BUTTON------------	
		JLabel CloseButton = new JLabel("CLOSE");
		CloseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					ProductView.this.dispose();
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
		
		JLabel btnback = new JLabel("  BACK");
		btnback.setForeground(Color.BLACK);
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashboardView first = new DashboardView();
				first.setVisible(true);
				ProductView.this.setVisible(false);
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
		
		
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID.setText("");
				name.setText("");
				category.setText("");
				quantity.setText("");
				price.setText("");
				description.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClear.setBounds(161, 488, 100, 30);
		contentPane.add(btnClear);
		
		JButton btnExport = new JButton("SAVE");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Successfully Exported!");
				String filePath = "C:\\Users\\mynam\\Desktop\\PRODUCT\\PRODUCTS.txt";
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
		btnExport.setBounds(295, 488, 377, 30);
		contentPane.add(btnExport);
	}
}
