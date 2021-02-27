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
//import javax.swing.JRadioButton;
import javax.swing.JTextArea;
//import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

//import javax.swing.ButtonGroup;
//import javax.swing.ImageIcon;

public class Add_Customer extends JFrame implements ActionListener,WindowListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_customerid;
	private JTextField txt_emailid;
	private JTextField txt_phoneno;
	private JTextArea txtarea_address;
	private JButton btn_exit,btn_submit;
	
    private Connection con;
	private PreparedStatement pswrite,psread;
	private ResultSet rsread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Customer frame = new Add_Customer();
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
	public Add_Customer() 
	{
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Add_Customer.class.getResource("/com/images/ML logo.png")));
		con = DataBaseConnection.connection();
		this.addWindowListener(this);
		createGui();
		
	}

	
	public void createGui()
	{
		setBackground(Color.WHITE);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Customer Enrollment");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setBounds(100, 100, 764, 747);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new LineBorder(new Color(34, 139, 34), 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_customer_enrollment = new JLabel("Customer Enrollment");
		lbl_customer_enrollment.setForeground(new Color(0, 0, 128));
		lbl_customer_enrollment.setFont(new Font("Cambria Math", Font.BOLD, 52));
		lbl_customer_enrollment.setBounds(120, 10, 541, 84);
		contentPane.add(lbl_customer_enrollment);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setForeground(new Color(0, 0, 128));
		lbl_name.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_name.setBounds(120, 209, 116, 33);
		contentPane.add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setOpaque(false);
		txt_name.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_name.setForeground(new Color(0, 0, 128));
		txt_name.setBackground(new Color(255, 255, 255));
		txt_name.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_name.setBounds(352, 207, 300, 38);
		contentPane.add(txt_name);
		txt_name.setColumns(20);
		
		JLabel lbl_customerid = new JLabel("Customer ID");
		lbl_customerid.setForeground(new Color(0, 0, 128));
		lbl_customerid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		lbl_customerid.setBounds(120, 134, 152, 38);
		contentPane.add(lbl_customerid);
		
		txt_customerid = new JTextField();
		txt_customerid.setOpaque(false);
		txt_customerid.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_customerid.setForeground(new Color(0, 0, 128));
		txt_customerid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_customerid.setBounds(352, 134, 300, 38);
		contentPane.add(txt_customerid);
		txt_customerid.setColumns(10);
		
		JLabel lbl_email = new JLabel("Email ID");
		lbl_email.setBackground(new Color(240, 240, 240));
		lbl_email.setForeground(new Color(0, 0, 128));
		lbl_email.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_email.setBounds(120, 275, 116, 33);
		contentPane.add(lbl_email);
		
		txt_emailid = new JTextField();
		txt_emailid.setOpaque(false);
		txt_emailid.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_emailid.setForeground(new Color(0, 0, 128));
		txt_emailid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_emailid.setBounds(352, 273, 300, 38);
		contentPane.add(txt_emailid);
		txt_emailid.setColumns(20);
		
		JLabel lbl_phoneno = new JLabel("Phone No");
		lbl_phoneno.setForeground(new Color(0, 0, 128));
		lbl_phoneno.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_phoneno.setBounds(120, 344, 132, 33);
		contentPane.add(lbl_phoneno);
		
		txt_phoneno = new JTextField();
		txt_phoneno.setOpaque(false);
		txt_phoneno.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_phoneno.setForeground(new Color(0, 0, 128));
		txt_phoneno.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_phoneno.setBounds(352, 342, 300, 38);
		contentPane.add(txt_phoneno);
		txt_phoneno.setColumns(10);
		
		JLabel lbl_address = new JLabel("Address");
		lbl_address.setForeground(new Color(0, 0, 128));
		lbl_address.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_address.setBounds(120, 447, 107, 49);
		contentPane.add(lbl_address);
		
	    txtarea_address = new JTextArea();
	    txtarea_address.setOpaque(false);
		txtarea_address.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txtarea_address.setForeground(new Color(0, 0, 128));
		txtarea_address.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txtarea_address.setBounds(352, 419, 300, 87);
		contentPane.add(txtarea_address);
		
		btn_submit = new JButton("Submit");
		btn_submit.setOpaque(false);
		btn_submit.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		btn_submit.setForeground(new Color(0, 0, 128));
		btn_submit.setBackground(new Color(0, 255, 0));
		btn_submit.setFont(new Font("Cambria Math", Font.BOLD, 25));
		btn_submit.setBounds(241, 565, 143, 49);
		btn_submit.addActionListener(this);
		btn_submit.addKeyListener(this);
		contentPane.add(btn_submit);
		
		btn_exit = new JButton("Exit");
		btn_exit.setBackground(new Color(255, 192, 203));
		btn_exit.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		btn_exit.setForeground(new Color(0, 0, 128));
		btn_exit.setOpaque(false);
		btn_exit.setFont(new Font("Cambria Math", Font.BOLD, 26));
		btn_exit.setBounds(457, 565, 143, 49);
		btn_exit.addActionListener(this);
		btn_exit.addKeyListener(this);
		contentPane.add(btn_exit);
		
		lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		lbl_border.setBounds(77, 104, 623, 561);
		contentPane.add(lbl_border);
		
		lbl_mainborder = new JLabel("");
		lbl_mainborder.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		lbl_mainborder.setIcon(new ImageIcon(Add_Customer.class.getResource("/com/images/Add_Supervisor.jpg")));
		lbl_mainborder.setBounds(0, 0, 764, 747);
		contentPane.add(lbl_mainborder);
		
		
		
	}

       
  String name,customerid,email,phoneno,address,caption;
  private JLabel lbl_border;
  private JLabel lbl_mainborder;
  
 
  
  public boolean checkStaffId()
  {
	  String strcheck = "select customerid from customerdetails";
	  
	  try {
		psread = con.prepareStatement(strcheck);
		
		rsread = psread.executeQuery();
		
		while(rsread.next())
		{
			
			String Customerid = rsread.getString("customerid");
			
		  if(customerid.equalsIgnoreCase(Customerid))
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
	     customerid = txt_customerid.getText();
		 email = txt_emailid.getText();
		 phoneno = txt_phoneno.getText();
		 address = txtarea_address.getText();
	
	  }

	public void actionPerformed(ActionEvent ae) 
	{
		
		caption = ae.getActionCommand();
		
		if(caption.contentEquals("Exit"))
				{
			this.dispose();
			
				}
		
		
		if(caption.contentEquals("Submit"))
		{
		
		fetchDetails();	
		
		if(checkEmpty())
		{
		
			JOptionPane.showMessageDialog(this,"All fields are mandatory", "Error", JOptionPane.ERROR_MESSAGE);	
			
		}	
		
		else
		{
			System.out.println("The Name is :"+name);
			System.out.println("The username is :"+customerid);
			System.out.println("The Email Id is :"+email);
			System.out.println("The Phone No. is :"+phoneno);
			System.out.println("The Adddress is :"+address);

			
			if(checkStaffId())
			{
				JOptionPane.showMessageDialog(this, "Customer ID already exist", "Error", JOptionPane.ERROR_MESSAGE);
				txt_customerid.grabFocus();
				txt_customerid.selectAll();
				
				
			}
			else
				addDetails();
			
			
		}
		}
		
		
	}
	
	
	
	    public void addDetails() {
	   String strinsert = "insert into customerdetails values(?,?,?,?,?)";
	   try {
		
		   pswrite = con.prepareStatement(strinsert);
		   pswrite.setString(1, customerid);
		   pswrite.setString(2, name);
		   pswrite.setString(3, email);
		   pswrite.setString(4, phoneno);
		   pswrite.setString(5, address);
		   
		   
		   int status = pswrite.executeUpdate();
		
		   if(status > 0 )
		   {
			   JOptionPane.showMessageDialog(this, "Information Added Successfully", "Submitted", JOptionPane.INFORMATION_MESSAGE);
			   txt_customerid.setText("");
		
			    txt_name.setText("");
				txt_emailid.setText("");
				txt_phoneno.setText("");

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
  	  if(name.isEmpty() || customerid.isEmpty()|| phoneno.isEmpty() || address.isEmpty() )
  		  
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
			
			
			if(e.getSource()==btn_exit)
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
				System.out.println("The username is :"+customerid);
				System.out.println("The Email Id is :"+email);
				System.out.println("The Phone No. is :"+phoneno);
				System.out.println("The Adddress is :"+address);

				
				if(checkStaffId())
				{
					JOptionPane.showMessageDialog(this, "Customer ID already exist", "Error", JOptionPane.ERROR_MESSAGE);
					txt_customerid.grabFocus();
					txt_customerid.selectAll();
					
					
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