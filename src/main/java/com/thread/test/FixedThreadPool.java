package com.thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
	public static void main(String[] args) {
	    // Constructor argument is number of threads:
	    ExecutorService exec = Executors.newFixedThreadPool(3);
	    for(int i = 0; i < 5; i++)
	      exec.execute(new LiftOff());
	    exec.shutdown();
	  }
}
