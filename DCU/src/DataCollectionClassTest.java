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
		fail("Not yet implemented");
	}

	@Test
	public void testSetData() {
		fail("Not yet implemented");
	}

	@Test
	public void testReturnTemp() throws Exception {
		assertTrue(s.ReturnTemp().equals(s.Temp));
	}

	@Test
	public void testGetTempValEquals() throws Exception {
		assertTrue(s.getTempVal() == s.temp);
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
	public void testReturnFlame() {
		fail("Not yet implemented");
	}

	@Test
	public void testReturnSmoke() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTempVal() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFlameVal() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSmokeVal() {
		fail("Not yet implemented");
	}

	

}
