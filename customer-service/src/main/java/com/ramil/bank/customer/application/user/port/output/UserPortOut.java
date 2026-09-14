package com.ramil.bank.customer.application.user.port.output;

import com.ramil.bank.customer.domain.user.User;

import java.util.List;
import java.util.UUID;

public interface UserPortOut {

    User save(User user);

    List<User> getAll();

    void deleteById(UUID id);

    User update(UUID id, User user);
}
