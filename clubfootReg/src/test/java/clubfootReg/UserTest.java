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
import edu.uiowa.icr.models.User;
import edu.uiowa.icr.models.Visit;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/webcontext/DispatcherServlet-context.xml"})
//@ContextConfiguration({"classpath*:spring/applicationContext.xml"})
@WebAppConfiguration
public class UserTest {

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
	User user = new User();
	@InjectMocks
	User user1 = new User(1, "test_name", "test@email.com", 5, "ROLE_ADMIN");
	
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
		//mockMvc.perform(get("/adduser")).andExpect(status().isOk()).andExpect(view().name("adduser"));
		this.mockMvc.perform(get("/adduser")).andExpect(status().isOk());
	}
	
	@Test
	public void test_UserIDisNull() throws Exception {
		if(this.user == null){
			assertNull(user.getId());
		}
	}
	
	@Test
	public void test_UserIDisNotNull() throws Exception {
		if(this.user1 != null){
			assertNotNull(user1.getId());
			assertEquals(user1.getId(), 1);
		}
	}
	
	@Test
	public void test_UserNameisNull() throws Exception {
		if(this.user == null){
			assertNull(user.getUserName());
		}
	}
	
	@Test
	public void test_UserNameisNotNull() throws Exception {
		if(this.user1 != null){
			assertNotNull(user1.getUserName());
			assertEquals(user1.getUserName(), "test_name");
		}
	}
	
	@Test
	public void test_UserEmailisNull() throws Exception {
		if(this.user == null){
			assertNull(user.getEmail());
		}
	}
	
	@Test
	public void test_UserEmailisNotNull() throws Exception {
		if(this.user1 != null){
			assertNotNull(user1.getEmail());
			assertEquals(user1.getEmail(), "test@email.com");
		}
	}
	
	@Test
	public void test_UserHospitalisNull() throws Exception {
		if(this.user == null){
			assertNull(user.getHospitalIds());
		}
	}
	
	@Test
	public void test_UserHospitalisNotNull() throws Exception {
		if(this.user1 != null){
			assertNotNull(user1.getHospitalIds());
			//assertEquals(user1.getHospitalId(), 2);
		}
	}
	
	@Test
	public void test_UserRoleisNull() throws Exception {
		if(this.user == null){
			assertNull(user.getRoleId());
		}
	}
	
	@Test
	public void test_UserRoleisNotNull() throws Exception {
		if(this.user1 != null){
			assertNotNull(user1.getRoleId());
			assertEquals(user1.getRoleId(), 3);
		}
	}

}
