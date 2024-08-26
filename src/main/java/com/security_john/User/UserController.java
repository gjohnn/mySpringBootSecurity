package com.security_john.User;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/v1/public/users")
@RequiredArgsConstructor
public class UserController {

    private final  UserService userService;

    @GetMapping("")
    public ResponseEntity<Page<User>> getUsers(Pageable pageable) {
        Page<User> users = userService.index(pageable);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        User user = userService.show(id);
        if (user != null) {
            return ResponseEntity.ok().body(Map.of("data", user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
