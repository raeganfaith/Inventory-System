import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
	public class AdminLoginController extends JFrame {
		AdminLoginView av;
		AdminLoginModel am;
		String Username, Password;
		public AdminLoginController(AdminLoginView av, AdminLoginModel am) {
				this.av = av;
				this.am = am;	
			this.av.addLoginListener(new LoginListener());
			this.av.addCancelListener(new CancelListener());
			this.av.addCloseListener(new CloseListener());
			av.setVisible(true);
		}
		
		class CloseListener implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent e) {
				int response = av.displayValidation("Are you sure you want to exit?", "Confirmation");
				if (response==JOptionPane.YES_OPTION ) {
					av.dispose();
				}
				else if (response==JOptionPane.NO_OPTION) {
					av.setVisible(true);
				}
				else if (response==JOptionPane.CLOSED_OPTION) {
					av.setVisible(true);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {				
			}
			@Override
			public void mouseReleased(MouseEvent e) {				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				av.CloseButton.setForeground(Color.RED);				
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
			
		}
   class LoginListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			am.createFolder();
			am.readFile();
			am.countLines();
			am.logic(av.getUserName(), av.getUserPass());	
		}
		}
   
	class CancelListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to go back?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					DashboardView first = new DashboardView();
					first.setVisible(true);
					av.dispose();
					
			}
		}
	
	}
}
	
	
		
	
	
	
	
	
	