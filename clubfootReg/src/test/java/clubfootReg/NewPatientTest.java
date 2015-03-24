
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

import com.packt.clubfootReg.controller.LoginController;
import com.packt.clubfootReg.controller.newPatientController;
import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.newPatient;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/webcontext/DispatcherServlet-context.xml"})
//@ContextConfiguration({"classpath*:spring/applicationContext.xml"})
@WebAppConfiguration
public class NewPatientTest {

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private MockHttpSession session;
	@Autowired
	private MockHttpServletRequest request;
	
	private MockMvc mockMvc;

	@InjectMocks
	private newPatientController npc;
	@InjectMocks
	newPatient np = new newPatient();
	@InjectMocks
	newPatient np1 = new newPatient(1, 2, 3, 4, "Bob", 
	          "Knight", "Not known", "01/02/1993", 5,
	          "02/11/2015", "right", "severe");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(npc).build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_view() throws Exception{
		//mockMvc.perform(get("/newpatient")).andExpect(status().isOk()).andExpect(view().name("newpatient"));
		this.mockMvc.perform(get("/newpatient")).andExpect(status().isOk());//.andExpect(view().name("hospital"));
	}
	
	@Test
	public void test_PatientIDisNull() throws Exception {
		if(this.np1 == null){
			assertNull(np1.getId());
		}
	}
	
	@Test
	public void test_PatientIDisNotNull() throws Exception {
		if(this.np1 == null){
			assertNotNull(np1.getId());
			assertEquals(np1.getId(), 1);
		}
	}
	
	@Test
	public void test_PatientFirstNameisNull() throws Exception {
		if(this.np1 == null){
			assertNull(np1.getPatient_firstName());
		}
	}
	
	@Test
	public void test_PatientFirstNameisNotNull() throws Exception {
		if(this.np1 != null){
			assertNotNull(np1.getPatient_firstName());
			assertEquals(np1.getPatient_firstName(), "Bob");
		}
	}
	
	@Test
	public void test_PatientMidNameisNull() throws Exception {
		if(this.np1 == null){
			assertNull(np1.getPatient_midName());
		}
	}
	
	@Test
	public void test_PatientMidNameisNotNull() throws Exception {
		if(this.np1 != null){
			assertNotNull(np1.getPatient_midName());
			assertEquals(np1.getPatient_midName(), "Not known");
		}
	}
	
	@Test
	public void test_PatientLastNameisNull() throws Exception {
		if(this.np1 == null){
			assertNull(np1.getPatient_lastName());
		}
	}
	
	@Test
	public void test_PatientLastNameisNotNull() throws Exception {
		if(this.np1 != null){
			assertNotNull(np1.getPatient_lastName());
			assertEquals(np1.getPatient_lastName(), "Knight");
		}
	}
	
	@Test
	public void test_PatientConsentisNotNull() throws Exception {
		if(this.np1 != null){
			assertNotNull(np1.getGuardianConsent());
			//assertEquals(np1.getGuardianConsent(), 2);
		}
	}
	
	@Test
	public void test_PatientConsentisNull() throws Exception {
		if(this.np1 == null){
			assertNull(np1.getGuardianConsent());
		}
	}
	
	@Test
	public void test_PatientPConsentisNotNull() throws Exception {
		if(this.np1 != null){
			assertNotNull(np1.getPhotoConsent());
			//assertEquals(np1.getPhotoConsent(), 3);
		}
	}
	
	@Test
	public void test_PatientPConsentisNull() throws Exception {
		if(this.np1 == null){
			assertNull(np1.getPhotoConsent());
		}
	}
	
	@Test
	public void test_PatientHospitalisNotNull() throws Exception {
		if(this.np1 != null){
			assertNotNull(np1.getHospital());
			//assertEquals(np1.getHospital(), 3);
		}
	}
	
	@Test
	public void test_PatientHospitalisNull() throws Exception {
		if(this.np1 == null){
			assertNull(np1.getHospital());
		}
	}
	
	@Test
	public void test_PatientDobisNotNull() throws Exception {
		if(this.np1 != null){
			assertNotNull(np1.getDob());
			assertEquals(np1.getDob(), "01/02/1993");
		}
	}
	
	@Test
	public void test_PatientDobisNull() throws Exception {
		if(this.np1 == null){
			assertNull(np1.getDob());
		}
	}
	
	@Test
	public void test_PatientVisitisNotNull() throws Exception {
		if(this.np1 != null){
			assertNotNull(np1.getEvaluation_date());
			//assertEquals(np1.getEvaluation_date(), "2/11/2015");
		}
	}
	
	@Test
	public void test_PatientVisitisNull() throws Exception {
		if(this.np1 == null){
			assertNull(np1.getEvaluation_date());
		}
	}
	
	@Test
	public void test_PatientFeetisNotNull() throws Exception {
		if(this.np1 != null){
			assertNotNull(np1.getFeet());
			assertEquals(np1.getFeet(), "right");
		}
	}
	
	@Test
	public void test_PatientFeettisNull() throws Exception {
		if(this.np1 == null){
			assertNull(np1.getFeet());
		}
	}
	
	@Test
	public void test_PatientDiagisNotNull() throws Exception {
		if(this.np1 != null){
			assertNotNull(np1.getDiagnosis());
			assertEquals(np1.getDiagnosis(), "severe");
		}
	}
	
	@Test
	public void test_PatientDiagtisNull() throws Exception {
		if(this.np1 == null){
			assertNull(np1.getDiagnosis());
		}
	}
	
	@Test
	public void test_PatientEvalisNotNull() throws Exception {
		if(this.np1 != null){
			assertNotNull(np1.getEvaluator());
			//assertEquals(np1.getEvaluator(), 5);
		}
	}
	
	@Test
	public void test_PatientEvaltisNull() throws Exception {
		if(this.np1 == null){
			assertNull(np1.getEvaluator());
		}
	}

}
