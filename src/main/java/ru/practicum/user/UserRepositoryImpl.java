package ru.practicum.user;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository{
    protected List<User> users;

    @Override
    public List<User> findAll(){
        return users;
    }

    @Override
    public User save(User user){
        users.add(user);
        return user;
    }
}
