package edu.guilford;

import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle {

	/*
	 * Paddle class
	 * paddle is extending rectangle becuase it is a rectangle shape
	 * as for the colors they are set to the colors of the paddles in the game
	 * speed and yVelocity are set to 10 because that is the speed of the paddles that are a generally not too fast but not too slow
	 * @param x the x coordinate of the paddle
	 * @param y the y coordinate of the paddle
	 * @param paddleWidth the width of the paddle
	 * @param paddleHeight the height of the paddle
	 * @param id the id of the paddle
	 * 
	 * 
	 */
	private Color onePaddleColor = OnePlayerFrame.paddleColor;
	private Color twoPaddleColorLeft = TwoPlayerFrame.paddleColorLeft;
	private Color twoPaddleColorRight = TwoPlayerFrame.paddleColorRight;
	boolean dragging = false;
	int id;
	int yVelocity;
	public static boolean stop = false;
	int speed = 10;

	Paddle(int x, int y, int paddleWidth, int paddleHeight, int id) {
		super(x, y, paddleWidth, paddleHeight);
		this.id = id;
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON2) {

		}
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}
/*
 * mouseDrag method
 * 
 * method for a mouseDrag event
 * players wishing use their mouse could similar in fashion to those wishing to play on their phone or touch screen
 */
	public void mouseDrag(MouseEvent e) {
		/*
		 * while (e.getButton() == MouseEvent.BUTTON1){ this.y = e.getY(); dragging =
		 * true; } dragging = false;
		 */
	}

	public void move(MouseEvent e) {
		this.y = e.getY();

	}

	/*
	 * keyPressed method
	 * designed to move the paddle when the key is pressed
	 */
	public void keyPressed(KeyEvent e) {

		if (id == 1) {
			if (e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(-speed);
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(speed);
			}

			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

				stop = true;
				PauseMenuFrame pmf = new PauseMenuFrame();

			}

		}

		if (id == 3) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(-speed);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(speed);
			}

		}
	}
	/*
	 * keyReleased method
	 * designed to stop the paddle from moving when the key is released
	 * @param e the key event
	 * @return none
	 * 
	 * allows for the program to no just keep moving the paddle when the key is held down
	 */

	public void keyReleased(KeyEvent e) {
		switch (id) {
		case 1:
			if (e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(0);
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(0);
			}
			break;
		case 3:
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(0);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(0);
			}
			break;
		}
	}

	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}

	public void move() {
		y = y + yVelocity;
	}

	public void draw(Graphics g) {
		if (id == 1) {
			if (MenuFrame.mod == false)
				g.setColor(onePaddleColor);
			else
				g.setColor(twoPaddleColorLeft);

		} else
			g.setColor(twoPaddleColorRight);
		g.fillRect(x, y, width, height);
	}
}