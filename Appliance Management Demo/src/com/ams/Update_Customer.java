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
public class Update_Customer extends JFrame  implements ActionListener,WindowListener,KeyListener
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_email;
	private JTextField txt_phone;
	private JTextArea text_area_address;

	private Connection  con;
	private JComboBox<String> cmb_customerid;
	
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
					Update_Customer frame = new Update_Customer();
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
	public Update_Customer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Update_Customer.class.getResource("/com/images/ML logo.png")));
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
		txt_name.setBounds(313, 197, 259, 29);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setForeground(Color.WHITE);
		txt_email.setOpaque(false);
		txt_email.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_email.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_email.setBounds(313, 268, 259, 29);
		contentPane.add(txt_email);
		txt_email.setColumns(20);
		
		txt_phone = new JTextField();
		txt_phone.setCaretColor(Color.WHITE);
		txt_phone.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_phone.setForeground(Color.WHITE);
		txt_phone.setOpaque(false);
		txt_phone.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_phone.setBounds(313, 435, 259, 29);
		contentPane.add(txt_phone);
		txt_phone.setColumns(10);
		
		 btn_update = new JButton("Update");
		 btn_update.setBackground(Color.PINK);
		 btn_update.setBorder(new LineBorder(Color.WHITE, 1, true));
		 btn_update.setForeground(Color.WHITE);
		 btn_update.setOpaque(false);
		 btn_update.setFont(new Font("Cambria Math", Font.BOLD, 33));
		btn_update.setBounds(252, 513, 147, 46);
		btn_update.addActionListener(this);
		btn_update.addKeyListener(this);
		contentPane.add(btn_update);
		
		cmb_customerid = new JComboBox<String>();
		cmb_customerid.setOpaque(false);
		cmb_customerid.setForeground(new Color(0, 0, 128));
		cmb_customerid.setBorder(new LineBorder(Color.WHITE, 1, true));
		cmb_customerid.setFont(new Font("Cambria Math", Font.PLAIN, 22));
		cmb_customerid.addActionListener(this);
		cmb_customerid.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Customer ID"}));
		populateCombo();
		cmb_customerid.setBounds(313, 127, 259, 29);
		contentPane.add(cmb_customerid);
		
		JLabel lbl_customerid = new JLabel("Customer ID");
		lbl_customerid.setForeground(Color.WHITE);
		lbl_customerid.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lbl_customerid.setBounds(102, 127, 155, 29);
		contentPane.add(lbl_customerid);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setForeground(Color.WHITE);
		lbl_name.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_name.setBounds(102, 197, 137, 24);
		contentPane.add(lbl_name);
		
		JLabel lbl_email = new JLabel("Email ID");
		lbl_email.setForeground(Color.WHITE);
		lbl_email.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_email.setBounds(102, 268, 137, 24);
		contentPane.add(lbl_email);
		
		JLabel lbl_phone = new JLabel("Phone No");
		lbl_phone.setForeground(Color.WHITE);
		lbl_phone.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_phone.setBounds(102, 435, 137, 24);
		contentPane.add(lbl_phone);
		
		text_area_address = new JTextArea();
		text_area_address.setBorder(new LineBorder(Color.WHITE, 1, true));
		text_area_address.setForeground(Color.WHITE);
		text_area_address.setOpaque(false);
		text_area_address.setFont(new Font("Cambria Math", Font.BOLD, 22));
		text_area_address.setBounds(313, 334, 259, 76);
		contentPane.add(text_area_address);
		
		JLabel lbl_address = new JLabel("Address");
		lbl_address.setForeground(Color.WHITE);
		lbl_address.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_address.setBounds(102, 353, 109, 39);
		contentPane.add(lbl_address);
		
		lbl_updatecustomer = new JLabel("Update Customer");
		lbl_updatecustomer.setForeground(Color.WHITE);
		lbl_updatecustomer.setFont(new Font("Cambria Math", Font.BOLD, 54));
		lbl_updatecustomer.setBounds(149, 10, 458, 72);
		contentPane.add(lbl_updatecustomer);
		
		btn_exit = new JButton("Exit");
		btn_exit.setOpaque(false);
		btn_exit.setForeground(Color.WHITE);
		btn_exit.setBackground(Color.PINK);
		btn_exit.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btn_exit.setFont(new Font("Cambria Math", Font.BOLD, 33));
		btn_exit.setBounds(452, 513, 147, 46);
		btn_exit.addActionListener(this);
		btn_exit.addKeyListener(this);
		contentPane.add(btn_exit);
		
		lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(Color.WHITE, 3, true));
		lbl_border.setBounds(49, 92, 617, 518);
		contentPane.add(lbl_border);
		
		lbl_mainborder = new JLabel("");
		lbl_mainborder.setBorder(new LineBorder(Color.WHITE, 3, true));
		lbl_mainborder.setIcon(new ImageIcon(Update_Customer.class.getResource("/com/images/Update new.jpg")));
		lbl_mainborder.setBounds(0, 0, 776, 729);
		contentPane.add(lbl_mainborder);
	}

	
	
	
	
	
	public void populateCombo()

	{
		int flag=0;
		try {
			
			String str_read = "select customerid  from customerdetails";
			pscourse = con.prepareStatement(str_read);
			rscourse = pscourse.executeQuery();

			while (rscourse.next())		
			{
				flag=1;
			
				String id=rscourse.getString("customerid");
			
				cmb_customerid.addItem(id);
			}
			if(flag==0)
			{
				JOptionPane.showMessageDialog(this, "No client associated yet");
				
				
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
			
			String strsql="select * from customerdetails where customerid=?";
			
			ps=con.prepareStatement(strsql);
			ps.setString(1,cid);
			ResultSet rs=	ps.executeQuery();
				if(rs.next())
				{
					
					name=rs.getString("name");
					email=rs.getString("email");
					phone=rs.getString("phone");
					address=rs.getString("address");
							
				}
				
						

			
		}
			
		catch(SQLException se)
		{
			
			
			System.out.println(se);
		}
		
		
				
	
	
		
	}
	String status="",cid;
	//Object source;
	private JLabel lbl_updatecustomer;
	private JButton btn_exit;
	private JLabel lbl_border;
	private JLabel lbl_mainborder;
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
	
	      //source = ae.getSource();
		String cmp =(String)cmb_customerid.getSelectedItem();
		
		if(ae.getSource() == btn_exit)
		{
			
			this.dispose();
		}
		
		
		if(ae.getSource()==cmb_customerid)
		{
			
			if(cmp .equalsIgnoreCase("Select Customer Id"))
			{
				txt_email.setText("");
				txt_phone.setText("");
				txt_name.setText("");
				text_area_address.setText("");
				
			}
			else
			{
		    cid=(String)cmb_customerid.getSelectedItem();
			fetchData(cid);
			txt_email.setText(email);
			txt_phone.setText(phone);
			txt_name.setText(name);
			text_area_address.setText(address);
			}
		}
		
		
		

		if(ae.getSource()==btn_update)
		{
			
			{
				
				cid=(String)cmb_customerid.getSelectedItem();
				String updated_email   =txt_email.getText();
				String updated_phone   =txt_phone.getText();
				String updated_address =text_area_address.getText(); 
			
			         if(cid.equalsIgnoreCase("Select Customer Id"))
			        	 JOptionPane.showMessageDialog(this, "Please Select any Customer ID");
				
				
			         else if(updated_email.isEmpty()||updated_phone.isEmpty()|| updated_address.isEmpty())
						{
							
							JOptionPane.showMessageDialog(this, "All fields are required");
						}
						
						else
						{
							
						
							
						int status=	update_Customer_Details(updated_email,updated_phone,updated_address,cid);
						if(status>0)
						{
							
							JOptionPane.showMessageDialog(this, "Customer Details Updated", "Successful", JOptionPane.INFORMATION_MESSAGE);
							
							cmb_customerid.setSelectedIndex(0);
							txt_email.setText("");
							txt_phone.setText("");
							text_area_address.setText("");
							txt_name.setText("");
							
							
						}
							
				
			}
			
			
			
			
				
			}
			}
			}
		
		
	
	
	public int update_Customer_Details(String email,String phone,String address,String id)
	
	{
		
		int updatestatus=0;
		try {
			
			String strupdate="update customerdetails set email=?, phone=?, address=? where customerid=?";
			
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
			String cmp =(String)cmb_customerid.getSelectedItem();
			
			if(ae.getSource() == btn_exit)
			{
				
				this.dispose();
			}
			
			
			if(ae.getSource()==cmb_customerid)
			{
				
				if(cmp .equalsIgnoreCase("Select Customer Id"))
				{
					txt_email.setText("");
					txt_phone.setText("");
					txt_name.setText("");
					text_area_address.setText("");
					
				}
				else
				{
			    cid=(String)cmb_customerid.getSelectedItem();
				fetchData(cid);
				txt_email.setText(email);
				txt_phone.setText(phone);
				txt_name.setText(name);
				text_area_address.setText(address);
				}
			}
			
			
			

			if(ae.getSource()==btn_update)
			{
				
				{
					
					cid=(String)cmb_customerid.getSelectedItem();
					String updated_email   =txt_email.getText();
					String updated_phone   =txt_phone.getText();
					String updated_address =text_area_address.getText(); 
				
				         if(cid.equalsIgnoreCase("Select Customer Id"))
				        	 JOptionPane.showMessageDialog(this, "Please Select any Customer ID");
					
					
				         else if(updated_email.isEmpty()||updated_phone.isEmpty()|| updated_address.isEmpty())
							{
								
								JOptionPane.showMessageDialog(this, "All fields are required");
							}
							
							else
							{
								
							
								
							int status=	update_Customer_Details(updated_email,updated_phone,updated_address,cid);
							if(status>0)
							{
								
								JOptionPane.showMessageDialog(this, "Customer Details Updated", "Successful", JOptionPane.INFORMATION_MESSAGE);
								
								cmb_customerid.setSelectedIndex(0);
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