/**
 * Copyright lgdispay.com.,LTD
 * All right reserved
 *
 * Mobile Vote Software
 */
package lucasjo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lucasjo.todo.model.Todo;

/**
 * <pre>
 * lucasjo.todo.repository
 *    |_ TodoRepository.java
 * </pre>
 *
 * @author     kikimans
 * @Date       2016. 11. 23.
 * @Version    
 *
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
