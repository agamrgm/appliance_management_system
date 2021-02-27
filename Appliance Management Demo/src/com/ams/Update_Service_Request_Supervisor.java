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
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Update_Service_Request_Supervisor extends JFrame implements ActionListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_customerid;
	private JTextField txt_company_name;
	private JButton btn_submit,btn_exit;
	private JRadioButton rdbtn_unpaid,rdbtn_paid;
	private JComboBox<String> cmb_requestid;
	private JRadioButton rdbtn_taken,rdbtn_delivered;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	
	
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
					Update_Service_Request_Supervisor frame = new Update_Service_Request_Supervisor();
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
	public Update_Service_Request_Supervisor() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Update_Service_Request_Supervisor.class.getResource("/com/images/ML logo.png")));
		con = DataBaseConnection.connection();
		setUndecorated(true);
		createGui();
	}
	
	
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 699, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_requestid = new JLabel("Request ID");
		lbl_requestid.setForeground(Color.WHITE);
		lbl_requestid.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_requestid.setBounds(78, 137, 147, 32);
		contentPane.add(lbl_requestid);
		
		JLabel lbl_customerid = new JLabel("Customer ID");
		lbl_customerid.setForeground(Color.WHITE);
		lbl_customerid.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_customerid.setBounds(78, 208, 159, 32);
		contentPane.add(lbl_customerid);
		
		txt_customerid = new JTextField();
		txt_customerid.setEditable(false);
		txt_customerid.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_customerid.setForeground(Color.WHITE);
		txt_customerid.setOpaque(false);
		txt_customerid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_customerid.setBounds(339, 208, 254, 38);
		contentPane.add(txt_customerid);
		txt_customerid.setColumns(10);
		
		JLabel lbl_company_name = new JLabel("Company Name");
		lbl_company_name.setForeground(Color.WHITE);
		lbl_company_name.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_company_name.setBounds(78, 280, 182, 38);
		contentPane.add(lbl_company_name);
		
		txt_company_name = new JTextField();
		txt_company_name.setOpaque(false);
		txt_company_name.setForeground(Color.WHITE);
		txt_company_name.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_company_name.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_company_name.setEditable(false);
		txt_company_name.setBounds(339, 280, 254, 38);
		contentPane.add(txt_company_name);
		txt_company_name.setColumns(10);
		
		JLabel lbl_amount_paid = new JLabel("Amount Paid");
		lbl_amount_paid.setForeground(Color.WHITE);
		lbl_amount_paid.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_amount_paid.setBounds(78, 353, 171, 32);
		contentPane.add(lbl_amount_paid);
		
		rdbtn_unpaid = new JRadioButton("UnPaid");
		rdbtn_unpaid.setForeground(Color.WHITE);
		rdbtn_unpaid.setOpaque(false);
		buttonGroup.add(rdbtn_unpaid);
		rdbtn_unpaid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		rdbtn_unpaid.setBounds(339, 353, 113, 32);
		contentPane.add(rdbtn_unpaid);
		
		rdbtn_paid = new JRadioButton("Paid");
		rdbtn_paid.setForeground(Color.WHITE);
		rdbtn_paid.setOpaque(false);
		buttonGroup.add(rdbtn_paid);
		rdbtn_paid.setFont(new Font("Cambria Math", Font.BOLD, 23));
		rdbtn_paid.setBounds(465, 357, 79, 27);
		contentPane.add(rdbtn_paid);
		
		btn_submit = new JButton("Submit");
		btn_submit.setOpaque(false);
		btn_submit.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_submit.setBackground(Color.GRAY);
		btn_submit.setForeground(Color.WHITE);
		btn_submit.setFont(new Font("Cambria Math", Font.BOLD, 28));
		btn_submit.setBounds(238, 474, 133, 45);
		btn_submit.addActionListener(this);
		btn_submit.addKeyListener(this);
		contentPane.add(btn_submit);
		
		btn_exit = new JButton("Exit");
		btn_exit.setForeground(Color.WHITE);
		btn_exit.setBackground(Color.GRAY);
		btn_exit.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_exit.setOpaque(false);
		btn_exit.setFont(new Font("Cambria Math", Font.BOLD, 28));
		btn_exit.setBounds(428, 474, 120, 45);
		btn_exit.addActionListener(this);
		btn_exit.addKeyListener(this);
		contentPane.add(btn_exit);
		
		cmb_requestid = new JComboBox<String>();
		cmb_requestid.setOpaque(false);
		cmb_requestid.setForeground(new Color(0, 0, 128));
		cmb_requestid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		cmb_requestid.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Request ID"}));
		cmb_requestid.setBounds(339, 137, 254, 38);
		populateCombo();
		cmb_requestid.addActionListener(this);
		contentPane.add(cmb_requestid);
		
		JLabel lblNewLabel = new JLabel("Delivery Status");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lblNewLabel.setBounds(78, 413, 182, 32);
		contentPane.add(lblNewLabel);
		
		rdbtn_taken = new JRadioButton("Taken");
		rdbtn_taken.setForeground(Color.WHITE);
		rdbtn_taken.setOpaque(false);
		buttonGroup_1.add(rdbtn_taken);
		rdbtn_taken.setFont(new Font("Cambria Math", Font.BOLD, 22));
		rdbtn_taken.setBounds(339, 413, 95, 32);
		contentPane.add(rdbtn_taken);
		
		rdbtn_delivered = new JRadioButton("Delivered");
		rdbtn_delivered.setForeground(Color.WHITE);
		rdbtn_delivered.setOpaque(false);
		buttonGroup_1.add(rdbtn_delivered);
		rdbtn_delivered.setFont(new Font("Cambria Math", Font.BOLD, 22));
		rdbtn_delivered.setBounds(465, 413, 128, 32);
		contentPane.add(rdbtn_delivered);
		
		lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(Color.WHITE, 2, true));
		lbl_border.setBounds(66, 102, 568, 451);
		contentPane.add(lbl_border);
		
		lblNewLabel_1 = new JLabel("Update Service Request");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 50));
		lblNewLabel_1.setBounds(60, 22, 547, 70);
		contentPane.add(lblNewLabel_1);
		
		lbl_mainborder = new JLabel("");
		lbl_mainborder.setBorder(new LineBorder(Color.WHITE, 3, true));
		lbl_mainborder.setIcon(new ImageIcon(Update_Service_Request_Supervisor.class.getResource("/com/images/Update new.jpg")));
		lbl_mainborder.setBounds(0, 0, 699, 629);
		contentPane.add(lbl_mainborder);
		
		
	}
	
	String requestid,customerid,id,company_name,customer_id,amount_paid_status,delivered_status;
	private JLabel lbl_border;
	private JLabel lblNewLabel_1;
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
			if(amount_paid_status.contentEquals("Un Paid")) 
			    rdbtn_unpaid.setSelected(true);
			else
				rdbtn_paid.setSelected(true);
			if(delivered_status.contentEquals("Taken"))
			    rdbtn_taken.setSelected(true);
			else
				rdbtn_delivered.setSelected(true);
			
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
						
					if(rdbtn_paid.isSelected())
					{
						if(rdbtn_delivered.isSelected())
						{
							String rid1=(String)cmb_requestid.getSelectedItem();
						int status=	update_Service_Status(rid1);
						if(status>0)
						{
							//String rid2 = (String)cmb_requestid.getSelectedItem();
							//deleteDetails(rid2);
							JOptionPane.showMessageDialog(this, "Delivery Status Updated", "Successful", JOptionPane.INFORMATION_MESSAGE);
							
							
							cmb_requestid.setSelectedIndex(0);
							txt_company_name.setText("");
							txt_customerid.setText("");
						
							
						}	
						}
						else
						{
							JOptionPane.showMessageDialog(this, "Please select Delivered to update", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Please select Paid to update", "Error", JOptionPane.ERROR_MESSAGE);
						
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
					amount_paid_status=rsread.getString("amountpaidstatus");
					delivered_status=rsread.getString("deliverystatus");
					
							
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
			
			String str_read = "select * from servicerequest where servicestatus=? and amountpaidstatus=?";
			psread = con.prepareStatement(str_read);
			
			psread.setString(1, "Done");
			psread.setString(2, "Un Paid");
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
	
   
   
   public int update_Service_Status(String rid)
	
	{
		
		int updatestatus=0;
		try {
			
			String strupdate="update servicerequest set amountpaidstatus=?,deliverystatus=? where requestid=?";
			
			psread=con.prepareStatement(strupdate);
			
			
			psread.setString(1,"Paid");
			psread.setString(2, "Delivered");
			psread.setString(3, rid);
			
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
	int check = ae.getKeyCode();
	if(check==10)
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
		if(amount_paid_status.contentEquals("Un Paid")) 
		    rdbtn_unpaid.setSelected(true);
		else
			rdbtn_paid.setSelected(true);
		if(delivered_status.contentEquals("Taken"))
		    rdbtn_taken.setSelected(true);
		else
			rdbtn_delivered.setSelected(true);
		
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
					
				if(rdbtn_paid.isSelected())
				{
					if(rdbtn_delivered.isSelected())
					{
						String rid1=(String)cmb_requestid.getSelectedItem();
					int status=	update_Service_Status(rid1);
					if(status>0)
					{
						//String rid2 = (String)cmb_requestid.getSelectedItem();
						//deleteDetails(rid2);
						JOptionPane.showMessageDialog(this, "Delivery Status Updated", "Successful", JOptionPane.INFORMATION_MESSAGE);
						
						
						cmb_requestid.setSelectedIndex(0);
						txt_company_name.setText("");
						txt_customerid.setText("");
					
						
					}	
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Please select Delivered to update", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Please select Paid to update", "Error", JOptionPane.ERROR_MESSAGE);
					
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