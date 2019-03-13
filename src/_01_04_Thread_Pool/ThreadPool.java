package _01_04_Thread_Pool;

import java.util.ArrayDeque;

public class ThreadPool {
	int totalThreads;
	Thread[] threads;
	ArrayDeque<Task> taskQueue;

	public ThreadPool(int totalThread) {

		this.totalThreads = totalThread;
		taskQueue = new ArrayDeque<Task>();
		threads = new Thread[totalThread];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Worker(taskQueue));
		}
	}

	public void start() {
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void addTask(Task task) {
		taskQueue.add(task);
	}

}
