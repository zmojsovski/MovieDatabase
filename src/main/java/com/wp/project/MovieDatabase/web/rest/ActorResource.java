package com.wp.project.MovieDatabase.web.rest;

import com.wp.project.MovieDatabase.models.Actor;
import com.wp.project.MovieDatabase.models.exceptions.ActorNotFoundException;
import com.wp.project.MovieDatabase.models.exceptions.DuplicateActorException;
import com.wp.project.MovieDatabase.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin({"*","localhost:3000"})
@RestController
@RequestMapping(value = "/actors", produces = MediaType.APPLICATION_JSON_VALUE)
public class ActorResource {

    private final ActorService actorService;

    @Autowired
    public ActorResource(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> getAllActors(){
        return actorService.getAllActors();
    }

    @GetMapping("/{id}")
    public Optional<Actor> getActorbyId(@PathVariable int id) throws ActorNotFoundException {
        return actorService.getActorbyId(id);
    }

    @GetMapping("/{name}")
    public Actor getActorbyName(@PathVariable String name) throws ActorNotFoundException {
        return actorService.getActorbyName(name);
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewActor(@Valid @RequestBody Actor actor, HttpServletResponse response) throws DuplicateActorException {
      Actor actor1 = actorService.addNewActor(actor);
        response.setHeader("Location", "/movies/"+ actor1.getActorid());
    }

    @DeleteMapping("/{id}")
    public Optional<Actor> deletebyId(@PathVariable int id) throws ActorNotFoundException {
        Optional<Actor> actor = actorService.getActorbyId(id);
        actorService.deletebyID(id);
        return actor;
    }

    @DeleteMapping("/{name}")
    public Actor deletebyName(@PathVariable String name) throws ActorNotFoundException {
        Actor actor = actorService.getActorbyName(name);
        actorService.deletebyName(name);
        return actor;
    }
}
