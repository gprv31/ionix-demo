package com.example.ionix.adapter.output.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class AuditEntity {
  @Column(name = "enabled")
  private Boolean enabled;

  @Column(name = "creation_date")
  private LocalDateTime creationDate;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "update_date")
  private LocalDateTime updateDate;

  @Column(name = "updated_by")
  private String updatedBy;

  @PrePersist
  public void prePersist() {
    creationDate = LocalDateTime.now();
    enabled = Boolean.TRUE;
  }
}
