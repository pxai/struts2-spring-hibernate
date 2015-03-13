package org.cuatrovientos.battlefield;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class to start the battle
 * @author luser
 *
 */
public class Main {

	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("battlefield.xml");
        
        Battlefield battlefield = (Battlefield) context.getBean("battlefield");
        
        System.out.println("Battle field: " + battlefield.toString());
        System.out.println("First squad: " + battlefield.getSquad1().getName() + " leader: " + battlefield.getSquad1().getSquadLeader().getName() );
        System.out.println("First squad soldiers: " + battlefield.getSquad1().getSoldiers());

        System.out.println("Second squad: " + battlefield.getSquad2().getName() + " leader: " + battlefield.getSquad2().getSquadLeader().getName() );
        System.out.println("Second squad soldiers: " + battlefield.getSquad2().getSoldiers());

	}

}
