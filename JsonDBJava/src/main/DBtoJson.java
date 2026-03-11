package main;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DBtoJson {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, StreamWriteException, DatabindException, IOException {
		// TODO Auto-generated method stub
		//Dynamically loaded this class to enable DriverManager
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		
		
		//Created the connection to DB
		Connection conn = null;		
		conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "root");
		
		//object of statement class will help to execute queries
		Statement st= conn.createStatement();
		ArrayList<CustomerDetails> a = new ArrayList<CustomerDetails>();
		//ResultSet rs = st.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia'");
		ResultSet rs = st.executeQuery("select * from CustomerInfo where Location ='Asia'");
		while(rs.next()) //pointer reaches 1st row and returns false when there is no row
		{
			/*
			 * System.out.println(rs.getString(1)); 
			 * System.out.println(rs.getString(2));
			 * System.out.println(rs.getInt(3)); 
			 * System.out.println(rs.getString(4));
			 */
			CustomerDetails cs= new CustomerDetails();
			cs.setCourseName(rs.getString(1));
			cs.setPurchaseDate(rs.getString(2));
			cs.setAmount(rs.getInt(3));
			cs.setLocation(rs.getString(4));
			System.out.println(cs.getCourseName());
			System.out.println(cs.getPurchaseDate()); System.out.println(cs.getAmount());
			System.out.println(cs.getLocation());
			
			a.add(cs);
			 
			
		}
		
		//File f = new File();
		
		ObjectMapper om = new ObjectMapper();
	
		for (int i = 0;i<a.size();i++)
		{
			om.writeValue(new File("C:\\Users\\u1073471\\OneDrive - IQVIA\\Documents\\WorkspaceTrials\\JsonDBJava\\jsonFiles\\CustomerInfo"+i+".json"),a.get(i));

		}
		

		conn.close();
	}

}
