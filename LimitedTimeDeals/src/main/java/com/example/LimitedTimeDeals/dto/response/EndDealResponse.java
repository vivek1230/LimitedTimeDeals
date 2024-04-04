package com.example.LimitedTimeDeals.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EndDealResponse {

    private Long dealId;
    private String dealName;
}
