package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.LunchMenu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ProxyMenuRepository extends JpaRepository<LunchMenu, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM LunchMenu m WHERE m.id=:id")
    int delete(int id);

    @Override
    @Transactional
    LunchMenu save(LunchMenu lunchMenu);

    @Override
    LunchMenu findOne(Integer id);

    LunchMenu findByName(String name);

    @Override
    List<LunchMenu> findAll(Sort sortName);

//    @Query("SELECT m FROM Menus m LEFT JOIN FETCH m.dishes WHERE m.id = ?1")
//    Menu getWithDishes(Integer id);
}
