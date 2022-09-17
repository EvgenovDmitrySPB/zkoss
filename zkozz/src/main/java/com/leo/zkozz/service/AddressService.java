package com.leo.zkozz.service;

import com.leo.zkozz.model.Address;
import com.leo.zkozz.model.Company;
import com.leo.zkozz.model.Filial;
import com.leo.zkozz.model.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

}
