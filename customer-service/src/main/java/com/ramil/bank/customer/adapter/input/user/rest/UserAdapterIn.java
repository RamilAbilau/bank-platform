package com.ramil.bank.customer.adapter.input.user.rest;

import com.ramil.bank.customer.application.user.port.input.UserPortIn;
import com.ramil.bank.customer.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserAdapterIn {

    private final UserPortIn userPortIn;

    private final UserRestMapper userRestMapper;

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody UserRequest userRequest) {
        log.info("POST method create user");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userPortIn.create(userRestMapper.mapToDomain(userRequest)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        log.info("GET method get all users");
        return ResponseEntity.ok(userPortIn.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable UUID id) {
        log.info("DELETE method delete user with id: {}", id);
        userPortIn.deleteById(id);
        return ResponseEntity.ok("User has been deleted with id: " + id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable UUID id, @RequestBody UserRequest userRequest) {
        log.info("PUT method update user with id: {}", id);
        return ResponseEntity.ok(userPortIn.update(id, userRestMapper.mapToDomain(userRequest)));
    }
}
