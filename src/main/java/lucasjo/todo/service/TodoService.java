/**
 * Copyright lgdispay.com.,LTD
 * All right reserved
 *
 * Mobile Vote Software
 */
package lucasjo.todo.service;

import java.util.List;
import java.util.Map;

import lucasjo.todo.model.Todo;

/**
 * <pre>
 * lucasjo.todo.service
 *    |_ TodoService.java
 * </pre>
 *
 * @author     kikimans
 * @Date       2016. 11. 23.
 * @Version    
 *
 */
public interface TodoService {

	/**
	 * <pre>
	 * @Description : todo 리스트를 가져온다.
	 * </pre>
	 * @Method Name : findTodoList
	 * @Date        : 2016. 11. 23.
	 * @author      : kikimans 
	 * @return
	 * @throws Exception
	 */
	List<Todo> findTodoList() throws Exception;
	
	/**
	 * <pre>
	 * @Description : todo 단일 저장
	 * </pre>
	 * @Method Name : save
	 * @Date        : 2016. 11. 23.
	 * @author      : kikimans 
	 * @param todo
	 * @throws Exception
	 */
	void save(Todo todo) throws Exception;
	
	/**
	 * <pre>
	 * @Description : todo 복수 저장
	 * </pre>
	 * @Method Name : save
	 * @Date        : 2016. 11. 23.
	 * @author      : kikimans 
	 * @param todos
	 * @throws Exception
	 */
	void save(List<Todo> todos) throws Exception;
	
	/**
	 * <pre>
	 * @Description : 단일 todo 저장
	 * </pre>
	 * @Method Name : findTodo
	 * @Date        : 2016. 11. 23.
	 * @author      : kikimans 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Todo findTodo(Map<String,Object> param) throws Exception;
	
	/**
	 * <pre>
	 * @Description : 삭제
	 * </pre>
	 * @Method Name : delete
	 * @Date        : 2016. 11. 24.
	 * @author      : kikimans 
	 * @param todo
	 * @throws Exception
	 */
	void delete(Todo todo) throws Exception;
}
