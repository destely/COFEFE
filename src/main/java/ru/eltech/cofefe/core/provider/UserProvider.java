package main.java.ru.eltech.cofefe.core.provider;

import main.java.ru.eltech.cofefe.core.entity.User;

/**
 * Created by destely on 03.11.2014.
 */
public interface UserProvider {

    public User getById(final Long id);

    public User getByLogin(final String login);

}
