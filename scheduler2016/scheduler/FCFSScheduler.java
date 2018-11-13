package scheduler;

/*
 * Assignment Submitted By Zafer Khourdaji
 * EID: E01251928
 */

/*
 */
/**
 * <p>Title: FCFSScheduler</p>
 * <p>Description: Component of the simulate operating system that encapsulates FCFS job scheduling.</p>
 * <p>Copyright: Copyright (c) 2015, 2004</p>
 * <p>Company: </p>
 * @author Matt Evett
 * @version 2.0
 */

import java.util.concurrent.ConcurrentLinkedQueue;

public class FCFSScheduler extends Scheduler {

  /*
   * TO_DO: your data structure to support a FCFS scheduler
   * and the abstract methods of Scheduler
   */
	private ConcurrentLinkedQueue<Job> readyQueue;
    
	public FCFSScheduler() {
		this.readyQueue = new ConcurrentLinkedQueue<>();
	}
 
  /**
   * If the ready queue is empty, return false.
   * Otherwise, start the next job in the queue, returning true.  If the queue is empty
   * return false.
   * Make the next job in the ready queue run. You should probably
   * invoke Thread.start() on it.
   */
  public boolean makeRun()
  {
	  if (this.readyQueue.isEmpty()) {
		  return false;
	  }

	  /*
	   * Place code here that gets the next Job from the ready queue and
	   * invokes start() on it
	   *
	   */
	  Job job = readyQueue.remove();
	  this.currentlyRunningJob = job;
	  this.currentlyRunningJob.start();
	  return true; // TO_DO ***SHOULDN'T ALWAYS RETURN TRUE***
  }
  
  /**
   * blockTilThereIsAJob()  Invoked by OS simulator when it wants to get a new Job to
   * run.  Will block if the ready queue is empty until a Job is added to the queue.
   */
  public synchronized void  blockTilThereIsAJob() {
	  if (hasRunningJob()) 
		  return;
	  /*
	   * Place code here that will cause the calling thread to block until the ready queue
	   * contains a Job
	   */
	  while (this.readyQueue.isEmpty()) {
		  try {
//			 System.out.println("waiting from blockTilThereIsAJob");
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  System.out.println("evidently there is now a job on readyQ");
  }

@Override
public synchronized void add(Job J) {
	this.readyQueue.add(J);
	notifyAll();
	
}

@Override
public void remove(Job J) {
	J = this.readyQueue.remove();
	
}

@Override
public boolean hasJobsQueued() {
	if (!this.readyQueue.isEmpty())
		return true;
	return false;
}
}
  

