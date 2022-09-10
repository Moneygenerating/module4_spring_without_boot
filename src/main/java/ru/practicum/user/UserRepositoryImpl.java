package ru.practicum.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository{
    //для теста FAKE USERS
    private static final List<User> FAKE_USERS = createManyFakeUsers(3);

    protected HashMap<Integer,User> users;
    protected int generatorId;

    @Override
    public List<User> findAll(){
        return FAKE_USERS;
    }

    @Override
    public User save(User user){
        generatorId++;
        users.put(generatorId,user);
        return users.get(generatorId);
    }

    //Наполнить юзеров
    private static List<User> createManyFakeUsers(int count) {
        List<User> fakeUsers = new ArrayList<>();
        for (long id =1; id<=count; id++){
            fakeUsers.add(createFakeUsers(id));
        }

        return Collections.unmodifiableList(fakeUsers);
    }

    private static User createFakeUsers(long id) {
        User fakeUser = new User();
        fakeUser.setId(id);
        fakeUser.setEmail("mail" + id + "@example.com");
        fakeUser.setName("Akaky Akaka #" + id);
        return fakeUser;
    }
}
