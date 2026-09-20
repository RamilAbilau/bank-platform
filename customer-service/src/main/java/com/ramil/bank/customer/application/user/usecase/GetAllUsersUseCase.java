package com.ramil.bank.customer.application.user.usecase;

import com.ramil.bank.customer.application.user.port.output.UserPortOut;
import com.ramil.bank.customer.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class GetAllUsersUseCase {

    private final UserPortOut userPortOut;

    public List<User> getAll() {
        log.debug("Getting all users");

        var users = userPortOut.getAll();

        log.info("Got all users");

        return users;
    }
}
