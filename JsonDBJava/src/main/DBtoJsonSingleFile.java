package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class DBtoJsonSingleFile {

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
			
			CustomerDetails cs= new CustomerDetails();
			cs.setCourseName(rs.getString(1));
			cs.setPurchaseDate(rs.getString(2));
			cs.setAmount(rs.getInt(3));
			cs.setLocation(rs.getString(4));
			
			
			a.add(cs);
			 
			
		}
		
		
		ObjectMapper om = new ObjectMapper();
		JSONArray js= new JSONArray();//from Json simple
	
		for (int i = 0;i<a.size();i++)
		{
			
			om.writeValue(new File("C:\\Users\\u1073471\\OneDrive - IQVIA\\Documents\\WorkspaceTrials\\JsonDBJava\\jsonFiles\\CustomerInfo"+i+".json"),a.get(i));

			//GSON - toJson helps to convert if the data are not of generic type(may consist of int, string etc) to string. 
			Gson g = new Gson();
			String jsonString=g.toJson(a.get(i));
			//Json Simple- JSONArray added all the json string to an array
			js.add(jsonString);
			
		
		}
		
		//Json Simple- JSONObject Helps to convert Json string to create one Json file
		JSONObject jo=new JSONObject();
		jo.put("data",js );	
		System.out.println(jo.toString());
		
		//Apache Unescape Dependency- helps to remove the java back slash in the strings 
		String unesccapedString = StringEscapeUtils.unescapeJava(jo.toString());
		System.out.println(unesccapedString);
		String unesccapedString1= unesccapedString.replace("\"{","{");
		String unesccapedStringFinal=unesccapedString1.replace("}\"","}");
		System.out.println(unesccapedStringFinal);
		
		//FileWriter helps to write anything to file. No dependency needs to add. Its already in java.io
		try(FileWriter file = new FileWriter("C:\\Users\\u1073471\\OneDrive - IQVIA\\Documents\\WorkspaceTrials\\JsonDBJava\\jsonFiles\\CustomerInfoSingleJson.json");)
		{
			file.write(unesccapedStringFinal);
		}
		
		


		conn.close();
	}

}
