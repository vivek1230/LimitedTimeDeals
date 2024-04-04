package com.example.LimitedTimeDeals.repository;


import com.example.LimitedTimeDeals.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {

}
