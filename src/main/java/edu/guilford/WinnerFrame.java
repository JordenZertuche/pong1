package edu.guilford;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class WinnerFrame extends JFrame {

	private static final int frameWidth = 500;
	private static final int frameHeight = 500;
	public static GameFrame game;

	/*
	 * Constructor for WinnerFrame class
	 * will display the winner of the game
	 * will display the time it took to win the game
	 * will display a picture of a trophy (winner.png)
	 */
	WinnerFrame() {
		final JLabel panel = new JLabel(
				new ImageIcon("winner.png"));
		this.setTitle("WINNER");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(frameWidth, frameHeight);

		Timer.stop();
		double seconds = Timer.getTimeSec();
/*
 * JLabels for the winner, game time, and match score
 * JLabels are set to the appropriate font, color, and size
 * JLabels are added to the panel
 * panel is added to the frame
 * frame is set to visible
 * frame is set to the center of the screen
 * frame is set to the appropriate size
 * frame is set to not be resizable
 */
		JLabel cup = new JLabel();
		cup.setText("WINNER:");
		cup.setFont(new java.awt.Font("Arial Black", Font.BOLD, 30));
		cup.setOpaque(true);
		cup.setBackground(Color.BLACK);
		cup.setForeground(Color.RED);
		cup.setBounds(110, 20, 170, 50);
		panel.add(cup);

		JLabel winner = new JLabel();
		winner.setText(GamePanel.winner);
		winner.setFont(new java.awt.Font("Arial Black", Font.BOLD, 24));
		winner.setOpaque(true);
		winner.setBackground(Color.BLACK);
		winner.setForeground(Color.BLUE);
		winner.setBounds(295, 25, 200, 30);
		panel.add(winner);

		JLabel gameTime = new JLabel();
		int value = (int) seconds;
		gameTime.setText("Game Time: " + value + " seconds.");
		gameTime.setFont(new java.awt.Font("Arial Black", Font.BOLD, 24));
		gameTime.setOpaque(true);
		gameTime.setBackground(Color.BLACK);
		gameTime.setForeground(Color.GREEN);
		gameTime.setBounds(90, 70, 350, 30);
		panel.add(gameTime);

		/*
		 * JLabel matchScore = new JLabel(); matchScore.setText("Match Score: " +
		 * 		GamePanel.player1 + ": " + GamePanel.score.player1 + " | " + GamePanel.player2 + ": "
		 */

		JLabel matchScore = new JLabel();
		matchScore.setText("Match Score: " + GamePanel.player1 + ": " + GamePanel.score.player1 + " | "
				+ GamePanel.player2 + ": " + GamePanel.score.player2);
		matchScore.setFont(new java.awt.Font("Arial Black", Font.BOLD, 16));
		matchScore.setOpaque(true);
		matchScore.setBackground(Color.BLACK);
		matchScore.setForeground(Color.GREEN);
		matchScore.setBounds(100, 110, 350, 30);
		panel.add(matchScore);

		Icon icon = new ImageIcon("pause.png");
		JButton returnButton = new JButton(icon);
		returnButton.setBounds(150, 280, 200, 100);
		returnButton.setForeground(Color.WHITE);
		panel.add(returnButton);

		this.setVisible(true);
		this.add(panel);
/*
 * Action listener for the return button
 * will return the user to the menu frame
 * will dispose of the current frame
 * will dispose of the game frame
 */
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				System.out.println("");

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
