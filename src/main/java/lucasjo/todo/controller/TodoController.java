/**
 * Copyright lgdispay.com.,LTD
 * All right reserved
 *
 * Mobile Vote Software
 */
package lucasjo.todo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import lucasjo.todo.model.Todo;
import lucasjo.todo.service.TodoService;

/**
 * <pre>
 * lucasjo.todo.controller
 *    |_ TodoController.java
 * </pre>
 *
 * @author     kikimans
 * @Date       2016. 11. 23.
 * @Version    
 *
 */
@RestController
@RequestMapping("api")
public class TodoController {

	final static Logger logger = LoggerFactory.getLogger(TodoController.class);
	
	@Autowired @Qualifier("todoService") TodoService todoService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Map<String,Object> add(@RequestBody Map<String,Object> param){
		Map<String,Object> res = Maps.newHashMap();
		
		try {
			todoService.save(this.convertMapToEntity(param, Todo.class));
			res.put("msgCode", "S");
			res.put("msg", "성공");
		} catch (Exception e) {
			e.printStackTrace();
			res.put("msgCode", "F");
			res.put("msg", e.getMessage());
		}
		return res;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public Map<String,Object> edit(@RequestBody Map<String,Object> param){
		Map<String,Object> res = Maps.newHashMap();
		
		try {
			todoService.save(this.convertMapToEntity(param, Todo.class));
			res.put("msgCode", "S");
			res.put("msg", "성공");
		} catch (Exception e) {
			e.printStackTrace();
			res.put("msgCode", "F");
			res.put("msg", e.getMessage());
		}
		return res;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public Map<String,Object> delete(@RequestBody Map<String,Object> param){
		Map<String,Object> res = Maps.newHashMap();
		
		try {
			todoService.delete(this.convertMapToEntity(param, Todo.class));
			res.put("msgCode", "S");
			res.put("msg", "성공");
		} catch (Exception e) {
			e.printStackTrace();
			res.put("msgCode", "F");
			res.put("msg", e.getMessage());
		}
		return res;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public Map<String,Object> list(){
		Map<String,Object> res = Maps.newHashMap();
		List<Todo> resList = Lists.newArrayList();
		try {
			List<Todo> todos = todoService.findTodoList();
			
			for(Todo todo : todos){
				if(!"D".equals(todo.getSts())){
					resList.add(todo);
				}
			}
			
			res.put("list",resList);
			res.put("msgCode", "S");
			res.put("msg", "성공");
		} catch (Exception e) {
			e.printStackTrace();
			res.put("msgCode", "F");
			res.put("msg", e.getMessage());
		}
		
		return res;
	}
	
	private <T> T convertMapToEntity(Map<String,Object> map, Class<T> entity) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		
		return (T) mapper.readValue(mapper.writeValueAsString(map), entity);
	}	
}
