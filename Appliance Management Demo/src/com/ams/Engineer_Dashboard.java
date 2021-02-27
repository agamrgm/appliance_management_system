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

public class Engineer_Dashboard extends JFrame implements ActionListener,WindowListener,KeyListener
{

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_username;
	private JButton btn_Request,btn_Dashboard,btn_View;
	private JPanel panel_Heading,panel_Menu;
	private JLayeredPane layeredPane;
	private JPanel panel_Dashboard;
	private JLabel lbl_Supervisor;
	private JLabel lbl_View;
	private JButton btn_Change_Password;
	private JButton btn_Refresh;
	private JLabel lbl_Refresh;
	private JButton btn_Log_out;
	private JLabel lbl_credits;
	private JLabel lbl_copyright;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel panel_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel panel_2;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JPanel panel_3;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JPanel panel_Request;
	private JPanel panel_View;
	private JButton btn_client_detail;
	private JButton btn_view_request;
	private JLabel lblNewLabel_12;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Engineer_Dashboard frame = new Engineer_Dashboard();
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
	public Engineer_Dashboard()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Engineer_Dashboard.class.getResource("/com/images/ML logo.png")));
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
	lbl_logo.setIcon(new ImageIcon(Engineer_Dashboard.class.getResource("/com/images/ML Logo new.jpg")));
	lbl_logo.setBounds(10, 5, 122, 91);
	panel_Heading.add(lbl_logo);
	
	panel_Menu = new JPanel();
	panel_Menu.setBorder(new LineBorder(Color.WHITE, 2, true));
	panel_Menu.setBackground(Color.GRAY);
	panel_Menu.setBounds(10, 100, 304, 583);
	contentPane.add(panel_Menu);
	panel_Menu.setLayout(null);
	
	JLabel lbl_Welcome = new JLabel("WELCOME");
	lbl_Welcome.setBounds(28, 5, 266, 49);
	lbl_Welcome.setForeground(new Color(255, 255, 255));
	lbl_Welcome.setFont(new Font("Tahoma", Font.PLAIN, 56));
	panel_Menu.add(lbl_Welcome);
	
	btn_Request = new JButton("Request");
	btn_Request.setBorder(null);
	btn_Request.setOpaque(false);
	btn_Request.setBackground(Color.GRAY);
	btn_Request.setForeground(Color.WHITE);
	btn_Request.setFont(new Font("Tahoma", Font.PLAIN, 32));
	btn_Request.setBounds(88, 175, 133, 41);
	btn_Request.addActionListener(this);
	btn_Request.addKeyListener(this);
	panel_Menu.add(btn_Request);
	
	btn_Dashboard = new JButton("Dashboard");
	btn_Dashboard.setOpaque(false);
	btn_Dashboard.setBorder(null);
	btn_Dashboard.setBackground(Color.GRAY);
	btn_Dashboard.setFont(new Font("Tahoma", Font.PLAIN, 30));
	btn_Dashboard.setForeground(Color.WHITE);
	btn_Dashboard.setBounds(88, 124, 152, 41);
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
	btn_View.setBounds(98, 226, 104, 35);
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
	btn_Change_Password.setIcon(new ImageIcon(Engineer_Dashboard.class.getResource("/com/images/Password reset.png")));
	btn_Change_Password.setBounds(996, 207, 85, 55);
	btn_Change_Password.addActionListener(this);
	btn_Change_Password.addKeyListener(this);
	panel_Dashboard.add(btn_Change_Password);
	
	btn_Log_out = new JButton("");
	btn_Log_out.setBackground(Color.RED);
	btn_Log_out.setOpaque(false);
	btn_Log_out.setIcon(new ImageIcon(Engineer_Dashboard.class.getResource("/com/images/Login new.png")));
	btn_Log_out.setBounds(996, 344, 85, 73);
	btn_Log_out.addKeyListener(this);
	btn_Log_out.addActionListener(this);
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
	btn_Refresh.setIcon(new ImageIcon(Engineer_Dashboard.class.getResource("/com/images/Refresh.png")));
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
	lblNewLabel.setBounds(331, 20, 355, 83);
	panel_Dashboard.add(lblNewLabel);
	
	panel = new JPanel();
	panel.setLayout(null);
	panel.setBorder(new LineBorder(Color.GRAY, 1, true));
	panel.setBackground(Color.WHITE);
	panel.setBounds(52, 137, 372, 142);
	panel_Dashboard.add(panel);
	
	lblNewLabel_1 = new JLabel("Address");
	lblNewLabel_1.setForeground(Color.BLACK);
	lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 24));
	lblNewLabel_1.setBounds(132, 10, 106, 35);
	panel.add(lblNewLabel_1);
	
	lblNewLabel_2 = new JLabel("  112/14 Street No 4 Barabanki Uttar Pradesh");
	lblNewLabel_2.setForeground(Color.GRAY);
	lblNewLabel_2.setFont(new Font("Cambria Math", Font.BOLD, 18));
	lblNewLabel_2.setBounds(0, 43, 362, 53);
	panel.add(lblNewLabel_2);
	
	lblNewLabel_3 = new JLabel("Pin Code : 225001");
	lblNewLabel_3.setForeground(Color.GRAY);
	lblNewLabel_3.setFont(new Font("Cambria Math", Font.BOLD, 22));
	lblNewLabel_3.setBounds(10, 94, 335, 38);
	panel.add(lblNewLabel_3);
	
	panel_1 = new JPanel();
	panel_1.setLayout(null);
	panel_1.setBorder(new LineBorder(Color.GRAY, 1, true));
	panel_1.setBackground(Color.WHITE);
	panel_1.setBounds(542, 137, 372, 142);
	panel_Dashboard.add(panel_1);
	
	lblNewLabel_4 = new JLabel("Contact Details");
	lblNewLabel_4.setFont(new Font("Cambria Math", Font.BOLD, 24));
	lblNewLabel_4.setBounds(117, 10, 181, 29);
	panel_1.add(lblNewLabel_4);
	
	lblNewLabel_5 = new JLabel("agamrgm@gmail.com");
	lblNewLabel_5.setForeground(Color.GRAY);
	lblNewLabel_5.setFont(new Font("Cambria Math", Font.BOLD, 22));
	lblNewLabel_5.setBounds(10, 57, 352, 29);
	panel_1.add(lblNewLabel_5);
	
	lblNewLabel_6 = new JLabel("abhijeetsrivastava3967@gmail.com");
	lblNewLabel_6.setForeground(Color.GRAY);
	lblNewLabel_6.setFont(new Font("Cambria Math", Font.BOLD, 21));
	lblNewLabel_6.setBounds(10, 96, 352, 36);
	panel_1.add(lblNewLabel_6);
	
	panel_2 = new JPanel();
	panel_2.setLayout(null);
	panel_2.setBorder(new LineBorder(Color.GRAY, 1, true));
	panel_2.setBackground(Color.WHITE);
	panel_2.setBounds(52, 324, 367, 142);
	panel_Dashboard.add(panel_2);
	
	lblNewLabel_7 = new JLabel("Timing");
	lblNewLabel_7.setForeground(Color.BLACK);
	lblNewLabel_7.setFont(new Font("Cambria Math", Font.BOLD, 24));
	lblNewLabel_7.setBounds(131, 10, 127, 33);
	panel_2.add(lblNewLabel_7);
	
	lblNewLabel_8 = new JLabel("Opens from 10 am to 7 pm");
	lblNewLabel_8.setForeground(Color.GRAY);
	lblNewLabel_8.setFont(new Font("Cambria Math", Font.BOLD, 23));
	lblNewLabel_8.setBounds(10, 49, 347, 42);
	panel_2.add(lblNewLabel_8);
	
	lblNewLabel_9 = new JLabel("Saturday and Sunday Closed");
	lblNewLabel_9.setForeground(Color.GRAY);
	lblNewLabel_9.setFont(new Font("Cambria Math", Font.BOLD, 24));
	lblNewLabel_9.setBounds(10, 90, 347, 42);
	panel_2.add(lblNewLabel_9);
	
	panel_3 = new JPanel();
	panel_3.setLayout(null);
	panel_3.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
	panel_3.setBackground(Color.WHITE);
	panel_3.setBounds(547, 324, 367, 142);
	panel_Dashboard.add(panel_3);
	
	lblNewLabel_10 = new JLabel("Motto");
	lblNewLabel_10.setFont(new Font("Cambria Math", Font.BOLD, 27));
	lblNewLabel_10.setBounds(144, 10, 95, 37);
	panel_3.add(lblNewLabel_10);
	
	lblNewLabel_11 = new JLabel("You Buy It , We Care it");
	lblNewLabel_11.setForeground(Color.GRAY);
	lblNewLabel_11.setFont(new Font("Bahnschrift", Font.BOLD, 32));
	lblNewLabel_11.setBounds(10, 59, 347, 59);
	panel_3.add(lblNewLabel_11);
	
	panel_Request = new JPanel();
	panel_Request.setBorder(new LineBorder(Color.WHITE, 1, true));
	panel_Request.setBackground(Color.WHITE);
	layeredPane.add(panel_Request, "name_2682719712306700");
	panel_Request.setLayout(null);
	
	panel_View = new JPanel();
	panel_View.setBorder(new LineBorder(Color.WHITE, 2, true));
	panel_View.setBackground(Color.GRAY);
	layeredPane.add(panel_View, "name_2682735920044200");
	panel_View.setLayout(null);
	
	btn_client_detail = new JButton("View Client");
	btn_client_detail.setForeground(Color.WHITE);
	btn_client_detail.setOpaque(false);
	btn_client_detail.setBorder(new LineBorder(Color.WHITE, 1, true));
	btn_client_detail.setBackground(Color.BLACK);
	btn_client_detail.setFont(new Font("Cambria Math", Font.BOLD, 30));
	btn_client_detail.setBounds(156, 200, 233, 55);
	btn_client_detail.addActionListener(this);
	btn_client_detail.addKeyListener(this);
	panel_View.add(btn_client_detail);
	
	btn_view_request = new JButton("View Request");
	btn_view_request.setBorder(new LineBorder(Color.WHITE, 1, true));
	btn_view_request.setOpaque(false);
	btn_view_request.setForeground(Color.WHITE);
	btn_view_request.setBackground(Color.BLACK);
	btn_view_request.setFont(new Font("Cambria Math", Font.BOLD, 30));
	btn_view_request.setBounds(745, 200, 238, 55);
	btn_view_request.addActionListener(this);
	btn_view_request.addKeyListener(this);
	panel_View.add(btn_view_request);
	
	lblNewLabel_12 = new JLabel("View");
	lblNewLabel_12.setForeground(Color.WHITE);
	lblNewLabel_12.setFont(new Font("Cambria Math", Font.BOLD, 65));
	lblNewLabel_12.setBounds(462, 36, 193, 70);
	panel_View.add(lblNewLabel_12);
	txt_username.setText(Login.userid);
	
	JLabel lbl_Dashboard = new JLabel("");
	lbl_Dashboard.setIcon(new ImageIcon(Engineer_Dashboard.class.getResource("/com/images/dashboard new.png")));
	lbl_Dashboard.setBounds(55, 133, 30, 27);
	panel_Menu.add(lbl_Dashboard);
	
	lbl_Supervisor = new JLabel("");
	lbl_Supervisor.setIcon(new ImageIcon(Engineer_Dashboard.class.getResource("/com/images/Service Request.png")));
	lbl_Supervisor.setBounds(55, 181, 30, 27);
	panel_Menu.add(lbl_Supervisor);
	
	lbl_View = new JLabel("");
	lbl_View.setIcon(new ImageIcon(Engineer_Dashboard.class.getResource("/com/images/View new.png")));
	lbl_View.setBounds(55, 230, 30, 27);
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
		this.setVisible(false);
		
		
	}
	
	if(ae.getSource()==btn_Dashboard)
		switchPanels(panel_Dashboard);
	
	if(ae.getSource()==btn_Request)
	{
		switchPanels(panel_Request);
		Update_Service_Request_Engineer usre = new Update_Service_Request_Engineer();
		usre.setVisible(true);
	
	}
	
	if(ae.getSource()==btn_View)
	{
		switchPanels(panel_View);
		
    }
	
	
	if(ae.getSource()==btn_client_detail)
	{
		Engineer_View_Customer_Details evcd = new Engineer_View_Customer_Details();
		evcd.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_view_request)
	{
		Table_View_Alloted_Request tvar = new Table_View_Alloted_Request();
		tvar.setVisible(true);
		
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
		this.setVisible(false);
		
		
	}
	
	if(ae.getSource()==btn_Dashboard)
		switchPanels(panel_Dashboard);
	
	if(ae.getSource()==btn_Request)
	{
		switchPanels(panel_Request);
		Update_Service_Request_Engineer usre = new Update_Service_Request_Engineer();
		usre.setVisible(true);
	
	}
	
	if(ae.getSource()==btn_View)
	{
		switchPanels(panel_View);
		
    }
	
	
	if(ae.getSource()==btn_client_detail)
	{
		Engineer_View_Customer_Details evcd = new Engineer_View_Customer_Details();
		evcd.setVisible(true);
		
	}
	
	if(ae.getSource()==btn_view_request)
	{
		Table_View_Alloted_Request tvar = new Table_View_Alloted_Request();
		tvar.setVisible(true);
		
	}
	
	}
	
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}