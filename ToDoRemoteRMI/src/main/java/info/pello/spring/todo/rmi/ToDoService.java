/**
 * 
 */
package info.pello.spring.todo.rmi;

import java.util.List;

/**
 * A service interface that will be presented through RMI
 * @author Pello Xabier Altadill Izura
 * @greets 4 u
 */
public interface ToDoService {
	List<ToDo> getToDoList();
	List<ToDo> searchToDoList(String name);
	ToDo getToDoById(int id);
	void saveToDo(ToDo toDo);
	void updateToDo(ToDo toDo);
	void deleteToDo(int id);
}
