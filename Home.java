package event_app;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.util.Date;
import java.sql.Timestamp;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField EventNameField;
	private JTextField VenueField;
	private JTextField PromoCodeField;
	private JTextField CapacityField;
	private JTextField EventDetailsField;
	private JTextField StartDateField;
	private static JTable table;
	private JLayeredPane layeredPane;
	private JLabel lblViewEvents;
	private JLabel lblLaunchEvent;
	private JTextField EndDateField;
	private JTextField PriceField;
	private JTextField DiscountField;
	private JTextField EventNameLField;
	private JTextField VenueLField;
	private JTextField PromoCodeLField;
	private JTextField CapacityLField;
	private JTextField EventDetailsLField;
	private JTextField StartDateLField;
	private JTextField EndDateLField;
	private JTextField PriceLField;
	private JTextField DiscountLField;
	private String name, uowID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login log2 = new Login();
					Home frame = new Home(log2.name,log2.uowid);
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
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	public Home(String name, String uowID) {
		this.name = name;
		this.uowID = uowID;
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
		lblNewLabel_3.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(35, 366, 200, 59);
		panel.add(lblNewLabel_3);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(264, 148, 914, 496);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel create = new JPanel();
		layeredPane.add(create, "name_279460949183400");
		create.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Event");
		lblNewLabel.setBounds(34, 112, 120, 36);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.WHITE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanels(create);
			}
		});
		
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_2.setBounds(0, 16, 733, 480);
		create.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(SystemColor.textHighlight);
		panel_3.setBounds(0, 0, 737, 59);
		panel_2.add(panel_3);
		
		JLabel label_1 = new JLabel("Create Event");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		label_1.setBounds(276, 16, 150, 28);
		panel_3.add(label_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(SystemColor.textHighlight);
		panel_4.setBounds(0, 440, 737, 46);
		panel_2.add(panel_4);
		
		JLabel label_8 = new JLabel("Event name:");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_8.setBounds(86, 75, 102, 20);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Venue:");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_9.setBounds(86, 183, 57, 20);
		panel_2.add(label_9);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStartDate.setBounds(86, 219, 97, 20);
		panel_2.add(lblStartDate);
		
		JLabel label_11 = new JLabel("Promo code:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_11.setBounds(86, 324, 102, 20);
		panel_2.add(label_11);
		
		EventNameField = new JTextField();
		EventNameField.setColumns(10);
		EventNameField.setBounds(253, 75, 191, 22);
		panel_2.add(EventNameField);
		
		VenueField = new JTextField();
		VenueField.setColumns(10);
		VenueField.setBounds(253, 182, 116, 22);
		panel_2.add(VenueField);
		
		PromoCodeField = new JTextField();
		PromoCodeField.setColumns(10);
		PromoCodeField.setBounds(253, 322, 116, 22);
		panel_2.add(PromoCodeField);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventNameField.setText("");
				VenueField.setText("");
				PromoCodeField.setText("");
				StartDateField.setText("");
				CapacityField.setText("");
				EventDetailsField.setText("");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBackground(SystemColor.textHighlight);
		btnClear.setBounds(524, 395, 109, 29);
		panel_2.add(btnClear);
		
		JLabel label_13 = new JLabel("Event Description:");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_13.setBounds(86, 111, 149, 20);
		panel_2.add(label_13);
		
		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCapacity.setBounds(86, 147, 102, 20);
		panel_2.add(lblCapacity);
		
		CapacityField = new JTextField();
		CapacityField.setColumns(10);
		CapacityField.setBounds(253, 146, 45, 22);
		panel_2.add(CapacityField);
		
		EventDetailsField = new JTextField();
		EventDetailsField.setColumns(10);
		EventDetailsField.setBounds(253, 108, 380, 25);
		panel_2.add(EventDetailsField);
		
		StartDateField = new JTextField();
		StartDateField.setColumns(10);
		StartDateField.setBounds(253, 216, 146, 26);
		panel_2.add(StartDateField);
		
		JPanel launch = new JPanel();
		layeredPane.add(launch, "name_279540375478299");
		launch.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(0, 0, 914, 496);
		launch.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_6.setBounds(0, 16, 733, 480);
		panel_5.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(SystemColor.textHighlight);
		panel_7.setBounds(0, 0, 737, 59);
		panel_6.add(panel_7);
		
		JLabel lblLaunchEvent_1 = new JLabel("Launch Event");
		lblLaunchEvent_1.setForeground(Color.WHITE);
		lblLaunchEvent_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblLaunchEvent_1.setBounds(276, 16, 179, 28);
		panel_7.add(lblLaunchEvent_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(SystemColor.textHighlight);
		panel_8.setBounds(0, 449, 737, 37);
		panel_6.add(panel_8);
		
		JLabel label_20 = new JLabel("Event name:");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_20.setBounds(86, 75, 102, 20);
		panel_6.add(label_20);
		
		JLabel label_21 = new JLabel("Venue:");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_21.setBounds(86, 183, 57, 20);
		panel_6.add(label_21);
		
		JLabel label_22 = new JLabel("Start Date:");
		label_22.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_22.setBounds(86, 219, 97, 20);
		panel_6.add(label_22);
		
		JLabel label_23 = new JLabel("Promo code:");
		label_23.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_23.setBounds(86, 324, 102, 20);
		panel_6.add(label_23);
		
		EventNameLField = new JTextField();
		EventNameLField.setEditable(false);
		EventNameLField.setColumns(10);
		EventNameLField.setBounds(253, 75, 191, 22);
		panel_6.add(EventNameLField);
		
		VenueLField = new JTextField();
		VenueLField.setEditable(false);
		VenueLField.setColumns(10);
		VenueLField.setBounds(253, 182, 116, 22);
		panel_6.add(VenueLField);
		
		PromoCodeLField = new JTextField();
		PromoCodeLField.setEditable(false);
		PromoCodeLField.setColumns(10);
		PromoCodeLField.setBounds(253, 322, 116, 22);
		panel_6.add(PromoCodeLField);
		
		JLabel label_25 = new JLabel("Event Description:");
		label_25.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_25.setBounds(86, 111, 149, 20);
		panel_6.add(label_25);
		
		JLabel label_26 = new JLabel("Capacity:");
		label_26.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_26.setBounds(86, 147, 102, 20);
		panel_6.add(label_26);
		
		CapacityLField = new JTextField();
		CapacityLField.setEditable(false);
		CapacityLField.setColumns(10);
		CapacityLField.setBounds(253, 146, 45, 22);
		panel_6.add(CapacityLField);
		
		EventDetailsLField = new JTextField();
		EventDetailsLField.setEditable(false);
		EventDetailsLField.setColumns(10);
		EventDetailsLField.setBounds(253, 108, 380, 25);
		panel_6.add(EventDetailsLField);
		
		StartDateLField = new JTextField();
		StartDateLField.setEditable(false);
		StartDateLField.setColumns(10);
		StartDateLField.setBounds(253, 216, 146, 26);
		panel_6.add(StartDateLField);
		
		JLabel label_27 = new JLabel("End Date:");
		label_27.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_27.setBounds(86, 255, 97, 20);
		panel_6.add(label_27);
		
		EndDateLField = new JTextField();
		EndDateLField.setEditable(false);
		EndDateLField.setColumns(10);
		EndDateLField.setBounds(253, 258, 146, 26);
		panel_6.add(EndDateLField);
		
		JLabel label_28 = new JLabel("Price/Seat($):");
		label_28.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_28.setBounds(86, 291, 128, 20);
		panel_6.add(label_28);
		
		PriceLField = new JTextField();
		PriceLField.setEditable(false);
		PriceLField.setColumns(10);
		PriceLField.setBounds(253, 290, 45, 22);
		panel_6.add(PriceLField);
		
		JLabel label_29 = new JLabel("Set Discount (%):");
		label_29.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_29.setBounds(412, 324, 161, 20);
		panel_6.add(label_29);
		
		DiscountLField = new JTextField();
		DiscountLField.setEditable(false);
		DiscountLField.setColumns(10);
		DiscountLField.setBounds(588, 321, 45, 22);
		panel_6.add(DiscountLField);
		
		lblLaunchEvent = new JLabel("Launch Event");
		lblLaunchEvent.setForeground(Color.WHITE);
		lblLaunchEvent.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblLaunchEvent.setBackground(Color.BLUE);
		lblLaunchEvent.setBounds(178, 112, 141, 36);
		panel_1.add(lblLaunchEvent);
		
		lblLaunchEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLaunchEvent.setForeground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLaunchEvent.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanels(launch);
			}
		});
		
		JPanel view_events = new JPanel();
		layeredPane.add(view_events, "name_294969694783300");
		view_events.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventNameLField.setText("");
				VenueLField.setText("");
				PromoCodeLField.setText("");
				CapacityLField.setText("");
				EventDetailsLField.setText("");
				StartDateLField.setText("");
				EndDateLField.setText("");
				PriceLField.setText("");
				DiscountLField.setText("");
				switchPanels(view_events);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBackground(SystemColor.textHighlight);
		btnExit.setBounds(524, 395, 109, 29);
		panel_6.add(btnExit);
		
		lblViewEvents = new JLabel("View Events");
		lblViewEvents.setForeground(Color.WHITE);
		lblViewEvents.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblViewEvents.setBackground(Color.BLUE);
		lblViewEvents.setBounds(334, 112, 141, 36);
		panel_1.add(lblViewEvents);
	
		Object [] columnNames = {"Event","Details","Start Date","End Date","Venue","Capacity","Price","Promocode","Discount"};
		
		DefaultTableModel dataModel = new DefaultTableModel();
		dataModel.setColumnIdentifiers(columnNames);
		Font font = new Font("",1,16);
		
		//Change file path here to your computer---------------------------------
		String FilePath = "C:\\Users\\malla\\Desktop\\database_Rahul\\"+uowID+".txt";
		//-------------------------------------------------------------------------
		
		File file = new File(FilePath);
		try {
			file.createNewFile(); 
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			Object [] lines = br.lines().toArray();
			
			for(int i = 0; i < lines.length; i++) {
				String [] dataRow = lines[i].toString().split("~");
				dataModel.addRow(dataRow);
			}
			try {
				br.close();
				fr.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		lblViewEvents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblViewEvents.setForeground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblViewEvents.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanels(view_events);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					dataModel.removeRow(i);
				}
				else {
					JOptionPane.showMessageDialog(null, "No item to delete!");
				}
			}
		});
		
		btnNewButton_1.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setBounds(15, 458, 137, 38);
		view_events.add(btnNewButton_1);
		
		JButton btnSendForLaunch = new JButton("Send For Launch");
		btnSendForLaunch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
				EventNameLField.setText(dataModel.getValueAt(i, 0).toString());
				EventDetailsLField.setText(dataModel.getValueAt(i, 1).toString());
				StartDateLField.setText(dataModel.getValueAt(i, 2).toString());
				EndDateLField.setText(dataModel.getValueAt(i, 3).toString());
				VenueLField.setText(dataModel.getValueAt(i, 4).toString());
				CapacityLField.setText(dataModel.getValueAt(i, 5).toString());
				PriceLField.setText(dataModel.getValueAt(i, 6).toString());
				PromoCodeLField.setText(dataModel.getValueAt(i, 7).toString());
				DiscountLField.setText(dataModel.getValueAt(i, 8).toString());
				
				JOptionPane.showMessageDialog(null, "Going to Launch Page!");
				switchPanels(launch);
				}
				else {
					JOptionPane.showMessageDialog(null, "No event to selected!");
				}
				
			}
		});
		btnSendForLaunch.setForeground(Color.WHITE);
		btnSendForLaunch.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnSendForLaunch.setBackground(SystemColor.textHighlight);
		btnSendForLaunch.setBounds(611, 458, 205, 38);
		view_events.add(btnSendForLaunch);
		
		table = new JTable();
		table.setBounds(10, 39, 806, 414);
		view_events.add(table);
		table.setModel(dataModel);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setFont(font);
		table.setRowHeight(20);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 39, 806, 414);
		view_events.add(scrollPane);
		
		Object [] row = new Object[10];
		
		JButton button_1 = new JButton("Create");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row[0] = EventNameField.getText();
				row[1] = EventDetailsField.getText();
				row[2] = StartDateField.getText();
				row[3] = EndDateField.getText();
				row[4] = VenueField.getText();
				row[5] = CapacityField.getText();
				row[6] = PriceField.getText();
				row[7] = PromoCodeField.getText();
				row[8] = DiscountField.getText();
				dataModel.addRow(row);
				
				JOptionPane.showMessageDialog(null, "Event Created!");
				switchPanels(view_events);
				
			}
		});

		JButton btnLaunch = new JButton("Launch");
		btnLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//-CHange file path here to your computer--------------------------------
				String filePath = "C:\\Users\\malla\\Desktop\\database_Rahul\\LaunchEvents.txt";
				//-----------------------------------------------------------------------
				File file = new File(filePath);
				try {
					file.createNewFile();
					FileWriter fw = new FileWriter(file,true);
					BufferedWriter bw = new BufferedWriter(fw);
					
					bw.write(EventNameLField.getText() + "~");
					bw.write(EventDetailsLField.getText() + "~");
					bw.write(StartDateLField.getText() + "~");
					bw.write(EndDateLField.getText() + "~");
					bw.write(VenueLField.getText() + "~");
					bw.write(CapacityLField.getText() + "~");
					bw.write(PriceLField.getText() + "~");
					bw.write(PromoCodeLField.getText() + "~");
					bw.write(DiscountLField.getText() + "~");
						
					bw.newLine();
					bw.close();
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Event Successfully Launched!");
			}
		});
		btnLaunch.setForeground(Color.WHITE);
		btnLaunch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLaunch.setBackground(SystemColor.textHighlight);
		btnLaunch.setBounds(86, 395, 116, 29);
		panel_6.add(btnLaunch);
		
		
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(86, 395, 116, 29);
		panel_2.add(button_1);
		
		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEndDate.setBounds(86, 255, 97, 20);
		panel_2.add(lblEndDate);
		
		EndDateField = new JTextField();
		EndDateField.setColumns(10);
		EndDateField.setBounds(253, 258, 146, 26);
		panel_2.add(EndDateField);
		
		JLabel lblDiscount = new JLabel("Price/Seat($):");
		lblDiscount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDiscount.setBounds(86, 291, 128, 20);
		panel_2.add(lblDiscount);
		
		PriceField = new JTextField();
		PriceField.setColumns(10);
		PriceField.setBounds(253, 290, 45, 22);
		panel_2.add(PriceField);
		
		JLabel lblSetDiscount = new JLabel("Set Discount (%):");
		lblSetDiscount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSetDiscount.setBounds(412, 324, 161, 20);
		panel_2.add(lblSetDiscount);
		
		DiscountField = new JTextField();
		DiscountField.setColumns(10);
		DiscountField.setBounds(588, 321, 45, 22);
		panel_2.add(DiscountField);
		
		JButton btnNewButton = new JButton("Save & Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File(FilePath);
				try {
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
		btnNewButton.setFont(new Font("Sitka Heading", Font.BOLD, 22));
		btnNewButton.setBounds(25, 599, 210, 29);
		panel.add(btnNewButton);
		
		JLabel lblUowId = new JLabel("UOW ID:");
		lblUowId.setForeground(Color.WHITE);
		lblUowId.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblUowId.setBounds(35, 441, 85, 35);
		panel.add(lblUowId);
		
		JLabel label_2 = new JLabel(uowID);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		label_2.setBounds(117, 441, 118, 35);
		panel.add(label_2);
		
	}
}

