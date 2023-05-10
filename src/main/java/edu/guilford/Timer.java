package edu.guilford;

public class Timer {

	private static long start;
	private static long end;
	private static boolean started;

	/*
	 * Constructor for Timer class
	 * starts as soon as the class is called and creates a new instance of the
	 * Timer class with the start time
	 * once game is over, the end time is recorded and the time is calculated and printed out
	 * 
	 */
	private static boolean isStopped() {
		return !started;
	}

	private static boolean isStarted() {
		return started;
	}

	public static void start() {
		if (isStopped()) {
			startTimer();
		} else {
			throw new RuntimeException("ERROR: The stopwatch has already started\n");
		}
	}

	private static void startTimer() {
		start = System.nanoTime();
		started = true;
	}
/*
 * error handling for when the timer is not started
 */
	public static void stop() {
		if (isStarted()) {
			stopTimer();
		} else {
			throw new RuntimeException("ERROR: The stopwatch is not started.\n" + " \n");
		}
	}

	private static void stopTimer() {
		end = System.nanoTime();
		started = false;
	}

	public static long getTime() {
		if (isStopped()) {
			return end - start; // NANO SANİYE
		} else {
			throw new RuntimeException("ERROR: \n" + "the stopwatch could not be stopped.\n");
		}

	}

	/*
	 * @return seconds
	 * part of the code that calculates the time in seconds
	 */

	public static double getTimeSec() {
		double seconds = (double) getTime() / 1000000000.0; // saniye
		return seconds;
	}
}
