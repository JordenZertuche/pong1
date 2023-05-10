package edu.guilford;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


/*
 * This class creates the menu frame for the pong game. It has two buttons, one
 * for one player and one for two players. It also has a button to turn the
 * music off which is not working yet. and would be finished in the future.
 * as for the images and the background, they are not working yet and would be
 * finished in the future. as for the prgrams overall functionality, it is working interface wise nicely in a mac computer.
 */
public class MenuFrame extends JFrame {
	public static boolean mod;
	public static Color ballColor = Color.WHITE;
	private static final int frameWidth = 800;
	private static final int frameHeight = 400;
	private static Path userFile;
	BufferedImage background;
	Graphics graphics;

	/*
	 * Constructor for MenuFrame class
	 */
	MenuFrame() {
		final JLabel panel = new JLabel();
				userFile = Path.of("/menuImage.png");
				try {
					background = ImageIO.read(userFile.toFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
				/*
				 * this is the background image for the menu frame
				 * also the buttons are created here
				 */
		this.setTitle("PONG GAME MENU");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(frameWidth, frameHeight);

		/*
		 * JLabel title = new JLabel(); title.setText("PONG GAME MENU");
		 * title.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 36));
		 * title.setOpaque(true); title.setBackground(Color.BLACK);
		 * title.setForeground(Color.WHITE); title.setBounds(230, 20, 400, 30);
		 * panel.add(title);
		 */

		JButton onePlayerButton = new JButton("<html><font color=red size=4><b>1 PLAYER</b></html>");
		onePlayerButton.setBounds(300, 100, 200, 100);
		panel.setLayout(null);
		panel.add(onePlayerButton);
		JButton twoPlayerButton = new JButton("<html><font color=red size=4><b>2 PLAYER</b></html>");
		twoPlayerButton.setBounds(300, 200, 200, 100);
		panel.setLayout(null);
		panel.add(twoPlayerButton);
		/*
		 * JButton musicONButton = new JButton("Music ON"); musicONButton.setBounds(10,
		 * 250, 100, 50); panel.setLayout(null); panel.add(musicONButton);
		 */
		JButton musicOFFButton = new JButton("Music OFF");
		musicOFFButton.setBounds(10, 320, 80, 40);
		panel.setLayout(null);
		panel.add(musicOFFButton);

		this.setVisible(true);

		this.add(panel);

		onePlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				System.out.println("[ 1 PLAYER MOD - ON ]");
				mod = false;
				OnePlayerFrame onePlayerFrame = new OnePlayerFrame();
				JComponent comp = (JComponent) ev.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
			}
		});

		twoPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				System.out.println("[ 2 PLAYER MOD - ON ]");
				mod = true;
				TwoPlayerFrame twoPlayerFrame = new TwoPlayerFrame();
				JComponent comp = (JComponent) ev.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
			}
		});
		/*
		 * musicONButton.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent ev) { PongGame.music = true; } });
		 */

		musicOFFButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				PongGame.music = false;
			}
		});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null, "DONT GO !!!! JUST ONE MORE :)", "Are you sure?",
						JOptionPane.YES_NO_OPTION);

				if (confirmed == JOptionPane.YES_OPTION) {
					dispose();
				}
				/*
				 * else if (confirmed == JOptionPane.NO_OPTION) { remove(confirmed); }
				 */
			}
		});
	}
}