package Exception;

import java.io.IOException;

public class NoSuchFieldException extends Exception{
	
	private static final long serialVersionUID = 1L;
	public NoSuchFieldException(String str) throws IOException{
		super(str);
	}

}
