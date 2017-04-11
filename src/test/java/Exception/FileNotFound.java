package Exception;

import java.io.IOException;

public class FileNotFound extends Exception{
	
	private static final long serialVersionUID = 1L;
	public FileNotFound(String str) throws IOException{
		super(str);
	}
	
}
