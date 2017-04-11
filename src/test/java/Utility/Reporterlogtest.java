package Utility;

import java.sql.Timestamp;
import org.testng.Reporter;

public class Reporterlogtest {
	
	public void warning(String msg){
        Reporter.log(new Timestamp(System.currentTimeMillis())+ " [Warning]\t"+msg);
    }
	
	public void info(String msg){
		 Reporter.log(new Timestamp(System.currentTimeMillis())+ " [Warning]\t"+msg);
	}
	
}
