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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
//import javax.swing.ImageIcon;

public class Add_Engineer extends JFrame implements ActionListener,WindowListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_engineerid;
	private JTextField txt_emailid;
	private JTextField txt_phoneno;
	private JTextArea txtarea_address;
	private JRadioButton rd_btn_male,rd_btn_female;
	JCheckBox []language = new JCheckBox[3];
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox<String> cmb_applianceid;
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
					Add_Engineer frame = new Add_Engineer();
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
	public Add_Engineer() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Add_Engineer.class.getResource("/com/images/ML logo.png")));
		con = DataBaseConnection.connection();
		setUndecorated(true);
		this.addWindowListener(this);
		createGui();
		
	}

	
	public void createGui()
	{
		setBackground(Color.WHITE);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Engineer Enrollment");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setBounds(100, 100, 764, 747);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new LineBorder(new Color(34, 139, 34), 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_engineer_enrollment = new JLabel("Engineer Enrollment");
		lbl_engineer_enrollment.setForeground(new Color(0, 0, 128));
		lbl_engineer_enrollment.setFont(new Font("Cambria Math", Font.PLAIN, 54));
		lbl_engineer_enrollment.setBounds(145, 10, 527, 55);
		contentPane.add(lbl_engineer_enrollment);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setForeground(new Color(0, 0, 128));
		lbl_name.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_name.setBounds(122, 216, 141, 33);
		contentPane.add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setOpaque(false);
		txt_name.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_name.setForeground(new Color(0, 0, 128));
		txt_name.setBackground(new Color(255, 255, 255));
		txt_name.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_name.setBounds(321, 214, 300, 38);
		contentPane.add(txt_name);
		txt_name.setColumns(20);
		
		JLabel lbl_engineerid = new JLabel("Engineer ID");
		lbl_engineerid.setForeground(new Color(0, 0, 128));
		lbl_engineerid.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_engineerid.setBounds(122, 103, 141, 39);
		contentPane.add(lbl_engineerid);
		
		txt_engineerid = new JTextField();
		txt_engineerid.setOpaque(false);
		txt_engineerid.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_engineerid.setForeground(new Color(0, 0, 128));
		txt_engineerid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_engineerid.setBounds(321, 103, 300, 38);
		contentPane.add(txt_engineerid);
		txt_engineerid.setColumns(10);
		
		JLabel lbl_email = new JLabel("Email Id");
		lbl_email.setBackground(new Color(240, 240, 240));
		lbl_email.setForeground(new Color(0, 0, 128));
		lbl_email.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_email.setBounds(122, 279, 141, 33);
		contentPane.add(lbl_email);
		
		txt_emailid = new JTextField();
		txt_emailid.setOpaque(false);
		txt_emailid.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_emailid.setForeground(new Color(0, 0, 128));
		txt_emailid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_emailid.setBounds(321, 277, 300, 38);
		contentPane.add(txt_emailid);
		txt_emailid.setColumns(20);
		
		JLabel lbl_phoneno = new JLabel("Phone No");
		lbl_phoneno.setForeground(new Color(0, 0, 128));
		lbl_phoneno.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_phoneno.setBounds(122, 344, 141, 33);
		contentPane.add(lbl_phoneno);
		
		txt_phoneno = new JTextField();
		txt_phoneno.setOpaque(false);
		txt_phoneno.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_phoneno.setForeground(new Color(0, 0, 128));
		txt_phoneno.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_phoneno.setBounds(321, 342, 300, 38);
		contentPane.add(txt_phoneno);
		txt_phoneno.setColumns(10);
		
		JLabel lbl_gender = new JLabel("Gender");
		lbl_gender.setForeground(new Color(0, 0, 128));
		lbl_gender.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_gender.setBounds(122, 398, 116, 39);
		contentPane.add(lbl_gender);
		
		rd_btn_male = new JRadioButton("Male");
		rd_btn_male.setForeground(new Color(0, 0, 128));
		rd_btn_male.setOpaque(false);
		rd_btn_male.setBackground(new Color(0, 0, 128));
		buttonGroup.add(rd_btn_male);
		rd_btn_male.setFont(new Font("Cambria Math", Font.BOLD, 20));
		rd_btn_male.setBounds(321, 401, 103, 33);
		contentPane.add(rd_btn_male);
		
		rd_btn_female = new JRadioButton("Female");
		rd_btn_female.setForeground(new Color(0, 0, 128));
		rd_btn_female.setOpaque(false);
		rd_btn_female.setBackground(new Color(0, 0, 128));
		buttonGroup.add(rd_btn_female);
		rd_btn_female.setFont(new Font("Cambria Math", Font.BOLD, 20));
		rd_btn_female.setBounds(518, 401, 103, 33);
		contentPane.add(rd_btn_female);
		
		JLabel lbl_address = new JLabel("Address");
		lbl_address.setForeground(new Color(0, 0, 128));
		lbl_address.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_address.setBounds(122, 470, 116, 48);
		contentPane.add(lbl_address);
		
	    txtarea_address = new JTextArea();
	    txtarea_address.setOpaque(false);
		txtarea_address.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txtarea_address.setForeground(new Color(0, 0, 128));
		txtarea_address.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txtarea_address.setBounds(321, 455, 300, 76);
		contentPane.add(txtarea_address);
		
		btn_submit = new JButton("Submit");
		btn_submit.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		btn_submit.setOpaque(false);
		btn_submit.setForeground(new Color(0, 0, 128));
		btn_submit.setBackground(new Color(0, 255, 0));
		btn_submit.setFont(new Font("Cambria Math", Font.BOLD, 25));
		btn_submit.setBounds(283, 632, 141, 38);
		btn_submit.addActionListener(this);
		btn_submit.addKeyListener(this);
		contentPane.add(btn_submit);
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setForeground(new Color(0, 0, 128));
		lbl_password.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_password.setBounds(122, 163, 126, 33);
		contentPane.add(lbl_password);
		
		txt_password = new JTextField();
		txt_password.setOpaque(false);
		txt_password.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_password.setForeground(new Color(0, 0, 128));
		txt_password.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_password.setBounds(321, 161, 300, 38);
		contentPane.add(txt_password);
		txt_password.setColumns(20);
		
		cmb_applianceid = new JComboBox<String>();
		cmb_applianceid.setForeground(new Color(0, 0, 128));
		cmb_applianceid.setModel(new DefaultComboBoxModel<String>(new String[] {"Select"}));
		cmb_applianceid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		cmb_applianceid.setBounds(321, 560, 300, 33);
		populateCombo();
		contentPane.add(cmb_applianceid);
		
		JLabel lbl_applianceid = new JLabel("Appliance ID");
		lbl_applianceid.setForeground(new Color(0, 0, 128));
		lbl_applianceid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		lbl_applianceid.setBounds(122, 555, 141, 38);
		contentPane.add(lbl_applianceid);
		
		btnExit = new JButton("Exit");
		btnExit.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		btnExit.setForeground(new Color(0, 0, 128));
		btnExit.setOpaque(false);
		btnExit.setBackground(new Color(128, 0, 128));
		btnExit.addActionListener(this);
		btnExit.addKeyListener(this);
		btnExit.setFont(new Font("Cambria Math", Font.BOLD, 25));
		btnExit.setBounds(488, 632, 133, 38);
		contentPane.add(btnExit);
		
		JLabel lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(new Color(0, 0, 139), 2, true));
		lbl_border.setBounds(87, 75, 635, 625);
		contentPane.add(lbl_border);
		
		JLabel lbl_mainborder = new JLabel("");
		lbl_mainborder.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		lbl_mainborder.setIcon(new ImageIcon(Add_Engineer.class.getResource("/com/images/Add_Supervisor.jpg")));
		lbl_mainborder.setBounds(0, 0, 764, 742);
		contentPane.add(lbl_mainborder);
		
		
		
	}

       
  String name,engineerid,password,email,phoneno,address,gender="",applianceid;
  private JTextField txt_password;
  private JButton btnExit,btn_submit;
  
 
  
  public void populateCombo()
  {
	  
	  try 
	  {
		  
		  String str_read = "select applianceid from appliancedetails";
		  psread = con.prepareStatement(str_read);
		  rsread = psread.executeQuery();
		  
		 while(rsread.next())
		  {
			  
			  String applianceid =rsread.getString("applianceid");
			  cmb_applianceid.addItem(applianceid);
			  
		}
	
	  
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
	  
  }
  
  
  
  
  
  
  
  
  public boolean checkStaffId()
  {
	  String strcheck = "select engineerid from engineerdetails";
	  
	  try {
		psread = con.prepareStatement(strcheck);
		
		rsread = psread.executeQuery();
		
		while(rsread.next())
		{
			
			String Engineerid = rsread.getString("engineerid");
			
		  if(engineerid.equalsIgnoreCase(Engineerid))
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
		 engineerid = txt_engineerid.getText();
		 email = txt_emailid.getText();
		 phoneno = txt_phoneno.getText();
		 address = txtarea_address.getText();
		
		 if(rd_btn_male.isSelected())
		    gender = "Male";
		
		if(rd_btn_female.isSelected())
			gender = "Female";
		
		applianceid = (String)cmb_applianceid.getSelectedItem();
		
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
			System.out.println("The username is :"+engineerid);
			System.out.println("The password is :"+password);
			System.out.println("The Email Id is :"+email);
			System.out.println("The Phone No. is :"+phoneno);
			System.out.println("The Adddress is :"+address);
			System.out.println("The Gender is :"+gender);
			System.out.println("The appliance id is: "+applianceid);
			
			if(checkStaffId())
			{
				JOptionPane.showMessageDialog(this, "Engineer Id already exist", "Error", JOptionPane.ERROR_MESSAGE);
				txt_engineerid.grabFocus();
				txt_engineerid.selectAll();
				
				
			}
			else
				addDetails();
			
			
		}
		
		
	}
	}
	
	
	
	    public void addDetails() {
	   String strinsert = "insert into engineerdetails values(?,?,?,?,?,?,?)";
	   String strinsert1 = "insert into login values(?,?,?)";
	   try {
		
		   pswrite = con.prepareStatement(strinsert);
		   pswrite1 = con.prepareStatement(strinsert1);
		   pswrite.setString(1, engineerid);
		   pswrite.setString(2, name);
		   pswrite.setString(3, email);
		   pswrite.setString(4, phoneno);
		   pswrite.setString(5, gender);
		   pswrite.setString(6, address);
		   pswrite.setString(7, applianceid);
		   pswrite1.setString(1,engineerid);
		   pswrite1.setString(2,password);
		   pswrite1.setString(3, "engineer");
		   
		   
		   int status = pswrite.executeUpdate();
		   int status1 = pswrite1.executeUpdate();
		
		   if(status > 0 && status1 > 0)
		   {
			   JOptionPane.showMessageDialog(this, "Information Added Successfully", "Submitted", JOptionPane.INFORMATION_MESSAGE);
			   txt_engineerid.setText("");
			   txt_password.setText("");
			    txt_name.setText("");
				txt_emailid.setText("");
				txt_phoneno.setText("");
				buttonGroup.clearSelection();
				txtarea_address.setText("");
				cmb_applianceid.setSelectedIndex(0);
				
			   
			   
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
  	  if(name.isEmpty() || password.isEmpty() || engineerid.isEmpty() || phoneno.isEmpty() || address.isEmpty() || gender.isEmpty())
  		  
  		  return true;
  	  
  	  return false;
  	   
  	 }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int check = e.getKeyCode();
		if(check==10)
		{
			if(e.getSource()==btnExit)
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
				System.out.println("The username is :"+engineerid);
				System.out.println("The password is :"+password);
				System.out.println("The Email Id is :"+email);
				System.out.println("The Phone No. is :"+phoneno);
				System.out.println("The Adddress is :"+address);
				System.out.println("The Gender is :"+gender);
				System.out.println("The appliance id is: "+applianceid);
				
				if(checkStaffId())
				{
					JOptionPane.showMessageDialog(this, "Engineer Id already exist", "Error", JOptionPane.ERROR_MESSAGE);
					txt_engineerid.grabFocus();
					txt_engineerid.selectAll();
					
					
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