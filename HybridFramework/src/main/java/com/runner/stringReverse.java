package com.runner;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class stringReverse {
	    
	    static Logger log=LogManager.getLogger(stringReverse.class.getName());
	    @Test
	    public void reverse()
	    {
	        Scanner s=new Scanner(System.in);
	        System.out.println("Enter a string:");
	        String word=s.nextLine();
	      
	     // Created a StringBuffer "sb" and stored all the characters of the String
	            StringBuffer sb = new StringBuffer(word);
	            
	            // Reversed the occurrence of characters
	             
	             log.info("Reverse String : "+sb.reverse());
	             s.close();
	    }

}

