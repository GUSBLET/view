package com.source.viewer.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {

    private final UserService userService;

    @PostMapping("/add-new-user")
    public ResponseEntity<Boolean> registration(@RequestParam(name = "userTelegramId") Long newUserTelegramId){
        User newUser = User.builder()
                .telegramId(newUserTelegramId)
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.addNewUser(newUser));
    }

    @PostMapping("/find-user")
    public ResponseEntity<Boolean> findUser(@RequestParam(name = "userTelegramId") Long userTelegramId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findUserByTelegramId(userTelegramId));
    }

}
