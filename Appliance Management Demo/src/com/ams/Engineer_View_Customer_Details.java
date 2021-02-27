package com.ams;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dbconnection.DataBaseConnection;
//import com.sun.media.sound.ModelAbstractChannelMixer;

import net.proteanit.sql.DbUtils;

//import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JScrollPane;
//import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class Engineer_View_Customer_Details extends JFrame implements ActionListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
    private JButton btn_exit;
    private JScrollPane scrollPane ;
    
    private Connection con;
	private PreparedStatement ps,psread;
	private ResultSet rs,rsread;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Engineer_View_Customer_Details frame = new Engineer_View_Customer_Details();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	DefaultTableModel model = new DefaultTableModel();
	

	
	
	
	
	
	
	public Engineer_View_Customer_Details() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Engineer_View_Customer_Details.class.getResource("/com/images/ML logo.png")));
		
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
		
		
		
		  
		  btn_exit = new JButton("Exit"); 
		  btn_exit.setOpaque(false);
		  btn_exit.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		  btn_exit.setBackground(new Color(0, 0, 128));
		  btn_exit.setForeground(new Color(0, 0, 128));btn_exit.setFont(new Font("Cambria Math", Font.BOLD, 30)); btn_exit.setBounds(716, 26, 148, 48);
		  btn_exit.addActionListener(this); 
		  btn_exit.addKeyListener(this);
		  contentPane.add(btn_exit);
		 
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		scrollPane.setBounds(22, 90, 1001, 673);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		JLabel lbl_requestid = new JLabel("Request ID");
		lbl_requestid.setForeground(new Color(0, 0, 128));
		lbl_requestid.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_requestid.setBounds(34, 26, 168, 41);
		contentPane.add(lbl_requestid);
		
		cmb_requestid = new JComboBox<String>();
		cmb_requestid.setOpaque(false);
		cmb_requestid.setForeground(new Color(0, 0, 128));
		cmb_requestid.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Request ID"}));
		cmb_requestid.setFont(new Font("Cambria Math", Font.BOLD, 24));
		cmb_requestid.setBounds(212, 26, 267, 48);
		cmb_requestid.addActionListener(this);
		cmb_requestid.addKeyListener(this);
		populateCombo();
		contentPane.add(cmb_requestid);
		
		lbl_mainborder = new JLabel("");
		lbl_mainborder.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		lbl_mainborder.setBounds(0, 0, 1051, 795);
		contentPane.add(lbl_mainborder);
		
	}

	
	  String request_id,cust_id;
	  
	  @Override public void actionPerformed(ActionEvent ae) 
	  { 
		  
		 
	  
	    if(ae.getSource()==btn_exit)
	    {
	    	this.dispose();
	    	
	    }
	  
	  
	 	 if(ae.getSource()==cmb_requestid) 
	 	 {
	 		 String cmp = (String)cmb_requestid.getSelectedItem();
	 		 if(cmp.contentEquals("Select"))
	 		 {
	 			 while(model.getRowCount() > 0)
	 			 model.removeRow(0);
	 			 
	 		 }
	 		 else
	 		 {
	 			 if(fetchDetails(cmp) > 0)
	 			 {
	 				 fetchData();
	 				 
	 			 }
	 			 
	 		 }
	 		 
	 	 }
	  
	  
	  
	  
	  
	  
	  }
	  
	  
	  
	  
	  public void populateCombo()

		{
			int flag=0;
			try {
				
				String str_read = "select * from allotservice where engineerid=?";
				ps = con.prepareStatement(str_read);
				ps.setString(1,Login.userid);
				rs = ps.executeQuery();

				while (rs.next())		
				{
					flag=1;
				
					String id=rs.getString("requestid");
				
					cmb_requestid.addItem(id);
				}
				if(flag==0)
				{
					JOptionPane.showMessageDialog(this, "No request alloted");
					
					
				}
				
				
				

			} catch (SQLException se) {
				System.out.println(se);
			} finally {

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

		}
		
		
		 
		  
		  public int fetchDetails(String rid)
			{
				
				int flag = 0;
				try {
					
					String strsql="select * from servicerequest where requestid=?";
					
					ps=con.prepareStatement(strsql);
					ps.setString(1,rid);
					ResultSet rs=	ps.executeQuery();
						if(rs.next())
						{
							
							cust_id=rs.getString("customerid");
							flag=1;
									
						}
						
								

					
				}
					
				catch(SQLException se)
				{
					
					
					System.out.println(se);
				}
				return flag;
				
				
						
			
			
				
			}
		  
		  
	  
	  
	  
	  String name,email,phone,address;
	  private JComboBox<String> cmb_requestid;
	  private JLabel lbl_mainborder;
		 
	  
	  
	  
	  public void fetchData()
  {
		 // model.addColumn("Name");
		 // model.addColumn("Email");
		 // model.addColumn("Phone");
		 // model.addColumn("Address");
	  
	  
	  try {
			
			String str_read = "select * from customerdetails where customerid=?";
			psread = con.prepareStatement(str_read);
			psread.setString(1,cust_id);
			rsread = psread.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rsread));
			//while(rsread.next())
			//{
				
			//	model.addRow(new Object [] {
				//		rsread.getString("name"),
					//	rsread.getString("email"),
						//rsread.getString("phone"),
						//rsread.getString("address")
						
						
			//});}
				
				
				
				
			//table.setModel(model);

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
	  
	  
	 	 if(ae.getSource()==cmb_requestid) 
	 	 {
	 		 String cmp = (String)cmb_requestid.getSelectedItem();
	 		 if(cmp.contentEquals("Select"))
	 		 {
	 			 while(model.getRowCount() > 0)
	 			 model.removeRow(0);
	 			 
	 		 }
	 		 else
	 		 {
	 			 if(fetchDetails(cmp) > 0)
	 			 {
	 				 fetchData();
	 				 
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