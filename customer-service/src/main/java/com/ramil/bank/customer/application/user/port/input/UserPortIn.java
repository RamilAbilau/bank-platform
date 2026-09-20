package com.ramil.bank.customer.application.user.port.input;

import com.ramil.bank.customer.domain.user.User;

import java.util.List;
import java.util.UUID;

public interface UserPortIn {

    User create(User user);

    List<User> getAll();

    void deleteById(UUID id);

    User update(User user);
}
