package dev.example.springbootrunnerz.Service;

import dev.example.springbootrunnerz.dao.RunRepository;
import dev.example.springbootrunnerz.pojo.Location;
import dev.example.springbootrunnerz.pojo.Run;
import dev.example.springbootrunnerz.exception.RunNotFoundException;
import dev.example.springbootrunnerz.aop.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunService {
    private final RunRepository runRepository;

    @Autowired
    public RunService(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @Time
    public List<Run> findAll(){
       return runRepository.findAll();
    }

    @Time
    public List<Run> findAllByLocation(String location) {
       return runRepository.findAllByLocation(Location.valueOf(location));
    }

    public Run findById(long id) {
        return runRepository.findById(id)
                .orElseThrow(RunNotFoundException::new);
    }

    public void save(Run run) {
        runRepository.save(run);
    }

    public void updateById(long id, Run run) {
        Run runDb = runRepository.findById(id).orElseThrow(RunNotFoundException::new);
        runDb.setLocation(run.getLocation());
        runDb.setTitle(run.getTitle());
        runDb.setMiles(run.getMiles());
        runDb.setStartOn(run.getStartOn());
        runDb.setCompleteOn(run.getCompleteOn());

        runRepository.save(runDb);
    }

    public void deleteById(long id) {
        if(runRepository.existsById(id)) {
            runRepository.deleteById(id);
        }else throw new RunNotFoundException();
    }
}
