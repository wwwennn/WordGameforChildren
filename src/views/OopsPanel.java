package views;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represents the page when review list is called but there are no words in the review list
 * @author YoonKim
 *
 */
public class OopsPanel extends JPanel{
	Image backgroundImage;
	JButton playGame, homePage, lessonMenu;
	JLabel text; 

	/**
	 * This is the constructor for the class
	 * @param image
	 * @throws IOException
	 */
	public OopsPanel(Image image) throws IOException {
		backgroundImage = image;
		initLabelsAndButtons();
		mouseControl();
		setLayout(null);
		this.addKeyListener(InitFrame.game);
	}
	
	
	/**
	 * This class initializes all the buttons and labels 
	 * The page gives options from the main menu except for reviewing words
	 * @throws IOException
	 */
	private void initLabelsAndButtons() throws IOException {
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		Image image;

//		text = new JLabel("Oops, there are no words in the review list yet!");
//		add(text);
//		text.setBounds(450, 250, 800, 100);
//		text.setFont(new Font("calibri", Font.PLAIN, 24));
		
		image = getImage("homepage");
		homePage = new JButton(new ImageIcon(image));
		setButton(homePage);
		//homePage.setBounds(530, 370, 250, 80);
		homePage.setBounds((int) (w*0.21), (int)(h*0.32), (int) (w*0.3), (int) (h*0.08));
		
		
		image = getImage("playGames");
		playGame = new JButton(new ImageIcon(image));
		setButton(playGame);
		//playGame.setBounds(530, 470, 250, 80);
		playGame.setBounds((int) (w*0.21), (int)(h*0.42), (int) (w*0.3), (int) (h*0.08));
		
		image = getImage("watchLessons");
		lessonMenu = new JButton(new ImageIcon(image));
		setButton(lessonMenu);
		//lessonMenu.setBounds(530, 570, 250, 80);
		lessonMenu.setBounds((int) (w*0.21), (int)(h*0.52), (int) (w*0.3), (int) (h*0.08));
		
	}
	
	/**
	 * helper method to retrieve and set image
	 * @param imageName
	 * @return formatted image
	 * @throws IOException
	 */
	private Image getImage (String imageName) throws IOException {
		Image image = ImageIO.read(new File("images/dash/"+imageName+".jpg"));
		Image scaledImage= image.getScaledInstance( 250, 80,  java.awt.Image.SCALE_SMOOTH ) ;
		return scaledImage;
	}
	
	/**
	 * helper method to set buttons
	 * @param button
	 * @throws IOException
	 */
	private void setButton(JButton button) throws IOException {
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		add(button);
	}

	
	/**
	 * set background image
	 */
	public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
     }

	
	/**
	 * This method deals with all the mouse control in the panel
	 */
	private void mouseControl() {

		playGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
				//InitFrame.game.setVisible(true);
				InitFrame.mainLayout.show(getParent(), "game");
				InitFrame.t.resume();
			}
		});	
		
		homePage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				InitFrame.main.setVisible(true);
				InitFrame.mainLayout.show(getParent(), "main");
			}
		});	
		
		lessonMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				InitFrame.lessonMenu.setVisible(true);
				InitFrame.mainLayout.show(getParent(), "lessonMenu");
			}
		});	
		
	}

}
