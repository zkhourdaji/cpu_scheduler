package scheduler;
/*
 * Assignment Submitted By Zafer Khourdaji
 * EID: E01251928
 */

/**
 * A factory class for generating JobWorkables to be placed in Jobs.
 * When I test your program I will replace this class with my own.
 * The only variability will be in createWork(), which will return
 * an instance of a class that I have created to implement JobWorkable.
 * @author matt
 * @version 1.1
 * <p>Copyright: Copyright (c) 2016, 2015, 2004 by Matt Evett</p>
 *
 */
public class WorkFactory {
	private int jobCount = 0;
	public JobWorkable createWork() {
		/* 
		 * Return a new instance of a class that implements JobWorkable.
		 * You should provide that class.  After running your program
         * as you submit it, I will have this method return an instance
         * of a class that I have created (which will also implement
         * JobWorkable.)
		 */
		return new JobWorkable() {
			
			@Override
			public void doWork() {
				System.out.println(Thread.currentThread().getName() + " doing work. Job count: " + ++jobCount);
				
			}
		};
	}
}
