
import org.apache.log4j.Logger;

import frames.WelcomeJFrame;

public class Launcher {
	private static final Logger LOGGER = Logger.getLogger(Launcher.class);
	
	public static void main(String[] args) {
		LOGGER.info("Début du programme : lancement de la fenetre d'acceuil 'WelcomeJFrame'");
		final WelcomeJFrame f = new WelcomeJFrame();
		f.setVisible(true);
				
	}
}
