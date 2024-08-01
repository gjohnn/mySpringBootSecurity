package com.security_john.controllers;

import com.security_john.User.User;
import com.security_john.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/public/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<Page<User>> getUsers(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "sortBy", defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<User> users = userService.index(username, page, size, sortBy);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(Map.of("data", userService.show(id)));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
    /*

    @PostMapping("/")
    public  ResponseEntity<?> store(@RequestBody TaskDto task) {
        return ResponseEntity.ok("Create a new task");
    }
    @PutMapping("/{id}")
    public  ResponseEntity<?> update(@PathVariable Long id, @RequestBody TaskDto task) {
        return ResponseEntity.ok("Update a task");
    }
    *
     */

