package com.example.sqldemo.services;

import com.example.sqldemo.models.Users;
import com.example.sqldemo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Iterable<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public Optional<Users> getById(Long id){
        return usersRepository.findById(id);
    }

    public Users create(Users u){
        return usersRepository.save(u);
    }


    public Users update(Users u, Long id){
        Optional<Users> userTemp = usersRepository.findById(id);

        if(userTemp.isPresent()){
            Users userFinal = userTemp.get();

            if(u.getName() != null){
                userFinal.setName(u.getName());
            }

            if(u.getEmail() != null){
                userFinal.setEmail(u.getEmail());
            }

            if(u.getPassword() != null){
                userFinal.setPassword(u.getPassword());
            }

            return usersRepository.save(userFinal);
        }
        return u.builder().build();
    }


    public void delete(Long id){
        if(usersRepository.existsById(id)){
            var user = usersRepository.findById(id);
            usersRepository.delete(user.get());
        }
    }

}
