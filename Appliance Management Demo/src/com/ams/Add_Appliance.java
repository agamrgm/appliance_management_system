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
//import javax.swing.JTextArea;
//import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

//import javax.swing.ButtonGroup;

public class Add_Appliance extends JFrame implements ActionListener,WindowListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_applianceid;
	private JTextField txt_name;
	private JButton btn_enroll;
	private String name,id;
	private Connection con;
	private PreparedStatement pswrite,psread;
	private ResultSet rsread;
	private JButton btn_exit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Appliance frame = new Add_Appliance();
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
	public Add_Appliance() 
	{
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Add_Appliance.class.getResource("/com/images/ML logo.png")));
		 
		
		con = DataBaseConnection.connection();
		this.addWindowListener(this);
		createGui();
		
		
		
	}
	
	public void createGui()
	{
		
		setResizable(false);
		setTitle("Add Appliance");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 769, 536);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_add_appliances = new JLabel("Add Appliances");
		lbl_add_appliances.setForeground(new Color(0, 0, 128));
		lbl_add_appliances.setFont(new Font("Cambria Math", Font.BOLD, 55));
		lbl_add_appliances.setBounds(204, 23, 433, 65);
		contentPane.add(lbl_add_appliances);
		
		JLabel lbl_applianceid = new JLabel("Appliance ID");
		lbl_applianceid.setForeground(new Color(0, 0, 128));
		lbl_applianceid.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_applianceid.setBounds(158, 161, 170, 31);
		contentPane.add(lbl_applianceid);
		
		txt_applianceid = new JTextField();
		txt_applianceid.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_applianceid.setOpaque(false);
		txt_applianceid.setForeground(new Color(0, 0, 128));
		txt_applianceid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_applianceid.setBounds(371, 154, 266, 38);
		contentPane.add(txt_applianceid);
		txt_applianceid.setColumns(20);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setForeground(new Color(0, 0, 128));
		lbl_name.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_name.setBounds(158, 239, 170, 40);
		contentPane.add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setOpaque(false);
		txt_name.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_name.setForeground(new Color(0, 0, 128));
		txt_name.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_name.setBounds(371, 241, 266, 38);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		btn_enroll = new JButton("Enroll");
		btn_enroll.setOpaque(false);
		btn_enroll.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		btn_enroll.setBackground(new Color(30, 144, 255));
		btn_enroll.setForeground(new Color(0, 0, 128));
		btn_enroll.setFont(new Font("Cambria Math", Font.BOLD, 24));
		btn_enroll.setBounds(307, 333, 127, 46);
		btn_enroll.addActionListener(this);
		btn_enroll.addKeyListener(this);
		contentPane.add(btn_enroll);
		
		btn_exit = new JButton("Exit");
		btn_exit.setBackground(new Color(100, 149, 237));
		btn_exit.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		btn_exit.setOpaque(false);
		btn_exit.setForeground(new Color(0, 0, 128));
		btn_exit.setFont(new Font("Cambria Math", Font.BOLD, 24));
		btn_exit.setBounds(503, 333, 127, 46);
		btn_exit.addActionListener(this);
		btn_exit.addKeyListener(this);
		contentPane.add(btn_exit);
		
		lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		lbl_border.setBounds(111, 105, 590, 321);
		contentPane.add(lbl_border);
		
		lbl_mainborder = new JLabel("");
		lbl_mainborder.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		lbl_mainborder.setIcon(new ImageIcon(Add_Appliance.class.getResource("/com/images/Add_Supervisor.jpg")));
		lbl_mainborder.setBounds(0, 0, 769, 536);
		contentPane.add(lbl_mainborder);
		
		
		
	}
	
	
	
   public boolean checkApplianceId()
   {
		  String strcheck = "select applianceid from appliancedetails";
		  
		  try {
			psread = con.prepareStatement(strcheck);
			
			rsread = psread.executeQuery();
			
			while(rsread.next())
			{
				
				String Applianceid = rsread.getString("applianceid");
				
			  if(id.equalsIgnoreCase(Applianceid))
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
	  
	  
	
	
	
	
	
	
	
	
	String caption;
	private JLabel lbl_border;
	private JLabel lbl_mainborder;

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		
		caption = ae.getActionCommand();
		
		if(caption.equalsIgnoreCase("Exit"))
		{
			this.dispose();			
		}
		
		if(caption.equalsIgnoreCase("Enroll"))
			{
		
	   
		        fetchDetails();
		
		       if(checkEmpty())	
	          {
		          System.out.println("All fields are mandatory"); 
		   
	         }
		
		     else
		     { 
			      if(checkApplianceId())
			     {
			         JOptionPane.showMessageDialog(this, "Appliance ID already exist", "Error",JOptionPane.ERROR_MESSAGE);	
			         txt_applianceid.grabFocus();
				     txt_applianceid.selectAll();
			     }
			     else
			     {
				     addDetails();
			 	
			     }
			
		      }
		}
		
		
		
	}
	
	
	public boolean checkEmpty()
	{
		if(id.isEmpty())
		{
				JOptionPane.showMessageDialog(this, "Enter Appliance ID", "Error", JOptionPane.ERROR_MESSAGE);
				return true;
		}
		if(name.isEmpty())
		{	
			JOptionPane.showMessageDialog(this, "Enter Appliance Name", "Error", JOptionPane.ERROR_MESSAGE);
		    return true;
		}
		
		return false;
		
	}
	
	public void fetchDetails()
	{
		id = txt_applianceid.getText();
		name = txt_name.getText();
		
		
	}
	
	public void addDetails()
	{
	String strinsert = "insert into appliancedetails values(?,?)";
	   
	   try {
		
		   pswrite = con.prepareStatement(strinsert);
		  
		   pswrite.setString(1, id);
		   pswrite.setString(2, name);
		   
		   
		   
		   int status = pswrite.executeUpdate();
		   
		
		   if(status > 0 )
		   {
			   JOptionPane.showMessageDialog(this, "Information Added Successfully", "Submitted", JOptionPane.INFORMATION_MESSAGE);
			   txt_applianceid.setText("");
			    txt_name.setText("");
				
				
			   
			   
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
	 
	
	
	
	
	
	
	
	
	

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) 
	{
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
			
			
			if(e.getSource()==btn_exit)
			{
				this.dispose();			
			}
			
			if(e.getSource()==btn_enroll)
				{
			
		   
			        fetchDetails();
			
			       if(checkEmpty())	
		          {
			          System.out.println("All fields are mandatory"); 
			   
		         }
			
			     else
			     { 
				      if(checkApplianceId())
				     {
				         JOptionPane.showMessageDialog(this, "Appliance ID already exist", "Error",JOptionPane.ERROR_MESSAGE);	
				         txt_applianceid.grabFocus();
					     txt_applianceid.selectAll();
				     }
				     else
				     {
					     addDetails();
				 	
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