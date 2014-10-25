package main.java.ru.eltech.cofefe.core.provider;

import main.java.ru.eltech.cofefe.core.entity.Cofefe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by destely on 25.10.2014.
 */
public class CofefeProviderStub implements CofefeProvider {

    private static final Object monitor = new Object();

    private List<Cofefe> list = new ArrayList<>(20);

    private static volatile CofefeProviderStub instance = null;

    public static CofefeProviderStub getInstance() {
        if (instance == null) {
            synchronized (monitor) {
                if (instance == null) {
                    instance = new CofefeProviderStub();
                }
            }
        }
        return instance;
    }

    private CofefeProviderStub() {
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            Cofefe cofefe = new Cofefe();
            cofefe.setId(i);
            cofefe.setTitle("Cofefe [" + random.nextInt() + "]");
            cofefe.setShortDescription("Это кофе");
            cofefe.setDescription("Это кофе, кофе кофе фе");
            cofefe.setImage("espr_robysta.jpg");
            list.add(cofefe);
        }
    }

    @Override
    public List<Cofefe> getAll() {
        return list;
    }

    @Override
    public List<Cofefe> search(String query) {
        List<Cofefe> result = new LinkedList<>();
        for (Cofefe cofefe : list) {
            if (cofefe.getTitle().contains(query.toLowerCase())) {
                result.add(cofefe);
            }
        }
        return result;
    }

    @Override
    public Cofefe getById(Long id) {
        for (Cofefe cofefe : list) {
            if (cofefe.getId() == id) {
                return cofefe;
            }
        }
        return null;
    }

}
