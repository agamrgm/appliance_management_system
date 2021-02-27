 package com.ams;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Delete_Appliance extends JFrame implements ActionListener,KeyListener,WindowListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_name;
	private JButton btn_delete;
	private JComboBox<String> cmb_applianceid;
	private Connection  con;
	private PreparedStatement ps,pscourse;
	private ResultSet rscourse;
	private PreparedStatement psread;
	private ResultSet rsread;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_Appliance frame = new Delete_Appliance();
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
	public Delete_Appliance()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Delete_Appliance.class.getResource("/com/images/ML logo.png")));
		con=DataBaseConnection.connection();
		this.addWindowListener(this);
		setUndecorated(true);
		createGui();
		populateCombo();
		
		
	}
	
	
	public void createGui()
	{
		setTitle("Delete Appliance");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 811, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_deleteappliance = new JLabel("Delete Appliance");
		lbl_deleteappliance.setForeground(Color.WHITE);
		lbl_deleteappliance.setFont(new Font("Cambria Math", Font.BOLD, 55));
		lbl_deleteappliance.setBounds(190, 20, 493, 77);
		contentPane.add(lbl_deleteappliance);
		
		JLabel lbl_applianceid = new JLabel("Appliance ID");
		lbl_applianceid.setForeground(Color.WHITE);
		lbl_applianceid.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_applianceid.setBounds(190, 135, 158, 35);
		contentPane.add(lbl_applianceid);
		
		cmb_applianceid = new JComboBox<String>();
		cmb_applianceid.setBorder(new LineBorder(Color.WHITE, 1, true));
		cmb_applianceid.setForeground(new Color(0, 0, 128));
		cmb_applianceid.setOpaque(false);
		cmb_applianceid.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Appliance"}));
		cmb_applianceid.setFont(new Font("Cambria Math", Font.BOLD, 22));
		//populateCombo();
		cmb_applianceid.setBounds(416, 141, 235, 29);
		cmb_applianceid.addActionListener(this);
		contentPane.add(cmb_applianceid);
		
		JLabel lbl_name = new JLabel("Appliance Name");
		lbl_name.setForeground(Color.WHITE);
		lbl_name.setFont(new Font("Cambria Math", Font.BOLD, 24));
		lbl_name.setBounds(190, 223, 193, 29);
		contentPane.add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setBorder(new LineBorder(Color.WHITE, 1, true));
		txt_name.setForeground(Color.WHITE);
		txt_name.setOpaque(false);
		txt_name.setFont(new Font("Cambria Math", Font.BOLD, 22));
		txt_name.setEditable(false);
		txt_name.setBounds(420, 223, 231, 29);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		btn_delete = new JButton("Delete");
		btn_delete.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_delete.setBackground(Color.PINK);
		btn_delete.setForeground(Color.WHITE);
		btn_delete.setOpaque(false);
		btn_delete.setFont(new Font("Cambria Math", Font.BOLD, 24));
		btn_delete.setBounds(285, 312, 121, 41);
		btn_delete.addActionListener(this);
		btn_delete.addKeyListener(this);
		contentPane.add(btn_delete);
		
		btn_exit = new JButton("Exit");
		btn_exit.setBackground(Color.PINK);
		btn_exit.setBorder(new LineBorder(Color.WHITE, 1, true));
		btn_exit.setForeground(Color.WHITE);
		btn_exit.setOpaque(false);
		btn_exit.setFont(new Font("Cambria", Font.BOLD, 24));
		btn_exit.setBounds(458, 312, 121, 41);
		btn_exit.addActionListener(this);
		btn_exit.addKeyListener(this);
		contentPane.add(btn_exit);
		
		lbl_border = new JLabel("");
		lbl_border.setBorder(new LineBorder(Color.WHITE, 2, true));
		lbl_border.setBounds(108, 107, 635, 307);
		contentPane.add(lbl_border);
		
		lbl_mainborder = new JLabel("");
		lbl_mainborder.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		lbl_mainborder.setIcon(new ImageIcon(Delete_Appliance.class.getResource("/com/images/Delete.jpg")));
		lbl_mainborder.setBounds(0, 0, 811, 502);
		contentPane.add(lbl_mainborder);
		
		
		
	}
	
	
	
	public void populateCombo()
	{
		int flag=0;
		try {
			
			String str_read = "select applianceid  from appliancedetails";
			pscourse = con.prepareStatement(str_read);
			rscourse = pscourse.executeQuery();

			while (rscourse.next())		
			{
				flag=1;
			
				String id=rscourse.getString("applianceid");
			
				cmb_applianceid.addItem(id);
			}
			if(flag==0)
			{
				JOptionPane.showMessageDialog(this, "No Appliance registered yet");
				
				
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
			
			String strsql="select * from appliancedetails where applianceid=?";
			
			ps=con.prepareStatement(strsql);
			ps.setString(1,cid);
			ResultSet rs=	ps.executeQuery();
				if(rs.next())
				{
					name=rs.getString("name");
					
							
				}
					

			
		}
			
		catch(SQLException se)
		{
			
			
			System.out.println(se);
		}
		
		
				
	
	
		
	}

	
	String cid,name;
	private JButton btn_exit;
	private JLabel lbl_border;
	private JLabel lbl_mainborder;
	
	@Override
	public void actionPerformed(ActionEvent ae) 
     {
		
	      
		String cmp =(String)cmb_applianceid.getSelectedItem();
		
		if(ae.getSource()==cmb_applianceid)
		{
			
			if(cmp.equalsIgnoreCase("Select"))
			{
				
				txt_name.setText("");
				
			}
			
			else
			{
		    cid=(String)cmb_applianceid.getSelectedItem();
			fetchData(cid);
			txt_name.setText(name);
			
			}
		}
		
		if(ae.getSource() == btn_exit)
		{
			
			this.dispose();
			Listener.windowClosing(con);
			
		}
		
		
		

		if(ae.getSource()== btn_delete)
		{
			
			if(txt_name.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Please select an Appliance", "Error", JOptionPane.ERROR_MESSAGE);
				txt_name.setText("");
				
				
			}
			
			else
			{
				
				deleteDetails();
				
			}
		  }
		}
			
			
		public void deleteDetails()
		{
			int selection =	JOptionPane.showConfirmDialog(this, "It will delete the appliance and assocaited engineer with it" , "Confirmation",JOptionPane.WARNING_MESSAGE);
			
			if(selection  == 0)
			{
				String str_delete="delete from appliancedetails where applianceid=?";
				try {
					
					psread=con.prepareStatement(str_delete);
					psread.setString(1,cid);
					int status=	psread.executeUpdate();
					
					if(status > 0)
					{
					   JOptionPane.showMessageDialog(this, "Appliance Deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
					   this.dispose(); 
					   
						
						
						
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
				String cmp =(String)cmb_applianceid.getSelectedItem();
				
				if(ae.getSource()==cmb_applianceid)
				{
					
					if(cmp.equalsIgnoreCase("Select"))
					{
						
						txt_name.setText("");
						
					}
					
					else
					{
				    cid=(String)cmb_applianceid.getSelectedItem();
					fetchData(cid);
					txt_name.setText(name);
					
					}
				}
				
				if(ae.getSource() == btn_exit)
				{
					
					this.dispose();
					Listener.windowClosing(con);
					
				}
				
				
				

				if(ae.getSource()== btn_delete)
				{
					
					if(txt_name.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(this,"Please select an Appliance", "Error", JOptionPane.ERROR_MESSAGE);
						txt_name.setText("");
						
						
					}
					
					else
					{
						
						deleteDetails();
						
					}
				  }
				}
					
					
				}
		
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}