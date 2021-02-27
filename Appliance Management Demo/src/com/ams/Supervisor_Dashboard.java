package com.ams;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Frame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Supervisor_Dashboard extends JFrame implements ActionListener,WindowListener,KeyListener
{

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_username;
	private JButton btn_Appliance,btn_Customer,btn_Dashboard,btn_View;
	private JPanel panel_Heading,panel_Menu;
	private JLayeredPane layeredPane;
	private JPanel panel_Dashboard;
	private JLabel lbl_Supervisor;
	private JLabel lbl_Appliance;
	private JLabel lbl_View;
	private JButton btn_Change_Password;
	private JButton btn_Refresh;
	private JLabel lbl_Refresh;
	private JButton btn_AddCustomer;
	private JButton btn_UpdateCustomer;
	private JButton btn_DeleteCustomer;
	private JPanel panel_Appliance;
	private JButton btn_AddAppliance;
	private JButton btn_DeleteAppliance;
	private JPanel panel_View;
	private JButton btn_Clients;
	private JButton btn_Staff;
	private JButton btn_Services;
	private JPanel panel_Customer;
	private JButton btn_Log_out;
	private JLabel lbl_credits;
	private JLabel lbl_copyright;
	private JLabel lbl_RequestHeading;
	private JButton btn_AddRequest;
	private JButton btn_UpdateRequest;
	private JButton btn_AllotRequest;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel panel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel panel_3;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JPanel panel_4;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JButton btn_Request;
	private JPanel panel_Request;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supervisor_Dashboard frame = new Supervisor_Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Supervisor_Dashboard()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Supervisor_Dashboard.class.getResource("/com/images/ML logo.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		this.addWindowListener(this);
		createGui();
		
		
 }
void createGui()
{
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 1610, 720);
	contentPane = new JPanel();
	contentPane.setFocusable(false);
	contentPane.setFocusTraversalKeysEnabled(false);
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	panel_Heading = new JPanel();
	panel_Heading.setBackground(new Color(255, 255, 255));
	panel_Heading.setBounds(0, 0, 1535, 96);
	contentPane.add(panel_Heading);
	panel_Heading.setLayout(null);
	
	JLabel lbl_Heading = new JLabel("ML APPLIANCES & SERVICES");
	lbl_Heading.setForeground(Color.GRAY);
	lbl_Heading.setBounds(new Rectangle(419, 5, 810, 73));
	lbl_Heading.setFont(new Font("Tahoma", Font.PLAIN, 60));
	panel_Heading.add(lbl_Heading);
	
	JLabel lbl_logo = new JLabel("");
	lbl_logo.setIcon(new ImageIcon(Supervisor_Dashboard.class.getResource("/com/images/ML Logo new.jpg")));
	lbl_logo.setBounds(10, 5, 122, 91);
	panel_Heading.add(lbl_logo);
	
	panel_Menu = new JPanel();
	panel_Menu.setBorder(new LineBorder(Color.WHITE, 2, true));
	panel_Menu.setBackground(Color.GRAY);
	panel_Menu.setBounds(10, 106, 304, 577);
	contentPane.add(panel_Menu);
	panel_Menu.setLayout(null);
	
	JLabel lbl_Welcome = new JLabel("WELCOME");
	lbl_Welcome.setBounds(28, 5, 266, 49);
	lbl_Welcome.setForeground(new Color(255, 255, 255));
	lbl_Welcome.setFont(new Font("Tahoma", Font.PLAIN, 56));
	panel_Menu.add(lbl_Welcome);
	
    btn_Appliance = new JButton("Appliance");
	btn_Appliance.setBorder(null);
	btn_Appliance.setOpaque(false);
	btn_Appliance.setBackground(Color.GRAY);
	btn_Appliance.setForeground(Color.WHITE);
	btn_Appliance.setFont(new Font("Tahoma", Font.PLAIN, 32));
	btn_Appliance.setBounds(98, 226, 143, 41);
	btn_Appliance.addActionListener(this);
	btn_Appliance.addKeyListener(this);
	panel_Menu.add(btn_Appliance);
	
	btn_Customer = new JButton("Customer");
	btn_Customer.setBorder(null);
	btn_Customer.setOpaque(false);
	btn_Customer.setBackground(Color.GRAY);
	btn_Customer.setForeground(Color.WHITE);
	btn_Customer.setFont(new Font("Tahoma", Font.PLAIN, 32));
	btn_Customer.setBounds(98, 175, 143, 41);
	btn_Customer.addActionListener(this);
	btn_Customer.addKeyListener(this);
	panel_Menu.add(btn_Customer);
	
	btn_Dashboard = new JButton("Dashboard");
	btn_Dashboard.setOpaque(false);
	btn_Dashboard.setBorder(null);
	btn_Dashboard.setBackground(Color.GRAY);
	btn_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 30));
	btn_Dashboard.setForeground(Color.WHITE);
	btn_Dashboard.setBounds(97, 124, 156, 41);
	btn_Dashboard.addActionListener(this);
	btn_Dashboard.addKeyListener(this);
	panel_Menu.add(btn_Dashboard);
	
	txt_username = new JTextField();
	txt_username.setForeground(Color.WHITE);
	txt_username.setFont(new Font("Cambria Math", Font.BOLD, 24));
	txt_username.setBorder(new LineBorder(new Color(171, 173, 179), 2));
	txt_username.setOpaque(false);
	txt_username.setEditable(false);
	txt_username.setBounds(28, 65, 266, 49);
	panel_Menu.add(txt_username);
	txt_username.setColumns(10);
	
	btn_View = new JButton("View");
	btn_View.setBorder(null);
	btn_View.setOpaque(false);
	btn_View.setBackground(Color.GRAY);
	btn_View.setForeground(Color.WHITE);
	btn_View.setFont(new Font("Tahoma", Font.PLAIN, 34));
	btn_View.setBounds(119, 328, 91, 35);
	btn_View.addActionListener(this);
	btn_View.addKeyListener(this);
	panel_Menu.add(btn_View);
	
	layeredPane = new JLayeredPane();
	layeredPane.setBounds(336, 168, 1108, 515);
	contentPane.add(layeredPane);
	layeredPane.setLayout(new CardLayout(0, 0));
	
	panel_Dashboard = new JPanel();
	panel_Dashboard.setBorder(new LineBorder(Color.GRAY, 2, true));
	panel_Dashboard.setBackground(Color.WHITE);
	layeredPane.add(panel_Dashboard, "name_2531033503084500");
	panel_Dashboard.setLayout(null);
	
	btn_Change_Password = new JButton("");
	btn_Change_Password.setBackground(Color.RED);
	btn_Change_Password.setOpaque(false);
	btn_Change_Password.setIcon(new ImageIcon(Supervisor_Dashboard.class.getResource("/com/images/Password reset.png")));
	btn_Change_Password.setBounds(996, 207, 85, 55);
	btn_Change_Password.addActionListener(this);
	btn_Change_Password.addKeyListener(this);
	panel_Dashboard.add(btn_Change_Password);
	
	btn_Log_out = new JButton("");
	btn_Log_out.setBackground(Color.RED);
	btn_Log_out.setOpaque(false);
	btn_Log_out.setIcon(new ImageIcon(Supervisor_Dashboard.class.getResource("/com/images/Login new.png")));
	btn_Log_out.setBounds(996, 344, 85, 73);
	btn_Log_out.addActionListener(this);
	btn_Log_out.addKeyListener(this);
	panel_Dashboard.add(btn_Log_out);
	
	JLabel lbl_Change_Password = new JLabel("Change Password");
	lbl_Change_Password.setFont(new Font("Tahoma", Font.BOLD, 14));
	lbl_Change_Password.setBounds(969, 272, 129, 31);
	panel_Dashboard.add(lbl_Change_Password);
	
	JLabel lbl_Log_Out = new JLabel("Log Out");
	lbl_Log_Out.setFont(new Font("Tahoma", Font.BOLD, 16));
	lbl_Log_Out.setBounds(1006, 427, 75, 23);
	panel_Dashboard.add(lbl_Log_Out);
	
	btn_Refresh = new JButton("");
	btn_Refresh.setBackground(Color.RED);
	btn_Refresh.setOpaque(false);
	btn_Refresh.setIcon(new ImageIcon(Supervisor_Dashboard.class.getResource("/com/images/Refresh.png")));
	btn_Refresh.setBounds(996, 40, 80, 68);
	btn_Refresh.addActionListener(this);
	btn_Refresh.addKeyListener(this);
	panel_Dashboard.add(btn_Refresh);
	
	lbl_Refresh = new JLabel("Refresh");
	lbl_Refresh.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lbl_Refresh.setBounds(1006, 118, 69, 31);
	panel_Dashboard.add(lbl_Refresh);
	
	lblNewLabel = new JLabel("DASHBOARD");
	lblNewLabel.setForeground(Color.GRAY);
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 55));
	lblNewLabel.setBounds(393, 10, 355, 79);
	panel_Dashboard.add(lblNewLabel);
	
	panel_1 = new JPanel();
	panel_1.setLayout(null);
	panel_1.setBorder(new LineBorder(Color.GRAY, 1, true));
	panel_1.setBackground(Color.WHITE);
	panel_1.setBounds(33, 129, 372, 142);
	panel_Dashboard.add(panel_1);
	
	lblNewLabel_1 = new JLabel("Address");
	lblNewLabel_1.setForeground(Color.BLACK);
	lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 24));
	lblNewLabel_1.setBounds(132, 10, 106, 35);
	panel_1.add(lblNewLabel_1);
	
	lblNewLabel_2 = new JLabel("  112/14 Street No 4 Barabanki Uttar Pradesh");
	lblNewLabel_2.setForeground(Color.GRAY);
	lblNewLabel_2.setFont(new Font("Cambria Math", Font.BOLD, 18));
	lblNewLabel_2.setBounds(0, 43, 362, 53);
	panel_1.add(lblNewLabel_2);
	
	lblNewLabel_3 = new JLabel("Pin Code : 225001");
	lblNewLabel_3.setForeground(Color.GRAY);
	lblNewLabel_3.setFont(new Font("Cambria Math", Font.BOLD, 22));
	lblNewLabel_3.setBounds(10, 94, 335, 38);
	panel_1.add(lblNewLabel_3);
	
	panel_2 = new JPanel();
	panel_2.setLayout(null);
	panel_2.setBorder(new LineBorder(Color.GRAY, 1, true));
	panel_2.setBackground(Color.WHITE);
	panel_2.setBounds(500, 129, 372, 142);
	panel_Dashboard.add(panel_2);
	
	lblNewLabel_4 = new JLabel("Contact Details");
	lblNewLabel_4.setFont(new Font("Cambria Math", Font.BOLD, 24));
	lblNewLabel_4.setBounds(117, 10, 181, 29);
	panel_2.add(lblNewLabel_4);
	
	lblNewLabel_5 = new JLabel("agamrgm@gmail.com");
	lblNewLabel_5.setForeground(Color.GRAY);
	lblNewLabel_5.setFont(new Font("Cambria Math", Font.BOLD, 22));
	lblNewLabel_5.setBounds(10, 57, 352, 29);
	panel_2.add(lblNewLabel_5);
	
	lblNewLabel_6 = new JLabel("abhijeetsrivastava3967@gmail.com");
	lblNewLabel_6.setForeground(Color.GRAY);
	lblNewLabel_6.setFont(new Font("Cambria Math", Font.BOLD, 21));
	lblNewLabel_6.setBounds(10, 96, 352, 36);
	panel_2.add(lblNewLabel_6);
	
	panel_3 = new JPanel();
	panel_3.setLayout(null);
	panel_3.setBorder(new LineBorder(Color.GRAY, 1, true));
	panel_3.setBackground(Color.WHITE);
	panel_3.setBounds(38, 323, 367, 142);
	panel_Dashboard.add(panel_3);
	
	lblNewLabel_7 = new JLabel("Timing");
	lblNewLabel_7.setForeground(Color.BLACK);
	lblNewLabel_7.setFont(new Font("Cambria Math", Font.BOLD, 24));
	lblNewLabel_7.setBounds(131, 10, 127, 33);
	panel_3.add(lblNewLabel_7);
	
	lblNewLabel_8 = new JLabel("Opens from 10 am to 7 pm");
	lblNewLabel_8.setForeground(Color.GRAY);
	lblNewLabel_8.setFont(new Font("Cambria Math", Font.BOLD, 23));
	lblNewLabel_8.setBounds(10, 49, 347, 42);
	panel_3.add(lblNewLabel_8);
	
	lblNewLabel_9 = new JLabel("Saturday and Sunday Closed");
	lblNewLabel_9.setForeground(Color.GRAY);
	lblNewLabel_9.setFont(new Font("Cambria Math", Font.BOLD, 24));
	lblNewLabel_9.setBounds(10, 90, 347, 42);
	panel_3.add(lblNewLabel_9);
	
	panel_4 = new JPanel();
	panel_4.setLayout(null);
	panel_4.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
	panel_4.setBackground(Color.WHITE);
	panel_4.setBounds(505, 323, 367, 142);
	panel_Dashboard.add(panel_4);
	
	lblNewLabel_10 = new JLabel("Motto");
	lblNewLabel_10.setFont(new Font("Cambria Math", Font.BOLD, 27));
	lblNewLabel_10.setBounds(144, 10, 95, 37);
	panel_4.add(lblNewLabel_10);
	
	lblNewLabel_11 = new JLabel("You Buy It , We Care it");
	lblNewLabel_11.setForeground(Color.GRAY);
	lblNewLabel_11.setFont(new Font("Bahnschrift", Font.BOLD, 32));
	lblNewLabel_11.setBounds(10, 59, 347, 59);
	panel_4.add(lblNewLabel_11);
	
	panel_Customer = new JPanel();
	panel_Customer.setBorder(new LineBorder(Color.WHITE, 2, true));
	panel_Customer.setBackground(Color.GRAY);
	layeredPane.add(panel_Customer, "name_2534219356449700");
	panel_Customer.setLayout(null);
	
	btn_AddCustomer = new JButton("Add Customer");
	btn_AddCustomer.setForeground(Color.WHITE);
	btn_AddCustomer.setOpaque(false);
	btn_AddCustomer.setBorder(new LineBorder(Color.WHITE, 1, true));
	btn_AddCustomer.setFont(new Font("Cambria Math", Font.BOLD, 28));
	btn_AddCustomer.setBackground(Color.GRAY);
	btn_AddCustomer.setBounds(25, 224, 260, 55);
	btn_AddCustomer.addActionListener(this);
	btn_AddCustomer.addKeyListener(this);
	panel_Customer.add(btn_AddCustomer);
	
	btn_UpdateCustomer = new JButton("Update Customer");
	btn_UpdateCustomer.setBorder(new LineBorder(Color.WHITE, 1, true));
	btn_UpdateCustomer.setForeground(Color.WHITE);
	btn_UpdateCustomer.setOpaque(false);
	btn_UpdateCustomer.setFont(new Font("Cambria Math", Font.BOLD, 28));
	btn_UpdateCustomer.setBackground(Color.DARK_GRAY);
	btn_UpdateCustomer.setBounds(443, 224, 272, 55);
	btn_UpdateCustomer.addActionListener(this);
	btn_UpdateCustomer.addKeyListener(this);
	panel_Customer.add(btn_UpdateCustomer);
	
	btn_DeleteCustomer = new JButton("Delete Customer");
	btn_DeleteCustomer.setForeground(Color.WHITE);
	btn_DeleteCustomer.setBorder(new LineBorder(Color.WHITE, 1, true));
	btn_DeleteCustomer.setOpaque(false);
	btn_DeleteCustomer.setFont(new Font("Cambria Math", Font.BOLD, 28));
	btn_DeleteCustomer.setBackground(Color.DARK_GRAY);
	btn_DeleteCustomer.setBounds(826, 223, 260, 56);
	btn_DeleteCustomer.addActionListener(this);
	btn_DeleteCustomer.addKeyListener(this);
	panel_Customer.add(btn_DeleteCustomer);
	
	JLabel lbl_CustomerHeading = new JLabel("Customer");
	lbl_CustomerHeading.setForeground(Color.WHITE);
	lbl_CustomerHeading.setFont(new Font("Cambria Math", Font.BOLD, 60));
	lbl_CustomerHeading.setBounds(443, 29, 327, 81);
	panel_Customer.add(lbl_CustomerHeading);
	
	panel_Appliance = new JPanel();
	panel_Appliance.setBorder(new LineBorder(Color.WHITE, 2, true));
	panel_Appliance.setBackground(Color.GRAY);
	layeredPane.add(panel_Appliance, "name_2538914228255900");
	panel_Appliance.setLayout(null);
	
	btn_AddAppliance = new JButton("Add Appliance");
	btn_AddAppliance.setForeground(Color.WHITE);
	btn_AddAppliance.setBorder(new LineBorder(Color.WHITE, 1, true));
	btn_AddAppliance.setBackground(Color.RED);
	btn_AddAppliance.setOpaque(false);
	btn_AddAppliance.setFont(new Font("Cambria Math", Font.BOLD, 30));
	btn_AddAppliance.setBounds(53, 241, 227, 56);
	btn_AddAppliance.addActionListener(this);
	btn_AddAppliance.addKeyListener(this);
	panel_Appliance.add(btn_AddAppliance);
	
	btn_DeleteAppliance = new JButton("Delete Appliance");
	btn_DeleteAppliance.setBorder(new LineBorder(Color.WHITE, 1, true));
	btn_DeleteAppliance.setForeground(Color.WHITE);
	btn_DeleteAppliance.setBackground(Color.RED);
	btn_DeleteAppliance.setOpaque(false);
	btn_DeleteAppliance.setFont(new Font("Cambria Math", Font.BOLD, 28));
	btn_DeleteAppliance.setBounds(829, 241, 235, 56);
	btn_DeleteAppliance.addActionListener(this);
	btn_DeleteAppliance.addKeyListener(this);
	panel_Appliance.add(btn_DeleteAppliance);
	
	JLabel lbl_ApplianceHeading = new JLabel("Appliance");
	lbl_ApplianceHeading.setForeground(Color.WHITE);
	lbl_ApplianceHeading.setFont(new Font("Cambria Math", Font.BOLD, 66));
	lbl_ApplianceHeading.setBounds(421, 23, 337, 85);
	panel_Appliance.add(lbl_ApplianceHeading);
	
	panel_View = new JPanel();
	panel_View.setBorder(new LineBorder(Color.WHITE, 2, true));
	panel_View.setBackground(Color.GRAY);
	layeredPane.add(panel_View, "name_2539827171987600");
	panel_View.setLayout(null);
	
	btn_Clients = new JButton("View Clients");
	btn_Clients.setForeground(Color.WHITE);
	btn_Clients.setBorder(new LineBorder(Color.WHITE, 1, true));
	btn_Clients.setOpaque(false);
	btn_Clients.setBackground(Color.RED);
	btn_Clients.setFont(new Font("Cambria Math", Font.BOLD, 28));
	btn_Clients.setBounds(51, 224, 226, 59);
	btn_Clients.addActionListener(this);
	btn_Clients.addKeyListener(this);
	panel_View.add(btn_Clients);
	
	btn_Staff = new JButton("View Staff");
	btn_Staff.setBorder(new LineBorder(Color.WHITE, 1, true));
	btn_Staff.setForeground(Color.WHITE);
	btn_Staff.setOpaque(false);
	btn_Staff.setFont(new Font("Cambria Math", Font.BOLD, 30));
	btn_Staff.setBackground(Color.RED);
	btn_Staff.setBounds(467, 224, 214, 59);
	btn_Staff.addActionListener(this);
	btn_Staff.addKeyListener(this);
	panel_View.add(btn_Staff);
	
	btn_Services = new JButton("View Services");
	btn_Services.setForeground(Color.WHITE);
	btn_Services.setBorder(new LineBorder(Color.WHITE, 1, true));
	btn_Services.setOpaque(false);
	btn_Services.setFont(new Font("Cambria Math", Font.BOLD, 30));
	btn_Services.setBackground(Color.RED);
	btn_Services.setBounds(854, 224, 220, 59);
	btn_Services.addActionListener(this);
	btn_Services.addKeyListener(this);
	panel_View.add(btn_Services);
	
	JLabel lbl_ViewHeading = new JLabel("View");
	lbl_ViewHeading.setFont(new Font("Cambria Math", Font.BOLD, 58));
	lbl_ViewHeading.setForeground(Color.WHITE);
	lbl_ViewHeading.setBounds(489, 10, 214, 89);
	panel_View.add(lbl_ViewHeading);
	
	panel_Request = new JPanel();
	panel_Request.setBorder(new LineBorder(Color.WHITE, 2, true));
	panel_Request.setBackground(Color.GRAY);
	layeredPane.add(panel_Request, "name_1704471170203400");
	panel_Request.setLayout(null);
	
	lbl_RequestHeading = new JLabel("Request");
	lbl_RequestHeading.setForeground(Color.WHITE);
	lbl_RequestHeading.setFont(new Font("Cambria Math", Font.BOLD, 64));
	lbl_RequestHeading.setBounds(510, 10, 314, 81);
	panel_Request.add(lbl_RequestHeading);
	
	btn_AddRequest = new JButton("Add Request");
	btn_AddRequest.setOpaque(false);
	btn_AddRequest.setForeground(Color.WHITE);
	btn_AddRequest.setFont(new Font("Cambria Math", Font.BOLD, 31));
	btn_AddRequest.setBorder(new LineBorder(Color.WHITE, 1, true));
	btn_AddRequest.setBackground(Color.GRAY);
	btn_AddRequest.setBounds(10, 206, 260, 55);
	btn_AddRequest.addActionListener(this);
	btn_AddRequest.addKeyListener(this);
	panel_Request.add(btn_AddRequest);
	
	btn_UpdateRequest = new JButton("Update Request");
	btn_UpdateRequest.addActionListener(this);
	btn_UpdateRequest.addKeyListener(this);	
	btn_UpdateRequest.setOpaque(false);
	btn_UpdateRequest.setForeground(Color.WHITE);
	btn_UpdateRequest.setFont(new Font("Cambria Math", Font.BOLD, 28));
	btn_UpdateRequest.setBorder(new LineBorder(Color.WHITE, 1, true));
	btn_UpdateRequest.setBackground(Color.GRAY);
	btn_UpdateRequest.setBounds(409, 206, 260, 55);
	panel_Request.add(btn_UpdateRequest);
	
	btn_AllotRequest = new JButton("Allot Request");
	btn_AllotRequest.setOpaque(false);
	btn_AllotRequest.setForeground(Color.WHITE);
	btn_AllotRequest.setFont(new Font("Cambria Math", Font.BOLD, 28));
	btn_AllotRequest.setBorder(new LineBorder(Color.WHITE, 1, true));
	btn_AllotRequest.setBackground(Color.GRAY);
	btn_AllotRequest.setBounds(795, 206, 260, 55);
	btn_AllotRequest.addKeyListener(this);
	btn_AllotRequest.addActionListener(this);
	panel_Request.add(btn_AllotRequest);
	txt_username.setText(Login.userid);
	
	JLabel lbl_Dashboard = new JLabel("");
	lbl_Dashboard.setIcon(new ImageIcon(Supervisor_Dashboard.class.getResource("/com/images/dashboard new.png")));
	lbl_Dashboard.setBounds(55, 133, 30, 27);
	panel_Menu.add(lbl_Dashboard);
	
	lbl_Supervisor = new JLabel("");
	lbl_Supervisor.setIcon(new ImageIcon(Supervisor_Dashboard.class.getResource("/com/images/supervisor.png")));
	lbl_Supervisor.setBounds(55, 181, 30, 27);
	panel_Menu.add(lbl_Supervisor);
	
	lbl_Appliance = new JLabel("");
	lbl_Appliance.setIcon(new ImageIcon(Supervisor_Dashboard.class.getResource("/com/images/Appliance.png")));
	lbl_Appliance.setBounds(55, 235, 33, 27);
	panel_Menu.add(lbl_Appliance);
	
	lbl_View = new JLabel("");
	lbl_View.setIcon(new ImageIcon(Supervisor_Dashboard.class.getResource("/com/images/View new.png")));
	lbl_View.setBounds(55, 334, 30, 27);
	panel_Menu.add(lbl_View);
	
	lbl_credits = new JLabel("CREDITS");
	lbl_credits.setFont(new Font("Verdana", Font.PLAIN, 22));
	lbl_credits.setForeground(Color.WHITE);
	lbl_credits.setBounds(98, 505, 104, 27);
	panel_Menu.add(lbl_credits);
	
	lbl_copyright = new JLabel("All copyright @ ML Softwares");
	lbl_copyright.setFont(new Font("Tw Cen MT", Font.PLAIN, 21));
	lbl_copyright.setForeground(Color.WHITE);
	lbl_copyright.setBounds(28, 542, 266, 27);
	panel_Menu.add(lbl_copyright);
	
	btn_Request = new JButton("Request");
	btn_Request.addActionListener(this);
	btn_Request.addKeyListener(this);	
	btn_Request.setOpaque(false);
	btn_Request.setForeground(Color.WHITE);
	btn_Request.setFont(new Font("Tahoma", Font.PLAIN, 33));
	btn_Request.setBorder(null);
	btn_Request.setBackground(Color.GRAY);
	btn_Request.setBounds(98, 277, 129, 41);
	panel_Menu.add(btn_Request);
	
	JLabel lbl_View_1 = new JLabel("");
	lbl_View_1.setIcon(new ImageIcon(Supervisor_Dashboard.class.getResource("/com/images/Service Request.png")));
	lbl_View_1.setBounds(55, 287, 30, 27);
	panel_Menu.add(lbl_View_1);
}




public void switchPanels(JPanel panel)
{
	layeredPane.removeAll();
	layeredPane.add(panel);
	layeredPane.repaint();
	layeredPane.revalidate();
	
}








@Override
public void actionPerformed(ActionEvent ae) 
{
	txt_username.setText(Login.userid);
	
	if(ae.getSource()==btn_Dashboard)
		switchPanels(panel_Dashboard);
	
	if(ae.getSource()==btn_Customer)
		switchPanels(panel_Customer);
	
	if(ae.getSource()==btn_Appliance)
		switchPanels(panel_Appliance);
	
	if(ae.getSource()==btn_View)
	   switchPanels(panel_View);
	
	if(ae.getSource()==btn_Request)
		   switchPanels(panel_Request);
	
	if(ae.getSource()==btn_Change_Password)
	{
		Change_Password_Admin cpa = new Change_Password_Admin();
		cpa.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_Log_out)
	{
		this.dispose();
		Login l = new Login();
		l.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_Refresh)
	{
	   this.setVisible(false);
	   this.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_AddCustomer)
	{
		Add_Customer ac = new Add_Customer();
		ac.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_UpdateCustomer)
	{
		Update_Customer uc = new Update_Customer();
		uc.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_DeleteCustomer)
	{
		Delete_Customer dc = new Delete_Customer();
		dc.setVisible(true);
		
	}
		
	if(ae.getSource()==btn_AddAppliance)
	{
		Add_Appliance aa = new Add_Appliance();
		aa.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_DeleteAppliance)
	{
		Delete_Appliance da = new Delete_Appliance();
		da.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_Staff)
	{
		Table_View_Engineer_Details tved = new Table_View_Engineer_Details();
		tved.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_Clients)
	{
		Table_View_Customer_Details tvcd = new Table_View_Customer_Details();
		tvcd.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_Services)
	{
		Table_View_All_Service_Done tvasd = new Table_View_All_Service_Done();
		tvasd.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_AddRequest)
	{
		Add_Service_Request_Supervisor asrs = new Add_Service_Request_Supervisor();
		asrs.setVisible(true);
		
	}
	if(ae.getSource()==btn_UpdateRequest)
	{
		Update_Service_Request_Supervisor usrs = new Update_Service_Request_Supervisor();
		usrs.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_AllotRequest)
	{
		Allot_Service_Request asr = new Allot_Service_Request();
		asr.setVisible(true);
		
	}
	
	
	
}

@Override
public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent e) {
	Login l = new Login();
	l.setVisible(true);
	
}

@Override
public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowIconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeiconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowActivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeactivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent ae) 
{
	
	int check = ae.getKeyCode();
	if(check==10)
	{
	if(ae.getSource()==btn_Dashboard)
		switchPanels(panel_Dashboard);
	
	if(ae.getSource()==btn_Customer)
		switchPanels(panel_Customer);
	
	if(ae.getSource()==btn_Appliance)
		switchPanels(panel_Appliance);
	
	if(ae.getSource()==btn_View)
	   switchPanels(panel_View);
	
	if(ae.getSource()==btn_Request)
		   switchPanels(panel_Request);
	
	if(ae.getSource()==btn_Change_Password)
	{
		Change_Password_Admin cpa = new Change_Password_Admin();
		cpa.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_Log_out)
	{
		this.dispose();
		Login l = new Login();
		l.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_Refresh)
	{
	   this.setVisible(false);
	   this.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_AddCustomer)
	{
		Add_Customer ac = new Add_Customer();
		ac.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_UpdateCustomer)
	{
		Update_Customer uc = new Update_Customer();
		uc.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_DeleteCustomer)
	{
		Delete_Customer dc = new Delete_Customer();
		dc.setVisible(true);
		
	}
		
	if(ae.getSource()==btn_AddAppliance)
	{
		Add_Appliance aa = new Add_Appliance();
		aa.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_DeleteAppliance)
	{
		Delete_Appliance da = new Delete_Appliance();
		da.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_Staff)
	{
		Table_View_Engineer_Details tved = new Table_View_Engineer_Details();
		tved.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_Clients)
	{
		Table_View_Customer_Details tvcd = new Table_View_Customer_Details();
		tvcd.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_Services)
	{
		Table_View_All_Service_Done tvasd = new Table_View_All_Service_Done();
		tvasd.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_AddRequest)
	{
		Add_Service_Request_Supervisor asrs = new Add_Service_Request_Supervisor();
		asrs.setVisible(true);
		
	}
	if(ae.getSource()==btn_UpdateRequest)
	{
		Update_Service_Request_Supervisor usrs = new Update_Service_Request_Supervisor();
		usrs.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_AllotRequest)
	{
		Allot_Service_Request asr = new Allot_Service_Request();
		asr.setVisible(true);
		
	}
	
	
	}	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}