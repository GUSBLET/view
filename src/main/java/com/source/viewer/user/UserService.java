package com.source.viewer.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public boolean addNewUser(User user){
        if(userRepository.findByTelegramId(user.getTelegramId()).isPresent())
            return false;

        userRepository.save(user);
        return true;
    }

    public boolean findUserByTelegramId(Long userTelegramId){
        return userRepository.findByTelegramId(userTelegramId).isPresent();
    }

    public User getUserByTelegramId(Long userTelegramId){
        return userRepository.findByTelegramId(userTelegramId).get();
    }
}
