/**
 * Copyright lgdispay.com.,LTD
 * All right reserved
 *
 * Mobile Vote Software
 */
package lucasjo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
