/**
 * 
 */
package studentCoursesBackup.myTree;
import java.util.ArrayList;

import studentCoursesBackup.util.TreeBuilder;

/**
 * @author sayali
 *This is Subject interface implemented by Node class for Observer Pattern implementation.
 */
public interface SubjectI {
    public void notifyAll(ArrayList<TreeBuilder> cloneList,Node Observer);
}