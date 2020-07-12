import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		/** Launch the application */
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
}
