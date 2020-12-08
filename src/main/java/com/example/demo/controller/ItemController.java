package com.example.demo.controller;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody Item itemEntity) throws Exception{
        return new ResponseEntity<>(itemService.updateItem(itemEntity), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateItem(@RequestBody Item itemEntity) throws Exception{
        return new ResponseEntity<>(itemService.updateItem(itemEntity), HttpStatus.OK);
    }
}
