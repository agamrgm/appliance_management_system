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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
//import javax.swing.ImageIcon;

public class Add_Supervisor extends JFrame implements ActionListener,WindowListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_supervisorid;
	private JTextField txt_emailid;
	private JTextField txt_phoneno;
	private JTextArea txtarea_address;
	private JRadioButton rd_btn_male,rd_btn_female;
	JCheckBox []language = new JCheckBox[3];
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Connection con;
	private PreparedStatement pswrite,pswrite1,psread;
	private ResultSet rsread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Supervisor frame = new Add_Supervisor();
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
	public Add_Supervisor() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Add_Supervisor.class.getResource("/com/images/ML logo.png")));
		setUndecorated(true);
		con = DataBaseConnection.connection();
		this.addWindowListener(this);
		createGui();
		
	}

	
	public void createGui()
	{
		setBackground(Color.WHITE);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Staff Enrollment");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setBounds(100, 100, 764, 747);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new LineBorder(new Color(34, 139, 34), 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_supervisor_enrollment = new JLabel("Supervisor Enrollment");
		lbl_supervisor_enrollment.setForeground(new Color(0, 0, 128));
		lbl_supervisor_enrollment.setFont(new Font("Garamond", Font.BOLD, 40));
		lbl_supervisor_enrollment.setBounds(163, 10, 418, 55);
		contentPane.add(lbl_supervisor_enrollment);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setForeground(new Color(0, 0, 128));
		lbl_name.setFont(new Font("Cambria Math", Font.BOLD, 27));
		lbl_name.setBounds(77, 216, 143, 33);
		contentPane.add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setOpaque(false);
		txt_name.setBorder(new LineBorder(new Color(70, 130, 180), 1, true));
		txt_name.setForeground(new Color(0, 0, 128));
		txt_name.setBackground(new Color(255, 255, 255));
		txt_name.setFont(new Font("Cambria Math", Font.BOLD, 20));
		txt_name.setBounds(291, 214, 319, 38);
		contentPane.add(txt_name);
		txt_name.setColumns(20);
		
		JLabel lbl_supervisorid = new JLabel("Supervisor ID");
		lbl_supervisorid.setForeground(new Color(0, 0, 128));
		lbl_supervisorid.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_supervisorid.setBounds(77, 103, 163, 38);
		contentPane.add(lbl_supervisorid);
		
		txt_supervisorid = new JTextField();
		txt_supervisorid.setOpaque(false);
		txt_supervisorid.setBorder(new LineBorder(new Color(70, 130, 180), 1, true));
		txt_supervisorid.setForeground(new Color(0, 0, 128));
		txt_supervisorid.setFont(new Font("Cambria Math", Font.BOLD, 20));
		txt_supervisorid.setBounds(291, 101, 319, 38);
		contentPane.add(txt_supervisorid);
		txt_supervisorid.setColumns(10);
		
		JLabel lbl_email = new JLabel("Email Id");
		lbl_email.setBackground(new Color(240, 240, 240));
		lbl_email.setForeground(new Color(0, 0, 128));
		lbl_email.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_email.setBounds(77, 281, 116, 33);
		contentPane.add(lbl_email);
		
		txt_emailid = new JTextField();
		txt_emailid.setOpaque(false);
		txt_emailid.setBorder(new LineBorder(new Color(70, 130, 180), 1, true));
		txt_emailid.setForeground(new Color(0, 0, 128));
		txt_emailid.setFont(new Font("Cambria Math", Font.BOLD, 20));
		txt_emailid.setBounds(291, 279, 319, 38);
		contentPane.add(txt_emailid);
		txt_emailid.setColumns(20);
		
		JLabel lbl_phoneno = new JLabel("Phone No");
		lbl_phoneno.setForeground(new Color(0, 0, 128));
		lbl_phoneno.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_phoneno.setBounds(77, 354, 128, 33);
		contentPane.add(lbl_phoneno);
		
		txt_phoneno = new JTextField();
		txt_phoneno.setOpaque(false);
		txt_phoneno.setBorder(new LineBorder(new Color(70, 130, 180), 1, true));
		txt_phoneno.setForeground(new Color(0, 0, 128));
		txt_phoneno.setFont(new Font("Cambria Math", Font.BOLD, 20));
		txt_phoneno.setBounds(291, 349, 319, 38);
		contentPane.add(txt_phoneno);
		txt_phoneno.setColumns(10);
		
		JLabel lbl_gender = new JLabel("Gender");
		lbl_gender.setForeground(new Color(0, 0, 128));
		lbl_gender.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_gender.setBounds(77, 533, 107, 39);
		contentPane.add(lbl_gender);
		
		rd_btn_male = new JRadioButton("Male");
		rd_btn_male.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		rd_btn_male.setOpaque(false);
		rd_btn_male.setForeground(new Color(0, 0, 128));
		buttonGroup.add(rd_btn_male);
		rd_btn_male.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		rd_btn_male.setBounds(291, 536, 103, 36);
		contentPane.add(rd_btn_male);
		
		rd_btn_female = new JRadioButton("Female");
		rd_btn_female.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		rd_btn_female.setForeground(new Color(0, 0, 128));
		rd_btn_female.setOpaque(false);
		buttonGroup.add(rd_btn_female);
		rd_btn_female.setFont(new Font("Segoe UI Semibold", Font.BOLD, 19));
		rd_btn_female.setBounds(488, 539, 103, 33);
		contentPane.add(rd_btn_female);
		
		JLabel lbl_address = new JLabel("Address");
		lbl_address.setForeground(new Color(0, 0, 128));
		lbl_address.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_address.setBounds(77, 439, 128, 38);
		contentPane.add(lbl_address);
		
	    txtarea_address = new JTextArea();
	    txtarea_address.setOpaque(false);
		txtarea_address.setBorder(new LineBorder(new Color(70, 130, 180), 1, true));
		txtarea_address.setForeground(new Color(0, 0, 128));
		txtarea_address.setFont(new Font("Cambria Math", Font.BOLD, 20));
		txtarea_address.setBounds(291, 418, 319, 93);
		contentPane.add(txtarea_address);
		
		btn_submit = new JButton("Submit");
		btn_submit.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		btn_submit.setOpaque(false);
		btn_submit.setForeground(new Color(0, 0, 128));
		btn_submit.setBackground(new Color(0, 255, 0));
		btn_submit.setFont(new Font("Cambria Math", Font.BOLD, 28));
		btn_submit.setBounds(260, 628, 134, 48);
		btn_submit.addActionListener(this);
		btn_submit.addKeyListener(this);
		contentPane.add(btn_submit);
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setForeground(new Color(0, 0, 128));
		lbl_password.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_password.setBounds(77, 163, 143, 38);
		contentPane.add(lbl_password);
		
		txt_password = new JTextField();
		txt_password.setOpaque(false);
		txt_password.setBorder(new LineBorder(new Color(70, 130, 180), 1, true));
		txt_password.setForeground(new Color(0, 0, 128));
		txt_password.setFont(new Font("Cambria Math", Font.BOLD, 20));
		txt_password.setBounds(291, 161, 319, 38);
		contentPane.add(txt_password);
		txt_password.setColumns(20);
		
		btn_Exit = new JButton("Exit");
		btn_Exit.setBackground(new Color(205, 133, 63));
		btn_Exit.addActionListener(this);
		btn_Exit.addKeyListener(this);
		btn_Exit.setOpaque(false);
		btn_Exit.setForeground(new Color(0, 0, 128));
		btn_Exit.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		btn_Exit.setFont(new Font("Cambria Math", Font.BOLD, 29));
		btn_Exit.setBounds(476, 628, 134, 48);
		contentPane.add(btn_Exit);
		
		JLabel lbl_Border = new JLabel("");
		lbl_Border.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		lbl_Border.setBounds(46, 69, 629, 646);
		contentPane.add(lbl_Border);
		
		JLabel lbl_MainBorder = new JLabel("");
		lbl_MainBorder.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		lbl_MainBorder.setIcon(new ImageIcon(Add_Supervisor.class.getResource("/com/images/Add_Supervisor.jpg")));
		lbl_MainBorder.setBounds(0, 0, 764, 747);
		contentPane.add(lbl_MainBorder);
		
		
		
	}

       
  String name,supervisorid,password,email,phoneno,address,gender="";
  private JTextField txt_password;
  private JButton btn_Exit;
  private JButton btn_submit;
  
 
  
  public boolean checkStaffId()
  {
	  String strcheck = "select supervisorid from supervisordetails";
	  
	  try {
		psread = con.prepareStatement(strcheck);
		
		rsread = psread.executeQuery();
		
		while(rsread.next())
		{
			
			String Supervisorid = rsread.getString("supervisorid");
			
		  if(supervisorid.equalsIgnoreCase(Supervisorid))
		  {
			  return true;
			  
		 }
		  
		  
		}
	   return false;
		
		} 
	  
	  catch (SQLException e)
	  
	  {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 
	 finally
	  {
		  if(psread!= null)
			try {
				psread.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  if(rsread!= null)
			try {
				rsread.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  
	  }  
	  return false;
	  
  }
  
  
  
  
 
  
  public void fetchDetails()
  {
	  
	     name = txt_name.getText();
	     password=txt_password.getText();
		 supervisorid = txt_supervisorid.getText();
		 email = txt_emailid.getText();
		 phoneno = txt_phoneno.getText();
		 address = txtarea_address.getText();
		
		 if(rd_btn_male.isSelected())
		    gender = "Male";
		
		if(rd_btn_female.isSelected())
			gender = "Female";
		
		
	  }

	public void actionPerformed(ActionEvent ae) 
	{
		String caption = ae.getActionCommand();  
		
		if(caption=="Exit")
		{
			this.dispose();
		}
		
		if(caption=="Submit")
		{
		
		fetchDetails();	
		
		if(checkEmpty())
		{
		
			JOptionPane.showMessageDialog(this,"All fields are mandatory", "Error", JOptionPane.ERROR_MESSAGE);	
			
		}	
		
		else
		{
			System.out.println("The Name is :"+name);
			System.out.println("The username is :"+supervisorid);
			System.out.println("The password is :"+password);
			System.out.println("The Email Id is :"+email);
			System.out.println("The Phone No. is :"+phoneno);
			System.out.println("The Adddress is :"+address);
			System.out.println("The Gender is :"+gender);
			
			if(checkStaffId())
			{
				JOptionPane.showMessageDialog(this, "Supervisor Id already exist", "Error", JOptionPane.ERROR_MESSAGE);
				txt_supervisorid.grabFocus();
				txt_supervisorid.selectAll();
				
				
			}
			else
				addDetails();
			
			
		}
		
		
	}
	}
	
	
	    public void addDetails() {
	   String strinsert = "insert into supervisordetails values(?,?,?,?,?,?)";
	   String strinsert1 = "insert into login values(?,?,?)";
	   try {
		
		   pswrite = con.prepareStatement(strinsert);
		   pswrite1 = con.prepareStatement(strinsert1);
		   pswrite.setString(1, supervisorid);
		   pswrite.setString(2, name);
		   pswrite.setString(3, email);
		   pswrite.setString(4, phoneno);
		   pswrite.setString(5, gender);
		   pswrite.setString(6, address);
		   pswrite1.setString(1,supervisorid);
		   pswrite1.setString(2,password);
		   pswrite1.setString(3, "supervisor");
		   
		   
		   int status = pswrite.executeUpdate();
		   int status1 = pswrite1.executeUpdate();
		
		   if(status > 0 && status1 > 0)
		   {
			   JOptionPane.showMessageDialog(this, "Information Added Successfully", "Submitted", JOptionPane.INFORMATION_MESSAGE);
			   txt_supervisorid.setText("");
			   txt_password.setText("");
			    txt_name.setText("");
				txt_emailid.setText("");
				txt_phoneno.setText("");
				buttonGroup.clearSelection();
				txtarea_address.setText("");
				
			   
			   
		   }
		   
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally
	 {
		 if(pswrite!= null)
				try {
					pswrite.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
		 
		  }
	  
	  
	  }
	 
	
		
	
	 public boolean checkEmpty()
     {
  	  if(name.isEmpty()|| password.isEmpty() || supervisorid.isEmpty()||phoneno.isEmpty()||address.isEmpty()||gender.isEmpty())
  		  
  		  return true;
  	  
  	  return false;
  	   
  	 }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
		int check = e.getKeyCode();
		if(check==10)
		{
			if(e.getSource()==btn_Exit)
			{
				this.dispose();
			}
			
			if(e.getSource()==btn_submit)
			{
			
			fetchDetails();	
			
			if(checkEmpty())
			{
			
				JOptionPane.showMessageDialog(this,"All fields are mandatory", "Error", JOptionPane.ERROR_MESSAGE);	
				
			}	
			
			else
			{
				System.out.println("The Name is :"+name);
				System.out.println("The username is :"+supervisorid);
				System.out.println("The password is :"+password);
				System.out.println("The Email Id is :"+email);
				System.out.println("The Phone No. is :"+phoneno);
				System.out.println("The Adddress is :"+address);
				System.out.println("The Gender is :"+gender);
				
				if(checkStaffId())
				{
					JOptionPane.showMessageDialog(this, "Supervisor Id already exist", "Error", JOptionPane.ERROR_MESSAGE);
					txt_supervisorid.grabFocus();
					txt_supervisorid.selectAll();
					
					
				}
				else
					addDetails();
				
				
			}
			
			
		}
		}
		}
		
		
		   
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		Listener.windowClosing(con);
		
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
}