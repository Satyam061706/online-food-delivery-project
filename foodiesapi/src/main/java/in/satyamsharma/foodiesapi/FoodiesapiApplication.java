package in.satyamsharma.foodiesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodiesapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodiesapiApplication.class, args);
		openBrowser("http://localhost:8080");
	}

	private static void openBrowser(String url) {
		if (java.awt.Desktop.isDesktopSupported()) {
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
			try {
				desktop.browse(new java.net.URI(url));
			} catch (Exception e) {
				System.err.println("Could not open browser using Desktop API: " + e.getMessage());
			}
		} else {
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
			} catch (Exception e) {
				System.err.println("Could not open browser using Runtime API: " + e.getMessage());
			}
		}
	}

}
