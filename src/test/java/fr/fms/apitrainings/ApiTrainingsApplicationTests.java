package fr.fms.apitrainings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.is;


@SpringBootTest
@AutoConfigureMockMvc
class ApiTrainingsApplicationTests {

//
//	@Autowired
//	private MockMvc mockMvc;
//
////	@Test
////	void contextLoads() {
////	}
//
//	@Test
//	void testGetTrainingsAndTestName() throws  Exception{
//
//		mockMvc.perform(get("/api/trainings"))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("[0].name",is("Java")));
//	}
//
}
