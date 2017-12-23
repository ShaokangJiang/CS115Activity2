import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.swing.JOptionPane;

public class copy {
	
	public static void copyFile(String oldPath, String newPath) { 
		try { 
		int bytesum = 0; 
		int byteread = 0; 
		File oldfile = new File(oldPath); 
		if (oldfile.exists()) { 
		InputStream inStream = new FileInputStream(oldPath); 
		FileOutputStream fs = new FileOutputStream(newPath); 
		byte[] buffer = new byte[1444]; 
		int length; 
		while ( (byteread = inStream.read(buffer)) != -1) { 
		bytesum += byteread; 
		//System.out.println(bytesum); 
		fs.write(buffer, 0, byteread); 
		} 
		inStream.close(); 
		} 
		} 
		catch (Exception e) { 
		JOptionPane.showMessageDialog(null, "Something goes error, Please try again later.\nPlease make sure the work space can be written.");
		e.printStackTrace(); 

		} 

		} 

}
