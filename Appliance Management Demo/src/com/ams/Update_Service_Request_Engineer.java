 package com.ams;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbconnection.DataBaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
//import javax.swing.ButtonModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Update_Service_Request_Engineer extends JFrame implements ActionListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_customerid;
	private JTextField txt_company_name;
	private JButton btn_submit,btn_exit;
	private JRadioButton rdbtn_pending,rdbtn_done;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	private Connection con;
	private PreparedStatement psread;
	private ResultSet rsread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Service_Request_Engineer frame = new Update_Service_Request_Engineer();
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
	public Update_Service_Request_Engineer() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Update_Service_Request_Engineer.class.getResource("/com/images/ML logo.png")));
		con = DataBaseConnection.connection();
		setUndecorated(true);
		createGui();
	}
	
	
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 690, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_requestid = new JLabel("Request ID");
		lbl_requestid.setForeground(Color.WHITE);
		lbl_requestid.setFont(new Font("Cambria Math", Font.BOLD, 27));
		lbl_requestid.setBounds(102, 127, 156, 38);
		contentPane.add(lbl_requestid);
		
		JLabel lbl_customerid = new JLabel("Customer ID");
		lbl_customerid.setForeground(Color.WHITE);
		lbl_customerid.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_customerid.setBounds(102, 203, 156, 38);
		contentPane.add(lbl_customerid);
		
		txt_customerid = new JTextField();
		txt_customerid.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_customerid.setOpaque(false);
		txt_customerid.setForeground(Color.WHITE);
		txt_customerid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_customerid.setEditable(false);
		txt_customerid.setBounds(324, 203, 231, 38);
		contentPane.add(txt_customerid);
		txt_customerid.setColumns(10);
		
		JLabel lbl_company_name = new JLabel("Company Name");
		lbl_company_name.setForeground(Color.WHITE);
		lbl_company_name.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_company_name.setBounds(102, 275, 182, 38);
		contentPane.add(lbl_company_name);
		
		txt_company_name = new JTextField();
		txt_company_name.setForeground(Color.WHITE);
		txt_company_name.setOpaque(false);
		txt_company_name.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_company_name.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_company_name.setEditable(false);
		txt_company_name.setBounds(324, 275, 231, 38);
		contentPane.add(txt_company_name);
		txt_company_name.setColumns(10);
		
		JLabel lbl_service_status = new JLabel("Service Status");
		lbl_service_status.setForeground(Color.WHITE);
		lbl_service_status.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_service_status.setBounds(102, 339, 182, 38);
		contentPane.add(lbl_service_status);
		
		rdbtn_pending = new JRadioButton("Pending");
		rdbtn_pending.setOpaque(false);
		rdbtn_pending.setForeground(Color.WHITE);
		buttonGroup.add(rdbtn_pending);
		rdbtn_pending.setFont(new Font("Cambria Math", Font.BOLD, 22));
		rdbtn_pending.setBounds(324, 339, 118, 36);
		contentPane.add(rdbtn_pending);
		
		rdbtn_done = new JRadioButton("Done");
		rdbtn_done.setOpaque(false);
		rdbtn_done.setForeground(Color.WHITE);
		buttonGroup.add(rdbtn_done);
		rdbtn_done.setFont(new Font("Cambria Math", Font.BOLD, 22));
		rdbtn_done.setBounds(475, 339, 80, 36);
		contentPane.add(rdbtn_done);
		
		btn_submit = new JButton("Submit");
		btn_submit.setOpaque(false);
		btn_submit.setForeground(Color.WHITE);
		btn_submit.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_submit.setBackground(Color.WHITE);
		btn_submit.setFont(new Font("Cambria Math", Font.BOLD, 28));
		btn_submit.setBounds(240, 416, 131, 38);
		btn_submit.addActionListener(this);
		btn_submit.addKeyListener(this);
		contentPane.add(btn_submit);
		
		btn_exit = new JButton("Exit");
		btn_exit.setForeground(Color.WHITE);
		btn_exit.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_exit.setBackground(Color.WHITE);
		btn_exit.setOpaque(false);
		btn_exit.setFont(new Font("Cambria Math", Font.BOLD, 28));
		btn_exit.setBounds(446, 416, 131, 35);
		btn_exit.addActionListener(this);
		btn_exit.addKeyListener(this);
		contentPane.add(btn_exit);
		
		cmb_requestid = new JComboBox<String>();
		cmb_requestid.setOpaque(false);
		cmb_requestid.setForeground(new Color(0, 0, 128));
		cmb_requestid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		cmb_requestid.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Request ID"}));
		cmb_requestid.setBounds(324, 127, 231, 38);
		populateCombo();
		cmb_requestid.addActionListener(this);
		contentPane.add(cmb_requestid);
		
		JLabel lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(Color.WHITE, 2, true));
		lbl_border.setBounds(81, 94, 529, 392);
		contentPane.add(lbl_border);
		
		lbl_heading = new JLabel("Update Service Request");
		lbl_heading.setForeground(Color.WHITE);
		lbl_heading.setFont(new Font("Cambria Math", Font.BOLD, 48));
		lbl_heading.setBounds(81, 10, 529, 74);
		contentPane.add(lbl_heading);
		
		lbl_mainborder = new JLabel("New label");
		lbl_mainborder.setBorder(new LineBorder(Color.WHITE, 3, true));
		lbl_mainborder.setIcon(new ImageIcon(Update_Service_Request_Engineer.class.getResource("/com/images/Update new.jpg")));
		lbl_mainborder.setBounds(0, 0, 690, 556);
		contentPane.add(lbl_mainborder);
		
		
	}
	
	String requestid,customerid,id,company_name,customer_id,service_status;
	
	private JComboBox<String> cmb_requestid;
	private JLabel lbl_heading;
	private JLabel lbl_mainborder;

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		
		fetchDetails();
		
		if(ae.getSource()==btn_exit)
		{
			this.dispose();
			
		}
		
	if(ae.getSource()==cmb_requestid)
	{
		String cmp = (String)cmb_requestid.getSelectedItem();
		if(cmp.contentEquals("Select"))
		{
			txt_company_name.setText("");
			txt_customerid.setText("");
			buttonGroup.clearSelection();
			
			
		}
		else
		{
			String rid = (String)cmb_requestid.getSelectedItem();
			searchDetails(rid);
			txt_company_name.setText(company_name);
			txt_customerid.setText(customer_id);
			if(service_status.contentEquals("Pending"))
			    rdbtn_pending.setSelected(true);
			else
				rdbtn_done.setSelected(true);
			
		}
		
		
		
	}
	
	if(ae.getSource()==btn_submit)
	{
		
		{
			
			String cid=(String)cmb_requestid.getSelectedItem();
			//String updated_customer_id   =txt_customerid.getText();
			//String updated_company_name   =txt_company_name.getText();
		
		         if(cid.equalsIgnoreCase("Select"))
		        	 JOptionPane.showMessageDialog(this, "Please Select any Request ID");
			
			
		        
					
					else
					{
						
					if(rdbtn_done.isSelected())
					{
						int status=	update_Service_Status(service_status);
						if(status>0)
						{
							String rid = (String)cmb_requestid.getSelectedItem();
							deleteDetails(rid);
							JOptionPane.showMessageDialog(this, "Service Status Updated", "Successful", JOptionPane.INFORMATION_MESSAGE);
							
							
							cmb_requestid.setSelectedIndex(0);
							txt_company_name.setText("");
							txt_customerid.setText("");
						
							
						}	
						
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Please select done to update", "Error", JOptionPane.ERROR_MESSAGE);
						
					}
						
			
		}
		
		
		
		
			
		}
		}
		    
			
			
		
		
		
		
		
		
		
	}
	
	
	
   public void fetchDetails()
   {
	   
	   requestid = (String)cmb_requestid.getSelectedItem();
	   customerid = txt_customerid.getText();
	   //id = Login.userid;
	   
   }

   
   public void searchDetails(String rid)
	{
	    	 
		  try 
		  {
			  
			  String str_read = "select * from servicerequest where requestid=?";
			  psread = con.prepareStatement(str_read);
			  psread.setString(1, rid);
			  rsread = psread.executeQuery();
			  
			  
			  if(rsread.next())
				{
					
					customer_id=rsread.getString("customerid");
					company_name=rsread.getString("companyname");
					service_status=rsread.getString("servicestatus");
					
							
				}
				
			 
			  
			 /*
				 * else if(flag == 0) {
				 * 
				 * if(customerid.isEmpty()) {
				 * JOptionPane.showMessageDialog(this,"Please enter a Customer ID", "Error",
				 * JOptionPane.ERROR_MESSAGE);
				 * 
				 * }
				 * 
				 * else { JOptionPane.showMessageDialog(this,"No such Customer Id. exist",
				 * "Error", JOptionPane.ERROR_MESSAGE); txt_customerid.grabFocus();
				 * txt_customerid.selectAll(); } }
				 */
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
   
   
   public void populateCombo()

	{
		int flag=0;
		try {
			
			String str_read = "select * from allotservice where engineerid=?";
			psread = con.prepareStatement(str_read);
			psread.setString(1, Login.userid);
			rsread = psread.executeQuery();

			while (rsread.next())		
			{
				flag=1;
			
				String id=rsread.getString("requestid");
			
				cmb_requestid.addItem(id);
			}
			if(flag==0)
			{
				JOptionPane.showMessageDialog(this, "No services pending");
				
				
			}
			
			
			

		} catch (SQLException se) {
			System.out.println(se);
		} finally {

			if (psread != null)
				try {
					psread.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (rsread != null)
				try {
					rsread.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

	}
	
   
   
   public int update_Service_Status(String status)
	
	{
		
		int updatestatus=0;
		try {
			
			String strupdate="update servicerequest set servicestatus=? where requestid=?";
			
			psread=con.prepareStatement(strupdate);
			//ButtonModel cmp =buttonGroup.getSelection();
			
			psread.setString(1, "Done");
			psread.setString(2, requestid);
			
		 updatestatus=psread.executeUpdate();	
			
		}
		catch(SQLException se)
		{
			
			se.printStackTrace();
		}
		finally {
			
			if(psread!=null)
				try {
					psread.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	return updatestatus;	
	}

   
   public void deleteDetails(String rid)
	{
		
       
		
		
			String str_delete="delete from allotservice where requestid=?";
			try {
				
				psread=con.prepareStatement(str_delete);
				psread.setString(1, rid);
				psread.executeUpdate();
				
				
			}
				
			
			catch(SQLException se)
			{
				
				se.printStackTrace();
			}
			
			finally
			{
				
				
				try {
					if(rsread!=null)
						rsread.close();
					if(psread!=null)
						psread.close();
					
				}
				
				catch(SQLException se)
				{
					
					System.out.println(se.getMessage());
				}
			
			
		}
			
			
		}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent ae) 
{
	fetchDetails();
	int check = ae.getKeyCode();
	if(check==10)
	{
	
	if(ae.getSource()==btn_exit)
	{
		this.dispose();
		
	}
	
if(ae.getSource()==cmb_requestid)
{
	String cmp = (String)cmb_requestid.getSelectedItem();
	if(cmp.contentEquals("Select"))
	{
		txt_company_name.setText("");
		txt_customerid.setText("");
		buttonGroup.clearSelection();
		
		
	}
	else
	{
		String rid = (String)cmb_requestid.getSelectedItem();
		searchDetails(rid);
		txt_company_name.setText(company_name);
		txt_customerid.setText(customer_id);
		if(service_status.contentEquals("Pending"))
		    rdbtn_pending.setSelected(true);
		else
			rdbtn_done.setSelected(true);
		
	}
	
	
	
}

if(ae.getSource()==btn_submit)
{
	
	{
		
		String cid=(String)cmb_requestid.getSelectedItem();
		//String updated_customer_id   =txt_customerid.getText();
		//String updated_company_name   =txt_company_name.getText();
	
	         if(cid.equalsIgnoreCase("Select"))
	        	 JOptionPane.showMessageDialog(this, "Please Select any Request ID");
		
		
	        
				
				else
				{
					
				if(rdbtn_done.isSelected())
				{
					int status=	update_Service_Status(service_status);
					if(status>0)
					{
						String rid = (String)cmb_requestid.getSelectedItem();
						deleteDetails(rid);
						JOptionPane.showMessageDialog(this, "Service Status Updated", "Successful", JOptionPane.INFORMATION_MESSAGE);
						
						
						cmb_requestid.setSelectedIndex(0);
						txt_company_name.setText("");
						txt_customerid.setText("");
					
						
					}	
					
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Please select done to update", "Error", JOptionPane.ERROR_MESSAGE);
					
				}
					
		
	}
	
	
	
	
		
	}
	}
	    
		
		
	}
	
	
	
	
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
	}