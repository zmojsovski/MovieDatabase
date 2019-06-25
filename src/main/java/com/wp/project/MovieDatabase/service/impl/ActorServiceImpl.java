package com.wp.project.MovieDatabase.service.impl;

import com.wp.project.MovieDatabase.models.Actor;
import com.wp.project.MovieDatabase.models.exceptions.ActorNotFoundException;
import com.wp.project.MovieDatabase.models.exceptions.DuplicateActorException;
import com.wp.project.MovieDatabase.persistence.JpaActorRepository;
import com.wp.project.MovieDatabase.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    private final JpaActorRepository jpaActorRepository;

    public ActorServiceImpl(JpaActorRepository jpaActorRepository) {
       this.jpaActorRepository = jpaActorRepository;
    }

    @Override
    public List<Actor> getAllActors() {
        return jpaActorRepository.findAll();
    }

    @Override
    public Optional<Actor> getActorbyId(int id) throws ActorNotFoundException {
        return jpaActorRepository.findById(id);
    }

    @Override
    public Actor getActorbyName(String name) throws ActorNotFoundException {
        return jpaActorRepository.findByName(name);
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public Actor addNewActor(Actor actor) throws DuplicateActorException {
        jpaActorRepository.save(actor);
        return actor;
    }

    @Override
    public Optional<Actor> deletebyID(int id) throws ActorNotFoundException {
        Optional<Actor> actor = jpaActorRepository.findById(id);
        jpaActorRepository.deleteById(id);
        return actor;
    }

    @Override
    public Actor deletebyName(String name) throws ActorNotFoundException {
        Actor actor = jpaActorRepository.findByName(name);
        jpaActorRepository.deleteByName(name);
        return actor;
    }
}
