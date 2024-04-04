package com.example.LimitedTimeDeals.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateDealRequest {

    private String dealName;

    private String dealDesc;

    private Date dealStartTime;

    private Date dealEndTime;

    private String itemName;

    private String itemDesc;
    private Long itemCountInDeal;
}
