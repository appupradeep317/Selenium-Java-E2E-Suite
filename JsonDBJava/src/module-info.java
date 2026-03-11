/**
 * 
 */
/**
 * 
 */
module JasonDBJava {
	requires java.sql;
	
	// This allows Jackson to use reflection on your classes at runtime
    opens main to com.fasterxml.jackson.databind,com.google.gson;
    //opens main to com.google.gson;
    
    // You likely also need this for general compilation/usage
    exports main;
    
    
	requires com.fasterxml.jackson.databind;
	requires com.google.gson;
	requires json.simple;
	requires org.apache.commons.text;
}