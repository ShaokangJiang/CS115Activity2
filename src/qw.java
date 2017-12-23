/**
 * @author Shaokang Jiang & Shein George
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class qw {

	public static void main(String[] args) {
		try {  
	        FileInputStream in=new FileInputStream("E:/test3.txt");  
	        boolean flag = FTP.uploadFile("*SERVER*", 21, "*USERNAME*", "*PASSWORD*", "/", "test3.txt", in);  
	        System.out.println(flag);
	    } catch (FileNotFoundException e) {  
	        e.printStackTrace();  
	    }  

	}

}
