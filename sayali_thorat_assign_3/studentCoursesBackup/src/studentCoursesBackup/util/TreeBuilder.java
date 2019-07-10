/**
 * 
 */
package studentCoursesBackup.util;

import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.ObserverI;
import studentCoursesBackup.myTree.SubjectI;



/**
 * @author sayali
 *This method uses the instance of Node class 
 *Here all the functions to build a tree, create cloned trees and deleteCourses are handled.
 *
 *Citation for BST :
 * 1)https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 * 2)https://www.sanfoundry.com/java-program-implement-binary-search-tree/
 */
public class TreeBuilder  {
	
	private Node root;

	//To hold list of clone tress
	ArrayList<TreeBuilder> cloneTreeList = new ArrayList<TreeBuilder>();

	
	//Constructor
	public TreeBuilder() {
		
		root=null;
	}
	
	//to check whether the tree is empty or not
	public boolean TreeEmpty()
	{
		return root ==null;
	}
	
	
	/*
	 * this method is used to create the required 2 backup or clone trees
	 */
	public void buildTree() {
		cloneTreeList.add(this);
		cloneTreeList.add(new TreeBuilder());    // first backup tree
		cloneTreeList.add(new TreeBuilder());	// second backup tree
	}
	
	
	//returns list of cloned trees
	 public ArrayList<TreeBuilder> getClones()
	    {
	        return cloneTreeList;
	    }
	 
	 
	/*
	 * This method is used to insert nodes in BST according to their Bnumbers.
	 * this method starts the recursion from root node
	 */
	public void insertNode(int Bnum, String course) {
				
		root=insertNode(root,Bnum,course);
	}

	
	/*
	 * This method is used to insert nodes in BST according to their Bnumbers.
	 * insertion of data recursively
	 */
	public Node insertNode(Node root, int Bnum, String course) {
		
		//if tree is empty ,return new node
		if(root==null) {
			
			root = new Node(Bnum,course);
			return root;
		}
		
		
		//otherwise recur down the tree
		
			if(Bnum < root.getBnumber()) {
				
				root.setLeft(insertNode(root.getLeft(),Bnum,course));
			}
			else if(Bnum > root.getBnumber()){
				
				root.setRight(insertNode(root.getRight(), Bnum,course));
			}
			else if(Bnum == root.getBnumber()) {
				
				updateNode(root,Bnum,course);
			}
			
			//return the (unchanged) node pointer
		return root;
	}
	
	
	
	/*
	 * This method is used to update node whenever a course is updated for the node
	 */
	Node updateNode(Node root, int key, String course) {
		
		if(root != null && root.getCourses().contains(course)!= true) {
			
			//root.setCourses.add(course);
			root.getCourses().add(course);
		}
		
		return root;
	}
	
	
	/*
	 * This method is used to print the tree in an inorder traversal form
	 */
	
	public void PrintNodes(Results R1) {
		
		inorderRec(root,R1);
	}
	
	
	/*
	 * this method is inorder traversal of tree for printing it
	 */
	public void inorderRec(Node root,Results R1) {
		
		if(root != null) {
			
			inorderRec(root.getLeft(),R1);
			//System.out.print("\n"+root.getBnumber()+":");
			R1.writeToFile("\n"+root.getBnumber()+":");
			
			for(int i = 0; i < root.getCourses().size();i++) {
			//	System.out.print(root.getCourses().get(i));
				R1.writeToFile(root.getCourses().get(i));
			}
			inorderRec(root.getRight(),R1);
		}
		
		
	} 
	
	
	/*
	 * This method searches for node according to Bnumber
	 */
	public Node search(int bnum) {
		Node Root = root;
		while(Root != null) {
			if(Root.getBnumber() < bnum)
				Root = Root.getRight();
			else if (Root.getBnumber() > bnum)
				Root = Root.getLeft();
			else if (Root.getBnumber() == bnum){
				return Root;
			}

		}
		return null;
	}
	
	
	/*
	 * This method is used to delete courses of a node when delete.txt file is called
	 */
	public void deleteCourse(int bnum, String course ) {
		Node Nodefound = this.search(bnum);
		if(Nodefound != null) {
			if(Nodefound.getCourses().contains(course)) {
				Nodefound.getCourses().remove(course);
			}
		}
		Nodefound.notifyAll(cloneTreeList,Nodefound);
	}

}
