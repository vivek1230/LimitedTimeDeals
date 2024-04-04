package com.example.LimitedTimeDeals.repository;


import com.example.LimitedTimeDeals.entity.Deal;
import com.example.LimitedTimeDeals.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
