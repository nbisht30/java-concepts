package com.ThreadsExample;

public class AnotherThread extends Thread {
	@Override
	public void run() { // run() contains the code of the thread.
		System.out.println("Hello from " + currentThread().getName());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("INTERRUPTED : Another thread woke me up.");
			return; // to halt execution when this thread is interrupted.
		}
		System.out.println("Seconds have passed and I am still awake.");

	}
}
