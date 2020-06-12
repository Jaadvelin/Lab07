package mx.tec.lab.rest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class GreetingRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void givenARequest_WhenEmptyName_thenHelloWorld() throws Exception{
		this.mockMvc.perform(get("/greeting"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Hello, World!")));
	}
	
	@Test
	public void givenARequest_WhenProvidedName_thenHelloName() throws Exception{
		this.mockMvc.perform(get("/greeting?name=Aloha Snow"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Hello, Aloha Snow!")));
	}
	
	@Test
	public void givenARequest_WhenNullName_thenHelloWorld() throws Exception{
		this.mockMvc.perform(get("/greeting?name="))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Hello, World!")));
	}
	
	public void givenARequest_whenWrongURL_thenError404() throws Exception{
		this.mockMvc.perform(get("/greetin"))
			.andExpect(status().is(404));
	}

}
