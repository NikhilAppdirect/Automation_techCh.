package Exception;

import java.io.IOException;

public class NoSuchMethodException extends Exception{
	
	private static final long serialVersionUID = 1L;
	public NoSuchMethodException(String str) throws IOException{
		super(str);
	}

}
