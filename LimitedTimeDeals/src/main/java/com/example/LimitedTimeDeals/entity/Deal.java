package com.example.LimitedTimeDeals.entity;


import com.example.LimitedTimeDeals.enums.DealStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "deal")
@Builder
@Data
public class Deal extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealId;

    private String dealName;

    private String dealDesc;

    private DealStatus dealStatus;

    private Date dealStartTime;

    private Date dealEndTime;

    private Long itemId;

    private Long itemCountInDeal;

}
