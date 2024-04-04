package com.example.LimitedTimeDeals.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EndDealRequest {

    private Long dealId;

    private String dealName;
}
