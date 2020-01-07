package com.batch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobCompletionListener extends JobExecutionListenerSupport {

	private long jobstartTime;

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Job Started");
		jobstartTime = System.currentTimeMillis();
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
			long end = System.currentTimeMillis();
			long delta = end - jobstartTime;

			System.out.println(delta  + " millisecond");
		}
	}

}
