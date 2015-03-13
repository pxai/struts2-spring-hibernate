/**
 * 
 */
package info.pello.spring.todo.rmi;

import java.util.List;

/**
 * Implementations of ToDoService
 * @author Pello Xabier Altadill Izura
 * @greetz 
 */
public class ToDoServiceImpl implements ToDoService {
	
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

	@Override
	public List<ToDo> getToDoList() {
		return toDoDAO.getToDos();
	}

	@Override
	public List<ToDo> searchToDoList(String name) {
		return toDoDAO.getToDos();
	}

	@Override
	public ToDo getToDoById(int id) {
		// TODO Auto-generated method stub
		return toDoDAO.getToDoById(id);
	}

	@Override
	public void saveToDo(ToDo toDo) {
		toDoDAO.create(toDo);
	}

	@Override
	public void updateToDo(ToDo toDo) {
		toDoDAO.update(toDo);
	}

	@Override
	public void deleteToDo(int id) {
		toDoDAO.delete(id);
	}

}
