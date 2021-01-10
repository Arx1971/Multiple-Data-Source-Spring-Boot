package org.java.multi.data.source.nasa.service;

import org.java.multi.data.source.nasa.model.Astronaut;

import java.util.List;

public interface AstronautService {

    List<Astronaut> findAll();

    Astronaut findById(Long id);

    Astronaut save(Astronaut object);

    void delete(Astronaut object);

    void deleteById(Long id);

}
