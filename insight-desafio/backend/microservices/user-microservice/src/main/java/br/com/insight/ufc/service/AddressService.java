package br.com.insight.ufc.service;

import br.com.insight.ufc.dto.AddressDTO;
import br.com.insight.ufc.model.AddressModel;
import br.com.insight.ufc.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressModel createAddress(AddressDTO request){

        AddressModel model = new AddressModel();
        model.setCity(request.getCity());
        model.setComplement(request.getComplement());
        model.setLogradouro(request.getLogradouro());
        model.setNeighborhood(request.getNeighborhood());
        model.setNumber(request.getNumber());
        model.setState(request.getState());
        model.setZipCode(request.getZipCode());
        return addressRepository.save(model);

    }
}
