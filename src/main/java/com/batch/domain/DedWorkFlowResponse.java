package com.batch.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DedWorkFlowResponse {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  private String name;
  private boolean picked;
  private int  processStatus;

  public DedWorkFlowResponse(String name, boolean picked, int  processStatus) {
    this.name = name;
    this.picked = picked;
    this.processStatus = processStatus;
  }

  public DedWorkFlowResponse() {}


  @Override
  public String toString() {
    return "DEDWorkFlowResponse{" +
            "id=" + id +
            ", isPicked=" + picked +
            ", processStatus=" + processStatus +
            '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isPicked() {
    return picked;
  }

  public void setPicked(boolean picked) {
    this.picked = picked;
  }

  public int getProcessStatus() {
    return processStatus;
  }

  public void setProcessStatus(int processStatus) {
    this.processStatus = processStatus;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
