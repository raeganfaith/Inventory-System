import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminLoginModel extends JFrame {

	File f = new File("C:\\Users\\mynam\\Desktop\\ADMIN");
    int ln;
    String Username, Password;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
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
                Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (IOException e) {
            Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    void checkData(String user, String password){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+ "\\info.txt", "rw");
            
            String line = raf.readLine();
            Username = line.substring(10);
            Password = raf.readLine().substring(10);
            
            if(user.equals(Username)& password.equals(Password)) {
                JOptionPane.showMessageDialog(null, "Login Successful!");
            }
            else {
                JOptionPane.showMessageDialog(null, "wrong user/Password");
            }
        } 
        catch (FileNotFoundException e) {
            Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (IOException e) {
            Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
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
                    JOptionPane.showMessageDialog(null, "Login Successfull!");
                    DashboardView dv = new DashboardView();
                    dv.setVisible(true);
                    AdminLoginView av = new AdminLoginView();
                    av.dispose();
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
            Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (IOException e) {
            Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (IOException e) {
            Logger.getLogger(AdminLoginView.class.getName()).log(Level.SEVERE, null, e);
        }
    }
	
}
