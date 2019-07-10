/**
 * 
 */
package studentCoursesBackup.myTree;

import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.ObserverI;
import studentCoursesBackup.myTree.SubjectI;
import studentCoursesBackup.util.TreeBuilder;

/**
 * @author sayali
 *Node class is used to implement BST.
 *
 *Citation for BST :
 * 1)https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 * 2)https://www.sanfoundry.com/java-program-implement-binary-search-tree/
 */
public class Node implements SubjectI, ObserverI {

	Node left;
	Node right;
	int Bnumber;
	private ArrayList<String> courses = new ArrayList<String>();
	private ArrayList<Node> nodeListeners = new ArrayList<Node>();
	//String courseName;
	
	
	/**
	 * Constructor
	 */
	public Node() {
		
		left=null;
		right=null;
		Bnumber =0;
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

	
	/**
     * @return Left node 
     */
	public Node getLeft() {
		return left;
	}


	public void setLeft(Node left) {
		this.left = left;
	}


	/**
     * @return Right node 
     */
	public Node getRight() {
		return right;
	}


	public void setRight(Node right) {
		this.right = right;
	}


	/**
     * @return Bnumber 
     */
	public int getBnumber() {
		return Bnumber;
	}


	public void setBnumber(int bnumber) {
		Bnumber = bnumber;
	}


	/**
     * @return Course list 
     */
	public ArrayList<String> getCourses() {
		return courses;
	}


	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}
	
	public void addNodeListener(Node node) {
		nodeListeners.add(node);
	}


	@Override
	public void update(ArrayList<TreeBuilder> cloneList,Node o) {
		// TODO Auto-generated method stub
		for (int i = 1; i < cloneList.size(); i++) {
			Node n=cloneList.get(i).search(o.Bnumber);
			n.setCourses(o.courses);
		}
	}


	@Override
	public void notifyAll(ArrayList<TreeBuilder> cloneList, Node Observer) {
		
		update(cloneList,Observer);
	}











	
	
	
}
