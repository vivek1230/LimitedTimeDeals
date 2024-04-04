package com.example.LimitedTimeDeals.dao.impl;

import com.example.LimitedTimeDeals.dao.ItemDao;
import com.example.LimitedTimeDeals.entity.Item;
import com.example.LimitedTimeDeals.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Log4j
@Service
@RequiredArgsConstructor
public class ItemDaoImpl implements ItemDao {

    private ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }
}
