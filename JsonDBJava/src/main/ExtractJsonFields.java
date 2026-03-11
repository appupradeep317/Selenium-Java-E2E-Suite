package main;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtractJsonFields {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		// TODO Auto-generated method stub
		
		//Use Jackson ObjectMapper itself to readd value from Json
		ObjectMapper om = new ObjectMapper();
		CustomerDetailsAppium c =om.readValue(new File("C:\\Users\\u1073471\\OneDrive - IQVIA\\Documents\\WorkspaceTrials\\JsonDBJava\\jsonFiles\\CustomerInfoToExtract.json"),CustomerDetailsAppium.class);
		System.out.println("Name of Student enrolled- "+c.getName());
		
		//Then Assert this backend/DB value is correct from  FrontEnd UI
		//This project will validate from DB or from the Json files. 

	}

}
