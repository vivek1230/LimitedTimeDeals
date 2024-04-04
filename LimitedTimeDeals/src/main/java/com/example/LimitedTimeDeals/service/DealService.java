package com.example.LimitedTimeDeals.service;


import com.example.LimitedTimeDeals.dto.BaseResponse;
import com.example.LimitedTimeDeals.dto.request.ClaimDealRequest;
import com.example.LimitedTimeDeals.dto.request.CreateDealRequest;
import com.example.LimitedTimeDeals.dto.request.EndDealRequest;
import com.example.LimitedTimeDeals.dto.request.UpdateDealRequest;
import com.example.LimitedTimeDeals.dto.response.ClaimDealResponse;
import com.example.LimitedTimeDeals.dto.response.CreateDealResponse;
import com.example.LimitedTimeDeals.dto.response.EndDealResponse;
import com.example.LimitedTimeDeals.dto.response.UpdateDealResponse;
import org.springframework.stereotype.Service;


public interface DealService {
    BaseResponse<CreateDealResponse> createDeal(CreateDealRequest createDealRequest);

    BaseResponse<EndDealResponse> endDeal(Long dealId, String dealName, EndDealRequest endDealRequest);

    BaseResponse<UpdateDealResponse> updateDeal(Long dealId, String dealName, UpdateDealRequest updateDealRequest);

    BaseResponse<ClaimDealResponse> claimDeal(Long dealId, String dealName, ClaimDealRequest claimDealRequest);
}
