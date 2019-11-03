import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class ReviewForTest {

	public static int numberOfSides = 0;

	public static void main(String[] args) {

		int xPosition = 100;
		int yPosition = 500;
		String numberOfRobots = JOptionPane.showInputDialog("number of robots? ");
		String numberOfSidesStr = JOptionPane.showInputDialog("number of sides?");
		numberOfSides = Integer.parseInt(numberOfSidesStr);
		int input = Integer.parseInt(numberOfRobots);

		Robot[] robots = new Robot[input];

		for (int i = 0; i < robots.length; i++) {

			robots[i] = new Robot(xPosition, yPosition);
			xPosition += 200;

		}

		for (Robot robot : robots) {
			new Thread(() -> drawSquare(robot)).start();
		}

		/**
		 * Robot r = new Robot(50, 500); Robot r2 = new Robot(300, 500); Robot r3 = new
		 * Robot(500, 500); Robot r4 = new Robot(700, 500);
		 **/

//		Thread r1Thread = new Thread(() -> drawSquare(robots[0]));
//		Thread r2Thread = new Thread(() -> drawSquare(robots[1]));
//		Thread r3Thread = new Thread(() -> drawSquare(robots[2]));
//		Thread r4Thread = new Thread(() -> drawSquare(robots[robots.length - 1]));
//
//		r1Thread.start();
//		r2Thread.start();
//		r3Thread.start();
//		r4Thread.start();

	}

	public static void drawSquare(Robot r) {
		r.penDown();

		for (int i = 0; i < numberOfSides; i++) {
			r.move(100);
			r.turn(360 / numberOfSides);
		}
	}

}
