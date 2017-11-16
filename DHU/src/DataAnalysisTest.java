import static org.junit.Assert.*;

import org.junit.Test;

public class DataAnalysisTest {

	//@Test
	//public void testSplitString() {
		//Stub s = new Stub();
		//DataAnalysis da = new DataAnalysis();
		//assertTrue(da.SplitString().equals("10"));
	//}

	
	@Test
	public void testSplitStringTemp() {
		DataAnalysis da = new DataAnalysis();
		assertTrue(da.SplitStringTemp() == "30");
	}

	@Test
	public void testSplitStringFire() {
		DataAnalysis da = new DataAnalysis();
		assertTrue(da.SplitStringFire() == "20");
	}

	@Test
	public void testSplitStringSmoke() {
		DataAnalysis da = new DataAnalysis();
		assertTrue(da.SplitStringSmoke() == "10");
	}
	
	@Test
	public void testGetTemp() {
		DataAnalysis da = new DataAnalysis();
		assertTrue(da.getTemp() == 30);
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
		assertFalse(da.temperature());
	}

}
