package com.ams;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.util.Date;

//import javax.swing.JTextField;
//import javax.swing.JComboBox;
//import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
//import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Allot_Service_Request extends JFrame implements ActionListener,WindowListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btn_exit,btn_done;
	
	private Connection  con;
    private PreparedStatement ps,pscourse;
	private ResultSet rscourse;
	int chk = 0;
	private JTextField txt_engineerid;
	private JTextField txt_requestid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Allot_Service_Request frame = new Allot_Service_Request();
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
	public Allot_Service_Request() 
	{
		con=DataBaseConnection.connection();
		setUndecorated(true);
		createGui();
		
	}
	
	public void createGui()
	{
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 769, 536);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_engineerid = new JLabel("Engineer ID");
		lbl_engineerid.setForeground(new Color(0, 0, 128));
		lbl_engineerid.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_engineerid.setBounds(125, 136, 151, 36);
		contentPane.add(lbl_engineerid);
		
		JLabel lbl_requestid = new JLabel("Request ID");
		lbl_requestid.setForeground(new Color(0, 0, 128));
		lbl_requestid.setFont(new Font("Cambria Math", Font.BOLD, 26));
		lbl_requestid.setBounds(125, 223, 151, 36);
		contentPane.add(lbl_requestid);
		
		btn_done = new JButton("Done");
		btn_done.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		btn_done.setBackground(new Color(128, 128, 0));
		btn_done.setOpaque(false);
		btn_done.setForeground(new Color(0, 0, 128));
		btn_done.setFont(new Font("Cambria Math", Font.BOLD, 28));
		btn_done.setBounds(264, 344, 122, 42);
		btn_done.addActionListener(this);
		contentPane.add(btn_done);
		
		btn_exit = new JButton("Exit");
		btn_exit.setOpaque(false);
		btn_exit.setForeground(new Color(0, 0, 128));
		btn_exit.setBackground(new Color(128, 128, 0));
		btn_exit.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		btn_exit.setFont(new Font("Cambria Math", Font.BOLD, 28));
		btn_exit.setBounds(464, 344, 111, 42);
		btn_exit.addActionListener(this);
		contentPane.add(btn_exit);
		
		txt_engineerid = new JTextField();
		txt_engineerid.setForeground(new Color(0, 0, 128));
		txt_engineerid.setOpaque(false);
		txt_engineerid.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_engineerid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_engineerid.setBounds(345, 136, 230, 36);
		contentPane.add(txt_engineerid);
		txt_engineerid.setColumns(10);
		
		txt_requestid = new JTextField();
		txt_requestid.setForeground(new Color(0, 0, 128));
		txt_requestid.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		txt_requestid.setOpaque(false);
		txt_requestid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_requestid.setColumns(10);
		txt_requestid.setBounds(345, 223, 230, 36);
		contentPane.add(txt_requestid);
		
		JLabel lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		lbl_border.setBounds(91, 102, 547, 345);
		contentPane.add(lbl_border);
		
		JLabel lblNewLabel = new JLabel("Allot Service Request");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 54));
		lblNewLabel.setBounds(91, 10, 547, 82);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_mainborder = new JLabel("New label");
		lbl_mainborder.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		lbl_mainborder.setIcon(new ImageIcon(Allot_Service_Request.class.getResource("/com/images/Add_Supervisor.jpg")));
		lbl_mainborder.setBounds(0, 0, 769, 536);
		contentPane.add(lbl_mainborder);
	}

	
	String engineerid,requestid;
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==btn_exit)
		{
			this.dispose();
			
		}
		
		if(ae.getSource()==btn_done)
		{
			fetchData();
			if(!checkEmpty())
			{
				if(checkEngineerId())
				{
					if(checkRequestId())
					{
						
					if(checkApplianceWithEngineer())
					{
						if(checkEngineerIsFree() < 5)
						{
							allotDetails();
							if(updateAssignedStatus() > 0)
							{
								System.out.println("Updated");
							}
							
						}
						else
						{
							
							JOptionPane.showMessageDialog(this, "The Engineer is not free", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(this, "This Request Id doesn't belong to this Engineer", "Error", JOptionPane.ERROR_MESSAGE);
						
					}
				}
				else
				{
					
					JOptionPane.showMessageDialog(this, "No such Request Id exist", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
				
				
				else
				{
					
					JOptionPane.showMessageDialog(this, "No such EngineerId exist", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
			
			
			
		}
		
		
	
	
	
	public void fetchData()
	{
		engineerid=txt_engineerid.getText();
		requestid=txt_requestid.getText();
		
	}
	
	public boolean checkEmpty()
{
		
		if(engineerid.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Enter an engineer id ", "Error", JOptionPane.ERROR_MESSAGE);
		  return true;
		}
		
		if(requestid.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Enter a request id ", "Error", JOptionPane.ERROR_MESSAGE);
		  return true;
		}
		
		
		return false;
	}
	
	
	public boolean checkEngineerId()
	{
		 	  try 
				  {
					  
					  String str_read = "select * from engineerdetails where engineerid=?";
					  ps = con.prepareStatement(str_read);
					  ps.setString(1, engineerid);
					  rscourse = ps.executeQuery();
					  
					 while(rscourse.next())
					  {
						  return true;
						 
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
					  if(ps!= null)
						try {
							ps.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  if(rscourse!= null)
						try {
							rscourse.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					  
				  }
				return false;
				  
				
			}
		
	
	
	public boolean checkRequestId()
	{
		 	  try 
				  {
					  
					  String str_read = "select * from servicerequest where requestid=?";
					  ps = con.prepareStatement(str_read);
					  ps.setString(1, requestid);
					  rscourse = ps.executeQuery();
					  
					 while(rscourse.next())
					  {
						  return true;
						 
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
					  if(ps!= null)
						try {
							ps.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  if(rscourse!= null)
						try {
							rscourse.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					  
				  }
				return false;
				  
				
			}
		
	
	
	
	
	
	
	
	
	String Applianceid;
	
	public void findApplianceId()
	{
		String strcheck = "select applianceid from engineerdetails where engineerid=?";
		  
		  try {
			pscourse = con.prepareStatement(strcheck);
			
			String engineerid = txt_engineerid.getText();
			
			pscourse.setString(1,engineerid);
			
			rscourse = pscourse.executeQuery();
			
			while(rscourse.next())
			{
				
				Applianceid = rscourse.getString("applianceid");
				
			  
			  
			}
		  
			
			} 
		  
		  catch (SQLException e)
		  
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		 finally
		  {
			  if(pscourse!= null)
				try {
					pscourse.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  if(rscourse!= null)
				try {
					rscourse.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			  
		  }  
		 
	
}
	
	
	public boolean checkApplianceWithEngineer()
	{
		findApplianceId();
		String strcheck = "select applianceid from servicerequest where requestid=?";
		  
		  try {
			pscourse = con.prepareStatement(strcheck);
			
			String requestid = txt_requestid.getText();
			
			pscourse.setString(1,requestid);
			
			rscourse = pscourse.executeQuery();
			
			while(rscourse.next())
			{
				
				String applianceid = rscourse.getString("applianceid");
				
				if(Applianceid.equals(applianceid))
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
			  if(pscourse!= null)
				try {
					pscourse.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  if(rscourse!= null)
				try {
					rscourse.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			  
		  }  
		 
	
		return false;
		
	}
	
	
	
	
	
	
	
	 public int checkEngineerIsFree()
		{
		 int flag = 0;	 
			  try 
			  {
				  
				  String str_read = "select * from allotservice where engineerid=?";
				  ps = con.prepareStatement(str_read);
				  ps.setString(1, engineerid);
				  rscourse = ps.executeQuery();
				  
				 while(rscourse.next())
				  {
					  flag++;
					 
				 }
				 
				 return flag;
				 
			
				 
			
			  } 
			  
			  catch (SQLException e) 
			  
			  {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			  finally
			  {
				  if(ps!= null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  if(rscourse!= null)
					try {
						rscourse.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				  
			  }
			return flag;
			  
			
		}
	 
	 public void allotDetails() 
	 {
		 fetchDate();
		   String strinsert = "insert into allotservice(engineerid,requestid,date) values(?,?,?)";
		   try {
			
			   ps = con.prepareStatement(strinsert);
			   ps.setString(1, engineerid);
			   ps.setString(2, requestid);
			   java.sql.Date sql_out_date=new java.sql.Date(outdate.getTime());
			   ps.setDate(3, sql_out_date);
			  
			   
			   
			   int status = ps.executeUpdate();
			
			   if(status > 0 )
			   {
				   JOptionPane.showMessageDialog(this, "Service alloted successfully", "Submitted", JOptionPane.INFORMATION_MESSAGE);
				   txt_engineerid.setText("");
				   txt_requestid.setText("");
				  
			
				    
					
				   
				   
			   }
			   
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally
		 {
			 if(ps!= null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
			 
			  }
		  
		  
		  }
	Date outdate,indate;
	 
	 public void fetchDate()
		{
		    	 
			  try 
			  {
				  
				  String str_read = "select * from servicerequest where requestid=?";
				  ps = con.prepareStatement(str_read);
				  ps.setString(1, requestid);
				  rscourse = ps.executeQuery();
				  int flag = 0;
				 while(rscourse.next())
				  {
					  
					  String Requestid =rscourse.getString("requestid");
					  if(Requestid.equals(requestid))
					  {
						flag = 1; 
						break;
					  }
					  
				}
				 
				 if(flag == 1)
				 {
				        outdate=rscourse.getDate("outdate");
				        indate=rscourse.getDate("indate");
				  
			
				  }
			  }
				 
			  
			  catch (SQLException e) 
			  
			  {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			  finally
			  {
				  if(ps!= null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  if(rscourse!= null)
					try {
						rscourse.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				  
			  }
			  
			}
		
	
	 public int updateAssignedStatus()
		{
			
			int updatestatus=0;
			try {
				
				String strupdate="update servicerequest set assignedstatus=? where requestid=?";
				
				pscourse=con.prepareStatement(strupdate);
				
				pscourse.setString(1,"Done");
				
				pscourse.setString(2,requestid);

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
			
			if(ae.getSource()==btn_done)
			{
				fetchData();
				if(!checkEmpty())
				{
					if(checkEngineerId())
					{
						if(checkRequestId())
						{
							
						if(checkApplianceWithEngineer())
						{
							if(checkEngineerIsFree() < 5)
							{
								allotDetails();
								if(updateAssignedStatus() > 0)
								{
									System.out.println("Updated");
								}
								
							}
							else
							{
								
								JOptionPane.showMessageDialog(this, "The Engineer is not free", "Error", JOptionPane.ERROR_MESSAGE);
							}
							
						}
						else
						{
							JOptionPane.showMessageDialog(this, "This Request Id doesn't belong to this Engineer", "Error", JOptionPane.ERROR_MESSAGE);
							
						}
					}
					else
					{
						
						JOptionPane.showMessageDialog(this, "No such Request Id exist", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
					
					
					else
					{
						
						JOptionPane.showMessageDialog(this, "No such EngineerId exist", "Error", JOptionPane.ERROR_MESSAGE);
					}
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