package com.alev.restaurantrating.repository.generic;

import com.alev.restaurantrating.model.BaseEntity;
import com.alev.restaurantrating.model.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Transactional(readOnly = true)
public interface GenericRepositoryImpl<T extends BaseEntity, ID extends Integer, PID extends Integer> extends JpaRepository<T, ID>, GenericRepository<T, ID, PID> {
    Sort SORT_NAME = new Sort("name");

    @Transactional
    @Override
    <S extends T> S save(S entity);

    @Transactional
    @Modifying
    @Override
    default boolean deleting(ID id, PID parentId) {
        return this.delete(id.intValue(), parentId.intValue()) != 0;
    }

    @Transactional
    @Modifying
    @Query("DELETE FROM #{#entityName} t WHERE t.id = ?1 AND t.parentId.id = ?2")
    int delete(int id, int parentId);

    @Override
    @Query("SELECT t FROM #{#entityName} t WHERE t.id=:id AND t.parentId.id= ?2")
    T get(ID id, PID restaurantId);

    @Override
    T findByName(String name);

    @Override
    List<T> findAll(Sort sort);

    @Override
    default List<T> getAll(PID parentId) {
        return this.findAll(GenericRepositoryImpl.SORT_NAME);
    }

    //
//    @Override
//    public Menu save(Menu menu, int restaurantId) {
//        if (!menu.isNew() && get(menu.getId(), restaurantId) == null) {
//            return null;
//        }
//        menu.setRestaurant(repository.get(restaurantId));
//        return proxy.save(menu);
//    }



//    @Override
//    default T get(ID id, PID parentId) {
//        return findOne(id);
//    }

//    @Override
//    public Menu getWithRestaurant(int id, int restaurantId) {
//        return proxy.getWithRestaurant(id, restaurantId);
//    }
//
////    @Override
////    public Menu getWithDishes(int id) {
////        return proxy.getWithDishes(id);
////    }
}
