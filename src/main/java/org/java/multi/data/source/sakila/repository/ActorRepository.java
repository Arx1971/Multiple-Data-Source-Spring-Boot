package org.java.multi.data.source.sakila.repository;

import org.java.multi.data.source.sakila.model.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
}
