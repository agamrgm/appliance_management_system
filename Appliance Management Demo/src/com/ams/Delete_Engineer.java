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

public class Delete_Engineer extends JFrame implements ActionListener,WindowListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_engineerid;
	private JTextField txt_name;
	private JTextField txt_phoneno;
	private JTextField txt_email;
	private JTextField txt_gender;
	private JTextArea txt_area_address;
	private JButton btn_search,btn_delete,btn_exit;
	private JLabel lbl_border,lbl_mainborder;
	
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
					Delete_Engineer frame = new Delete_Engineer();
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
	public Delete_Engineer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Delete_Engineer.class.getResource("/com/images/ML logo.png")));
		
		con = DataBaseConnection.connection();
		setUndecorated(true);
		this.addWindowListener(this);
		createGui();

	}
	
	
	public void createGui()
	{
		
		setTitle("Delete Engineer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 798, 727);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_deleteengineer = new JLabel("Delete Engineer");
		lbl_deleteengineer.setForeground(Color.WHITE);
		lbl_deleteengineer.setFont(new Font("Cambria Math", Font.BOLD, 57));
		lbl_deleteengineer.setBounds(161, 23, 439, 65);
		contentPane.add(lbl_deleteengineer);
		
		JLabel lbl_engineerid = new JLabel("Engineer ID");
		lbl_engineerid.setForeground(Color.WHITE);
		lbl_engineerid.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_engineerid.setBounds(99, 133, 153, 42);
		contentPane.add(lbl_engineerid);
		
		txt_engineerid = new JTextField();
		txt_engineerid.setOpaque(false);
		txt_engineerid.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_engineerid.setForeground(Color.WHITE);
		txt_engineerid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_engineerid.setBounds(289, 133, 251, 33);
		contentPane.add(txt_engineerid);
		txt_engineerid.setColumns(10);
		
		btn_search = new JButton("Search");
		btn_search.setForeground(Color.WHITE);
		btn_search.setBackground(Color.YELLOW);
		btn_search.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_search.setOpaque(false);
		btn_search.setFont(new Font("Garamond", Font.BOLD, 33));
		btn_search.setBounds(566, 126, 138, 42);
		btn_search.addActionListener(this);
		btn_search.addKeyListener(this);
		contentPane.add(btn_search);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setForeground(Color.WHITE);
		lbl_name.setFont(new Font("Cambria Math", Font.BOLD, 27));
		lbl_name.setBounds(99, 195, 106, 33);
		contentPane.add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_name.setOpaque(false);
		txt_name.setForeground(Color.WHITE);
		txt_name.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_name.setEditable(false);
		txt_name.setBounds(289, 195, 251, 33);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		JLabel lbl_phoneo = new JLabel("Phone No");
		lbl_phoneo.setForeground(Color.WHITE);
		lbl_phoneo.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_phoneo.setBounds(99, 251, 138, 29);
		contentPane.add(lbl_phoneo);
		
		txt_phoneno = new JTextField();
		txt_phoneno.setOpaque(false);
		txt_phoneno.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_phoneno.setForeground(Color.WHITE);
		txt_phoneno.setEditable(false);
		txt_phoneno.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_phoneno.setBounds(289, 247, 251, 33);
		contentPane.add(txt_phoneno);
		txt_phoneno.setColumns(10);
		
		JLabel lbl_email = new JLabel("Email ID");
		lbl_email.setForeground(Color.WHITE);
		lbl_email.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_email.setBounds(99, 301, 122, 29);
		contentPane.add(lbl_email);
		
		txt_email = new JTextField();
		txt_email.setOpaque(false);
		txt_email.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_email.setForeground(Color.WHITE);
		txt_email.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_email.setEditable(false);
		txt_email.setBounds(288, 297, 252, 33);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		
		JLabel lbl_address = new JLabel("Address");
		lbl_address.setForeground(Color.WHITE);
		lbl_address.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_address.setBounds(99, 378, 138, 52);
		contentPane.add(lbl_address);
		
		txt_area_address = new JTextArea();
		txt_area_address.setOpaque(false);
		txt_area_address.setForeground(Color.WHITE);
		txt_area_address.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_area_address.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_area_address.setEditable(false);
		txt_area_address.setBounds(289, 361, 251, 83);
		contentPane.add(txt_area_address);
		
		JLabel lbl_gender = new JLabel("Gender");
		lbl_gender.setForeground(Color.WHITE);
		lbl_gender.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_gender.setBounds(99, 473, 122, 33);
		contentPane.add(lbl_gender);
		
		txt_gender = new JTextField();
		txt_gender.setOpaque(false);
		txt_gender.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_gender.setForeground(Color.WHITE);
		txt_gender.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_gender.setEditable(false);
		txt_gender.setBounds(289, 469, 251, 33);
		contentPane.add(txt_gender);
		txt_gender.setColumns(10);
		
		btn_delete = new JButton("Delete");
		btn_delete.setForeground(Color.WHITE);
		btn_delete.setOpaque(false);
		btn_delete.setBackground(Color.YELLOW);
		btn_delete.setBorder(new LineBorder(new Color(255, 255, 255)));
		btn_delete.setFont(new Font("Cambria Math", Font.BOLD, 33));
		btn_delete.setBounds(227, 622, 153, 47);
		btn_delete.addActionListener(this);
		btn_delete.addKeyListener(this);
		contentPane.add(btn_delete);
		
		JLabel lbl_applianceid = new JLabel("Appliance ID");
		lbl_applianceid.setForeground(Color.WHITE);
		lbl_applianceid.setFont(new Font("Cambria Math", Font.BOLD, 23));
		lbl_applianceid.setBounds(99, 526, 138, 39);
		contentPane.add(lbl_applianceid);
		
		txt_applianceid = new JTextField();
		txt_applianceid.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_applianceid.setOpaque(false);
		txt_applianceid.setForeground(Color.WHITE);
		txt_applianceid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_applianceid.setEditable(false);
		txt_applianceid.setBounds(291, 532, 249, 33);
		contentPane.add(txt_applianceid);
		txt_applianceid.setColumns(10);
		
		btn_exit = new JButton("Exit");
		btn_exit.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_exit.setBackground(Color.YELLOW);
		btn_exit.setOpaque(false);
		btn_exit.setForeground(Color.WHITE);
		btn_exit.setFont(new Font("Cambria Math", Font.BOLD, 33));
		btn_exit.setBounds(431, 622, 153, 47);
		btn_exit.addActionListener(this);
		btn_exit.addKeyListener(this);
		contentPane.add(btn_exit);
		
		lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		lbl_border.setBounds(55, 87, 661, 610);
		contentPane.add(lbl_border);
		
		lbl_mainborder = new JLabel("");
		lbl_mainborder.setBorder(new LineBorder(Color.WHITE, 3, true));
		lbl_mainborder.setIcon(new ImageIcon(Delete_Engineer.class.getResource("/com/images/Delete.jpg")));
		lbl_mainborder.setBounds(0, 0, 797, 727);
		contentPane.add(lbl_mainborder);
		
		
	}

	String engineerid,name;
	String caption;
	private JTextField txt_applianceid;
	
   public void fetchDetails()
   {
	   
	   engineerid = txt_engineerid.getText();
	   name = txt_name.getText();
	   
   }

	public void actionPerformed(ActionEvent ae) 
	{
		caption = ae.getActionCommand();
		fetchDetails();
		
		
		if(caption.equals("Exit"))
		{
			this.dispose();
		}
		
		
		if(caption.equals("Search"))
		{
		     searchDetails();
			
			
		}
		if(caption.equals("Delete"))
		{

			if(engineerid.isEmpty() )
			{
				JOptionPane.showMessageDialog(this, "Enter the Engineer ID first","Error", JOptionPane.ERROR_MESSAGE);
				txt_engineerid.grabFocus();
				txt_engineerid.selectAll();
			}
			
			
			
			else if(name.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Search the Engineer ID first","Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
			
			else
				
			deleteDetails();
			
			
		}
		
		
		
		
		
		
	}
	
	public void searchDetails()
	{
	    	 
		  try 
		  {
			  
			  String str_read = "select * from engineerdetails where engineerid=?";
			  psread = con.prepareStatement(str_read);
			  psread.setString(1, engineerid);
			  rsread = psread.executeQuery();
			  int flag = 0;
			 while(rsread.next())
			  {
				  
				  String Engineerid =rsread.getString("engineerid");
				  if(Engineerid.equals(engineerid))
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
			  txt_gender.setText(rsread.getString("gender"));
			  txt_applianceid.setText(rsread.getString("applianceid"));
			 
			  
			  }
			 else
			 {
				JOptionPane.showMessageDialog(this,"No such Engineer ID exist", "Error", JOptionPane.ERROR_MESSAGE);
			    txt_engineerid.grabFocus();
				txt_engineerid.selectAll();
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
		
        
		
		int selection =	JOptionPane.showConfirmDialog(this, "It will delete engineer's record permanently" , "Confirmation",JOptionPane.WARNING_MESSAGE);
		
		if(selection  == 0)
		{
			String str_delete="delete from engineerdetails where engineerid=?";
			try {
				
				psread=con.prepareStatement(str_delete);
				psread.setString(1, engineerid);
				int status=	psread.executeUpdate();
				
				if(status > 0)
				{
				   JOptionPane.showMessageDialog(this, "Engineer Record Deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
				    txt_engineerid.setText("");
				    txt_name.setText("");
					txt_email.setText("");
					txt_phoneno.setText("");
					txt_gender.setText("");
					txt_area_address.setText("");
					txt_applianceid.setText("");
					
					
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

					if(engineerid.isEmpty() )
					{
						JOptionPane.showMessageDialog(this, "Enter the Engineer ID first","Error", JOptionPane.ERROR_MESSAGE);
						txt_engineerid.grabFocus();
						txt_engineerid.selectAll();
					}
					
					
					
					else if(name.isEmpty())
					{
						JOptionPane.showMessageDialog(this, "Search the Engineer ID first","Error", JOptionPane.ERROR_MESSAGE);
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