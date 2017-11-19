import static org.junit.Assert.*;

import org.junit.Test;

public class DataAnalysisTest {

	Stub s = new Stub();
	
	@Test
	public void testSplitStringTemp() throws Exception {
		assertTrue(s.SplitStringTemp().equals("30"));
	}
	
	@Test
	public void testSplitStringFlame() throws Exception {
		assertTrue(s.SplitStringFire().equals("20"));
	}

	@Test
	public void testSplitStringSmoke() throws Exception {
		assertTrue(s.SplitStringSmoke().equals("10"));
	}
	
	@Test
	public void testGetTemp() {
		assertTrue(s.getTemp() == 60);
	}

	@Test
	public void testGetFire() {
		assertTrue(s.getFire().equals(true));
	}

	@Test
	public void testGetSmoke() {
		assertTrue(s.getSmoke().equals(true));
	}

	@Test
	public void testTempHigh() {
		assertTrue(s.tempHigh());
	}

}
