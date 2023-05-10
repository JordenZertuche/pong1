package edu.guilford;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AI_paddle extends Rectangle {

	/*
	 * class that creates the AI paddle
	 * description:
	 * 	- the AI paddle is the paddle that the computer controls
	 *  when creating this paddle, the constructor takes in the x and y coordinates, the width and height of the paddle, the id of the paddle, and the ball
	 * the AI paddle is always on the right side of the screen
	 * the AI paddle moves up and down depending on the difficulty of the game
	 * as the difficulty increases, the AI paddle moves faster
	 * each difficulty has the paddle shrink to a smaller size
	 */
	double yVel;
	int id;
	//final double gravity = 0.94;
	Ball b1;
	OnePlayerFrame dFrame;

	public AI_paddle(int x, int y, int paddleWidth, int paddleHeight, int id, Ball b) {
		super(x, y, paddleWidth, paddleHeight);

		b1 = b;
		this.id = id;

		y = 210;
		yVel = 0;
	}

	public void move() {
		// TODO Auto-generated method stub

		if (OnePlayerFrame.difficulty == 1) {// beg

			y = (int) (b1.getY() + 5);

			if (y < 70)
				y = 70;
			if (y > 370)
				y = 370;

		}
		if (OnePlayerFrame.difficulty == 2) {// nor

			y = (int) (b1.getY() - 40);

			if (y < 40)
				y = 40;
			if (y > 420)
				y = 420;

		}
		if (OnePlayerFrame.difficulty == 3) {// ins

			y = (int) (b1.getY() - 40);

			if (y < 1)
				y = 1;
			if (y > 500)
				y = 500;

		}

		// System.out.println("AI hareket");
	}

	public void draw(Graphics g) {

		if (OnePlayerFrame.difficulty == 1) {// beg

			g.setColor(Color.green);
		}
		if (OnePlayerFrame.difficulty == 2) {// nor

			g.setColor(Color.red);
		}
		if (OnePlayerFrame.difficulty == 3) {// ins

			g.setColor(Color.MAGENTA);
		}

		g.fillRect(x, y, width, height);
	}

	public double getY() {
		// TODO Auto-generated method stub
		return (int) y;
	}
}
