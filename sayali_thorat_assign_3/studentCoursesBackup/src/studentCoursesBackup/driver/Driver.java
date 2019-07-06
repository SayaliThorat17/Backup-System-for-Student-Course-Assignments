/**
 * 
 */
package studentCoursesBackup.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import util.FileProcessor;

/**
 * @author sayali
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub
		
		if(args.length != 1) {
			System.out.println("Missing Input or Output File or Debug Value");
			//System.out.println("Run the program as  : ant -buildfile build.xml run -Darg0=infile.txt -Darg1=outfile.txt debug_num(between 0 to 4)");
			System.exit(0);
		}
		
		String inputFile = args[0];
		System.out.println("Argo 0 "+inputFile+"\n");
		
		
		FileProcessor fpobj = new FileProcessor();
		
		BufferedReader br1 = fpobj.OpenFile(inputFile);
		String line = fpobj.readLine(br1);

		while (line != null) 
		{
			String[] splited = line.split(":");
			System.out.println(splited[0]+" "+splited[1]);
			//System.out.println(splited[1]);
			line = fpobj.readLine(br1);

			
		}

	}


}
