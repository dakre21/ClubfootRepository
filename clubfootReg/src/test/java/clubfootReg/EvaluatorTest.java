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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.packt.clubfootReg.controller.AddUserController;
import com.packt.clubfootReg.controller.HomeController;
import com.packt.clubfootReg.domain.Evaluator;
import com.packt.clubfootReg.domain.User;
import com.packt.clubfootReg.domain.Visit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/webcontext/DispatcherServlet-context.xml"})
//@ContextConfiguration({"classpath*:spring/applicationContext.xml"})
@WebAppConfiguration
public class EvaluatorTest {

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private MockHttpSession session;
	@Autowired
	private MockHttpServletRequest request;
	
	private MockMvc mockMvc;

	@InjectMocks
	private AddUserController auc;
	@InjectMocks
	Evaluator evaluator = new Evaluator();
	@InjectMocks
	Evaluator evaluator1 = new Evaluator(1, "first", "last", "middle", "doc", "Rush", 1);
	
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
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_view() throws Exception {
		this.mockMvc.perform(get("/evaluator")).andExpect(status().isOk());
	}
	
	@Test
	public void test_EvaluatorIDisNull() throws Exception {
		if(this.evaluator == null){
			assertNull(evaluator.getId());
		}
	}
	
	@Test
	public void test_EvaluatorIDisNotNull() throws Exception {
		if(this.evaluator1 != null){
			assertNotNull(evaluator1.getId());
			assertEquals(evaluator1.getId(), 1);
		}
	}
	
	@Test
	public void test_EvaluatorNameisNull() throws Exception {
		if(this.evaluator == null){
			assertNull(evaluator.getFirst_name());
		}
	}
	
	@Test
	public void test_EvaluatorNameisNotNull() throws Exception {
		if(this.evaluator1 != null){
			assertNotNull(evaluator1.getFirst_name());
			assertEquals(evaluator1.getFirst_name(), "first");
		}
	}
	
	@Test
	public void test_EvaluatorLNameisNull() throws Exception {
		if(this.evaluator == null){
			assertNull(evaluator.getLast_name());
		}
	}
	
	@Test
	public void test_EvaluatorLNameisNotNull() throws Exception {
		if(this.evaluator1 != null){
			assertNotNull(evaluator1.getLast_name());
			assertEquals(evaluator1.getLast_name(), "last");
		}
	}
	
	@Test
	public void test_EvaluatorMNameisNull() throws Exception {
		if(this.evaluator == null){
			assertNull(evaluator.getMiddle_name());
		}
	}
	
	@Test
	public void test_EvaluatorMNameisNotNull() throws Exception {
		if(this.evaluator1 != null){
			assertNotNull(evaluator1.getMiddle_name());
			assertEquals(evaluator1.getMiddle_name(), "middle");
		}
	}
	
	@Test
	public void test_EvaluatorTitleisNull() throws Exception {
		if(this.evaluator == null){
			assertNull(evaluator.getTitle());
		}
	}
	
	@Test
	public void test_EvaluatorTitleisNotNull() throws Exception {
		if(this.evaluator1 != null){
			assertNotNull(evaluator1.getTitle());
			assertEquals(evaluator1.getTitle(), "doc");
		}
	}
	
	@Test
	public void test_EvaluatorHospisNull() throws Exception {
		if(this.evaluator == null){
			assertNull(evaluator.getHospital_name());
		}
	}
	
	@Test
	public void test_EvaluatorHospisNotNull() throws Exception {
		if(this.evaluator1 != null){
			assertNotNull(evaluator1.getHospital_name());
			assertEquals(evaluator1.getHospital_name(), "Rush");
		}
	}
	
	@Test
	public void test_EvaluatorHospIDisNull() throws Exception {
		if(this.evaluator == null){
			assertNull(evaluator.getHospital_id());
		}
	}
	
	@Test
	public void test_EvaluatorHospIDisNotNull() throws Exception {
		if(this.evaluator1 != null){
			assertNotNull(evaluator1.getHospital_id());
			assertEquals(evaluator1.getHospital_id(), 1);
		}
	}

}
