/**
 * 
 */
package info.pello.javakart;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
/**
 * @author luser
 *
 */
@Aspect
public class MonitoringKart {
	
	/**
	 * called when Kart.move() method is called
	 */
	  @Before("execution(* info.pello.javakart.Kart.move(..))")
	  public void movingKart() {
	     System.out.println("Kart moving");
	  }

	  /**
	   * called when Kart.move() method is called
	   * @param joinPoint
	   */
	  // If we put this Spring will call this and the other
	  @Before("execution(* info.pello.javakart.Kart.move(..))")
	  public void movingKart(JoinPoint joinPoint) {
	    String methodName = joinPoint.getSignature().toShortString();
	    System.out.println(methodName + " Kart Moving with join Point");
	  }

	  /**
	   * called after Kart.move() method call returns value
	   * we get the returning value through returning param 
	   * @param joinPoint
	   * @param distance
	   */
	  @AfterReturning(value="execution(* info.pello.javakart.Kart.move(..))",returning="distance")
	  public void movingKart(JoinPoint joinPoint, int distance) {
		  // join.Point.getThis : the caller object
	    System.out.println(joinPoint.getThis().toString() + " Kart Moved: " + distance );
	  }
	  
	  /**
	   * called after Kart.move() method call returns value
	   * we get the returning value through returning param 
	   * @param joinPoint
	   * @param distance
	   */
	  @AfterReturning(value="execution(* info.pello.javakart.Kart.handle(..))",returning="handlePoints")
	  public void handleKart(JoinPoint joinPoint, int handlePoints) {
		  Kart callingKart = (Kart) joinPoint.getThis();
		  // join.Point.getThis : the caller object
	    System.out.println(callingKart.getName() + " Kart handle: " + handlePoints );
	  }

}
