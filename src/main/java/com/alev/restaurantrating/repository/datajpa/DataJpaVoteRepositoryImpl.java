package com.alev.restaurantrating.repository.datajpa;

import com.alev.restaurantrating.model.User;
import com.alev.restaurantrating.model.Vote;
import com.alev.restaurantrating.repository.VoteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
@Transactional(readOnly = true)
interface DataJpaVoteRepositoryImpl extends VoteRepository, JpaRepository<Vote, Integer> {

    @Query("SELECT u FROM User u WHERE u.id=:id")
    User getUser(@Param("id") int id);

    @Override
    @Transactional
    default Vote save(Vote vote, int userId) {
        if (!vote.isNew() && get(vote.getId(), userId) == null) {
            return null;
        }
        vote.setUser(getUser(userId));
        return save(vote);
    }

    @Override
    @Modifying
    @Transactional
    default boolean delete(int id, int userId) {
        return deleting(id, userId) != 0;
    }

    @Modifying
    @Transactional
    @Query("DELETE FROM Vote v WHERE v.id=:id AND v.user.id=:userId")
    int deleting(@Param("id") int id, @Param("userId") int userId);

    @Override
    Vote save(Vote item);

    @Query("SELECT v FROM Vote v WHERE v.id=:id AND v.user.id=:userId")
    Vote get(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId ORDER BY v.voteDate DESC")
    List<Vote> getAll(@Param("userId") int userId);

    @Query("SELECT v FROM Vote v JOIN FETCH v.user JOIN FETCH v.restaurant JOIN FETCH v.menu WHERE v.id =:id and v.user.id =:userId")
    Vote getWithFields(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT v FROM Vote v JOIN FETCH v.restaurant JOIN FETCH v.menu WHERE v.id =:id and v.user.id =:userId")
    Vote getWithoutUser(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT v FROM Vote v JOIN FETCH v.restaurant JOIN FETCH v.menu ORDER BY v.voteDate DESC")
    Collection<Vote> getAllVotesForAllUsers();

    @Query("SELECT v FROM Vote v JOIN FETCH v.restaurant WHERE v.id =:id and v.user.id =:userId")
    Vote getWithRestaurant(@Param("id")Integer id, @Param("userId")Integer userId);

    @Query("SELECT v FROM Vote v JOIN FETCH v.menu WHERE v.id =:id and v.user.id =:userId")
    Vote getWithMenu(@Param("id")Integer id, @Param("userId")Integer userId);

}