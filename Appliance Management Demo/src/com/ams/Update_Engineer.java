 package com.ams;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbconnection.DataBaseConnection;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
public class Update_Engineer extends JFrame  implements ActionListener,WindowListener,KeyListener
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_email;
	private JTextField txt_phone;
	private JTextArea text_area_address;
	private JButton btn_exit;

	private Connection  con;
	private JComboBox<String> cmb_engineerid;
	
	private PreparedStatement ps,pscourse;
	private ResultSet rscourse;
	
	

	
	String name,gender,address,email,phone,applianceid;
	private JButton btn_update;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Engineer frame = new Update_Engineer();
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
	public Update_Engineer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Update_Engineer.class.getResource("/com/images/ML logo.png")));
		setResizable(false);
		setTitle("Update Supervisor");
		setUndecorated(true);
		con=DataBaseConnection.connection();
		this.addWindowListener(this);
		createGui();
		
	}
	
	
	public void createGui()
	{
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 778, 729);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_name = new JTextField();
		txt_name.setForeground(Color.CYAN);
		txt_name.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_name.setOpaque(false);
		txt_name.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_name.setEditable(false);
		//txtid.addFocusListener(this);
		txt_name.setBounds(300, 175, 255, 29);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_email.setForeground(Color.WHITE);
		txt_email.setOpaque(false);
		txt_email.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_email.setBounds(300, 284, 255, 29);
		contentPane.add(txt_email);
		txt_email.setColumns(20);
		
		txt_phone = new JTextField();
		txt_phone.setForeground(Color.WHITE);
		txt_phone.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_phone.setOpaque(false);
		txt_phone.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_phone.setBounds(300, 462, 255, 34);
		contentPane.add(txt_phone);
		txt_phone.setColumns(10);
		
		 btn_update = new JButton("Update");
		 btn_update.setForeground(Color.WHITE);
		 btn_update.setOpaque(false);
		 btn_update.setBackground(Color.YELLOW);
		 btn_update.setBorder(new LineBorder(Color.WHITE, 1, true));
		 btn_update.setFont(new Font("Cambria Math", Font.BOLD, 30));
		 btn_update.setBounds(238, 548, 141, 44);
		 btn_update.addKeyListener(this);
		 btn_update.addActionListener(this);
		 contentPane.add(btn_update);
		
		cmb_engineerid = new JComboBox<String>();
		cmb_engineerid.setBackground(new Color(173, 216, 230));
		cmb_engineerid.setForeground(new Color(0, 0, 128));
		cmb_engineerid.setOpaque(false);
		cmb_engineerid.setFont(new Font("Cambria Math", Font.PLAIN, 22));
		cmb_engineerid.addActionListener(this);
		cmb_engineerid.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Engineer ID"}));
		populateCombo();
		cmb_engineerid.setBounds(300, 115, 255, 32);
		contentPane.add(cmb_engineerid);
		
		JLabel lbl_engineerid = new JLabel("Engineer ID");
		lbl_engineerid.setForeground(Color.WHITE);
		lbl_engineerid.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_engineerid.setBounds(102, 114, 141, 33);
		contentPane.add(lbl_engineerid);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setForeground(Color.WHITE);
		lbl_name.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_name.setBounds(102, 170, 119, 29);
		contentPane.add(lbl_name);
		
		JLabel lbl_email = new JLabel("Email ID");
		lbl_email.setForeground(Color.WHITE);
		lbl_email.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_email.setBounds(102, 279, 119, 29);
		contentPane.add(lbl_email);
		
		JLabel lbl_phone = new JLabel("Phone No");
		lbl_phone.setForeground(Color.WHITE);
		lbl_phone.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_phone.setBounds(102, 461, 141, 34);
		contentPane.add(lbl_phone);
		
		text_area_address = new JTextArea();
		text_area_address.setForeground(Color.WHITE);
		text_area_address.setOpaque(false);
		text_area_address.setBorder(new LineBorder(Color.WHITE, 1, true));
		text_area_address.setFont(new Font("Cambria Math", Font.BOLD, 22));
		text_area_address.setBounds(300, 346, 255, 76);
		contentPane.add(text_area_address);
		
		JLabel lbl_address = new JLabel("Address");
		lbl_address.setForeground(Color.WHITE);
		lbl_address.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_address.setBounds(102, 362, 135, 54);
		contentPane.add(lbl_address);
		
		lbl_updateengineer = new JLabel("Update Engineer");
		lbl_updateengineer.setForeground(Color.WHITE);
		lbl_updateengineer.setFont(new Font("Cambria Math", Font.BOLD, 55));
		lbl_updateengineer.setBounds(140, 10, 437, 63);
		contentPane.add(lbl_updateengineer);
		
		lbl_applianceid = new JLabel("Appliance ID");
		lbl_applianceid.setForeground(Color.WHITE);
		lbl_applianceid.setFont(new Font("Cambria Math", Font.BOLD, 23));
		lbl_applianceid.setBounds(102, 223, 135, 34);
		contentPane.add(lbl_applianceid);
		
		txt_applianceid = new JTextField();
		txt_applianceid.setForeground(Color.CYAN);
		txt_applianceid.setOpaque(false);
		txt_applianceid.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_applianceid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_applianceid.setEditable(false);
		txt_applianceid.setBounds(303, 226, 252, 29);
		contentPane.add(txt_applianceid);
		txt_applianceid.setColumns(10);
		
		btn_exit = new JButton("Exit");
		btn_exit.setBackground(Color.YELLOW);
		btn_exit.setOpaque(false);
		btn_exit.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_exit.setForeground(Color.WHITE);
		btn_exit.setFont(new Font("Cambria Math", Font.BOLD, 31));
		btn_exit.setBounds(442, 548, 141, 44);
		btn_exit.addActionListener(this);
		btn_exit.addKeyListener(this);
		contentPane.add(btn_exit);
		
		lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(Color.WHITE, 3, true));
		lbl_border.setBounds(49, 83, 596, 589);
		contentPane.add(lbl_border);
		
		lbl_mainborder = new JLabel("New label");
		lbl_mainborder.setBorder(new LineBorder(Color.WHITE, 3, true));
		lbl_mainborder.setIcon(new ImageIcon(Update_Engineer.class.getResource("/com/images/Update new.jpg")));
		lbl_mainborder.setBounds(0, 0, 778, 733);
		contentPane.add(lbl_mainborder);
		//populateCombo1();
	}

	
	
	
	
	
	public void populateCombo()

	{
		int flag=0;
		try {
			
			String str_read = "select engineerid  from engineerdetails";
			pscourse = con.prepareStatement(str_read);
			rscourse = pscourse.executeQuery();

			while (rscourse.next())		
			{
				flag=1;
			
				String id=rscourse.getString("engineerid");
			
				cmb_engineerid.addItem(id);
			}
			if(flag==0)
			{
				System.out.println("Flag "+flag);
				JOptionPane.showMessageDialog(this, "No Engineer recruited yet");
				
				
			}
			
			
			

		} catch (SQLException se) {
			System.out.println(se);
		} finally {

			if (pscourse != null)
				try {
					pscourse.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (rscourse != null)
				try {
					rscourse.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		

	}
	
	
	
	/*
	 * public void populateCombo1()
	 * 
	 * { int flag=0; try {
	 * 
	 * String str_read = "select applianceid  from appliancedetails"; pscourse =
	 * con.prepareStatement(str_read); rscourse = pscourse.executeQuery();
	 * 
	 * while (rscourse.next()) { flag=1;
	 * 
	 * String id=rscourse.getString("applianceid");
	 * 
	 * cmb_applianceid.addItem(id); } if(flag==0) {
	 * JOptionPane.showMessageDialog(this, "No Appliance added");
	 * 
	 * 
	 * }
	 */
			
			
			

	/*
	 * } catch (SQLException se) { System.out.println(se); } finally {
	 * 
	 * if (pscourse != null) try { pscourse.close(); } catch (SQLException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } if (rscourse != null)
	 * try { rscourse.close(); } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * }
	 */
	
	
	
	
	public void fetchData(String cid)
	{
		
		
		try {
			
			String strsql="select * from engineerdetails where engineerid=?";
			
			ps=con.prepareStatement(strsql);
			ps.setString(1,cid);
			ResultSet rs=	ps.executeQuery();
				if(rs.next())
				{
					
					name=rs.getString("name");
					email=rs.getString("email");
					phone=rs.getString("phone");
					gender=rs.getString("gender");
					address=rs.getString("address");
					applianceid = rs.getString("applianceid");
							
				}
				
						

			
		}
			
		catch(SQLException se)
		{
			
			
			System.out.println(se);
		}
		
		
				
	
	
		
	}
	String status="",cid,cid1;
	
	private JLabel lbl_updateengineer;
	private JLabel lbl_applianceid;
	private JTextField txt_applianceid;
	private JLabel lbl_border;
	private JLabel lbl_mainborder;
	
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
	
	     
		String cmp =(String)cmb_engineerid.getSelectedItem();
		
		
		  if(ae.getSource()==btn_exit) 
		  { 
			  this.dispose();
		  
		  }
		 
		
		
		
		
		if(ae.getSource()==cmb_engineerid)
		{
			/*if(populateCombo() == 0)
				JOptionPane.showMessageDialog(this, "No Engineer recruited yet");
			
			
			if(populateCombo() == 1)
			{
			*/
			if(cmp.equalsIgnoreCase("Select Engineer Id"))
			{
				txt_email.setText("");
				txt_phone.setText("");
				txt_name.setText("");
				text_area_address.setText("");
				txt_applianceid.setText("");
				//cmb_applianceid.setSelectedIndex(-1);
				
			}
			else
			{
		    cid=(String)cmb_engineerid.getSelectedItem();
		    
			fetchData(cid);
			txt_email.setText(email);
			txt_phone.setText(phone);
			txt_name.setText(name);
			text_area_address.setText(address);
			txt_applianceid.setText(applianceid);
			//cmb_applianceid.setSelectedItem(applianceid);
			}
			}
		
		
		
		

		if(ae.getSource()==btn_update)
		{

				String updated_email   =txt_email.getText();
				String updated_phone   =txt_phone.getText();
				String updated_address =text_area_address.getText(); 
				cid1=(String)cmb_engineerid.getSelectedItem();
				
				if(cid1.equalsIgnoreCase("Select Engineer Id"))
					JOptionPane.showMessageDialog(this, "Please select an Engineer Id", "Error", JOptionPane.ERROR_MESSAGE);
			
			
				else if(updated_email.isEmpty()||updated_phone.isEmpty() || updated_address.isEmpty() )	
					 JOptionPane.showMessageDialog(this, "All fields are required");
					
						
						else
						{
							
						
							
						int status=	update_Engineer_Details(updated_email,updated_phone,updated_address,cid,cid1);
						if(status>0)
						{
							
							JOptionPane.showMessageDialog(this, "Engineer Details Updated", "Successful", JOptionPane.INFORMATION_MESSAGE);
							
							cmb_engineerid.setSelectedIndex(0);
							txt_email.setText("");
							txt_phone.setText("");
							text_area_address.setText("");
							txt_name.setText("");
							//cmb_applianceid.setSelectedIndex(-1);
							
							
						}
							
				
			}
			
			
			
			
				
			}
			}
			
		
		
	
	
	public int update_Engineer_Details(String email,String phone,String address,String id,String id1)
	
	{
		
		int updatestatus=0;
		try {
			
			String strupdate="update engineerdetails set email=?, phone=?, address=? where engineerid=?";
			
			pscourse=con.prepareStatement(strupdate);
			
			pscourse.setString(1, email);
			pscourse.setString(2, phone);
			pscourse.setString(3, address);
			//pscourse.setString(4,id1);
			pscourse.setString(4, id);
			System.out.println(pscourse);
			
		 updatestatus=pscourse.executeUpdate();	
			
		}
		catch(SQLException se)
		{
			
			se.printStackTrace();
		}
		finally {
			
			if(pscourse!=null)
				try {
					pscourse.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	return updatestatus;	
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
	public void keyPressed(KeyEvent ae) 
	{
		int check = ae.getKeyCode();
		if(check==10)
		{

			String cmp =(String)cmb_engineerid.getSelectedItem();
			
			
			  if(ae.getSource()==btn_exit) 
			  { 
				  this.dispose();
			  
			  }
			 
			
			
			
			
			if(ae.getSource()==cmb_engineerid)
			{
				/*if(populateCombo() == 0)
					JOptionPane.showMessageDialog(this, "No Engineer recruited yet");
				
				
				if(populateCombo() == 1)
				{
				*/
				if(cmp.equalsIgnoreCase("Select Engineer Id"))
				{
					txt_email.setText("");
					txt_phone.setText("");
					txt_name.setText("");
					text_area_address.setText("");
					txt_applianceid.setText("");
					//cmb_applianceid.setSelectedIndex(-1);
					
				}
				else
				{
			    cid=(String)cmb_engineerid.getSelectedItem();
			    
				fetchData(cid);
				txt_email.setText(email);
				txt_phone.setText(phone);
				txt_name.setText(name);
				text_area_address.setText(address);
				txt_applianceid.setText(applianceid);
				//cmb_applianceid.setSelectedItem(applianceid);
				}
				}
			
			
			
			

			if(ae.getSource()==btn_update)
			{

					String updated_email   =txt_email.getText();
					String updated_phone   =txt_phone.getText();
					String updated_address =text_area_address.getText(); 
					cid1=(String)cmb_engineerid.getSelectedItem();
					
					if(cid1.equalsIgnoreCase("Select Engineer Id"))
						JOptionPane.showMessageDialog(this, "Please select an Engineer Id", "Error", JOptionPane.ERROR_MESSAGE);
				
				
					else if(updated_email.isEmpty()||updated_phone.isEmpty() || updated_address.isEmpty() )	
						 JOptionPane.showMessageDialog(this, "All fields are required");
						
							
							else
							{
								
							
								
							int status=	update_Engineer_Details(updated_email,updated_phone,updated_address,cid,cid1);
							if(status>0)
							{
								
								JOptionPane.showMessageDialog(this, "Engineer Details Updated", "Successful", JOptionPane.INFORMATION_MESSAGE);
								
								cmb_engineerid.setSelectedIndex(0);
								txt_email.setText("");
								txt_phone.setText("");
								text_area_address.setText("");
								txt_name.setText("");
								//cmb_applianceid.setSelectedIndex(-1);
								
								
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