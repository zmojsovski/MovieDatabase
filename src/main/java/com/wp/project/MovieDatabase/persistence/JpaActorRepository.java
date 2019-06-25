package com.wp.project.MovieDatabase.persistence;

import com.wp.project.MovieDatabase.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaActorRepository extends JpaRepository<Actor,Integer> {
    Actor findByName(String name);

    void deleteByName(String name);
}
