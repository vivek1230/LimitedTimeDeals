package com.example.LimitedTimeDeals.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClaimDealResponse {

    private Long dealId;
    private String dealName;

    private Long itemId;
    private String itemName;
    private String username;
    private String itemCountToClaim;
}
