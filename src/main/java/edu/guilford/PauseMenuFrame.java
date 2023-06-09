package edu.guilford;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class PauseMenuFrame extends JFrame {

	private static final int frameWidth = 400;
	private static final int frameHeight = 200;
	public static GameFrame game;
	/*
	 * Constructor for PauseMenuFrame class
	 * will pause the game when the pause button is pressed
	 * game can be restarted or exited from this menu
	 */
	PauseMenuFrame() {
		final JPanel panel = new JPanel();
		this.setTitle("PAUSE MENU");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(frameWidth, frameHeight);

		Icon icon = new ImageIcon("pause.png");
		JButton returnButton = new JButton(icon);
		returnButton.setBounds(0, 0, frameWidth, frameHeight);
		panel.add(returnButton);

		this.setVisible(true);
		this.add(panel);
/*
 * action listener for the return button
 * will return to the game when pressed
 * will dispose of the pause menu frame
 */
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				System.out.println("");
				Timer.stop();
				MenuFrame menuFrame = new MenuFrame();
				JComponent comp = (JComponent) ev.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();

				if (MenuFrame.mod == false) {
					OnePlayerFrame.game.dispose();
					Paddle.stop = false;
				}
				if (MenuFrame.mod == true) {
					TwoPlayerFrame.game.dispose();
					Paddle.stop = false;
				}

			}
		});
	}
}
