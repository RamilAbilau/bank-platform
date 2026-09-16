package com.ramil.bank.customer.application.user.usecase;

import com.ramil.bank.customer.application.user.port.output.UserPortOut;
import com.ramil.bank.customer.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CreateUserUseCase {

    private final UserPortOut userPortOut;

    public User create(User user) {
        log.debug("Creating user");

        var createdUser = userPortOut.save(user);

        log.info("User created with id: {}", createdUser.getId());

        return createdUser;
    }
}
