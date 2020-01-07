package com.batch.step;

import com.batch.domain.DedWorkFlowResponse;
import com.batch.domain.Response;
import com.batch.repo.DedWorkFlowResponseRepository;
import com.batch.repo.ResponseRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class Processor implements ItemProcessor<DedWorkFlowResponse, Response> {

	@Autowired
	ResponseRepository responseRepository;

	@Autowired
	DedWorkFlowResponseRepository dedWorkFlowResponseRepository;

	@Override
	public Response process(DedWorkFlowResponse responses) throws Exception {

		Response response = new Response();
		response.setName(responses.getName());
		response.setProcessedDate(new Date(System.currentTimeMillis()));


		responses.setPicked(true);
		dedWorkFlowResponseRepository.saveAndFlush(responses);
		System.out.println(response.toString() + "Processed");
		return response;
}

}
