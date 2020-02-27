package com.product.root.exception;

public class GeneralException extends Exception{  
    
	private static final long serialVersionUID = 1L;

	public GeneralException() {
	}

	public GeneralException(String arg0) {
		super(arg0);
	}

	public GeneralException(Throwable arg0) {
		super(arg0);
	}

	public GeneralException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public GeneralException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}  
   }  
   