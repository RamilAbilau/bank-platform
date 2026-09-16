package com.ramil.bank.customer.adapter.out;

import com.ramil.bank.customer.application.user.port.output.UserPortOut;
import com.ramil.bank.customer.domain.user.User;
import jakarta.persistence.EntityNotFoundException;
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
        var userEntity = userEntityMapper.toEntity(user);
        var savedUserEntity = userRepository.save(userEntity);
        return userEntityMapper.toDomain(savedUserEntity);
    }

    @Override
    public List<User> getAll() {
        var users = userRepository.findAll();
        return users.stream().map(userEntityMapper::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        var existingUser = userRepository.findById(user.getId());

        if (existingUser.isEmpty()) {
            throw new EntityNotFoundException("User does not exist");
        }

        var updatedUserEntity = userEntityMapper.update(user, existingUser.get());
        var savedUserEntity = userRepository.save(updatedUserEntity);
        return userEntityMapper.toDomain(savedUserEntity);
    }
}
