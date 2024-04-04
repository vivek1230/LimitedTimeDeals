package com.example.LimitedTimeDeals.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateDealRequest {

    private Date dealStartTime;
    private Date dealEndTime;
    private Long itemCountInDeal;
}
