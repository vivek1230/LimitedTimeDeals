package com.example.LimitedTimeDeals.dao.impl;

import com.example.LimitedTimeDeals.dao.ItemDao;
import com.example.LimitedTimeDeals.entity.Item;
import com.example.LimitedTimeDeals.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }
}
