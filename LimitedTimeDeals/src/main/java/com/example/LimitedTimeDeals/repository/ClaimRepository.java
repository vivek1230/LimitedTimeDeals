package com.example.LimitedTimeDeals.repository;


import com.example.LimitedTimeDeals.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
