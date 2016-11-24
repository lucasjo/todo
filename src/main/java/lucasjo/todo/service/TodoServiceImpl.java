/**
 * Copyright lgdispay.com.,LTD
 * All right reserved
 *
 * Mobile Vote Software
 */
package lucasjo.todo.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lucasjo.todo.model.Todo;
import lucasjo.todo.repository.TodoRepository;

/**
 * <pre>
 * lucasjo.todo.service
 *    |_ TodoServiceImpl.java
 * </pre>
 *
 * @author     kikimans
 * @Date       2016. 11. 23.
 * @Version    
 *
 */
@Component(value="todoService")
@Transactional
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepo;
	
	@Override
	public List<Todo> findTodoList() throws Exception {
		
		return todoRepo.findAll();
	}

	
	@Override
	public void save(Todo todo) throws Exception {		
		todoRepo.save(todo);		
	}

	
	@Override
	public void save(List<Todo> todos) throws Exception {		
		todoRepo.save(todos);
	}
	
	

	
	@Override
	public Todo findTodo(Map<String, Object> param) throws Exception {		
		return todoRepo.findOne(Long.valueOf(String.valueOf(param.get("id"))));
	}


	@Override
	public void delete(Todo todo) throws Exception {
		todoRepo.delete(todo);		
	}

}
