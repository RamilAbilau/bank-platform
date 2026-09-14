package com.ramil.bank.customer.application.user.usecase;

import com.ramil.bank.customer.application.user.port.output.UserPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class DeleteByIdUserUseCase {

    private final UserPortOut userPortOut;

    public void deleteById(UUID id) {
        userPortOut.deleteById(id);
    }
}
