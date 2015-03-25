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

import com.packt.clubfootReg.controller.HomeController;
import com.packt.clubfootReg.controller.HospitalController;
import com.packt.clubfootReg.domain.Hospital;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath*:spring/applicationContext.xml"})
//@ContextConfiguration({"classpath*:WEB-INF/"})
@ContextConfiguration({"classpath*:spring/webcontext/DispatcherServlet-context.xml"})
@WebAppConfiguration
public class HospitalTest {

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private MockHttpSession session;
	@Autowired
	private MockHttpServletRequest request;
	
	private MockMvc mockMvc;

	@InjectMocks
	HospitalController hc = new HospitalController();
	@InjectMocks
	Hospital mockHosp = new Hospital();
	@InjectMocks
	Hospital mockHosp1 = new Hospital(1, "Rush", 1, "USA");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(hc).build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_view() throws Exception {
		//mockMvc.perform(get("/hospital")).andExpect(status().isOk());
		this.mockMvc.perform(get("/hospital")).andExpect(status().isOk());//.andExpect(view().name("hospital"));
	}
	
	@Test
	public void test_HospitalNameisNull() throws Exception {
		if(this.mockHosp == null){
			assertNull(mockHosp.getName());
		}
		
	}
	
	@Test
	public void test_HospitalNameisNotNull() throws Exception {
		
		if(this.mockHosp1 != null){
			assertNotNull(mockHosp1.getName());
			assertEquals(mockHosp1.getName(), "Rush");
		}
		
	}
	
	@Test
	public void test_HospitalIDisNull() throws Exception {
		
		if(this.mockHosp == null){
			assertNull(mockHosp1.getId());
		}
		
	}
	
	@Test
	public void test_HospitalIDisNotNull() throws Exception {
		
		if(this.mockHosp1 != null){
			assertNotNull(mockHosp1.getId());
			assertEquals(mockHosp1.getId(), 1);
		}
		
	}
	
	@Test
	public void test_HospitalRegionIDisNull() throws Exception {
		
		if(this.mockHosp == null){
			assertNull(mockHosp1.getRegion_id());
		}
		
	}
	
	@Test
	public void test_HospitalRegionIDisNotNull() throws Exception {
		
		if(this.mockHosp1 != null){
			assertNotNull(mockHosp1.getRegion_id());
			assertEquals(mockHosp1.getRegion_id(), 1);
		}
		
	}
	
	@Test
	public void test_HospitalRegionisNull() throws Exception {
		
		if(this.mockHosp == null){
			assertNull(mockHosp1.getRegion_name());
		}
		
	}
	
	@Test
	public void test_HospitalRegionisNotNull() throws Exception {
		
		if(this.mockHosp1 != null){
			assertNotNull(mockHosp1.getRegion_name());
			assertEquals(mockHosp1.getRegion_name(), "USA");
		}
		
	}

}
