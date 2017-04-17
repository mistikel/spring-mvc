package com.mitrais.trainee;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MvcspringApplicationTests {

	private MockMvc mockMvcEmployee;
	private MockMvc mockMvcHello;

	@Before
	public void setup(){
		this.mockMvcHello = MockMvcBuilders
			.standaloneSetup(new HelloController())
			.build();
	}

	@Before
	public void setupEmployees(){
		this.mockMvcEmployee = MockMvcBuilders
		.standaloneSetup(new EmployeeController())
		.build();
	}

	@Test
	public void getMessage() throws Exception{
		this.mockMvcHello.perform(get("/hello"))
		.andExpect(status().isOk());
	}

	@Test
	public void getEmployee() throws Exception{
		String result = "[{\"name\": \"Jacqualine\",\"gender\": \"Female\",\"privilage\": \"Jakarta\"}]";
		this.mockMvcEmployee.perform(get("/employees?gender=Female"))
		.andExpect(content().json(result));
	}

	@Test
	public void postEmployee() throws Exception{
		this.mockMvcEmployee.perform(post("/employees").content("{\"name\": \"Test\",\"gender\": \"Female\",\"privilage\": \"Jakarta\"}").contentType("application/json"))
		.andExpect(status().isOk());
	}

}
