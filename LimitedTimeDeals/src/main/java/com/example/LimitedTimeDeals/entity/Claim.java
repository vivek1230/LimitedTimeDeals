package com.example.LimitedTimeDeals.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "claim")
@Builder
@Data
public class Claim extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    private String username;

    private long count;
}
