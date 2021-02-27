package com.ams;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import java.awt.Color;
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
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import com.dbconnection.DataBaseConnection;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Delete_Customer extends JFrame implements ActionListener,WindowListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_customerid;
	private JTextField txt_name;
	private JTextField txt_phoneno;
	private JTextField txt_email;
	private JTextArea txt_area_address;
	private JButton btn_exit,btn_delete,btn_search;
	
	
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
					Delete_Customer frame = new Delete_Customer();
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
	public Delete_Customer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Delete_Customer.class.getResource("/com/images/ML logo.png")));
		
		con = DataBaseConnection.connection();
		setUndecorated(true);
		this.addWindowListener(this);
		createGui();

	}
	
	
	public void createGui()
	{
		
		setTitle("Delete Customer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 798, 727);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_deletecustomer = new JLabel("Delete Customer");
		lbl_deletecustomer.setForeground(Color.WHITE);
		lbl_deletecustomer.setFont(new Font("Cambria Math", Font.BOLD, 55));
		lbl_deletecustomer.setBounds(166, 23, 486, 73);
		contentPane.add(lbl_deletecustomer);
		
		JLabel lbl_customer = new JLabel("Customer ID");
		lbl_customer.setForeground(Color.WHITE);
		lbl_customer.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_customer.setBounds(73, 149, 173, 47);
		contentPane.add(lbl_customer);
		
		txt_customerid = new JTextField();
		txt_customerid.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_customerid.setOpaque(false);
		txt_customerid.setForeground(Color.WHITE);
		txt_customerid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_customerid.setBounds(256, 155, 278, 36);
		contentPane.add(txt_customerid);
		txt_customerid.setColumns(10);
		
		btn_search = new JButton("Search");
		btn_search.setOpaque(false);
		btn_search.setForeground(Color.WHITE);
		btn_search.setBackground(Color.PINK);
		btn_search.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_search.setFont(new Font("Cambria Math", Font.BOLD, 34));
		btn_search.setBounds(571, 149, 133, 42);
		btn_search.addActionListener(this);
		btn_search.addKeyListener(this);
		contentPane.add(btn_search);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setForeground(Color.WHITE);
		lbl_name.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_name.setBounds(73, 233, 147, 33);
		contentPane.add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_name.setOpaque(false);
		txt_name.setForeground(Color.WHITE);
		txt_name.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_name.setEditable(false);
		txt_name.setBounds(256, 233, 285, 33);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		JLabel lbl_phoneo = new JLabel("Phone No");
		lbl_phoneo.setForeground(Color.WHITE);
		lbl_phoneo.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_phoneo.setBounds(73, 303, 147, 33);
		contentPane.add(lbl_phoneo);
		
		txt_phoneno = new JTextField();
		txt_phoneno.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_phoneno.setOpaque(false);
		txt_phoneno.setForeground(Color.WHITE);
		txt_phoneno.setEditable(false);
		txt_phoneno.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_phoneno.setBounds(256, 303, 285, 33);
		contentPane.add(txt_phoneno);
		txt_phoneno.setColumns(10);
		
		JLabel lbl_email = new JLabel("Email ID");
		lbl_email.setForeground(Color.WHITE);
		lbl_email.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_email.setBounds(73, 370, 147, 36);
		contentPane.add(lbl_email);
		
		txt_email = new JTextField();
		txt_email.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_email.setOpaque(false);
		txt_email.setForeground(Color.WHITE);
		txt_email.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_email.setEditable(false);
		txt_email.setBounds(256, 372, 285, 33);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		
		JLabel lbl_address = new JLabel("Address");
		lbl_address.setForeground(Color.WHITE);
		lbl_address.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_address.setBounds(73, 461, 105, 50);
		contentPane.add(lbl_address);
		
		txt_area_address = new JTextArea();
		txt_area_address.setOpaque(false);
		txt_area_address.setForeground(Color.WHITE);
		txt_area_address.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_area_address.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_area_address.setEditable(false);
		txt_area_address.setBounds(256, 446, 285, 73);
		contentPane.add(txt_area_address);
		
		btn_delete = new JButton("Delete");
		btn_delete.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_delete.setBackground(Color.PINK);
		btn_delete.setForeground(Color.WHITE);
		btn_delete.setOpaque(false);
		btn_delete.setFont(new Font("Cambria Math", Font.BOLD, 34));
		btn_delete.setBounds(241, 561, 160, 47);
		btn_delete.addActionListener(this);
		btn_delete.addKeyListener(this);
		contentPane.add(btn_delete);
		
		btn_exit = new JButton("Exit");
		btn_exit.setBackground(Color.PINK);
		btn_exit.setForeground(Color.WHITE);
		btn_exit.setOpaque(false);
		btn_exit.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btn_exit.setFont(new Font("Cambria Math", Font.BOLD, 34));
		btn_exit.setBounds(460, 561, 160, 47);
		btn_exit.addActionListener(this);
		btn_exit.addKeyListener(this);
		contentPane.add(btn_exit);
		
		lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(Color.WHITE, 2, true));
		lbl_border.setBounds(40, 99, 699, 578);
		contentPane.add(lbl_border);
		
		lbl_mainborder = new JLabel("New label");
		lbl_mainborder.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		lbl_mainborder.setIcon(new ImageIcon(Delete_Customer.class.getResource("/com/images/Delete.jpg")));
		lbl_mainborder.setBounds(0, 0, 796, 727);
		contentPane.add(lbl_mainborder);
		
		
	}

	String customerid,name;
	String caption;
	private JLabel lbl_border;
	private JLabel lbl_mainborder;
	
   public void fetchDetails()
   {
	   
	   customerid = txt_customerid.getText();
	   name = txt_name.getText();
	   
   }

	public void actionPerformed(ActionEvent ae) 
	{
		caption = ae.getActionCommand();
		fetchDetails();
		
		if(caption.contentEquals("Exit"))
		{
			this.dispose();
			
		}
		
		if(caption.equals("Search"))
		{
		     searchDetails();
			
			
		}
		if(caption.equals("Delete"))
		{

			if(customerid.isEmpty() )
			{
				JOptionPane.showMessageDialog(this, "Enter the Supervisor ID first","Error", JOptionPane.ERROR_MESSAGE);
				txt_customerid.grabFocus();
				txt_customerid.selectAll();
			}
			
			
			
			else if(name.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Search the Supervisor ID first","Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
		   
			else
				
			deleteDetails();
			
			
		}
		
		
		
		
		
		
	}
	
	public void searchDetails()
	{
	    	 
		  try 
		  {
			  
			  String str_read = "select * from customerdetails where customerid=?";
			  psread = con.prepareStatement(str_read);
			  psread.setString(1, customerid);
			  rsread = psread.executeQuery();
			  int flag = 0;
			 while(rsread.next())
			  {
				  
				  String Customerid =rsread.getString("customerid");
				  if(Customerid.equals(customerid))
				  {
					flag = 1; 
					break;
				  }
				  
			}
			 
			 if(flag == 1)
			 {
			  txt_name.setText(rsread.getString("name"));
			  txt_email.setText(rsread.getString("email"));
			  txt_phoneno.setText(rsread.getString("phone"));
			  txt_area_address.setText(rsread.getString("address"));
		
			  }
			 else if(flag == 0)
			 {
				 
				 if(customerid.isEmpty())
				 {
					 JOptionPane.showMessageDialog(this,"Please enter a Customer ID", "Error", JOptionPane.ERROR_MESSAGE);
					 
				 }
				 
				 else
				 {
				JOptionPane.showMessageDialog(this,"No such Customer ID exist", "Error", JOptionPane.ERROR_MESSAGE);
			    txt_customerid.grabFocus();
				txt_customerid.selectAll();
			 }
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
	
	public void deleteDetails()
	{
		
        
		
		int selection =	JOptionPane.showConfirmDialog(this, "It will delete customer's record permanently" , "Confirmation",JOptionPane.WARNING_MESSAGE);
		
		if(selection  == 0)
		{
			String str_delete="delete from customerdetails where customerid=?";
			try {
				
				psread=con.prepareStatement(str_delete);
				psread.setString(1, customerid);
				int status=	psread.executeUpdate();
				
				if(status > 0)
				{
				   JOptionPane.showMessageDialog(this, "Customer Record Deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
				    txt_customerid.setText("");
				    txt_name.setText("");
					txt_email.setText("");
					txt_phoneno.setText("");
					txt_area_address.setText("");
					
					
				}
				
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
			
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent ae) 
	{
		
			
		int check = ae.getKeyCode();
			if(check == 10)
			{	
				
				fetchDetails();
				
				if(ae.getSource()==btn_exit)
				{
					this.dispose();
					
				}
				
				if(ae.getSource()==btn_search)
				{
				     searchDetails();
					
					
				}
				if(ae.getSource()==btn_delete)
				{

					if(customerid.isEmpty() )
					{
						JOptionPane.showMessageDialog(this, "Enter the Supervisor ID first","Error", JOptionPane.ERROR_MESSAGE);
						txt_customerid.grabFocus();
						txt_customerid.selectAll();
					}
					
					
					
					else if(name.isEmpty())
					{
						JOptionPane.showMessageDialog(this, "Search the Supervisor ID first","Error", JOptionPane.ERROR_MESSAGE);
					}
					
					
				   
					else
						
					deleteDetails();
					
					
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