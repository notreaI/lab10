import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
public class FileManager2 extends JFrame implements ActionListener{
	public JTextField textfield = new JTextField(20);
	public JButton button = new JButton("go");
	public JRadioButton rButton= new JRadioButton("read");
	public JRadioButton rButton2= new JRadioButton("encrypt");
	public File cd = new File(".");
	JTextArea textarea = new JTextArea(20,20);
	JFrame displayFrame = new JFrame("File Content");
	String buffer = "";
	String buffer2 ="";
	public FileManager2(){
		super("SimpleFileManager");
		setLayout(new GridLayout(0,1));
		add(textfield);
		add(rButton);
		add(rButton2);
		add(button);
		button.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		}
	public void actionPerformed(ActionEvent event){
		if (event.getSource()== button){
			displayFrame.add(textarea);
			if (rButton.isSelected()){
				try{
				FileInputStream fileIn = new FileInputStream(textfield.getText());
				int c;
				while ((c=fileIn.read())!= -1){
					buffer += (char)c;
				}
				}catch (IOException e){
					System.out.println(e.getMessage());
				}
				displayFrame.setVisible(true);
				textarea.setText(buffer);
				displayFrame.pack();
				buffer = "";
			}
			if (rButton2.isSelected()){
				buffer = textarea.getText();
				char[] temp=buffer.toCharArray();
				for (int i = 0;i < temp.length;i++){
					System.out.println(temp[i]);
					if(Character.isLetter(temp[i])){
						buffer2 += (char)((temp[i] + 13 - (int)'a') % 26 + (int)'a');
					}
					else{
						buffer2 += temp[i];
					}
					System.out.println("B"+buffer2);
				}
				textarea.setText(buffer2);
				buffer2 = "";
				buffer = "";
			}
		}
	}
	public static void main(String[] args){
		FileManager2 a = new FileManager2();
		a.setVisible(true);
	}
}