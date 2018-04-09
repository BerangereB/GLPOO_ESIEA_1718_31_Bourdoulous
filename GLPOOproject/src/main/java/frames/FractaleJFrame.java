package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import fractales.Fractale;
import fractales.FractaleService;
import options.LANGUAGE;

public class FractaleJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(FractaleJFrame.class);

	private int[] ORIGINAL_SCALES; // Permet de "réinitialiser" le dessin après avoir zoomé plusieurs fois

	private BufferedImage buffer; // Contient la superposition des fractales

	private List<BufferedImage> images; // Contient les dessin de fractales sélectionnées (1min et 3 max)

	private String fileName; // Nom du fichier donné par l'utilisateur lors de la sauvegarde d'une image

	private int WIDTH; // Largeur de la fenêtre : utile pour le redimensionnement du dessin

	private int HEIGHT; // Hauteur de la fenetre

	private List<Fractale> fractales; // liste des fractales sélectionnées (leur buffer n'est pas encore rempli)

	private JLabel label; // Label qui accueil le dessin final

	private JPanel panelImage; // Panel qui va contenir l'image

	final JMenuBar menuBar;

	private JPanel panel; // Panel de boutons

	public FractaleJFrame(List<Fractale> fractales, int WIDTH, int HEIGHT) {
		this.fractales = fractales;
		this.label = new JLabel();
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		ORIGINAL_SCALES = initOriginalScales();

		// Initialisation de la fenêtre
		setTitle(LANGUAGE.FRACGEN.getSelectedLanguage());
		setMinimumSize(new Dimension(700, 700)); // On impose une taille minimale pour la fenetre
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Ajout d'un bandeau d'action
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createLoweredBevelBorder()));

		JButton backButton = new JButton(new BackAction(LANGUAGE.BACK.getSelectedLanguage()));
		backButton.setBackground(Color.BLACK);
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		panel.add(backButton);

		JButton reinitialiser = new JButton(new Reinitialiser());
		reinitialiser.setBackground(Color.BLACK);
		reinitialiser.setForeground(Color.WHITE);
		reinitialiser.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		panel.add(reinitialiser);

		// Ajout du menu dans la fenetre
		menuBar = configureMenu();

		// Permet de redimensionner la fenetre et de recalculer le dessin en conséquence
		addComponentListener(new Adapter());

		// Pour zoomer ou translater
		label.addKeyListener(new Key_Listener());

		// Ajout des composants dans la fenetre

		panelImage = new JPanel();
		panelImage.setBackground(Color.DARK_GRAY);

		buffer = getBuffer();

		label.setIcon(new ImageIcon(buffer));
		panelImage.add(label);
		getContentPane().add(panelImage, BorderLayout.CENTER);

		getContentPane().add(panel, BorderLayout.SOUTH);

		setJMenuBar(menuBar);

		// Affichage
		pack();
		setVisible(true);
		setLocationRelativeTo(null);

	}

	private int[] initOriginalScales() {
		int[] tab = new int[fractales.size()];
		for (int i = 0; i < tab.length; i++) {
			tab[i] = fractales.get(i).getScale();
		}
		return tab;
	}

	/*
	 * Permet de calculer les dessins de chaque fractale de la liste initialisée
	 * dans le constructeur de la classe et de les superposer
	 */
	private BufferedImage getBuffer() {
		images = new ArrayList<BufferedImage>();
		for (Fractale f : fractales) {
			FractaleService.changeSize(f, WIDTH, HEIGHT); // On change la taille du buffer de
															// la fractale en fonction de la taille de la fenetre
			images.add(f.getDrawing()); // On remplit le buffer de la fractale
		}
		BufferedImage buffer = FractaleService.joinFractales(images); // On superpose tous les dessins (on "additionne"
																		// les buffers)
		return buffer;
	}

	private JMenuBar configureMenu() {
		JMenuBar menuBar = new JMenuBar();

		JMenu fichierMenu = new JMenu(LANGUAGE.FILE.getSelectedLanguage());
		menuBar.add(fichierMenu);

		JMenuItem save = new JMenuItem(new SaveAction(LANGUAGE.SAVE.getSelectedLanguage()));
		fichierMenu.add(save);
		fichierMenu.addSeparator();
		JMenuItem close = new JMenuItem(new CloseAction(LANGUAGE.QUIT.getSelectedLanguage()));
		fichierMenu.add(close);
		return menuBar;
	}

	/*
	 * Permet de sauvegarder le dessin en lui donnant un nom : sauvegarde dans le
	 * dossier "src/main/Images" du projet
	 */
	private class SaveAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		private SaveAction(String string) {
			super(string);
		}

		public void actionPerformed(ActionEvent e) {
			// On demande le nom du fichier
			fileName = JOptionPane.showInputDialog(null, LANGUAGE.FN.getSelectedLanguage(),
					LANGUAGE.SAVE.getSelectedLanguage(), JOptionPane.QUESTION_MESSAGE);

			// On enregistre l'image
			Graphics2D g2d = (Graphics2D) buffer.getGraphics();
			g2d.dispose();
			try {
				ImageIO.write(buffer, "png", new File("src/main/Images/" + fileName + "_julia.png"));
			} catch (IOException e1) {
				LOGGER.error(e1.getMessage());
			}

		}

	}

	private class CloseAction extends AbstractAction {

		private static final long serialVersionUID = 1L;

		private CloseAction(String string) {
			super(string);
		}

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}

	private class BackAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		private BackAction(String string) {
			super(string);
		}

		public void actionPerformed(ActionEvent arg0) {
			dispose();
			WelcomeJFrame f = new WelcomeJFrame();
			f.setVisible(true);
		}

	}

	/*
	 * Permet de redimensionner le dessin lorsque l'utilisateur change la taille de
	 * la fenetre
	 */
	private class Adapter extends ComponentAdapter {

		public void componentResized(ComponentEvent e) {

			int width = getWidth();
			int height = getHeight();
			if (width != WIDTH || height != HEIGHT) { // Si l'un des parametres de dimensionnement est modifié
				WIDTH = width;
				HEIGHT = height;

				buffer = getBuffer(); // On redessine l'image

				setPreferredSize(new Dimension(width, height)); // changement de la dimension de la fenetre

				// Réaffichage
				getContentPane().add(panel, BorderLayout.SOUTH);
				label.setIcon(new ImageIcon(buffer));
				setJMenuBar(menuBar);
				label.requestFocus();

				pack();
			}
		}
	}

	/*
	 * Permet de réinitialiser le dessins à l'échelle d'origine
	 */
	private class Reinitialiser extends AbstractAction {

		private static final long serialVersionUID = 1L;

		public Reinitialiser() {
			super(LANGUAGE.REINIT.getSelectedLanguage());
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			label.requestFocus();

			images.clear();
			int i = 0;
			for (Fractale fractale : fractales) {
				fractale.setScale(ORIGINAL_SCALES[i]);
				images.add(fractale.getDrawing());
				i++;
			}
			buffer = FractaleService.joinFractales(images);
			label.setIcon(new ImageIcon(buffer));

			pack();
		}

	}

	private class Key_Listener implements KeyListener {

		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			float X = 0, Y = 0;
			final float coef = FractaleService.TRANSLATION_COEF;
			if (keyCode == 38) { // UP
				X = 0;
				Y = -coef;
			} else if (keyCode == 40) { // DOWN
				X = 0;
				Y = coef;
			} else if (keyCode == 39) { // RIGHT
				X = coef;
				Y = 0;
			} else if (keyCode == 37) { // LEFT
				X = -coef;
				Y = 0;
			} else if (keyCode == 107 || keyCode == 61) { // + pavé numérique ou non
				for (Fractale fractale : fractales) {
					FractaleService.zoom(fractale, true);
				}
			} else if (keyCode == 109 || keyCode == 54) { // -
				for (Fractale fractale : fractales) {
					FractaleService.zoom(fractale, false);
				}
			}

			if (keyCode == 37 || keyCode == 38 || keyCode == 39 || keyCode == 40) {
				for (Fractale fractale : fractales) {
					FractaleService.changeCenter(fractale, X, Y);
				}
			}

			images.clear();
			for (Fractale fractale : fractales) {
				images.add(fractale.getDrawing());
			}

			buffer = FractaleService.joinFractales(images);
			label.setIcon(new ImageIcon(buffer));

			pack();
		}

		public void keyReleased(KeyEvent arg0) {
		}

		public void keyTyped(KeyEvent arg0) {
		}
	}
}
