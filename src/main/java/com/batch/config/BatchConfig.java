package com.batch.config;

import com.batch.domain.DedWorkFlowResponse;
import com.batch.domain.Response;
import com.batch.listener.JobCompletionListener;
import com.batch.repo.DedWorkFlowResponseRepository;
import com.batch.repo.ResponseRepository;
import com.batch.step.Processor;
import com.batch.step.Writer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.Collections;

@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	Writer writer;

	@Autowired
	Processor processor;

	@Autowired
	ResponseRepository repository;

	@Autowired
	DedWorkFlowResponseRepository dedWorkFlowResponseRepository;

	@Bean
	@StepScope
	public RepositoryItemReader<DedWorkFlowResponse> dedWorkFlowResponseItemReader() {

		return new RepositoryItemReaderBuilder<DedWorkFlowResponse>()
				.name("dedWorkFlowResponseItemReader")
				.methodName("findByPickedIs")
				.arguments(Collections.singletonList(false))
				.pageSize(10)
				.repository(dedWorkFlowResponseRepository)
				.sorts(Collections.singletonMap("id", Sort.Direction.ASC))
				.build();
	}



	@Bean
	public Job processJob() throws Exception {

		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer()).listener(listener())
				.flow(orderStep1()).end().build();
	}

	@Bean
	public Step orderStep1() throws Exception {

		return stepBuilderFactory.get("step1")
				.<DedWorkFlowResponse, Response>chunk(10)
				.reader(dedWorkFlowResponseItemReader())
				.processor(processor)
				.writer(writer)
				.build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}





}
