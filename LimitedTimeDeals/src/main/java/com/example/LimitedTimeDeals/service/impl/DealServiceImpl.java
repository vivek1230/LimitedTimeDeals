package com.example.LimitedTimeDeals.service.impl;

import com.example.LimitedTimeDeals.dao.ClaimDao;
import com.example.LimitedTimeDeals.dao.DealDao;
import com.example.LimitedTimeDeals.dao.ItemDao;
import com.example.LimitedTimeDeals.dto.BaseResponse;
import com.example.LimitedTimeDeals.dto.request.ClaimDealRequest;
import com.example.LimitedTimeDeals.dto.request.CreateDealRequest;
import com.example.LimitedTimeDeals.dto.request.EndDealRequest;
import com.example.LimitedTimeDeals.dto.request.UpdateDealRequest;
import com.example.LimitedTimeDeals.dto.response.ClaimDealResponse;
import com.example.LimitedTimeDeals.dto.response.CreateDealResponse;
import com.example.LimitedTimeDeals.dto.response.EndDealResponse;
import com.example.LimitedTimeDeals.dto.response.UpdateDealResponse;
import com.example.LimitedTimeDeals.entity.Claim;
import com.example.LimitedTimeDeals.entity.Deal;
import com.example.LimitedTimeDeals.entity.Item;
import com.example.LimitedTimeDeals.enums.DealStatus;
import com.example.LimitedTimeDeals.service.DealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@Service
public class DealServiceImpl implements DealService {


    @Autowired
    ItemDao itemDao;
    @Autowired
    DealDao dealDao;
    @Autowired
    ClaimDao claimDao;

    @Override
    public BaseResponse<CreateDealResponse> createDeal(CreateDealRequest createDealRequest) {

        Item item = Item.builder()
                .itemName(createDealRequest.getItemName())
                .itemDesc(createDealRequest.getItemDesc())
                .build();
        item = itemDao.save(item);

        Deal deal = Deal.builder()
                .dealName(createDealRequest.getDealName())
                .dealDesc(createDealRequest.getDealDesc())
                .dealStatus(DealStatus.ACTIVE)
                .dealStartTime(createDealRequest.getDealStartTime())
                .dealEndTime(createDealRequest.getDealEndTime())
                .itemCountInDeal(createDealRequest.getItemCountInDeal())
                .itemId(item.getItemId())
                .build();
        deal = dealDao.save(deal);

        CreateDealResponse createDealResponse = CreateDealResponse.builder()
                .dealId(deal.getDealId())
                .dealName(deal.getDealName())
                .dealDesc(deal.getDealDesc())
                .dealStartTime(deal.getDealStartTime())
                .dealEndTime(deal.getDealEndTime())
                .itemId(item.getItemId())
                .itemName(item.getItemName())
                .itemDesc(item.getItemDesc())
                .itemCountInDeal(deal.getItemCountInDeal())
                .build();

        BaseResponse<CreateDealResponse> response = new BaseResponse<>();
        response.setResponseMsg("Deal created successfully");
        response.setRequestId(UUID.randomUUID().toString());
        response.setTimeStamp(new Date());
        response.setResponse(createDealResponse);
        return response;
    }

    @Override
    public BaseResponse<EndDealResponse> endDeal(Long dealId, String dealName, EndDealRequest endDealRequest) {

        Optional<Deal> optionalDeal = dealDao.findByDealId(dealId);
        if (optionalDeal.isPresent()) {
            Deal deal = optionalDeal.get();
            if (deal.getDealStatus().equals(DealStatus.ACTIVE)) {
                deal.setDealStatus(DealStatus.ENDED);
                dealDao.save(deal);

                EndDealResponse dealResponse = EndDealResponse.builder()
                        .dealId(deal.getDealId())
                        .dealName(deal.getDealName())
                        .build();

                BaseResponse<EndDealResponse> response = new BaseResponse<>();
                response.setResponseMsg("Deal ended successfully");
                response.setRequestId(UUID.randomUUID().toString());
                response.setTimeStamp(new Date());
                response.setResponse(dealResponse);
                return response;
            } else {
                BaseResponse<EndDealResponse> response = new BaseResponse<>();
                response.setResponseMsg("Deal is not active");
                response.setRequestId(UUID.randomUUID().toString());
                response.setTimeStamp(new Date());
                return response;
            }
        }
        BaseResponse<EndDealResponse> response = new BaseResponse<>();
        response.setResponseMsg("No deal found");
        response.setRequestId(UUID.randomUUID().toString());
        response.setTimeStamp(new Date());
        return response;
    }

    @Override
    public BaseResponse<UpdateDealResponse> updateDeal(Long dealId, String dealName, UpdateDealRequest updateDealRequest) {

        Optional<Deal> optionalDeal = dealDao.findByDealId(dealId);
        if (optionalDeal.isPresent()) {
            Deal deal = optionalDeal.get();
            if (deal.getDealStatus().equals(DealStatus.ACTIVE)) {
                deal.setDealStartTime(updateDealRequest.getDealStartTime());
                deal.setDealEndTime(updateDealRequest.getDealEndTime());
                deal.setItemCountInDeal(updateDealRequest.getItemCountInDeal());
                dealDao.save(deal);

                UpdateDealResponse dealResponse = UpdateDealResponse.builder()
                        .dealId(deal.getDealId())
                        .dealName(deal.getDealName())
                        .dealStartTime(deal.getDealStartTime())
                        .dealEndTime(deal.getDealEndTime())
                        .itemCountInDeal(deal.getItemCountInDeal())
                        .build();

                BaseResponse<UpdateDealResponse> response = new BaseResponse<>();
                response.setResponseMsg("Deal update successfully");
                response.setRequestId(UUID.randomUUID().toString());
                response.setTimeStamp(new Date());
                response.setResponse(dealResponse);
                return response;
            } else {
                BaseResponse<UpdateDealResponse> response = new BaseResponse<>();
                response.setResponseMsg("Deal is not active");
                response.setRequestId(UUID.randomUUID().toString());
                response.setTimeStamp(new Date());
                return response;
            }
        }
        BaseResponse<UpdateDealResponse> response = new BaseResponse<>();
        response.setResponseMsg("No deal found");
        response.setRequestId(UUID.randomUUID().toString());
        response.setTimeStamp(new Date());
        return response;
    }

    @Override
    public BaseResponse<ClaimDealResponse> claimDeal(Long dealId, String dealName, ClaimDealRequest claimDealRequest) {

        Optional<Deal> optionalDeal = dealDao.findByDealId(dealId);
        if (optionalDeal.isPresent()) {
            Deal deal = optionalDeal.get();
            if (deal.getDealStatus().equals(DealStatus.ACTIVE)) {
                if (claimDealRequest.getCount() <= deal.getItemCountInDeal()) {
                    Claim claim = Claim.builder()
                            .username(claimDealRequest.getUsername())
                            .count(claimDealRequest.getCount())
                            .build();
                    claim = claimDao.save(claim);

                    deal.setItemCountInDeal(deal.getItemCountInDeal() - claim.getCount());
                    deal.setDealStatus(deal.getItemCountInDeal() > 0 ? DealStatus.ACTIVE : DealStatus.ENDED);
                    dealDao.save(deal);

                    ClaimDealResponse claimDealResponse = ClaimDealResponse.builder()
                            .dealId(deal.getDealId())
                            .dealName(deal.getDealName())
                            .itemId(deal.getItemId())
                            .username(claim.getUsername())
                            .itemCountToClaim(claim.getUsername())
                            .build();

                    BaseResponse<ClaimDealResponse> response = new BaseResponse<>();
                    response.setResponseMsg("Claim made successfully");
                    response.setRequestId(UUID.randomUUID().toString());
                    response.setTimeStamp(new Date());
                    response.setResponse(claimDealResponse);
                    return response;
                } else {
                    BaseResponse<ClaimDealResponse> response = new BaseResponse<>();
                    response.setResponseMsg("Item is not available");
                    response.setRequestId(UUID.randomUUID().toString());
                    response.setTimeStamp(new Date());
                    return response;
                }
            } else {
                BaseResponse<ClaimDealResponse> response = new BaseResponse<>();
                response.setResponseMsg("Deal is not active");
                response.setRequestId(UUID.randomUUID().toString());
                response.setTimeStamp(new Date());
                return response;
            }
        }
        BaseResponse<ClaimDealResponse> response = new BaseResponse<>();
        response.setResponseMsg("No deal found");
        response.setRequestId(UUID.randomUUID().toString());
        response.setTimeStamp(new Date());
        return response;
    }
}
