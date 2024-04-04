package com.example.LimitedTimeDeals.dao.impl;

import com.example.LimitedTimeDeals.dao.DealDao;
import com.example.LimitedTimeDeals.entity.Deal;
import com.example.LimitedTimeDeals.repository.DealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Log4j
@Service
@RequiredArgsConstructor
public class DealDaoImpl implements DealDao {

    DealRepository dealRepository;

    @Override
    public Deal save(Deal deal) {
        return dealRepository.save(deal);
    }

    @Override
    public Optional<Deal> findByDealId(Long dealId) {
        return dealRepository.findById(dealId);
    }
}
