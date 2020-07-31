import static org.junit.Assert.*;

import java.io.IOException;

import javax.swing.JLabel;

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

	@SuppressWarnings("deprecation")
	@Rule
    public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void useZipTest() {
		APIRequest APIR = new APIRequest();
		String ans = APIR.useZip("48334", "us");
		assertEquals("http://api.openweathermap.org/data/2.5/weather?zip=48334,us&appid=7b4f07573c184034f4d2230c7d5046b6&units=imperial", ans);
	}
	
	@Test
	public void useCoordsTest() {
		APIRequest APIR = new APIRequest();
		String ans = APIR.useCoords("92", "74");
		assertEquals("http://api.openweathermap.org/data/2.5/weather?lat=92&lon=74&appid=7b4f07573c184034f4d2230c7d5046b6&units=imperial", ans);
	}
	
	@Test
	public void useCityIDTest() {
		APIRequest APIR = new APIRequest();
		String ans = APIR.useCityID("2345");
		assertEquals("http://api.openweathermap.org/data/2.5/weather?id=2345&appid=7b4f07573c184034f4d2230c7d5046b6&units=imperial", ans);
	}
	
	@Test
	public void useCityTest() {
		APIRequest APIR = new APIRequest();
		String ans = APIR.useCity("Farmington", "MI");
		assertEquals("http://api.openweathermap.org/data/2.5/weather?q=Farmington,MI&appid=7b4f07573c184034f4d2230c7d5046b6&units=imperial", ans);
	}
	
	@Test
	public void getWeatherCurrTest() {
		APIRequest APIR = new APIRequest();
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
		APIRequest APIR = new APIRequest();
		APIR.getWeatherCurr("4", "a");
	}
	
	@Test
	public void getOneshotTest() {
		APIRequest APIR = new APIRequest();
		APIR.getOneshot("48334", "us");
		/** testing that each variable is filled 
		 * using correct API call
		 * */
		assertEquals("42.51", APIR.latitude);
		assertEquals("-83.35", APIR.longitude);
		
	}
	
	@Test
	public void getOneshotTestFalseInfo() {
		APIRequest APIR = new APIRequest();
		APIR.getOneshot("23", "us");
	}
	
	@Test
	public void checkInfoTestFalse() {
		GUInew gui = new GUInew();
		APIRequest APIR = new APIRequest();
		APIR.cityName = null;
		gui.checkInfo();
	}
	
	@Test
	public void getDayTest() {
		GUInew gui = new GUInew();
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
	public void chooseBackground() {
		JLabel j = new JLabel();
		GUInew gui = new GUInew();
		gui.chooseBackground(j);
	}
	
	@Test
	public void testGUI() {
		String[] args = null;
		Main.main(args);
	}
}
	
