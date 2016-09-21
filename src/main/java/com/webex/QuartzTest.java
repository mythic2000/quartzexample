package com.webex;

import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.*; 
import static org.quartz.TriggerBuilder.*; 
import static org.quartz.SimpleScheduleBuilder.*;


public class QuartzTest {

	public static void main(String[] args) throws SchedulerException, InterruptedException {
		SchedulerFactory sf = new StdSchedulerFactory();   
		Scheduler sched = sf.getScheduler();
		Date startTime = new Date();
		
		/*JobKey jobKey = new JobKey("statefulJob1", "group1");
		if(sched.checkExists(jobKey))
		{
			sched.deleteJob(jobKey);
		}*/
		
		JobDetail job = newJob(HelloJob.class)   
			    .withIdentity("statefulJob1", "group1").requestRecovery()
			    .build(); 
		CronTrigger trigger = newTrigger().withIdentity("trigger1", "group1").withSchedule(cronSchedule("0 0/2 * * * ?"))
			        .build();
/*			SimpleTrigger trigger = newTrigger()    
			    .withIdentity("trigger1", "group1")   
			    .startAt(startTime)   
			    .withSchedule(simpleSchedule()   
			            .withIntervalInSeconds(3)   
			            .repeatForever())   
			    .build();  */ 
			
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
