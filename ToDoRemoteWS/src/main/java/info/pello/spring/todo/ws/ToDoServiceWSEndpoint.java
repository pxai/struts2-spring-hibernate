/**
 * 
 */
package info.pello.spring.todo.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This is a class to export a standalone JAX-WS webservice
 * using the Spring framework. In Spring context we create
 * a bean that will find all annotated WebService endpoints like this,
 * and Spring publishes them in http://localhost:8080
 * 
 * @author Pello Xabier Altadill Izura
 * @greetz -double wink-
 */

@Component
@WebService(serviceName="ToDoServiceWS")
public class ToDoServiceWSEndpoint {

	private ToDoServiceImpl toDoService;
	
	/**
	 * @return the toDoService
	 */
	public ToDoServiceImpl getToDoService() {
		return toDoService;
	}

	/**
	 * @param toDoService the toDoService to set
	 */
	public void setToDoService(ToDoServiceImpl toDoService) {
		this.toDoService = toDoService;
	}

	@WebMethod
	public List<ToDo> getToDoList() {
		return toDoService.getToDoList();
	}

	@WebMethod
	public List<ToDo> searchToDoList(String name) {
		return toDoService.getToDoList();
	}

	@WebMethod
	public ToDo getToDoById(int id) {
		// TODO Auto-generated method stub
		return toDoService.getToDoById(id);
	}

	@WebMethod
	public void saveToDo(ToDo toDo) {
		toDoService.saveToDo(toDo);
	}

	@WebMethod
	public void updateToDo(ToDo toDo) {
		toDoService.updateToDo(toDo);
	}

	@WebMethod
	public void deleteToDo(int id) {
		toDoService.deleteToDo(id);
	}
}
