package com.example.LimitedTimeDeals.dao;


import com.example.LimitedTimeDeals.entity.Item;
import org.springframework.stereotype.Service;

public interface ItemDao {
    Item save(Item item);
}
