package com.hong.pack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="MEMBER")
public class Member {
    @Id
    private Long ID;
    private String USERNAME;
    private Integer AGE;
}
