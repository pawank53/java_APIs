package com.export.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Course")
public class Course {
    @Id
    private Integer cid;
    private String name;
    private Double price;
}
