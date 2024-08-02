package dev.example.springbootrunnerz.Service;

import dev.example.springbootrunnerz.dao.RunRepositoryJpa;
import dev.example.springbootrunnerz.pojo.Location;
import dev.example.springbootrunnerz.pojo.Run;
import dev.example.springbootrunnerz.exception.RunNotFoundException;
import dev.example.springbootrunnerz.aop.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunServiceJpa implements RunService {
    private final RunRepositoryJpa runRepositoryJpa;

    @Autowired
    public RunServiceJpa(RunRepositoryJpa runRepositoryJpa) {
        this.runRepositoryJpa = runRepositoryJpa;
    }

    @Time
    public List<Run> findAll(){
       return runRepositoryJpa.findAll();
    }

    @Time
    public List<Run> findAllByLocation(String location) {
       return runRepositoryJpa.findAllByLocation(Location.valueOf(location));
    }

    public Run findById(long id) {
        return runRepositoryJpa.findById(id)
                .orElseThrow(RunNotFoundException::new);
    }

    public void save(Run run) {
        runRepositoryJpa.save(run);
    }

    public void updateById(long id, Run run) {
        Run runDb = runRepositoryJpa.findById(id).orElseThrow(RunNotFoundException::new);
        runDb.setLocation(run.getLocation());
        runDb.setTitle(run.getTitle());
        runDb.setMiles(run.getMiles());
        runDb.setStartOn(run.getStartOn());
        runDb.setCompleteOn(run.getCompleteOn());

        runRepositoryJpa.save(runDb);
    }

    public void deleteById(long id) {
        if(runRepositoryJpa.existsById(id)) {
            runRepositoryJpa.deleteById(id);
        }else throw new RunNotFoundException();
    }
}
