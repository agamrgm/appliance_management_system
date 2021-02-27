package com.ams;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.dbconnection.DataBaseConnection;

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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Change_Password_Admin extends JFrame implements ActionListener, WindowListener, KeyListener

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField pwd_current;
	private JPasswordField pwd_new;
	private JPasswordField pwd_confirm;
	private JButton btn_exit,btn_submit;
	
	
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
					Change_Password_Admin frame = new Change_Password_Admin();
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
	public Change_Password_Admin() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Change_Password_Admin.class.getResource("/com/images/ML logo.png")));
		con=DataBaseConnection.connection();
		setUndecorated(true);
		createGui();
		this.addWindowListener(this);
		
	}
	
	
	

	public void createGui()
	{
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 875, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_current_password = new JLabel("Current Password");
		lbl_current_password.setForeground(Color.WHITE);
		lbl_current_password.setFont(new Font("Cambria Math", Font.BOLD, 23));
		lbl_current_password.setBounds(175, 167, 199, 38);
		contentPane.add(lbl_current_password);
		
		JLabel lbl_usernaame = new JLabel("Username");
		lbl_usernaame.setForeground(Color.WHITE);
		lbl_usernaame.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_usernaame.setBounds(175, 110, 165, 29);
		contentPane.add(lbl_usernaame);
		
		txt_username = new JTextField();
		txt_username.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_username.setForeground(Color.WHITE);
		txt_username.setOpaque(false);
		txt_username.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_username.setBounds(460, 110, 222, 30);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		JLabel lbl_new_password = new JLabel("New Password");
		lbl_new_password.setForeground(Color.WHITE);
		lbl_new_password.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_new_password.setBounds(175, 234, 199, 29);
		contentPane.add(lbl_new_password);
		
		pwd_current = new JPasswordField();
		pwd_current.setBorder(new LineBorder(Color.WHITE, 1, true));
		pwd_current.setOpaque(false);
		pwd_current.setForeground(Color.WHITE);
		pwd_current.setFont(new Font("Cambria Math", Font.BOLD, 22));
		pwd_current.setEchoChar('*');
		pwd_current.setBounds(460, 171, 222, 29);
		contentPane.add(pwd_current);
		
		pwd_new = new JPasswordField();
		pwd_new.setForeground(Color.WHITE);
		pwd_new.setBorder(new LineBorder(Color.WHITE, 1, true));
		pwd_new.setOpaque(false);
		pwd_new.setEchoChar('*');
		pwd_new.setFont(new Font("Cambria Math", Font.BOLD, 22));
		pwd_new.setBounds(460, 233, 222, 31);
		contentPane.add(pwd_new);
		
		JLabel lbl_confirm_password = new JLabel("Confirm Password");
		lbl_confirm_password.setForeground(Color.WHITE);
		lbl_confirm_password.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_confirm_password.setBounds(175, 307, 210, 29);
		contentPane.add(lbl_confirm_password);
		
		pwd_confirm = new JPasswordField();
		pwd_confirm.setBorder(new LineBorder(Color.WHITE, 1, true));
		pwd_confirm.setOpaque(false);
		pwd_confirm.setForeground(Color.WHITE);
		pwd_confirm.setEchoChar('*');
		pwd_confirm.setFont(new Font("Cambria Math", Font.BOLD, 22));
		pwd_confirm.setBounds(460, 306, 222, 30);
		contentPane.add(pwd_confirm);
		
		btn_submit = new JButton("Submit");
		btn_submit.setForeground(Color.WHITE);
		btn_submit.setOpaque(false);
		btn_submit.setBackground(Color.PINK);
		btn_submit.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_submit.setFont(new Font("Cambria Math", Font.BOLD, 28));
		btn_submit.setBounds(313, 385, 137, 38);
		btn_submit.addActionListener(this);
		btn_submit.addKeyListener(this);
		contentPane.add(btn_submit);
		
		btn_exit = new JButton("Exit");
		btn_exit.setOpaque(false);
		btn_exit.setBackground(Color.PINK);
		btn_exit.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_exit.setForeground(Color.WHITE);
		btn_exit.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btn_exit.setBounds(545, 385, 137, 38);
		btn_exit.addActionListener(this);
		btn_exit.addKeyListener(this);
		contentPane.add(btn_exit);
		
		JLabel lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		lbl_border.setBounds(100, 82, 668, 383);
		contentPane.add(lbl_border);
		
		JLabel lbl_Heading = new JLabel("Change Password");
		lbl_Heading.setForeground(Color.WHITE);
		lbl_Heading.setFont(new Font("Cambria Math", Font.BOLD, 60));
		lbl_Heading.setBounds(185, 10, 539, 64);
		contentPane.add(lbl_Heading);
		
		JLabel lbl_mainborder = new JLabel("");
		lbl_mainborder.setBorder(new LineBorder(Color.WHITE, 3, true));
		lbl_mainborder.setIcon(new ImageIcon(Change_Password_Admin.class.getResource("/com/images/Login1.jpg")));
		lbl_mainborder.setBounds(0, 0, 875, 536);
		contentPane.add(lbl_mainborder);
		
	}
	
	String current_password,caption,username,password_current,password_new,password_confirm;
	char[] pass_current,pass_new,pass_confirm;
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		
		caption = ae.getActionCommand();
		username = txt_username.getText();
		pass_current = pwd_current.getPassword();
		password_current = String.valueOf(pass_current);
		
		pass_new = pwd_new.getPassword();
		password_new = String.valueOf(pass_new);
		
		pass_confirm = pwd_confirm.getPassword();
		password_confirm = String.valueOf(pass_confirm);
		
		if(caption.contentEquals("Exit") )
		{
			
		
			this.dispose();
			
			
		}
		
		if(caption.contentEquals("Submit"))
		{
			
			if(checkEmpty())
			{
				System.out.println("All fields required");	
			}
			
			else if(password_new.contentEquals(password_confirm))
			{
				if(credentials())
				{
					int status = changePassword(password_new,username);
					if(status > 0)
					{
					JOptionPane.showMessageDialog(this, "Password Updated successfully", "Error", JOptionPane.ERROR_MESSAGE);
					this.dispose();
					
					
				}
				
				
				}
			
			else
			
				JOptionPane.showMessageDialog(this,"New Password & Confirm Password doesn't match", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
			
			
		}	
			
			
		
		
       
		
		
		
	}
	
	
	
	
	
	
	
	public boolean checkEmpty() 
	{

		 if(username.isEmpty() )
		 {
			 JOptionPane.showMessageDialog(this, "Username is required", "Error", JOptionPane.ERROR_MESSAGE);
		    return true;
		 }
		 
				
	     if(password_current.isEmpty() ) 
	     {
	    	JOptionPane.showMessageDialog(this, "Current Password is required", "Error", JOptionPane.ERROR_MESSAGE);	
	    	return true;
	     }
	    	
	     if(password_new.isEmpty())
	     {
	         JOptionPane.showMessageDialog(this, "New Password is required", "Error", JOptionPane.ERROR_MESSAGE);
             return true;

	     }
	     
	     if(password_confirm.isEmpty())
	     {
	         JOptionPane.showMessageDialog(this, "Confirm Password is required", "Error", JOptionPane.ERROR_MESSAGE);
             return true;

	     }
	    
	        return false;

	}
	
	
	
	public boolean credentials() 
	{
          
         
        	int flag =  fetchData(username);
        	if(flag!=0)
        	{
		      if(password_current.contentEquals(current_password) )
		      {
		    	  
		    	  return true;
				
			  }
		      else
		      {
		    	  JOptionPane.showMessageDialog(this, "Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
		          pwd_current.selectAll();
		      
		      }
        	}
        	else
        	{
        		
        		JOptionPane.showMessageDialog(this, "No such username exist", "Error", JOptionPane.ERROR_MESSAGE);
        		txt_username.selectAll();
        		txt_username.grabFocus();
        		return false;
        	
        	}
			return false;
		  
		 
		  }
	
		  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int fetchData(String username)
	{
	int flag=0;	
		
		try {
			
			
			String strsql=  "select * from login where username=?";
			
			ps = con.prepareStatement(strsql);
			ps.setString(1,username);
		    rs =	ps.executeQuery();
				if(rs.next())
				{
					current_password = rs.getString("password");
					
					flag++;
						
							
				}
				else
					return flag;
			
		}
			
		catch(SQLException se)
		{
			
			
			System.out.println(se);
		}
	
		
		
		finally {

			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		return flag;		
	
	
		
	}
	
	
	
public int changePassword(String curr_password,String id)
	
	{
		
		int updatestatus=0;
		try {
			
			String strupdate="update login set password=? where username=?";
			
			ps=con.prepareStatement(strupdate);
			
			ps.setString(1, curr_password);
			ps.setString(2, id);
			
			System.out.println(ps);
			
		 updatestatus=ps.executeUpdate();	
			
		}
		catch(SQLException se)
		{
			
			se.printStackTrace();
		}
		finally {
			
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	return updatestatus;	
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
		
		username = txt_username.getText();
		pass_current = pwd_current.getPassword();
		password_current = String.valueOf(pass_current);
		
		pass_new = pwd_new.getPassword();
		password_new = String.valueOf(pass_new);
		
		pass_confirm = pwd_confirm.getPassword();
		password_confirm = String.valueOf(pass_confirm);
		
		if(ae.getSource()==btn_exit )
		{
			
		
			this.dispose();
			
			
		}
		
		if(ae.getSource()==btn_submit)
		{
			
			if(checkEmpty())
			{
				System.out.println("All fields required");	
			}
			
			else if(password_new.contentEquals(password_confirm))
			{
				if(credentials())
				{
					int status = changePassword(password_new,username);
					if(status > 0)
					{
					JOptionPane.showMessageDialog(this, "Password Updated successfully", "Error", JOptionPane.ERROR_MESSAGE);
					this.dispose();
					
					
				}
				
				
				}
			
			else
			
				JOptionPane.showMessageDialog(this,"New Password & Confirm Password doesn't match", "Error", JOptionPane.ERROR_MESSAGE);
				
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