package dev.example.springbootrunnerz.Service;

import dev.example.springbootrunnerz.pojo.Run;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RunService {
    List<Run> findAll();

    Run findById(long id);

    List<Run> findAllByLocation(String upperCase);

    void save(Run run);

    void deleteById(long id);

    void updateById(long id, Run run);
}
