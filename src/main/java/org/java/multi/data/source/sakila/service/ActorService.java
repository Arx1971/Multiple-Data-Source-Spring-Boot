package org.java.multi.data.source.sakila.service;


import org.java.multi.data.source.sakila.model.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();

    Actor findById(Long id);

    Actor save(Actor object);

    void delete(Actor object);

    void deleteById(Long id);
}
