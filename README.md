# Selenium-Java-E2E-Suite

•	This framework project automates the extraction of database table details into JSON files, serving multiple Quality Assurance (QA) functions: 
•	Test Automation Frameworks: The generated JSON files facilitate automated validation between the database and the JSON output.
•	Manual QA Verification: Manual testers can use the JSON files to cross-reference and verify database contents manually.
•	Frontend Validation: The JSON files/APIs can be integrated with tools like Selenium to validate data consistency between the backend and the frontend user interface using Selenium.

• Dynamically loaded one class in the jdbc jar “com.mysql.cj.jdbc.Driver”
•	Creating POJO classes to convert DB results into Java Objects
•	To Convert java object to json files using Jackson API
  o	Download 3 dependencies for Jackson API to work 
    	Jackson core
    	Jackson databind
    	Jackson annotations
•	Use ObjectMapper class to map java object into json files
•	Building ArrayList for each row in the table
•	Converted java oblect to json, we use ObjectMapper class, method is writeValue()
•	Convertedt json to java oblect, we use ObjectMapper class, method is readvalue()

•	Added Gson Dependency- to create json string from java object
•	Merged all Json files into single using Gson
  o	For single jsons, we took date from DB, create POJO classes,  create a java objects using this POJO, created an ArrayList with all these objects, then created single Json files.
  o	For this, we need to take data from DB, create POJO classes,  create a java objects using this POJO, created an ArrayList with all these objects, then create a Json Array with these objects

  o	String jsonString = g.toJson(); //this will convert java object into json string
  o Download Json Simple maven
  o JSONArray added all the json string to an array
  o JSONObject Helps to convert Json string to create one Json file
  o To remove unescaped text, use apache Common Text dependency maven.

•	Parse Json file into Java object to send the data through getter Methods
   o Use Jackson ObjectMapper itself to readd value from Json

•	Then Assert this backend/DB value is correct from  FrontEnd UI
•	This project will validate from DB or from the Json files to UI. 




