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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class HelloWorldService {
	private static Logger _log = LoggerFactory.getLogger(HelloWorldService.class);
	static Scheduler sched = null;

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") int msg) throws Exception {
		switch (msg) {
			case 0:
				this.stopQuartz();
				break;
			case 1:
				this.startQuartz();
				break;
		}

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();
	}

	public void startQuartz() throws Exception {
		JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1")
				.build();

		JobDetail job2 = newJob(HelloJob1.class).withIdentity("job2", "group1")
				.build();

		Trigger trigger = newTrigger()
				.withIdentity("trigger1", "group1")
				.startNow()
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(4)
								.repeatForever()).build();

		Trigger trigger2 = newTrigger()
				.withIdentity("trigger2", "group2")
				.startNow()
				.withSchedule(
						simpleSchedule().withIntervalInSeconds(4)
								.repeatForever()).build();

		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
		sched = schedFact.getScheduler();

		sched.scheduleJob(job, trigger);
		sched.scheduleJob(job2, trigger2);

		sched.start();
	}

	public void stopQuartz() throws SchedulerException {
		if (null == sched) {
			_log.info("sched is null");
			return;
		}else {
			sched.shutdown(false);
			sched = null;
			_log.info("sched shut down");
		}
	}
}
