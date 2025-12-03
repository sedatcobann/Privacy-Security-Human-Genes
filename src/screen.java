import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
// This class is needed for entering the file name and the private key for decryption.
public class screen implements Runnable, ActionListener{
	JFrame window=new JFrame("Research");
	JLabel fileLabel=new JLabel("Enter the file name: ");
	JTextField file=new JTextField();
	JLabel passwordLabel=new JLabel("Password: ");
	JPasswordField password=new JPasswordField();
	JButton enterButton=new JButton("Enter");
	Thread thread2;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		window.setBounds(10,10,400,300);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		Container container= new Container();
		fileLabel.setBounds(20,50,150,30);
		file.setBounds(170,50,150,30);
		passwordLabel.setBounds(20,95,150,30);
		password.setBounds(170,95,150,30);
		enterButton.setBounds(125,140,100,30);
		container.add(fileLabel);
		container.add(file);
		container.add(passwordLabel);
		container.add(password);
		container.add(enterButton);
		window.add(container);
		window.setVisible(true);
		enterButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==enterButton && (!file.getText().equals(null) || !password.getText().equals(null))) {
			try {
				if(Authentication.hashingSecretKey(password.getText())) {
					String gene = readFile(file.getText(),password.getText());
					if(gene!=null) {
					applications app = new applications(gene);
					thread2 = new Thread(app);
					window.setVisible(false);
					thread2.start();
					}
				}else {
					JOptionPane.showMessageDialog(null,"Password is incorrect!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null,"Password or file is empty!");
		}
		
	}
	private String readFile(String text, String key) {
		File file = new File("src/EncryptedDataset/"+text+".fasta"); 
		BufferedReader rd = null;
		try {
			rd = new BufferedReader(new FileReader(file));
			String gene = "";
			while(true) {
				String row = null;
				try {
					row = rd.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(row==null) {
					break;
				}
				gene+=encryption.decrypt(row,key);
				
			}
			return gene;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"File could not be found!");
		}
		return null; 
		
	}

	
	
}
