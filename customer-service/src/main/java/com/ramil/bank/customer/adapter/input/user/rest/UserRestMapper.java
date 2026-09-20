package com.ramil.bank.customer.adapter.input.user.rest;

import com.ramil.bank.customer.domain.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRestMapper {

    User toDomain(UserRequest userRequest);

    UserResponse toResponse(User user);
}
