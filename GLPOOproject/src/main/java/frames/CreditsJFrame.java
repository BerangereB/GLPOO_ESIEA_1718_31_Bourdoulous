package frames;


import javax.swing.JFrame;

import options.LANGUAGE;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class CreditsJFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public CreditsJFrame() {
		getContentPane().setBackground(Color.DARK_GRAY);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		this.setTitle("Crédits");
		this.setResizable(false);
		this.setBounds(0,0,1068,573);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblCredits = new JLabel("CREDITS");
		lblCredits.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		lblCredits.setForeground(Color.WHITE);
		lblCredits.setBounds(466, 11, 92, 62);
		getContentPane().add(lblCredits);

		JLabel lblEtuidants = new JLabel(LANGUAGE.GI.getSelectedLanguage());
		lblEtuidants.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblEtuidants.setForeground(Color.WHITE);
		lblEtuidants.setBounds(435, 134, 231, 36);
		getContentPane().add(lblEtuidants);

		JLabel label = new JLabel(" - BOURDOULOUS Bérangère");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		label.setBounds(143, 173, 178, 22);
		getContentPane().add(label);

		JLabel label_1 = new JLabel(" - COLIN Tim");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		label_1.setBounds(767, 173, 134, 22);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel(" - BOURDOULOUS Bérangère");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		label_2.setBounds(329, 313, 178, 22);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel(" - KERHARO Vincent");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		label_3.setBounds(466, 173, 134, 22);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel(" - KUE HOMSI Richard");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		label_4.setBounds(659, 313, 148, 22);
		getContentPane().add(label_4);

		JLabel label_5 = new JLabel(" - PAU Allan");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		label_5.setBounds(767, 193, 134, 22);
		getContentPane().add(label_5);
		
		JLabel lblFractalesdessins = new JLabel(LANGUAGE.FRACT.getSelectedLanguage());
		lblFractalesdessins.setForeground(Color.WHITE);
		lblFractalesdessins.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblFractalesdessins.setBounds(119, 134, 231, 36);
		getContentPane().add(lblFractalesdessins);
		
		JLabel label_7 = new JLabel(" - SYLVAIN Armand");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		label_7.setBounds(143, 193, 158, 22);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel(" - TAGNATI Ugo");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		label_8.setBounds(466, 193, 154, 22);
		getContentPane().add(label_8);
		
		JLabel lblStatistiques = new JLabel(LANGUAGE.STATS.getSelectedLanguage());
		lblStatistiques.setForeground(Color.WHITE);
		lblStatistiques.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblStatistiques.setBounds(757, 134, 200, 36);
		getContentPane().add(lblStatistiques);
		
		JLabel lblTests = new JLabel(LANGUAGE.TEST.getSelectedLanguage());
		lblTests.setForeground(Color.WHITE);
		lblTests.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblTests.setBounds(319, 278, 200, 36);
		getContentPane().add(lblTests);
		
		JLabel lblPuzzle = new JLabel(LANGUAGE.BONUS.getSelectedLanguage());
		lblPuzzle.setForeground(Color.WHITE);
		lblPuzzle.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblPuzzle.setBounds(649, 278, 200, 36);
		getContentPane().add(lblPuzzle);
		
		JLabel iconBack = new IconBack(this);
		getContentPane().add(iconBack);
		

	}
}
