import static org.junit.Assert.*;

import org.junit.Test;

public class DataCollectionClassTest {


	@Test
	public void testReturnTemp() throws Exception {
		Stub S = new Stub();
		assertTrue(S.ReturnTemp().equals(S.Temp));
	}

	@Test
	public void testGetTempValEquals() throws Exception {
		Stub S = new Stub();
		assertTrue(S.getTempVal() == S.temp);
	}
	
	@Test
	public void testGetTempValHigher() throws Exception {
		Stub S = new Stub();
		assertFalse(S.getTempVal() > (float)150.0);
	}
	@Test
	public void testGetTempValLower() throws Exception {
		Stub S = new Stub();
		assertFalse(S.getTempVal() < (float)-55.0);
	}


}
