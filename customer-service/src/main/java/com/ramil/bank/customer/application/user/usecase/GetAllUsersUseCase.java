package com.ramil.bank.customer.application.user.usecase;

import com.ramil.bank.customer.application.user.port.output.UserPortOut;
import com.ramil.bank.customer.domain.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllUsersUseCase {

    private final UserPortOut userPortOut;

    public List<User> getAll() {
        return userPortOut.getAll();
    }
}
