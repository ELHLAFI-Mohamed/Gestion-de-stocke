import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class insert {

	private JFrame frame1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	

	/**
	 * Initialize the contents of the frame.
	 */
public insert() {
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 1101, 768);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(167, 61, 173, 22);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 109, 173, 22);
		frame1.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(167, 156, 173, 22);
		frame1.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setForeground(Color.WHITE);
		lblId.setBounds(58, 67, 56, 16);
		frame1.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(58, 112, 56, 16);
		frame1.getContentPane().add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("Quantit\u00E9");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(58, 162, 81, 16);
		frame1.getContentPane().add(lblNewLabel_1);
		
		JButton btnInsert = new JButton("Insert");
		table = new JTable();
		table.setBackground(Color.PINK);
		DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Quantite"}, 0);
		table.setBounds(404, 340, 478, 319);
		frame1.getContentPane().add(table);
		model.setRowCount(0);
		 model.addRow(new Object[]{"ID", "NOM", "Quantite"});
		try{  
    		Class.forName("com.mysql.jdbc.Driver");  
    			Connection con=DriverManager.getConnection(  
    			"jdbc:mysql://localhost:3306/stocke?autoReconnect=true&useSSL=false","root","root"); 
    			Statement stmt=con.createStatement();  
	    		ResultSet rs=stmt.executeQuery("select * from produit");
	    		while(rs.next())
	    		{
	    		    String d = rs.getString("id");
	    		    String e = rs.getString("nom");
	    		    String f = rs.getString("quantite");
	    		    model.addRow(new Object[]{d, e, f});
	    		}
	    		table.setModel(model);
	    	   con.close();
		 }catch(Exception e){ System.out.println(e);}
		
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{  model.setRowCount(0);
				  model.addRow(new Object[]{"ID", "NOM", "Quantite"});
		    		Class.forName("com.mysql.jdbc.Driver");  
		    			Connection con=DriverManager.getConnection(  
		    			"jdbc:mysql://localhost:3306/stocke?autoReconnect=true&useSSL=false","root","root"); 
		    			String query="insert into produit values(?,?,?)";
			    		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query) ;
			    		int a=Integer.parseInt(textField.getText());
			    		int b=Integer.parseInt(textField_2.getText());
			    	    ps.setInt(1,a);
			    	    ps.setString(2,textField_1.getText());
			    	    ps.setInt(3, b);
			    	    ps.execute();			    	    
			    	    textField.setText("");
			    	    textField_1.setText("");
			    	    textField_2.setText("");
			    	    Statement stmt=con.createStatement();  
			    		ResultSet rs=stmt.executeQuery("select * from produit");
			    		
			    		while(rs.next())
			    		{
			    		    String d = rs.getString("id");
			    		    String e = rs.getString("nom");
			    		    String f = rs.getString("quantite");
			    		    model.addRow(new Object[]{d, e, f});
			    		}
			    		table.setModel(model);
			    	   con.close();
			    
			    	    
			    	    
			    		
				   }catch(Exception e){ System.out.println(e);}

			    	    
		    			
			}
		});
		btnInsert.setBackground(Color.LIGHT_GRAY);
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInsert.setBounds(243, 206, 97, 25);
		frame1.getContentPane().add(btnInsert);
		
		JButton btnLogout = new JButton("LOGout\r\n");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
				Login x=new Login();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogout.setBackground(Color.LIGHT_GRAY);
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setBounds(699, 108, 162, 25);
		frame1.getContentPane().add(btnLogout);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=Integer.parseInt(textField.getText());
			
				try{  model.setRowCount(0);
				  model.addRow(new Object[]{"ID", "NOM", "Quantite"});
		    		Class.forName("com.mysql.jdbc.Driver");  
		    			Connection con=DriverManager.getConnection(  
		    			"jdbc:mysql://localhost:3306/stocke?autoReconnect=true&useSSL=false","root","root"); 
		    			Statement stmt=con.createStatement();  
			    		stmt.executeUpdate("delete from produit where id="+i);
			    		textField.setText("");
			    		model.setRowCount(0);
			    		 model.addRow(new Object[]{"ID", "NOM", "Quantite"});
			    		ResultSet rs1=stmt.executeQuery("select * from produit");
			    		while(rs1.next())
			    		{
			    		    String d = rs1.getString("id");
			    		    String v = rs1.getString("nom");
			    		    String f = rs1.getString("quantite");
			    		    model.addRow(new Object[]{d, v, f});
			    		}
			    		table.setModel(model);
			    	   con.close();
				 }catch(Exception a){ System.out.println(e);}

			    	   
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(115, 207, 97, 25);
		frame1.getContentPane().add(btnDelete);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setIcon(new ImageIcon("illustration-gestion-stocks-generix.jpg"));
		lblNewLabel.setBounds(0, 0, 1083, 721);
		frame1.getContentPane().add(lblNewLabel);
		frame1.setVisible(true);
}
}
