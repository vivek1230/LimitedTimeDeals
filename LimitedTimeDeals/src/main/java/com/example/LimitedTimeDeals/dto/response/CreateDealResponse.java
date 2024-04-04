package com.example.LimitedTimeDeals.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateDealResponse {

    private Long dealId;
    private String dealName;

    private String dealDesc;

    private Date dealStartTime;

    private Date dealEndTime;

    private Long itemId;
    private String itemName;

    private String itemDesc;
    private Long itemCountInDeal;
}
