package lucasjo.todo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import lucasjo.todo.model.Todo;
import lucasjo.todo.service.TodoService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TestTodoApplication {	
	
	private static final Logger logger = LoggerFactory.getLogger(TestTodoApplication.class);
	
	@Autowired
	@Qualifier("todoService")
	private TodoService todoService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void test_todo등록() throws Exception{
		Todo todo = new Todo();
		
		todo.setText("교육개발");
		todo.setToDoSts("01");
		todo.setSts("C");
		
//		Date now = new Date();
//		SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(2016, 11, 24);
		
		todo.setCloseDt(cal.getTime());
		
		todoService.save(todo);
		
		List<Todo> todos = todoService.findTodoList();
		
		logger.info("toda all : {}", todos);
		
		assertThat(todos.size(), is(1));
		assertThat(todos.get(0).getText(), is("교육개발"));
	}

}
