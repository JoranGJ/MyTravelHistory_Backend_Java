package com.group2.MyTravelHistory.Service;


import com.group2.MyTravelHistory.DAO.UserDAO;
import com.group2.MyTravelHistory.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserDAO uDao;

    public void addUserToDao(User newUser){
        uDao.save(newUser);
    }

    public Optional<User> checkLogInCredentials(String userName, String password){
        return uDao.findByUserNameAndPassword(userName,password);
    }

    public Iterable<User>  fetchAllUsersFromDAO(){
        return uDao.findAll();
    }

    public Optional<User> findUserByName(String userName){
        return uDao.findByUserName(userName);
    }

    public Optional<User> findUserById(Long id){
        return uDao.findById(id);
    }

}
