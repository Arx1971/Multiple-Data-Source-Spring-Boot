package org.java.multi.data.source.nasa.service;

import org.java.multi.data.source.nasa.model.Astronaut;
import org.java.multi.data.source.nasa.repository.AstronautRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AstronautServiceImpl implements AstronautService {

    private AstronautRepository astronautRepository;

    @Autowired
    public AstronautServiceImpl(AstronautRepository astronautRepository) {
        this.astronautRepository = astronautRepository;
    }

    @Override
    public List<Astronaut> findAll() {
        return (List<Astronaut>) astronautRepository.findAll();
    }

    @Override
    public Astronaut findById(Long id) {

        List<Astronaut> astronauts = (List<Astronaut>) astronautRepository.findAll();

        for (Astronaut astronaut : astronauts) {
            if (astronaut.getId().equals(id)) {
                return astronaut;
            }
        }
        throw new RuntimeException("Actor Does Not Exist");
    }

    @Override
    public Astronaut save(Astronaut object) {
        return null;
    }

    @Override
    public void delete(Astronaut object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

}
