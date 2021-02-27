package com.ams;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dbconnection.DataBaseConnection;

//import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class Table_View_Customer_Details extends JFrame implements ActionListener,KeyListener
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	
	private Connection con;
	private PreparedStatement psread;
	private ResultSet rsread;
	
	
	DefaultTableModel model = new DefaultTableModel();

	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table_View_Customer_Details frame = new Table_View_Customer_Details();
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
	public Table_View_Customer_Details() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Table_View_Customer_Details.class.getResource("/com/images/ML logo.png")));
		con = DataBaseConnection.connection();
		setUndecorated(true);
		createGui();
		fetchData();
		
	}

	public void createGui()
	{
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(130, 130, 1051, 795);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		scrollPane.setBounds(17, 33, 1024, 695);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btn_exit = new JButton("Exit");
		btn_exit.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		btn_exit.setOpaque(false);
		btn_exit.setBackground(new Color(0, 0, 128));
		btn_exit.setForeground(new Color(0, 0, 128));
		btn_exit.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btn_exit.setBounds(450, 738, 165, 47);
		btn_exit.addActionListener(this);
		btn_exit.addKeyListener(this);
		contentPane.add(btn_exit);
		
		lbl_mainborder = new JLabel("");
		lbl_mainborder.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		lbl_mainborder.setBounds(0, 0, 1051, 795);
		contentPane.add(lbl_mainborder);
	}
	
	String caption;
	private JButton btn_exit;
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
		
		
		
	public void fetchData()
	{
		
		  model.addColumn("Customer ID");
		  model.addColumn("Name");
		  model.addColumn("Email");
		  model.addColumn("Phone");
		  model.addColumn("Address");
		 
		
		
		try {
			
			String str_read = "select * from customerdetails";
			psread = con.prepareStatement(str_read);
			rsread = psread.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rsread));
			
			while(rsread.next())
			{
				
				model.addRow(new Object [] {
						rsread.getString("customerid"),
						rsread.getString("name"),
						rsread.getString("email"),
						rsread.getString("phone"),
						rsread.getString("address"),
					
						
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