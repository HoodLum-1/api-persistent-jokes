package za.co.sithole.fun.application.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.sithole.fun.application.persistence.entity.JokeEntity;

import java.util.Optional;

@Repository
public interface JokeRepository extends JpaRepository<JokeEntity, Integer> {
    Optional<JokeEntity> findByJokeId(String jokeId);
}
