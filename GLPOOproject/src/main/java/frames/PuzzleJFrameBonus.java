package frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PuzzleJFrameBonus extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	int counter = 0;
	JLabel labelEditCounter;
	
	
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, sample;
	Icon star;
	Icon ic0 = new ImageIcon("src/main/ressources/3.jpg"); //la taille de "src/main/ressources/starB0.jpg" n'est pas suffisament grande
	Icon ic10 = new ImageIcon("src/main/ressources/starB10.jpg");
	Icon ic20 = new ImageIcon("src/main/ressources/starB20.jpg");
	Icon samicon1 = new ImageIcon("src/main/ressources/main.jpg");
	Icon samicon2 = new ImageIcon("src/main/ressources/main2.jpg");
	Icon samicon3 = new ImageIcon("src/main/ressources/main3.jpg");
	//Puzzle one
	Icon ic1 = new ImageIcon("src/main/ressources/1.jpg");
	Icon ic2 = new ImageIcon("src/main/ressources/5.jpg");
	Icon ic3 = new ImageIcon("src/main/ressources/2.jpg");
	Icon ic4 = new ImageIcon("src/main/ressources/7.jpg");
	Icon ic5 = new ImageIcon("src/main/ressources/4.jpg");
	Icon ic6 = new ImageIcon("src/main/ressources/6.jpg");
	Icon ic7 = new ImageIcon("src/main/ressources/8.jpg");
	Icon ic8 = new ImageIcon("src/main/ressources/9.jpg");
	Icon ic9 = new ImageIcon("src/main/ressources/3.jpg");
	
	//Puzzle two
	Icon ic11 = new ImageIcon("src/main/ressources/12.jpg");
	Icon ic12 = new ImageIcon("src/main/ressources/13.jpg");
	Icon ic13 = new ImageIcon("src/main/ressources/16.jpg");
	Icon ic14 = new ImageIcon("src/main/ressources/11.jpg");
	Icon ic15 = new ImageIcon("src/main/ressources/14.jpg");
	Icon ic16 = new ImageIcon("src/main/ressources/19.jpg");
	Icon ic17 = new ImageIcon("src/main/ressources/17.jpg");
	Icon ic18 = new ImageIcon("src/main/ressources/15.jpg");
	Icon ic19 = new ImageIcon("src/main/ressources/18.jpg");

	//Puzzle three
//Puzzle three
	Icon ic21 = new ImageIcon("src/main/ressources/24.jpg");
	Icon ic22 = new ImageIcon("src/main/ressources/25.jpg");
	Icon ic23 = new ImageIcon("src/main/ressources/21.jpg");
	Icon ic24 = new ImageIcon("src/main/ressources/27.jpg");
	Icon ic25 = new ImageIcon("src/main/ressources/23.jpg");
	Icon ic26 = new ImageIcon("src/main/ressources/29.jpg");
	Icon ic27 = new ImageIcon("src/main/ressources/28.jpg");
	Icon ic28 = new ImageIcon("src/main/ressources/22.jpg");
	Icon ic29 = new ImageIcon("src/main/ressources/26.jpg");

	public PuzzleJFrameBonus() {

		super("EuroProject : Bonus Puzzle");
		
		JLabel iconBack = new IconBack(this);
		getContentPane().add(iconBack);
		
		setResizable(false);
		b1 = new JButton(ic1);
		b1.setBounds(192, 92, 100, 100);
		b2 = new JButton(ic2);
		b2.setBounds(292, 92, 100, 100);
		b3 = new JButton(ic3);
		b3.setBounds(392, 92, 100, 100);
		b4 = new JButton(ic4);
		b4.setBounds(192, 192, 100, 100);
		b5 = new JButton(ic5);
		b5.setBounds(292, 192, 100, 100);
		b6 = new JButton(ic6);
		b6.setBounds(392, 192, 100, 100);
		b7 = new JButton(ic7);
		b7.setBounds(192, 292, 100, 100);
		b8 = new JButton(ic8);
		b8.setBounds(292, 292, 100, 100);
		b9 = new JButton(ic9);
		b9.setBounds(392, 292, 100, 100);
		sample = new JButton(samicon1);
		sample.setBounds(710, 92, 200, 200);

		JLabel l1=new JLabel("Puzzle:");  
		l1.setFont(new Font("OCR A Extended", Font.BOLD, 13));
		l1.setForeground(Color.WHITE);
		l1.setBounds(700,60,70,20);    
		JLabel l3=new JLabel("Cliquer sur le puzzle pour changer de puzzle");
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		l3.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		l3.setBounds(629,305,369,40);  
		l3.setForeground(Color.WHITE);
		star = b9.getIcon();

		getContentPane().add(b1);
		getContentPane().add(b2);
		getContentPane().add(b3);
		getContentPane().add(b4);
		getContentPane().add(b5);
		getContentPane().add(b6);
		getContentPane().add(b7);
		getContentPane().add(b8);
		getContentPane().add(b9);
		getContentPane().add(sample);
		getContentPane().add(l1);
		getContentPane().add(l3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);

		sample.addActionListener(this);
		getContentPane().setLayout(null);
		setSize(1054,573);
		setVisible(true);
		getContentPane().setBackground(Color.DARK_GRAY);
		
		
		JLabel lblCompteur = new JLabel("COMPTEUR");
		lblCompteur.setFont(new Font("OCR A Extended", Font.BOLD, 13));
		lblCompteur.setForeground(Color.WHITE);
		lblCompteur.setBounds(307, 412, 79, 16);
		getContentPane().add(lblCompteur);
		
		labelEditCounter = new JLabel("0");
		labelEditCounter.setHorizontalAlignment(SwingConstants.CENTER);
		labelEditCounter.setForeground(Color.WHITE);
		labelEditCounter.setFont(new Font("OCR A Extended", Font.ITALIC, 13));
		labelEditCounter.setBounds(317, 435, 56, 16);
		getContentPane().add(labelEditCounter);

		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == b1) {
			Icon s1 = b1.getIcon();
			if (b2.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b2.setIcon(s1);
				b1.setIcon(star);
			} else if (b4.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b4.setIcon(s1);
				b1.setIcon(star);
			}
		} // end of if

		if (e.getSource() == b2) {
			Icon s1 = b2.getIcon();
			if (b1.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b1.setIcon(s1);
				b2.setIcon(star);
			} else if (b5.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b5.setIcon(s1);
				b2.setIcon(star);
			} else if (b3.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b3.setIcon(s1);
				b2.setIcon(star);
			}
		} // end of if

		if (e.getSource() == b3) {
			Icon s1 = b3.getIcon();
			if (b2.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b2.setIcon(s1);
				b3.setIcon(star);
			} else if (b6.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b6.setIcon(s1);
				b3.setIcon(star);
			}
		} // end of if

		if (e.getSource() == b4) {
			Icon s1 = b4.getIcon();
			if (b1.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b1.setIcon(s1);
				b4.setIcon(star);
			} else if (b5.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b5.setIcon(s1);
				b4.setIcon(star);
			} else if (b7.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b7.setIcon(s1);
				b4.setIcon(star);
			}
		} // end of if

		if (e.getSource() == b5) {
			Icon s1 = b5.getIcon();
			if (b2.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b2.setIcon(s1);
				b5.setIcon(star);
			} else if (b4.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b4.setIcon(s1);
				b5.setIcon(star);
			} else if (b6.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b6.setIcon(s1);
				b5.setIcon(star);
			} else if (b8.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b8.setIcon(s1);
				b5.setIcon(star);
			}
		} // end of if

		if (e.getSource() == b6) {
			Icon s1 = b6.getIcon();
			if (b3.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b3.setIcon(s1);
				b6.setIcon(star);
			} else if (b5.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b5.setIcon(s1);
				b6.setIcon(star);
			} else if (b9.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b9.setIcon(s1);
				b6.setIcon(star);
			}
		} // end of if

		if (e.getSource() == b7) {
			Icon s1 = b7.getIcon();
			if (b4.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b4.setIcon(s1);
				b7.setIcon(star);
			} else if (b8.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b8.setIcon(s1);
				b7.setIcon(star);
			}
		} // end of if

		if (e.getSource() == b8) {
			Icon s1 = b8.getIcon();
			if (b7.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b7.setIcon(s1);
				b8.setIcon(star);
			} else if (b5.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b5.setIcon(s1);
				b8.setIcon(star);
			} else if (b9.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b9.setIcon(s1);
				b8.setIcon(star);
			}

		} // end of if

		if (e.getSource() == b9) {
			Icon s1 = b9.getIcon();
			if (b8.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b8.setIcon(s1);
				b9.setIcon(star);
			} else if (b6.getIcon() == star) {
				counter++;
				labelEditCounter.setText(counter+"");
				b6.setIcon(s1);
				b9.setIcon(star);
			}
		} // end of if

		if (e.getSource() == sample) {
			counter = 0;
			labelEditCounter.setText(counter+"");
			
			Icon s1 = sample.getIcon();
			if (s1 == samicon3) {
				sample.setIcon(samicon1);
				b1.setIcon(ic1);
				b2.setIcon(ic2);
				b3.setIcon(ic3);
				b4.setIcon(ic4);
				b5.setIcon(ic5);
				b6.setIcon(ic6);
				b7.setIcon(ic7);
				b8.setIcon(ic8);
				b9.setIcon(ic9);
				star = b9.getIcon();
			} // eof if
			else if (s1 == samicon1) {
				sample.setIcon(samicon2);
				b1.setIcon(ic11);
				b2.setIcon(ic12);
				b3.setIcon(ic13);
				b4.setIcon(ic14);
				b5.setIcon(ic15);
				b6.setIcon(ic16);
				b7.setIcon(ic17);
				b8.setIcon(ic18);
				b9.setIcon(ic19);
				star = b6.getIcon();
			} // eof else
			else {
				sample.setIcon(samicon3);
				b1.setIcon(ic21);
				b2.setIcon(ic22);
				b3.setIcon(ic23);
				b4.setIcon(ic24);
				b5.setIcon(ic25);
				b6.setIcon(ic26);
				b7.setIcon(ic27);
				b8.setIcon(ic28);
				b9.setIcon(ic29);
				star = b6.getIcon();
			} // eof else

		}
	}
	
}
