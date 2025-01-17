/**
 *
 */
package studentCoursesBackup.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.MyLogger.DebugLevel;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.myTree.Node;

/**
 * @author sayali
 *this class is used to create all objects and to deal with command line arguments
 */
public class Driver {

	/**
	 * the arguments passed to the main file are
	 * @param args InputFile.txt, Delete.txt, Output1.txt ,Output2.txt, Output3.txt and debugger value
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub

		if(args.length != 6) {
			System.out.println("Missing Input or Output File or Debug Value");
			System.out.println("Run the program as  : ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt -Darg5=4(between 0 to 4)");
			System.exit(0);
		}

		String inputFile =args[0];
		String deleteFile=args[1];
		String output1 = args[2];
		String output2 = args[3];
		String output3 = args[4];
		String debug_num= args[5];

		System.out.println("Argo 0 "+inputFile+"\n");
		System.out.println("Argo 1 "+deleteFile+"\n");
		System.out.println("Argo 2 "+output1+"\n");
		System.out.println("Argo 3 "+output2+"\n");
		System.out.println("Argo 4 "+output3+"\n");
		System.out.println("Argo 5 "+debug_num+"\n");

		int debugValue = Integer.parseInt(args[5]);

		if((debugValue >4) || (debugValue<0)) {

			System.out.println("Invalid debug argument .Please enter debug value from 0 to 4");
			System.exit(0);
		}

		MyLogger.setDebugValue(debugValue);





		treeobj.buildTree();

		BufferedReader br1 = fpobj.OpenFile(inputFile);
		String line = fpobj.readLine(br1);
		List<String> myList = new ArrayList<String>();

		/*
		 * This loop is used to read InputFile and call insertNode method to generate BST
		 */
		while (line != null) {
			MyLogger.writeMessage("Reading from file input.txt", DebugLevel.FILEREAD);
			String[] splited = line.split(":");
			myList.add(splited[1]);
			int Bnum =Integer.parseInt(splited[0]);
			String course = splited[1];
			treeobj.getClones().get(0).insertNode(Bnum, course);
			treeobj.getClones().get(1).insertNode(Bnum, course);
			treeobj.getClones().get(2).insertNode(Bnum, course);
			line = fpobj.readLine(br1);
		}




		//System.out.println("Tree Generated after insertion of input file :\n");
		//System.out.println("******************************");


		/*
		 * Here Output Files are generated to store the 3 trees generated
		 * i.e. Original Tree, Clone Tree 1 and Clone Tree2
		 */
		R1.writeToFile("Original BST generated after insertion of input file :\n");
		treeobj.getClones().get(0).PrintNodes(R1);

		R2.writeToFile("Clone BST 1 generated after insertion of input file :\n");
		treeobj.getClones().get(1).PrintNodes(R2);

		R3.writeToFile("Clone BST 2 generated after insertion of input file :\n");
		treeobj.getClones().get(2).PrintNodes(R3);
		//System.out.println("\n");







		/*
		 * This loop is used to read DeleteFile and call deleteCourse method to generate final BST
		 */
		while (outputLine != null) {

			MyLogger.writeMessage("Reading from file delete.txt", DebugLevel.FILEREAD);
			String[] splited = outputLine.split(":");
			myList1.add(splited[1]);

			int Bnum =Integer.parseInt(splited[0]);
			String course = splited[1];
			treeobj.deleteCourse(Bnum, course);
			outputLine = fpobj1.readLine(br2);
		}



			//treeobj.getClones().get(0).deleteCourse(50, "E");
			//System.out.println("Delete\n");


			/*
			 * Here final trees are generated in respective output files
			 * i.e. Original Tree, Clone Tree 1 and Clone Tree2
			 */
			R1.writeToFile("\n\nOriginal BST generated after deletion of courses from delete file :\n");
			treeobj.getClones().get(0).PrintNodes(R1);

			R2.writeToFile("\n\nClone BST 1 generated after deletion of courses from delete file :\n");
			treeobj.getClones().get(1).PrintNodes(R2);

			R3.writeToFile("\n\nClone BST 2 generated after deletion of courses from delete file :\n");
			treeobj.getClones().get(2).PrintNodes(R3);


	


	}
}
