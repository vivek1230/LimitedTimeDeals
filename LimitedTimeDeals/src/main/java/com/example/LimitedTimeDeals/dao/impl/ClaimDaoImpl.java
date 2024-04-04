package com.example.LimitedTimeDeals.dao.impl;

import com.example.LimitedTimeDeals.dao.ClaimDao;
import com.example.LimitedTimeDeals.dao.ItemDao;
import com.example.LimitedTimeDeals.entity.Claim;
import com.example.LimitedTimeDeals.entity.Item;
import com.example.LimitedTimeDeals.repository.ClaimRepository;
import com.example.LimitedTimeDeals.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Log4j
@Service
@RequiredArgsConstructor
public class ClaimDaoImpl implements ClaimDao {

    private ClaimRepository claimRepository;

    @Override
    public Claim save(Claim claim) {
        return claimRepository.save(claim);
    }
}
