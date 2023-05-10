package edu.guilford;

import java.awt.*;
import javax.swing.*;

/*
 * game frame class
 * initalizes the game panel and sets the frame properties
 * when the game is over, the frame is disposed
 * each time the game is restarted, a new frame is created
 * 
 */
public class GameFrame extends JFrame { 

	GamePanel panel;

	GameFrame() {
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack(); 
		this.setVisible(true);
		this.setLocationRelativeTo(null); 
	}

}
