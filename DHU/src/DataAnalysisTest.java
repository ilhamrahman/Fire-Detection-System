import static org.junit.Assert.*;

import org.junit.Test;

public class DataAnalysisTest {

	Stub s = new Stub();
	DataAnalysis d = new DataAnalysis();
	
	@Test
	public void testSplitStringTemp() throws Exception {
		assertTrue(d.SplitStringTemp().equals("60"));
	}
	
	@Test
	public void testSplitStringFlame() throws Exception {
		assertTrue(d.SplitStringFire().equals("20"));
	}

	@Test
	public void testSplitStringSmoke() throws Exception {
		assertTrue(d.SplitStringSmoke().equals("10"));
	}
	
	@Test
	public void testGetTemp() {
		DataAnalysis da = new DataAnalysis();
		assertTrue(da.getTemp() == 60);
	}

	@Test
	public void testGetFire() {
		DataAnalysis da = new DataAnalysis();
		assertTrue(da.getFire() == 20);
	}

	@Test
	public void testGetSmoke() {
		DataAnalysis da = new DataAnalysis();
		assertTrue(da.getSmoke() == 10);
	}

	@Test
	public void testTemperature() {
		DataAnalysis da = new DataAnalysis();
		assertTrue(da.temperature());
	}

}
