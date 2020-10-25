package br.com.insight.ufc.controller;

import br.com.insight.ufc.dto.CreateUserDTO;
import br.com.insight.ufc.dto.UpdateUserDTO;
import br.com.insight.ufc.model.UserModel;
import br.com.insight.ufc.model.view.UserView;
import br.com.insight.ufc.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserDTO request) {

        Long id = userService.createUser(request).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();

    }

    @GetMapping(
            value = "/{id}",
            produces = {"application/json", "application/xml"}
            )
    @JsonView(UserView.Resumo.class)
    public ResponseEntity<UserModel> getUser(@PathVariable Long id) {

        UserModel user = userService.findUser(id);
        return ResponseEntity.ok().body(user);

    }

    @GetMapping(
            produces = {"application/json", "application/xml"}
    )
    @JsonView(UserView.Resumo.class)
    public ResponseEntity<List<UserModel>> getUsers() {

        List<UserModel> users = userService.findUsers();
        return ResponseEntity.ok().body(users);

    }

    @PatchMapping(
            value = "/{id}",
            consumes = {"application/json", "application/xml"}
            )
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UpdateUserDTO request) {

        userService.updateUser(id, request);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(
            value = "/{id}"
    )
    public ResponseEntity<?> removeUser(@PathVariable Long id) {

        userService.removeUser(id);
        return ResponseEntity.accepted().build();

    }

}
