package com.codeup.habitperformancegame.repositories;

import com.codeup.habitperformancegame.models.User_Badge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserBadgeRepository extends CrudRepository<User_Badge, Long>{
    @Query(value = "select * from user_badges where user_id = ?1 AND has_completed = TRUE", nativeQuery = true)
    List<User_Badge> findCompleted(long id);

    @Query(value = "select * from user_badges where user_id = ?1 AND has_completed = FALSE", nativeQuery = true)
    List<User_Badge> findNotCompleted(long id);
}
