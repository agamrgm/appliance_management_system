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
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
public class Update_Supervisor extends JFrame  implements ActionListener,WindowListener,KeyListener
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_email;
	private JTextField txt_phone;
	private JTextArea text_area_address;

	private Connection  con;
	private JComboBox<String> cmb_supervisorid;
	
	private PreparedStatement ps,pscourse;
	private ResultSet rscourse;
	
	

	
	String name,gender,address,email,phone;
	private JButton btn_update;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Supervisor frame = new Update_Supervisor();
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
	public Update_Supervisor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Update_Supervisor.class.getResource("/com/images/ML logo.png")));
		con=DataBaseConnection.connection();
		setUndecorated(true);
		this.addWindowListener(this);
		createGui();
		
	}
	
	
	public void createGui()
	{
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 778, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		txt_name = new JTextField();
		txt_name.setOpaque(false);
		txt_name.setForeground(Color.WHITE);
		txt_name.setBorder(new LineBorder(new Color(70, 130, 180), 2, true));
		txt_name.setEditable(false);
		txt_name.setFont(new Font("Cambria Math", Font.BOLD, 22));
		//txtid.addFocusListener(this);
		txt_name.setBounds(300, 223, 276, 35);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setForeground(Color.WHITE);
		txt_email.setBorder(new LineBorder(new Color(70, 130, 180), 2, true));
		txt_email.setOpaque(false);
		txt_email.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_email.setBounds(300, 291, 276, 35);
		contentPane.add(txt_email);
		txt_email.setColumns(20);
		
		txt_phone = new JTextField();
		txt_phone.setForeground(Color.WHITE);
		txt_phone.setBorder(new LineBorder(new Color(70, 130, 180), 2, true));
		txt_phone.setOpaque(false);
		txt_phone.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_phone.setBounds(300, 368, 276, 36);
		contentPane.add(txt_phone);
		txt_phone.setColumns(10);
		
		 btn_update = new JButton("Update");
		 btn_update.setBackground(new Color(0, 0, 255));
		 btn_update.setBorder(new LineBorder(new Color(70, 130, 180), 2, true));
		 btn_update.setOpaque(false);
		 btn_update.setForeground(Color.WHITE);
		 btn_update.setFont(new Font("Cambria Math", Font.BOLD, 28));
		 btn_update.setBounds(245, 583, 139, 43);
		 btn_update.addKeyListener(this);
		 btn_update.addActionListener(this);
		 contentPane.add(btn_update);
		
		cmb_supervisorid = new JComboBox<String>();
		cmb_supervisorid.setMaximumRowCount(15);
		cmb_supervisorid.setBorder(new LineBorder(new Color(70, 130, 180), 2, true));
		cmb_supervisorid.setOpaque(false);
		cmb_supervisorid.setBackground(Color.LIGHT_GRAY);
		cmb_supervisorid.setForeground(Color.WHITE);
		cmb_supervisorid.setFont(new Font("Cambria Math", Font.BOLD, 21));
		cmb_supervisorid.addActionListener(this);
		cmb_supervisorid.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Supervisor ID"}));
		populateCombo();
		cmb_supervisorid.setBounds(300, 137, 276, 35);
		contentPane.add(cmb_supervisorid);
		
		JLabel lbl_staffid = new JLabel("Supervisor  ID");
		lbl_staffid.setForeground(Color.WHITE);
		lbl_staffid.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_staffid.setBounds(102, 137, 163, 35);
		contentPane.add(lbl_staffid);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setForeground(Color.WHITE);
		lbl_name.setFont(new Font("Cambria Math", Font.BOLD, 28));
		lbl_name.setBounds(102, 223, 163, 35);
		contentPane.add(lbl_name);
		
		JLabel lbl_email = new JLabel("Email ID");
		lbl_email.setForeground(Color.WHITE);
		lbl_email.setFont(new Font("Cambria Math", Font.BOLD, 27));
		lbl_email.setBounds(102, 291, 152, 35);
		contentPane.add(lbl_email);
		
		JLabel lbl_phone = new JLabel("Phone No");
		lbl_phone.setForeground(Color.WHITE);
		lbl_phone.setFont(new Font("Cambria Math", Font.BOLD, 27));
		lbl_phone.setBounds(102, 368, 163, 36);
		contentPane.add(lbl_phone);
		
		text_area_address = new JTextArea();
		text_area_address.setForeground(Color.WHITE);
		text_area_address.setBorder(new LineBorder(new Color(70, 130, 180), 2, true));
		text_area_address.setOpaque(false);
		text_area_address.setFont(new Font("Cambria Math", Font.BOLD, 22));
		text_area_address.setBounds(300, 453, 276, 85);
		contentPane.add(text_area_address);
		
		JLabel lbl_address = new JLabel("Address");
		lbl_address.setForeground(Color.WHITE);
		lbl_address.setFont(new Font("Cambria Math", Font.BOLD, 27));
		lbl_address.setBounds(102, 476, 152, 43);
		contentPane.add(lbl_address);
		
		btn_Exit = new JButton("Exit");
		btn_Exit.setForeground(Color.WHITE);
		btn_Exit.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btn_Exit.addActionListener(this);
		btn_Exit.addActionListener(this);
		btn_Exit.addKeyListener(this);	
		btn_Exit.setBorder(new LineBorder(new Color(70, 130, 180), 2, true));
		btn_Exit.setOpaque(false);
		btn_Exit.setBackground(new Color(0, 0, 128));
		btn_Exit.setBounds(452, 583, 135, 43);
		contentPane.add(btn_Exit);
		
		lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		lbl_border.setBounds(68, 100, 596, 555);
		contentPane.add(lbl_border);
		
		lbl_heading = new JLabel("Update Supervisor");
		lbl_heading.setFont(new Font("Cambria Math", Font.PLAIN, 52));
		lbl_heading.setForeground(Color.WHITE);
		lbl_heading.setBounds(151, 27, 445, 76);
		contentPane.add(lbl_heading);
		
		lbl_mainborder = new JLabel("");
		lbl_mainborder.setBorder(new LineBorder(Color.WHITE, 3, true));
		lbl_mainborder.setIcon(new ImageIcon(Update_Supervisor.class.getResource("/com/images/Update new.jpg")));
		lbl_mainborder.setBounds(0, 0, 778, 729);
		contentPane.add(lbl_mainborder);
	}

	
	
	
	
	
	public void populateCombo()

	{
		int flag=0;
		try {
			
			String str_read = "select supervisorid  from supervisordetails";
			pscourse = con.prepareStatement(str_read);
			rscourse = pscourse.executeQuery();

			while (rscourse.next())		
			{
				flag=1;
			
				String id=rscourse.getString("supervisorid");
			
				cmb_supervisorid.addItem(id);
			}
			if(flag==0)
			{
				JOptionPane.showMessageDialog(this, "No supervisor recruited yet");
				
				
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
	
	
	
	
	public void fetchData(String cid)
	{
		
		
		try {
			
			String strsql="select * from supervisordetails where supervisorid=?";
			
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
							
				}
				
						

			
		}
			
		catch(SQLException se)
		{
			
			
			System.out.println(se);
		}
		
		
				
	
	
		
	}
	String status="",cid;
	Object source;
	private JButton btn_Exit;
	private JLabel lbl_border;
	private JLabel lbl_heading;
	private JLabel lbl_mainborder;
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
	
	      
		
		
		if(ae.getSource()==cmb_supervisorid)
		{
		    cid=(String)cmb_supervisorid.getSelectedItem();
			fetchData(cid);
			txt_email.setText(email);
			txt_phone.setText(phone);
			txt_name.setText(name);
			text_area_address.setText(address);
		}
		
		if(ae.getSource()==btn_Exit)
		{
			this.dispose();
		}

		if(ae.getSource()==btn_update)
		{
			
			{
				
				
				String updated_email   =txt_email.getText();
				String updated_phone   =txt_phone.getText();
				String updated_address =text_area_address.getText(); 
			
			
						if(updated_email.isEmpty()||updated_phone.isEmpty()||cid.equalsIgnoreCase("Select CourseId")|| updated_address.isEmpty())
						
							
						{
							
							JOptionPane.showMessageDialog(this, "All fields are required");
						}
						
						
						else
						{
							
						
							
						int status=	update_Supervisor_Details(updated_email,updated_phone,updated_address,cid);
						if(status>0)
						{
							
							JOptionPane.showMessageDialog(this, "Supervisor Details Updated", "Successful", JOptionPane.INFORMATION_MESSAGE);
							
							cmb_supervisorid.setSelectedIndex(0);
							txt_email.setText("");
							txt_phone.setText("");
							text_area_address.setText("");
							txt_name.setText("");
							
							
						}
							
				
			}
			
			
			
			
				
			}
			}
			}
		
		
	
	
	public int update_Supervisor_Details(String email,String phone,String address,String id)
	
	{
		
		int updatestatus=0;
		try {
			
			String strupdate="update supervisordetails set email=?, phone=?, address=? where supervisorid=?";
			
			pscourse=con.prepareStatement(strupdate);
			
			pscourse.setString(1, email);
			pscourse.setString(2, phone);
			pscourse.setString(3, address);
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

			
			if(ae.getSource()==cmb_supervisorid)
			{
			    cid=(String)cmb_supervisorid.getSelectedItem();
				fetchData(cid);
				txt_email.setText(email);
				txt_phone.setText(phone);
				txt_name.setText(name);
				text_area_address.setText(address);
			}
			
			if(ae.getSource()==btn_Exit)
			{
				this.dispose();
			}

			if(ae.getSource()==btn_update)
			{
				
				{
					
					
					String updated_email   =txt_email.getText();
					String updated_phone   =txt_phone.getText();
					String updated_address =text_area_address.getText(); 
				
				
							if(updated_email.isEmpty()||updated_phone.isEmpty()||cid.equalsIgnoreCase("Select CourseId")|| updated_address.isEmpty())
							
								
							{
								
								JOptionPane.showMessageDialog(this, "All fields are required");
							}
							
							
							else
							{
								
							
								
							int status=	update_Supervisor_Details(updated_email,updated_phone,updated_address,cid);
							if(status>0)
							{
								
								JOptionPane.showMessageDialog(this, "Supervisor Details Updated", "Successful", JOptionPane.INFORMATION_MESSAGE);
								
								cmb_supervisorid.setSelectedIndex(0);
								txt_email.setText("");
								txt_phone.setText("");
								text_area_address.setText("");
								txt_name.setText("");
								
								
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