package _01_02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	static boolean winner = false;

	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {
		Robot r1 = new Robot(50, 700);
		Robot r2 = new Robot(250, 700);
		Robot r3 = new Robot(450, 700);
		Robot r4 = new Robot(650, 700);
		Robot r5 = new Robot(850, 700);
		Thread t1 = new Thread(() -> circle(r1));
		Thread t2 = new Thread(() -> circle(r2));
		Thread t3 = new Thread(() -> circle(r3));
		Thread t4 = new Thread(() -> circle(r4));
		Thread t5 = new Thread(() -> circle(r5));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

	public static void circle(Robot r) {
		r.setRandomPenColor();
		r.setPenWidth(10);
		r.penDown();
		while (winner == false) {
			if (r.getY() <= 100) {
				winner = true;
				r.turn(360);
			}
			Random rand = new Random();
			r.move(rand.nextInt(10));
			r.setSpeed(rand.nextInt(10) + 5);

		}
		r.penUp();
	}
}
