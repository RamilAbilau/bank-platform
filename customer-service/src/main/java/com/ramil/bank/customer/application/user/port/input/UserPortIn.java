package com.ramil.bank.customer.application.user.port.input;

import com.ramil.bank.customer.adapter.input.user.rest.UserResponse;
import com.ramil.bank.customer.domain.user.User;

import java.util.List;
import java.util.UUID;

public interface UserPortIn {

    UserResponse create(User user);

    List<UserResponse> getAll();

    void deleteById(UUID id);

    UserResponse update(UUID id, User user);
}
