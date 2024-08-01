package com.goplanner.services;

import com.goplanner.User.User;
import com.goplanner.User.UserRepository;
import com.goplanner.specifications.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Page<User> index(String username, int page, int size, String sortBy) {
        Specification<User> spec = Specification.where(null);

        // Username filter
        if (username != null && !username.isEmpty()) {
            spec = spec.and(UserSpecification.hasUsername(username));
        }
        // date filter
        if (sortBy != null && !sortBy.isEmpty()) {
            switch (sortBy) {
                case "createdAt":
                    spec = spec.and(UserSpecification.sortByCreatedAt());
                    break;
                case "updatedAt":
                    spec = spec.and(UserSpecification.sortByUpdatedAt());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid sortBy parameter: " + sortBy);
            }
        }

        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(spec, pageable);
    }

    public User show(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
