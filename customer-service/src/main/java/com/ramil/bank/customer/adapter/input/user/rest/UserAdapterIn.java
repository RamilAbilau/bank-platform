package com.ramil.bank.customer.adapter.input.user.rest;

import com.ramil.bank.customer.application.user.port.input.UserPortIn;
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

    private final UserPortIn portIn;
    private final UserRestMapper mapper;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {
        var user = mapper.toDomain(userRequest);
        var createdUser = portIn.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(createdUser));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.ok(portIn.getAll().stream().map(mapper::toResponse).toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable UUID id) {
        portIn.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest userRequest) {
        var user = mapper.toDomain(userRequest);
        var updatedUser = portIn.update(user);
        return ResponseEntity.ok(mapper.toResponse(updatedUser));
    }
}
