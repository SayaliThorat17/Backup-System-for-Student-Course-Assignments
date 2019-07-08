/**
 * 
 */
package studentCoursesBackup.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author sayali
 *
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	
	private BufferedWriter bw;
	private String outputFileName;
	private File fileWriter;
	public Results(String outfilename)  {
		// TODO Auto-generated constructor stub
		outputFileName=outfilename;
		fileWriter = new File(outputFileName);

		// Create file
		try {
			fileWriter.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println("Output File :- "+outputFileName);
			bw = new BufferedWriter(new FileWriter(outputFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeToStdout( String s)
	{
		System.out.println(s);
	}
	public void writeToFile(String text)
	{
		System.out.println("Inside Write sToStdOut"+text);	//Inside Write sToStdOut
		if ( text == null )
		{
			return;
		}
		try
		{
			bw.write(text + "\n");

		}
		catch( IOException e)
		{
			System.err.println("Error while writing");
			e.printStackTrace();
		}
	}
	public void closeFile() throws IOException {
		bw.close();
	}

}
