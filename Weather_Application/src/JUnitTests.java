import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JUnitTests {

	Main launch = new Main();
	APIRequest APIR = new APIRequest();
	
	@Rule
    public ExpectedException expectedException = ExpectedException.none();
	
	
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
	}
	
	@Test
	public void getWeatherCurrTestFail() {
        expectedException.expect(IOException.class);
		APIR.getWeatherCurr("4", "a");
	}
	
	@Test
	public void getOneshotTest() {
		APIR.getOneshot("48334", "us");
	}
	
	@Test
	public void getOneshotTestFail() {
        expectedException.expect(IOException.class);
		APIR.getOneshot("23", "us");
	}
	
//	@Test
//	public void guiTest() {
//		Main.main(null);
//	}
	
	
	
	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(JUnitTests.class);
			
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
	   }
}
