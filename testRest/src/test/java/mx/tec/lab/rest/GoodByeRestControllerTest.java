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
public class GoodByeRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void givenARequest_WhenEmptyName_thenGoodbyeWorld() throws Exception{
		this.mockMvc.perform(get("/goodbye"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Good bye, World :(")));
	}
	
	@Test
	public void givenARequest_WhenProvidedName_thenGoodbyeName() throws Exception{
		this.mockMvc.perform(get("/goodbye?name=Aloha Snow"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Good bye, Aloha Snow")));
	}

}
