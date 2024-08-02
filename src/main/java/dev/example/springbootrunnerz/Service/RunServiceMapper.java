package dev.example.springbootrunnerz.Service;

import dev.example.springbootrunnerz.dao.RunRepositoryMapper;
import dev.example.springbootrunnerz.pojo.Location;
import dev.example.springbootrunnerz.pojo.Run;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RunServiceMapper implements RunService {
    private final RunRepositoryMapper runRepositoryMapper;
    public RunServiceMapper(RunRepositoryMapper runRepositoryMapper, RunRepositoryMapper runRepositoryMapper1) {
        this.runRepositoryMapper = runRepositoryMapper1;
    }

    @Override
    public List<Run> findAll() {
        return runRepositoryMapper.findAll();
    }

    @Override
    public Run findById(long id) {
        return runRepositoryMapper.findById(id);
    }

    @Override
    public List<Run> findAllByLocation(String upperCase) {
        return runRepositoryMapper.findAllByLocation(upperCase);
    }

    @Override
    public void save(Run run) {
        runRepositoryMapper.save(run);
    }

    @Override
    public void deleteById(long id) {
        runRepositoryMapper.deleteById(id);
    }

    @Override
    public void updateById(long id, Run run) {
        runRepositoryMapper.updateById(id,run.getTitle(),run.getStartOn(),run.getCompleteOn(),run.getMiles(),run.getLocation());
    }
}
