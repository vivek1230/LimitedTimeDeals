package com.example.LimitedTimeDeals.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.util.Date;


public class BaseEntity {
    private Date createdDate;

    private Date updatedDate;
}
