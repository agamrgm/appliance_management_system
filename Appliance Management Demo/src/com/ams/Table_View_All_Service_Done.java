package com.ams;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dbconnection.DataBaseConnection;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class Table_View_All_Service_Done extends JFrame implements ActionListener,KeyListener 
{

	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btn_exit;
	
	
	private Connection con;
	private PreparedStatement psread;
	private ResultSet rsread;
	
	
	DefaultTableModel model = new DefaultTableModel();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table_View_All_Service_Done frame = new Table_View_All_Service_Done();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Table_View_All_Service_Done() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Table_View_All_Service_Done.class.getResource("/com/images/ML logo.png")));
		con = DataBaseConnection.connection();
		setUndecorated(true);
		createGui();
		fetchData();
		
		
	}
	
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1051, 795);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		scrollPane.setBounds(23, 38, 1004, 655);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btn_exit = new JButton("Exit");
		btn_exit.setOpaque(false);
		btn_exit.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		btn_exit.setBackground(new Color(0, 0, 128));
		btn_exit.setForeground(new Color(0, 0, 128));
		btn_exit.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btn_exit.setBounds(411, 703, 144, 52);
		btn_exit.addActionListener(this);
		btn_exit.addKeyListener(this);
		contentPane.add(btn_exit);
		
		lbl_mainborder = new JLabel("");
		lbl_mainborder.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		lbl_mainborder.setBounds(0, 0, 1051, 795);
		contentPane.add(lbl_mainborder);
		
		
		
	}
	
	
	public void fetchData()
	{
		  model.addColumn("Request ID");
		  model.addColumn("Customer ID");
		  model.addColumn("Appliance Model No.");
		  model.addColumn("Company Name");
		  model.addColumn("In Date");
		  model.addColumn("Out Date");
		  model.addColumn("Total Amount");
		  
		 
		
		
		try {
			
			String str_read = "select * from servicerequest where servicestatus=?";
			psread = con.prepareStatement(str_read);
			psread.setString(1,"Done");
			rsread = psread.executeQuery();
			
			
			while(rsread.next())
			{
				
				model.addRow(new Object [] {
						rsread.getString("requestid"),
						rsread.getString("customerid"),
						rsread.getString("appliancemodelno"),
						rsread.getString("companyname"),
						rsread.getString("indate"),
						rsread.getString("outdate"),
						rsread.getString("totalamount"),
						
					
						
				});
				
				
				
				}
			table.setModel(model);

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
String caption;
private JLabel lbl_mainborder;

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		
   caption = ae.getActionCommand();
		
		
		if(caption.contentEquals("Exit"))
		{
			this.dispose();
			
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
		
		if(ae.getSource()==btn_exit)
		{
			this.dispose();
			
		}
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}