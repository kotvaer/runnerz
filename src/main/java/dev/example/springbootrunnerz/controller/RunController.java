package dev.example.springbootrunnerz.controller;

import dev.example.springbootrunnerz.pojo.Run;
import dev.example.springbootrunnerz.Service.RunService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/runs")
public class RunController {
    private final RunService runService;

    @Autowired
    public RunController(RunService runRepository) {
        this.runService = runRepository;
    }

    @GetMapping("")
    public List<Run> findAll() {
        return runService.findAll();
    }

    @GetMapping("/{id}")
    public Run findById(@PathVariable long id) {
        return runService.findById(id);
    }

    @GetMapping("location/{location}")
    public List<Run> findByLocation(@PathVariable String location) {
        return runService.findAllByLocation(location.toUpperCase());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@Validated @RequestBody Run run) {

        runService.save(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @Valid @RequestBody Run run) {
        runService.updateById(id, run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        runService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAll(@RequestParam List<Integer> ids) {
        ids.forEach(runService::deleteById);
    }

}
