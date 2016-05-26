package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ProxyVoteRepository extends JpaRepository<Vote, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Vote v WHERE v.id=:id AND v.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Override
    Vote save(Vote item);

    @Query("SELECT v FROM Vote v WHERE v.id=:id AND v.user.id=:userId")
    Vote get(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId ORDER BY v.voteDate DESC")
    List<Vote> getAll(@Param("userId") int userId);

    @Query("SELECT v FROM Vote v JOIN FETCH v.user WHERE v.id =:id and v.user.id =:userId")
    Vote getWithUser(@Param("id")Integer id, @Param("userId")Integer userId);

    @Query("SELECT v FROM Vote v JOIN FETCH v.restaurant WHERE v.id =:id and v.user.id =:userId")
    Vote getWithRestaurant(@Param("id")Integer id, @Param("userId")Integer userId);

    @Query("SELECT v FROM Vote v JOIN FETCH v.menu WHERE v.id =:id and v.user.id =:userId")
    Vote getWithMenu(@Param("id")Integer id, @Param("userId")Integer userId);
}
