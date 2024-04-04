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
public class UpdateDealResponse {

    private Long dealId;
    private String dealName;
    private Date dealStartTime;
    private Date dealEndTime;
    private Long itemCountInDeal;
}
