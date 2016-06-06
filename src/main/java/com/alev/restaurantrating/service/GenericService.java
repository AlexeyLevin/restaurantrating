package com.alev.restaurantrating.service;

import com.alev.restaurantrating.util.exceptions.NotFoundException;

import java.util.Collection;

interface GenericService<T, id, parentId> {

    <T> T get(id id, parentId parentId) throws NotFoundException;

    void delete(id id, parentId parentId) throws NotFoundException;

    <T> Collection<T> getAll(parentId parentId);

    <T> T save(T entity, parentId parentId);

    <T> T findByName(String name) throws NotFoundException;
}



//public interface UserService extends GenericService<User, Long>  {
//    User findOneByUsername(String username);
//}

//http://stackoverflow.com/questions/12099213/hibernate-generic-dao-generic-service-and-generic-view-layer

//http://stackoverflow.com/questions/24857003/crud-methods-in-service-layer-using-spring-data-jpa

//public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {
//
//    @Autowired
//    private CrudRepository<T, ID> repository;
//
//    @Override
//    public <S extends T> S save(S entity) {
//        return repository.save(entity);
//    }
//}