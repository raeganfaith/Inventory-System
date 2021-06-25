import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Arrays;

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
import javax.swing.JComboBox;

public class ProductView extends JFrame {	
	private Image img_logo = new ImageIcon(ProductView.class.getResource("ress/logoh.png")).getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH);
	
	private static JPanel contentPane;
	private JTextField ID;
	private JTextField name;
	private JTextField quantity;
	private JTextField price;
	private JTextField description;
	
	DefaultComboBoxModel combo;
	DefaultTableModel model;
	

	private JTable table;
	private static JComboBox<String> comboBox;
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
		lblUni.setBounds(257, 32, 124, 69);
		lblUni.setForeground(new Color(245, 245, 245));
		lblUni.setFont(new Font("Big John", Font.PLAIN, 50));
		contentPane.add(lblUni);
		
		JLabel lblStore = new JLabel("STORE");
		lblStore.setBounds(350, 25, 209, 82);
		lblStore.setForeground(new Color(0, 51, 51));
		lblStore.setFont(new Font("Big John", Font.PLAIN, 50));
		contentPane.add(lblStore);
		
		JLabel lblNewLabel_1 = new JLabel("Inventory system");
		lblNewLabel_1.setBounds(258, 74, 242, 48);
		lblNewLabel_1.setForeground(new Color(153, 204, 204));
		lblNewLabel_1.setFont(new Font("Big John", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(184, 0, 77, 130);
		lblNewLabel.setIcon(new ImageIcon(img_logo));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 132, 700, 10);
		panel.setBackground(new Color(220, 220, 220));
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUCT INVENTORY");
		lblNewLabel_2.setBounds(242, 152, 251, 24);
		lblNewLabel_2.setForeground(SystemColor.menu);
		lblNewLabel_2.setFont(new Font("Big John", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Product ID:");
		lblNewLabel_3.setBounds(31, 186, 87, 24);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Name:");
		lblNewLabel_3_1.setBounds(31, 220, 100, 24);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3_1);
		
		ID = new JTextField();
		ID.setBounds(123, 191, 139, 19);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Category:");
		lblNewLabel_3_1_1.setBounds(31, 253, 87, 24);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Stock:");
		lblNewLabel_3_1_2.setBounds(31, 287, 87, 24);
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("Price:");
		lblNewLabel_3_1_3.setBounds(31, 321, 87, 24);
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3_1_3);
		
		JLabel lblNewLabel_3_1_4 = new JLabel("Description:");
		lblNewLabel_3_1_4.setBounds(31, 355, 87, 24);
		lblNewLabel_3_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_3_1_4);
		
		name = new JTextField();
		name.setBounds(123, 225, 139, 19);
		name.setColumns(10);
		contentPane.add(name);
		
		quantity = new JTextField();
		quantity.setBounds(123, 292, 139, 19);
		quantity.setColumns(10);
		contentPane.add(quantity);
		
		price = new JTextField();
		price.setBounds(123, 326, 139, 19);
		price.setColumns(10);
		contentPane.add(price);
		
		description = new JTextField();
		description.setBounds(123, 360, 139, 38);
		description.setColumns(10);
		contentPane.add(description);
		
		comboBox = new JComboBox();
		combo = new DefaultComboBoxModel();
		comboBox.setBounds(123, 257, 138, 21);
		contentPane.add(comboBox);
		fillComboFromTxtFile();
		
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
		btnNewButton.setBounds(31, 408, 231, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = ID.getText();
				row[1] = name.getText();
				row[2] = comboBox.getSelectedItem();
				row[3] = quantity.getText();
				row[4] = price.getText();
				row[5] = description.getText();
				model.addRow(row);

				ID.setText("");
				name.setText("");
				comboBox.setSelectedItem("");
				quantity.setText("");
				price.setText("");
				description.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setBounds(31, 448, 231, 30);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table .getSelectedRow();
				model.setValueAt(ID.getText(), i, 0);
				model.setValueAt(name.getText(), i, 1);
				model.setValueAt(comboBox.getSelectedItem(), i, 2);
				model.setValueAt(quantity.getText(), i, 3);
				model.setValueAt(price.getText(), i, 4);
				model.setValueAt(description.getText(), i, 5);
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(31, 488, 100, 30);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnDelete);
		
		//----------CLOSE BUTTON------------	
		JLabel CloseButton = new JLabel("CLOSE");
		CloseButton.setBounds(620, 0, 80, 41);
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
		contentPane.add(CloseButton);
		
		JLabel btnback = new JLabel("  BACK");
		btnback.setBounds(0, 0, 71, 41);
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
		contentPane.add(btnback);
		
		
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(161, 488, 100, 30);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID.setText("");
				name.setText("");
				comboBox.setSelectedItem("");
				quantity.setText("");
				price.setText("");
				description.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnClear);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(295, 488, 165, 30);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Successfully Saved!");
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
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnSave);
		
		JButton btnSwitch = new JButton("VIEW");
		btnSwitch.setBounds(507, 488, 165, 30);
		btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TableModel model1 = table.getModel();
				int index[] = table.getSelectedRows();
				
				Object[] row = new Object[6];
				
				TransactHistoryView th = new TransactHistoryView();
				DefaultTableModel model2 = (DefaultTableModel)th.table.getModel();
				ProductView.setVisibility(false);
				
				for(int i = 0; i < index.length; i++) {
					row[0] = model1.getValueAt(index[i], 0);
					row[1] = model1.getValueAt(index[i], 1);
					row[2] = model1.getValueAt(index[i], 2);
					row[3] = model1.getValueAt(index[i], 3);
					row[4] = model1.getValueAt(index[i], 4);
					row[5] = model1.getValueAt(index[i], 5);
					
					
					model2.addRow(row);
				}
				th.setVisible(true);
			}
		});
		btnSwitch.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnSwitch);
	
	}
public void fillComboFromTxtFile(){
        
        String filePath = "C:\\Users\\mynam\\Desktop\\PRODUCT\\info.txt";
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] lines = br.lines().toArray();
            
            for(int i = 0; i < lines.length; i++){
                String line = lines[i].toString();
                comboBox.addItem(line);
            }
            } catch (FileNotFoundException ex) {
            	ex.printStackTrace();
            }
            
        }   

	protected static void setVisibility(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
}
