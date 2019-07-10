/**
 * 
 */
package studentCoursesBackup.util;

import studentCoursesBackup.util.MyLogger.DebugLevel;

/**
 * @author sayali
 *this logger class is used for debugging mechanism
 */
public class MyLogger {
	
	/*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
	   DEBUG_VALUE=3 [Print to stdout everytime the state is changed]
	   DEBUG_VALUE=2 [FIXME: Print when you wite results to file.(Specified in Results.java file)]
	   DEBUG_VALUE=1 [FIXME: Print exceptions if occured during outputfile generation (Specified in Results.java file)]
	   DEBUG_VALUE=0 [No output should be printed from the applicatio to stdout. It is ok to write to the output file though" ]
	 */

	public static enum DebugLevel {RELEASE, FILEEXCEPTION, IN_RESULTS, STATE_CHANGE, CONSTRUCTOR , NONE
    };

private static DebugLevel debugLevel;


public static void setDebugValue (int levelIn) {
switch (levelIn) {
case 4: debugLevel = DebugLevel.CONSTRUCTOR; 
break;
// FIXME: add code for other cases

case 3: debugLevel = DebugLevel.STATE_CHANGE; 
break;

case 2: debugLevel = DebugLevel.IN_RESULTS; 
break;

case 1: debugLevel = DebugLevel.FILEEXCEPTION; 
break;

case 0: debugLevel = DebugLevel.RELEASE; 
break;

default:
debugLevel = DebugLevel.NONE;
break;
}
}

  public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
  }

  // @return None
  public static void writeMessage (String  message  ,
                                   DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
  }

  /**
	 * @return String
	 */
  public String toString() {
	return "Debug Level is " + debugLevel;
  }

}
