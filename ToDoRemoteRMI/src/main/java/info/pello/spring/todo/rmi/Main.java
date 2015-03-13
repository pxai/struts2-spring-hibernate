package info.pello.spring.todo.rmi;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 */

/**
 * @author Pello Xabier Altadill Izura
 * @greetz Blue Mug users
 */
public class Main {
	
	
	public static String showAll (List<ToDo> toDos) {
		String result = "";
		
		for (ToDo toDo : toDos) {
			result += toDo.toString() + "\n";
		}
		
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("todoremotermi.xml");
		
		ToDoService toDoService = (ToDoService) context.getBean("toDoServiceRMI");
		
		List<ToDo> toDoList = toDoService.getToDoList();
		
		System.out.println("Here are our ToDos...");
		System.out.println(showAll(toDoList));
		
		// TODO Auto-generated method stub
		int id = 0;
		String name = "Spring";
		String description = "Master Spring";
		Date date = new Date();
		
		
		// CREATE
		ToDo toDo = new ToDo(0, name, description,date,false);
		toDoService.saveToDo(toDo);
		System.out.println("After insert> Here are our ToDos...");
		toDoList = toDoService.getToDoList();
		System.out.println(showAll(toDoList));
		
		// UPDATE DATA
		toDo.setName("Master all");
		toDoService.updateToDo(toDo);
		System.out.println("After update> Here are our ToDos...");
		toDoList = toDoService.getToDoList();
		System.out.println(showAll(toDoList));
		
		
		// REMOVE
		toDoService.deleteToDo(5);
		System.out.println("After deletion> Here are our ToDos...");
		toDoList = toDoService.getToDoList();
		System.out.println(showAll(toDoList));

		// and so on...


		
	}

}
