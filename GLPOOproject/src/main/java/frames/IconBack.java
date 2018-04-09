package frames;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class IconBack extends JLabel {
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	
	IconBack(JFrame frame){
		this.frame = frame;
		
		setIcon(new ImageIcon("C:\\Users\\bourd\\eclipse-workspace\\GLPOOproject\\src\\main\\ressources\\back_icon.png"));
		setBounds(12, 11, 57, 36);
		addMouseListener(new BackAction());
	}
	
	
	private class BackAction implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			frame.dispose();
			WelcomeJFrame f = new WelcomeJFrame();
			f.setVisible(true);}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}


	}

}
