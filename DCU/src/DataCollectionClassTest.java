import static org.junit.Assert.*;
import org.junit.Test;

public class DataCollectionClassTest {
	
	Stub s = new Stub();

	@Test
	public void testCreatePort() {
		assertTrue(s.createPort());
	}

	@Test
	public void testGetValue() {
		assertFalse(s.getValue().equals(""));
	}

	@Test
	public void testReturnTemp() throws Exception {
		assertTrue(s.ReturnTemp().equals("30"));
	}

	@Test
	public void testGetTempValEquals() throws Exception {
		assertTrue(s.getTempVal() == (float)30);
	}
	
	@Test
	public void testGetTempValHigher() throws Exception {
		assertFalse(s.getTempVal() > (float)150.0);
	}
	
	@Test
	public void testGetTempValLower() throws Exception {
		assertFalse(s.getTempVal() < (float)-55.0);
	}
	
	@Test
	public void testReturnFlame() throws Exception {
		assertTrue(s.ReturnFlame().equals("20"));
	}

	@Test
	public void testReturnSmoke() throws Exception {
		assertTrue(s.ReturnSmoke().equals("10"));
	}
	

}
