package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.service.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @PostMapping
    public ResponseEntity<?> addAddressDetails(@RequestBody Address address) throws Exception{
        return new ResponseEntity<>(addressService.updateAddress(address), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateShippingDetails(@RequestBody Address address) throws Exception{
        return new ResponseEntity<>(addressService.updateAddress(address), HttpStatus.OK);
    }
}
