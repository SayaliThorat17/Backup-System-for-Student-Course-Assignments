/**
 * 
 */
package studentCoursesBackup.myTree;
import java.util.ArrayList;

import studentCoursesBackup.util.TreeBuilder;

/**
 * @author sayali
 *
 */
public interface ObserverI {
	public void update(ArrayList<TreeBuilder> cloneList,Node o);
}
