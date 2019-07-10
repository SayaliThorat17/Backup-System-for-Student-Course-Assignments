/**
 * 
 */
package studentCoursesBackup.myTree;
import java.util.ArrayList;

import studentCoursesBackup.util.TreeBuilder;

/**
 * @author sayali
 *This is observer interface implemented by Node class for Observer Pattern implementation.
 */
public interface ObserverI {
	public void update(ArrayList<TreeBuilder> cloneList,Node o);
}
