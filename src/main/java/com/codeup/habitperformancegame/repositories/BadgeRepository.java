package com.codeup.habitperformancegame.repositories;

import com.codeup.habitperformancegame.models.Badge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BadgeRepository extends CrudRepository<Badge,Long> {
    @Query(value = "select * from badges where id NOT IN (select badge_id from user_badges where user_id =?1) AND type = 'ind'", nativeQuery = true)
    List<Badge> findNotAdded(long id);

    @Query(value = "select * from badges where id IN (select badge_id from user_badges where user_id =?1) AND type = 'ind'", nativeQuery = true)
    List<Badge> findAdded(long id);

    @Query(value = "select * from badges where id NOT IN (select badge_id from clan_badges where clan_id =?1) AND type = 'clan'", nativeQuery = true)
    List<Badge> clanNotAdded(long id);

    @Query(value = "select * from badges where id IN (select badge_id from clan_badges where clan_id =?1) AND type = 'clan'", nativeQuery = true)
    List<Badge> clanAdded(long id);
}
