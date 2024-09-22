package com.footballLeague.footballLeague.Repository;

import com.footballLeague.footballLeague.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player,Long> {
    void deleteByName(String name);
    Optional<Player> findByName(String name);
}
