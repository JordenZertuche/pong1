package edu.guilford;

import java.awt.*;
import java.util.Random;
/*
 * class that creates the ball
 * description:
 * 	- the ball is the object that bounces around the screen
 * 	when creating the ball, the constructor takes in the x and y coordinates, the width and height of the ball
 * 	the ball is always in the center of the screen
 * 	the ball moves in a random direction when the game starts
 * 	the ball bounces off of the paddles and the top and bottom of the screen
 * 	the ball is the object that the player is trying to hit with the paddle
 * 	the ball is the object that the AI paddle is trying to hit with its paddle
 * 	the ball is the object that the player is trying to keep from hitting the bottom of the screen
 *  with the intial basics of the game, the ball class is the most important class as it is the object that the player interacts with the most
 *  removing this class would not allow the rest of the program to run
 *  as for the inital speed and its reasoning when tinkering with other speeds aisde from two it would weitehr be too fast or too slow
 *  two is the perfect speed for the ball to move at initally before the difficulty is changed overtime.
 */
public class Ball extends Rectangle {

	private Color beginnerBallColor = OnePlayerFrame.ballColor;
	private Color twoPlayerBallColor = TwoPlayerFrame.ballColor;
	private Random random;
	public int xVelocity;
	public int yVelocity;
	private int initialSpeed = 2;
	Random rand = new Random();
	OnePlayerFrame dFrame;

	Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		random = new Random();
		int randomXDirection = random.nextInt(2);
		if (randomXDirection == 0)
			randomXDirection--;
		setXDirection(randomXDirection * initialSpeed);

		int randomYDirection = random.nextInt(2);
		if (randomYDirection == 0)
			randomYDirection--;
		setYDirection(randomYDirection * initialSpeed);

	}

	Color randomColor;

	public void ColorLooper() {

		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();

		randomColor = new Color(r, g, b);

	}

	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
	}

	public void setYDirection(int randomYDirection) {
		yVelocity = randomYDirection;
	}

	public void move() {
		x += xVelocity;
		y += yVelocity;
	}

	public void draw(Graphics g) {

		if (OnePlayerFrame.difficulty == 3 || OnePlayerFrame.difficulty == 2) {

			g.setColor(randomColor);
		} else {
			if (MenuFrame.mod == false)
				g.setColor(beginnerBallColor);
			else
				g.setColor(twoPlayerBallColor);
		}

		g.fillOval(x, y, height, width);
	}
}