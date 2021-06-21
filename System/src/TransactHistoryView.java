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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransactHistoryView extends JFrame {
	
	private Image img_logo = new ImageIcon(TransactHistoryView.class.getResource("ress/logoh.png")).getImage().getScaledInstance(70, 100, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField ordernum;
	private JTextField date;
	private JTextField amount;
	private JTextField id;
	private JTextField cat;
	private JTextField quantity;
	DefaultTableModel model;

	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactHistoryView frame = new TransactHistoryView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TransactHistoryView() {
		
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
		
		JLabel lblNewLabel_2 = new JLabel("TRANSACTION HISTORY");
		lblNewLabel_2.setForeground(SystemColor.menu);
		lblNewLabel_2.setFont(new Font("Big John", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(213, 152, 287, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Order number:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(30, 193, 93, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Date:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(30, 227, 100, 24);
		contentPane.add(lblNewLabel_3_1);
		
		ordernum = new JTextField();
		ordernum.setBounds(122, 198, 139, 19);
		contentPane.add(ordernum);
		ordernum.setColumns(10);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Amount:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(30, 260, 87, 24);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Product ID:");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2.setBounds(30, 294, 87, 24);
		contentPane.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_3 = new JLabel("Categories:");
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_3.setBounds(30, 328, 87, 24);
		contentPane.add(lblNewLabel_3_1_3);
		
		JLabel lblNewLabel_3_1_4 = new JLabel("Quantity:");
		lblNewLabel_3_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_4.setBounds(30, 362, 87, 24);
		contentPane.add(lblNewLabel_3_1_4);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(122, 232, 139, 19);
		contentPane.add(date);
		
		amount = new JTextField();
		amount.setColumns(10);
		amount.setBounds(122, 265, 139, 19);
		contentPane.add(amount);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(122, 299, 139, 19);
		contentPane.add(id);
		
		cat = new JTextField();
		cat.setColumns(10);
		cat.setBounds(122, 333, 139, 19);
		contentPane.add(cat);
		
		quantity = new JTextField();
		quantity.setColumns(10);
		quantity.setBounds(122, 367, 139, 24);
		contentPane.add(quantity);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 186, 393, 295);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				ordernum.setText(model.getValueAt(i, 0).toString());
				date.setText(model.getValueAt(i, 0).toString());
				amount.setText(model.getValueAt(i, 0).toString());
				id .setText(model.getValueAt(i, 0).toString());
				cat.setText(model.getValueAt(i, 0).toString());
				quantity.setText(model.getValueAt(i, 0).toString());
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"Order Number","Date","Amount","Product ID","Category","Quantity"};
		final Object[] row = new Object[6];
		//Object[] row = new Object [0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = ordernum.getText();
				row[1] = date.getText();
				row[2] = amount.getText();
				row[3] = id.getText();
				row[4] = cat.getText();
				row[5] = quantity.getText();
				model.addRow(row);

				ordernum.setText("");
				date.setText("");
				amount.setText("");
				id.setText("");
				cat.setText("");
				quantity.setText("");
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(30, 411, 231, 30);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table .getSelectedRow();
				model.setValueAt(ordernum.getText(), i, 0);
				model.setValueAt(date.getText(), i, 1);
				model.setValueAt(amount.getText(), i, 2);
				model.setValueAt(id.getText(), i, 3);
				model.setValueAt(cat.getText(), i, 4);
				model.setValueAt(quantity.getText(), i, 5);
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBounds(30, 451, 231, 30);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.removeRow(i);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(30, 491, 87, 30);
		contentPane.add(btnDelete);
			
		JLabel CloseButton = new JLabel("CLOSE");
		CloseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					TransactHistoryView.this.dispose();
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
		CloseButton.setFont(new Font("Arial Black", Font.BOLD, 13));
		CloseButton.setBounds(620, 0, 80, 41);
		contentPane.add(CloseButton);
		
		JLabel btnback = new JLabel("  BACK");
		btnback.setForeground(Color.BLACK);
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashboardView first = new DashboardView();
				first.setVisible(true);
				TransactHistoryView.this.setVisible(false);
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
		btnback.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnback.setBounds(0, 0, 71, 41);
		contentPane.add(btnback);
		
		JButton btnImport = new JButton("IMPORT");
		btnImport.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnImport.setBounds(284, 491, 393, 30);
		contentPane.add(btnImport);
		
		JButton BtnClear = new JButton("CLEAR");
		BtnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordernum.setText("");
				date.setText("");
				amount.setText("");
				id.setText("");
				cat.setText("");
				quantity.setText("");
			}
		});
		BtnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		BtnClear.setBounds(168, 491, 93, 30);
		contentPane.add(BtnClear);
	}
}
