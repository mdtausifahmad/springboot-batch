package com.batch.rest;

import com.batch.repo.DedWorkFlowResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private DedWorkFlowResponseRepository repository;

  @Autowired
  private DedWorkFlowResponseRepository customers;


  @RequestMapping("/customers")
  public String getCustomers(){
    return "Hellow";
  }
}
