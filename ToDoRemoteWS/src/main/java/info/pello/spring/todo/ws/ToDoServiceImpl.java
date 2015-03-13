/**
 * 
 */
package info.pello.spring.todo.ws;

import java.io.Serializable;
import java.util.List;

/**
 * Implementations of ToDoService
 * @author Pello Xabier Altadill Izura
 * @greetz 
 */
public class ToDoServiceImpl implements ToDoService{
	
	private ToDoDAO toDoDAO;

	
	/**
	 * @return the toDoDAO
	 */
	public ToDoDAO getToDoDAO() {
		return toDoDAO;
	}

	/**
	 * @param toDoDAO the toDoDAO to set
	 */
	public void setToDoDAO(ToDoDAO toDoDAO) {
		this.toDoDAO = toDoDAO;
	}


	public List<ToDo> getToDoList() {
		return toDoDAO.getToDos();
	}


	public List<ToDo> searchToDoList(String name) {
		return toDoDAO.getToDos();
	}


	public ToDo getToDoById(int id) {
		// TODO Auto-generated method stub
		return toDoDAO.getToDoById(id);
	}


	public void saveToDo(ToDo toDo) {
		toDoDAO.create(toDo);
	}


	public void updateToDo(ToDo toDo) {
		toDoDAO.update(toDo);
	}


	public void deleteToDo(int id) {
		toDoDAO.delete(id);
	}

}
