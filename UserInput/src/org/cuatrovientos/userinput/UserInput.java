package org.cuatrovientos.userinput;

import java.util.Scanner;

/**
 * Simple class to show how to read data from console
 * @author Pello Altadill
 * @greet any
 */
public class UserInput {

	public static void main(String[] args) {
		int number = 0;
		
		// This is needed to read from console
		Scanner reader = new Scanner(System.in);
		// Anything we read will be stored in this variable
		String line = "";
		
		System.out.println("Please enter a number:");
		line = reader.nextLine();
		// Convert line, which is a String to int 
		number = Integer.parseInt(line);
		
		System.out.println("The number was: " + number);
		

	}

}
