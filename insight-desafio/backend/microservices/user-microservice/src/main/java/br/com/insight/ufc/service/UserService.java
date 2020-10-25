package br.com.insight.ufc.service;

import br.com.insight.ufc.dto.CreateUserDTO;
import br.com.insight.ufc.dto.UpdateUserDTO;
import br.com.insight.ufc.exception.ResourceNotFoundException;
import br.com.insight.ufc.model.UserModel;
import br.com.insight.ufc.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final AddressService addressService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       AddressService addressService,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.addressService = addressService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserModel createUser(CreateUserDTO request) {

       UserModel user = new UserModel();
       user.setCpf(request.getCpf());
       user.setAge(request.getAge());
       user.setEmail(request.getEmail());
       user.setGender(request.getGender());
       user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
       user.setName(request.getName());
       user.setTelephone(request.getTelephone());
       user.setAddress(addressService.createAddress(request.getAddress()));
       return userRepository.save(user);

    }

    public UserModel findUser(Long id) {

        return userRepository.findById(id)
                             .orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado"));

    }

    public List<UserModel> findUsers() {

        List<UserModel> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;

    }

    private UserModel findById(Long id) {

        return userRepository.findById(id)
                             .orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado"));

    }

    public void updateUser(Long id, UpdateUserDTO request) {

        UserModel user = findById(id);

    }

    public void removeUser(Long id) {

        UserModel user = findById(id);
        userRepository.save(user);

    }

}
