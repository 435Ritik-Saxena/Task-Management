package com.task.entities;

import java.sql.Date;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


 
@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int taskid;

    
    @Column
    private String title;

    @Column(length = 1000)
    private String description;

    
    @Column
    private Date startDate;

    @Column
    private Date completeDate;

 
    @Column
    private String priority;

    
    @Column
    private String status;

   

   
}