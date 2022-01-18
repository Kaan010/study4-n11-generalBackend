package com.example.fourthstudy.service;

import com.example.fourthstudy.dao.UserDao;
import com.example.fourthstudy.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserService {

    public final UserDao userDao;

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public User findUserById(Long id){
        return userDao.findById(id).orElseGet(null);
    }

    public User createUser(User user){
        return userDao.saveAndFlush(user);
    }

    public User updateUser(Long userId,User user){

        Optional<User> userOptional = userDao.findById(userId);
        userOptional.ifPresent(
                newUser->{
                    newUser.setName(user.getName());
                }
        );
        return userOptional.orElse(new User());
    }

    public void deleteUser(Long userId){
        userDao.deleteById(userId);
    }
}
