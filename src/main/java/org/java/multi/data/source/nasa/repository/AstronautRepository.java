package org.java.multi.data.source.nasa.repository;

import org.java.multi.data.source.nasa.model.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AstronautRepository extends JpaRepository<Astronaut, Long> {
}
