package com.ams;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.dbconnection.DataBaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.sql.*;
import java.awt.Toolkit;
//import java.awt.SystemColor;

public class Login extends JFrame implements ActionListener, WindowListener, KeyListener

{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_username;
	private JButton btn_Login;
	private static Login frame;
	private  JLabel lbl_captcha;
	
	private Connection  con;
	private PreparedStatement ps;
	private ResultSet rs;
	public static String userid;
	

	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Login();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/images/ML logo.png")));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/images/Logo.jpg")));
		setUndecorated(true);
		
		
		con=DataBaseConnection.connection();

		createGui();
		randomnumber();

		this.addWindowListener(this);

	}

	public void createGui() {
		{
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 875, 536);
			setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(255, 250, 205));
			contentPane.setBorder(new LineBorder(new Color(128, 128, 0), 4));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			txt_username = new JTextField();
			txt_username.setForeground(Color.WHITE);
			txt_username.setBorder(new LineBorder(Color.WHITE, 2, true));
			txt_username.setOpaque(false);
			txt_username.setBackground(new Color(227, 227, 227));
			txt_username.setFont(new Font("Cambria Math", Font.BOLD, 22));
			txt_username.setBounds(458, 120, 276, 38);
			contentPane.add(txt_username);
			txt_username.setColumns(20);

			btn_Login = new JButton("Login");
			btn_Login.setBackground(new Color(135, 206, 250));
			btn_Login.setOpaque(false);
			btn_Login.setForeground(Color.WHITE);
			btn_Login.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
			btn_Login.setFont(new Font("Cambria", Font.BOLD, 25));
			btn_Login.setBounds(428, 416, 121, 38);
			btn_Login.addActionListener(this);
			btn_Login.addKeyListener(this);
			contentPane.add(btn_Login);
			
			pwd_password = new JPasswordField();
			pwd_password.setForeground(Color.WHITE);
			pwd_password.setBorder(new LineBorder(Color.WHITE, 2, true));
			pwd_password.setOpaque(false);
			pwd_password.setFont(new Font("Cambria Math", Font.BOLD, 22));
			pwd_password.setEchoChar('*');
			pwd_password.setColumns(20);
			pwd_password.setBounds(458, 195, 276, 38);
			contentPane.add(pwd_password);
			
			lbl_warning = new JLabel("");
			lbl_warning.setForeground(Color.WHITE);
			lbl_warning.setFont(new Font("Candara", Font.ITALIC, 15));
			lbl_warning.setBounds(458, 316, 263, 20);
			contentPane.add(lbl_warning);
			
			lbl_captcha = new JLabel("Captcha");
			lbl_captcha.setBorder(new LineBorder(Color.WHITE, 2, true));
			lbl_captcha.setForeground(Color.WHITE);
			lbl_captcha.setFont(new Font("Cambria Math", Font.BOLD, 20));
			lbl_captcha.setBounds(458, 268, 276, 38);
			contentPane.add(lbl_captcha);
			
			txt_captcha = new JTextField();
			txt_captcha.setFont(new Font("Cambria Math", Font.BOLD, 22));
			txt_captcha.setForeground(Color.WHITE);
			txt_captcha.setOpaque(false);
			txt_captcha.setBorder(new LineBorder(Color.WHITE, 2, true));
			txt_captcha.setBounds(458, 350, 276, 38);
			contentPane.add(txt_captcha);
			txt_captcha.setColumns(10);
			
			btn_exit = new JButton("Exit");
			btn_exit.setBackground(new Color(173, 216, 230));
			btn_exit.setForeground(Color.WHITE);
			btn_exit.setBorder(new LineBorder(Color.WHITE, 3, true));
			btn_exit.setOpaque(false);
			btn_exit.setFont(new Font("Cambria", Font.BOLD, 25));
			btn_exit.setBounds(613, 416, 121, 38);
			btn_exit.addActionListener(this);
			btn_exit.addKeyListener(this);
			contentPane.add(btn_exit);
			
			lbl_Border = new JLabel("");
			lbl_Border.setFont(new Font("Cambria Math", Font.BOLD, 20));
			lbl_Border.setForeground(new Color(30, 144, 255));
			lbl_Border.setBorder(new LineBorder(Color.WHITE, 4, true));
			lbl_Border.setBounds(164, 81, 669, 394);
			contentPane.add(lbl_Border);
			
			lbl_UserName = new JLabel("User Name");
			lbl_UserName.setFont(new Font("Cambria", Font.BOLD, 30));
			lbl_UserName.setForeground(Color.WHITE);
			lbl_UserName.setBounds(212, 120, 179, 36);
			contentPane.add(lbl_UserName);
			
			lbl_Password = new JLabel("Password");
			lbl_Password.setForeground(Color.WHITE);
			lbl_Password.setFont(new Font("Cambria", Font.BOLD, 30));
			lbl_Password.setBounds(212, 188, 162, 38);
			contentPane.add(lbl_Password);
			
			lbl_Captcha = new JLabel("Captcha ");
			lbl_Captcha.setForeground(Color.WHITE);
			lbl_Captcha.setFont(new Font("Cambria", Font.BOLD, 30));
			lbl_Captcha.setBounds(212, 264, 149, 33);
			contentPane.add(lbl_Captcha);
			
			lbl_EnterCaptcha = new JLabel("Enter Captcha");
			lbl_EnterCaptcha.setForeground(Color.WHITE);
			lbl_EnterCaptcha.setFont(new Font("Cambria", Font.BOLD, 27));
			lbl_EnterCaptcha.setBounds(212, 340, 179, 49);
			contentPane.add(lbl_EnterCaptcha);
			
			lbl_Heading = new JLabel("ML Appliances & Services");
			lbl_Heading.setForeground(Color.WHITE);
			lbl_Heading.setFont(new Font("Cambria Math", Font.BOLD, 56));
			lbl_Heading.setBounds(164, 10, 669, 71);
			contentPane.add(lbl_Heading);
			
			lbl_Background = new JLabel("");
			lbl_Background.setIcon(new ImageIcon(Login.class.getResource("/com/images/Login1.jpg")));
			lbl_Background.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
			lbl_Background.setBounds(0, 0, 875, 536);
			contentPane.add(lbl_Background);
		}

	}

	private String username,password,captcha,caption;
	 char[] pwd;
	private JPasswordField pwd_password;
	private JLabel lbl_warning;
	private JTextField txt_captcha;
	
	
	
	int c = 1;
	String val;
	
	public void randomnumber()
	{
		
		Random ran = new Random();
		int n = ran.nextInt(100000)+1;
		 val = String.valueOf(n);
		lbl_captcha.setText(val);
		
	}
		
	String usertype,pass;
	
	public int fetchData(String username)
	{
	int flag=0;	
		
		try {
			
			
			String strsql=  "select * from login where username=?";
			
			ps = con.prepareStatement(strsql);
			ps.setString(1,username);
		    rs =	ps.executeQuery();
				if(rs.next())
				{
					pass = rs.getString("password");
					usertype = rs.getString("usertype");
					flag++;
						
							
				}
				else
					return flag;
			
		}
			
		catch(SQLException se)
		{
			
			
			System.out.println(se);
		}
	
		return flag;
		
				
	
	
		
	}
	
	
	
	
	

	public void actionPerformed(ActionEvent e) 
	{
		caption = e.getActionCommand();
		
		username = txt_username.getText();
		pwd = pwd_password.getPassword();
		captcha = txt_captcha.getText();
		
		password = String.valueOf(pwd);
		
		if(caption.contentEquals("Exit"))
		{
			
		
			System.exit(0);
			
			
		}
		
       
		if(caption.contentEquals("Login")) 
		{
 
		   if( checkEmpty())
		   {
		   System.out.println("All fields are mandatory");
		   }

		 
		
		else
		
		{

			System.out.println("The username is " + username);
			System.out.println("The password is " + password);
			System.out.println("The captcha is " +captcha);
			System.out.println("The value is " + val);

			credentials();

		}
		}
	}
	
	int attempts = 6;
	private JLabel lbl_Border;
	private JLabel lbl_UserName;
	private JLabel lbl_Password;
	private JLabel lbl_Captcha;
	private JLabel lbl_EnterCaptcha;
	private JLabel lbl_Heading;
	private JLabel lbl_Background;
	private JButton btn_exit;
	
	public void credentials() 
	{
          
          while(attempts!=0)
          {
		  
        	int flag =  fetchData(username);
        	if(flag!=0)
        	{
		  if(password.contentEquals(pass) && captcha.equals(val))
		  {
			  
				
				 
				 
			  if(usertype.equals("admin"))
			  {
				  userid=username;
				  Admin_Dashboard frame1= new Admin_Dashboard(); 
				  frame1.setVisible(true);
				  this.dispose();
			  }

			  
			  if(usertype.equals("supervisor"))
			  {
				  userid=username;
				  Supervisor_Dashboard frame2= new Supervisor_Dashboard(); 
				  frame2.setVisible(true);
				  this.dispose();
				  
			  }
			  
			  if(usertype.equals("engineer"))
			  {
				  userid=username;
				  Engineer_Dashboard frame3= new Engineer_Dashboard(); 
				  frame3.setVisible(true);
				  this.dispose();
			  }
				  
		  }
        	}
		  
		  else
		  {
			  attempts--;
			  JOptionPane.showMessageDialog(this, "Wrong username/password", "Error", JOptionPane.ERROR_MESSAGE);  
              randomnumber();
	        lbl_warning.setText("Invalid Pin "+attempts+" remaining");
		  }
		  return;
		  
          }
          if(attempts==0)
          {
        	  
        	JOptionPane.showMessageDialog(this,"Contact Admin or Try after reopening", "Error", JOptionPane.ERROR_MESSAGE); 
        	System.exit(0);
        }
		  }
	
		  
		  
		 


	public boolean checkEmpty() 
	{

		 if(username.isEmpty() )
		 {
			 JOptionPane.showMessageDialog(this, "Username is required", "Error", JOptionPane.ERROR_MESSAGE);
		    return true;
		 }
		 
				
	     if(password.isEmpty() ) 
	     {
	    	JOptionPane.showMessageDialog(this, "Password is required", "Error", JOptionPane.ERROR_MESSAGE);	
	    	return true;
	     }
	    	
	     if(captcha.isEmpty())
	     {
	         JOptionPane.showMessageDialog(this, "Captcha is required", "Error", JOptionPane.ERROR_MESSAGE);
             return true;

	     }
	    
	        return false;

	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) 
	{

		

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent ae) {
		int check = ae.getKeyCode();

		if (check == 10)
		{
			
	
			username = txt_username.getText();
			pwd = pwd_password.getPassword();
			captcha = txt_captcha.getText();
			
			password = String.valueOf(pwd);
			
			if(ae.getSource()==btn_exit)
			{
				
			
				System.exit(0);
				
				
			}
			
	       
			if(ae.getSource()==btn_Login) 
			{
	 
			   if( checkEmpty())
			   {
			   System.out.println("All fields are mandatory");
			   }

			 
			
			else
			
			{

				System.out.println("The username is " + username);
				System.out.println("The password is " + password);
				System.out.println("The captcha is " +captcha);
				System.out.println("The value is " + val);

				credentials();

			}
			}
		}


		}

	

	@Override
	public void keyReleased(KeyEvent e) {

	}
}