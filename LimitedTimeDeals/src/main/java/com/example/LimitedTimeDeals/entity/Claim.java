package com.example.LimitedTimeDeals.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "claim")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Claim extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    private String username;

    private long count;
}
