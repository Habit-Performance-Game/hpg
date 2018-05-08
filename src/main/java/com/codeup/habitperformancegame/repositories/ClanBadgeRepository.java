package com.codeup.habitperformancegame.repositories;

import com.codeup.habitperformancegame.models.Clan_Badge;
import com.codeup.habitperformancegame.models.User_Badge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClanBadgeRepository extends CrudRepository<Clan_Badge, Long> {
    @Query(value = "select * from clan_badges where clan_id = ?1 AND has_completed = TRUE", nativeQuery = true)
    List<Clan_Badge> findCompleted(long id);
}
