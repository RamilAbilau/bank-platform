package com.ramil.bank.customer.adapter.out;

import com.ramil.bank.customer.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntity mapToEntity(User user);

    User mapToDomain(UserEntity userEntity);

    @Mapping(target = "id", ignore = true)
    UserEntity update(User user,@MappingTarget UserEntity userEntity);
}
