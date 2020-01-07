package com.batch;

import com.batch.domain.DedWorkFlowResponse;
import com.batch.repo.DedWorkFlowResponseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
public class SpringBatchApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBatchApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DedWorkFlowResponseRepository repository) {
		return (args) -> {
			for(int i = 0; i< 30; i++){
				repository.save(new DedWorkFlowResponse("Job "+i,false,0));
			}
		};
	}
}
