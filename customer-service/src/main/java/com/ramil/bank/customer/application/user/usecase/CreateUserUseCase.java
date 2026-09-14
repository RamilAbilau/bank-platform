package com.ramil.bank.customer.application.user.usecase;

import com.ramil.bank.customer.application.user.port.output.UserPortOut;
import com.ramil.bank.customer.domain.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateUserUseCase {

    private final UserPortOut userPortOut;

    public User create(User user) {
        return userPortOut.save(user);
    }
}
