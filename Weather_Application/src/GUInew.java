import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;


public class GUInew extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	APIRequest APIR = new APIRequest();
	
	/** Find Location */
	private void enterLocation() {		
		String zipCode = JOptionPane.showInputDialog(null, "Enter Zip Code: ");
		String countryCode = JOptionPane.showInputDialog(null, "Enter Country Code: ");
		APIR.getWeatherCurr(zipCode, countryCode);
		APIR.getOneshot(zipCode, countryCode);
	}
	
	private boolean checkInfo() {
		if (APIR.cityName == null) {
			if (JOptionPane.showConfirmDialog(null, "Incorrect information, would you like to try again?", "Weather", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				// yes option
				try {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								GUInew frame = new GUInew();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} 
				catch (Exception e) {
					e.printStackTrace(); 
				}
			} 
			else {
			    // no option
				System.exit(0);
			}
			return false;
		}
		return true;
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
		default:
			System.out.println("Error in switch statements");
			break;
		}
		return dayName;
	}
	/** Display  Current Weather */
	
	private void clock(JPanel panel, JLabel lblNewLabel_15) {
		Thread clock = new Thread() {
			public void run(){
				try {
					while(true) {
						Calendar cal = new GregorianCalendar();
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);
						int am_pm = cal.get(Calendar.AM_PM);
						String ampm;
						if (am_pm == 0)
							ampm = "AM";
						else
							ampm = "PM";
						lblNewLabel_15.setText(hour + ":" + minute + ampm);
						sleep(1000);
					}
				} 
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}
	
	private int findDay() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}

	private String getImageCurrent() {
		String x = APIR.weekForcast[0];
		String imageName = "";
		if (x.equals("Clouds"))
			imageName = "weather.png";
		if (x.equals("Clear"))
			imageName = "sun.png";
		if (x.equals("Rain")) 
			imageName = "rain.png";
		if (x.equals("Snow"))
			imageName = "snow.png";
		if (x.equals("Storm"))
			imageName = "storm.png";
		return imageName;
	}
	
	private String getImageWeekForecast(int a) {
		String x = APIR.weekForcast[a];
		String imageName = "";
		if (x.equals("Clouds"))
			imageName = "weather-2.png";
		if (x.equals("Clear"))
			imageName = "sun-2.png";
		if (x.equals("Rain")) 
			imageName = "rain-2.png";
		if (x.equals("Snow"))
			imageName = "snow-2.png";
		if (x.equals("Storm"))
			imageName = "storm-2.png";
		return imageName;
	}
	
	private void chooseBackground(JLabel j) {
	   	JRadioButton pinkFade = new JRadioButton("Pink Fade");
	    pinkFade.setMnemonic(KeyEvent.VK_B);
	    pinkFade.setActionCommand("Pink Fade");
	    pinkFade.setSelected(true);

	    JRadioButton multiColor = new JRadioButton("Multi-Color");
	    multiColor.setMnemonic(KeyEvent.VK_C);
	    multiColor.setActionCommand("Multi-Color");

	    JRadioButton yellow = new JRadioButton("Yellow");
	    yellow.setMnemonic(KeyEvent.VK_D);
	    yellow.setActionCommand("Yellow");

	    JRadioButton purple = new JRadioButton("Purple");
	    purple.setMnemonic(KeyEvent.VK_R);
	    purple.setActionCommand("Purple");

	    //Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(pinkFade);
	    group.add(multiColor);
	    group.add(yellow);
	    group.add(purple);
	    
	    JButton ok = new JButton("Ok");

	    JPanel radioPanel = new JPanel(new GridLayout(0, 1));
	    radioPanel.add(pinkFade);
	    radioPanel.add(multiColor);
	    radioPanel.add(yellow);
	    radioPanel.add(purple);
	    radioPanel.add(ok);
	    
	    JFrame frame = new JFrame("Background");
	    frame.setBounds(20, 20, 200, 200);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(radioPanel);
	    frame.setVisible(true);
	    
	    ok.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (pinkFade.isSelected()) {
	    			j.setIcon(new ImageIcon(GUInew.class.getResource("/images/Fluorescent-Gradient-Final.jpg")));
	    		}
	    		if (multiColor.isSelected()) {
	    			j.setIcon(new ImageIcon(GUInew.class.getResource("/images/multiColor.jpg")));
	    		}
	    		if (yellow.isSelected()) {
	    			j.setIcon(new ImageIcon(GUInew.class.getResource("/images/yellow.jpg")));
	    		}
	    		if (purple.isSelected()) {
	    			j.setIcon(new ImageIcon(GUInew.class.getResource("/images/purple.jpg")));
	    		}
	    		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
	    	}
	    });

}
	
	private void currentWeatherDisplay() {
	
		//** Panel 0 (Current Weather Information)**/
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 20, 800, 281);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//weather photo
		String imageName = getImageCurrent();
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon(GUInew.class.getResource("/images/" + imageName)));
		lblNewLabel_16.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setBounds(294, 113, 203, 168);
		panel.add(lblNewLabel_16);

		//Clock
		JLabel lblNewLabel_15 = new JLabel("04:10");
		lblNewLabel_15.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_15.setBounds(563, 26, 140, 24);
		panel.add(lblNewLabel_15);
		clock(panel, lblNewLabel_15);
		
		// City Name
		JLabel lblNewLabel = new JLabel("Weather Forcast in " + APIR.cityName);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 22));
		lblNewLabel.setBounds(0, 20, 799, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(APIR.curr_temp + "°");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Courier New", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(0, 64, 799, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Feels Like " + APIR.curr_temp_feel + "°");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(240, 92, 322, 32);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(APIR.cloud_coverage + "% coverage");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(94, 103, 146, 32);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(APIR.wind_speed + " mph");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(94, 147, 146, 32);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(APIR.humidity + "% humidity");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Courier New", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(94, 191, 146, 32);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(APIR.temp_max + "°");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Courier New", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(563, 130, 236, 16);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(APIR.temp_min + "°");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Courier New", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(563, 199, 236, 16);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_17 = new JLabel("Temp. High");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblNewLabel_17.setBounds(563, 100, 236, 16);
		panel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Temp. Low");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		lblNewLabel_18.setBounds(563, 171, 236, 16);
		panel.add(lblNewLabel_18);
		
		/** Icons */
		JLabel lblNewLabel_25 = new JLabel("");
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_25.setIcon(new ImageIcon(GUInew.class.getResource("/images/cloudCoverage.png")));
		lblNewLabel_25.setBounds(39, 100, 52, 35);
		panel.add(lblNewLabel_25);
		
		JLabel lblNewLabel_25_1 = new JLabel("");
		lblNewLabel_25_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_25_1.setIcon(new ImageIcon(GUInew.class.getResource("/images/wind.png")));
		lblNewLabel_25_1.setBounds(39, 147, 52, 32);
		panel.add(lblNewLabel_25_1);
		
		JLabel lblNewLabel_25_2 = new JLabel("");
		lblNewLabel_25_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_25_2.setIcon(new ImageIcon(GUInew.class.getResource("/images/humidity.png")));
		lblNewLabel_25_2.setBounds(39, 191, 52, 32);
		panel.add(lblNewLabel_25_2);
		
		/** Page dividers */
		Canvas canvas = new Canvas();
		canvas.setBounds(240, 103, 2, 106);
		panel.add(canvas);
		
		Canvas canvas_1 = new Canvas();
		canvas_1.setBounds(560, 100, 2, 106);
		panel.add(canvas_1);
		
		//Background Img
		JLabel lblNewLabel_0 = new JLabel("");
		lblNewLabel_0.setBounds(0, 0, 799, 281);
		panel.add(lblNewLabel_0);
		lblNewLabel_0.setIcon(new ImageIcon(GUInew.class.getResource("/images/Fluorescent-Gradient-Final.jpg")));
		
		/** Menu */
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 20);
		contentPane.add(menuBar);
		
		//menu 1
		JMenu menu1 = new JMenu("Change Location");
		menuBar.add(menu1);
		JMenuItem newWindow = new JMenuItem("Open in new window");
		newWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GUInew frame = new GUInew();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		menu1.add(newWindow);
		
		//menu 2
		JMenu menu2 = new JMenu("About");
		menuBar.add(menu2);
		JMenuItem learnAbout = new JMenuItem("Learn About The App");
		learnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runnable r = () -> {
		            String html = "<html><body width='500'><h1>Hey!</h1>"
		                + "<p>This weather app was created by: "
		                + "<br><br>"
		                + "Nicholas Compton"
		                + "<br>"
		                + "Jeremy Bottoms"
		                + "<br>"
		                + "David Butz"
		                + "<br><br>"
		                + "Using a weather API provided by OpenWeather, we are able to use the location information entered in to send different requests to the API to retrieve weather data for the entered location."
		                + " More specifically, the zip code and country code is used to get the current weather data. After parsing the json file that is retrieved from the API, we are able to display the weather information."
		                + "<br><br>"
		                + "The first call (seen in \"getWeatherCurr\") also provides us with the longitude and latitude for the zipcode entered. This allows us to make another call to the API (seen in \"oneShot\") using the longitude and latitude to get the week weather forecast."
		                + " The source code can be found at the github link: https://github.com/ncomptonn/CIS350."
		                + "<br><br>"
		                + "<br><br>"
		                + "July 26, 2020";
		            // change to alter the width 
		            int w = 175;

		            JOptionPane.showMessageDialog(null, String.format(html, w, w));
		        };
		        SwingUtilities.invokeLater(r);
			}
		});
		menu2.add(learnAbout);
		
		//menu 3
		JMenu menu3 = new JMenu("Settings");
		menuBar.add(menu3);
		JMenuItem changeBackground = new JMenuItem("Change Background");
		changeBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   chooseBackground(lblNewLabel_0);
			}
		});
		menu3.add(changeBackground);
	}
		
	private void weekWeatherDisplay() {
		
		/** Panel 1 (Week Weather Information)*/
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 240, 230));
		panel_1.setBounds(0, 300, 800, 198);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		/** Day of week*/
		JLabel lblNewLabel_8 = new JLabel(getDay(findDay()));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(27, 20, 79, 16);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(getDay(findDay() + 1));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(132, 20, 90, 16);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(getDay(findDay() + 2));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(244, 20, 90, 16);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel(getDay(findDay() + 3));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(360, 20, 79, 16);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel(getDay(findDay() + 4));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(465, 20, 92, 16);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel(getDay(findDay() + 5));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(577, 20, 89, 16);
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel(getDay(findDay() + 6));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setBounds(687, 20, 90, 16);
		panel_1.add(lblNewLabel_14);
		
		/** Forecast */
		JLabel lblNewLabel_15 = new JLabel("" + APIR.weekForcastHighs[0] + "°");
		lblNewLabel_15.setForeground(Color.BLACK);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setBounds(27, 59, 79, 16);
		panel_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("" + APIR.weekForcastHighs[1] + "°");
		lblNewLabel_16.setForeground(Color.BLACK);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setBounds(132, 59, 90, 16);
		panel_1.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("" + APIR.weekForcastHighs[2] + "°");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setBounds(243, 59, 90, 16);
		panel_1.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("" + APIR.weekForcastHighs[3] + "°");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setBounds(352, 59, 90, 16);
		panel_1.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("" + APIR.weekForcastHighs[4] + "°");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setBounds(465, 59, 87, 16);
		panel_1.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("" + APIR.weekForcastHighs[5] + "°");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setBounds(577, 59, 88, 16);
		panel_1.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("" + APIR.weekForcastHighs[6] + "°");
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setBounds(687, 59, 90, 16);
		panel_1.add(lblNewLabel_21);
		
		/** Temperature High/Low */
		JLabel lblNewLabel_22 = new JLabel("" + APIR.weekForcastLows[0] + "°");
		lblNewLabel_22.setForeground(Color.GRAY);
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setBounds(27, 87, 79, 16);
		panel_1.add(lblNewLabel_22);
		
		JLabel lblNewLabel_22_1 = new JLabel("" + APIR.weekForcastLows[1] + "°");
		lblNewLabel_22_1.setForeground(Color.GRAY);
		lblNewLabel_22_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22_1.setBounds(132, 87, 90, 16);
		panel_1.add(lblNewLabel_22_1);
		
		JLabel lblNewLabel_22_2 = new JLabel("" + APIR.weekForcastLows[2] + "°");
		lblNewLabel_22_2.setForeground(Color.GRAY);
		lblNewLabel_22_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22_2.setBounds(244, 87, 90, 16);
		panel_1.add(lblNewLabel_22_2);
		
		JLabel lblNewLabel_22_3 = new JLabel("" + APIR.weekForcastLows[3] + "°");
		lblNewLabel_22_3.setForeground(Color.GRAY);
		lblNewLabel_22_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22_3.setBounds(352, 87, 91, 16);
		panel_1.add(lblNewLabel_22_3);
		
		JLabel lblNewLabel_22_4 = new JLabel("" + APIR.weekForcastLows[4] + "°");
		lblNewLabel_22_4.setForeground(Color.GRAY);
		lblNewLabel_22_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22_4.setBounds(465, 87, 87, 16);
		panel_1.add(lblNewLabel_22_4);
		
		JLabel lblNewLabel_22_5 = new JLabel("" + APIR.weekForcastLows[5] + "°");
		lblNewLabel_22_5.setForeground(Color.GRAY);
		lblNewLabel_22_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22_5.setBounds(577, 87, 89, 16);
		panel_1.add(lblNewLabel_22_5);
		
		JLabel lblNewLabel_22_6 = new JLabel("" + APIR.weekForcastLows[6] + "°");
		lblNewLabel_22_6.setForeground(Color.GRAY);
		lblNewLabel_22_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22_6.setBounds(687, 87, 90, 16);
		panel_1.add(lblNewLabel_22_6);
		
		/** Icons for week forecast display*/
		String imageName2 = getImageWeekForecast(0);
		String imageName3 = getImageWeekForecast(1);
		String imageName4 = getImageWeekForecast(2);
		String imageName5 = getImageWeekForecast(3);
		String imageName6 = getImageWeekForecast(4);
		String imageName7 = getImageWeekForecast(5);
		String imageName8 = getImageWeekForecast(6);
		
		JLabel lblNewLabel_23 = new JLabel("\n");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setIcon(new ImageIcon(GUInew.class.getResource("/images/" + imageName2)));
		lblNewLabel_23.setBounds(26, 115, 80, 24);
		panel_1.add(lblNewLabel_23);
		
		JLabel lblNewLabel_23_1 = new JLabel("\n");
		lblNewLabel_23_1.setIcon(new ImageIcon(GUInew.class.getResource("/images/" + imageName3)));
		lblNewLabel_23_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23_1.setBounds(132, 115, 90, 24);
		panel_1.add(lblNewLabel_23_1);
		
		JLabel lblNewLabel_23_2 = new JLabel("\n");
		lblNewLabel_23_2.setIcon(new ImageIcon(GUInew.class.getResource("/images/" + imageName4)));
		lblNewLabel_23_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23_2.setBounds(244, 115, 90, 24);
		panel_1.add(lblNewLabel_23_2);
		
		JLabel lblNewLabel_23_3 = new JLabel("\n");
		lblNewLabel_23_3.setIcon(new ImageIcon(GUInew.class.getResource("/images/" + imageName5)));
		lblNewLabel_23_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23_3.setBounds(352, 115, 90, 24);
		panel_1.add(lblNewLabel_23_3);
		
		JLabel lblNewLabel_23_4 = new JLabel("\n");
		lblNewLabel_23_4.setIcon(new ImageIcon(GUInew.class.getResource("/images/" + imageName6)));
		lblNewLabel_23_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23_4.setBounds(465, 115, 87, 24);
		panel_1.add(lblNewLabel_23_4);
		
		JLabel lblNewLabel_23_4_1 = new JLabel("\n");
		lblNewLabel_23_4_1.setIcon(new ImageIcon(GUInew.class.getResource("/images/" + imageName7)));
		lblNewLabel_23_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23_4_1.setBounds(577, 115, 89, 24);
		panel_1.add(lblNewLabel_23_4_1);
		
		JLabel lblNewLabel_23_4_2 = new JLabel("\n");
		lblNewLabel_23_4_2.setIcon(new ImageIcon(GUInew.class.getResource("/images/" + imageName8)));
		lblNewLabel_23_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23_4_2.setBounds(687, 115, 92, 24);
		panel_1.add(lblNewLabel_23_4_2);
		
		JLabel lblNewLabel_24 = new JLabel("");
		lblNewLabel_24.setBackground(Color.CYAN);
		lblNewLabel_24.setBounds(21, 16, 90, 153);
		panel_1.add(lblNewLabel_24);
		
		JLabel lblNewLabel_24_1 = new JLabel("");
		lblNewLabel_24_1.setForeground(Color.BLACK);
		lblNewLabel_24_1.setBackground(Color.CYAN);
		lblNewLabel_24_1.setBounds(132, 16, 90, 153);
		panel_1.add(lblNewLabel_24_1);
		
		JLabel lblNewLabel_24_1_1 = new JLabel("");
		lblNewLabel_24_1_1.setBounds(243, 16, 90, 153);
		panel_1.add(lblNewLabel_24_1_1);
		
		JLabel lblNewLabel_24_1_2 = new JLabel("");
		lblNewLabel_24_1_2.setBounds(354, 16, 90, 153);
		panel_1.add(lblNewLabel_24_1_2);
		
		JLabel lblNewLabel_24_1_3 = new JLabel("");
		lblNewLabel_24_1_3.setBounds(465, 16, 90, 153);
		panel_1.add(lblNewLabel_24_1_3);
		
		JLabel lblNewLabel_24_1_4 = new JLabel("");
		lblNewLabel_24_1_4.setBounds(576, 16, 90, 153);
		panel_1.add(lblNewLabel_24_1_4);
	
		JLabel lblNewLabel_24_1_5 = new JLabel("");
		lblNewLabel_24_1_5.setBounds(687, 16, 90, 153);
		panel_1.add(lblNewLabel_24_1_5);
		
	}
	
	
	
	
		/** Create the frame. 
		 * @throws InterruptedException */
		public GUInew(){

			enterLocation();
			
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setBounds(100, 100, 800, 520);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			checkInfo();
			currentWeatherDisplay();
			weekWeatherDisplay();
		}	
	}


