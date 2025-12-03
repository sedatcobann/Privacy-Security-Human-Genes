import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//This class is needed to construct login page.
class loginPage implements Runnable, ActionListener {
	JLabel usernameLabel=new JLabel("Username: ");
    JLabel passwordLabel=new JLabel("Password: ");
    JTextField username=new JTextField();
    JPasswordField password=new JPasswordField();
    JButton loginButton=new JButton("Login");
    JButton resetButton=new JButton("Reset");
    String usernameScreen="";
    Thread thread2;
    Thread t;
    JFrame page;
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		page=new JFrame("Login Page");
		screen sc = new screen();
		thread2 = new Thread(sc);
		t = new Thread(this);
		page.setBounds(10,10,370,300);
		page.setResizable(false);
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page.setResizable(false);
		Container container= new Container();;
	    container.setLayout(null);
	    usernameLabel.setBounds(50,50,100,30);
	    passwordLabel.setBounds(50,120,100,30);
	    username.setBounds(150,50,150,30);
        password.setBounds(150,120,150,30);
        loginButton.setBounds(50,200,100,30);
	    resetButton.setBounds(200,200,100,30);
	    container.add(usernameLabel);
	    container.add(username);
	    container.add(passwordLabel);
	    container.add(password);
	    container.add(loginButton);
	    container.add(resetButton);
	    page.add(container);
	    page.setVisible(true);
	    loginButton.addActionListener(this);
	    resetButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == resetButton) {
			username.setText("");
			password.setText("");
			
		}else if(e.getSource() == loginButton) {
			String user = username.getText();
			String pass = password.getText();
			try {
				if(Authentication.hashingPassword(user,pass)) {
					page.setVisible(false);
					thread2.start();
					
				}else {
					JOptionPane.showMessageDialog(null,"Username or Password is incorrect");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
}

public class main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loginPage login = new loginPage();
		Thread t = new Thread(login);
		t.start();
		
	}
	
}
