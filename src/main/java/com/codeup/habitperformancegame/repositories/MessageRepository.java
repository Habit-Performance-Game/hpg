package com.codeup.habitperformancegame.repositories;

import com.codeup.habitperformancegame.models.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository <Message, Long> {
}
