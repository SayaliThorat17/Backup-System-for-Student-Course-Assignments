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
	
	public TreeBuilder() {
		
		root=null;
	}
	
	public boolean TreeEmpty()
	{
		return root ==null;
	}
	
	
	public Node recursiveInsert(Node node, int Bnum, String course) {
		
		if(node==null) {
			
			node = new Node(Bnum,course);
		}
		
		else {
			
			if(Bnum<=node.getBnumber()) {
				
				node.left =recursiveInsert(node.left,Bnum,course);
			}
			else {
				
				node.right=recursiveInsert(node.right, Bnum,course);
			}
			
		}
		
		return node;
	}
	

}
