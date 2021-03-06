import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;


public class FTP {

	/** 
	 * Description: upload
	 * @param url hostname 
	 * @param port 
	 * @param username 
	 * @param password 
	 * @param path 
	 * @param filename 
	 * @param input 
	 * @return 
	 */  
	public static boolean uploadFile(String url,int port,String username, String password, String path, String filename, InputStream input) {  
	    boolean success = false;  
	    FTPClient ftp = new FTPClient();  
	    try {  
	        int reply;  
	        ftp.connect(url, port);//connect
	        ftp.login(username, password);
	        reply = ftp.getReplyCode();  
	        if (!FTPReply.isPositiveCompletion(reply)) {  
	            ftp.disconnect();  
	            return success;  
	        }  
	        ftp.changeWorkingDirectory(path);  
	        ftp.storeFile(filename, input);           
	          
	        input.close();  
	        ftp.logout();  
	        success = true;  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {  
	        if (ftp.isConnected()) {  
	            try {  
	                ftp.disconnect();  
	            } catch (IOException ioe) {  
	            }  
	        }  
	    }  
	    return success;  
	}
	
	/** 
	 * Description: download
	 * @param url hostname 
	 * @param port 
	 * @param username  
	 * @param password 
	 * @param remotePath
	 * @param fileName 
	 * @param localPath 
	 * @return 
	 */  
	public static boolean downFile(String url, int port,String username, String password, String remotePath,String fileName,String localPath) {  
	    boolean success = false;  
	    FTPClient ftp = new FTPClient();  
	    try {  
	        int reply;  
	        ftp.connect(url, port);  
	        ftp.login(username, password);  
	        reply = ftp.getReplyCode();  
	        if (!FTPReply.isPositiveCompletion(reply)) {  
	            ftp.disconnect();  
	            return success;  
	        }  
	        ftp.changeWorkingDirectory(remotePath);//move to ftp menu
	        FTPFile[] fs = ftp.listFiles();  
	        for(FTPFile ff:fs){  
	            if(ff.getName().equals(fileName)){  
	                File localFile = new File(localPath+"/"+ff.getName());  
	                  
	                OutputStream is = new FileOutputStream(localFile);   
	                ftp.retrieveFile(ff.getName(), is);  
	                is.close();  
	            }  
	        }  
	          
	        ftp.logout();  
	        success = true;  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {  
	        if (ftp.isConnected()) {  
	            try {  
	                ftp.disconnect();  
	            } catch (IOException ioe) {  
	            }  
	        }  
	    }  
	    return success;  
	}
	
}
