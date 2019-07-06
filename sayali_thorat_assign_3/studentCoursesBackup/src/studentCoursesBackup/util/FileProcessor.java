/**
 * 
 */
package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author sayali
 *
 */
public class FileProcessor {
	
	private String fileName;
	//private BufferedReader br;
	
	public BufferedReader OpenFile(String fileName) throws FileNotFoundException {
		BufferedReader br;
		
		this.fileName=fileName;
		
			br = new BufferedReader(new FileReader(fileName));
	
		return br;
	}
	
	public String readLine(BufferedReader br) {
		String line="";
		try {
			line = br.readLine();
		} catch (IOException e) {
			System.err.print("Error Reading file");
			e.printStackTrace();
		}
			return line;
	}
	
	public void closeFile(BufferedReader br) throws IOException {
		br.close();
		
	}


}
