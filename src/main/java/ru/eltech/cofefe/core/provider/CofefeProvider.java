package main.java.ru.eltech.cofefe.core.provider;

import main.java.ru.eltech.cofefe.core.entity.Cofefe;

import java.util.List;

/**
 * Created by destely on 25.10.2014.
 */
public interface CofefeProvider {

    public List<Cofefe> getAll();

    public List<Cofefe> search(final String query);

    public Cofefe getById(final Long id);

}
