package frames;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import org.apache.log4j.Logger;

import fractales.Fractale;
import fractales.Mandelbrot;
import options.LANGUAGE;


public class WelcomeJFrame extends JFrame {
	private static final long serialVersionUID = 1L;


	private static final Logger LOGGER = Logger.getLogger(WelcomeJFrame.class);


	final private String[] gameMode = { LANGUAGE.CSVDRAW.getSelectedLanguage(), LANGUAGE.RANDDRAW.getSelectedLanguage(), LANGUAGE.SELECTEDDRAW.getSelectedLanguage() };
	private JComboBox<String> comboBox = new JComboBox<String>(gameMode);
	
	final private String[] bonusMode = { "Puzzle", "Mandelbrot" };
	private JComboBox<String> comboBoxBonus = new JComboBox<String>(bonusMode);

	public WelcomeJFrame() {
		LOGGER.info("WelcomeJFrame opened");
		initialize();
	}

	private void initialize() {
		this.setTitle("EuroProject");
		this.setResizable(false);
		this.setBounds(0,0,1068,573);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setLayout(null);
		panel_1.setPreferredSize(new Dimension(1063, 535));
		getContentPane().add(panel_1);
		

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 215, 534);
		panel_1.add(panel);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(10, 167, 175, 55);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton = new JButton(new Jouer());
		btnNewButton.setBounds(0, 0, 175, 55);
		panel_2.add(btnNewButton);
		btnNewButton.setFont(new Font("OCR A Extended", Font.PLAIN, 22));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);

		JButton button_1 = new JButton(new Credits());
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.BLACK);
		button_1.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		button_1.setBounds(10, 445, 195, 40);
		panel.add(button_1);

		JButton button = new JButton(new Bonus());
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		button.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		button.setBounds(10, 394, 175, 40);
		panel.add(button);
		
		comboBoxBonus.setForeground(Color.WHITE);
		comboBoxBonus.setBackground(Color.BLACK);
		comboBoxBonus.setBounds(10, 394, 195, 40);
		panel.add(comboBoxBonus);

		JButton btnNewButton_1 = new JButton(new Options());
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(10, 343, 195, 40);
		panel.add(btnNewButton_1);

		JLabel lblWelcome = new JLabel(LANGUAGE.WELCOME.getSelectedLanguage());
		lblWelcome.setFont(new Font("OCR A Extended", Font.BOLD, 29));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBounds(20, 32, 181, 40);
		panel.add(lblWelcome);

		JLabel label_1 = new JLabel(" EURO-PSYCHO");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		label_1.setBounds(24, 75, 181, 40);
		panel.add(label_1);

		// Choix du mode de jeu

		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(Color.BLACK);
		comboBox.setBounds(10, 167, 195, 55);
		panel.add(comboBox);
		
		
		
		JButton btnNewButton_2 = new JButton(new Stats("Stats"));
		btnNewButton_2.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(10, 292, 195, 40);
		panel.add(btnNewButton_2);

		JLabel label = new JLabel("");
		label.setBounds(70, 11, 982, 513);
		panel_1.add(label);
		label.setIcon(new ImageIcon("src\\main\\ressources\\Accueil1.jfif"));

		pack();
	}
	
	private class Stats extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public Stats(String string) {
			super(string);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			LOGGER.info("StatsJFrame opened");
			dispose();
			StatsJFrame f = new StatsJFrame();
			f.setVisible(true);
		}
		
	}

	private class Jouer extends AbstractAction {
		private static final long serialVersionUID = 1L;

		private Jouer() {
			super(LANGUAGE.PLAY.getSelectedLanguage());
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			LOGGER.info("Game launched");
			switch (comboBox.getSelectedIndex()) {
			case 0:
				dispose();
				JFrame f = new TirageJFrame();
				f.setVisible(true);
				break;
			case 1:
				dispose();
				JFrame fr = new RandTirageJFrame();
				fr.setVisible(true);
				break;
			case 2:
				JFrame fc = new ChoixJFrame();
				fc.setVisible(true);
				dispose();
				break;
			default:
				LOGGER.error("index inconnu !");
			}
		}

	}

	private class Options extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public Options() {
			super("Options");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			LOGGER.info("OptionsJFrame opened");
			dispose();
			JFrame option = new OptionsJFrame();
			option.setVisible(true);
		}

	}

	private class Bonus extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public Bonus() {
			super("Bonus");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame;
			switch (comboBoxBonus.getSelectedIndex()) {
			case 0:
				LOGGER.info("PuzzleJFrame opened");
				dispose();
				frame = new PuzzleJFrameBonus();
				frame.setVisible(true);
				break;
			case 1:
				LOGGER.info("Mandelbrot opened");
				dispose();
				List<Fractale> fractales = new ArrayList<Fractale>();
				fractales.add(new Mandelbrot(-0.743f, 0.16f, 200, 1070, 540, 150));
				new FractaleJFrame(fractales, 1070, 540);
				break;
			}

		}

	}

	private class Credits extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public Credits() {
			super("Credits");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			JFrame f = new CreditsJFrame();
			f.setVisible(true);
			pack();
		}

	}
}
