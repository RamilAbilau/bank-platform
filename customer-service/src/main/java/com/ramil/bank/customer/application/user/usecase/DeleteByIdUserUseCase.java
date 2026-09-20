package com.ramil.bank.customer.application.user.usecase;

import com.ramil.bank.customer.application.user.port.output.UserPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class DeleteByIdUserUseCase {

    private final UserPortOut userPortOut;

    public void deleteById(UUID id) {
        log.debug("Deleting user");

        userPortOut.deleteById(id);

        log.info("User deleted with id: {}", id);
    }
}
