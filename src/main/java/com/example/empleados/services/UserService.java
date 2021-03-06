package com.example.empleados.services;

import com.example.empleados.entities.Profile;
import com.example.empleados.entities.User;
import com.example.empleados.repositories.BaseRepository;
import com.example.empleados.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class UserService extends BaseServiceImpl<User, Long> {
    @Autowired
    private UserRepository userRepository;

   public UserService(BaseRepository<User, Long> baseRepository){
        super(baseRepository);
    }
    public List<User> search(String filtro) throws Exception{
        try {
            return userRepository.search(filtro);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Paged Search
    public Page<User> search(String filtro, Pageable pageable) throws Exception {
       try {
           Page<User> users = userRepository.search(filtro, pageable);
           return users;
       } catch(Exception e) {
           throw new Exception(e.getMessage());
       }
    }
}
