package com.security_john.User;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Page<User> index(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User show(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
