package com.example.LimitedTimeDeals.controller;


import com.example.LimitedTimeDeals.dto.BaseResponse;
import com.example.LimitedTimeDeals.dto.request.ClaimDealRequest;
import com.example.LimitedTimeDeals.dto.request.CreateDealRequest;
import com.example.LimitedTimeDeals.dto.request.EndDealRequest;
import com.example.LimitedTimeDeals.dto.request.UpdateDealRequest;
import com.example.LimitedTimeDeals.dto.response.*;
import com.example.LimitedTimeDeals.service.DealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/deal")
@RequiredArgsConstructor
public class DealController {

    private DealService dealService;

    @PostMapping("/create-deal")
    public BaseResponse<CreateDealResponse> createDeal(
            @RequestBody CreateDealRequest createDealRequest){
        log.info("Received request for create a deal");
        return dealService.createDeal(createDealRequest);
    }

    @PostMapping("/end-deal")
    public BaseResponse<EndDealResponse> endDeal(
            @RequestParam Long dealId,
            @RequestParam String dealName,
            @RequestBody EndDealRequest endDealRequest){
        log.info("Received request for end a deal");
        return dealService.endDeal(dealId, dealName, endDealRequest);
    }

    @PostMapping("/update-deal")
    public BaseResponse<UpdateDealResponse> updateDeal(
            @RequestParam Long dealId,
            @RequestParam String dealName,
            @RequestBody UpdateDealRequest updateDealRequest){
        log.info("Received request for update a deal");
        return dealService.updateDeal(dealId, dealName, updateDealRequest);
    }

    @PostMapping("/claim-deal")
    public BaseResponse<ClaimDealResponse> claimDeal(
            @RequestParam Long dealId,
            @RequestParam String dealName,
            @RequestBody ClaimDealRequest claimDealRequest){
        log.info("Received request for claim a deal");
        return dealService.claimDeal(dealId, dealName, claimDealRequest);
    }
}
