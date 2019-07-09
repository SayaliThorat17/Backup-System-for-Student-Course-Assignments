/**
 * 
 */
package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

/**
 * @author sayali
 *
 */
public class TreeBuilder {
	
	private Node root;
	
	
	//Constructor
	public TreeBuilder() {
		
		root=null;
	}
	
	//to check if tree is empty
	public boolean TreeEmpty()
	{
		return root ==null;
	}
	
	
	//method that starts the recursion from root node
			public void insertNode(int Bnum, String course) {
				
				root=insertNode(root,Bnum,course);
			}
	
	
	//insertion of data recursively
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
	
	
	Node updateNode(Node root, int key, String course) {
		
		if(root != null && root.getCourses().contains(course)!= true) {
			
			//root.setCourses.add(course);
			root.getCourses().add(course);
		}
		
		return root;
	}
	
	
	
	public void inorder() {
		
		inorderRec(root);
	}
	
	public void inorderRec(Node root) {
		
		if(root != null) {
			
			inorderRec(root.getLeft());
			System.out.println(root.getBnumber());
			
			for(int i = 0; i < root.getCourses().size();i++) {
				System.out.println(root.getCourses().get(i));
			}
			inorderRec(root.getRight());
		}
		
		
	} 
	
		
		
	/*	//print tree
		void printTree(Node root)
		{
			if(root == null) 
				return;
	 
				printTree(root.getLeft());
				if(root.getLeft() != null && root.getRight()!= null) {
					
					System.out.println(root.getBnumber()+" "+root.getCourseName());
				}

				printTree(root.getRight());
			

		}
		
		
		//search
		public boolean search(int bnum) {
			
			return search(root, bnum);
		}
		
		
		
		//search recursively
		private boolean search(Node node, int bnum) {
			
			boolean found = false;
			int value = node.getBnumber();
			
			while((node != null) && !found) {
				
				
				if(bnum < value)
					node = node.getLeft();
				else if(bnum > value)
					node=node.getRight();
				else {
					
					found = true;
					break;
				}
				
				found = search(node,bnum);
				System.out.println(found +""+ bnum);
			}
				
			return found;
		}
		
		*/
		
		
		
		

}
