/**
 * 
 */
package studentCoursesBackup.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import studentCoursesBackup.util.FileProcessor;

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
		List<String> myList = new ArrayList<String>();
		
		while (line != null) 
		{
			
			String[] splited = line.split(":");
			System.out.println(Integer.parseInt(splited[0])+" "+splited[1]);
			//System.out.println(splited[1]);
			myList.add(splited[1]);
			//System.out.println("Course "+myList);
			line = fpobj.readLine(br1);

			
		}
		
		
		System.out.println("Hi");
		//for (int i = 0; i < myList.size(); i++) {
			System.out.print(myList);
		//}

	}
}
