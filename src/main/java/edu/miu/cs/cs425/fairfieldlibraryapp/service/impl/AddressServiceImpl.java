package edu.miu.cs.cs425.fairfieldlibraryapp.service.impl;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Address;
import edu.miu.cs.cs425.fairfieldlibraryapp.repository.AddressRepository;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address addNewAddress(Address newAddress) {
        return addressRepository.save(newAddress);
    }

}
