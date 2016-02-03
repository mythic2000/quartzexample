package com.webex;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.*; 
import static org.quartz.TriggerBuilder.*; 
import static org.quartz.SimpleScheduleBuilder.*;


public class QuartzTest {

	public static void main(String[] args) throws SchedulerException, InterruptedException {
		SchedulerFactory sf = new StdSchedulerFactory();   
		Scheduler sched = sf.getScheduler();
		Date startTime = new Date();
		
		JobDetail job = newJob(StatefulDumbJob.class)   
			    .withIdentity("statefulJob1", "group1")
			    .usingJobData(StatefulDumbJob.EXECUTION_DELAY, 10000L)   
			    .build(); 
			SimpleTrigger trigger = newTrigger()    
			    .withIdentity("trigger1", "group1")   
			    .startAt(startTime)   
			    .withSchedule(simpleSchedule()   
			            .withIntervalInSeconds(3)   
			            .repeatForever())   
			    .build();   
			
	/*	JobDetail job = newJob(StatefulDumbJob.class)   
		            .withIdentity("statefulJob2", "group1")   
		            .usingJobData(StatefulDumbJob.EXECUTION_DELAY, 10000L)   
		            .build();   
		       
		SimpleTrigger trigger = newTrigger()    
		            .withIdentity("trigger2", "group1")   
		            .startAt(startTime)   
		            .withSchedule(simpleSchedule()   
		                    .withIntervalInSeconds(3)   
		                    .repeatForever()   
		                    .withMisfireHandlingInstructionNowWithExistingCount()) // set 
		                          // misfire instruction   
		            .build();*/
		sched.scheduleJob(job, trigger);

		        sched.start();
		        Thread.sleep(600L * 1000L);
		        sched.shutdown(true);


	}

}
