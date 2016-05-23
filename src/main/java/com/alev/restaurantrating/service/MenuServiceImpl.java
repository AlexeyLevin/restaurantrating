package com.alev.restaurantrating.service;

import com.alev.restaurantrating.model.LunchMenu;
import com.alev.restaurantrating.repository.MenuRepository;
import com.alev.restaurantrating.util.exceptions.ExceptionUtil;
import com.alev.restaurantrating.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public LunchMenu save(LunchMenu lunchMenu) {
        return repository.save(lunchMenu);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id), id);
    }

    @Override
    public LunchMenu get(int id) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @Override
    public LunchMenu getByName(String name) throws NotFoundException {
        Objects.requireNonNull(name, "Name must not be empty");
        return ExceptionUtil.check(repository.findByName(name), "name=" + name);
    }

    @Override
    public void update(LunchMenu lunchMenu) {
        repository.save(lunchMenu);
    }

    @Override
    public List<LunchMenu> getAll() {
        return repository.getAll();
    }
}
