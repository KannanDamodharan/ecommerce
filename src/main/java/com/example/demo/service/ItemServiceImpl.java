package com.example.demo.service;

import com.example.demo.dao.ItemDao;
import com.example.demo.entity.Item;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class ItemServiceImpl {

    @Autowired
    private ItemDao itemDao;

    public Item updateItem(Item itemEntity) {
        return itemDao.save(itemEntity);
    }

}
