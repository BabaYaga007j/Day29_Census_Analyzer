package census_ananlyzer.exceptions;

import census_ananlyzer.utility.ExceptionType;

public class CustomExceptions extends RuntimeException{
	
	 public CustomExceptions(String message, ExceptionType type) {
	        super(message);
	    }	

}
