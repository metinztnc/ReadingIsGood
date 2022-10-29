package com.readingIsGood.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter @NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

  @Basic
  public Date createDate;

  @Basic
  public Date  updateDate;



  @PrePersist
  public void setInitialValuesOnPrePersist() {
    this.createDate = new Date();
  }

  @PreUpdate
  public void setInitialValuesOnPreUpdate() {
    this.updateDate = new Date();
  }
}
