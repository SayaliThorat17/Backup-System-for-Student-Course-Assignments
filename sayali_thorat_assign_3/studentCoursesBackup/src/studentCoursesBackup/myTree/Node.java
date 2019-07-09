/**
 * 
 */
package studentCoursesBackup.myTree;

import java.util.ArrayList;

/**
 * @author sayali
 *
 */
public class Node implements SubjectI, ObserverI {

	Node left;
	Node right;
	int Bnumber;
	private ArrayList<String> courses = new ArrayList<String>();
	//String courseName;
	
	
	//constructor
	public Node() {
		
		left=null;
		right=null;
		Bnumber =0;
		//courseName = null;
	
		
	}
	
	
	/**
	 * Constructor
	 */
	public Node(int bNumber, String course) {
		super();
		// TODO Auto-generated constructor stub
		
		this.Bnumber=bNumber;
		left = right = null;
		addCourse(course);
		
	}
	
	public void addCourse(String course) {
		
		courses.add(course);
	}

	
	
	public Node getLeft() {
		return left;
	}


	public void setLeft(Node left) {
		this.left = left;
	}


	public Node getRight() {
		return right;
	}


	public void setRight(Node right) {
		this.right = right;
	}


	public int getBnumber() {
		return Bnumber;
	}


	public void setBnumber(int bnumber) {
		Bnumber = bnumber;
	}


	/*public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	*/

	public ArrayList<String> getCourses() {
		return courses;
	}


	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}
	
	
	
	
}
