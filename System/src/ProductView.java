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
		lblNewLabel_3.setBounds(30, 193, 87, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Name:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(30, 227, 100, 24);
		contentPane.add(lblNewLabel_3_1);
		
		ID = new JTextField();
		ID.setBounds(122, 198, 139, 19);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Category:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(30, 260, 87, 24);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Quantity:");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2.setBounds(30, 294, 87, 24);
		contentPane.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("Price:");
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_3.setBounds(30, 328, 87, 24);
		contentPane.add(lblNewLabel_3_1_3);
		
		JLabel lblNewLabel_3_1_4 = new JLabel("Description:");
		lblNewLabel_3_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_4.setBounds(30, 362, 87, 24);
		contentPane.add(lblNewLabel_3_1_4);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(122, 232, 139, 19);
		contentPane.add(name);
		
		category = new JTextField();
		category.setColumns(10);
		category.setBounds(122, 265, 139, 19);
		contentPane.add(category);
		
		quantity = new JTextField();
		quantity.setColumns(10);
		quantity.setBounds(122, 299, 139, 19);
		contentPane.add(quantity);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(122, 333, 139, 19);
		contentPane.add(price);
		
		description = new JTextField();
		description.setColumns(10);
		description.setBounds(122, 367, 139, 58);
		contentPane.add(description);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(30, 442, 100, 30);
		contentPane.add(btnNewButton);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBounds(161, 442, 100, 30);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(94, 482, 100, 30);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(295, 186, 377, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Product ID","Name","Quantity","Price","Description"};
		Object[] row = new Object [0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel CloseButton = new JLabel("X");
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
		CloseButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		CloseButton.setBounds(680, 0, 20, 20);
		contentPane.add(CloseButton);
		
		JLabel lblNewLabel_4 = new JLabel("\u2190");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 40));
		lblNewLabel_4.setBounds(10, 0, 45, 38);
		contentPane.add(lblNewLabel_4);
	}
}
