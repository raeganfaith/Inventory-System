
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class DashboardView extends JFrame {

	private Image img_logo = new ImageIcon(DashboardView.class.getResource("ress/logoh.png")).getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardView frame = new DashboardView();
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
	public DashboardView() {
		setUndecorated(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450); //Frame size
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(156, 0, 109, 144);
		lblNewLabel.setIcon(new ImageIcon(img_logo));
		contentPane.add(lblNewLabel);
		
		JLabel lblUni = new JLabel("UNI");
		lblUni.setForeground(new Color(245, 245, 245));
		lblUni.setFont(new Font("Big John", Font.PLAIN, 50));
		lblUni.setBounds(260, 40, 124, 69);
		contentPane.add(lblUni);
		
		JLabel lblStore = new JLabel("STORE");
		lblStore.setForeground(new Color(0, 51, 51));
		lblStore.setFont(new Font("Big John", Font.PLAIN, 50));
		lblStore.setBounds(353, 33, 209, 82);
		contentPane.add(lblStore);
		
		JLabel lblNewLabel_1 = new JLabel("Inventory system");
		lblNewLabel_1.setForeground(new Color(153, 204, 204));
		lblNewLabel_1.setFont(new Font("Big John", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(261, 82, 242, 48);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 149, 700, 10);
		contentPane.add(panel);
		
		JLabel CloseButton = new JLabel("X");
		CloseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					DashboardView.this.dispose();
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
		
		JPanel PnlProducts = new JPanel();
		PnlProducts.setBounds(143, 184, 117, 94);
		contentPane.add(PnlProducts);
		
		JPanel PnlCategories = new JPanel();
		PnlCategories.setBounds(294, 184, 117, 94);
		contentPane.add(PnlCategories);
		
		JPanel PnlTransactionHistory = new JPanel();
		PnlTransactionHistory.setBounds(452, 184, 117, 94);
		contentPane.add(PnlTransactionHistory);
		
		JPanel PnlUsers = new JPanel();
		PnlUsers.setBounds(228, 297, 117, 94);
		contentPane.add(PnlUsers);
		
		JPanel PnlProducts_1_1_2 = new JPanel();
		PnlProducts_1_1_2.setBounds(386, 297, 117, 94);
		contentPane.add(PnlProducts_1_1_2);
		
		
		
		JPanel panelLogoutBtn = new JPanel();
		panelLogoutBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to logout?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					LoginView first = new LoginView();
					first.setVisible(true);
					DashboardView.this.dispose();
				}}
					//Hovering buttons
					@Override
					public void mouseEntered(MouseEvent e) {
						panelLogoutBtn.setBackground(new Color(0, 70, 70));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						panelLogoutBtn.setBackground(new Color(0, 102, 102));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						panelLogoutBtn.setBackground(new Color(30, 133, 133));
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						panelLogoutBtn.setBackground(new Color(0, 70, 70));
					}});
		
		
		
		panelLogoutBtn.setLayout(null);
		panelLogoutBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLogoutBtn.setBackground(new Color(51, 102, 102));
		panelLogoutBtn.setBounds(294, 413, 134, 27);
		contentPane.add(panelLogoutBtn);
		
		JLabel lblLogin2 = new JLabel("LOG IN");
		lblLogin2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLogin2.setBounds(0, 0, 134, 27);
		panelLogoutBtn.add(lblLogin2);
		
	}

}
