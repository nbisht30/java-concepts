package com.ThreadsExample;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello from Main thread.");

		Thread thread = new AnotherThread();
		thread.setName("==Another Thread==");
		thread.start(); // start() starts the thread and executes the code in the overridden run(). Just
						// instantiating the thread doesn't execute the code.
		thread.interrupt(); // interrupting AnotherThread from Main thread	
		// We can also create an anonymous inner class using Thread class, if we only
		// want to
		// execute a piece of code once
		new Thread() {
			@Override
			public void run() {
				System.out.println("Inner class thread.");
			}
		}.start();

		System.out.println("Also in the Main thread."); // order of execution within threads is not guaranteed.

		// thread.start(); // throws IllegalThreadStateException at Runtime because same
		// thread object
		// cannot be started more than once
		// If you want to run the code more than once, you have to create a new instance
		// and call start()

		// creating a thread when class was implementing Runnable interface
		Thread myRunnableThread = new Thread(new MyRunnable());
		myRunnableThread.start();

		Thread myRunnableThreadAnnon = new Thread(new MyRunnable() {
			@Override
			public void run() {
				System.out.println("Hello from anonymous class");
			}
		});
		myRunnableThreadAnnon.start();

	}
}
