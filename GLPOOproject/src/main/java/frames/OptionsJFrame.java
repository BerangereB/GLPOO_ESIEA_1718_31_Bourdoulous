package frames;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;

import org.apache.log4j.Logger;

import options.LANGUAGE;

import javax.swing.JButton;

public class OptionsJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final Logger LOGGER = Logger.getLogger(OptionsJFrame.class);
	
	public static int languageSelected = 0; //0 = francais ; 1 = anglais
	
	public OptionsJFrame() {
		initialize();
	}
	
	private void initialize() {
		this.setTitle("EuroProject");
		this.setResizable(false);
		this.setBounds(0,0,1068,563);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 215, 535);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setPreferredSize(new Dimension(1063, 535));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLangue = new JLabel(LANGUAGE.LANGUE.getSelectedLanguage());
		lblLangue.setBounds(10, 145, 112, 20);
		panel_1.add(lblLangue);
		lblLangue.setForeground(Color.WHITE);
		lblLangue.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("English", radioSelected("english"));
		rdbtnNewRadioButton_1.setBounds(114, 169, 75, 21);
		panel_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Français", radioSelected("french"));
		rdbtnNewRadioButton.setBounds(114, 144, 81, 21);
		panel_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		rdbtnNewRadioButton.setEnabled(true);
		
		ButtonGroup bg = new ButtonGroup(); //pour qu'un seul puisse etre sélectionné à la fois
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setBounds(52, 42, 112, 26);
		panel_1.add(lblOptions);
		lblOptions.setForeground(Color.WHITE);
		lblOptions.setFont(new Font("OCR A Extended", Font.BOLD, 24));
		
		JButton btnNewButton = new JButton(new OptionSaveAction(LANGUAGE.SAVE.getSelectedLanguage(), rdbtnNewRadioButton, rdbtnNewRadioButton_1));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(102, 459, 107, 23);
		panel_1.add(btnNewButton);
		
		JButton btnAnnuler = new JButton(new BackAction(LANGUAGE.CANCEL.getSelectedLanguage()));
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(Color.BLACK);
		btnAnnuler.setBounds(5, 459, 89, 23);
		panel_1.add(btnAnnuler);
		
		JPanel panel = new JPanel();
		panel.setBounds(90, 11,962, 512);
		getContentPane().add(panel);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(-24, 0, 986, 522);
		panel.add(label);
		label.setIcon(new ImageIcon("src\\main\\ressources\\Accueil1.jfif"));
		
	}
	
	//coche la langue active a l'ouverture des options
	private boolean radioSelected(String string) {
		final boolean selected;
		if(languageSelected == 0 && string == "french") {
			selected = true;
		}
		else if(languageSelected == 1 && string == "english") {
			selected = true;
		}
		else {
			selected = false;
		}
		return selected;
	}
	
	private class BackAction extends AbstractAction{
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
	
	private class OptionSaveAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		JRadioButton b1;
		JRadioButton b2;
		
		public OptionSaveAction(String string, JRadioButton b1, JRadioButton b2) {
			super(string);
			this.b1=b1;
			this.b2=b2;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(b1.isSelected() == true) {
				languageSelected = 0;			
			}
			else if(b2.isSelected() == true) {
				languageSelected = 1;
			}
			else {
				LOGGER.error("Pas de boutton selectionné");
			}
			dispose();
			WelcomeJFrame f = new WelcomeJFrame();
			f.setVisible(true);
		}
		
	}
}
