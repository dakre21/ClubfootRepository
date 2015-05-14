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

import edu.uiowa.icr.controllers.HomeController;
import edu.uiowa.icr.controllers.UserController;
import edu.uiowa.icr.models.Evaluator;
import edu.uiowa.icr.models.User;
import edu.uiowa.icr.models.Visit;
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
	private UserController auc;
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
			assertNull(evaluator.getFirstName());
		}
	}
	
	@Test
	public void test_EvaluatorNameisNotNull() throws Exception {
		if(this.evaluator1 != null){
			assertNotNull(evaluator1.getFirstName());
			assertEquals(evaluator1.getFirstName(), "first");
		}
	}
	
	@Test
	public void test_EvaluatorLNameisNull() throws Exception {
		if(this.evaluator == null){
			assertNull(evaluator.getLastName());
		}
	}
	
	@Test
	public void test_EvaluatorLNameisNotNull() throws Exception {
		if(this.evaluator1 != null){
			assertNotNull(evaluator1.getLastName());
			assertEquals(evaluator1.getLastName(), "last");
		}
	}
	
	@Test
	public void test_EvaluatorMNameisNull() throws Exception {
		if(this.evaluator == null){
			assertNull(evaluator.getMiddleName());
		}
	}
	
	@Test
	public void test_EvaluatorMNameisNotNull() throws Exception {
		if(this.evaluator1 != null){
			assertNotNull(evaluator1.getMiddleName());
			assertEquals(evaluator1.getMiddleName(), "middle");
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
			assertNull(evaluator.getHospitalName());
		}
	}
	
	@Test
	public void test_EvaluatorHospisNotNull() throws Exception {
		if(this.evaluator1 != null){
			assertNotNull(evaluator1.getHospitalName());
			assertEquals(evaluator1.getHospitalName(), "Rush");
		}
	}
	
	@Test
	public void test_EvaluatorHospIDisNull() throws Exception {
		if(this.evaluator == null){
			assertNull(evaluator.getHospitalId());
		}
	}
	
	@Test
	public void test_EvaluatorHospIDisNotNull() throws Exception {
		if(this.evaluator1 != null){
			assertNotNull(evaluator1.getHospitalId());
			assertEquals(evaluator1.getHospitalId(), 1);
		}
	}

}
