package _01_01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot first = new Robot(400, 700);
		Robot second = new Robot(800, 700);
		Robot third = new Robot(1200, 700);
		Robot fourth = new Robot(800, 700);
		Robot fifth = new Robot(1200, 700);
		first.setSpeed(10);
		second.setSpeed(10);
		third.setSpeed(10);

		first.moveTo(400, 700);
		second.moveTo(800, 700);
		third.moveTo(1200, 700);

		first.moveTo(600, 900);
		second.moveTo(1000, 900);
		third.moveTo(1400, 900);

		first.penDown();
		second.penDown();
		third.penDown();
		fourth.penDown();
		fifth.penDown();

		Thread r1 = new Thread(() -> doLoop(first, 3));
		Thread r2 = new Thread(() -> doLoop(second, 3));
		Thread r3 = new Thread(() -> doLoop(third, 3));
		Thread r4 = new Thread(() -> doLoop(fourth, 3));
		Thread r5 = new Thread(() -> doLoop(fifth, 3));

		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();

	}

	public static void doLoop(Robot r, int i) {
		for (int j = 0; j < 360; j++) {
			r.move(i);
			r.turn(1);
		}
	}

}
