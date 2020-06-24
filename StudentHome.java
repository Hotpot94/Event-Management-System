package event_app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class StudentHome extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JTextField EventDetailsField;
	private JTextField PromoCodeField;
	private JLabel PriceLabel;
	private JTextField EventDetailsTextField_2;
	private String name, uowID;
	private int count;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login log1 = new Login();
					StudentHome frame = new StudentHome(log1.name, log1.uowid);
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
	
	public StudentHome(String name, String uowID) {
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
		lblNewLabel_3.setFont(new Font("Sitka Heading", Font.PLAIN, 22));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(15, 363, 264, 59);
		panel.add(lblNewLabel_3);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(264, 149, 914, 495);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel Events = new JPanel();
		layeredPane.add(Events, "name_360303847986800");
		
		JPanel BookEvent = new JPanel();
		layeredPane.add(BookEvent, "name_360318511138000");
		BookEvent.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_2.setBounds(0, 0, 914, 495);
		BookEvent.add(panel_2);
		
		JLabel label_1 = new JLabel("Event Name:");
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(37, 0, 142, 30);
		panel_2.add(label_1);
		
		JLabel EventNameLabel = new JLabel("(Name of data here from db)");
		EventNameLabel.setForeground(Color.DARK_GRAY);
		EventNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		EventNameLabel.setBackground(Color.WHITE);
		EventNameLabel.setBounds(171, 1, 264, 30);
		panel_2.add(EventNameLabel);
		
		EventDetailsField = new JTextField();
		EventDetailsField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		EventDetailsField.setEditable(false);
		EventDetailsField.setColumns(10);
		EventDetailsField.setBackground(Color.CYAN);
		EventDetailsField.setBounds(37, 137, 703, 122);
		panel_2.add(EventDetailsField);
		
		JLabel label_3 = new JLabel("Description:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(37, 113, 129, 23);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Total Cost:");
		label_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		label_4.setBounds(37, 361, 97, 27);
		panel_2.add(label_4);
		
		JLabel label_6 = new JLabel("No. of tickets:");
		label_6.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 18));
		label_6.setBounds(37, 318, 142, 27);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Venue:");
		label_7.setForeground(Color.DARK_GRAY);
		label_7.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		label_7.setBackground(Color.WHITE);
		label_7.setBounds(37, 46, 90, 21);
		panel_2.add(label_7);
		
		JLabel EventVenueLabel = new JLabel("(Venue data from db)");
		EventVenueLabel.setForeground(Color.DARK_GRAY);
		EventVenueLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		EventVenueLabel.setBackground(Color.WHITE);
		EventVenueLabel.setBounds(171, 46, 226, 23);
		panel_2.add(EventVenueLabel);
		
		JLabel label_9 = new JLabel("Available Seats: ");
		label_9.setForeground(Color.DARK_GRAY);
		label_9.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		label_9.setBounds(481, 6, 168, 19);
		panel_2.add(label_9);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 113, 703, 8);
		panel_2.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(37, 404, 703, 8);
		panel_2.add(separator_1);
		
		JLabel label_10 = new JLabel("Promo code:");
		label_10.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 22));
		label_10.setBounds(37, 275, 129, 27);
		panel_2.add(label_10);
		
		PromoCodeField = new JTextField();
		PromoCodeField.setEditable(false);
		PromoCodeField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		PromoCodeField.setColumns(10);
		PromoCodeField.setBounds(194, 275, 168, 30);
		panel_2.add(PromoCodeField);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(SystemColor.textHighlight);
		panel_3.setBounds(0, 460, 914, 35);
		panel_2.add(panel_3);
		
		JLabel label_5 = new JLabel("");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Sitka Small", Font.PLAIN, 16));
		label_5.setBounds(95, 10, 198, 14);
		panel_3.add(label_5);
		
		JLabel AvailableSeatsLabel = new JLabel("(data from db)");
		AvailableSeatsLabel.setForeground(Color.DARK_GRAY);
		AvailableSeatsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		AvailableSeatsLabel.setBounds(658, 6, 140, 21);
		panel_2.add(AvailableSeatsLabel);
		
		JLabel label_14 = new JLabel("$");
		label_14.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		label_14.setBounds(159, 361, 20, 27);
		panel_2.add(label_14);
		
		JLabel lblStartDate = new JLabel("Start Date: ");
		lblStartDate.setForeground(Color.DARK_GRAY);
		lblStartDate.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		lblStartDate.setBounds(481, 46, 122, 19);
		panel_2.add(lblStartDate);
		
		JLabel StartDateLabel = new JLabel("(data from db)");
		StartDateLabel.setForeground(Color.DARK_GRAY);
		StartDateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		StartDateLabel.setBounds(600, 47, 140, 21);
		panel_2.add(StartDateLabel);
		
		JLabel lblEndDate = new JLabel("End Date: ");
		lblEndDate.setForeground(Color.DARK_GRAY);
		lblEndDate.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		lblEndDate.setBounds(481, 89, 122, 19);
		panel_2.add(lblEndDate);
		
		JLabel EndDateLabel = new JLabel("(data from db)");
		EndDateLabel.setForeground(Color.DARK_GRAY);
		EndDateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		EndDateLabel.setBounds(600, 89, 140, 21);
		panel_2.add(EndDateLabel);
		
		JLabel lblPriceseat = new JLabel("Price/Seat($): ");
		lblPriceseat.setForeground(Color.DARK_GRAY);
		lblPriceseat.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		lblPriceseat.setBounds(391, 321, 142, 24);
		panel_2.add(lblPriceseat);
		
		PriceLabel = new JLabel("(data from db)");
		PriceLabel.setForeground(Color.DARK_GRAY);
		PriceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		PriceLabel.setBounds(534, 321, 142, 24);
		panel_2.add(PriceLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 20));
		comboBox.setEditable(true);
		comboBox.setBackground(Color.CYAN);
		comboBox.setBounds(192, 317, 59, 27);
		
		panel_2.add(comboBox);
		
		JLabel CalculateCostLabel = new JLabel(PriceLabel.getText());
		CalculateCostLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		CalculateCostLabel.setBounds(171, 360, 226, 27);
		panel_2.add(CalculateCostLabel);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double costPerSeat = Double.parseDouble(PriceLabel.getText());
				Double ticks = Double.parseDouble((String) comboBox.getSelectedItem());
				Double ticksCost = costPerSeat*ticks;
				CalculateCostLabel.setText(Double.toString(ticksCost));
				count = 0;
			}
		});
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Events);
				comboBox.setSelectedIndex(0);
				CalculateCostLabel.setText(PriceLabel.getText());
			}
		});
		
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(37, 416, 156, 30);
		panel_2.add(button_1);
		
		JLabel DiscountLabel = new JLabel("");
		DiscountLabel.setForeground(Color.DARK_GRAY);
		DiscountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		DiscountLabel.setBounds(529, 275, 34, 27);
		panel_2.add(DiscountLabel);
		
		JButton btnCalculate = new JButton("Apply");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count == 0) {
				Double icost = Double.parseDouble(CalculateCostLabel.getText());
				Double discount = (Double.parseDouble(DiscountLabel.getText()))/100;
				Double finalPrice = icost-(icost*discount);
				CalculateCostLabel.setText(String.valueOf(finalPrice));
				++count;
				}
			}
		});
		
		btnCalculate.setForeground(Color.WHITE);
		btnCalculate.setBackground(SystemColor.textHighlight);
		btnCalculate.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		btnCalculate.setBounds(391, 275, 129, 29);
		panel_2.add(btnCalculate);
		
		JLabel lblOff = new JLabel("% Off");
		lblOff.setForeground(Color.DARK_GRAY);
		lblOff.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblOff.setBounds(550, 275, 66, 27);
		panel_2.add(lblOff);
		
		JPanel viewBookings = new JPanel();
		layeredPane.add(viewBookings, "name_360356120046000");
		
		JPanel viewSelectedEvent = new JPanel();
		layeredPane.add(viewSelectedEvent, "name_360373423626400");
		viewSelectedEvent.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(0, 0, 914, 495);
		viewSelectedEvent.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_5.setBounds(0, 0, 914, 495);
		panel_4.add(panel_5);
		
		JLabel label_2 = new JLabel("Event Name:");
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(37, 0, 142, 30);
		panel_5.add(label_2);
		
		JLabel EventNameLabel_2 = new JLabel("(Name of data here from db)");
		EventNameLabel_2.setForeground(Color.DARK_GRAY);
		EventNameLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		EventNameLabel_2.setBackground(Color.WHITE);
		EventNameLabel_2.setBounds(171, 1, 264, 30);
		panel_5.add(EventNameLabel_2);
		
		EventDetailsTextField_2 = new JTextField();
		EventDetailsTextField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		EventDetailsTextField_2.setEditable(false);
		EventDetailsTextField_2.setColumns(10);
		EventDetailsTextField_2.setBackground(Color.CYAN);
		EventDetailsTextField_2.setBounds(37, 137, 703, 122);
		panel_5.add(EventDetailsTextField_2);
		
		JLabel label_8 = new JLabel("Description:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_8.setBounds(37, 113, 129, 23);
		panel_5.add(label_8);
		
		JLabel label_13 = new JLabel("Total Cost:");
		label_13.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		label_13.setBounds(37, 275, 97, 27);
		panel_5.add(label_13);
		
		JLabel lblEditNoOf = new JLabel("Edit No. of tickets:");
		lblEditNoOf.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 18));
		lblEditNoOf.setBounds(37, 318, 156, 27);
		panel_5.add(lblEditNoOf);
		
		JLabel label_17 = new JLabel("Venue:");
		label_17.setForeground(Color.DARK_GRAY);
		label_17.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		label_17.setBackground(Color.WHITE);
		label_17.setBounds(37, 46, 90, 21);
		panel_5.add(label_17);
		
		JLabel EventVenueLabel_2 = new JLabel("(Venue data from db)");
		EventVenueLabel_2.setForeground(Color.DARK_GRAY);
		EventVenueLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		EventVenueLabel_2.setBackground(Color.WHITE);
		EventVenueLabel_2.setBounds(171, 46, 226, 23);
		panel_5.add(EventVenueLabel_2);
		
		JLabel lblSeatsBooked = new JLabel("Seats Booked");
		lblSeatsBooked.setForeground(Color.DARK_GRAY);
		lblSeatsBooked.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		lblSeatsBooked.setBounds(481, 6, 168, 19);
		panel_5.add(lblSeatsBooked);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(37, 113, 703, 8);
		panel_5.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(37, 361, 703, 8);
		panel_5.add(separator_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setForeground(Color.WHITE);
		panel_6.setBackground(SystemColor.textHighlight);
		panel_6.setBounds(0, 460, 914, 35);
		panel_5.add(panel_6);
		
		JLabel BookedSeatsLabel_2 = new JLabel("(data from db)");
		BookedSeatsLabel_2.setForeground(Color.DARK_GRAY);
		BookedSeatsLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		BookedSeatsLabel_2.setBounds(658, 6, 140, 21);
		panel_5.add(BookedSeatsLabel_2);
		
		JLabel label_25 = new JLabel("$");
		label_25.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		label_25.setBounds(159, 275, 20, 27);
		panel_5.add(label_25);
		
		JLabel label_26 = new JLabel("Start Date: ");
		label_26.setForeground(Color.DARK_GRAY);
		label_26.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		label_26.setBounds(481, 46, 122, 19);
		panel_5.add(label_26);
		
		JLabel StartDateLabel_2 = new JLabel("(data from db)");
		StartDateLabel_2.setForeground(Color.DARK_GRAY);
		StartDateLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		StartDateLabel_2.setBounds(600, 47, 140, 21);
		panel_5.add(StartDateLabel_2);
		
		JLabel label_28 = new JLabel("End Date: ");
		label_28.setForeground(Color.DARK_GRAY);
		label_28.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		label_28.setBounds(481, 89, 122, 19);
		panel_5.add(label_28);
		
		JLabel EndDateLabel_2 = new JLabel("(data from db)");
		EndDateLabel_2.setForeground(Color.DARK_GRAY);
		EndDateLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		EndDateLabel_2.setBounds(600, 89, 140, 21);
		panel_5.add(EndDateLabel_2);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 20));
		comboBox_1.setEditable(true);
		comboBox_1.setBackground(Color.CYAN);
		comboBox_1.setBounds(219, 317, 59, 27);
		panel_5.add(comboBox_1);
		
		JLabel TotalCostLabel_2 = new JLabel("(data from db)");
		TotalCostLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		TotalCostLabel_2.setBounds(171, 275, 226, 27);
		panel_5.add(TotalCostLabel_2);
		
		Object [] columnNames = {"Event","Details","Start Date","End Date","Venue","Capacity","Price","Promocode","Discount"};
		
		JTable table = new JTable();
		table.setBounds(1, 1, 450, 0);
		Events.add(table);
		
		DefaultTableModel dataModel = new DefaultTableModel();
		dataModel.setColumnIdentifiers(columnNames);
		table.setModel(dataModel);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		Font font = new Font("",1,16);
		Events.setLayout(null);
		table.setFont(font);
		table.setRowHeight(20);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 5, 730, 402);
		Events.add(scrollPane);
		
		JButton btnNewButton = new JButton("Book ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i >= 0) {
					EventNameLabel.setText(dataModel.getValueAt(i,0).toString());
					EventDetailsField.setText(dataModel.getValueAt(i,1).toString());
					StartDateLabel.setText(dataModel.getValueAt(i, 2).toString());
					EndDateLabel.setText(dataModel.getValueAt(i,3).toString());
					EventVenueLabel.setText(dataModel.getValueAt(i,4).toString());
					AvailableSeatsLabel.setText(dataModel.getValueAt(i,5).toString());
					PriceLabel.setText(dataModel.getValueAt(i, 6).toString());
					PromoCodeField.setText(dataModel.getValueAt(i,7).toString());
					DiscountLabel.setText(dataModel.getValueAt(i,8).toString());
					int cap = Integer.parseInt(dataModel.getValueAt(i, 5).toString());
					for(int j = 1; j <= cap; j++) {
						comboBox.addItem(Integer.toString(j));
					}
					switchPanels(BookEvent);
				}
				else {
					JOptionPane.showMessageDialog(null, "No event selected!");
				}
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		btnNewButton.setBounds(15, 414, 159, 43);
		Events.add(btnNewButton);
		
		JButton btnViewBookings = new JButton("View Bookings");
		btnViewBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(viewBookings);
			}
		});
		btnViewBookings.setForeground(Color.WHITE);
		btnViewBookings.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
		btnViewBookings.setBackground(SystemColor.textHighlight);
		btnViewBookings.setBounds(553, 414, 187, 43);
		Events.add(btnViewBookings);
		
		JLabel lblNewLabel = new JLabel("List Of Events");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(277, 407, 173, 48);
		Events.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(264, 0, 914, 142);
		panel_1.setBackground(new Color(110,89,222));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(525, -30, 389, 207);
		panel_1.add(label);
		label.setIcon(new ImageIcon(Home.class.getResource("/images/LogoMakr_8jqcL0.png")));
		
		JLabel lblEditEvent = new JLabel("Event Booking System");
		lblEditEvent.setBounds(195, 90, 315, 52);
		panel_1.add(lblEditEvent);
		lblEditEvent.setForeground(Color.WHITE);
		lblEditEvent.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 25));
		//change file path to your computer here ------------------------------------
		String FilePath = "C:\\Users\\malla\\Desktop\\database_Rahul\\LaunchEvents.txt";
		//---------------------------------------------------------------------------
		File file = new File(FilePath);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			Object [] lines = br.lines().toArray();
			
			for(int i = 0; i < lines.length; i++) {
				String [] dataRow = lines[i].toString().split("~");
				dataModel.addRow(dataRow);
			}
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
        Object [] BookedColumnNames = {"Event","Details","Start Date","End Date","Venue","No Of Seats","Total Cost($)"};
		
		JTable table_1 = new JTable();
		table_1.setBounds(1, 1, 450, 0);
		viewBookings.add(table_1);
		
		DefaultTableModel dataModel_1 = new DefaultTableModel();
		dataModel_1.setColumnIdentifiers(BookedColumnNames);
		table_1.setModel(dataModel_1);
		table_1.setBackground(Color.WHITE);
		table_1.setForeground(Color.BLACK);
		viewBookings.setLayout(null);
		table_1.setFont(font);
		table_1.setRowHeight(20);
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(10, 5, 730, 402);
		viewBookings.add(scrollPane_1);
		
		//CHange file path here to your computer----------------------------------------
		String FilePathBook = "c:\\users\\malla\\Desktop\\database_Rahul\\"+uowID+".txt";
		//-----------------------------------------------------------------------------
		File fileBook = new File(FilePathBook);
		try {
			fileBook.createNewFile();
			FileReader fr = new FileReader(fileBook);
			BufferedReader br = new BufferedReader(fr);
			
			Object [] linesbook = br.lines().toArray();
			for(int i = 0; i < linesbook.length; i++) {
				String [] rowData = linesbook[i].toString().split("~");
				dataModel_1.addRow(rowData);
			}
			
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		
		JButton btnNewButton_1 = new JButton("Save & Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File file = new File(FilePathBook);
				File file_1 = new File(FilePath);
				try {
					int pane = JOptionPane.showConfirmDialog(null, "Confirm Logout!");
					if(pane == JOptionPane.YES_OPTION) {
						file.createNewFile();
						FileWriter fw = new FileWriter(file);
						BufferedWriter bw = new BufferedWriter(fw);
						for(int i = 0; i < table_1.getRowCount(); i++) { //rows
							for(int j = 0; j < table_1.getColumnCount(); j++) { //columns
								bw.write(table_1.getValueAt(i, j).toString() + "~");
							}
							bw.newLine();
						}
						bw.close();
						fw.close();
						
						fw = new FileWriter(file_1);
						bw = new BufferedWriter(fw);
						for(int i = 0; i < table.getRowCount(); i++) { //rows
							for(int j = 0; j < table.getColumnCount(); j++) { //columns
								bw.write(table.getValueAt(i, j).toString() + "~");
							}
							bw.newLine();
						}
						bw.close();
						fw.close();
						
						dispose();
						Login log = new Login();
						log.setUndecorated(true);
						log.setVisible(true);
						log.setLocationRelativeTo(null);
					}
				}catch(IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(35, 578, 187, 29);
		panel.add(btnNewButton_1);
		
		JLabel label_18 = new JLabel("UOW ID:");
		label_18.setBounds(35, 444, 86, 25);
		panel.add(label_18);
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 16));
		
		JLabel lblSomething = new JLabel(uowID);
		lblSomething.setBounds(122, 444, 100, 23);
		panel.add(lblSomething);
		lblSomething.setForeground(Color.WHITE);
		lblSomething.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JButton btnCancelBooking = new JButton("Cancel Booking");
		btnCancelBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i  = table_1.getSelectedRow();
				if(i >= 0) {
				int pane = JOptionPane.showConfirmDialog(null, "Are you sure? No money will be refunded");
					if(pane == JOptionPane.YES_OPTION) {
						dataModel_1.removeRow(i);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "No event selected!");
				}
			}
		});
		btnCancelBooking.setForeground(Color.WHITE);
		btnCancelBooking.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCancelBooking.setBackground(SystemColor.textHighlight);
		btnCancelBooking.setBounds(316, 423, 191, 43);
		viewBookings.add(btnCancelBooking);
		
		JButton btnEditBooking = new JButton("View / Edit Booking");
		btnEditBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_1.getSelectedRow();
				if(i >= 0) {
					EventNameLabel_2.setText(dataModel_1.getValueAt(i, 0).toString());
					EventDetailsTextField_2.setText(dataModel_1.getValueAt(i, 1).toString());
					StartDateLabel_2.setText(dataModel_1.getValueAt(i, 2).toString());
					EndDateLabel_2.setText(dataModel_1.getValueAt(i, 3).toString());
					EventVenueLabel_2.setText(dataModel_1.getValueAt(i, 4).toString());
					BookedSeatsLabel_2.setText(dataModel_1.getValueAt(i, 5).toString());
					TotalCostLabel_2.setText(dataModel_1.getValueAt(i, 6).toString());
					Integer Limit = Integer.parseInt(BookedSeatsLabel_2.getText());
					
					for(int x = 1; x <= Limit; x++) {
						comboBox_1.addItem(Integer.toString(x));
					}
					switchPanels(viewSelectedEvent);
					
				}else {
					JOptionPane.showMessageDialog(null, "No Booking Selected!");
				}
			}
		});
		btnEditBooking.setForeground(Color.WHITE);
		btnEditBooking.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnEditBooking.setBackground(SystemColor.textHighlight);
		btnEditBooking.setBounds(530, 423, 210, 43);
		viewBookings.add(btnEditBooking);
		
		JButton button_3 = new JButton("Back");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Events);
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		button_3.setBackground(SystemColor.textHighlight);
		button_3.setBounds(20, 423, 156, 43);
		viewBookings.add(button_3);
		
		Object [] row = new Object[8];
		
		JButton button = new JButton("Confirm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String confirmMessage = "Confirm Book "+(String)comboBox.getSelectedItem()+" seats and Pay $"+CalculateCostLabel.getText();
				if(AvailableSeatsLabel.getText().contentEquals("0")) {
					JOptionPane.showMessageDialog(null, "This event is fully booked!");
				}
				else {
				int i = JOptionPane.showConfirmDialog(null, confirmMessage);
				if(i == JOptionPane.YES_OPTION) {
					switchPanels(viewBookings);
					row[0] = EventNameLabel.getText();
					row[1] = EventDetailsField.getText();
					row[2] = StartDateLabel.getText();
					row[3] = EndDateLabel.getText();
					row[4] = EventVenueLabel.getText();
					row[5] = (String)comboBox.getSelectedItem();
					row[6] = CalculateCostLabel.getText();
					dataModel_1.addRow(row);
					int icap = Integer.parseInt(AvailableSeatsLabel.getText());
					int lcap = icap - Integer.parseInt(row[5].toString());
					AvailableSeatsLabel.setText(Integer.toString(lcap));
					int x = table.getSelectedRow();
					if(x >= 0) {
						dataModel.setValueAt(Integer.toString(lcap), x, 5);
					}
				}
				
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Times New Roman", Font.BOLD, 20));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(581, 416, 156, 30);
		panel_2.add(button);
		
		JButton button_4 = new JButton("Confirm");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pane = JOptionPane.showConfirmDialog(null, "Are you sure you want to proceed? NO AMOUNT WILL BE REFUNDED!");
				if(pane == JOptionPane.YES_OPTION) {
					int i  = table_1.getSelectedRow();
					dataModel_1.setValueAt((String)comboBox_1.getSelectedItem(), i, 5);
					BookedSeatsLabel_2.setText(dataModel_1.getValueAt(i, 5).toString());
					int icap = Integer.parseInt(AvailableSeatsLabel.getText());
					int itick = Integer.parseInt(comboBox_1.getItemAt(comboBox_1.getItemCount()-1).toString());
					int ltick = Integer.parseInt(comboBox_1.getSelectedItem().toString());
					int lcap = icap + (itick - ltick);
					AvailableSeatsLabel.setText(Integer.toString(lcap));
					int x = table.getSelectedRow();
					if(x >= 0) {
						dataModel.setValueAt(Integer.toString(lcap), x, 5);
					}
				}
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		button_4.setBackground(SystemColor.textHighlight);
		button_4.setBounds(584, 385, 156, 30);
		panel_5.add(button_4);
		
		JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(viewBookings);
				comboBox_1.removeAllItems();
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		button_2.setBackground(SystemColor.textHighlight);
		button_2.setBounds(37, 385, 156, 30);
		panel_5.add(button_2);
		
		
	}
}
