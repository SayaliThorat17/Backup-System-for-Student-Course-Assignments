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
			//System.out.println(root.getBnumber());
			
			for(int i = 0; i < root.getCourses().size();i++) {
				System.out.println(root.getBnumber()+":"+root.getCourses().get(i));
			}
			inorderRec(root.getRight());
		}
		
		
	} 
	
	
	
	/*//search
	public Node search(Node root, int bnum) {
		
		
		//base cases: root is null or key is present at root
		if(root == null || root.getBnumber()==bnum)
			return root;

		
		//val is greater than roots value
		else if(root.getBnumber() > bnum)
			return search(root.getLeft(),bnum);
		
		
		//val is less than roots value
		else if(root.getBnumber() < bnum)
		return search(root.getRight(),bnum);
		
		else 
			return null;
	}
	
	*/
	
	


		
		
		//search recursively
		private Node search(int bnum) {
			
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
		
		
		
		
		public void deleteCourse(int bnum, String course ) {
			
			Node Nodefound = this.search(bnum);
			
			if(Nodefound != null) {
				
				if(Nodefound.getCourses().contains(course)) {
					
					Nodefound.getCourses().remove(course);
				}
			
			}
			
		}
		
			
		
		
		
		

}
