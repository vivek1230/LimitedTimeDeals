package com.example.LimitedTimeDeals.dao.impl;

import com.example.LimitedTimeDeals.dao.ClaimDao;
import com.example.LimitedTimeDeals.entity.Claim;
import com.example.LimitedTimeDeals.repository.ClaimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//@Log4j
@Service
@RequiredArgsConstructor
public class ClaimDaoImpl implements ClaimDao {

    private ClaimRepository claimRepository;

    @Override
    public Claim save(Claim claim) {
        return claimRepository.save(claim);
    }
}
