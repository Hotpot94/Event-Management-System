package event_app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class StaffTypeAdmin extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JTextField NameField;
	private JTextField UowIDField;
	private JTextField UserNameField;
	private JTextField PasswordField;
	private String name, uowid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login log1 = new Login();
					StaffTypeAdmin frame = new StaffTypeAdmin(log1.name, log1.uowid);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	public StaffTypeAdmin(String name, String uowid) {
		this.name = name;
		this.uowid = uowid;
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(264, 0, 914, 148);
		panel_1.setBackground(new Color(110,89,222));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(525, -30, 389, 207);
		panel_1.add(label);
		label.setIcon(new ImageIcon(Home.class.getResource("/images/LogoMakr_8jqcL0.png")));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 264, 644);
		panel.setBackground(new Color(54,33,89));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/images/avatar.png")));
		lblNewLabel_1.setBounds(15, 0, 264, 257);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome");
		lblNewLabel_2.setFont(new Font("Sitka Display", Font.BOLD, 50));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(25, 257, 224, 119);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(name);
		lblNewLabel_3.setFont(new Font("Sitka Heading", Font.PLAIN, 25));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(35, 366, 200, 59);
		panel.add(lblNewLabel_3);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(264, 148, 914, 496);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel MainPage = new JPanel();
		layeredPane.add(MainPage, "name_611830318862000");
		MainPage.setLayout(null);
		
		JPanel CreateAccount = new JPanel();
		layeredPane.add(CreateAccount, "name_612787249454300");
		CreateAccount.setLayout(null);
		
		JPanel AccountList = new JPanel();
		layeredPane.add(AccountList, "name_612812154622300");
		AccountList.setLayout(null);
		
		JPanel LoginHistory = new JPanel();
		layeredPane.add(LoginHistory, "name_612800560942300");
		LoginHistory.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.textHighlight);
		btnBack.setForeground(SystemColor.text);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(MainPage);
			}
		});
		btnBack.setBounds(39, 348, 134, 30);
		CreateAccount.add(btnBack);
		
		JLabel lblFullName = new JLabel("Full name:");
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFullName.setBounds(39, 48, 102, 20);
		CreateAccount.add(lblFullName);
		
		NameField = new JTextField();
		NameField.setColumns(10);
		NameField.setBounds(306, 47, 287, 22);
		CreateAccount.add(NameField);
		
		JLabel lblUowId = new JLabel("UOW ID:");
		lblUowId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUowId.setBounds(39, 94, 102, 20);
		CreateAccount.add(lblUowId);
		
		UowIDField = new JTextField();
		UowIDField.setColumns(10);
		UowIDField.setBounds(306, 93, 102, 22);
		CreateAccount.add(UowIDField);
		
		UserNameField = new JTextField();
		UserNameField.setColumns(10);
		UserNameField.setBounds(306, 142, 206, 22);
		CreateAccount.add(UserNameField);
		
		PasswordField = new JTextField();
		PasswordField.setColumns(10);
		PasswordField.setBounds(306, 180, 206, 22);
		CreateAccount.add(PasswordField);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserName.setBounds(39, 143, 102, 20);
		CreateAccount.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(39, 181, 102, 20);
		CreateAccount.add(lblPassword);
		
		JComboBox <String>comboBox = new JComboBox<String>();
		comboBox.setForeground(SystemColor.activeCaptionText);
		comboBox.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		comboBox.setBackground(SystemColor.menu);
		comboBox.addItem("Staff");
		comboBox.addItem("Student");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(306, 224, 134, 26);
		CreateAccount.add(comboBox);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NameField.setText("");
				UowIDField.setText("");
				UserNameField.setText("");
				PasswordField.setText("");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClear.setBackground(SystemColor.textHighlight);
		btnClear.setBounds(331, 348, 156, 30);
		CreateAccount.add(btnClear);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(39, 330, 651, 2);
		CreateAccount.add(separator);
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserType.setBounds(39, 227, 102, 20);
		CreateAccount.add(lblUserType);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(MainPage);
			}
		});
		
		button.setBounds(40, 451, 115, 29);
		LoginHistory.add(button);
		
		JButton button_1 = new JButton("BACK");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(MainPage);
			}
		});
		
		button_1.setBounds(15, 434, 115, 29);
		AccountList.add(button_1);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(CreateAccount);
			}
		});
		
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 30));
		btnNewButton.setIcon(new ImageIcon(StaffTypeAdmin.class.getResource("/images/createAcc.png")));
		btnNewButton.setBounds(100, 42, 405, 95);
		MainPage.add(btnNewButton);
		

		
		JButton btnCreatedAccounts = new JButton("List Of Accounts");
		btnCreatedAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(AccountList);
			}
		});
		
		btnCreatedAccounts.setIcon(new ImageIcon(StaffTypeAdmin.class.getResource("/images/view.png")));
		btnCreatedAccounts.setForeground(Color.WHITE);
		btnCreatedAccounts.setFont(new Font("Sitka Text", Font.BOLD, 30));
		btnCreatedAccounts.setBackground(SystemColor.textHighlight);
		btnCreatedAccounts.setBounds(100, 358, 405, 95);
		MainPage.add(btnCreatedAccounts);
		
        Object [] LoginColumn = {"Name","UOWID","Username","Password","Type","Login-Time"};
		
		JTable table_1 = new JTable();
		table_1.setBounds(1, 1, 450, 0);
		LoginHistory.add(table_1);
		
		DefaultTableModel dataModel_1 = new DefaultTableModel();
		dataModel_1.setColumnIdentifiers(LoginColumn);
		table_1.setModel(dataModel_1);
		table_1.setBackground(Color.WHITE);
		table_1.setForeground(Color.BLACK);
		LoginHistory.setLayout(null);
		Font font = new Font("",1,13);
		table_1.setFont(font);
		table_1.setRowHeight(20);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(10, 5, 889, 402);
		LoginHistory.add(scrollPane_1);
		
		//Change file path here to your computer -------------------------------------------
		String filepath_login = "c://users//malla//Desktop//database_Rahul//LoginHistory.txt";
		//----------------------------------------------------------------------------------
		File file_login = new File(filepath_login);
		try {
			file_login.createNewFile();
			FileReader fr = new FileReader(file_login);
			BufferedReader br = new BufferedReader(fr);
			Object [] lines =  br.lines().toArray();
			for(int i = 0; i < lines.length; i++) {
				String [] row = lines[i].toString().split("~");
				dataModel_1.addRow(row);
			}
			br.close();
			fr.close();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		
		
		//Display Account list
		Object [] AccountColumn = {"Name","UOWID","Username","Password","Type","Suspended"};
		
		JTable table = new JTable();
		table.setBounds(1, 1, 450, 0);
		AccountList.add(table);
		
		DefaultTableModel dataModel = new DefaultTableModel();
		dataModel.setColumnIdentifiers(AccountColumn);
		table.setModel(dataModel);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		AccountList.setLayout(null);
		table.setFont(font);
		table.setRowHeight(20);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 5, 730, 402);
		AccountList.add(scrollPane);
		
		Object [] dataRow = new Object[6];
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataRow[0] = NameField.getText();
				dataRow[1] = UowIDField.getText();
				dataRow[2] = UserNameField.getText();
				dataRow[3] = PasswordField.getText();
				dataRow[4] = comboBox.getSelectedItem().toString();
				dataRow[5] = "No";
				dataModel.addRow(dataRow);
				switchPanels(AccountList);
			}
		});
		//change file path here to your computer -----------------------------------------------
		String filepath_accountlist = "c:\\users\\malla\\Desktop\\database_Rahul\\AccountList.txt";
		//--------------------------------------------------------------------------------------
		File file_account = new File(filepath_accountlist);
		try {
			FileReader fr = new FileReader(file_account);
			BufferedReader br = new BufferedReader(fr);
			Object [] lines_acc = br.lines().toArray();
			for(int i = 0; i < lines_acc.length; i++) {
				String [] row_acc = lines_acc[i].toString().split("~");
				dataModel.addRow(row_acc);
			}
			br.close();
			fr.close();
		}catch(IOException e1) {
			e1.printStackTrace();
		}	
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCreate.setBackground(SystemColor.textHighlight);
		btnCreate.setBounds(534, 348, 156, 30);
		CreateAccount.add(btnCreate);
		
		JButton btnNewButton_1 = new JButton("Suspend");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					dataModel.setValueAt("Yes",i, 5);
					JOptionPane.showMessageDialog(null, "Account: "+dataModel.getValueAt(i, 0).toString()+" UOW ID: "+dataModel.getValueAt(i, 1).toString()+" is Suspended!");
				}
				else {
					JOptionPane.showMessageDialog(null, "No Acount Selected!");
				}
			}
		});
		btnNewButton_1.setBounds(621, 434, 115, 29);
		AccountList.add(btnNewButton_1);
		
		JButton btnUnsuspend = new JButton("Un-Suspend");
		btnUnsuspend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					dataModel.setValueAt("No",i,5);
                    JOptionPane.showMessageDialog(null, "Account: "+dataModel.getValueAt(i, 0).toString()+" UOW ID: "+dataModel.getValueAt(i, 1).toString()+" is Un-Suspended!");
				}
				else {
					JOptionPane.showMessageDialog(null, "No Acount Selected!");
				}
			}
		});
		btnUnsuspend.setBounds(460, 434, 139, 29);
		AccountList.add(btnUnsuspend);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File(filepath_accountlist);
				try {
					file.createNewFile();
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					
					for(int i = 0; i < table.getRowCount(); i++) { //rows
						for(int j = 0; j < table.getColumnCount(); j++) { //columns
							bw.write(table.getValueAt(i, j).toString() + "~");
						}
						bw.newLine();
					}
					bw.close();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Confirm Logout!");
				dispose();
				Login page = new Login();
				page.setUndecorated(true);
				page.setVisible(true);
				page.setLocationRelativeTo(null);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_2.setBounds(35, 599, 178, 29);
		panel.add(btnNewButton_2);
		
		JButton btnLoginHistory = new JButton("Login History");
		btnLoginHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(LoginHistory);
			}
		});
		
		btnLoginHistory.setIcon(new ImageIcon(StaffTypeAdmin.class.getResource("/images/LoginHist.png")));
		btnLoginHistory.setForeground(Color.WHITE);
		btnLoginHistory.setFont(new Font("Sitka Text", Font.BOLD, 30));
		btnLoginHistory.setBackground(SystemColor.textHighlight);
		btnLoginHistory.setBounds(100, 199, 405, 95);
		MainPage.add(btnLoginHistory);
		
		
		
	}
}

