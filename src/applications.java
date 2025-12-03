import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class applications implements Runnable, ActionListener{

	JFrame window=new JFrame("Applications");
	JRadioButton search=new JRadioButton("Search");
	JTextArea searchText= new JTextArea(1,5);
	JRadioButton countA=new JRadioButton("Number of A");
	JRadioButton countT=new JRadioButton("Number of T");
	JRadioButton countG=new JRadioButton("Number of G");
	JRadioButton countC=new JRadioButton("Number of C");
	JFormattedTextField output = new JFormattedTextField("");
	JButton enterButton=new JButton("Enter");
	JButton resetButton = new JButton("Reset");
	
	String gene;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==enterButton) {
			String result = "";
			if(search.isSelected()) {
				String s = searchText.getText().toUpperCase();
				Pattern pattern = Pattern.compile(s);
				Matcher matcher = pattern.matcher(gene);
				int count = 0;
				while(matcher.find()){
					count++;
				}
				String countResult = "Search pattern is " + s + ". The count is "+ count+"\n";
				result += countResult;
				
			}
			if(countA.isSelected()) {
				String s = "A";
				Pattern pattern = Pattern.compile(s);
				Matcher matcher = pattern.matcher(gene);
				int count = 0;
				while(matcher.find()){
					count++;
				}
				String countAResult = "The number of "+ s+ " in the gene is "+ count+"\n";
				result+=countAResult;
			}
			if(countT.isSelected()) {
				String s = "T";
				Pattern pattern = Pattern.compile(s);
				Matcher matcher = pattern.matcher(gene);
				int count = 0;
				while(matcher.find()){
					count++;
				}
				String countTResult = "The number of "+ s+ " in the gene is "+ count+"\n";
				result+=countTResult;
			}
			if(countG.isSelected()) {
				String s = "G";
				Pattern pattern = Pattern.compile(s);
				Matcher matcher = pattern.matcher(gene);
				int count = 0;
				while(matcher.find()){
					count++;
				}
				String countGResult = "The number of "+ s+ " in the gene is "+ count+"\n";
				result+=countGResult;
			}
			if(countC.isSelected()) {
				String s = "C";
				Pattern pattern = Pattern.compile(s);
				Matcher matcher = pattern.matcher(gene);
				int count = 0;
				while(matcher.find()){
					count++;
				}
				String countCResult = "The number of "+ s+ " in the gene is "+ count+"\n";
				result+=countCResult;			
				}
			
			output.setText(result);
			
		}else if(arg0.getSource()==resetButton) {
			output.setText("");
			countC.setSelected(false);
			countT.setSelected(false);
			countG.setSelected(false);
			countA.setSelected(false);
			search.setSelected(false);
			searchText.setText("");
			searchText.setEnabled(false);


		}

	}

	public applications(String gene) {
		this.gene = gene;
	}

	@Override
	public void run() {
		window.setBounds(10,10,400,600);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		Container container= new Container();
		search.setBounds(20,50,150,30);
		searchText.setBounds(170,55,150,20);
		countA.setBounds(20, 80, 150, 30);
		countT.setBounds(20, 110, 150, 30);
		countG.setBounds(20, 140, 150, 30);
		countC.setBounds(20, 170, 150, 30);
		enterButton.setBounds(20,200,150,30);
		resetButton.setBounds(190, 200, 150, 30);
		output.setBounds(20, 240, 320, 250);
		output.setEnabled(false);
		searchText.setEnabled(false);
		output.setForeground(Color.red);
		container.add(search);
		container.add(searchText);
		container.add(enterButton);
		container.add(countA);
		container.add(countT);
		container.add(countG);
		container.add(countC);
		container.add(resetButton);
		container.add(output);
		window.add(container);
		window.setVisible(true);
		enterButton.addActionListener(this);
		resetButton.addActionListener(this);
		output.addActionListener(this);
		search.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(search.isSelected()) {
					searchText.setEnabled(true);
				}else {
					searchText.setEnabled(false);
				}
			}
		});

	}

}
