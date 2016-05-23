package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.LunchMenu;
import com.alev.restaurantrating.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaMenuRepositoryImpl implements MenuRepository {
    private static final Sort SORT_NAME = new Sort("name");

    @Autowired
    private ProxyMenuRepository proxy;

    @Override
    public LunchMenu save(LunchMenu lunchMenu) {
        return proxy.save(lunchMenu);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public LunchMenu get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public LunchMenu findByName(String name) {
        return proxy.findByName(name);
    }

    @Override
    public List<LunchMenu> getAll() {
        return proxy.findAll(SORT_NAME);
    }
}
