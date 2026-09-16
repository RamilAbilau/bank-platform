package com.ramil.bank.customer.application.user.port.input.impl;

import com.ramil.bank.customer.application.user.port.input.UserPortIn;
import com.ramil.bank.customer.application.user.usecase.CreateUserUseCase;
import com.ramil.bank.customer.application.user.usecase.DeleteByIdUserUseCase;
import com.ramil.bank.customer.application.user.usecase.GetAllUsersUseCase;
import com.ramil.bank.customer.application.user.usecase.UpdateUserUseCase;
import com.ramil.bank.customer.domain.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserPortInImpl implements UserPortIn {

    private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final DeleteByIdUserUseCase deleteByIdUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    @Override
    public User create(User user) {
        return createUserUseCase.create(user);
    }

    @Override
    public List<User> getAll() {
        return getAllUsersUseCase.getAll();
    }

    @Override
    public void deleteById(UUID id) {
        deleteByIdUserUseCase.deleteById(id);
    }

    @Override
    public User update(User user) {
        return updateUserUseCase.update(user);
    }
}
