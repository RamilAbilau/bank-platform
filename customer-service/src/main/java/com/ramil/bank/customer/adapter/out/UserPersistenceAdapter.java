package com.ramil.bank.customer.adapter.out;

import com.ramil.bank.customer.application.user.port.output.UserPortOut;
import com.ramil.bank.customer.domain.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserPersistenceAdapter implements UserPortOut {

    private final UserRepository userRepository;

    private final UserEntityMapper userEntityMapper;

    @Override
    public User save(User user) {
        var userEntity = userEntityMapper.mapToEntity(user);
        var savedUserEntity = userRepository.save(userEntity);
        return userEntityMapper.mapToDomain(savedUserEntity);
    }

    @Override
    public List<User> getAll() {
        var users = userRepository.findAll();
        return users.stream().map(userEntityMapper::mapToDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(UUID id, User user) {
        if (userRepository.findById(id).isEmpty()) {
            throw new RuntimeException("User does not exist");
        }
        var userEntity = userRepository.findById(id);
        var updatedUserEntity = userEntityMapper.update(user, userEntity.get());
        var savedUserEntity = userRepository.save(updatedUserEntity);
        return userEntityMapper.mapToDomain(savedUserEntity);
    }
}
