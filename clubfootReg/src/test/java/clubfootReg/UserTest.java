package clubfootReg;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.packt.clubfootReg.controller.AddUserController;
import com.packt.clubfootReg.controller.HomeController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/webcontext/DispatcherServlet-context.xml"})
//@ContextConfiguration({"classpath*:spring/applicationContext.xml"})
@WebAppConfiguration
public class UserTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;

	@InjectMocks
	private AddUserController auc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(auc).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_view() throws Exception {
		//mockMvc.perform(get("/adduser")).andExpect(status().isOk()).andExpect(view().name("adduser"));
	}

}
