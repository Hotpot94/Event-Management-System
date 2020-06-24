package event_app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException; 
import java.text.SimpleDateFormat; 
import java.util.Date;

import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JRadioButton;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public String name, uowid;
	int xx, xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				Login.this.setLocation(x - xx, y - xy);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.desktop);
		panel.setBackground(new Color(45,118,232));
		panel.setBounds(0, 0, 350, 502);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/images/moreUO.png")));
		lblNewLabel_1.setBounds(33, 227, 249, 191);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/images/LogoMakr_8jqcL0.png")));
		lblNewLabel_3.setBounds(-90, 74, 369, 129);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(319, 0, 31, 502);
		panel.add(panel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		textField.setBounds(365, 90, 220, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(365, 55, 104, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.GRAY);
		lblPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblPassword.setBounds(365, 156, 104, 20);
		contentPane.add(lblPassword);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setForeground(SystemColor.activeCaptionText);
		comboBox.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		comboBox.setBackground(SystemColor.menu);
		comboBox.addItem("Admin");
		comboBox.addItem("Staff");
		comboBox.addItem("Student");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(364, 283, 150, 44);
		contentPane.add(comboBox);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		passwordField.setBounds(365, 181, 220, 50);
		contentPane.add(passwordField);
		
		//change path here--------------------------------------------------------
		String filepath = "c://users//malla//Desktop//database_Rahul//AccountList.txt";
		String filepath_login = "c://users//malla//Desktop//database_Rahul//LoginHistory.txt";
		//------------------------------------------------------------------------------
		Button button = new Button("Log In");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user, pass, type;
				String suspended = "No";
				int count = 0;
				user = textField.getText();
				pass = passwordField.getText();
				type = (String)comboBox.getSelectedItem();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String date = dateFormat.format(new Date());
				File file = new File(filepath);
				File file_1 = new File(filepath_login);
				//Authenticate which account
				try {
					file.createNewFile();
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					Object [] lines = br.lines().toArray();
					
					for(int i = 0; i < lines.length; i++) {
						String [] accountArr = lines[i].toString().split("~");
						if(user.contentEquals(accountArr[2]) &&  pass.contentEquals(accountArr[3]) && type.contentEquals("Student")&&
							accountArr[5].contentEquals("No"))
						{
							count++;
							name = accountArr[0];
							uowid = accountArr[1];
							file_1.createNewFile();
							FileWriter fw = new FileWriter(file_1,true);
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(name + "~");
							bw.write(uowid+ "~");
							bw.write(user + "~");
							bw.write(pass + "~");
							bw.write(type + "~");
							bw.write(date + "~");
							bw.newLine();
							StudentHome app = new StudentHome(name, uowid);
							app.setVisible(true);
							dispose();
							bw.close();
							fw.close();
						}
						else if(user.contentEquals(accountArr[2]) &&  pass.contentEquals(accountArr[3]) && type.contentEquals("Staff")&&
								accountArr[5].contentEquals("No"))
						{
							count++;
							name = accountArr[0];
							uowid = accountArr[1];
							file_1.createNewFile();
							FileWriter fw = new FileWriter(file_1,true);
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(name + "~");
							bw.write(uowid+ "~");
							bw.write(user + "~");
							bw.write(pass + "~");
							bw.write(type + "~");
							bw.write(date + "~");
							bw.newLine();
							bw.close();
							fw.close();
							Home app = new Home(name, uowid);
							app.setVisible(true);
							dispose();
						}
						else if(type.contentEquals("Admin"))
						{
							break;
						}
						else if(accountArr[5].contentEquals("Yes"))
						{
							count++;
							JOptionPane.showMessageDialog(null, "Your account has been suspended!"+" Contact administrator for more information.");
						}
						
					}
					if(type.contentEquals("Admin") && user.contentEquals("Admin1") && pass.contentEquals("Admin1"))
					{
						count++;
						name = "Ricardo Guetta";
						uowid = "9785466";
						file_1.createNewFile();
						FileWriter fw = new FileWriter(file_1,true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(name + "~");
						bw.write(uowid+ "~");
						bw.write(user + "~");
						bw.write(pass + "~");
						bw.write(type + "~");
						bw.write(date + "~");
						bw.newLine();
						bw.close();
						fw.close();
						StaffTypeAdmin app = new StaffTypeAdmin(name, uowid);
						app.setVisible(true);
						dispose();
					}
					else if(type.contentEquals("Admin") && user.contentEquals("Admin2") && pass.contentEquals("Admin2"))
					{
						count++;
						name = "Steven Segall";
						uowid = "5674382";
						file_1.createNewFile();
						FileWriter fw = new FileWriter(file_1,true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(name + "~");
						bw.write(uowid+ "~");
						bw.write(user + "~");
						bw.write(pass + "~");
						bw.write(type + "~");
						bw.write(date + "~");
						bw.newLine();
						bw.close();
						fw.close();
						StaffTypeAdmin app = new StaffTypeAdmin(name, uowid);
						app.setVisible(true);
						dispose();
					}
					br.close();
					fr.close();
				}catch(IOException e1){
					e1.printStackTrace();
				}
				
				if(count == 0) {
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password!");
				}
				
			}
		});
		button.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		button.setForeground(Color.WHITE);
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(356, 355, 224, 50);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setToolTipText("Close");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(45,118,232));
		btnNewButton.setBounds(607, 0, 44, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("_");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setToolTipText("Minimize");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		btnNewButton_1.setBackground(new Color(45,118,232));
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.setBounds(566, 0, 41, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblLoginAs = new JLabel("Login As");
		lblLoginAs.setForeground(Color.GRAY);
		lblLoginAs.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblLoginAs.setBounds(365, 247, 104, 29);
		contentPane.add(lblLoginAs);
	}
}

