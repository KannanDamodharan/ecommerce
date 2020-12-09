package com.example.demo.controller;

import com.example.demo.entity.Item;
import com.example.demo.entity.Orders;
import com.example.demo.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*To save new items
* PUT and POST are performed*/
@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody Item item) throws Exception{
        return new ResponseEntity<>(itemService.updateItem(item), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateItem(@RequestBody Item item) throws Exception{
        return new ResponseEntity<>(itemService.updateItem(item), HttpStatus.OK);
    }

}
