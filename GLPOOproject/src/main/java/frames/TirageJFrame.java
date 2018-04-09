package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.apache.log4j.Logger;

import model.*;
import options.LANGUAGE;
import dao.*;
import fractales.Fractale;
import fractales.TirageToFractaleConverter;
import java.awt.FlowLayout;

public class TirageJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Logger LOGGER = Logger.getLogger(TirageJFrame.class);
	private ModeleDynamique modele = new ModeleDynamique();
	private final JTable tableau = new JTable(modele);
			

	public TirageJFrame() {

		super();
		setTitle("Liste des tirages");
		setPreferredSize(new Dimension(1070, 540));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		tableau.setBackground(Color.DARK_GRAY);
		tableau.setForeground(Color.WHITE);
		tableau.setRowHeight(25);
		tableau.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.BLACK);
		
		JButton back_button = new JButton(new BackAction(LANGUAGE.BACK.getSelectedLanguage()));
		back_button.setBackground(Color.BLACK);
		back_button.setForeground(Color.WHITE);

		JButton button_julia = new JButton(new GenerateWithCSV("Julia"));
		button_julia.setBackground(Color.BLACK);
		button_julia.setForeground(Color.WHITE);

		JButton button_newton = new JButton(new GenerateWithCSV("Newton"));
		button_newton.setBackground(Color.BLACK);
		button_newton.setForeground(Color.WHITE);
		
		JButton button_householder = new JButton(new GenerateWithCSV("Householder"));
		button_householder.setBackground(Color.BLACK);
		button_householder.setForeground(Color.WHITE);
		
		JButton button_halley = new JButton(new GenerateWithCSV("Halley"));
		button_halley.setBackground(Color.BLACK);
		button_halley.setForeground(Color.WHITE);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		buttonPane.add(back_button);
		buttonPane.add(button_julia);
		buttonPane.add(button_newton);
		buttonPane.add(button_householder);
		buttonPane.add(button_halley);

		
		
		pack();
		setLocationRelativeTo(null);
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

	private class GenerateWithCSV extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		private TirageToFractaleConverter converter;
		
		private String string;

		private GenerateWithCSV(String string) {
			super(LANGUAGE.GENERATE_FRACTAL.getSelectedLanguage()+string);
			this.string = string;
		}

		public void actionPerformed(ActionEvent e) {
			if (tableau.getSelectedRow() > -1) {
				
				LOGGER.debug("Tirages séléctionné : ");
	
				List<Tirage> tirages = new ArrayList<Tirage>();
	
				final int[] selection = tableau.getSelectedRows();
	
				if(selection.length < 4) {
					for (int i = selection.length - 1; i >= 0; i--) {
						Tirage tirage = modele.rowToTirage(selection[i]);
						tirages.add(tirage);
					}
	
					dispose();
					converter = new TirageToFractaleConverter(tirages, string);
					
					
					List<Fractale> fractales = converter.convertTirageToFractale();
	
					new FractaleJFrame(fractales,1070, 540 );
					
					
				}else {
					LOGGER.info("Trop de tirages selectionnés!");
					
					JOptionPane.showMessageDialog(null,
							LANGUAGE.TOO_MANY_SLT.getSelectedLanguage());
				}
			} else {
				LOGGER.info("Aucun tirage séléctionné !");
			}
		}
	}
	
	
}
