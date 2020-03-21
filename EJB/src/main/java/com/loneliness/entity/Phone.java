package com.loneliness.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "phone")
@EqualsAndHashCode(of = { "id" })
@ToString(of = { "id", "model" })
public class Phone {
    @GeneratedValue(generator = "increment")
    @Id
    private int id;
    private String model;
    private String category;
    private BigDecimal price;
    private boolean status;




}
