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

public class Delete_Supervisor extends JFrame implements ActionListener,WindowListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_supervisorid;
	private JTextField txt_name;
	private JTextField txt_phoneno;
	private JTextField txt_email;
	private JTextField txt_gender;
	private JTextArea txt_area_address;
	
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
					Delete_Supervisor frame = new Delete_Supervisor();
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
	public Delete_Supervisor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Delete_Supervisor.class.getResource("/com/images/ML logo.png")));
		setResizable(false);
		
	      setUndecorated(true);
		con = DataBaseConnection.connection();
		this.addWindowListener(this);
		createGui();

	}
	
	
	public void createGui()
	{
		
		setTitle("Delete Staff");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 798, 727);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lbl_deletesupervisor = new JLabel("Delete Supervisor");
		lbl_deletesupervisor.setForeground(Color.WHITE);
		lbl_deletesupervisor.setFont(new Font("Cambria Math", Font.BOLD, 45));
		lbl_deletesupervisor.setBounds(182, 24, 376, 57);
		contentPane.add(lbl_deletesupervisor);
		
		JLabel lbl_supervisorid = new JLabel("Supervisor ID");
		lbl_supervisorid.setForeground(Color.WHITE);
		lbl_supervisorid.setFont(new Font("Cambria Math", Font.BOLD, 20));
		lbl_supervisorid.setBounds(73, 117, 173, 33);
		contentPane.add(lbl_supervisorid);
		
		txt_supervisorid = new JTextField();
		txt_supervisorid.setOpaque(false);
		txt_supervisorid.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_supervisorid.setForeground(Color.WHITE);
		txt_supervisorid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_supervisorid.setBounds(256, 113, 254, 33);
		contentPane.add(txt_supervisorid);
		txt_supervisorid.setColumns(10);
		
		btn_search = new JButton("Search");
		btn_search.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_search.setBackground(Color.WHITE);
		btn_search.setForeground(Color.WHITE);
		btn_search.setOpaque(false);
		btn_search.setFont(new Font("Cambria Math", Font.BOLD, 28));
		btn_search.setBounds(555, 107, 125, 42);
		btn_search.addActionListener(this);
		btn_search.addKeyListener(this);
		contentPane.add(btn_search);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setForeground(Color.WHITE);
		lbl_name.setFont(new Font("Cambria Math", Font.BOLD, 22));
		lbl_name.setBounds(73, 195, 105, 33);
		contentPane.add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_name.setOpaque(false);
		txt_name.setForeground(Color.WHITE);
		txt_name.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_name.setEditable(false);
		txt_name.setBounds(256, 194, 254, 33);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		JLabel lbl_phoneo = new JLabel("Phone No");
		lbl_phoneo.setForeground(Color.WHITE);
		lbl_phoneo.setFont(new Font("Cambria Math", Font.BOLD, 22));
		lbl_phoneo.setBounds(73, 286, 105, 25);
		contentPane.add(lbl_phoneo);
		
		txt_phoneno = new JTextField();
		txt_phoneno.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_phoneno.setOpaque(false);
		txt_phoneno.setForeground(Color.WHITE);
		txt_phoneno.setEditable(false);
		txt_phoneno.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_phoneno.setBounds(256, 274, 254, 33);
		contentPane.add(txt_phoneno);
		txt_phoneno.setColumns(10);
		
		JLabel lbl_email = new JLabel("Email ID");
		lbl_email.setForeground(Color.WHITE);
		lbl_email.setFont(new Font("Cambria Math", Font.BOLD, 22));
		lbl_email.setBounds(73, 354, 105, 25);
		contentPane.add(lbl_email);
		
		txt_email = new JTextField();
		txt_email.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_email.setOpaque(false);
		txt_email.setForeground(Color.WHITE);
		txt_email.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_email.setEditable(false);
		txt_email.setBounds(256, 349, 254, 33);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		
		JLabel lbl_address = new JLabel("Address");
		lbl_address.setForeground(Color.WHITE);
		lbl_address.setFont(new Font("Cambria Math", Font.BOLD, 22));
		lbl_address.setBounds(73, 427, 105, 25);
		contentPane.add(lbl_address);
		
		txt_area_address = new JTextArea();
		txt_area_address.setOpaque(false);
		txt_area_address.setForeground(Color.WHITE);
		txt_area_address.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_area_address.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_area_address.setEditable(false);
		txt_area_address.setBounds(256, 408, 254, 72);
		contentPane.add(txt_area_address);
		
		JLabel lbl_gender = new JLabel("Gender");
		lbl_gender.setForeground(Color.WHITE);
		lbl_gender.setFont(new Font("Cambria Math", Font.BOLD, 22));
		lbl_gender.setBounds(73, 527, 105, 33);
		contentPane.add(lbl_gender);
		
		txt_gender = new JTextField();
		txt_gender.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_gender.setOpaque(false);
		txt_gender.setForeground(Color.WHITE);
		txt_gender.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_gender.setEditable(false);
		txt_gender.setBounds(256, 523, 254, 33);
		contentPane.add(txt_gender);
		txt_gender.setColumns(10);
		
		btn_delete = new JButton("Delete");
		btn_delete.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_delete.setOpaque(false);
		btn_delete.setForeground(Color.WHITE);
		btn_delete.setBackground(Color.WHITE);
		btn_delete.setFont(new Font("Garamond", Font.BOLD, 33));
		btn_delete.setBounds(261, 592, 142, 47);
		btn_delete.addActionListener(this);
		btn_delete.addKeyListener(this);
		contentPane.add(btn_delete);
		
		btn_Exit = new JButton("Exit");
		btn_Exit.addActionListener(this);
		btn_Exit.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_Exit.setOpaque(false);
		btn_Exit.setBackground(Color.WHITE);
		btn_Exit.setForeground(Color.WHITE);
		btn_Exit.setFont(new Font("Garamond", Font.BOLD, 33));
		btn_Exit.setBounds(490, 592, 142, 47);
		contentPane.add(btn_Exit);
		
		JLabel lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		lbl_border.setBounds(48, 91, 657, 595);
		contentPane.add(lbl_border);
		
		JLabel lbl_mainborder = new JLabel("");
		lbl_mainborder.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		lbl_mainborder.setIcon(new ImageIcon(Delete_Supervisor.class.getResource("/com/images/Delete.jpg")));
		lbl_mainborder.setBounds(0, 0, 798, 727);
		contentPane.add(lbl_mainborder);
		
		
	}

	String supervisorid,name;
	String caption;
	private JButton btn_search;
	private JButton btn_delete;
	private JButton btn_Exit;
	
   public void fetchDetails()
   {
	   
	   supervisorid = txt_supervisorid.getText();
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

			if(supervisorid.isEmpty() )
			{
				JOptionPane.showMessageDialog(this, "Enter the Supervisor ID first","Error", JOptionPane.ERROR_MESSAGE);
				txt_supervisorid.grabFocus();
				txt_supervisorid.selectAll();
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
			  
			  String str_read = "select * from supervisordetails where supervisorid=?";
			  psread = con.prepareStatement(str_read);
			  psread.setString(1, supervisorid);
			  rsread = psread.executeQuery();
			  int flag = 0;
			 while(rsread.next())
			  {
				  
				  String Supervisorid =rsread.getString("supervisorid");
				  if(Supervisorid.equals(supervisorid))
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
			 
			  
			  }
			 else if(flag==0)
			 {
				 
				 if(supervisorid.isEmpty())
					 JOptionPane.showMessageDialog(this,"Please enter a Staff ID", "Error", JOptionPane.ERROR_MESSAGE);
				 
				 else { 
				 
				JOptionPane.showMessageDialog(this,"No such Staff ID exist", "Error", JOptionPane.ERROR_MESSAGE);
			    txt_supervisorid.grabFocus();
				txt_supervisorid.selectAll();
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
		
        
		
		int selection =	JOptionPane.showConfirmDialog(this, "It will delete supervisor's record permanently" , "Confirmation",JOptionPane.WARNING_MESSAGE);
		
		if(selection  == 0)
		{
			String str_delete="delete from supervisordetails where supervisorid=?";
			try {
				
				psread=con.prepareStatement(str_delete);
				psread.setString(1, supervisorid);
				int status=	psread.executeUpdate();
				
				if(status > 0)
				{
				   JOptionPane.showMessageDialog(this, "Supervisor Record Deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
				    txt_supervisorid.setText("");
				    txt_name.setText("");
					txt_email.setText("");
					txt_phoneno.setText("");
					txt_gender.setText("");
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
			
			if(ae.getSource()==btn_Exit)
			{
				this.dispose();
				
			}
			
			
			
			if(ae.getSource()==btn_search)
			{
			     searchDetails();
				
				
			}
			if(ae.getSource()==btn_delete)
			{

				if(supervisorid.isEmpty() )
				{
					JOptionPane.showMessageDialog(this, "Enter the Supervisor ID first","Error", JOptionPane.ERROR_MESSAGE);
					txt_supervisorid.grabFocus();
					txt_supervisorid.selectAll();
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