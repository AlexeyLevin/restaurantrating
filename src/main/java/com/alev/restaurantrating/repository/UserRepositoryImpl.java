package com.alev.restaurantrating.repository;

import com.alev.restaurantrating.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
interface UserRepositoryImpl extends JpaRepository<User, Integer>, UserRepository {
    Sort SORT_NAME_EMAIL = new Sort("name", "email");

    @Transactional
    @Modifying
    @Override
    default boolean delete(int id) {
        return deleting(id) != 0;
    }

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int deleting(@Param("id") int id);

    @Override
    default User get(int id) {
        return findOne(id);
    }

    @Override
    default List<User> getAll() {
        return findAll(SORT_NAME_EMAIL);
    }

    @Override
    @Transactional
    User save(User user);

    @Override
    User findOne(Integer id);

    @Override
    List<User> findAll(Sort sort);

    User getByEmail(String email);

//    @Query("SELECT u FROM User u LEFT JOIN FETCH u.votes WHERE u.id = ?1")
//    User getWithVotes(Integer id);
}