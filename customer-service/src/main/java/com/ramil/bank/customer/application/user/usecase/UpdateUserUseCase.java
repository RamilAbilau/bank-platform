package com.ramil.bank.customer.application.user.usecase;

import com.ramil.bank.customer.application.user.port.output.UserPortOut;
import com.ramil.bank.customer.domain.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class UpdateUserUseCase {

    private final UserPortOut userPortOut;

    public User update(UUID id, User user) {
        return userPortOut.update(id, user);
    }
}
