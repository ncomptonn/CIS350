import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/** Some methods where switched to public in order to allow 
 * the tests to access the methods 
 * */
public class JUnitTests {

	private APIRequest APIR;
	private GUInew gui;
	
	@SuppressWarnings("deprecation")
	@Rule
    public ExpectedException expectedException = ExpectedException.none();
	
	@Before
	public void preTestSetup() {
		APIR = new APIRequest();
		gui = new GUInew();
	}
	
	@Test
	public void useZipTest() {
		String ans = APIR.useZip("48334", "us");
		assertEquals("http://api.openweathermap.org/data/2.5/weather?zip=48334,us&appid=7b4f07573c184034f4d2230c7d5046b6&units=imperial", ans);
	}
	
	@Test
	public void useCoordsTest() {
		String ans = APIR.useCoords("92", "74");
		assertEquals("http://api.openweathermap.org/data/2.5/weather?lat=92&lon=74&appid=7b4f07573c184034f4d2230c7d5046b6&units=imperial", ans);
	}
	
	@Test
	public void useCityIDTest() {
		String ans = APIR.useCityID("2345");
		assertEquals("http://api.openweathermap.org/data/2.5/weather?id=2345&appid=7b4f07573c184034f4d2230c7d5046b6&units=imperial", ans);
	}
	
	@Test
	public void useCityTest() {
		String ans = APIR.useCity("Farmington", "MI");
		assertEquals("http://api.openweathermap.org/data/2.5/weather?q=Farmington,MI&appid=7b4f07573c184034f4d2230c7d5046b6&units=imperial", ans);
	}
	
	@Test
	public void getWeatherCurrTest() {
		APIR.getWeatherCurr("48334", "us");
		/** testing that each variable is filled 
		 * using correct API call
		 * */
		assertNotNull(APIR.cityName);
		assertNotNull(APIR.curr_temp);
		assertNotNull(APIR.temp_min);
		assertNotNull(APIR.temp_max);
		assertNotNull(APIR.humidity);
		assertNotNull(APIR.wind_speed);
		assertNotNull(APIR.cloud_coverage);	
	}
	
	@Test
	public void getWeatherCurrTestFalseInfo() {
		expectedException.expect(IOException.class);
		APIR.getWeatherCurr("4", "a");
	}
	
	@Test
	public void getOneshotTest() {
		APIR.getOneshot("48334", "us");
		/** testing that each variable is filled 
		 * using correct API call
		 * */
		assertEquals("42.51", APIR.latitude);
		assertEquals("-83.35", APIR.longitude);
		
	}
	
	@Test
	public void getOneshotTestFalseInfo() {
		expectedException.expect(IOException.class);
		APIR.getOneshot("23", "us");
	}
	
	@Test
	public void getDayTest() {
		assertTrue(gui.getDay(1) == "SUN");
		assertTrue(gui.getDay(2) == "MON");
		assertTrue(gui.getDay(3) == "TUE");
		assertTrue(gui.getDay(4) == "WED");
		assertTrue(gui.getDay(5) == "THU");
		assertTrue(gui.getDay(6) == "FRI");
		assertTrue(gui.getDay(7) == "SAT");
		assertTrue(gui.getDay(8) == "SUN");
		assertTrue(gui.getDay(9) == "MON");
		assertTrue(gui.getDay(10) == "TUE");
		assertTrue(gui.getDay(11) == "WED");
		assertTrue(gui.getDay(12) == "THU");
		assertTrue(gui.getDay(13) == "FRI");
	}
	
	@Test
	public void testGUI() {
		String[] args = null;
		Main.main(args);
	}
	
	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(JUnitTests.class);
	      
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      
	      System.out.println(result.wasSuccessful());
	}
}
