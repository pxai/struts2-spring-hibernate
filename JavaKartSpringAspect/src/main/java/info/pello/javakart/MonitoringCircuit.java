/**
 * 
 */
package info.pello.javakart;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
/**
 * @author Pello Altadill
 * @greetz to Spring v4
 */
@Aspect
public class MonitoringCircuit {
	


	  /**
	   * called after Circuit.difficulty method call returns value
	   * we get the returning value through returning param 
	   * @param joinPoint
	   * @param difficulty
	   */
	  @AfterReturning(value="execution(* info.pello.javakart.Circuit.difficulty(..))",returning="difficultyValue")
	  public void movingKart(JoinPoint joinPoint, int difficultyValue) {
		  // join.Point.getThis : the caller object
	    System.out.println(joinPoint.getThis().toString() + " Circuit difficulty: " + difficultyValue );
	  }
	  

}
