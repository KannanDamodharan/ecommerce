package com.example.demo.service;

import com.example.demo.dao.AddressDao;
import com.example.demo.entity.Address;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class AddressServiceImpl {

    @Autowired
    private AddressDao addressDao;

    public Address updateAddress(Address address) {
        return addressDao.save(address);
    }
}
