package com.example.LimitedTimeDeals.dao;

import com.example.LimitedTimeDeals.entity.Deal;

import java.util.Optional;


public interface DealDao {
    Deal save(Deal deal);

    Optional<Deal> findByDealId(Long dealId);
}
