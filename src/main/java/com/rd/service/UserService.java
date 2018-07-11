package com.rd.service;

import com.rd.entity.User;
import com.rd.enums.UserEnum;
import com.rd.exception.UserException;
import com.rd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> finAll(){
        return userRepository.findAll();
    }

    public  User findById(Integer id){
        return  userRepository.findOne(id);
    }

    public  User saveUser(User u) {
//        if ("".equals(u.getName())){
//            return new Exception("姓名不能为空");
//        }else if ("123".equals(u.getName())){
//            return new Exception("姓名不能为123");
//        }
       return  userRepository.save(u);
    }

    public  void deleteUserById(Integer id){
        userRepository.delete(id);
    }

    public void check(Integer id) throws  Exception{
        User u=userRepository.findOne(id);
        if("".equals(u.getName())){
            throw  new UserException(UserEnum.ERROS_ENUM);
        }else if("123".equals(u.getName())){
            throw  new UserException(UserEnum.ERROS_ENUM);
        }

    }

    public User findOne(Integer id){
        User one = userRepository.findOne(id);
        return one;
    }
}
