package com.webex;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;

import static org.quartz.JobKey.jobKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class HelloWorldService {
	private static Logger logger = LoggerFactory.getLogger(HelloWorldService.class);
	static Scheduler sched = null;

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") int msg) throws Exception {
		switch (msg) {
			case 0:
				//this.stopQuartz();
				String rootPath=HelloWorldService.class.getResource("/").getFile().toString();
				  logger.info(rootPath);
				 String path = System.getProperty("user.dir");
				 logger.info(path);
				        /*String currentPath1=getClass().getResource(".").getFile().toString();
				        logger.info(currentPath1);*/
				       
				        String currentPath2=getClass().getResource("/").getFile().toString();
				        logger.info(currentPath2);
				       
				       /* String parentPath=getClass().getResource("../").getFile().toString();
				        logger.info(parentPath);*/
				break;
			case 1:
				this.startQuartz();
				break;
			case 2:
				this.pauseJob();
				break;
			case 3:
				this.resumeJob();
				break;
			case 4:
				this.updateJob();
				break;
		}

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();
	}

	public void startQuartz() throws Exception {
		sched = null;
		JobDetail job = newJob(HelloJob.class).withIdentity("job", "group")
				.build();

		JobDetail job1 = newJob(HelloJob1.class).withIdentity("job1", "group1")
				.build();

		Trigger trigger = newTrigger()
				.withIdentity("trigger", "group")
				.startNow()
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(4)
								.repeatForever()).build();

		Trigger trigger1 = newTrigger()
				.withIdentity("trigger1", "group1")
				.startNow()
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(4)
								.repeatForever()).build();

		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
		sched = schedFact.getScheduler();

		sched.scheduleJob(job, trigger);
		sched.scheduleJob(job1, trigger1);

		sched.start();
	}

	public void stopQuartz() throws SchedulerException {
		if (null == sched) {
			logger.info("sched is null");
			return;
		}else {
			sched.shutdown(false);
			sched = null;
			logger.info("sched shut down");
		}
	}
	
	public void pauseJob() throws SchedulerException {
		if (null == sched) {
			logger.info("sched is null");
			return;
		}else {
			//sched.deleteJob(jobKey("job1", "group1"));
			sched.pauseAll();
			logger.info("sched shut down");
		}
	}
	
	public void resumeJob() throws SchedulerException {
		if (null == sched) {
			logger.info("sched is null");
			return;
		}else {
			//sched.deleteJob(jobKey("job1", "group1"));
			sched.resumeAll();
			logger.info("sched shut down");
		}
	}
	
	
	public void updateJob() throws SchedulerException {
		if (null == sched) {
			logger.info("sched is null");
			return;
		}else {
			JobDetail job2 = newJob(HelloJob2.class).withIdentity("job", "group").storeDurably(true)
					.build();
			Trigger trigger1 = newTrigger()
					.withIdentity("trigger", "group")
					.startNow()
					.withSchedule(
							simpleSchedule().withIntervalInSeconds(4)
									.repeatForever()).build();

			sched.scheduleJob(job2, trigger1);

			logger.info("sched shut down");
		}
	}
}
