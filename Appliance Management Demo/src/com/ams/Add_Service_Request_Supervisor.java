package com.ams;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.dbconnection.DataBaseConnection;
//import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
//import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Toolkit;

public class Add_Service_Request_Supervisor extends JFrame implements ActionListener,KeyListener,WindowListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_requestid;
	private JTextField txt_customerid;
	private JTextField txt_appliance_model_no;
	private JTextField txt_company_name;
	private JTextField txt_total_amount;
	private JButton btn_submit,btn_exit;
	private JDateChooser date_out,date_in;
	private JComboBox<String> cmb_applianceid;
	
	private Connection  con;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Service_Request_Supervisor frame = new Add_Service_Request_Supervisor();
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
	public Add_Service_Request_Supervisor() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Add_Service_Request_Supervisor.class.getResource("/com/images/ML logo.png")));
		con=DataBaseConnection.connection();
		this.addWindowListener(this);
		setUndecorated(true);
		createGui();
		
		
	}
	
	
	public void createGui()
	{
		setTitle("Service Request");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 764, 747);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_requestid = new JLabel("Request ID");
		lbl_requestid.setForeground(new Color(0, 0, 128));
		lbl_requestid.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_requestid.setBounds(100, 138, 194, 32);
		contentPane.add(lbl_requestid);
		
		txt_requestid = new JTextField();
		txt_requestid.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_requestid.setOpaque(false);
		txt_requestid.setForeground(new Color(0, 0, 128));
		txt_requestid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_requestid.setBounds(355, 137, 250, 33);
		contentPane.add(txt_requestid);
		txt_requestid.setColumns(10);
		
		JLabel lbl_customerid = new JLabel("Customer ID");
		lbl_customerid.setForeground(new Color(0, 0, 128));
		lbl_customerid.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_customerid.setBounds(100, 204, 194, 26);
		contentPane.add(lbl_customerid);
		
		txt_customerid = new JTextField();
		txt_customerid.setOpaque(false);
		txt_customerid.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_customerid.setForeground(new Color(0, 0, 128));
		txt_customerid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_customerid.setBounds(355, 204, 250, 32);
		contentPane.add(txt_customerid);
		txt_customerid.setColumns(10);
		
		JLabel lbl_appliance_model_no = new JLabel("Appliance Model No");
		lbl_appliance_model_no.setForeground(new Color(0, 0, 128));
		lbl_appliance_model_no.setFont(new Font("Cambria Math", Font.BOLD, 23));
		lbl_appliance_model_no.setBounds(100, 263, 222, 32);
		contentPane.add(lbl_appliance_model_no);
		
		txt_appliance_model_no = new JTextField();
		txt_appliance_model_no.setOpaque(false);
		txt_appliance_model_no.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_appliance_model_no.setForeground(new Color(0, 0, 128));
		txt_appliance_model_no.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_appliance_model_no.setBounds(355, 260, 250, 32);
		contentPane.add(txt_appliance_model_no);
		txt_appliance_model_no.setColumns(10);
		
		JLabel lbl_company_name = new JLabel("Company Name");
		lbl_company_name.setForeground(new Color(0, 0, 128));
		lbl_company_name.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_company_name.setBounds(100, 313, 194, 32);
		contentPane.add(lbl_company_name);
		
		txt_company_name = new JTextField();
		txt_company_name.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_company_name.setOpaque(false);
		txt_company_name.setForeground(new Color(0, 0, 128));
		txt_company_name.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_company_name.setBounds(355, 312, 250, 33);
		contentPane.add(txt_company_name);
		txt_company_name.setColumns(10);
		
		JLabel lbl_applianceid = new JLabel("Appliance ID");
		lbl_applianceid.setForeground(new Color(0, 0, 128));
		lbl_applianceid.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_applianceid.setBounds(100, 372, 170, 32);
		contentPane.add(lbl_applianceid);
		
		cmb_applianceid = new JComboBox<String>();
		cmb_applianceid.setOpaque(false);
		cmb_applianceid.setForeground(new Color(0, 0, 128));
		cmb_applianceid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		cmb_applianceid.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Appliance ID"}));
		cmb_applianceid.setBounds(358, 370, 247, 34);
		populateCombo();
		contentPane.add(cmb_applianceid);
		
		JLabel lbl_indate = new JLabel("In Date");
		lbl_indate.setForeground(new Color(0, 0, 128));
		lbl_indate.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_indate.setBounds(100, 432, 170, 33);
		contentPane.add(lbl_indate);
		
		JLabel lbl_outdate = new JLabel("Out Date");
		lbl_outdate.setForeground(new Color(0, 0, 128));
		lbl_outdate.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_outdate.setBounds(100, 492, 151, 32);
		contentPane.add(lbl_outdate);
		
		date_out = new JDateChooser();
		date_out.setBounds(355, 491, 250, 33);
		date_out.setDateFormatString("dd-MM-yyyy");
		contentPane.add(date_out);
		
		date_in = new JDateChooser();
		date_in.setBounds(355, 432, 250, 34);
		date_in.setDateFormatString("dd-MM-yyyy");
		contentPane.add(date_in);
		
		JLabel lbl_total_amount = new JLabel("Total Amount");
		lbl_total_amount.setForeground(new Color(0, 0, 128));
		lbl_total_amount.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_total_amount.setBounds(100, 548, 170, 28);
		contentPane.add(lbl_total_amount);
		
		txt_total_amount = new JTextField();
        txt_total_amount.addKeyListener(this);
		txt_total_amount.setOpaque(false);
		txt_total_amount.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_total_amount.setForeground(new Color(0, 0, 128));
		txt_total_amount.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_total_amount.setBounds(355, 550, 250, 32);
		contentPane.add(txt_total_amount);
		txt_total_amount.setColumns(10);
		
		btn_submit = new JButton("Submit");
		btn_submit.setOpaque(false);
		btn_submit.setBackground(new Color(255, 215, 0));
		btn_submit.setForeground(new Color(0, 0, 128));
		btn_submit.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		btn_submit.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btn_submit.setBounds(213, 628, 134, 43);
		btn_submit.addActionListener(this);
		btn_submit.addKeyListener(this);
		contentPane.add(btn_submit);
		
		btn_exit = new JButton("Exit");
		btn_exit.setOpaque(false);
		btn_exit.setForeground(new Color(0, 0, 128));
		btn_exit.setBackground(new Color(255, 215, 0));
		btn_exit.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		btn_exit.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btn_exit.setBounds(418, 628, 134, 43);
		btn_exit.addActionListener(this);
		btn_exit.addKeyListener(this);
		contentPane.add(btn_exit);
		
		lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		lbl_border.setBounds(69, 102, 581, 595);
		contentPane.add(lbl_border);
		
		lblNewLabel_1 = new JLabel("Service Request");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 55));
		lblNewLabel_1.setBounds(159, 27, 446, 65);
		contentPane.add(lblNewLabel_1);
		
		lbl_mainborder = new JLabel("");
		lbl_mainborder.setBorder(new LineBorder(new Color(0, 0, 128), 3, true));
		lbl_mainborder.setIcon(new ImageIcon(Add_Service_Request_Supervisor.class.getResource("/com/images/Add_Supervisor.jpg")));
		lbl_mainborder.setBounds(0, 0, 761, 747);
		contentPane.add(lbl_mainborder);
		
		lbl_number_warning = new JLabel("");
		lbl_number_warning.setForeground(Color.RED);
		lbl_number_warning.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lbl_number_warning.setBounds(355, 592, 250, 19);
		contentPane.add(lbl_number_warning);
		
		
	}
	
	
	 String requestid,applianceid,company_name,appliance_model_no,customerid,total_amount;
	 Date in_date;
	Date out_date;
	private JLabel lbl_border;
	private JLabel lblNewLabel_1;
	private JLabel lbl_mainborder;
	private JLabel lbl_number_warning;
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		
		//String cmp =(String)cmb_applianceid.getSelectedItem();
		
		 if(ae.getSource()==btn_exit) 
		  { 
			 this.dispose();
		  
		  }
		 
		 if(ae.getSource()==btn_submit)
			{
			    fetchDetails();
			    if(!checkEmpty())
			    {
			    	
			    	if(in_date.before(out_date))
			    	{
			    		if(!checkRequestId())
			    		{
			    			if(checkCustomerId())
			    			{
			    				addDetails();
			    				
			    			}
			    			else
			    			{
			    				JOptionPane.showMessageDialog(this, "Create Customer record first", "Error", JOptionPane.ERROR_MESSAGE);
			    				txt_customerid.selectAll();
			    				txt_customerid.grabFocus();
			    			}
			    			
			    		}
			    		else
			    		{
			    			JOptionPane.showMessageDialog(this, "Request Id already exist", "Error", JOptionPane.ERROR_MESSAGE);
			    			txt_requestid.selectAll();
			    			txt_requestid.grabFocus();
			    		}
			    		
			    	}
			    	else
			    		JOptionPane.showMessageDialog(this, "Out Date is inappropriate", "Error",JOptionPane.ERROR_MESSAGE);
			    	
			    	
			    }
			 
			 
			}
		 
		
		
		
	}
	
	
	
	
	  public void populateCombo()
	  
	  {
		  int flag=0;
	 
	 try 
	  {
	  
	  String str_read = "select applianceid  from appliancedetails"; 
	  
	  ps =con.prepareStatement(str_read); 
	  rs = ps.executeQuery();
	  
	  while (rs.next()) 
	  { 
		  flag=1;
	      String id=rs.getString("applianceid");
	      cmb_applianceid.addItem(id); 
	  }
	  if(flag==0) 
	  {
	  JOptionPane.showMessageDialog(this, "No Appliance added");
	  }
	 
	} 
	  catch (SQLException se) 
	  { 
		  System.out.println(se); 
		  } 
	  finally 
	  {
	    if (ps != null) 
	    	try 
	    		{ 
	    			ps.close(); 
	    		} 
	    catch (SQLException e) 
	    		{ 
	    			e.printStackTrace(); 
	    		} 
	    if (rs != null)
	    	try 
	    { 
	    		rs.close(); 
	    } 
	    catch (SQLException e) 
	    { 
	    	e.printStackTrace(); 
	    }
	  
	  }
	  
	  }
	
	
	  public boolean checkRequestId()
	  {
		  String strcheck = "select requestid from servicerequest";
		  
		  try {
			ps = con.prepareStatement(strcheck);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				String Requestid = rs.getString("requestid");
				
			  if(requestid.equalsIgnoreCase(Requestid))
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
			  if(ps!= null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  if(rs!= null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			  
		  }  
		  return false;
		  
	  }
	  
	public void fetchDetails()
	{
		
		requestid = txt_requestid.getText();
		customerid = txt_customerid.getText();
		appliance_model_no = txt_appliance_model_no.getText();
		company_name = txt_company_name.getText();
		applianceid = (String)cmb_applianceid.getSelectedItem();		
		in_date = date_in.getDate();
		out_date = date_out.getDate();
		total_amount = txt_total_amount.getText();
		
	}
	
    public boolean	checkEmpty()
	{
    	
    	if(requestid.isEmpty())
    	{
		JOptionPane.showMessageDialog(this, "Request Id is required", "Error", JOptionPane.ERROR_MESSAGE);
		txt_requestid.grabFocus();
		return true;
    	}
    	
    	if(customerid.isEmpty())
    	{
		
		JOptionPane.showMessageDialog(this, "Customer Id is required", "Error", JOptionPane.ERROR_MESSAGE);
		txt_customerid.grabFocus();
		return true;
    	}
    	
    	if(appliance_model_no.isEmpty())
    	{
		
		JOptionPane.showMessageDialog(this, "Appliance Model No. is required", "Error", JOptionPane.ERROR_MESSAGE);
		txt_appliance_model_no.grabFocus();
		return true;
    	}
    	
    	if(company_name.isEmpty())
    	{
		
		JOptionPane.showMessageDialog(this, "Company Name is required", "Error", JOptionPane.ERROR_MESSAGE);
		txt_company_name.grabFocus();
		return true;
    	}
    	
    	if(applianceid.contentEquals("Select"))
    	{
		
		JOptionPane.showMessageDialog(this, "Select an Appliance ID first", "Error", JOptionPane.ERROR_MESSAGE);
		
		return true;
    	}
    	
    	if(in_date == null)
    	{
		
		JOptionPane.showMessageDialog(this, "In date is required", "Error", JOptionPane.ERROR_MESSAGE);
		return true;
    	}
    	
    	if(out_date == null)
    	{
		
		JOptionPane.showMessageDialog(this, "Out date is required", "Error", JOptionPane.ERROR_MESSAGE);
		return true;
    	}
    	
    	if(total_amount.isEmpty())
    	{
		
		JOptionPane.showMessageDialog(this, "Total Amount is required", "Error", JOptionPane.ERROR_MESSAGE);
		return true;
    	}
    	
    	return false;
		
	}
	
    
    public boolean checkCustomerId()
    {
  	  String strcheck = "select customerid from customerdetails";
  	  
  	  try {
  		ps = con.prepareStatement(strcheck);
  		
  		rs = ps.executeQuery();
  		
  		while(rs.next())
  		{
  			
  			String Customerid = rs.getString("customerid");
  			
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
  		  if(ps!= null)
  			try {
  				ps.close();
  			} catch (SQLException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  		  if(rs!= null)
  			try {
  				rs.close();
  			} catch (SQLException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			} 
  		  
  	  }  
  	  return false;
  	  
    }

	
	public void addDetails()
	{ 
		String strinsert = "insert into servicerequest values(?,?,?,?,?,?,?,?,?,?,?,?)";
	   
	   try 
	   {
		
		   ps = con.prepareStatement(strinsert);
		   ps.setString(1, requestid);
		   ps.setString(2, customerid);
		   ps.setString(3, appliance_model_no);
		   ps.setString(4, company_name);
		   ps.setString(5, applianceid);
		   java.sql.Date sql_in_date=new java.sql.Date(in_date.getTime());
		   ps.setDate(6, sql_in_date);
		   java.sql.Date sql_out_date=new java.sql.Date(out_date.getTime());
		   ps.setDate(7, sql_out_date);
		   ps.setString(8, total_amount);
		   ps.setString(9, "Taken");
		   ps.setString(10, "Not Assigned");
		   ps.setString(11, "Pending");
		   ps.setString(12, "Un Paid");

		   
		   
		   int status = ps.executeUpdate();
		   
		
		   if(status > 0)
		   {
			   JOptionPane.showMessageDialog(this, "Information Added Successfully", "Submitted", JOptionPane.INFORMATION_MESSAGE);
			   txt_requestid.setText("");
			   txt_customerid.setText("");
			   txt_appliance_model_no.setText("");
			   txt_company_name.setText("");
			   cmb_applianceid.setSelectedIndex(0);
			   date_in.setCalendar(null);
			   date_out.setCalendar(null);
			   txt_total_amount.setText("");
				
			   
			   
		   }
		   
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally
	 {
		 if(ps!= null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
		 
		  }
	  
	  
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
			    if(!checkEmpty())
			    {
			    	
			    	if(in_date.before(out_date))
			    	{
			    		if(!checkRequestId())
			    		{
			    			if(checkCustomerId())
			    			{
			    				addDetails();
			    				
			    			}
			    			else
			    			{
			    				JOptionPane.showMessageDialog(this, "Create Customer record first", "Error", JOptionPane.ERROR_MESSAGE);
			    				txt_customerid.selectAll();
			    				txt_customerid.grabFocus();
			    			}
			    			
			    		}
			    		else
			    		{
			    			JOptionPane.showMessageDialog(this, "Request Id already exist", "Error", JOptionPane.ERROR_MESSAGE);
			    			txt_requestid.selectAll();
			    			txt_requestid.grabFocus();
			    		}
			    		
			    	}
			    	else
			    		JOptionPane.showMessageDialog(this, "Out Date is inappropriate", "Error",JOptionPane.ERROR_MESSAGE);
			    	
			    	
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
		// TODO Auto-generated method stub
		
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