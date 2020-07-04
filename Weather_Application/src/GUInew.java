import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;


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
	
	private void currentWeatherDisplay() {
		/** Panel 0 (Current Weather Information)**/
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(0, 6, 721, 272);
		contentPane.add(panel);
		panel.setLayout(null);

		// City Name
		JLabel lblNewLabel = new JLabel("City: " + APIR.cityName);
		lblNewLabel.setFont(new Font("News Gothic MT", Font.BOLD, 20));
		lblNewLabel.setBounds(276, 20, 327, 32);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Current Tempurature: " + APIR.curr_temp);
		lblNewLabel_1.setBounds(31, 64, 249, 24);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Feels Like: " + APIR.curr_temp_feel);
		lblNewLabel_2.setBounds(31, 92, 231, 32);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Clouds: " + APIR.cloud_coverage);
		lblNewLabel_3.setBounds(31, 125, 249, 32);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Wind: " + APIR.wind_speed);
		lblNewLabel_4.setBounds(31, 157, 172, 32);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Humidity: " + APIR.humidity);
		lblNewLabel_5.setBounds(31, 190, 172, 32);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Latitude: " + APIR.latitude);
		lblNewLabel_6.setBounds(324, 64, 211, 24);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Longitude: " + APIR.longitude);
		lblNewLabel_7.setBounds(324, 96, 201, 24);
		panel.add(lblNewLabel_7);
		
	}
		
	private void weekWeatherDisplay() {
		/** Panel 1 (Week Weather Information)*/
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 240, 230));
		panel_1.setBounds(0, 278, 721, 167);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Monday: ");
		lblNewLabel_8.setBounds(34, 20, 72, 16);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Tuesday: ");
		lblNewLabel_9.setBounds(126, 20, 72, 16);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Wednesday: ");
		lblNewLabel_10.setBounds(231, 20, 79, 16);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Thursday: ");
		lblNewLabel_11.setBounds(348, 20, 76, 16);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Friday: ");
		lblNewLabel_12.setBounds(459, 20, 61, 16);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Saturday: ");
		lblNewLabel_13.setBounds(539, 20, 72, 16);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Sunday: ");
		lblNewLabel_14.setBounds(623, 20, 61, 16);
		panel_1.add(lblNewLabel_14);
	}

	/** Create the frame. */
	public GUInew() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		enterLocation();
		currentWeatherDisplay();
		weekWeatherDisplay();
	
	}
}

