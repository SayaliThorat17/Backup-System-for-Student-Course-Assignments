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
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.myTree.Node;

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
		
		if(args.length != 5) {
			System.out.println("Missing Input or Output File or Debug Value");
			//System.out.println("Run the program as  : ant -buildfile build.xml run -Darg0=infile.txt -Darg1=outfile.txt debug_num(between 0 to 4)");
			System.exit(0);
		}
		
		String inputFile = args[0];
		String deleteFile=args[1];
		String output1 = args[2];
		String output2 = args[3];
		String output3 = args[4]; 
		System.out.println("Argo 0 "+inputFile+"\n");
		
		
		FileProcessor fpobj = new FileProcessor();
		TreeBuilder treeobj = new TreeBuilder();
		treeobj.buildTree();
		BufferedReader br1 = fpobj.OpenFile(inputFile);
		String line = fpobj.readLine(br1);
		List<String> myList = new ArrayList<String>();
		
		Results R1 = new Results(output1);
		Results R2 = new Results(output2);
		Results R3 = new Results(output3);
		
		
		while (line != null) 
		{
			
			String[] splited = line.split(":");
			//System.out.println(Integer.parseInt(splited[0])+" "+splited[1]);
			//System.out.println(splited[1]);
			myList.add(splited[1]);
			//System.out.println("Course "+myList);
			//treeobj.insert(Integer.parseInt(splited[0]), splited[1]);
			int Bnum =Integer.parseInt(splited[0]);
			String course = splited[1];
			treeobj.getClones().get(0).insertNode(Bnum, course);
			treeobj.getClones().get(1).insertNode(Bnum, course);
			treeobj.getClones().get(2).insertNode(Bnum, course);
			line = fpobj.readLine(br1);

			
		}
		
		R1.writeToFile("Insert\n");
		System.out.println("Insert\n");
		System.out.println("******************************");
		treeobj.getClones().get(0).PrintNodes(R1);
		System.out.println("******************************");
		treeobj.getClones().get(1).PrintNodes(R2);
		System.out.println("******************************");
		treeobj.getClones().get(2).PrintNodes(R3);
		System.out.println("\n");
		
FileProcessor fpobj1 = new FileProcessor();
		

		

		BufferedReader br2 = fpobj1.OpenFile(deleteFile);
		String outputLine = fpobj1.readLine(br2);
		List<String> myList1 = new ArrayList<String>();
		

		while (outputLine != null) 
		{
			

			String[] splited = outputLine.split(":");
			//System.out.println(Integer.parseInt(splited[0])+" "+splited[1]);
			//System.out.println(splited[1]);
			myList1.add(splited[1]);
			

			int Bnum =Integer.parseInt(splited[0]);
			String course = splited[1];
			//treeobj.insertNode(Bnum, course);
			treeobj.deleteCourse(Bnum, course);
			outputLine = fpobj1.readLine(br2);

			

		}
		
		/*System.out.println("Hi");
		treeobj.inorder();
		
		System.out.println("Hi");
		//for (int i = 0; i < myList.size(); i++) {
			System.out.print(myList+"\n\n");
		//}  */
			
			
			//treeobj.getClones().get(0).deleteCourse(50, "E");
		System.out.println("Delete\n");
		System.out.println("******************************");
			treeobj.getClones().get(0).PrintNodes(R1);
			System.out.println("******************************");
			treeobj.getClones().get(1).PrintNodes(R2);
			System.out.println("******************************");
			treeobj.getClones().get(2).PrintNodes(R3);
			
			//treeobj.PrintNodes(R1);
			
			R1.closeFile();
			R2.closeFile();
			R3.closeFile();
			

	}
}
