/**
 * 
 */
package info.pello.maven.spring.Javamon;

/**
* Represents a Javamon combat
* @author Pello
* greetz lafu
*/
public class Combat {
   private Javamon javamon1;
   private Javamon javamon2;
   private int assaults = 0;
   
   /**
	* Class constructor
    */
   public Combat () {
   }
   
   /**
    * this method performs combat
    */
   public void combat () {
       Javamon first, second;

       do {

           assaults++;
           
           // Depending on initiative roll one attacks and the other defends
           if (javamon1.initiative() < javamon2.initiative()) {
               first = javamon2;
               second = javamon1;
           } else {
               first = javamon1;
               second = javamon2;
           }
           System.out.println(first.status() +" -> attacks -> "+ second.status());
           assault(first, second);
       // while both are alive they keep on fighting
       } while (first.getLife() > 0 && second.getLife() > 0);
           
   }
   
   /**
    * represents one assault of the combar
	* the first parameter is the attacker
    * @param jm1
    * @param jm2
    */
   private void assault (Javamon jm1, Javamon jm2) {
       // Assault damage will be one attack minus defender defense roll
       int damage = (jm1.attack() - jm2.defend());

       // In case of damage we decrease defender life points
       if (damage > 0) {
           System.out.println(jm1.getName() + " -> makes " + damage + " damage to -> " + jm2.getName());
           jm2.setLife(jm2.getLife() - damage);
       } else {
           System.out.println(jm2.getName() + " stops the attack!!");
       }
       
   }
   
   /**
    * outcome of the combat
    * @return the winner javamon
    */
   public Javamon outcome () {
       System.out.println("Total " + assaults + " assaults");
       if (javamon1.getLife() > 0) {
           return javamon1;
       } else {
           return javamon2;
       }
   }

/**
 * @return the javamon1
 */
public Javamon getJavamon1() {
	return javamon1;
}

/**
 * @param javamon1 the javamon1 to set
 */
public void setJavamon1(Javamon javamon1) {
	this.javamon1 = javamon1;
}

/**
 * @return the javamon2
 */
public Javamon getJavamon2() {
	return javamon2;
}

/**
 * @param javamon2 the javamon2 to set
 */
public void setJavamon2(Javamon javamon2) {
	this.javamon2 = javamon2;
}
   
}
