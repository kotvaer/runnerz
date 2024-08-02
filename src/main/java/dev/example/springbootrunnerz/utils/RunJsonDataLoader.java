package dev.example.springbootrunnerz.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.example.springbootrunnerz.dao.RunRepositoryJpa;
import dev.example.springbootrunnerz.pojo.Runs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aot.hint.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class RunJsonDataLoader implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(RunJsonDataLoader.class);

    private RunRepositoryJpa runRepositoryJpa;
    private ObjectMapper objectMapper;

    public RunJsonDataLoader(RunRepositoryJpa runRepositoryJpa, ObjectMapper objectMapper) {
        this.runRepositoryJpa = runRepositoryJpa;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (runRepositoryJpa.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getClassLoader().getResourceAsStream("data/runs.json")) {
                Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
                log.info("Reading {} runs from JSON data and saving to in-memory collection.", allRuns.runs().size());
                runRepositoryJpa.saveAll(allRuns.runs());
            }catch (IOException e) {
               throw new RuntimeException("Failed to read JSON data",e);
            }
        }else {
            log.info("Not loading Runs from data because the collection contains data.");
        }
    }
}
