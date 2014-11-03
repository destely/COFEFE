package main.java.ru.eltech.cofefe.core.provider;

import main.java.ru.eltech.cofefe.core.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by destely on 03.11.2014.
 */
public class UserProviderStub implements UserProvider {

    private Map<Long, User> userById = new HashMap<>();
    private Map<String, User> userByLogin = new HashMap<>();

    private static final UserProviderStub instance = new UserProviderStub();

    private UserProviderStub() {
        User user = new User();
        user.setLogin("user");
        user.setId(0l); //здесь буква L
        user.setPassword("qwerty");
        userById.put(user.getId(), user);
        userByLogin.put(user.getLogin(), user);
    }

    public static UserProviderStub getInstance() {
        return instance;
    }

    @Override
    public User getById(final Long id) {
        return userById.get(id);
    }

    @Override
    public User getByLogin(final String login) {
        return userByLogin.get(login);
    }

}
