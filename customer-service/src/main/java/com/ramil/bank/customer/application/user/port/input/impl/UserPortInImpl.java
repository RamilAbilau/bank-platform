package com.ramil.bank.customer.application.user.port.input.impl;

import com.ramil.bank.customer.adapter.input.user.rest.UserResponse;
import com.ramil.bank.customer.adapter.input.user.rest.UserRestMapper;
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
    private final UserRestMapper userRestMapper;

    @Override
    public UserResponse create(User user) {
        var response = createUserUseCase.create(user);
        return userRestMapper.mapToUserResponse(response);
    }

    @Override
    public List<UserResponse> getAll() {
        return getAllUsersUseCase.getAll().stream().map(userRestMapper::mapToUserResponse).toList();
    }

    @Override
    public void deleteById(UUID id) {
        deleteByIdUserUseCase.deleteById(id);
    }

    @Override
    public UserResponse update(UUID id, User user) {
        var response = updateUserUseCase.update(id, user);
        return userRestMapper.mapToUserResponse(response);
    }
}
