/**
 * 
 */
package studentCoursesBackup.myTree;

/**
 * @author sayali
 *
 */
public class Node implements SubjectI, ObserverI {

	Node left;
	Node right;
	int Bnumber;
	String courseName;
	
	
	public Node() {
		
		left=null;
		right=null;
		Bnumber =0;
		courseName = null;
	}
	
	
	/**
	 * Constructor
	 */
	public Node(int Bnum, String subject) {
		super();
		// TODO Auto-generated constructor stub
		
		this.Bnumber=Bnum;
		this.courseName=subject;
		
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


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	
	
}
