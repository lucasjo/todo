/**
 * Copyright http://kikimans.github.io/
 * All right reserved
 *
 * Mobile ToDo Software
 */
package lucasjo.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import lucasjo.todo.config.ISO8601JsonDateDeserializer;


/**
 * <pre>
 * lucasjo.todo
 *    |_ TodoApplication.java
 * </pre>
 *
 * @author     kikimans
 * @Date       2016. 11. 23.
 * @Version    
 *
 */
@SpringBootApplication
public class TodoApplication {

	/**
	 * <pre>
	 * @Description :
	 * </pre>
	 * @Method Name : main
	 * @Date        : 2016. 11. 23.
	 * @author      : kikimans 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(TodoApplication.class, args);
	}
	
	/**
	 * <pre>
	 * @Description : javascript Date format parameter ConvertTo Java Date
	 * </pre>
	 * @Method Name : objectMapper
	 * @Date        : 2016. 11. 23.
	 * @author      : kikimans 
	 * @return
	 */
	@Primary
    @Bean
	public ObjectMapper objectMapper()
	{
    	ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();
		module.addDeserializer(Object.class, new ISO8601JsonDateDeserializer());
		mapper.registerModule(module);
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.disable(SerializationFeature.FLUSH_AFTER_WRITE_VALUE);
		return mapper;
	}

}
