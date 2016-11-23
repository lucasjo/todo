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

import org.springframework.stereotype.Component;

import lucasjo.todo.model.Todo;

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

	
	@Override
	public List<Todo> findTodoList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void save(Todo todo) throws Exception {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void save(List<Todo> todos) throws Exception {
		// TODO Auto-generated method stub

	}

	
	@Override
	public Todo findTodo(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
