package frames;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import dao.Tirage;
import fractales.Fractale;
import fractales.TirageToFractaleConverter;
import model.ModeleDynamique;
import options.LANGUAGE;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

public class RandTirageJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private ModeleDynamique modele = new ModeleDynamique();
	private final JTable tableau = new JTable(modele);

	private Random randomGen = new Random();
	private int rand = randomGen.nextInt(tableau.getRowCount());
	private Tirage tirage = modele.rowToTirage(rand);

	JPanel panel;
	JLabel lblNewLabel;

	public RandTirageJFrame() {
		initialize();
	}

	private void initialize() {
		this.setTitle("Random Tirage");
		this.setResizable(false);
		this.setBounds(0, 0, 803, 303);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 797, 268);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		panel = new JPanel();
		panel.setBounds(55, 42, 565, 90);
		panel_1.add(panel);
		panel.setBackground(Color.BLACK);
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255),
						new Color(255, 255, 255), new Color(255, 255, 255))));
		panel.setLayout(null);

		lblNewLabel = new JLabel(tirage.toStringBis());
		lblNewLabel.setBounds(0, 0, 565, 90);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setForeground(Color.WHITE);

		JButton btnNewton= new JButton(new GenerateWtihCSV("Newton"));
		btnNewton.setBounds(55, 143, 271, 32);
		panel_1.add(btnNewton);
		btnNewton.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		btnNewton.setForeground(Color.WHITE);
		btnNewton.setBackground(Color.BLACK);

		JButton btnJulia = new JButton(new GenerateWtihCSV("Julia"));
		btnJulia.setBounds(55, 190, 271, 32);
		panel_1.add(btnJulia);
		btnJulia.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		btnJulia.setBackground(Color.BLACK);
		btnJulia.setForeground(Color.WHITE);
		
		JButton btnHH = new JButton(new GenerateWtihCSV("Householder"));
		btnHH.setBounds(338, 190, 282, 32);
		panel_1.add(btnHH);
		btnHH.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		btnHH.setBackground(Color.BLACK);
		btnHH.setForeground(Color.WHITE);
		
		JButton btnHalley = new JButton(new GenerateWtihCSV("Halley"));
		btnHalley.setBounds(338, 143, 282, 32);
		panel_1.add(btnHalley);
		btnHalley.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		btnHalley.setBackground(Color.BLACK);
		btnHalley.setForeground(Color.WHITE);

		JButton btnRegenerate = new JButton(new Regenerate(LANGUAGE.REGENERATE.getSelectedLanguage()));
		btnRegenerate.setBounds(632, 93, 116, 39);
		panel_1.add(btnRegenerate);
		btnRegenerate.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		btnRegenerate.setBackground(Color.BLACK);
		btnRegenerate.setForeground(Color.WHITE);

		JButton btnBack = new JButton(new BackAction(LANGUAGE.BACK.getSelectedLanguage()));
		btnBack.setBounds(632, 41, 116, 39);
		panel_1.add(btnBack);
		btnBack.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(0, 0, 0));
		setBackground(Color.DARK_GRAY);

	}

	private class Regenerate extends AbstractAction {
		private static final long serialVersionUID = 1L;

		private Regenerate(String string) {
			super(string);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			rand = randomGen.nextInt(tableau.getRowCount());
			tirage = modele.rowToTirage(rand);
			lblNewLabel.setText(tirage.toStringBis());
			panel.repaint();
		}

	}

	private class GenerateWtihCSV extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		private TirageToFractaleConverter converter;

		private String name;
		
		private GenerateWtihCSV(String name) {
			super(LANGUAGE.GENERATE_FRACTAL.getSelectedLanguage()+name);
			this.name = name;

		}

		public void actionPerformed(ActionEvent e) {
			List<Tirage> tirages = new ArrayList<Tirage>();
			tirages.add(tirage);

			dispose();
			converter = new TirageToFractaleConverter(tirages, name);
			

			List<Fractale> fractales = converter.convertTirageToFractale();
			new FractaleJFrame(fractales, 1070, 540);

		}

	}

	private class BackAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public BackAction(String string) {
			super(string);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			JFrame f = new WelcomeJFrame();
			f.setVisible(true);

		}

	}
}
