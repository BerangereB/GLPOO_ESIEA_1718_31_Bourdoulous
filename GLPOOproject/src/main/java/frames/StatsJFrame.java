package frames;


import javax.swing.JFrame;

import options.LANGUAGE;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import stats.*;

public class StatsJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	Stats stat = new Stats("src//main//ressources//euromillions_4.csv");

	public StatsJFrame() {
		getContentPane().setBackground(Color.DARK_GRAY);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		this.setTitle(LANGUAGE.STATS_TITLE.getSelectedLanguage());
		this.setResizable(false);
		this.setBounds(0, 0, 909, 854);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		JLabel iconBack = new IconBack(this);
		getContentPane().add(iconBack);

		JLabel lblCredits = new JLabel("Stats");
		lblCredits.setFont(new Font("OCR A Extended", Font.PLAIN, 28));
		lblCredits.setForeground(Color.white);
		lblCredits.setBounds(385, 13, 92, 68);
		getContentPane().add(lblCredits);

		//////////////////////////////////// affichage des moyennes par boules

		JLabel lblMoy = new JLabel(LANGUAGE.MOY.getSelectedLanguage());
		lblMoy.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblMoy.setForeground(Color.WHITE);
		lblMoy.setBounds(50, 134, 300, 36);
		getContentPane().add(lblMoy);

	//////B1
		JLabel label1 = new JLabel("B1");
		label1.setForeground(Color.RED);
		label1.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label1.setBounds(120, 173, 92, 36);
		getContentPane().add(label1);

		JLabel labelav1 = new JLabel(stat.getAvB1());
		labelav1.setForeground(Color.WHITE);
		labelav1.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelav1.setBounds(120, 190, 92, 22);
		getContentPane().add(labelav1);

	////B2	
		JLabel label2 = new JLabel("B2");
		label2.setForeground(Color.GREEN);
		label2.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label2.setBounds(220, 173, 92, 36);
		getContentPane().add(label2);

		JLabel labelav2 = new JLabel(stat.getAvB2());
		labelav2.setForeground(Color.WHITE);
		labelav2.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelav2.setBounds(220, 190, 92, 22);
		getContentPane().add(labelav2);

	////B3	
		JLabel label3 = new JLabel("B3");
		label3.setForeground(Color.BLUE);
		label3.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label3.setBounds(320, 173, 92, 36);
		getContentPane().add(label3);

		JLabel labelav3 = new JLabel(stat.getAvB3());
		labelav3.setForeground(Color.WHITE);
		labelav3.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelav3.setBounds(320, 190, 92, 22);
		getContentPane().add(labelav3);

		
	///B4	
		JLabel label4 = new JLabel("B4");
		label4.setForeground(Color.YELLOW);
		label4.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label4.setBounds(420, 173,92, 36);
		getContentPane().add(label4);

		JLabel labelav4 = new JLabel(stat.getAvB4());
		labelav4.setForeground(Color.WHITE);
		labelav4.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelav4.setBounds(420, 190, 92, 22);
		getContentPane().add(labelav4);

	///B5	
		JLabel label5 = new JLabel("B5");
		label5.setForeground(Color.PINK);
		label5.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label5.setBounds(520, 173, 92, 36);
		getContentPane().add(label5);

		JLabel labelav5 = new JLabel(stat.getAvB5());
		labelav5.setForeground(Color.WHITE);
		labelav5.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelav5.setBounds(520, 190, 92, 22);
		getContentPane().add(labelav5);
		
		///E1	
				JLabel label6 = new JLabel("E1");
				label6.setForeground(Color.RED);
				label6.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
				label6.setBounds(650, 173, 92, 36);
				getContentPane().add(label6);

				JLabel labelav6 = new JLabel(stat.getAvE1());
				labelav6.setForeground(Color.WHITE);
				labelav6.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				labelav6.setBounds(650, 190, 92, 22);
				getContentPane().add(labelav6);

			///E2	
				JLabel label7 = new JLabel("E2");
				label7.setForeground(Color.GREEN);
				label7.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
				label7.setBounds(750, 173, 92, 36);
				getContentPane().add(label7);

				JLabel labelav7 = new JLabel(stat.getAvE2());
				labelav7.setForeground(Color.WHITE);
				labelav7.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				labelav7.setBounds(750, 190, 92, 22);
				getContentPane().add(labelav7);

		
		//////////////////////////////////// mediane par boule

		JLabel lblmed = new JLabel(LANGUAGE.MED.getSelectedLanguage());
		lblmed.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblmed.setForeground(Color.WHITE);
		lblmed.setBounds(50, 250, 500, 36);
		getContentPane().add(lblmed);
	
	///B1
		JLabel label12 = new JLabel("B1");
		label12.setForeground(Color.RED);
		label12.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label12.setBounds(120, 280, 300, 36);
		getContentPane().add(label12);

		JLabel labelmed1 = new JLabel(stat.getMedB1());
		labelmed1.setForeground(Color.WHITE);
		labelmed1.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelmed1.setBounds(120, 300, 178, 22);
		getContentPane().add(labelmed1);

	///B2
		JLabel label22 = new JLabel("B2");
		label22.setForeground(Color.GREEN);
		label22.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label22.setBounds(220, 280, 380, 36);
		getContentPane().add(label22);

		JLabel labelmed2 = new JLabel(stat.getMedB2());
		labelmed2.setForeground(Color.WHITE);
		labelmed2.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelmed2.setBounds(220, 300, 178, 22);
		getContentPane().add(labelmed2);

	///B3
		JLabel label32 = new JLabel("B3");
		label32.setForeground(Color.BLUE);
		label32.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label32.setBounds(320, 280, 300, 36);
		getContentPane().add(label32);

		JLabel labelmed3 = new JLabel(stat.getMedB3());
		labelmed3.setForeground(Color.WHITE);
		labelmed3.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelmed3.setBounds(320, 300, 178, 22);
		getContentPane().add(labelmed3);

	///B4
		JLabel label42 = new JLabel("B4");
		label42.setForeground(Color.YELLOW);
		label42.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label42.setBounds(420, 280, 300, 36);
		getContentPane().add(label42);

		JLabel labelmed4 = new JLabel(stat.getMedB4());
		labelmed4.setForeground(Color.WHITE);
		labelmed4.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelmed4.setBounds(420, 300, 178, 22);
		getContentPane().add(labelmed4);

	///B5
		JLabel label52 = new JLabel("B5");
		label52.setForeground(Color.PINK);
		label52.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label52.setBounds(520, 280, 300, 36);
		getContentPane().add(label52);

		JLabel labelmed5 = new JLabel(stat.getMedB5());
		labelmed5.setForeground(Color.WHITE);
		labelmed5.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelmed5.setBounds(520, 300, 178, 22);
		getContentPane().add(labelmed5);
		
		///E1
				JLabel label62 = new JLabel("E1");
				label62.setForeground(Color.RED);
				label62.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
				label62.setBounds(650, 280, 300, 36);
				getContentPane().add(label62);

				JLabel labelmed6 = new JLabel(stat.getMedE1());
				labelmed6.setForeground(Color.WHITE);
				labelmed6.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				labelmed6.setBounds(650, 300, 178, 22);
				getContentPane().add(labelmed6);

			///E2
				JLabel label72 = new JLabel("E2");
				label72.setForeground(Color.GREEN);
				label72.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
				label72.setBounds(750, 280, 300, 36);
				getContentPane().add(label72);

				JLabel labelmed7 = new JLabel(stat.getMedE2());
				labelmed7.setForeground(Color.WHITE);
				labelmed7.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				labelmed7.setBounds(750, 300, 178, 22);
				getContentPane().add(labelmed7);

		////////// variance par boule

		JLabel lblvar = new JLabel(LANGUAGE.VAR.getSelectedLanguage());
		lblvar.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblvar.setForeground(Color.WHITE);
		lblvar.setBounds(50, 350, 500, 36);
		getContentPane().add(lblvar);

	///B1
		JLabel label13 = new JLabel("B1");
		label13.setForeground(Color.RED);
		label13.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label13.setBounds(120, 380, 300, 36);
		getContentPane().add(label13);

		JLabel labelvar1 = new JLabel(stat.getVarB1());
		labelvar1.setForeground(Color.WHITE);
		labelvar1.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelvar1.setBounds(120, 400, 178, 22);
		getContentPane().add(labelvar1);

	///B2
		JLabel label23 = new JLabel("B2");
		label23.setForeground(Color.GREEN);
		label23.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label23.setBounds(220, 380, 380, 36);
		getContentPane().add(label23);

		JLabel labelvar21 = new JLabel(stat.getVarB2());
		labelvar21.setForeground(Color.WHITE);
		labelvar21.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelvar21.setBounds(220, 400, 178, 22);
		getContentPane().add(labelvar21);

	///B3
		JLabel label33 = new JLabel("B3");
		label33.setForeground(Color.BLUE);
		label33.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label33.setBounds(320, 380, 300, 36);
		getContentPane().add(label33);

		JLabel labelvar3 = new JLabel(stat.getVarB3());
		labelvar3.setForeground(Color.WHITE);
		labelvar3.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelvar3.setBounds(320, 400, 178, 22);
		getContentPane().add(labelvar3);

	///B4
		JLabel label43 = new JLabel("B4");
		label43.setForeground(Color.YELLOW);
		label43.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label43.setBounds(420, 380, 300, 36);
		getContentPane().add(label43);

		JLabel labelvar4 = new JLabel(stat.getVarB4());
		labelvar4.setForeground(Color.WHITE);
		labelvar4.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelvar4.setBounds(420, 400, 178, 22);
		getContentPane().add(labelvar4);

	///B5
		JLabel label53 = new JLabel("B5");
		label53.setForeground(Color.PINK);
		label53.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label53.setBounds(520, 380, 300, 36);
		getContentPane().add(label53);

		JLabel labelvar5 = new JLabel(stat.getVarB5());
		labelvar5.setForeground(Color.WHITE);
		labelvar5.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelvar5.setBounds(520, 400, 178, 22);
		getContentPane().add(labelvar5);
		
		///E1
				JLabel label63 = new JLabel("E1");
				label63.setForeground(Color.RED);
				label63.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
				label63.setBounds(650, 380, 300, 36);
				getContentPane().add(label63);

				JLabel labelvar6 = new JLabel(stat.getVarE1());
				labelvar6.setForeground(Color.WHITE);
				labelvar6.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				labelvar6.setBounds(650, 400, 178, 22);
				getContentPane().add(labelvar6);

			///E2
				JLabel label73 = new JLabel("E2");
				label73.setForeground(Color.GREEN);
				label73.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
				label73.setBounds(750, 380, 300, 36);
				getContentPane().add(label73);

				JLabel labelvar7 = new JLabel(stat.getVarE2());
				labelvar7.setForeground(Color.WHITE);
				labelvar7.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				labelvar7.setBounds(750, 400, 178, 22);
				getContentPane().add(labelvar7);

		////////// ecart-type par boule

		JLabel lblecart = new JLabel(LANGUAGE.ECART.getSelectedLanguage());
		lblecart.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblecart.setForeground(Color.WHITE);
		lblecart.setBounds(50, 450, 500, 36);
		getContentPane().add(lblecart);

	///B1
		JLabel label14 = new JLabel("B1");
		label14.setForeground(Color.RED);
		label14.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label14.setBounds(120, 480, 300, 36);
		getContentPane().add(label14);

		JLabel labelecart1 = new JLabel(stat.getEcartB1());
		labelecart1.setForeground(Color.WHITE);
		labelecart1.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelecart1.setBounds(120, 500, 178, 22);
		getContentPane().add(labelecart1);

	///B2
		JLabel label24 = new JLabel("B2");
		label24.setForeground(Color.GREEN);
		label24.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label24.setBounds(220, 480, 380, 36);
		getContentPane().add(label24);

		JLabel labelecart21 = new JLabel(stat.getEcartB2());
		labelecart21.setForeground(Color.WHITE);
		labelecart21.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelecart21.setBounds(220, 500, 178, 22);
		getContentPane().add(labelecart21);

	///B3
		JLabel label34 = new JLabel("B3");
		label34.setForeground(Color.BLUE);
		label34.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label34.setBounds(320, 480, 300, 36);
		getContentPane().add(label34);

		JLabel labelecart3 = new JLabel(stat.getEcartB3());
		labelecart3.setForeground(Color.WHITE);
		labelecart3.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelecart3.setBounds(320, 500, 178, 22);
		getContentPane().add(labelecart3);

	///B4
		JLabel label44 = new JLabel("B4");
		label44.setForeground(Color.YELLOW);
		label44.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label44.setBounds(420, 480, 300, 36);
		getContentPane().add(label44);

		JLabel labelecart4 = new JLabel(stat.getEcartB4());
		labelecart4.setForeground(Color.WHITE);
		labelecart4.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelecart4.setBounds(420, 500, 178, 22);
		getContentPane().add(labelecart4);

	///B5
		JLabel label54 = new JLabel("B5");
		label54.setForeground(Color.PINK);
		label54.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label54.setBounds(520, 480, 300, 36);
		getContentPane().add(label54);

		JLabel labelecart5 = new JLabel(stat.getEcartB5());
		labelecart5.setForeground(Color.WHITE);
		labelecart5.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelecart5.setBounds(520, 500, 178, 22);
		getContentPane().add(labelecart5);
		
		///E1
				JLabel label64 = new JLabel("E1");
				label64.setForeground(Color.RED);
				label64.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
				label64.setBounds(650, 480, 300, 36);
				getContentPane().add(label64);

				JLabel labelecart6 = new JLabel(stat.getEcartE1());
				labelecart6.setForeground(Color.WHITE);
				labelecart6.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				labelecart6.setBounds(650, 500, 178, 22);
				getContentPane().add(labelecart6);

			///E2
				JLabel label74 = new JLabel("E2");
				label74.setForeground(Color.GREEN);
				label74.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
				label74.setBounds(750, 480, 300, 36);
				getContentPane().add(label74);

				JLabel labelecart7 = new JLabel(stat.getEcartE2());
				labelecart7.setForeground(Color.WHITE);
				labelecart7.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				labelecart7.setBounds(750, 500, 178, 22);
				getContentPane().add(labelecart7);
				
				
		/////////////////////////////////////////////////////// nombre qui sort
		/////////////////////////////////////////////////////// le plus sur
		/////////////////////////////////////////////////////// l'ensemble des
		/////////////////////////////////////////////////////// tirages par
		/////////////////////////////////////////////////////// boule
		
		JLabel lblplus = new JLabel(LANGUAGE.NBPLUS.getSelectedLanguage());
		lblplus.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lblplus.setForeground(Color.WHITE);
		lblplus.setBounds(50, 550, 500, 36);
		getContentPane().add(lblplus);
		
		///B1	
		JLabel label11 = new JLabel("B1");
		label11.setForeground(Color.RED);
		label11.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label11.setBounds(120, 580, 92, 36);
		getContentPane().add(label11);
		
		JLabel labelplus1 = new JLabel(stat.getPlusParuB1());
		labelplus1.setForeground(Color.WHITE);
		labelplus1.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelplus1.setBounds(120, 608, 92, 44);
		getContentPane().add(labelplus1);
		
		///B2	
		JLabel label21 = new JLabel("B2");
		label21.setForeground(Color.GREEN);
		label21.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label21.setBounds(220, 580, 300, 36);
		getContentPane().add(label21);
		
		JLabel labelplus2 = new JLabel(stat.getPlusParuB2());
		labelplus2.setForeground(Color.WHITE);
		labelplus2.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelplus2.setBounds(220, 608, 92, 44);
		getContentPane().add(labelplus2);
		
		///B3	
		JLabel label31 = new JLabel("B3");
		label31.setForeground(Color.BLUE);
		label31.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label31.setBounds(320, 580, 300, 36);
		getContentPane().add(label31);
		
		JLabel labelplus3 = new JLabel(stat.getPlusParuB3());
		labelplus3.setForeground(Color.WHITE);
		labelplus3.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelplus3.setBounds(320, 608, 92, 44);
		getContentPane().add(labelplus3);
		
		///B4	
		JLabel label41 = new JLabel("B4");
		label41.setForeground(Color.YELLOW);
		label41.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label41.setBounds(420, 580, 300, 36);
		getContentPane().add(label41);
		
		JLabel labelplus4 = new JLabel(stat.getPlusParuB4());
		labelplus4.setForeground(Color.WHITE);
		labelplus4.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelplus4.setBounds(416, 608, 82, 44);
		getContentPane().add(labelplus4);
		
		///B5	
		JLabel label51 = new JLabel("B5");
		label51.setForeground(Color.PINK);
		label51.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		label51.setBounds(520, 580, 300, 36);
		getContentPane().add(label51);
		
		JLabel labelplus5 = new JLabel(stat.getPlusParuB5());
		labelplus5.setForeground(Color.WHITE);
		labelplus5.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
		labelplus5.setBounds(520, 608, 92, 44);
		getContentPane().add(labelplus5);
		
			///E1	
			JLabel label61 = new JLabel("E1");
			label61.setForeground(Color.RED);
			label61.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
			label61.setBounds(650, 580, 300, 36);
			getContentPane().add(label61);
			
			JLabel labelplus6 = new JLabel(stat.getPlusParuE1());
			labelplus6.setForeground(Color.WHITE);
			labelplus6.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
			labelplus6.setBounds(650, 608, 92, 44);
			getContentPane().add(labelplus6);
			
			///E2	
			JLabel label71 = new JLabel("E2");
			label71.setForeground(Color.GREEN);
			label71.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
			label71.setBounds(750, 580, 300, 36);
			getContentPane().add(label71);
			
			JLabel labelplus7 = new JLabel(stat.getPlusParuE2());
			labelplus7.setForeground(Color.WHITE);
			labelplus7.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
			labelplus7.setBounds(750, 608, 92, 44);
			getContentPane().add(labelplus7);
			
			/////////////////////////////////////////////////////// nombre qui sort
			/////////////////////////////////////////////////////// le moins sur
			/////////////////////////////////////////////////////// l'ensemble des
			/////////////////////////////////////////////////////// tirages par
			/////////////////////////////////////////////////////// boule
			
			JLabel lblmoins = new JLabel(LANGUAGE.NBMOINS.getSelectedLanguage());
			lblmoins.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
			lblmoins.setForeground(Color.WHITE);
			lblmoins.setBounds(50, 650, 500, 36);
			getContentPane().add(lblmoins);
			
			///B1	
			JLabel label10 = new JLabel("B1");
			label10.setForeground(Color.RED);
			label10.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
			label10.setBounds(120, 680, 92, 36);
			getContentPane().add(label10);
			
			JLabel labelmoins1 = new JLabel(stat.getMinB1());
			labelmoins1.setForeground(Color.WHITE);
			labelmoins1.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
			labelmoins1.setBounds(120, 710, 92, 56);
			getContentPane().add(labelmoins1);
			
			///B2	
			JLabel label20 = new JLabel("B2");
			label20.setForeground(Color.GREEN);
			label20.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
			label20.setBounds(220, 680, 300, 36);
			getContentPane().add(label20);
			
			JLabel labelmoins2 = new JLabel(stat.getMinB2());
			labelmoins2.setForeground(Color.WHITE);
			labelmoins2.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
			labelmoins2.setBounds(220, 710, 92, 56);
			getContentPane().add(labelmoins2);
			
			///B3	
			JLabel label30 = new JLabel("B3");
			label30.setForeground(Color.BLUE);
			label30.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
			label30.setBounds(320, 680, 300, 36);
			getContentPane().add(label30);
			
			JLabel labelmoins3 = new JLabel(stat.getMinB3());
			labelmoins3.setForeground(Color.WHITE);
			labelmoins3.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
			labelmoins3.setBounds(320, 710, 92, 56);
			getContentPane().add(labelmoins3);
			
			///B4	
			JLabel label40 = new JLabel("B4");
			label40.setForeground(Color.YELLOW);
			label40.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
			label40.setBounds(420, 680, 300, 36);
			getContentPane().add(label40);
			
			JLabel labelmoins4 = new JLabel(stat.getMinB4());
			labelmoins4.setForeground(Color.WHITE);
			labelmoins4.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
			labelmoins4.setBounds(420, 710, 87, 56);
			getContentPane().add(labelmoins4);
			
			///B5	
			JLabel label50 = new JLabel("B5");
			label50.setForeground(Color.PINK);
			label50.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
			label50.setBounds(520, 680, 300, 36);
			getContentPane().add(label50);
			
			JLabel labelmoins5 = new JLabel(stat.getMinB5());
			labelmoins5.setForeground(Color.WHITE);
			labelmoins5.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
			labelmoins5.setBounds(520, 710, 92, 56);
			getContentPane().add(labelmoins5);
			
				///E1	
				JLabel label60 = new JLabel("E1");
				label60.setForeground(Color.RED);
				label60.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
				label60.setBounds(650, 680, 300, 36);
				getContentPane().add(label60);
				
				JLabel labelmoins6 = new JLabel(stat.getMinE1());
				labelmoins6.setForeground(Color.WHITE);
				labelmoins6.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				labelmoins6.setBounds(650, 710, 82, 56);
				getContentPane().add(labelmoins6);
				
				///E2	
				JLabel label70 = new JLabel("E2");
				label70.setForeground(Color.GREEN);
				label70.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
				label70.setBounds(750, 680, 300, 36);
				getContentPane().add(label70);
				
				JLabel labelmoins7 = new JLabel(stat.getMinE2());
				labelmoins7.setForeground(Color.WHITE);
				labelmoins7.setFont(new Font("OCR A Extended", Font.PLAIN, 11));
				labelmoins7.setBounds(750, 710, 92, 56);
				getContentPane().add(labelmoins7);

		
	}

	
}
