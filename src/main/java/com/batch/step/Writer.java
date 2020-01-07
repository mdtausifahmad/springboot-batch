package com.batch.step;

import java.util.ArrayList;
import java.util.List;

import com.batch.domain.DedWorkFlowResponse;
import com.batch.domain.Response;
import com.batch.repo.DedWorkFlowResponseRepository;
import com.batch.repo.ResponseRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Writer implements ItemWriter<Response> {

	@Autowired
	ResponseRepository responseRepository;


	@Override
	public void write(List<? extends Response> list) throws Exception {
		List<Response> responses = new ArrayList<>();

		list.stream().forEach( response ->{
			System.out.println(response.toString());
			responses.add(response);
		} );

		responseRepository.saveAll(responses);
	}
}
