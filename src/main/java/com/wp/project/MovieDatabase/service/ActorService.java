package com.wp.project.MovieDatabase.service;

import com.wp.project.MovieDatabase.models.Actor;
import com.wp.project.MovieDatabase.models.exceptions.ActorNotFoundException;
import com.wp.project.MovieDatabase.models.exceptions.DuplicateActorException;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    List<Actor> getAllActors();

    Optional<Actor> getActorbyId(int id) throws ActorNotFoundException;

    Actor getActorbyName(String name) throws  ActorNotFoundException;

    Actor addNewActor(Actor actor) throws DuplicateActorException;

    Optional<Actor> deletebyID(int id) throws ActorNotFoundException;

    Actor deletebyName(String name) throws  ActorNotFoundException;
}
