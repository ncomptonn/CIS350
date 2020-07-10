import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import javax.swing.SwingConstants;


public class GUInew extends JFrame {

	private JPanel contentPane;
	APIRequest APIR = new APIRequest();
	
	/** Find Location */
	private void enterLocation() {
		String zipCode = JOptionPane.showInputDialog(null, "Enter Zip Code: ");
		String countryCode = JOptionPane.showInputDialog(null, "Enter Country Code: ");
		APIR.getWeatherCurr(zipCode, countryCode);
		APIR.getOneshot(zipCode, countryCode);
	}
	
	/** Display Currnet Weather */
	private void currentWeatherDisplay() {
		/** Panel 0 (Current Weather Information)**/
		JPanel panel = new JPanel();
		panel.setBounds(0, 6, 800, 272);
		contentPane.add(panel);
		panel.setLayout(null);

		// City Name
		JLabel lblNewLabel = new JLabel("City: " + APIR.cityName);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("News Gothic MT", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 20, 800, 32);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Current Tempurature: " + APIR.curr_temp + "°");
		lblNewLabel_1.setBounds(31, 64, 249, 24);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Feels Like: " + APIR.curr_temp_feel + "°");
		lblNewLabel_2.setBounds(31, 92, 231, 32);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Clouds: " + APIR.cloud_coverage + "%");
		lblNewLabel_3.setBounds(31, 125, 249, 32);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Wind: " + APIR.wind_speed + "mph");
		lblNewLabel_4.setBounds(31, 157, 172, 32);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Humidity: " + APIR.humidity + "%");
		lblNewLabel_5.setBounds(270, 60, 172, 32);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Latitude: " + APIR.latitude);
		lblNewLabel_6.setBounds(270, 100, 211, 24);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Longitude: " + APIR.longitude);
		lblNewLabel_7.setBounds(270, 129, 201, 24);
		panel.add(lblNewLabel_7);
		
		//Background Img
		JLabel lblNewLabel_0 = new JLabel("");
		lblNewLabel_0.setIcon(new ImageIcon(GUInew.class.getResource("/images/Fluorescent-Gradient-Final.jpg")));
		lblNewLabel_0.setBounds(0, 0, 800, 272);
		panel.add(lblNewLabel_0);

		
	}
	
	private int findDay() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}

	private String getDay(int day) {
		String dayName = "null";
		switch (day) {
		case 1: 
			dayName = "SUN";
			break;
		case 2: 
			dayName = "MON";
			break;
		case 3: 
			dayName = "TUE";
			break;
		case 4: 
			dayName = "WED";
			break;
		case 5: 
			dayName = "THU";
			break;	
		case 6: 
			dayName = "FRI";
			break;
		case 7: 
			dayName = "SAT";
			break;
		case 8: 
			dayName = "SUN";
			break;	
		case 9: 
			dayName = "MON";
			break;
		case 10: 
			dayName = "TUE";
			break;
		case 11: 
			dayName = "WED";
			break;
		case 12: 
			dayName = "THU";
			break;	
		case 13: 
			dayName = "FRI";
			break;
		}
		return dayName;
	}
		
	private void weekWeatherDisplay() {
		
		/** Panel 1 (Week Weather Information)*/
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 240, 230));
		panel_1.setBounds(0, 272, 800, 200);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		/** Day of week*/
		JLabel lblNewLabel_8 = new JLabel(getDay(findDay()));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(6, 20, 100, 16);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(getDay(findDay() + 1));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(129, 20, 93, 16);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(getDay(findDay() + 2));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(255, 20, 79, 16);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel(getDay(findDay() + 3));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(374, 20, 76, 16);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel(getDay(findDay() + 4));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(496, 20, 61, 16);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel(getDay(findDay() + 5));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(599, 20, 72, 16);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel(getDay(findDay() + 6));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setBounds(707, 20, 80, 16);
		panel_1.add(lblNewLabel_14);
		
		/** Forcast */
		JLabel lblNewLabel_15 = new JLabel("" + APIR.weekForcast[0]);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setBounds(6, 59, 100, 16);
		panel_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("" + APIR.weekForcast[1]);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setBounds(126, 59, 96, 16);
		panel_1.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("" + APIR.weekForcast[2]);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setBounds(233, 59, 117, 16);
		panel_1.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("" + APIR.weekForcast[3]);
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setBounds(349, 59, 119, 16);
		panel_1.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("" + APIR.weekForcast[4]);
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setBounds(480, 59, 85, 16);
		panel_1.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("" + APIR.weekForcast[5]);
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setBounds(593, 59, 78, 16);
		panel_1.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("" + APIR.weekForcast[6]);
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setBounds(707, 59, 80, 16);
		panel_1.add(lblNewLabel_21);
		
		/** Temperature High/Low */
		JLabel lblNewLabel_22 = new JLabel("" + APIR.weekForcastHighs[0] + "°");
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setBounds(16, 87, 79, 16);
		panel_1.add(lblNewLabel_22);
		
		JLabel lblNewLabel_22_1 = new JLabel("" + APIR.weekForcastHighs[1] + "°");
		lblNewLabel_22_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22_1.setBounds(136, 87, 69, 16);
		panel_1.add(lblNewLabel_22_1);
		
		JLabel lblNewLabel_22_2 = new JLabel("" + APIR.weekForcastHighs[2] + "°");
		lblNewLabel_22_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22_2.setBounds(255, 87, 72, 16);
		panel_1.add(lblNewLabel_22_2);
		
		JLabel lblNewLabel_22_3 = new JLabel("" + APIR.weekForcastHighs[3] + "°");
		lblNewLabel_22_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22_3.setBounds(371, 87, 72, 16);
		panel_1.add(lblNewLabel_22_3);
		
		JLabel lblNewLabel_22_4 = new JLabel("" + APIR.weekForcastHighs[4] + "°");
		lblNewLabel_22_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22_4.setBounds(490, 87, 61, 16);
		panel_1.add(lblNewLabel_22_4);
		
		JLabel lblNewLabel_22_5 = new JLabel("" + APIR.weekForcastHighs[5] + "°");
		lblNewLabel_22_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22_5.setBounds(593, 87, 78, 16);
		panel_1.add(lblNewLabel_22_5);
		
		JLabel lblNewLabel_22_6 = new JLabel("" + APIR.weekForcastHighs[6] + "°");
		lblNewLabel_22_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22_6.setBounds(707, 87, 80, 16);
		panel_1.add(lblNewLabel_22_6);
	}

	/** Create the frame. */
	public GUInew() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		enterLocation();
		currentWeatherDisplay();
		weekWeatherDisplay();
	
	}
}


