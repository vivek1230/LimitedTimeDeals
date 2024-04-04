package com.example.LimitedTimeDeals.dao.impl;

import com.example.LimitedTimeDeals.dao.ClaimDao;
import com.example.LimitedTimeDeals.entity.Claim;
import com.example.LimitedTimeDeals.repository.ClaimRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClaimDaoImpl implements ClaimDao {

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public Claim save(Claim claim) {
        return claimRepository.save(claim);
    }
}
