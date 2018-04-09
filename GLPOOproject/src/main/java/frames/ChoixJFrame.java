package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.SimpleTirage;
import dao.Tirage;
import fractales.Fractale;
import fractales.TirageToFractaleConverter;
import options.LANGUAGE;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;

public class ChoixJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Tirage tirage = new SimpleTirage();

	private JTextField boule1;
	private JTextField boule3;
	private JTextField boule2;
	private JTextField boule4;
	private JTextField boule5;
	private JTextField etoile1;
	private JTextField etoile2;

	public ChoixJFrame() {
		getContentPane().setBackground(Color.DARK_GRAY);
		initialize();
	}

	public void initialize() {
		this.setTitle(LANGUAGE.SELECTEDDRAW.getSelectedLanguage());
		this.setResizable(false);
		this.setBounds(0, 0, 256, 351);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0,0, 250, 322);
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLACK);
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255))));

		getContentPane().add(panel);
		panel.setLayout(null);

	/// TEXT INPUT ///	
		boule1 = new JTextField();
		boule1.setBounds(92, 24, 134, 20);
		panel.add(boule1);
		boule1.setColumns(10);

		boule2 = new JTextField();
		boule2.setColumns(10);
		boule2.setBounds(92, 52, 134, 20);
		panel.add(boule2);

		boule3 = new JTextField();
		boule3.setColumns(10);
		boule3.setBounds(92, 83, 134, 20);
		panel.add(boule3);

		boule4 = new JTextField();
		boule4.setColumns(10);
		boule4.setBounds(92, 114, 134, 20);
		panel.add(boule4);

		boule5 = new JTextField();
		boule5.setBounds(92, 145, 134, 20);
		panel.add(boule5);
		boule5.setColumns(10);

		etoile1 = new JTextField();
		etoile1.setBounds(92, 196, 134, 20);
		panel.add(etoile1);
		etoile1.setColumns(10);

		etoile2 = new JTextField();
		etoile2.setBounds(92, 228, 134, 20);
		panel.add(etoile2);
		etoile2.setColumns(10);

	/// LABELS ///
		JLabel lblB = new JLabel("B1 :");
		lblB.setForeground(Color.WHITE);
		lblB.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblB.setBounds(24, 26, 32, 14);
		panel.add(lblB);

		JLabel lblB_1 = new JLabel("B2 :");
		lblB_1.setForeground(Color.WHITE);
		lblB_1.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblB_1.setBounds(24, 54, 32, 14);
		panel.add(lblB_1);

		JLabel lblB_2 = new JLabel("B3 :");
		lblB_2.setForeground(Color.WHITE);
		lblB_2.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblB_2.setBounds(24, 85, 32, 14);
		panel.add(lblB_2);

		JLabel lblB_3 = new JLabel("B4 :");
		lblB_3.setForeground(Color.WHITE);
		lblB_3.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblB_3.setBounds(24, 116, 32, 14);
		panel.add(lblB_3);

		JLabel lblB_4 = new JLabel("B5 :");
		lblB_4.setForeground(Color.WHITE);
		lblB_4.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblB_4.setBounds(24, 147, 32, 14);
		panel.add(lblB_4);

		JLabel lblE = new JLabel("E1 :");
		lblE.setForeground(Color.WHITE);
		lblE.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblE.setBounds(24, 198, 32, 14);
		panel.add(lblE);

		JLabel lblE_1 = new JLabel("E2 :");
		lblE_1.setForeground(Color.WHITE);
		lblE_1.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		lblE_1.setBounds(24, 230, 32, 14);
		panel.add(lblE_1);

	/// BUTTONS ///	
		JButton btnNewButton = new JButton(new GenerateWithCSV(LANGUAGE.GENERATE.getSelectedLanguage()));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("OCR A Extended", Font.BOLD, 11));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(128, 288, 112, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton(new CancelAction(LANGUAGE.CANCEL.getSelectedLanguage()));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setFont(new Font("OCR A Extended", Font.BOLD, 11));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(10, 288, 112, 23);
		panel.add(btnNewButton_1);
	}

	
	private class GenerateWithCSV extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		private TirageToFractaleConverter converter;

		public GenerateWithCSV(String string) {
			super(string);
		}

		/**
		 * 
		 * Cette méthode vérifie les entrées de l'utilisateur 
		 * et lance une nouvelle fenetre contenant la fractale
		 * de Julia correspondant au tirage 
		 *
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			List<Tirage> tirages = new ArrayList<Tirage>();
			int b1 = 0, b2 = 0, b3 = 0, b4 = 0, b5 = 0, e1 = 0, e2 = 0;
			try {
				b1 = new Integer(boule1.getText());
				b2 = new Integer(boule2.getText());
				b3 = new Integer(boule3.getText());
				b4 = new Integer(boule4.getText());
				b5 = new Integer(boule5.getText());
				e1 = new Integer(etoile1.getText());
				e2 = new Integer(etoile2.getText());
			}catch(NumberFormatException exception) {
				JOptionPane.showMessageDialog(null,
						LANGUAGE.MANUAL_CHOICE_EMPTY.getSelectedLanguage());
				return;
			}
			
			
			int boules[] = {new Integer(b1),new Integer(b2),new Integer(b3),new Integer(b4),new Integer(b5)};
			int etoiles[] = {new Integer(e1),new Integer(e2)};			
		
			try {
				verifFormat(boules,etoiles);
			}catch(NumberFormatException except) {
				JOptionPane.showMessageDialog(null,
						LANGUAGE.MANUAL_CHOICE_ERROR.getSelectedLanguage());
				return;
			}
			
			//on les trie
			Arrays.sort(boules);
			Arrays.sort(etoiles);
			
			tirage.setB1(b1);
			tirage.setB2(b2);
			tirage.setB3(b3);
			tirage.setB4(b4);
			tirage.setB5(b5);
			tirage.setE1(e1);
			tirage.setE2(e2);
	
	
			tirages.add(tirage);
	
			dispose();
	
			converter = new TirageToFractaleConverter(tirages, "Julia");
			List<Fractale> fractales = converter.convertTirageToFractale();
	
			dispose();
			new FractaleJFrame(fractales, 1070, 540);
			
		}

		private void verifFormat(int[] boules, int[] etoiles) {
			
			if(etoiles[0] == etoiles[1]) throw new NumberFormatException(); //doublons
			if(etoiles[0] < 1 || etoiles[0] > 12 || etoiles[1] < 1 || etoiles[1] > 12)  throw new NumberFormatException(); // hors des bornes
			Set<Integer> set = new HashSet<Integer>();
			
			for(int i = 0 ; i < 5 ; i++) {
				if(boules[i] > 50 || boules[i] < 1)  throw new NumberFormatException(); // hors limites
				if(set.contains(boules[i]))  throw new NumberFormatException(); // doublons
				set.add(boules[i]);
				
			}
			
		}

	}
	
	private class CancelAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public CancelAction(String string) {
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
