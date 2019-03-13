package _01_04_Thread_Pool;

import java.util.ArrayDeque;

public class Worker implements Runnable {
	ArrayDeque<Task> taskQueue;

	public Worker(ArrayDeque<Task> taskQueue) {
		this.taskQueue = taskQueue;
	}

	@Override
	public void run() {
		Task remove = taskQueue.poll();
		while (remove != null) {
			remove.perform();
			remove = taskQueue.poll();
		}
	}

}
