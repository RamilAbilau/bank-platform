package com.ramil.bank.customer.application.user.usecase;

import com.ramil.bank.customer.application.user.port.output.UserPortOut;
import com.ramil.bank.customer.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class UpdateUserUseCase {

    private final UserPortOut userPortOut;

    public User update(User user) {
        log.debug("Updating user");

        var updatedUser = userPortOut.update(user);

        log.info("User updated with id: {}", user.getId());

        return updatedUser;
    }
}
